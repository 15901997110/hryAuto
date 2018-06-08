package com.haier.service;

import com.alibaba.fastjson.JSONObject;
import com.haier.po.ImportInterfaceResult;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/18 19:35
 */
public interface ImportService {
    String sendGet(String url);
    Integer findServiceId(String serviceKey,String serviceName,String realName);
    ImportInterfaceResult importInterface(Integer serviceId, JSONObject jsonObject,Boolean overwrite,String developerEmail);
}
