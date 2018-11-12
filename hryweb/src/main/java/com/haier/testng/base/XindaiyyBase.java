package com.haier.testng.base;

import com.haier.anno.SKey;
import com.haier.anno.Uri;
import com.haier.po.HryTest;
import com.haier.util.HryHttpClientUtil;

/**
 * @Description: XindaiyyBase
 * @Author: 自动生成
 * @Date: 2018/11/12 14:21:00
 */
@SKey("Xindaiyy")
public class XindaiyyBase extends Base {
    public XindaiyyBase(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {
        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);
    }

    @Uri(value = "/cbp-web/book/addBookInfo.json", desc = "新建预约")
    public String _cbp_web_book_addBookInfo_json(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-web/book/audit.json", desc = "审核预约")
    public String _cbp_web_book_audit_json(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-web/book/queryBookList.json", desc = "查询预约列表")
    public String _cbp_web_book_queryBookList_json(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

    @Uri(value = "/cbp-web/book/review.json", desc = "复核预约")
    public String _cbp_web_book_review_json(HryTest test) {
        return HryHttpClientUtil.send(test, this);
    }

}
