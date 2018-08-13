package com.haier.testng.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.config.SpringContextHolder;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.HryUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: PgwBase
 * @Author: 自动生成
 * @Date: 2018/08/08 17:35:33
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("Pgw")
public class PgwBase2 {
    public Integer serviceId;
    public Integer envId;
    public String caseDesigner;
    public JSONObject i_c_JSONObject;//{"methodName",List<CaseId>}
    public JSONObject i_c_zdy_JSONObject;//{"methodName",list<Tcase>}
    public Tservice tservice;
    public Tservicedetail tservicedetail;
    public RunService runService = SpringContextHolder.getBean(RunService.class);

    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        log.info("测试类接收到的ServiceId:" + serviceId);
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        if (StringUtils.isNotBlank(i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        if (StringUtils.isNotBlank(i_c_zdy)) {
            this.i_c_zdy_JSONObject = JSONObject.parseObject(i_c_zdy);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
    }

    public Object[] provider(Method method) {
        return HryUtil.getTests(tservice, tservicedetail, caseDesigner, i_c_JSONObject, i_c_zdy_JSONObject, method);
    }

/*    public Object[] getTests(Method method) {
        Object[] ret;
        String iUri;
        //testName可能未填写
        iUri = method.getAnnotation(Test.class).testName();
        if (StringUtils.isBlank(iUri)) {
            throw new SkipException("测试方法(" + method.getName() + ")上@Test.testName注解异常");
        }

        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            throw new SkipException("测试服务(id=" + serviceId + ")未找到此接口" + iUri);
        }

        *//**
     * 用户有自定义的Case,则返回用户自定义的Case
     *//*

        if (i_c_zdy_JSONObject.size() > 0) {
            JSONArray zdyCaseArray = i_c_zdy_JSONObject.getJSONArray(method.getName());
            if (zdyCaseArray != null && zdyCaseArray.size() > 0) {
                ret = new Object[zdyCaseArray.size()];
                for (int i = 0; i < zdyCaseArray.size(); i++) {
                    HryTest test = new HryTest();
                    test.setTservice(tservice);
                    test.setTservicedetail(tservicedetail);
                    test.setTi(ti);
                    test.setTcase((Tcase) zdyCaseArray.get(i));
                }
                return ret;
            }
        }


        *//**
     * 用户没有自定义的Case,则使用数据库的Case,选择对应环境的所有Case(注意,未指定envId的Case也会被选择出来)
     * 然后根据用户的定制需求,过滤出用户定制的Case
     *//*
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            throw new SkipException("此接口(" + iUri + ")无可用的测试用例");
        }

        */

    /**
     * 处理用户定制的Case
     *//*
        if (this.i_c_JSONObject != null && this.i_c_JSONObject.size() > 0) {
            JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());
            if (customCaseArray != null && customCaseArray.size() > 0) {
                Iterator<Tcase> iterator = tcases.iterator();
                while (iterator.hasNext()) {
                    Tcase tcase = iterator.next();
                    //数据库中查到的caseid不在定制列表中,则移除掉
                    if (!customCaseArray.contains(tcase.getId())) {
                        iterator.remove();
                    }
                }
            }
        }
        ret = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            HryTest test=new HryTest();
            test.setTservice(tservice);
            test.setTservicedetail(tservicedetail);
            test.setTi(ti);
            test.setTcase(tcases.get(i));
            ret[i] = test;
        }
        return ret;
    }*/
    @Uri(value = "/payToAccountFacade/payToAccount", desc = "转账到账户")
    public String _payToAccountFacade_payToAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeQueryFacade/tradeQuery", desc = "交易查询")
    public String _tradeQueryFacade_tradeQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
