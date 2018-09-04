package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: AceSaBase
 * @Author: 自动生成
 * @Date: 2018/09/03 20:16:25
 */
@SKey("AceSa")
public class AceSaBase extends Base {
    @Uri(value = "/sa/login", desc = "SA登录")
    public String _sa_login(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
