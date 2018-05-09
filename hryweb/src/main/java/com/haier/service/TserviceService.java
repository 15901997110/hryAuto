package com.haier.service;

import com.haier.po.Tservice;
import sun.security.timestamp.TSRequest;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:01
 */
public interface TserviceService {
    Tservice findOne(Integer id);
    List<TSRequest> findByCondition(Tservice tservice,Integer pageNum,Integer pageSize);
    Integer update(Integer id,Tservice tservice);
    Integer add(Tservice tservice);
}
