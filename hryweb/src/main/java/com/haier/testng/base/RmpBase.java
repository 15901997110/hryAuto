package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: RmpBase
 * @Author: 自动生成
 * @Date: 2018/08/17 14:34:00
 */
@SKey("Rmp")
public class RmpBase extends Base {
    @Uri(value = "/riskManagementFacade/apply", desc = "提交风控申请")
    public String _riskManagementFacade_apply(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagementFacade/query", desc = "查询风控审核结果")
    public String _riskManagementFacade_query(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
