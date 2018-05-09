package com.haier.service;

import com.haier.po.Ti;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:09
 */
public interface TiService {
    Integer insertOne(Ti ti);
    Integer updateOne(Integer id,Ti ti);
    Ti selectOne(Integer id);
    List<Ti> selectByCondition(Ti ti, Integer pageNum, Integer pageSize);
}
