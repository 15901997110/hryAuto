package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.Params;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/6 13:58
 */
@SKey("Pgw")
public class PgwBase {

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
        return HryHttpClientUtil.send(baseUrl, dbInfo, params);
    }

}
