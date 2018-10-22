package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: RmpBase
 * @Author: 自动生成
 * @Date: 2018/08/22 16:04:42
 */
@SKey("Rmp")
public class RmpBase extends Base {
    public RmpBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/riskManagementFacade/apply", desc = "提交风控申请")
    public String _riskManagementFacade_apply(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/riskManagementFacade/query", desc = "查询风控审核结果")
    public String _riskManagementFacade_query(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
