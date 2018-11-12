package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: MtsBase
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@SKey("Mts")
public class MtsBase extends Base {
    public MtsBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/emailFacade/queryEmail", desc = "查询邮件信息详情")
    public String _emailFacade_queryEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/emailFacade/queryEmailAttachment", desc = "查询邮件附件")
    public String _emailFacade_queryEmailAttachment(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/emailFacade/queryEmailList", desc = "查询邮件信息列表")
    public String _emailFacade_queryEmailList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/emailFacade/resendEmail", desc = "重新发送邮件")
    public String _emailFacade_resendEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/emailFacade/sendEmail", desc = "发送邮件,不使用邮件模板")
    public String _emailFacade_sendEmail(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/emailFacade/sendEmailUseTemplate", desc = "发送邮件,使用邮件模板")
    public String _emailFacade_sendEmailUseTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/addMessageDictionary", desc = "新增错误信息内容,仅供后台使用")
    public String _messageDictionaryFacade_addMessageDictionary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/deleteMessageDictionary", desc = "删除错误信息内容,仅供后台使用")
    public String _messageDictionaryFacade_deleteMessageDictionary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/getMessageDictionary", desc = "按主键id条件查询错误信息")
    public String _messageDictionaryFacade_getMessageDictionary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/queryMessageDictionary", desc = "根据请求查询错误信息内容，仅供后台使用")
    public String _messageDictionaryFacade_queryMessageDictionary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/queryMessageDictionaryByCode", desc = "按条件查询错误信息")
    public String _messageDictionaryFacade_queryMessageDictionaryByCode(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/queryMessageDictionaryByProjectName", desc = "按条件查询错误信息")
    public String _messageDictionaryFacade_queryMessageDictionaryByProjectName(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/messageDictionaryFacade/updateMessageDictionary", desc = "更新错误信息内容,仅供后台使用")
    public String _messageDictionaryFacade_updateMessageDictionary(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mqFacade/queryMq", desc = "查询Mq信息详情")
    public String _mqFacade_queryMq(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mqFacade/queryMqList", desc = "查询Mq信息列表详情")
    public String _mqFacade_queryMqList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mqFacade/resendMq", desc = "重新发送Mq消息")
    public String _mqFacade_resendMq(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/mqFacade/sendMq", desc = "向消息队列内推送消息")
    public String _mqFacade_sendMq(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/querySms", desc = "查询消息信息详情")
    public String _smsFacade_querySms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/querySmsList", desc = "查询消息信息列表")
    public String _smsFacade_querySmsList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/querySmsRecord", desc = "查询短信响应详情")
    public String _smsFacade_querySmsRecord(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/resendSms", desc = "重新发送消息")
    public String _smsFacade_resendSms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/sendBatchSms", desc = "批量发送短信,不使用短信模板")
    public String _smsFacade_sendBatchSms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/sendBatchSmsUseTemplate", desc = "批量发送短信,使用短信模板")
    public String _smsFacade_sendBatchSmsUseTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/sendSms", desc = "单个发送短信,不使用短信模板")
    public String _smsFacade_sendSms(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/smsFacade/sendSmsUseTemplate", desc = "单个发送短信,使用短信模板")
    public String _smsFacade_sendSmsUseTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/templateFacade/createTemplate", desc = "创建模板")
    public String _templateFacade_createTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/templateFacade/deleteTemplate", desc = "删除模板")
    public String _templateFacade_deleteTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/templateFacade/queryTemplate", desc = "获取模板相信信息")
    public String _templateFacade_queryTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/templateFacade/queryTemplateList", desc = "查询模板列表信息详情")
    public String _templateFacade_queryTemplateList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/templateFacade/updateTemplate", desc = "修改模板")
    public String _templateFacade_updateTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatAlarmFacade/queryWechatAlarm", desc = "查询微信报警信息详情")
    public String _wechatAlarmFacade_queryWechatAlarm(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatAlarmFacade/queryWechatAlarmList", desc = "查询微信报警信息列表")
    public String _wechatAlarmFacade_queryWechatAlarmList(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatAlarmFacade/sendWechatAlarm", desc = "发送微信报警,不使用模板")
    public String _wechatAlarmFacade_sendWechatAlarm(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatAlarmFacade/sendWechatAlarmUseTemplate", desc = "发送微信报警,使用模板")
    public String _wechatAlarmFacade_sendWechatAlarmUseTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/addWechatMessageTemplate", desc = "新增微信公众号消息模版,系统内部使用的模版")
    public String _wechatPublicAccountFacade_addWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/deleteWechatMessageTemplate", desc = "删除微信公众号消息模版,系统内部使用的模版")
    public String _wechatPublicAccountFacade_deleteWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/fetchWechatMessageTemplate", desc = "查询微信公众号中配置的消息模版列表")
    public String _wechatPublicAccountFacade_fetchWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/getWechatAccessToken", desc = "获取微信公众号access_token")
    public String _wechatPublicAccountFacade_getWechatAccessToken(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/getWechatMessageTemplate", desc = "查看mts已配置的微信公众号消息模版详情")
    public String _wechatPublicAccountFacade_getWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/queryWechatMessageTemplate", desc = "查询mts已配置的微信公众号消息模版列表")
    public String _wechatPublicAccountFacade_queryWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/sendWechatTemplateMessage", desc = "发送微信公众号模版消息")
    public String _wechatPublicAccountFacade_sendWechatTemplateMessage(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/wechatPublicAccountFacade/updateWechatMessageTemplate", desc = "修改微信公众号消息模版,系统内部使用的模版")
    public String _wechatPublicAccountFacade_updateWechatMessageTemplate(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
