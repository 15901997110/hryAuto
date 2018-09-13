package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: LuBase
 * @Author: 自动生成
 * @Date: 2018/09/11 19:27:25
 */
@SKey("Lu")
public class LuBase extends Base {
    @Uri(value = "/i1", desc = "添加接口测试")
    public String _i1(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
