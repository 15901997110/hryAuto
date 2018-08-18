package com.haier.testng.base;

import com.alibaba.fastjson.JSONObject;
import com.haier.anno.Cookie;
import com.haier.config.SpringContextHolder;
import com.haier.po.Tservice;
import com.haier.po.Tservicedetail;
import com.haier.service.RunService;
import com.haier.util.HryUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.CookieStore;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/14 10:49
 */
@Slf4j
public class Base {
    public Integer serviceId;
    public Integer envId;
    public String caseDesigner;
    public JSONObject i_c_JSONObject;//{"methodName",List<CaseId>}
    public JSONObject i_c_zdy_JSONObject;//{"methodName",list<Tcase>}
    public Tservice tservice;
    public Tservicedetail tservicedetail;
    public RunService runService = SpringContextHolder.getBean(RunService.class);

    @Cookie
    public CookieStore cookieStore;

    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        this.serviceId = serviceId;
        this.envId = envId;
        this.caseDesigner = caseDesigner;
        if (StringUtils.isNotBlank(i_c)) {
            this.i_c_JSONObject = JSONObject.parseObject(i_c);
        }
        if (StringUtils.isNotBlank(i_c_zdy)) {
            this.i_c_zdy_JSONObject = JSONObject.parseObject(i_c_zdy);
        }
        tservice = runService.getTservice(this.serviceId);
        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);
        log.info("base类初始化(init()执行)完成");
    }

    public Object[] provider(Method method) {
        return HryUtil.getTests(tservice, tservicedetail, caseDesigner, i_c_JSONObject, i_c_zdy_JSONObject, method);
    }
}
