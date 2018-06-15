package com.haier.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.ImportInterfaceResult;
import com.haier.po.Tenvdetail;
import com.haier.response.Result;
import com.haier.service.ImportService;
import com.haier.service.TenvdetailService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/18 19:00
 */
@RestController
@Slf4j
@RequestMapping("/import")
public class ImportController {
    @Autowired
    ImportService importService;
    @Autowired
    TenvdetailService tenvdetailService;

    @PostMapping("/interfaceImport")
    public Result interfaceImport(
            @RequestParam("serviceId") Integer serviceId,//服务id,必填
            @RequestParam("envId") Integer envId,//环境id,必填
            Boolean overwrite,//是否覆盖已经存在的记录
            //String sEditor,//服务维护者,传测试人员realName或者当前登录人realName
            String iDev//此服务下接口开发人员的realName
    ) {
        if (serviceId == null || envId == null || serviceId == 0 || envId == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "serviceId,envId必填");
        }
        if (overwrite == null) {
            overwrite = false;
        }
        /**
         * 现在选择服务 ,已经不需要服务维护者参数
         */
/*        if(sEditor==null||"".equals(sEditor.trim())){
            sEditor="自动导入";
        }else{
            sEditor=sEditor.trim();
        }*/
        if (iDev == null || "".equals(iDev)) {
            iDev = "自动导入";
        } else {
            iDev = iDev.trim();
        }


        //1.通过serviceId和envId找到swaggerUrl
        Tenvdetail tenvdetail = new Tenvdetail();
        tenvdetail.setServiceid(serviceId);
        tenvdetail.setEnvid(envId);
        String swaggerUrl = null;
        List<Tenvdetail> tenvdetailList = tenvdetailService.selectByCondition(tenvdetail);
        if (tenvdetailList != null && tenvdetailList.size() > 0) {
            //查询到记录,应该有且只有一条记录,否则就是脏数据
            swaggerUrl = tenvdetailList.get(0).getSwaggerurl();
            if (swaggerUrl == null || "".equals(swaggerUrl.trim())) {
                throw new HryException(38, "serviceId=" + serviceId + ",envId=" + envId + "对应的swagger地址为空,请先维护tenvdetail信息");
            } else {
                swaggerUrl = swaggerUrl.trim();
            }
        } else {
            //未查询到记录
            throw new HryException(StatusCodeEnum.NOT_FOUND, "tenvdetail表查询serviceId=" + serviceId + ",envId=" + envId);
        }
        //2.通过url发送get请求,得到返回json
        String responseJson = importService.sendGet(swaggerUrl);
        if (responseJson == null) {
            throw new HryException(StatusCodeEnum.HTTP_ERROR, "请求地址为:" + swaggerUrl);
        }
        JSONObject jsonObject;
        try {
            //DisableCircularReferenceDetect禁止引用传递,(fastJson在此处对$ref对象处理不好,故这里直接禁用)
            jsonObject = JSON.parseObject(responseJson, Feature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            log.info("swaggerUrl:"+swaggerUrl);
            log.info("get swaggerUrl返回的内容:"+responseJson);
            log.error("swagger json序列化为JSONObject时出现异常:", e);
            throw new HryException(StatusCodeEnum.PARSE_JSON_ERROR);
        }

        //3.解析json,插入数据到ti表
        ImportInterfaceResult importInterfaceResult = importService.importInterface(serviceId, jsonObject, overwrite, iDev);
        return ResultUtil.success(importInterfaceResult);
    }
}
