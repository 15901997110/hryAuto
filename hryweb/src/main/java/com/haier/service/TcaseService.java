package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Tcase;
import com.haier.po.TcaseCustom;

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
    PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom,Integer pageNum,Integer pageSize);

}
