package com.haier.service.impl;

import com.haier.enums.ParamKeyEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.enums.StatusEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcustomMapper;
import com.haier.mapper.TenvMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.*;
import com.haier.testng.listener.HryReporter;
import com.haier.util.HryUtil;
import com.haier.util.ReflectUtil;
import com.haier.util.RunUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
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

    @Override
    public Integer insertOne(Tcustom tcustom) {
        ReflectUtil.setInvalidFieldToNull(tcustom, false);
        if (tcustom == null || tcustom.getEnvid() == null || tcustom.getServiceid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id,envId,serviceId必填!");
        }
        return tcustomMapper.insertSelective(tcustom);
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
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        Tcustom tcustom = new Tcustom();
        tcustom.setId(id);
        tcustom.setStatus(-1);
        return this.updateOne(tcustom);
    }

    @Override
    public Tcustom selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return tcustomMapper.selectByPrimaryKey(id);
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
        List<TcustomCustom> tcustomCustoms = new ArrayList<>();
        List<Tcustom> tcustoms = this.selectByCondition(tcustom);

        if (tcustoms != null && tcustoms.size() > 0) {
            //拿到所有Tservice
            List<Tservice> var1 = tserviceService.selectByCondition(null);
            Map<Integer, Tservice> tserviceMap = new HashMap<>();
            if (var1 != null && var1.size() > 0) {
                for (Tservice var2 : var1) {
                    tserviceMap.put(var2.getId(), var2);
                }
            }
            //拿到所有的Tenv
            List<Tenv> var3 = tenvService.selectAll();
            Map<Integer, Tenv> tenvMap = new HashMap<>();
            if (var3 != null && var3.size() > 0) {
                for (Tenv var4 : var3) {
                    tenvMap.put(var4.getId(), var4);
                }
            }


            for (Tcustom t : tcustoms) {
                TcustomCustom tcustomCustom = new TcustomCustom();
                ReflectUtil.clone(t, tcustomCustom);
                if (tcustomCustom.getEnvid() != null) {
                    Tenv tenv = tenvMap.get(tcustomCustom.getEnvid());
                    if (tenv != null) {
                        tcustomCustom.setEnvkey(tenv.getEnvkey());
                    }
                }
                String serviceid = tcustomCustom.getServiceid();
                List<Tservice> list = new ArrayList<>();
                if (serviceid != null) {
                    String[] ids;
                    if (serviceid.contains(",")) {
                        ids = serviceid.trim().split(",");
                    } else {
                        ids = new String[]{serviceid};
                    }
                    for (String id : ids) {
                        try {
                            int i = Integer.parseInt(id);
                            Tservice tservice = tserviceMap.get(i);
                            if (tservice != null)
                                list.add(tservice);
                        } catch (NumberFormatException e) {
                            log.error("serviceId String强转Integer失败");
                        }
                    }
                }
                tcustomCustom.setTserviceList(list);
                tcustomCustoms.add(tcustomCustom);
            }
            return tcustomCustoms;
        }
        return null;
    }

    @Override
    public void run(Integer customId,Integer executeUserId) {
        if (customId == null || customId == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "定制测试id必填!");
        }
        Tcustom tcustom = this.selectOne(customId);
        if (tcustom == null) {
            throw new HryException(StatusCodeEnum.NOT_FOUND, "tcustom.id=" + customId);
        }
        String serviceIdStr = tcustom.getServiceid();
        Integer[] serviceIds= HryUtil.convert(serviceIdStr);
        if(serviceIds==null||serviceIds.length==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        Integer envid=tcustom.getEnvid();
        Tenv tenv=tenvService.selectOne(envid);

        User user=userService.selectOne(executeUserId);

        Tenvdetail condition=new Tenvdetail();
        List<Tenvdetail> tenvdetails=new ArrayList<>();//要运行的测试类
        for(Integer serviceid:serviceIds){
            condition.setEnvid(envid);
            condition.setServiceid(serviceid);
            List<Tenvdetail> tenvdetailList = tenvdetailService.selectByCondition(condition);
            if(tenvdetailList!=null&& tenvdetailList.size()>0){
                for(Tenvdetail var:tenvdetailList){
                    tenvdetails.add(var);
                }
            }
        }

        if(tenvdetails==null||tenvdetails.size()<1){
            throw new HryException(StatusCodeEnum.NOT_FOUND,"定制id="+customId+",通过相应的serviceId和envId未从服务-环境映射表中找到记录!");
        }

        List<XmlClass> xmlClasses=new ArrayList<XmlClass>();
        for(Tenvdetail ttt:tenvdetails){

            XmlClass xmlClass=new XmlClass();
            xmlClass.setName(ttt.getClazz());
            //设置参数,测试类运行时需要根据serviceId和envId来初始化并获取case信息
            Map<String,String> params=new HashMap<>();
            params.put(ParamKeyEnum.SERVICEID.getKey(),ttt.getServiceid()+"");
            params.put(ParamKeyEnum.ENVID.getKey(),ttt.getEnvid()+"");
            params.put(ParamKeyEnum.DESIGNER.getKey(),"");//此字段为预留后期使用,先传空值
            xmlClass.setParameters(params);
            xmlClasses.add(xmlClass);
        }

        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "report_u" + user.getId() + "_c" + customId + "_" + date + ".html";
        //构造入库记录
        Treport treport=new Treport();
        treport.setCustomid(tcustom.getId());
        treport.setCustomname(tcustom.getCustomname());
        treport.setEnvid(tenv.getId());
        treport.setEnvkey(tenv.getEnvkey());
        treport.setServiceid(serviceIdStr);
        treport.setUserid(user.getId());
        treport.setUsername(user.getRealname());
        treport.setReportpath(reportPath);
        treport.setReportname(resourcePathPattern+reportName);
        treport.setStatus(StatusEnum.FIVE.getId());//测试报告生成中

        treportService.insertOne(treport);//执行数据插入后,返回自增ID到treport.id中
        Integer treportId=treport.getId();

        this.run(null,treportId,reportName,HryUtil.distinct(xmlClasses));
    }

    @Async("asyncServiceExecutor")
    public void run(Map<String, String> params,Integer reportId,String reportName,List<XmlClass> xmlClasses) {

        /**
         * 运行测试用例
         */
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        List<XmlTest> xmlTests = new ArrayList<>();
        for(XmlClass c:xmlClasses){
            XmlTest test=new XmlTest(suite);
            test.setName(c.getName().substring(c.getName().lastIndexOf(".")+1));
            test.setClasses(Arrays.asList(c));
            xmlTests.add(test);
        }
        suite.setName("AutoSuite");
        suite.setTests(xmlTests);

        testNG.setXmlSuites(Arrays.asList(suite));
        testNG.addListener(new HryReporter(reportPath, reportName));
        testNG.run();


        /**
         * 运行完成之后,更新treport状态
         */
        Treport treport=new Treport();
        treport.setId(reportId);
        treport.setStatus(StatusEnum.TEN.getId());
        treportService.updateOne(treport);
    }
}
