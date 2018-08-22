package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: CdpBase
 * @Author: 自动生成
 * @Date: 2018/08/17 14:34:00
 */
@SKey("Cdp")
public class CdpBase extends Base {
    @Uri(value = "/baiduFacade/queryBlackRiskLevel", desc = "百度-磐石系统-黑名单风险等级")
    public String _baiduFacade_queryBlackRiskLevel(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/echoFacade/queryEchoInfo", desc = "阿福平台共享数据查询")
    public String _echoFacade_queryEchoInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/echoFacade/queryRiskInfo", desc = "宜信风险名单查询")
    public String _echoFacade_queryRiskInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/echoFacade/queryShareInfo", desc = "共享数据查询（数据由我方提供，接口由宜信调用）")
    public String _echoFacade_queryShareInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/esFacade/queryContactsStats", desc = "ES-BI计算数据-设备计算数据")
    public String _esFacade_queryContactsStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/esFacade/queryEquipmentData", desc = "ES-BI计算数据-设备计算数据")
    public String _esFacade_queryEquipmentData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/hairyGatewayFacade/queryData", desc = "海融易网关统一facade")
    public String _hairyGatewayFacade_queryData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/juXinLiFacade/queryData", desc = "聚信立统一facade")
    public String _juXinLiFacade_queryData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/kjtPayFacade/queryData", desc = "快捷通统一facade")
    public String _kjtPayFacade_queryData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieCallBackFacade/allbill", desc = "摩羯-异步回调Allbill持久化facade")
    public String _moxieCallBackFacade_allbill(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieCallBackFacade/bill", desc = "摩羯-异步回调Bill持久化facade")
    public String _moxieCallBackFacade_bill(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieCallBackFacade/report", desc = "摩羯-异步回调Report持久化facade")
    public String _moxieCallBackFacade_report(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieCallBackFacade/task", desc = "摩羯-异步回调Task持久化facade")
    public String _moxieCallBackFacade_task(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieCallBackFacade/task/submit", desc = "摩羯-异步回调TaskSubmit持久化facade")
    public String _moxieCallBackFacade_task_submit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/alipay/queryAlipayTradeInfoData", desc = "摩羯-支付宝用户交易记录facade")
    public String _moxieFacade_alipay_queryAlipayTradeInfoData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/alipay/queryAlipayUserInfoData", desc = "摩羯-支付宝用户基本信息facade")
    public String _moxieFacade_alipay_queryAlipayUserInfoData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/alipay/queryAlipayWealthData", desc = "摩羯-支付宝用户资产状况facade")
    public String _moxieFacade_alipay_queryAlipayWealthData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/pushCarrierMobilesDataToKafka", desc = "摩羯-运营商-获取运营商原始数据(推送BI的Kafka)facade")
    public String _moxieFacade_carrier_pushCarrierMobilesDataToKafka(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierMobilesData", desc = "摩羯-运营商-获取运营商原始数据衍生计算数据(含通话详单采集结果)facade")
    public String _moxieFacade_carrier_queryCarrierMobilesData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierMobilesDataAll", desc = "摩羯-运营商-获取运营商聚合数据(含计算后的原始数据业务数据和报表数据)facade")
    public String _moxieFacade_carrier_queryCarrierMobilesDataAll(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierMobilesDataStats", desc = "摩羯-运营商-获取运营商原始数据(交叉统计数据)facade")
    public String _moxieFacade_carrier_queryCarrierMobilesDataStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierMobilesOriginalData", desc = "摩羯-运营商-获取运营商原始数据(含通话详单采集结果)facade")
    public String _moxieFacade_carrier_queryCarrierMobilesOriginalData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierMxreportData", desc = "摩羯-运营商-获取运营商数据报表facade")
    public String _moxieFacade_carrier_queryCarrierMxreportData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/carrier/queryCarrierReportData", desc = "摩羯-运营商-获取运营商数据报表(报表URL和HTML数据)facade")
    public String _moxieFacade_carrier_queryCarrierReportData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/email/emailBillsConsistencyCheck", desc = "摩羯-用户姓名、卡号与信用卡邮箱数据一致性校验")
    public String _moxieFacade_email_emailBillsConsistencyCheck(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/email/queryEmailBills", desc = "摩羯-查询信用卡邮箱接口facade")
    public String _moxieFacade_email_queryEmailBills(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/email/queryMobilesMxreport", desc = "摩羯-信用卡邮箱报告接口(报表URL和HTML数据)facade")
    public String _moxieFacade_email_queryMobilesMxreport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/email/queryMobilesMxreportData", desc = "摩羯-信用卡邮箱报告接口(报原始数据)facade")
    public String _moxieFacade_email_queryMobilesMxreportData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/queryMobilesMxreport", desc = "摩羯-用户报告API文档facade")
    public String _moxieFacade_queryMobilesMxreport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/moxieFacade/queryReportStatus", desc = "摩羯-查询报告状态接口facade")
    public String _moxieFacade_queryReportStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nfcsFacade/queryCredit", desc = "资信NFCS用户信用facade")
    public String _nfcsFacade_queryCredit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nfcsFacade/queryCreditReport", desc = "资信NFCS报告facade")
    public String _nfcsFacade_queryCreditReport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/nfcsFacade/queryCreditStats", desc = "资信NFCS用户信用交叉计算数据facade")
    public String _nfcsFacade_queryCreditStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/outerFacade/orderPushOrderStatus", desc = "外部接口 - orderPushOrderStatus订单状态推送接口")
    public String _outerFacade_orderPushOrderStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tongdunFacade/tongDunQuery", desc = "同盾-query接口获取返回json")
    public String _tongdunFacade_tongDunQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/tongdunFacade/tongDunSubmit", desc = "同盾-submit接口获取返回json")
    public String _tongdunFacade_tongDunSubmit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/additionInfo", desc = "北斗平台 - additionInfo原始数据callback接口")
    public String _u51Facade_additionInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/bankCardResult", desc = "北斗平台 - bankCardResult绑卡结果反馈接口")
    public String _u51Facade_bankCardResult(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/baseInfo", desc = "北斗平台 - baseInfo原始数据callback接口")
    public String _u51Facade_baseInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/orderPushOrderStatus", desc = "北斗平台 - orderPushOrderStatus订单状态推送接口")
    public String _u51Facade_orderPushOrderStatus(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/orderSynPredit", desc = "北斗平台 - orderSynPredit审批结论反馈接口")
    public String _u51Facade_orderSynPredit(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/pullAdditionInfoData", desc = "北斗平台 - 补充信息拉取接口数据接口")
    public String _u51Facade_pullAdditionInfoData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/pullBaseInfoData", desc = "北斗平台-基本信息拉取接口合集")
    public String _u51Facade_pullBaseInfoData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/queryCarrierReport", desc = "北斗平台 - queryCarrierReport运营商交叉计算报告接口")
    public String _u51Facade_queryCarrierReport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/queryCarrierStats", desc = "北斗平台 - queryCarrierStats运营商交叉计算接口")
    public String _u51Facade_queryCarrierStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/queryCreditcardReport", desc = "北斗平台 - queryCreditcardReport信用卡交叉计算报告接口")
    public String _u51Facade_queryCreditcardReport(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/queryCreditcardStats", desc = "北斗平台 - queryCreditcardStats信用卡交叉计算接口")
    public String _u51Facade_queryCreditcardStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/queryMpfStats", desc = "北斗平台 - queryMpfStats公积金交叉计算接口")
    public String _u51Facade_queryMpfStats(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/repaymentPush", desc = "北斗平台 - repaymentPush还款计划推送接口")
    public String _u51Facade_repaymentPush(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/u51Facade/u51BaseInfoData", desc = "北斗平台 - u51BaseInfoData基础数据获取")
    public String _u51Facade_u51BaseInfoData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/whiteListFacade/putWhiteListData", desc = "白名单-导入白名单数据接口")
    public String _whiteListFacade_putWhiteListData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/whiteListFacade/queryWhiteListBlazeData", desc = "白名单- 获取blaze数据接口")
    public String _whiteListFacade_queryWhiteListBlazeData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/approachIntegration", desc = "世联评估自动估价-估价综合方法")
    public String _worldunionFacade_approachIntegration(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/approachManual", desc = "世联评估自动估价-通过案例号发起重评 此方法采用Get 方式提交，参数在URl中")
    public String _worldunionFacade_approachManual(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/areasById", desc = "世联评估自动估价-根据城市ID获取行政区域")
    public String _worldunionFacade_areasById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/citys", desc = "世联评估自动估价-获取所有城市信息")
    public String _worldunionFacade_citys(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/citysById", desc = "世联评估自动估价-根据省份获取城市")
    public String _worldunionFacade_citysById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/getBuild", desc = "世联评估自动估价-根据楼盘ID获取楼栋列表")
    public String _worldunionFacade_getBuild(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/getConstruction", desc = "世联评估自动估价-根据关键字(包含名称、别名、地址等)，城市ID 模糊检索该城市的楼盘列表")
    public String _worldunionFacade_getConstruction(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/getConstrutionViewInfoById", desc = "世联评估自动估价-根据楼盘ID获取楼盘详情")
    public String _worldunionFacade_getConstrutionViewInfoById(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/getHouse", desc = "世联评估自动估价-根据楼栋ID 获取该楼栋的全部房号信息")
    public String _worldunionFacade_getHouse(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/getQueryPrice", desc = "世联评估自动估价-获取地址拆分自动估价结果")
    public String _worldunionFacade_getQueryPrice(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/worldunionFacade/provinces", desc = "世联评估自动估价-获取所有省份信息")
    public String _worldunionFacade_provinces(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yinLianFacade/queryCreditcardData", desc = "银联统一信用卡facade")
    public String _yinLianFacade_queryCreditcardData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yinLianFacade/queryData", desc = "银联统一facade")
    public String _yinLianFacade_queryData(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yirenFacade/queryDate", desc = "宜人-公积金接口")
    public String _yirenFacade_queryDate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yirenFacade/queryDateDetail", desc = "宜人-公积金Detail数据接口")
    public String _yirenFacade_queryDateDetail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yirenFacade/queryDateInfo", desc = "宜人-公积金Info数据接口")
    public String _yirenFacade_queryDateInfo(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/yirenFacade/yirenMpfCallbackBill", desc = "宜人-公积金Bill持久化facade")
    public String _yirenFacade_yirenMpfCallbackBill(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/auth", desc = "芝麻授权")
    public String _zhimaFacade_auth(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/authQuery", desc = "芝麻授权查询")
    public String _zhimaFacade_authQuery(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/queryAntifraudRiskList", desc = "欺诈关注清单查询")
    public String _zhimaFacade_queryAntifraudRiskList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/queryAntifraudScore", desc = "芝麻申请反欺诈分查询")
    public String _zhimaFacade_queryAntifraudScore(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/queryCreditScore", desc = "芝麻信用分查询")
    public String _zhimaFacade_queryCreditScore(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/queryCreditWatchlistii", desc = "行业关注名单查询")
    public String _zhimaFacade_queryCreditWatchlistii(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/zhimaFacade/verifyAntifraud", desc = "欺诈信息验证")
    public String _zhimaFacade_verifyAntifraud(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
