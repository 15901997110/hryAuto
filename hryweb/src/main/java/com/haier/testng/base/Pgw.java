package com.haier.testng.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.enums.HttpTypeEnum;
import com.haier.po.*;
import com.haier.service.RunService;
import com.haier.service.TcaseService;
import com.haier.service.TserviceService;
import com.haier.service.TservicedetailService;
import com.haier.util.AssertUtil;
import com.haier.util.BeforeUtil;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 只实现单一测试方法, 没有逻辑
 * @params:
 * @return:
 * @author: luqiwei
 * @date: 2018-08-02
 */
@Slf4j
@SKey("Pgw")
public class Pgw {
    public Pgw(Integer envId) {
        TserviceService tserviceService = SpringContextHolder.getBean(TserviceService.class);
        Tservice tservice = tserviceService.selectOne(this.getClass().getAnnotation(SKey.class).value());
        TservicedetailService tservicedetailService = SpringContextHolder.getBean(TservicedetailService.class);
        Tservicedetail tservicedetail = tservicedetailService.selectOne(tservice.getId(), envId);
        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo();
        dbInfo = tservicedetail.getDbinfo();
    }

    private String baseUrl;
    private String dbInfo;

    @Uri(value = "/accountBalanceQueryFacade/accountBalanceQuery", desc ="账户余额查询")
    public String accountBalanceQueryFacade_accountBalanceQuery(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/fundPurchaseFacade/fundPurchase", desc = "基金申购")
    public String fundPurchaseFacade_fundPurchase(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/fundShareQueryFacade/fundShareQuery", desc = "基金份额查询")
    public String fundShareQueryFacade_fundShareQuery(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/gatewayPostNotifyFacade/kjtPayNotify", desc = "快捷通回调")
    public String gatewayPostNotifyFacade_kjtPayNotify(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/instantTradeFacade/instantTrade", desc = "即时收单")
    public String instantTradeFacade_instantTrade(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/payToAccountFacade/payToAccount", desc = "转账到账户")
    public String payToAccountFacade_payToAccount(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/payToCardFacade/payToCard", desc = "付款到卡")
    public String payToCardFacade_payToCard(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

    @Uri(value = "/tradeQueryFacade/tradeQuery", desc = "交易查询")
    public String tradeQueryFacade_tradeQuery(Params params) {
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }
}
