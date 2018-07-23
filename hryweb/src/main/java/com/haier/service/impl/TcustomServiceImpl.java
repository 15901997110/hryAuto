package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.haier.enums.ClientLevelEnum;
import com.haier.enums.ParamKeyEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.enums.StatusEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcustomMapper;
import com.haier.po.*;
import com.haier.vo.CustomVO;
import com.haier.service.*;
import com.haier.testng.listener.HryReporter;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.testng.IReporter;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.*;

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
    TenvService tenvService;

    @Autowired
    UserService userService;

    @Autowired
    TserviceService tserviceService;

    @Autowired
    TreportService treportService;

    @Autowired
    TenvdetailService tenvdetailService;

    @Autowired
    TcustomdetailService tcustomdetailService;

    @Override
    public Integer insertOne(Tcustom tcustom, List<Tcustomdetail> tcustomdetails) {
        tcustomMapper.insertSelective(tcustom);
        Integer customId = tcustom.getId();//获取插入的自增Id
        if (tcustomdetails != null && tcustomdetails.size() > 0) {
            for (Tcustomdetail tcustomdetail : tcustomdetails) {
                tcustomdetail.setCustomid(customId);
                tcustomdetailService.insertOne(tcustomdetail);
            }
        }
        return customId;
    }

    @Override
    public Integer insertOne(CustomVO customVO) {
        Tcustom tcustom = new Tcustom();
        ReflectUtil.cloneChildToParent(tcustom, customVO);
        List<Tcustomdetail> list = customVO.getTcustomdetails();
        return this.insertOne(tcustom, list);
    }

    @Override
    public Integer updateOne(Tcustom tcustom) {
        ReflectUtil.setInvalidFieldToNull(tcustom, false);
        if (tcustom == null || tcustom.getId() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填!");
        }

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
        condition.setCustomid(tcustom.getId());
        tcustomdetailService.deleteByCondition(condition);

        //插入本次编辑的tcustomdetail记录
        List<Tcustomdetail> tcustomdetails = customVO.getTcustomdetails();
        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            tcustomdetail.setCustomid(tcustom.getId());
            tcustomdetailService.insertOne(tcustomdetail);
        }
        return tcustom.getId();
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
        tcustomdetailService.deleteByCondition(tcustomdetail);
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
    public List<Tcustom> selectByCondition(Tcustom tcustom) {
        TcustomExample tcustomExample = new TcustomExample();
        TcustomExample.Criteria criteria = tcustomExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tcustom != null) {
            if (tcustom.getUserid() != null) {
                criteria.andUseridEqualTo(tcustom.getUserid());
            }
        }
        return tcustomMapper.selectByExample(tcustomExample);
    }


    @Override
    public List<TcustomCustom> selectTcustomCustomByCondition(Tcustom tcustom) {
        List<Tcustom> tcustoms = this.selectByCondition(tcustom);
        List<TcustomCustom> tcustomCustoms = new ArrayList<>();

        List<Tenv> tenvList = tenvService.selectAll();
        Map<Integer, Tenv> tenvMap = new HashMap<>();
        for (Tenv _env : tenvList) {
            tenvMap.put(_env.getId(), _env);
        }

        for (Tcustom t : tcustoms) {
            TcustomCustom tcustomCustom = new TcustomCustom();
            ReflectUtil.cloneParentToChild(t, tcustomCustom);
            tcustomCustom.setEnvkey(tenvMap.get(tcustomCustom.getEnvid()).getEnvkey());

            List<Tcustomdetail> tcustomdetails = tcustomdetailService.selectByCondition(t.getId());
            tcustomCustom.setTcustomdetails(tcustomdetails);

            tcustomCustoms.add(tcustomCustom);
        }

        return tcustomCustoms;
    }

    @Override
    public void run(Integer customId, Integer executeUserId) {

        //VO包含Tcustom 和 Tcustomdetail
        CustomVO customVO = this.selectOne(customId);

        List<Tcustomdetail> tcustomdetails = customVO.getTcustomdetails();

        List<Tcustomdetail> tcustomdetails_service = new ArrayList<>();//定制的服务
        List<Tcustomdetail> tcustomdetails_interface = new ArrayList<>();//定制的接口
        List<Tcustomdetail> tcustomdetails_case = new ArrayList<>();//定制的用例

        List<Integer> service_ids = new ArrayList<>();
        List<String> service_names = new ArrayList<>();

        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            /**
             * 服务-对应测试类
             */
            if (ClientLevelEnum.SERVICE.getLevel().equals(tcustomdetail.getClientlevel())) {
                tcustomdetails_service.add(tcustomdetail);
                service_ids.add(tcustomdetail.getClientid());
                service_names.add(tcustomdetail.getClientname());
            }

            /**
             * 接口-对应测试方法,注意,iUri与测试方法需要转换一下 /aaa/bbb   转成 aaa_bbb
             */
            if (ClientLevelEnum.INTERFACE.getLevel().equals(tcustomdetail.getClientlevel())) {
                tcustomdetails_interface.add(tcustomdetail);
            }

            /**
             * 用例,用例需要传到测试类中,但是测试类现在仅支持传入Map<String,String>,需要将用例ids转成字符串传入并在测试类中解析出来
             */
            if (ClientLevelEnum.CASE.getLevel().equals(tcustomdetail.getClientlevel())) {
                tcustomdetails_case.add(tcustomdetail);
            }
        }

        Map<Integer, List<String>> iMap = new HashMap<>();
        Map<Integer, Map<String, List<Integer>>> cMap = new HashMap<>();

        if (tcustomdetails_interface.size() > 0) {
            for (Tcustomdetail i : tcustomdetails_interface) {
                /**
                 * 将iUri转换成对应的测试方法名称
                 */
                String iUri = i.getClientname();//接口Uri
                String testMethodName;//对应测试类中的测试方法名
                if (iUri.startsWith("/")) {
                    testMethodName = iUri.replaceFirst("/", "").replaceAll("/", "_");
                } else {
                    testMethodName = iUri.replaceAll("/", "_");
                }

                /**
                 * 将测试方法归类到测试类中t.getParentclientid()==Service.ID
                 */
                if (!iMap.containsKey(i.getParentclientid())) {
                    List<String> list = new ArrayList<>();
                    list.add(testMethodName);
                    iMap.put(i.getParentclientid(), list);
                } else {
                    iMap.get(i.getParentclientid()).add(testMethodName);
                }

                /**
                 * 找此接口是否定制过用例
                 */
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
                    cMap.put(i.getParentclientid(), i_c_map);
                }
            }
        }


        /**
         * 将准备好的测试类,测试方法,测试case传递给testNG
         */
        Map<Tcustomdetail, XmlClass> sMap = new HashMap<>();

        Integer envid = customVO.getEnvid();
        User user = userService.selectOne(executeUserId);

        Tenvdetail condition = new Tenvdetail();
        for (Tcustomdetail tcustomdetail : tcustomdetails_service) {
            condition.setEnvid(envid);
            condition.setServiceid(tcustomdetail.getClientid());
            List<Tenvdetail> tenvdetails_service = tenvdetailService.selectByCondition(condition);
            if (tenvdetails_service != null && tenvdetails_service.size() > 0) {

                //取第1条记录,按正常情况 ,有且仅有一条记录才对,否则 就是脏数据
                Tenvdetail s0 = tenvdetails_service.get(0);

                //测试类必须已经填写
                if (s0.getClazz() != null && !"".equals(s0.getClazz())) {

                    //构建测试类
                    XmlClass xmlClass = new XmlClass(s0.getClazz());

                    Map<String, String> params = new HashMap<>();//构建测试类常规参数
                    params.put(ParamKeyEnum.SERVICEID.getKey(), s0.getServiceid() + "");
                    params.put(ParamKeyEnum.ENVID.getKey(), s0.getEnvid() + "");
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
                    xmlClass.setParameters(params);
                    sMap.put(tcustomdetail, xmlClass);//建立映射关系
                }
            }
        }

        Tenv tenv = tenvService.selectOne(envid);

        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "report_u" + user.getId() + "_c" + customId + "_" + date + ".html";//u(user)代表用户,c(custom)代表定制
        //构造入库记录
        Treport treport = new Treport();
        treport.setCustomid(customVO.getId());
        treport.setCustomname(customVO.getCustomname());
        treport.setEnvid(envid);
        treport.setEnvkey(tenv.getEnvkey());
        treport.setServiceids(JSON.toJSONString(service_ids));//[1,2,3]
        treport.setServicenames(JSON.toJSONString(service_names));//["aaa","bbb","ccc"],取出后,可直接转换成JSONArray
        treport.setUserid(user.getId());
        treport.setUsername(user.getRealname());
        treport.setReportpath(reportPath);
        treport.setReportname(resourcePathPattern + reportName);
        treport.setStatus(StatusEnum.FIVE.getId());//测试报告生成中

        treportService.insertOne(treport);//执行数据插入后,返回自增ID到treport.id中
        Integer treportId = treport.getId();

        this.run(null, treportId, reportName, customVO.getCustomname(), sMap);
        return;
    }
    public void updateReportStatus(Integer reportId) {
        Treport treport = new Treport();
        treport.setId(reportId);
        treport.setStatus(StatusEnum.TEN.getId());
        treportService.updateOne(treport);
    }

    @Async("asyncServiceExecutor")
    public void run(Map<String, String> params, Integer reportId, String reportName, String customName, Map<Tcustomdetail, XmlClass> sMap) {
        TestNG ng = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("AutoSuite");
        if (params != null) {
            suite.setParameters(params);//这是全局的参数,预留未来可能的需求(现在并未使用 2018-07-14)
        }
        List<XmlTest> tests = new ArrayList<>();
        for (Map.Entry entry : sMap.entrySet()) {
            Tcustomdetail key = (Tcustomdetail) entry.getKey();
            XmlClass clazz = (XmlClass) entry.getValue();

            XmlTest test = new XmlTest(suite);
            test.setName(key.getClientname());
            //test.setName("test.setName 测试测试");
            test.setXmlClasses(Arrays.asList(clazz));

            tests.add(test);
        }

        suite.setTests(tests);
        ng.setXmlSuites(Arrays.asList(suite));

        ITestNGListener reporter = new HryReporter(reportPath, reportName, customName);
        ng.addListener(reporter);
        ng.run();

        /**
         * 运行完成之后,更新treport状态
         */
        updateReportStatus(reportId);
    }

    @Async("asyncServiceExecutor")
    public void run(Map<String, String> params, Integer reportId, String reportName, List<XmlClass> xmlClasses) {

        /**
         * 运行测试用例
         */
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("AutoSuite");
        if (params != null) {
            suite.setParameters(params);
        }
        List<XmlTest> xmlTests = new ArrayList<>();
        for (XmlClass c : xmlClasses) {
            XmlTest test = new XmlTest(suite);
            test.setName(c.getName().substring(c.getName().lastIndexOf(".") + 1));
            test.setClasses(Arrays.asList(c));
            xmlTests.add(test);
        }

        suite.setTests(xmlTests);

        testNG.setXmlSuites(Arrays.asList(suite));
        ITestNGListener reporter = new HryReporter(reportPath, reportName);
        testNG.addListener(reporter);
        testNG.run();

        /**
         * 运行完成之后,更新treport状态
         */
        updateReportStatus(reportId);
    }
}
