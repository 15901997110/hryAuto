package com.haier.testng.test;

import com.haier.po.HryTest;
import com.haier.testng.base.MtsBase;
import static com.haier.util.AssertUtil.supperAssert;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @Description: MtsDefaultTest
 * @Author: 自动生成
 * @Date: 2018/11/06 16:53:31
 */
@Slf4j
public class MtsDefaultTest extends MtsBase{
    @Parameters({"serviceId", "envId", "caseDesigner", "i_c", "i_c_zdy" ,"testingId"})
    public MtsDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @DataProvider(name = "provider")
    public Object[] getCase(Method method) {
        return provider(method);
    }

    @Test(testName = "/emailFacade/queryEmail", dataProvider = "provider", description = "查询邮件信息详情")
    public void emailFacade_queryEmail(HryTest hryTest) {
        String actual = super._emailFacade_queryEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/emailFacade/queryEmailAttachment", dataProvider = "provider", description = "查询邮件附件")
    public void emailFacade_queryEmailAttachment(HryTest hryTest) {
        String actual = super._emailFacade_queryEmailAttachment(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/emailFacade/queryEmailList", dataProvider = "provider", description = "查询邮件信息列表")
    public void emailFacade_queryEmailList(HryTest hryTest) {
        String actual = super._emailFacade_queryEmailList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/emailFacade/resendEmail", dataProvider = "provider", description = "重新发送邮件")
    public void emailFacade_resendEmail(HryTest hryTest) {
        String actual = super._emailFacade_resendEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/emailFacade/sendEmail", dataProvider = "provider", description = "发送邮件,不使用邮件模板")
    public void emailFacade_sendEmail(HryTest hryTest) {
        String actual = super._emailFacade_sendEmail(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/emailFacade/sendEmailUseTemplate", dataProvider = "provider", description = "发送邮件,使用邮件模板")
    public void emailFacade_sendEmailUseTemplate(HryTest hryTest) {
        String actual = super._emailFacade_sendEmailUseTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/addMessageDictionary", dataProvider = "provider", description = "新增错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_addMessageDictionary(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_addMessageDictionary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/deleteMessageDictionary", dataProvider = "provider", description = "删除错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_deleteMessageDictionary(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_deleteMessageDictionary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/getMessageDictionary", dataProvider = "provider", description = "按主键id条件查询错误信息")
    public void messageDictionaryFacade_getMessageDictionary(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_getMessageDictionary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionary", dataProvider = "provider", description = "根据请求查询错误信息内容，仅供后台使用")
    public void messageDictionaryFacade_queryMessageDictionary(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_queryMessageDictionary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionaryByCode", dataProvider = "provider", description = "按条件查询错误信息")
    public void messageDictionaryFacade_queryMessageDictionaryByCode(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_queryMessageDictionaryByCode(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/queryMessageDictionaryByProjectName", dataProvider = "provider", description = "按条件查询错误信息")
    public void messageDictionaryFacade_queryMessageDictionaryByProjectName(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_queryMessageDictionaryByProjectName(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/messageDictionaryFacade/updateMessageDictionary", dataProvider = "provider", description = "更新错误信息内容,仅供后台使用")
    public void messageDictionaryFacade_updateMessageDictionary(HryTest hryTest) {
        String actual = super._messageDictionaryFacade_updateMessageDictionary(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mqFacade/queryMq", dataProvider = "provider", description = "查询Mq信息详情")
    public void mqFacade_queryMq(HryTest hryTest) {
        String actual = super._mqFacade_queryMq(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mqFacade/queryMqList", dataProvider = "provider", description = "查询Mq信息列表详情")
    public void mqFacade_queryMqList(HryTest hryTest) {
        String actual = super._mqFacade_queryMqList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mqFacade/resendMq", dataProvider = "provider", description = "重新发送Mq消息")
    public void mqFacade_resendMq(HryTest hryTest) {
        String actual = super._mqFacade_resendMq(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/mqFacade/sendMq", dataProvider = "provider", description = "向消息队列内推送消息")
    public void mqFacade_sendMq(HryTest hryTest) {
        String actual = super._mqFacade_sendMq(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/querySms", dataProvider = "provider", description = "查询消息信息详情")
    public void smsFacade_querySms(HryTest hryTest) {
        String actual = super._smsFacade_querySms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/querySmsList", dataProvider = "provider", description = "查询消息信息列表")
    public void smsFacade_querySmsList(HryTest hryTest) {
        String actual = super._smsFacade_querySmsList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/querySmsRecord", dataProvider = "provider", description = "查询短信响应详情")
    public void smsFacade_querySmsRecord(HryTest hryTest) {
        String actual = super._smsFacade_querySmsRecord(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/resendSms", dataProvider = "provider", description = "重新发送消息")
    public void smsFacade_resendSms(HryTest hryTest) {
        String actual = super._smsFacade_resendSms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/sendBatchSms", dataProvider = "provider", description = "批量发送短信,不使用短信模板")
    public void smsFacade_sendBatchSms(HryTest hryTest) {
        String actual = super._smsFacade_sendBatchSms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/sendBatchSmsUseTemplate", dataProvider = "provider", description = "批量发送短信,使用短信模板")
    public void smsFacade_sendBatchSmsUseTemplate(HryTest hryTest) {
        String actual = super._smsFacade_sendBatchSmsUseTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/sendSms", dataProvider = "provider", description = "单个发送短信,不使用短信模板")
    public void smsFacade_sendSms(HryTest hryTest) {
        String actual = super._smsFacade_sendSms(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/smsFacade/sendSmsUseTemplate", dataProvider = "provider", description = "单个发送短信,使用短信模板")
    public void smsFacade_sendSmsUseTemplate(HryTest hryTest) {
        String actual = super._smsFacade_sendSmsUseTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/templateFacade/createTemplate", dataProvider = "provider", description = "创建模板")
    public void templateFacade_createTemplate(HryTest hryTest) {
        String actual = super._templateFacade_createTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/templateFacade/deleteTemplate", dataProvider = "provider", description = "删除模板")
    public void templateFacade_deleteTemplate(HryTest hryTest) {
        String actual = super._templateFacade_deleteTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/templateFacade/queryTemplate", dataProvider = "provider", description = "获取模板相信信息")
    public void templateFacade_queryTemplate(HryTest hryTest) {
        String actual = super._templateFacade_queryTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/templateFacade/queryTemplateList", dataProvider = "provider", description = "查询模板列表信息详情")
    public void templateFacade_queryTemplateList(HryTest hryTest) {
        String actual = super._templateFacade_queryTemplateList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/templateFacade/updateTemplate", dataProvider = "provider", description = "修改模板")
    public void templateFacade_updateTemplate(HryTest hryTest) {
        String actual = super._templateFacade_updateTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatAlarmFacade/queryWechatAlarm", dataProvider = "provider", description = "查询微信报警信息详情")
    public void wechatAlarmFacade_queryWechatAlarm(HryTest hryTest) {
        String actual = super._wechatAlarmFacade_queryWechatAlarm(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatAlarmFacade/queryWechatAlarmList", dataProvider = "provider", description = "查询微信报警信息列表")
    public void wechatAlarmFacade_queryWechatAlarmList(HryTest hryTest) {
        String actual = super._wechatAlarmFacade_queryWechatAlarmList(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatAlarmFacade/sendWechatAlarm", dataProvider = "provider", description = "发送微信报警,不使用模板")
    public void wechatAlarmFacade_sendWechatAlarm(HryTest hryTest) {
        String actual = super._wechatAlarmFacade_sendWechatAlarm(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatAlarmFacade/sendWechatAlarmUseTemplate", dataProvider = "provider", description = "发送微信报警,使用模板")
    public void wechatAlarmFacade_sendWechatAlarmUseTemplate(HryTest hryTest) {
        String actual = super._wechatAlarmFacade_sendWechatAlarmUseTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/addWechatMessageTemplate", dataProvider = "provider", description = "新增微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_addWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_addWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/deleteWechatMessageTemplate", dataProvider = "provider", description = "删除微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_deleteWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_deleteWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/fetchWechatMessageTemplate", dataProvider = "provider", description = "查询微信公众号中配置的消息模版列表")
    public void wechatPublicAccountFacade_fetchWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_fetchWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/getWechatAccessToken", dataProvider = "provider", description = "获取微信公众号access_token")
    public void wechatPublicAccountFacade_getWechatAccessToken(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_getWechatAccessToken(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/getWechatMessageTemplate", dataProvider = "provider", description = "查看mts已配置的微信公众号消息模版详情")
    public void wechatPublicAccountFacade_getWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_getWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/queryWechatMessageTemplate", dataProvider = "provider", description = "查询mts已配置的微信公众号消息模版列表")
    public void wechatPublicAccountFacade_queryWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_queryWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/sendWechatTemplateMessage", dataProvider = "provider", description = "发送微信公众号模版消息")
    public void wechatPublicAccountFacade_sendWechatTemplateMessage(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_sendWechatTemplateMessage(hryTest);
        supperAssert(actual, hryTest);
    }

    @Test(testName = "/wechatPublicAccountFacade/updateWechatMessageTemplate", dataProvider = "provider", description = "修改微信公众号消息模版,系统内部使用的模版")
    public void wechatPublicAccountFacade_updateWechatMessageTemplate(HryTest hryTest) {
        String actual = super._wechatPublicAccountFacade_updateWechatMessageTemplate(hryTest);
        supperAssert(actual, hryTest);
    }

}
