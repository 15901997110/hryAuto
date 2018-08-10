package com.haier.testng.backup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.util.HryHttpClientUtil;
import com.haier.config.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/6 13:58
 */
@SuppressWarnings("Duplicates")
@Slf4j
@SKey("Pgw")
public class PgwBaseBackup {
    public Integer serviceId;
    public Integer envId;
    public String caseDesigner;
    public JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型
    public String baseUrl;//http://host:port
    public String dbInfo;
    public Tservice tservice;
    public Tservicedetail tservicedetail;
    public RunService runService = SpringContextHolder.getBean(RunService.class);

    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        if (StringUtils.isNotBlank(i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo();
        dbInfo = tservicedetail.getDbinfo();
    }

    public Object[] provider(Method method) {
        Object[] objects;
        String iUri;
        //testName可能未填写
        try {
            iUri = method.getAnnotation(Test.class).testName();
            if (iUri == null || "".equals(iUri)) {
                Reporter.log("测试方法中没有没有@Test(testName=\"\")注解");
                throw new SkipException("测试方法中没有没有@Test(testName=\"\")注解");
            }
        } catch (NullPointerException e) {
            log.error("获取测试方法的@Test注解异常:" + method.getName(), e);
            throw new SkipException("获取测试方法的@Test注解异常");
        }

        Ti ti = runService.getTi(this.serviceId, iUri);
        if (ti == null) {
            throw new SkipException("测试服务下面没有接口:" + iUri);
        }
        //此接口对应的全部用例
        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);
        if (tcases == null || tcases.size() == 0) {
            throw new SkipException("此接口无可用的测试用例");
        }

        //如果用户有定制测试用例,则使用用户定制的用例来进行测试
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
        objects = new Object[tcases.size()];
        for (int i = 0; i < tcases.size(); i++) {
            Params params = new Params();
            params.setTi(ti);
            params.setTcase(tcases.get(i));
            objects[i] = params;
        }
        return objects;
    }

    @Uri(value = "/accountBalanceQueryFacade/accountBalanceQuery", desc = "账户余额查询")
    public String accountBalanceQueryFacade_accountBalanceQuery(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/fundPurchaseFacade/fundPurchase", desc = "基金申购")
    public String fundPurchaseFacade_fundPurchase(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/fundShareQueryFacade/fundShareQuery", desc = "基金份额查询")
    public String fundShareQueryFacade_fundShareQuery(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/gatewayPostNotifyFacade/kjtPayNotify", desc = "快捷通回调")
    public String gatewayPostNotifyFacade_kjtPayNotify(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/instantTradeFacade/instantTrade", desc = "即时收单")
    public String instantTradeFacade_instantTrade(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/payToAccountFacade/payToAccount", desc = "转账到账户")
    public String payToAccountFacade_payToAccount(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/payToCardFacade/payToCard", desc = "付款到卡")
    public String payToCardFacade_payToCard(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/tradeQueryFacade/tradeQuery", desc = "交易查询")
    public String tradeQueryFacade_tradeQuery(String baseUrl, String dbInfo, Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);
    }

}
