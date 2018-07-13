package com.haier.service.impl;

import com.haier.enums.ClientLevelEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.enums.StatusEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcustomMapper;
import com.haier.po.*;
import com.haier.request.CustomVO;
import com.haier.service.*;
import com.haier.testng.listener.HryReporter;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

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
        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            tcustomdetail.setCustomid(customId);
            tcustomdetailService.insertOne(tcustomdetail);
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

/*
        //VO包含Tcustom 和 Tcustomdetail
        CustomVO customVO = this.selectOne(customId);


        List<Tcustomdetail> tcustomdetails = customVO.getTcustomdetails();

        List<Tcustomdetail> tcustomdetails_service = new ArrayList<>();//定制的服务
        List<Tcustomdetail> tcustomdetails_interface = new ArrayList<>();//定制的接口
        List<Tcustomdetail> tcustomdetails_case = new ArrayList<>();//定制的用例

        for (Tcustomdetail tcustomdetail : tcustomdetails) {
            if (ClientLevelEnum.SERVICE.getLevel() == tcustomdetail.getClientlevel()) {
                tcustomdetails_service.add(tcustomdetail);
            }
            if (ClientLevelEnum.INTERFACE.getLevel() == tcustomdetail.getClientlevel()) {
                tcustomdetails_interface.add(tcustomdetail);
            }
            if (ClientLevelEnum.CASE.getLevel() == tcustomdetail.getClientlevel()) {
                tcustomdetails_case.add(tcustomdetail);
            }
        }

        Integer[] serviceIds = null;

        Integer envid = customVO.getEnvid();
        Tenv tenv = tenvService.selectOne(envid);

        User user = userService.selectOne(executeUserId);

        Tenvdetail condition = new Tenvdetail();
        *//**
         * 要运行的测试类对应的tenvdetail
         *//*
        List<Tenvdetail> tenvdetails = new ArrayList<>();//要运行的测试类
        for(Tcustomdetail tcustomdetail:tcustomdetails_service){
            condition.setEnvid(envid);
            condition.setServiceid(tcustomdetail.getClientid());
            List<Tenvdetail> tenvdetails_service = tenvdetailService.selectByCondition(condition);
            if(tenvdetails_service!=null&&tenvdetails_service.size()>0){
                for(Tenvdetail tenvdetail_service:tenvdetails_service){
                    tenvdetails.add(tenvdetail_service);
                }
            }
        }
        *//**
         * 要运行的接口
         *//*


        if (tenvdetails == null || tenvdetails.size() < 1) {
            throw new HryException(StatusCodeEnum.NOT_FOUND, "定制id=" + customId + ",通过相应的serviceId和envId未从服务-环境映射表中找到记录!");
        }

        List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
        for (Tenvdetail ttt : tenvdetails) {

            XmlClass xmlClass = new XmlClass();
            xmlClass.setName(ttt.getClazz());
            //设置参数,测试类运行时需要根据serviceId和envId来初始化并获取case信息
            Map<String, String> params = new HashMap<>();
            params.put(ParamKeyEnum.SERVICEID.getKey(), ttt.getServiceid() + "");
            params.put(ParamKeyEnum.ENVID.getKey(), ttt.getEnvid() + "");
            params.put(ParamKeyEnum.DESIGNER.getKey(), "");//此字段为预留后期使用,先传空值
            xmlClass.setParameters(params);
            xmlClasses.add(xmlClass);
        }

        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "report_u" + user.getId() + "_c" + customId + "_" + date + ".html";
        //构造入库记录
        Treport treport = new Treport();
        treport.setCustomid(tcustom.getId());
        treport.setCustomname(tcustom.getCustomname());
        treport.setEnvid(tenv.getId());
        treport.setEnvkey(tenv.getEnvkey());
        treport.setServiceids(serviceIdStr);
        treport.setUserid(user.getId());
        treport.setUsername(user.getRealname());
        treport.setReportpath(reportPath);
        treport.setReportname(resourcePathPattern + reportName);
        treport.setStatus(StatusEnum.FIVE.getId());//测试报告生成中

        treportService.insertOne(treport);//执行数据插入后,返回自增ID到treport.id中
        Integer treportId = treport.getId();

        this.run(null, treportId, reportName, HryUtil.distinct(xmlClasses));
    }

    @Async("asyncServiceExecutor")
    public void run(Map<String, String> params, Integer reportId, String reportName, List<XmlClass> xmlClasses) {

        *//**
         * 运行测试用例
         *//*
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        List<XmlTest> xmlTests = new ArrayList<>();
        for (XmlClass c : xmlClasses) {
            XmlTest test = new XmlTest(suite);
            test.setName(c.getName().substring(c.getName().lastIndexOf(".") + 1));
            test.setClasses(Arrays.asList(c));
            xmlTests.add(test);
        }
        suite.setName("AutoSuite");
        suite.setTests(xmlTests);

        testNG.setXmlSuites(Arrays.asList(suite));
        testNG.addListener(new HryReporter(reportPath, reportName));
        testNG.run();


        *//**
         * 运行完成之后,更新treport状态
         *//*
        Treport treport = new Treport();
        treport.setId(reportId);
        treport.setStatus(StatusEnum.TEN.getId());
        treportService.updateOne(treport);*/
    }
}
