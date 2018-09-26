package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: AceSaBase
 * @Author: 自动生成
 * @Date: 2018/09/26 19:37:05
 */
@SKey("AceSa")
public class AceSaBase extends Base {
    public AceSaBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy);
    }
    @Uri(value = "/sa/login", desc = "SA登录")
    public String _sa_login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
