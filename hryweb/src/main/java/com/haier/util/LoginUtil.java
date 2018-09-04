package com.haier.util;

import com.alibaba.fastjson.JSONObject;
import com.haier.anno.HryHeader;
import com.haier.config.SpringContextHolder;
import com.haier.po.*;
import com.haier.service.TcaseService;
import com.haier.service.TiService;
import com.haier.testng.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.testng.Reporter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/9/3 16:20
 */
@Slf4j
public class LoginUtil {
    public static <T extends Base> void zhuanleLogin(Tservice tservice, Tservicedetail tservicedetail, String iUri, T entity) {
        TiService tiService = SpringContextHolder.getBean(TiService.class);
        TcaseService tcaseService = SpringContextHolder.getBean(TcaseService.class);
        Ti tiCondition = new Ti();
        tiCondition.setServiceid(tservicedetail.getServiceid());
        tiCondition.setIuri(iUri);

        List<Ti> tis = tiService.selectByCondition(tiCondition);

        if (tis.size() == 0) {
            log.error("未找到接口:serviceId=" + tiCondition.getServiceid() + ",iUri=" + iUri);
            return;
        }
        Ti ti = tis.get(0);
        Tcase tcaseCondition = new Tcase();
        tcaseCondition.setEnvid(tservicedetail.getEnvid());
        tcaseCondition.setIid(ti.getId());
        List<Tcase> tcases = tcaseService.selectByCondition(tcaseCondition);

        if (tcases.size() == 0) {
            log.error("未找到Case,查询条件iid=" + tcaseCondition.getIid() + ",envId=" + tcaseCondition.getEnvid());
            return;
        }
        Tcase tcase = tcases.get(0);

        HryTest test = new HryTest();
        test.setTservice(tservice);
        test.setTservicedetail(tservicedetail);
        test.setTi(ti);
        test.setTcase(tcase);
        String loginRes = HryHttpClientUtil.send(test, null);

        log.info("zhuanle登录返回:" + loginRes);
        JSONObject jsonObject = JSONUtil.str2JSONObj(loginRes);

        if (jsonObject != null) {
            try {
                String auth = jsonObject.getJSONObject("body").getString("auth");
                Header header = new BasicHeader("X-KJT-Auth", auth);
                Field[] fields = entity.getClass().getFields();
                for (Field field : fields) {
                    if (field.getAnnotation(HryHeader.class) != null) {
                        field.set(entity, ArrayUtils.add(null, header));
                        Reporter.log("登录成功,设置auth=" + auth);
                        break;
                    }
                }
            } catch (Exception e) {
                Reporter.log(e.getMessage());
                log.error("登录返回结果中寻找auth发生异常");
            }

        } else {
            log.error("登录失败");
            Reporter.log("登录失败");
        }

    }
}
