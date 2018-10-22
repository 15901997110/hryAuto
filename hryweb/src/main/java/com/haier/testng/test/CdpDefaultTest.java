package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.CdpBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: CdpDefaultTest
 * @Author: 自动生成
 * @Date: 2018/10/22 15:52:34
 */
@Slf4j
public class CdpDefaultTest extends CdpBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public CdpDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/baiduFacade/queryBlackRiskLevel", dataProvider = "provider", description = "百度-磐石系统-黑名单风险等级")
    public void baiduFacade_queryBlackRiskLevel(HryTest hryTest) {
        String actual = super._baiduFacade_queryBlackRiskLevel(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/bairongFacade/riskStrategy", dataProvider = "provider", description = "百融-策略引擎-实名反欺诈")
    public void bairongFacade_riskStrategy(HryTest hryTest) {
        String actual = super._bairongFacade_riskStrategy(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/echoFacade/queryEchoInfo", dataProvider = "provider", description = "阿福平台共享数据查询")
    public void echoFacade_queryEchoInfo(HryTest hryTest) {
        String actual = super._echoFacade_queryEchoInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/echoFacade/queryRiskInfo", dataProvider = "provider", description = "宜信风险名单查询")
    public void echoFacade_queryRiskInfo(HryTest hryTest) {
        String actual = super._echoFacade_queryRiskInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/echoFacade/queryShareInfo", dataProvider = "provider", description = "共享数据查询（数据由我方提供，接口由宜信调用）")
    public void echoFacade_queryShareInfo(HryTest hryTest) {
        String actual = super._echoFacade_queryShareInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/esFacade/queryContactsStats", dataProvider = "provider", description = "ES-BI计算数据-设备计算数据")
    public void esFacade_queryContactsStats(HryTest hryTest) {
        String actual = super._esFacade_queryContactsStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/esFacade/queryEquipmentData", dataProvider = "provider", description = "ES-BI计算数据-设备计算数据")
    public void esFacade_queryEquipmentData(HryTest hryTest) {
        String actual = super._esFacade_queryEquipmentData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/hairyGatewayFacade/queryData", dataProvider = "provider", description = "海融易网关统一facade")
    public void hairyGatewayFacade_queryData(HryTest hryTest) {
        String actual = super._hairyGatewayFacade_queryData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/kjtPayFacade/queryData", dataProvider = "provider", description = "快捷通统一facade")
    public void kjtPayFacade_queryData(HryTest hryTest) {
        String actual = super._kjtPayFacade_queryData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieCallBackFacade/allbill", dataProvider = "provider", description = "摩羯-异步回调Allbill持久化facade")
    public void moxieCallBackFacade_allbill(HryTest hryTest) {
        String actual = super._moxieCallBackFacade_allbill(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieCallBackFacade/bill", dataProvider = "provider", description = "摩羯-异步回调Bill持久化facade")
    public void moxieCallBackFacade_bill(HryTest hryTest) {
        String actual = super._moxieCallBackFacade_bill(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieCallBackFacade/report", dataProvider = "provider", description = "摩羯-异步回调Report持久化facade")
    public void moxieCallBackFacade_report(HryTest hryTest) {
        String actual = super._moxieCallBackFacade_report(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieCallBackFacade/task", dataProvider = "provider", description = "摩羯-异步回调Task持久化facade")
    public void moxieCallBackFacade_task(HryTest hryTest) {
        String actual = super._moxieCallBackFacade_task(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieCallBackFacade/task/submit", dataProvider = "provider", description = "摩羯-异步回调TaskSubmit持久化facade")
    public void moxieCallBackFacade_task_submit(HryTest hryTest) {
        String actual = super._moxieCallBackFacade_task_submit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieFacade/carrier/pushCarrierMobilesDataToKafka", dataProvider = "provider", description = "摩羯-运营商-获取运营商原始数据(推送BI的Kafka)facade")
    public void moxieFacade_carrier_pushCarrierMobilesDataToKafka(HryTest hryTest) {
        String actual = super._moxieFacade_carrier_pushCarrierMobilesDataToKafka(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieFacade/carrier/queryCarrierMobilesData", dataProvider = "provider", description = "摩羯-运营商-获取运营商原始数据衍生计算数据(含通话详单采集结果)facade")
    public void moxieFacade_carrier_queryCarrierMobilesData(HryTest hryTest) {
        String actual = super._moxieFacade_carrier_queryCarrierMobilesData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieFacade/carrier/queryCarrierMobilesDataStats", dataProvider = "provider", description = "摩羯-运营商-获取运营商原始数据(交叉统计数据)facade")
    public void moxieFacade_carrier_queryCarrierMobilesDataStats(HryTest hryTest) {
        String actual = super._moxieFacade_carrier_queryCarrierMobilesDataStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieFacade/carrier/queryCarrierMxreportData", dataProvider = "provider", description = "摩羯-运营商-获取运营商数据报表facade")
    public void moxieFacade_carrier_queryCarrierMxreportData(HryTest hryTest) {
        String actual = super._moxieFacade_carrier_queryCarrierMxreportData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/moxieFacade/carrier/queryCarrierReportData", dataProvider = "provider", description = "摩羯-运营商-获取运营商数据报表(报表URL和HTML数据)facade")
    public void moxieFacade_carrier_queryCarrierReportData(HryTest hryTest) {
        String actual = super._moxieFacade_carrier_queryCarrierReportData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nfcsFacade/queryCredit", dataProvider = "provider", description = "资信NFCS用户信用facade")
    public void nfcsFacade_queryCredit(HryTest hryTest) {
        String actual = super._nfcsFacade_queryCredit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nfcsFacade/queryCreditReport", dataProvider = "provider", description = "资信NFCS报告facade")
    public void nfcsFacade_queryCreditReport(HryTest hryTest) {
        String actual = super._nfcsFacade_queryCreditReport(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/nfcsFacade/queryCreditStats", dataProvider = "provider", description = "资信NFCS用户信用交叉计算数据facade")
    public void nfcsFacade_queryCreditStats(HryTest hryTest) {
        String actual = super._nfcsFacade_queryCreditStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/outerFacade/orderPushOrderStatus", dataProvider = "provider", description = "外部接口 - orderPushOrderStatus订单状态推送接口")
    public void outerFacade_orderPushOrderStatus(HryTest hryTest) {
        String actual = super._outerFacade_orderPushOrderStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tongdunFacade/tongDunQuery", dataProvider = "provider", description = "同盾-query接口获取返回json")
    public void tongdunFacade_tongDunQuery(HryTest hryTest) {
        String actual = super._tongdunFacade_tongDunQuery(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/tongdunFacade/tongDunSubmit", dataProvider = "provider", description = "同盾-submit接口获取返回json")
    public void tongdunFacade_tongDunSubmit(HryTest hryTest) {
        String actual = super._tongdunFacade_tongDunSubmit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/additionInfo", dataProvider = "provider", description = "北斗平台 - additionInfo原始数据callback接口")
    public void u51Facade_additionInfo(HryTest hryTest) {
        String actual = super._u51Facade_additionInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/bankCardResult", dataProvider = "provider", description = "北斗平台 - bankCardResult绑卡结果反馈接口")
    public void u51Facade_bankCardResult(HryTest hryTest) {
        String actual = super._u51Facade_bankCardResult(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/baseInfo", dataProvider = "provider", description = "北斗平台 - baseInfo原始数据callback接口")
    public void u51Facade_baseInfo(HryTest hryTest) {
        String actual = super._u51Facade_baseInfo(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/orderPushOrderStatus", dataProvider = "provider", description = "北斗平台 - orderPushOrderStatus订单状态推送接口")
    public void u51Facade_orderPushOrderStatus(HryTest hryTest) {
        String actual = super._u51Facade_orderPushOrderStatus(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/orderSynPredit", dataProvider = "provider", description = "北斗平台 - orderSynPredit审批结论反馈接口")
    public void u51Facade_orderSynPredit(HryTest hryTest) {
        String actual = super._u51Facade_orderSynPredit(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/pullAdditionInfoData", dataProvider = "provider", description = "北斗平台 - 补充信息拉取接口数据接口")
    public void u51Facade_pullAdditionInfoData(HryTest hryTest) {
        String actual = super._u51Facade_pullAdditionInfoData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/pullBaseInfoData", dataProvider = "provider", description = "北斗平台-基本信息拉取接口合集")
    public void u51Facade_pullBaseInfoData(HryTest hryTest) {
        String actual = super._u51Facade_pullBaseInfoData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/queryCarrierReport", dataProvider = "provider", description = "北斗平台 - queryCarrierReport运营商交叉计算报告接口")
    public void u51Facade_queryCarrierReport(HryTest hryTest) {
        String actual = super._u51Facade_queryCarrierReport(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/queryCarrierStats", dataProvider = "provider", description = "北斗平台 - queryCarrierStats运营商交叉计算接口")
    public void u51Facade_queryCarrierStats(HryTest hryTest) {
        String actual = super._u51Facade_queryCarrierStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/queryCreditcardReport", dataProvider = "provider", description = "北斗平台 - queryCreditcardReport信用卡交叉计算报告接口")
    public void u51Facade_queryCreditcardReport(HryTest hryTest) {
        String actual = super._u51Facade_queryCreditcardReport(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/queryCreditcardStats", dataProvider = "provider", description = "北斗平台 - queryCreditcardStats信用卡交叉计算接口")
    public void u51Facade_queryCreditcardStats(HryTest hryTest) {
        String actual = super._u51Facade_queryCreditcardStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/queryMpfStats", dataProvider = "provider", description = "北斗平台 - queryMpfStats公积金交叉计算接口")
    public void u51Facade_queryMpfStats(HryTest hryTest) {
        String actual = super._u51Facade_queryMpfStats(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/repaymentPush", dataProvider = "provider", description = "北斗平台 - repaymentPush还款计划推送接口")
    public void u51Facade_repaymentPush(HryTest hryTest) {
        String actual = super._u51Facade_repaymentPush(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/u51Facade/u51BaseInfoData", dataProvider = "provider", description = "北斗平台 - u51BaseInfoData基础数据获取")
    public void u51Facade_u51BaseInfoData(HryTest hryTest) {
        String actual = super._u51Facade_u51BaseInfoData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/whiteListFacade/putWhiteListData", dataProvider = "provider", description = "白名单-导入白名单数据接口")
    public void whiteListFacade_putWhiteListData(HryTest hryTest) {
        String actual = super._whiteListFacade_putWhiteListData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/whiteListFacade/queryWhiteListBlazeData", dataProvider = "provider", description = "白名单- 获取blaze数据接口")
    public void whiteListFacade_queryWhiteListBlazeData(HryTest hryTest) {
        String actual = super._whiteListFacade_queryWhiteListBlazeData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/approachIntegration", dataProvider = "provider", description = "世联评估自动估价-估价综合方法")
    public void worldunionFacade_approachIntegration(HryTest hryTest) {
        String actual = super._worldunionFacade_approachIntegration(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/approachManual", dataProvider = "provider", description = "世联评估自动估价-通过案例号发起重评 此方法采用Get 方式提交，参数在URl中")
    public void worldunionFacade_approachManual(HryTest hryTest) {
        String actual = super._worldunionFacade_approachManual(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/areasById", dataProvider = "provider", description = "世联评估自动估价-根据城市ID获取行政区域")
    public void worldunionFacade_areasById(HryTest hryTest) {
        String actual = super._worldunionFacade_areasById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/citys", dataProvider = "provider", description = "世联评估自动估价-获取所有城市信息")
    public void worldunionFacade_citys(HryTest hryTest) {
        String actual = super._worldunionFacade_citys(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/citysById", dataProvider = "provider", description = "世联评估自动估价-根据省份获取城市")
    public void worldunionFacade_citysById(HryTest hryTest) {
        String actual = super._worldunionFacade_citysById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/getBuild", dataProvider = "provider", description = "世联评估自动估价-根据楼盘ID获取楼栋列表")
    public void worldunionFacade_getBuild(HryTest hryTest) {
        String actual = super._worldunionFacade_getBuild(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/getConstruction", dataProvider = "provider", description = "世联评估自动估价-根据关键字(包含名称、别名、地址等)，城市ID 模糊检索该城市的楼盘列表")
    public void worldunionFacade_getConstruction(HryTest hryTest) {
        String actual = super._worldunionFacade_getConstruction(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/getConstrutionViewInfoById", dataProvider = "provider", description = "世联评估自动估价-根据楼盘ID获取楼盘详情")
    public void worldunionFacade_getConstrutionViewInfoById(HryTest hryTest) {
        String actual = super._worldunionFacade_getConstrutionViewInfoById(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/getHouse", dataProvider = "provider", description = "世联评估自动估价-根据楼栋ID 获取该楼栋的全部房号信息")
    public void worldunionFacade_getHouse(HryTest hryTest) {
        String actual = super._worldunionFacade_getHouse(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/getQueryPriceData", dataProvider = "provider", description = "世联评估自动估价-获取地址拆分自动估价结果")
    public void worldunionFacade_getQueryPriceData(HryTest hryTest) {
        String actual = super._worldunionFacade_getQueryPriceData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/worldunionFacade/provinces", dataProvider = "provider", description = "世联评估自动估价-获取所有省份信息")
    public void worldunionFacade_provinces(HryTest hryTest) {
        String actual = super._worldunionFacade_provinces(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yinLianFacade/queryCreditcardData", dataProvider = "provider", description = "银联统一信用卡facade")
    public void yinLianFacade_queryCreditcardData(HryTest hryTest) {
        String actual = super._yinLianFacade_queryCreditcardData(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/yinLianFacade/queryData", dataProvider = "provider", description = "银联统一facade")
    public void yinLianFacade_queryData(HryTest hryTest) {
        String actual = super._yinLianFacade_queryData(hryTest);
        supperAssert(actual, hryTest);
    }

}
