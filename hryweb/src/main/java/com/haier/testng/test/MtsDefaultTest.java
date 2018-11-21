package com.haier.testng.test;

import com.haier.anno.SKey;
import com.haier.po.HryTest;
import com.haier.testng.base.Base;
import com.haier.util.HryHttpClientUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.haier.util.AssertUtil.supperAssert;
@SKey("Mts")
public class MtsDefaultTest extends Base{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy", "testingId"})
    public MtsDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Test(testName = "/emailFacade/queryEmail", dataProvider = "provider", description = "查询邮件信息详情")
    public void emailFacade_queryEmail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/emailFacade/queryEmailAttachment", dataProvider = "provider", description = "查询邮件附件")
    public void emailFacade_queryEmailAttachment(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/emailFacade/queryEmailList", dataProvider = "provider", description = "查询邮件信息列表")
    public void emailFacade_queryEmailList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/emailFacade/resendEmail", dataProvider = "provider", description = "重新发送邮件")
    public void emailFacade_resendEmail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/emailFacade/sendEmail", dataProvider = "provider", description = "发送邮件,不使用邮件模板")
    public void emailFacade_sendEmail(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/emailFacade/sendEmailUseTemplate", dataProvider = "provider", description = "发送邮件,使用邮件模板")
    public void emailFacade_sendEmailUseTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/addMessageDictionary", dataProvider = "provider", description = "新增错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_addMessageDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/deleteMessageDictionary", dataProvider = "provider", description = "删除错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_deleteMessageDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/getMessageDictionary", dataProvider = "provider", description = "按主键id条件查询错误信息")
    public void messageDictionaryFacade_getMessageDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionary", dataProvider = "provider", description = "根据请求查询错误信息内容，仅供后台使用")
    public void messageDictionaryFacade_queryMessageDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionaryByCode", dataProvider = "provider", description = "按条件查询错误信息")
    public void messageDictionaryFacade_queryMessageDictionaryByCode(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionaryByProjectName", dataProvider = "provider", description = "按条件查询错误信息")
    public void messageDictionaryFacade_queryMessageDictionaryByProjectName(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/messageDictionaryFacade/updateMessageDictionary", dataProvider = "provider", description = "更新错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_updateMessageDictionary(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mqFacade/queryMq", dataProvider = "provider", description = "查询Mq信息详情")
    public void mqFacade_queryMq(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mqFacade/queryMqList", dataProvider = "provider", description = "查询Mq信息列表详情")
    public void mqFacade_queryMqList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mqFacade/resendMq", dataProvider = "provider", description = "重新发送Mq消息")
    public void mqFacade_resendMq(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/mqFacade/sendMq", dataProvider = "provider", description = "向消息队列内推送消息")
    public void mqFacade_sendMq(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/querySms", dataProvider = "provider", description = "查询消息信息详情")
    public void smsFacade_querySms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/querySmsList", dataProvider = "provider", description = "查询消息信息列表")
    public void smsFacade_querySmsList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/querySmsRecord", dataProvider = "provider", description = "查询短信响应详情")
    public void smsFacade_querySmsRecord(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/resendSms", dataProvider = "provider", description = "重新发送消息")
    public void smsFacade_resendSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/sendBatchSms", dataProvider = "provider", description = "批量发送短信,不使用短信模板")
    public void smsFacade_sendBatchSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/sendBatchSmsUseTemplate", dataProvider = "provider", description = "批量发送短信,使用短信模板")
    public void smsFacade_sendBatchSmsUseTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/sendSms", dataProvider = "provider", description = "单个发送短信,不使用短信模板")
    public void smsFacade_sendSms(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/smsFacade/sendSmsUseTemplate", dataProvider = "provider", description = "单个发送短信,使用短信模板")
    public void smsFacade_sendSmsUseTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/templateFacade/createTemplate", dataProvider = "provider", description = "创建模板")
    public void templateFacade_createTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/templateFacade/deleteTemplate", dataProvider = "provider", description = "删除模板")
    public void templateFacade_deleteTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/templateFacade/queryTemplate", dataProvider = "provider", description = "获取模板相信信息")
    public void templateFacade_queryTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/templateFacade/queryTemplateList", dataProvider = "provider", description = "查询模板列表信息详情")
    public void templateFacade_queryTemplateList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/templateFacade/updateTemplate", dataProvider = "provider", description = "修改模板")
    public void templateFacade_updateTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatAlarmFacade/queryWechatAlarm", dataProvider = "provider", description = "查询微信报警信息详情")
    public void wechatAlarmFacade_queryWechatAlarm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatAlarmFacade/queryWechatAlarmList", dataProvider = "provider", description = "查询微信报警信息列表")
    public void wechatAlarmFacade_queryWechatAlarmList(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatAlarmFacade/sendWechatAlarm", dataProvider = "provider", description = "发送微信报警,不使用模板")
    public void wechatAlarmFacade_sendWechatAlarm(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatAlarmFacade/sendWechatAlarmUseTemplate", dataProvider = "provider", description = "发送微信报警,使用模板")
    public void wechatAlarmFacade_sendWechatAlarmUseTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/addWechatMessageTemplate", dataProvider = "provider", description = "新增微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_addWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/deleteWechatMessageTemplate", dataProvider = "provider", description = "删除微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_deleteWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/fetchWechatMessageTemplate", dataProvider = "provider", description = "查询微信公众号中配置的消息模版列表")
    public void wechatPublicAccountFacade_fetchWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/getWechatAccessToken", dataProvider = "provider", description = "获取微信公众号access_token")
    public void wechatPublicAccountFacade_getWechatAccessToken(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/getWechatMessageTemplate", dataProvider = "provider", description = "查看mts已配置的微信公众号消息模版详情")
    public void wechatPublicAccountFacade_getWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/queryWechatMessageTemplate", dataProvider = "provider", description = "查询mts已配置的微信公众号消息模版列表")
    public void wechatPublicAccountFacade_queryWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/sendWechatTemplateMessage", dataProvider = "provider", description = "发送微信公众号模版消息")
    public void wechatPublicAccountFacade_sendWechatTemplateMessage(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

    @Test(testName = "/wechatPublicAccountFacade/updateWechatMessageTemplate", dataProvider = "provider", description = "修改微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_updateWechatMessageTemplate(HryTest test) {
        String actual = HryHttpClientUtil.send(test, this);
        supperAssert(actual, test);
    }

}
