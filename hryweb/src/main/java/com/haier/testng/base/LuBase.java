package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: LuBase
 * @Author: 自动生成
 * @Date: 2018/10/22 15:52:34
 */
@SKey("Lu")
public class LuBase extends Base {
    public LuBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/i1", desc = "添加接口测试")
    public String _i1(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
