package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Tenvdetail;
import com.haier.po.TenvdetailCustom;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/30 19:47
 */
public interface TenvdetailService {
    Integer insertOne(Tenvdetail tenvdetail);

    Integer deleteOne(Integer id);

    Integer deleteByCondition(Tenvdetail tenvdetail);

    Tenvdetail selectOne(Integer id);

    Integer updateOne(Tenvdetail tenvdetail);

    List<Tenvdetail> selectByCondition(Tenvdetail tenvdetail);

    PageInfo<TenvdetailCustom> selectByCondition(TenvdetailCustom tenvdetailCustom, Integer pageNum, Integer pageSize);
}
