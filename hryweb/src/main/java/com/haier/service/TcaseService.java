package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Tcase;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/23 10:33
 */
public interface TcaseService {
    //增
    Integer insertOne(Tcase tcase);
    //改,删
    Integer updateOne(Integer tcaseId,Tcase tcase);
    //查
/*    PageInfo<Tcase> selectByCondition(Tcase tcase,)*/
}
