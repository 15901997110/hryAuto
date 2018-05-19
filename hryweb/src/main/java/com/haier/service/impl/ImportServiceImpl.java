package com.haier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.mapper.TserviceMapper;
import com.haier.po.ImportInterfaceResult;
import com.haier.po.Tservice;
import com.haier.po.TserviceExample;
import com.haier.service.ImportService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/19 13:21
 */
@Slf4j
@Service
public class ImportServiceImpl implements ImportService {
    @Autowired
    TserviceMapper tserviceMapper;

    private TserviceExample tserviceExample=new TserviceExample();

    private Tservice tservice=new Tservice();

    @Override
    public String sendGet(String url) {
        String jsonResponse=null;
        try {
            jsonResponse= HryHttpClientUtil.send(url, RequestMethodTypeEnum.REQUEST_METHOD_GET,null);
        } catch (HttpProcessException e) {
            log.error("",e);
            return null;
        }
        return jsonResponse;
    }

    @Override
    public Integer findServiceId(String serviceKey,String serviceName) {
        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andServicekeyEqualTo(serviceKey).andIsdelEqualTo((short)0);
        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);
        if(tservices!=null){//有记录,则取出第一条记录的ID
            return tservices.get(0).getId();
        }else{//无记录,则插入一条记录,返回插入serviceId
            tservice.setServicekey(serviceKey);
            tservice.setServicename(serviceName);
            tservice.setEditor("system");
            tserviceMapper.insert(tservice);
            return tservice.getId();
        }

    }

    @Override
    public ImportInterfaceResult importInterface(Integer serviceId,String serviceKey, JSONObject jsonObject,Boolean overwrite) {
        ImportInterfaceResult result=new ImportInterfaceResult();
        result.setServiceId(serviceId);
        result.setServiceKey(serviceKey);
        List<String> failList=new ArrayList<String>();

        JSONObject paths=jsonObject.getJSONObject("paths");//获取path:
        JSONObject definitions=jsonObject.getJSONObject("definitions");//获取definitions
        for(Map.Entry<String,Object> entry:paths.entrySet()){
            entry.getKey();
            entry.getValue();
        }
        return null;
    }
}
