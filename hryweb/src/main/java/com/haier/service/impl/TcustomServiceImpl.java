package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.ClientLevelEnum;
import com.haier.enums.PackageEnum;
import com.haier.enums.ParamKeyEnum;
import com.haier.enums.SortEnum;
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
import org.springframework.stereotype.Service;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

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
        for (Tcustom t : tcustoms) {
            TcustomCustom tcustomCustom = new TcustomCustom();
            ReflectUtil.cloneParentToChild(t, tcustomCustom);
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
        List<Tcustomdetail> ls = customVO.getTcustomdetails();

        /**
         * 将定制详情分组,groupingBy(Tcustomdetail.clientlevel)
         */
        Map<Integer, List<Tcustomdetail>> levelGroups = ls.stream().collect(Collectors.groupingBy(Tcustomdetail::getClientlevel));
        List<Tcustomdetail> ss = levelGroups.get(ClientLevelEnum.SERVICE.getLevel());//定制的服务,服务是一定有的
        List<Tcustomdetail> is = levelGroups.get(ClientLevelEnum.INTERFACE.getLevel());//定制的接口,可能有,可能没有
        List<Tcustomdetail> cs = levelGroups.get(ClientLevelEnum.CASE.getLevel());//定制的用例,可能有,可能没有

        /**
         * 映射服务-接口s,接口-用例s
         */
        Map<Integer, List<Tcustomdetail>> s_iList = is == null ? new HashMap<>() : is.stream().collect(Collectors.groupingBy(Tcustomdetail::getParentclientid));
        Map<Integer, List<Tcustomdetail>> i_cList = cs == null ? new HashMap<>() : cs.stream().collect(Collectors.groupingBy(Tcustomdetail::getParentclientid));

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
                    xmlIncludeList.add(new XmlInclude(methodName, 0 - i.getPriority()));//XmlInclude按index升序的顺序执行测试
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
        Treport treport = treportService.insertOne(customVO);

        runner.run(treport.getId(), treport.getReportname(), customVO.getCustomname(), suite);
        return treport.getReportname();
    }
}
