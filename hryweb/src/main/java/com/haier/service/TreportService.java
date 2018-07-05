package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.po.Treport;

import java.util.Date;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:22
 */
public interface TreportService {
    Integer insertOne(Treport treport);

    Integer updateOne(Treport treport);

    Integer deleteOne(Integer id);

    PageInfo<Treport> selectByCondition(Treport treport, Date startTime, Date endTime, Integer pageNum, Integer pageSize);
}
