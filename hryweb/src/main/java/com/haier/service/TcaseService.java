package com.haier.service;

import com.haier.po.Tcase;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/23 10:33
 */
public interface TcaseService {

    //增
    Integer insertOne(Tcase tcase);
    //删
    Integer deleteOne(Integer tcaseId);
    //改
    Integer updateOne(Integer tcaseId,Tcase tcase);
    //查-根据主键查询
    Tcase selectOne(Integer tcaseId);
    //查-综合查询

}
