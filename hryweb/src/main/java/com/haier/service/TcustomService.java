package com.haier.service;

import com.haier.po.Tcustom;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:22
 */
public interface TcustomService {
    Integer insertOne(Tcustom tcustom);
    Integer updateOne(Tcustom tcustom);
    Integer deleteOne(Integer id);
    List<Tcustom> selectByCondition(Tcustom tcustom);
}
