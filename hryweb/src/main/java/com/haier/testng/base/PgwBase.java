package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: PgwBase
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@SKey("Pgw")
public class PgwBase extends Base {
    public PgwBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy,String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy,testingId);
    }
    @Uri(value = "/accountBalanceQueryFacade/accountBalanceQuery", desc = "账户余额查询")
    public String _accountBalanceQueryFacade_accountBalanceQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundPurchaseFacade/fundPurchase", desc = "基金申购")
    public String _fundPurchaseFacade_fundPurchase(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/fundShareQueryFacade/fundShareQuery", desc = "基金份额查询")
    public String _fundShareQueryFacade_fundShareQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/gatewayPostNotifyFacade/kjtPayNotify", desc = "快捷通回调")
    public String _gatewayPostNotifyFacade_kjtPayNotify(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/instantTradeFacade/instantTrade", desc = "即时收单")
    public String _instantTradeFacade_instantTrade(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/payToAccountFacade/payToAccount", desc = "转账到账户")
    public String _payToAccountFacade_payToAccount(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/payToCardFacade/payToCard", desc = "付款到卡")
    public String _payToCardFacade_payToCard(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tradeQueryFacade/tradeQuery", desc = "交易查询")
    public String _tradeQueryFacade_tradeQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
