package com.haier.util;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.Tservice;
import com.haier.po.TserviceExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Description: 导入工具类
 * @Author: luqiwei
 * @Date: 2018/5/18 13:06
 */
@Slf4j
public class ImportUtil {
    /**
     * @description: 导入接口
     * @params: [url, serviceKey, overwrite]
     * @return: void
     * @author: luqiwei
     * @date: 2018-05-18
     */
    @Autowired
    static TserviceMapper tserviceMapper;
    @Autowired
    static TiMapper tiMapper;

    public static void importInterface(String url, String serviceKey, Boolean overwrite) {
        String serviceName = null;
        HttpConfig httpConfig = HttpConfig.custom().url(url);
        String result = null;
        try {
            result = HttpClientUtil.get(httpConfig);
        } catch (HttpProcessException e) {
            log.error("访问{}时发生异常", url);
            log.error("", e.getMessage());
            return;
        }
        if (result == null) {
            return;
        }
        JSONObject jsonObject = JSONUtil.str2JsonObj(result);
        serviceName = jsonObject.getJSONObject("info").getString("description");
        log.debug("服务描述:{}", serviceName);

        Tservice tservice = tserviceMapper.selectByPrimaryKey(1);
        log.debug(tservice.toString());

    }

    public static Integer getServiceId(String serviceKey, String serviceDesc) {
        TserviceExample tserviceExample = new TserviceExample();
        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andServicekeyEqualTo(serviceKey);
        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);
        if (tservices != null) {
            //没有此servicekey,插入一条新的servicekey
            Tservice tservice = new Tservice();
            tservice.setServicekey(serviceKey);
            tservice.setEditor("luqiwei@kjtpay.com.cn");
            tservice.setServicename(serviceDesc);
            return tservice.getId();
        } else {
            return tservices.get(0).getId();
        }
    }

    @Test
    public void testImport() {
        importInterface("http://10.252.12.212:7032/swagger.json", null, null);
/*        Integer cs2 = getServiceId("p2p", null);
        log.debug(cs2.toString());*/
    }


}
