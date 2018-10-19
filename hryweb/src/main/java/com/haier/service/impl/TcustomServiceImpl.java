package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.*;
import com.haier.mapper.TcustomMapper;
import com.haier.po.*;
import com.haier.service.*;
import com.haier.testng.run.Runner;
import com.haier.util.HryUtil;
import com.haier.util.ReflectUtil;
import com.haier.vo.CustomVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:36
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class TcustomServiceImpl implements TcustomService {

    @Value("${zdy.reportPath}")
    String reportPath;

    @Value("${zdy.resourcePathPattern}")
    String resourcePathPattern;

    @Autowired
    TcustomMapper tcustomMapper;

    @Autowired
    TserviceService tserviceService;

    @Autowired
    TreportService treportService;

    @Autowired
    TservicedetailService tservicedetailService;

    @Autowired
    TcustomdetailService tcustomdetailService;

    @Autowired
    Runner runner;

    @Override
    public Integer insertOne(Tcustom tcustom, List<Tcustomdetail> tcustomdetails) {
        tcustomMapper.insertSelective(tcustom);
        Integer customId = tcustom.getId();//获取插入的自增Id
        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            tcustomdetail.setCustomid(customId);
        }
        tcustomdetailService.insertBatch(tcustomdetails);
        return customId;
    }

    @Override
    public Integer insertOne(CustomVO customVO) {
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        return this.insertOne(customVO, list);
    }

    @Override
    public Integer updateOne(Tcustom tcustom) {
        return tcustomMapper.updateByPrimaryKeySelective(tcustom);
    }

    @Override
    public Integer updateOne(CustomVO customVO) {
        Tcustom tcustom = new Tcustom();
        ReflectUtil.cloneChildToParent(tcustom, customVO);
        /**
         *  更新tcustom信息
         */
        this.updateOne(tcustom);
        /**
         * 更新tcustomdetail信息
         */
        //先删除历史保存的tcustomdetail记录
        Tcustomdetail condition = new Tcustomdetail();
        condition.setCustomid(customVO.getId());
        tcustomdetailService.physicalDeleteByCondition(condition);

        //插入本次编辑的tcustomdetail记录
        List<Tcustomdetail> tcustomdetails = customVO.getTcustomdetails();
        tcustomdetailService.insertBatch(tcustomdetails);
        return customVO.getId();
    }

    @Override
    public Integer deleteOne(Integer id) {
        /**
         * 删除tcustom
         */
        Tcustom tcustom = new Tcustom();
        tcustom.setId(id);
        tcustom.setStatus(-1);
        this.updateOne(tcustom);
        /**
         * 删除tcustomdetail
         */
        Tcustomdetail tcustomdetail = new Tcustomdetail();
        tcustomdetail.setCustomid(id);
        //物理删除tcustomdetail表的记录
        tcustomdetailService.physicalDeleteByCondition(tcustomdetail);
        return id;
    }


    @Override
    public CustomVO selectOne(Integer id) {
        CustomVO vo = new CustomVO();
        Tcustom tcustom = tcustomMapper.selectByPrimaryKey(id);
        ReflectUtil.cloneParentToChild(tcustom, vo);

        List<Tcustomdetail> tcustomdetails = tcustomdetailService.selectByCondition(id);
        vo.setTcustomdetails(tcustomdetails);

        return vo;
    }

    @Override
    public List<Tcustom> selectTcustomList(Tcustom tcustom) {
        TcustomExample tcustomExample = new TcustomExample();
        TcustomExample.Criteria criteria = tcustomExample.createCriteria();
        tcustomExample.setOrderByClause(SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        criteria.andStatusGreaterThan(0);
        if (tcustom != null) {
            if (tcustom.getId() != null) {
                criteria.andIdEqualTo(tcustom.getId());
            }
            if (tcustom.getUserid() != null) {
                criteria.andUseridEqualTo(tcustom.getUserid());
            }
            if (StringUtils.isNotBlank(tcustom.getUsername())) {
                criteria.andUsernameEqualTo(tcustom.getUsername());
            }
            if (tcustom.getEnvid() != null) {
                criteria.andEnvidEqualTo(tcustom.getEnvid());
            }
            if (StringUtils.isNotBlank(tcustom.getCustomname())) {
                criteria.andCustomnameLike("%" + tcustom.getCustomname() + "%");
            }
        }
        return tcustomMapper.selectByExample(tcustomExample);
    }

    @Override
    public List<TcustomCustom> selectTcustomCustomList(Tcustom tcustom) {
        List<Tcustom> tcustoms = this.selectTcustomList(tcustom);
        List<TcustomCustom> tcustomCustoms = new ArrayList<>();

        //现在已经在tcustom对象中扩展了envkey字段,无需再联查env表
       /* List<Tenv> tenvs = tenvService.selectAll();
        //java 1.8的新特性,使用Stream Api 将list转换为Map
        Map<Integer, Tenv> tenvMap = tenvs.stream().collect(Collectors.toMap(Tenv::getId, tenv -> tenv));

        *//*
        Map<Integer, Tenv> tenvMap = new HashMap<>();
        for (Tenv tenv : tenvs) {
            tenvMap.put(tenv.getId(), tenv);
        }
        */

        for (Tcustom t : tcustoms) {
            TcustomCustom tcustomCustom = new TcustomCustom();
            ReflectUtil.cloneParentToChild(t, tcustomCustom);
            //tcustomCustom.setEnvkey(tenvMap.get(tcustomCustom.getEnvid()).getEnvkey());
            List<Tcustomdetail> tcustomdetails = tcustomdetailService.selectByCondition(t.getId(), ClientLevelEnum.SERVICE.getLevel());//只取clientLevel=1的数据
            tcustomCustom.setTcustomdetails(tcustomdetails);
            tcustomCustoms.add(tcustomCustom);
        }
        return tcustomCustoms;
    }

    @Override
    public PageInfo<TcustomCustom> selectTcustomCustomPageInfo(Tcustom tcustom, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TcustomCustom> tcustomCustoms = this.selectTcustomCustomList(tcustom);
        PageInfo<TcustomCustom> pageInfo = new PageInfo<>(tcustomCustoms);
        return pageInfo;
    }

    @Override
    public String run(Integer customId, Integer executeUserId) {
        XmlSuite suite = new XmlSuite();
        List<XmlTest> xmlTestList = new ArrayList<>();

        CustomVO customVO = this.selectOne(customId); //VO包含Tcustom 和 Tcustomdetail
        List<Tcustomdetail> tcustomdetails = customVO.getTcustomdetails();

        /**
         * 将定制详情分组,groupingBy(Tcustomdetail.clientlevel)
         */
        List<Tcustomdetail> ss = new ArrayList<>();//定制的服务
        List<Tcustomdetail> is = new ArrayList<>();//定制的接口
        List<Tcustomdetail> cs = new ArrayList<>();//定制的用例
        List<Integer> sIds = new ArrayList<>();
        List<String> sNames = new ArrayList<>();
        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            if (ClientLevelEnum.SERVICE.getLevel().equals(tcustomdetail.getClientlevel())) {
                ss.add(tcustomdetail);
                sIds.add(tcustomdetail.getClientid());
                sNames.add(tcustomdetail.getClientname());
            } else if (ClientLevelEnum.INTERFACE.getLevel().equals(tcustomdetail.getClientlevel())) {
                is.add(tcustomdetail);
            } else if (ClientLevelEnum.CASE.getLevel().equals(tcustomdetail.getClientlevel())) {
                cs.add(tcustomdetail);
            }
        }

        /**
         * 映射服务-接口s,接口-用例s
         */
        Map<Integer, List<Tcustomdetail>> s_iList = is.stream().collect(Collectors.groupingBy(Tcustomdetail::getParentclientid));
        Map<Integer, List<Tcustomdetail>> i_cList = cs.stream().collect(Collectors.groupingBy(Tcustomdetail::getParentclientid));

        //自定义比较器-按优先级(priority)倒序,所有的list通过此比较器排序
        Comparator<Tcustomdetail> sortByPriorityDesc = Comparator.comparingInt(Tcustomdetail::getPriority).reversed();

        Consumer<Tcustomdetail> s_consumer = s -> {
            XmlClass xmlClass = new XmlClass();
            xmlClass.setName(PackageEnum.TEST.getPackageName() + "." + s.getClassname());
            List<XmlInclude> xmlIncludeList = new ArrayList<>();
            Map<String, List<Integer>> iName_cIdList = new HashMap<>();
            List<Tcustomdetail> iList = s_iList.get(s.getClientid());
            if (iList != null && iList.size() > 0) {
                iList.stream().sorted(sortByPriorityDesc).forEach(i -> {
                    String methodName = HryUtil.iUri2MethodName(i.getClientname());
                    xmlIncludeList.add(new XmlInclude(methodName));
                    List<Tcustomdetail> cList = i_cList.get(i.getClientid());
                    if (cList != null && cList.size() > 0) {
                        iName_cIdList.put(methodName, cList.stream().sorted(sortByPriorityDesc).map(Tcustomdetail::getClientid).collect(Collectors.toList()));
                    }
                });
            }
            if (xmlIncludeList.size() > 0) {
                xmlClass.setIncludedMethods(xmlIncludeList);
            }
            Map<String, String> params = new HashMap<>();
            params.put(ParamKeyEnum.SERVICEID.getKey(), s.getClientid() + "");
            params.put(ParamKeyEnum.ENVID.getKey(), customVO.getEnvid() + "");
            params.put(ParamKeyEnum.DESIGNER.getKey(), "");
            params.put(ParamKeyEnum.I_C.getKey(), iName_cIdList.size() > 0 ? JSON.toJSONString(iName_cIdList) : "");
            params.put(ParamKeyEnum.I_C_ZDY.getKey(), "");

            XmlTest xmlTest = new XmlTest(suite);
            xmlTest.setName(s.getClassname());
            xmlTest.setParameters(params);
            xmlTest.setClasses(Arrays.asList(xmlClass));

            xmlTestList.add(xmlTest);

        };
        ss.stream().sorted(sortByPriorityDesc).forEach(s_consumer);

        suite.setTests(xmlTestList);
        String date = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
        suite.setName("AutoSuite_" + date);
        log.info("即将运行定制:" + customId);

        String reportName = "r_uid" + customVO.getUserid() + "_cid" + customId + "_" + date + ".html";//u(user)代表用户,c(custom)代表定制
        //构造入库测试报告记录
        Treport treport = new Treport();
        treport.setCustomid(customVO.getId());
        treport.setCustomname(customVO.getCustomname());
        treport.setEnvid(customVO.getEnvid());
        treport.setEnvkey(customVO.getEnvkey());
        treport.setServiceids(JSON.toJSONString(sIds));//[1,2,3]
        treport.setServicenames(JSON.toJSONString(sNames));//["aaa","bbb","ccc"],取出后,可直接转换成JSONArray
        treport.setUserid(customVO.getUserid());
        treport.setUsername(customVO.getUsername());
        treport.setReportpath(reportPath);
        treport.setReportname(resourcePathPattern + reportName);
        treport.setStatus(StatusEnum.FIVE.getId());//测试报告生成中
        Integer treportId = treportService.insertOne(treport);

        //运行测试
        runner.run(treportId, reportName, customVO.getCustomname(), suite);
        //runner.run(null, treportId, reportName, customVO.getCustomname(), sMap);
        return resourcePathPattern + reportName;
        /*

         */
/**
 * iMap<服务id,List<接口名称>>
 *//*

        Map<Integer, List<String>> iMap = new HashMap<>();


        */
/**
 * cMap<服务id,Map<接口名称,List<用例id>>>
 *//*

        Map<Integer, Map<String, List<Integer>>> cMap = new HashMap<>();

        for (Tcustomdetail i : tcustomdetails_interface) {
            */
/**
 * 将iUri转换成对应的测试方法名称
 *//*

            String testMethodName = HryUtil.iUri2MethodName(i.getClientname());//对应测试类中的测试方法名

            */
/**
 * 将测试方法归类到测试类中t.getParentclientid()==Service.ID
 *//*

            if (!iMap.containsKey(i.getParentclientid())) {
                List<String> list = new ArrayList<>();
                list.add(testMethodName);
                iMap.put(i.getParentclientid(), list);
            } else {
                iMap.get(i.getParentclientid()).add(testMethodName);
            }

            */
/**
 * 找此接口是否定制过用例
 *//*

            Map<String, List<Integer>> i_c_map = new HashMap<>();
            for (Tcustomdetail c : tcustomdetails_case) {
                if (c.getParentclientid().equals(i.getClientid())) {
                    //此接口定制了用例
                    if (!i_c_map.containsKey(testMethodName)) {
                        List<Integer> listC = new ArrayList<>();
                        listC.add(c.getClientid());
                        i_c_map.put(testMethodName, listC);
                    } else {
                        i_c_map.get(testMethodName).add(c.getClientid());
                    }
                }
            }
            if (i_c_map.size() > 0) {
                if (cMap.containsKey(i.getParentclientid())) {
                    //如果serviceId已经存在 ,则将i_c_map合并到原来的i_c_map中,fixed by luqiwei 2018/08/07
                    cMap.get(i.getParentclientid()).putAll(i_c_map);//map.putAll():映射不存在则复制,存在则覆盖
                } else {
                    cMap.put(i.getParentclientid(), i_c_map);
                }
            }
        }
*/


        /**
         * 将准备好的测试类,测试方法,测试case传递给testNG
         */
        //Map<Tcustomdetail, XmlClass> sMap = new HashMap<>();

        //Integer envid = customVO.getEnvid();
        //User user = userService.selectOne(executeUserId);


/*
//        Tservicedetail condition = new Tservicedetail();
        for (Tcustomdetail tcustomdetail : tcustomdetails_service) {
            //构建测试类
            String testClassName = PackageEnum.TEST.getPackageName() + "." + tcustomdetail.getClassname();
            log.info("此次定制要测试的类:" + testClassName);
            XmlClass xmlClass = new XmlClass(testClassName);

            Map<String, String> params = new HashMap<>();//构建测试类常规参数
            params.put(ParamKeyEnum.SERVICEID.getKey(), tcustomdetail.getClientid() + "");
            params.put(ParamKeyEnum.ENVID.getKey(), envid + "");
            params.put(ParamKeyEnum.DESIGNER.getKey(), "");//此字段为预留后期使用,先传空值

            //构建此测试类对应的方法选择器(如果有的话)
            if (iMap.size() > 0) {
                List<String> runInterface = iMap.get(tcustomdetail.getClientid());
                if (runInterface != null && runInterface.size() > 0) {
                    List<XmlInclude> xmlIncludes = new ArrayList<>();
                    for (String s : runInterface) {
                        XmlInclude include = new XmlInclude(s);
                        xmlIncludes.add(include);
                    }
                    xmlClass.setIncludedMethods(xmlIncludes);
                }
            }

            //构建此测试类对应的case参数(如果有的话)
            String i_c_jsonStr = "";
            if (cMap.size() > 0) {
                Map<String, List<Integer>> stringListMap = cMap.get(tcustomdetail.getClientid());
                if (stringListMap != null && stringListMap.size() > 0) {
                    i_c_jsonStr = JSON.toJSONString(stringListMap);

                }
            }

            params.put(ParamKeyEnum.I_C.getKey(), i_c_jsonStr);//参数名:i_c
            params.put(ParamKeyEnum.I_C_ZDY.getKey(), "");//自定义Case,定制测试中使用不到,故这里传空值

            log.info("传给测试类的参数:" + params.toString());

            xmlClass.setParameters(params);
            sMap.put(tcustomdetail, xmlClass);//建立映射关系

        }
*/

        //Tenv tenv = tenvService.selectOne(envid);


    }

}
