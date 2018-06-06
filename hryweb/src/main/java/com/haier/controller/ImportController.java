package com.haier.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.ImportInterfaceResult;
import com.haier.response.Result;
import com.haier.service.ImportService;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/interfaceImport")
    public Result interfaceImport(@RequestParam(value="url") String url,//swagger url,例如:http://10.252.12.168:7029/swagger.json
                                  @RequestParam(value="overwrite") Boolean overwrite,//是否覆盖ti表中存在的记录
                                  @RequestParam(value="sEditor") String sEditor,//
                                  @RequestParam(value="iDev") String iDev//接口开发人员-realname
                                  ){
        //1.通过url发送get请求,得到返回json
        String responseJson = importService.sendGet(url);
        if(responseJson==null){
            throw new HryException(StatusCodeEnum.HTTP_ERROR);
        }
        JSONObject jsonObject;
        try{
            //DisableCircularReferenceDetect禁止引用传递,(fastJson在此处对$ref对象处理不好,故这里直接禁用)
            jsonObject= JSON.parseObject(responseJson, Feature.DisableCircularReferenceDetect);
        }catch(Exception e){
            log.error("",e);
            throw new HryException(StatusCodeEnum.PARSE_JSON_ERROR);
        }

        String servicekey=jsonObject.getJSONObject("info").getString("title").trim();
        String serviceName = jsonObject.getJSONObject("info").getString("description").trim();

        //2.通过servicekey查询serviceId,没有查询到,则新插入一条service记录,返回新插入的id
        Integer serviceId=importService.findServiceId(servicekey,serviceName,sEditor);
        //3.解析json,插入数据到ti表
        ImportInterfaceResult importInterfaceResult=importService.importInterface(serviceId,servicekey,jsonObject,overwrite,iDev);

        return ResultUtil.success(importInterfaceResult);
    }
}
