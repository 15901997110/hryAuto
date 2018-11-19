package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: AceSaBase
 * @Author: 自动生成
 * @Date: 2018/11/15 14:56:54
 */
@SKey("AceSa")
public class AceSaBase extends Base {
    public AceSaBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/sa/login", desc = "SA登录")
    public String _sa_login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
