package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Ti;
import com.haier.po.TiCustom;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:09
 */
public interface TiService {
    Integer insertOne(Ti ti);

    Integer updateOne(Integer id, Ti ti);

    Integer deleteOne(Integer id);//需谨慎操作,删除ti表的记录,将会连带删除tcase表的记录

    Integer deleteByCondition(Ti ti);

    Ti selectOne(Integer id);

    PageInfo<TiCustom> selectByCondition(TiCustom tiCustom, Integer pageNum, Integer pageSize);

    List<Ti> selectByCondition(Ti ti);
}
