package com.haier.service;

import com.haier.po.Tservice;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:01
 */
public interface TserviceService {
    Tservice selectOne(Integer id);
    List<Tservice> selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize);
    Integer updateOne(Integer id, Tservice tservice);
    //返回主键
    Integer insertOne(Tservice tservice);
}
