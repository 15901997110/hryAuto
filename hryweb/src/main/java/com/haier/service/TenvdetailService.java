package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Tenvdetail;
import com.haier.po.TenvdetailCustom;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/30 19:47
 */
public interface TenvdetailService {
    Integer insertOne(Tenvdetail tenvdetail);
    Integer deleteOne(Tenvdetail tenvdetail);
    PageInfo<TenvdetailCustom> selectByCondition(TenvdetailCustom tenvdetailCustom,Integer pageNum,Integer pageSize);
}
