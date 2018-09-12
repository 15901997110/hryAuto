package com.haier.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.po.ImportInterfaceResult;
import com.haier.po.Tservicedetail;
import com.haier.response.Result;
import com.haier.service.ImportService;
import com.haier.service.TservicedetailService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    TservicedetailService tservicedetailService;

    @PostMapping("/interfaceImport")
    public Result interfaceImport(Integer serviceDetailId, Boolean overwrite, String iDev) {
        if (serviceDetailId == null || serviceDetailId == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "tserviceDetail.id必传");
        }
        if (overwrite == null) {
            overwrite = false;
        }
        //1.找到swaggerUrl
        Tservicedetail tservicedetail = tservicedetailService.selectOne(serviceDetailId);
        if (tservicedetail == null || tservicedetail.getSwaggerurl() == null) {
            throw new HryException(StatusCodeEnum.LOGICAL_ERROR, "服务与环境映射中未找到记录,或者找到记录的swaggerUrl不存在,serviceDetailId=" + serviceDetailId);
        }

        //2.通过url发送get请求,得到返回json
        String responseJson = HryHttpClientUtil.get(tservicedetail.getSwaggerurl());
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(responseJson, Feature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            throw new HryException(StatusCodeEnum.PARSE_JSON_ERROR, "解析Swagger失败,swaggerUrl=" + tservicedetail.getSwaggerurl()
                    + ", swagger内容为: " + responseJson);
        }

        //3.解析json,插入数据到ti表
        ImportInterfaceResult importInterfaceResult = importService.importInterface(tservicedetail.getServiceid(), jsonObject, overwrite, iDev);
        return ResultUtil.success(importInterfaceResult);
    }
}
