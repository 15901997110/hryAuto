package com.haier.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.haier.enums.RequestMethodTypeEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.ImportService;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    TiMapper tiMapper;

    private TserviceExample tserviceExample = new TserviceExample();

    private Tservice tservice = new Tservice();

    @Override
    public String sendGet(String url) {
        String jsonResponse;
        try {
            jsonResponse = HryHttpClientUtil.send(url, RequestMethodTypeEnum.REQUEST_METHOD_GET.getId(), null);
        } catch (HttpProcessException e) {
            log.info("请求地址为:"+url);
            log.error("请求swaggerUrl时发生异常", e);
            return null;
        }
        return jsonResponse;
    }

    /**
     * @description: 根据serviceKey查询返回serviceId, 如果不存在, 则根据此serviceKey创建一
     * 条新记录并返回serviceId
     * @params: [serviceKey, serviceName]
     * @return: java.lang.Integer
     * @author: luqiwei
     * @date: 2018-05-21
     */
    @Override
    public Integer findServiceId(String serviceKey, String serviceName,String realName) {
        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andServicekeyEqualTo(serviceKey).andIsdelEqualTo((short)0);
        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);

        if (tservices != null && tservices.size()>0) {//有记录,则取出第一条记录的ID
            return tservices.get(0).getId();

        } else {//无记录,则插入一条记录,返回插入serviceId
            tservice.setServicekey(serviceKey);
            tservice.setServicename(serviceName);
            tservice.setEditor(realName);
            tserviceMapper.insertSelective(tservice);
            return tservice.getId();
        }
    }

    @Override
    public ImportInterfaceResult importInterface(Integer serviceId, JSONObject jsonObject, Boolean overwrite,String iDev) {
        String serviceKey=jsonObject.getJSONObject("info").getString("title").trim();
        String serviceName=jsonObject.getJSONObject("info").getString("description").trim();

        ImportInterfaceResult result = new ImportInterfaceResult();
        result.setServiceId(serviceId);
        result.setServiceKey(serviceKey);
        result.setServiceName(serviceName);
        List<String> insertList = new ArrayList<String>();
        List<String> updateList = new ArrayList<String>();
        List<String> failList = new ArrayList<String>();


        //获取接口表(ti)已经存在的记录,by serviceId
        TiExample tiExample = new TiExample();
        TiExample.Criteria criteria = tiExample.createCriteria();
        criteria.andServiceidEqualTo(serviceId);//筛选serviceId
        criteria.andIstatusNotEqualTo((short)-1);//筛选状态!=-1(非删除的数据)
        List<Ti> tis = tiMapper.selectByExample(tiExample);//ti表中所有的此serviceId存在的记录的集合,(不包括删除的)
        List<String> existIuri = new ArrayList<String>();
        Map<String,Integer> existIuriId=new HashMap<String,Integer>();//后续更新记录时会用到primaryKey
        if (tis != null) {
            for (Ti i : tis) {
                existIuri.add(i.getIuri());
                existIuriId.put(i.getIuri(),i.getId());
            }
        }

        JSONObject paths = jsonObject.getJSONObject("paths");//获取path:
        //definitions主要用于获取示例参数,这里暂时忽略,获取示例参数将改由Selenium从页面抓取
        //JSONObject definitions=jsonObject.getJSONObject("definitions");//获取definitions

        //解析paths,
        for (Map.Entry<String, Object> entry : paths.entrySet()) {
            String iUri = entry.getKey();//ti.iuri
            JSONObject iUriJsonObject = (JSONObject) entry.getValue();
            JSONObject postJsonObject = iUriJsonObject.getJSONObject("post");
            String summary = postJsonObject.getString("summary");//接口描述信息,作为i.remark插入

            //构造ti对象
            Ti ti = new Ti();
            ti.setServiceid(serviceId);
            ti.setIuri(iUri);
            ti.setRemark(summary);
            ti.setIdev(iDev);


            if (Objects.isNull(existIuri) || !existIuri.contains(iUri)) {//如果existIurl==null,说明此serviceId没有对应
                // 的接口记录,以下则可放心插入,
                //或者existIuri虽然不为null,但是并不包含此条需要插入的ti记录,此情况也可以直接插入
                try {
                    tiMapper.insertSelective(ti);
                    insertList.add(iUri);
                } catch (Exception e) {
                    log.error("插入接口数据失败", e);
                    failList.add(iUri+":插入数据失败");//记录失败的iUri
                }
            } else {//existIuri不是null&&existIuri包含当前要插入的记录
                if (overwrite) {//如果overwrite==true,则覆盖存在的记录,将数据更新
                    ti.setId(existIuriId.get(iUri));
                    try{
                        tiMapper.updateByPrimaryKeySelective(ti);
                        updateList.add(iUri);
                    }catch (Exception e){
                        log.error("更新接口数据失败",e);
                        failList.add(iUri+":更新数据失败");
                    }
                } else {//如果overwrite==false,则不覆盖记录,直接忽略这条ti记录
                    failList.add(iUri + ":存在重复的记录");
                }
            }
        }

        //构建返回信息
        result.setTotalCount(paths.size());
        result.setInsertCount(insertList.size());
        result.setInsertList(insertList);
        result.setUpdateCount(updateList.size());
        result.setUpdateList(updateList);
        result.setFailCount(failList.size());
        result.setFailList(failList);


        return result;
    }
}
