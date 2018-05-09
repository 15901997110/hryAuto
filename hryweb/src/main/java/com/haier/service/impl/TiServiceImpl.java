package com.haier.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haier.mapper.TiMapper;
import com.haier.po.Ti;
import com.haier.service.TiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:21
 */
@Service
public class TiServiceImpl implements TiService {
    @Autowired
    TiMapper tiMapper;
    @Override
    public Integer insertOne(Ti ti) {
        return tiMapper.insert(ti);
    }

    @Override
    public Integer updateOne(Integer id, Ti ti) {
        ti.setId(id);
        return tiMapper.updateByPrimaryKey(ti);
    }

    @Override
    public Ti selectOne(Integer id) {
        return tiMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ti> selectByCondition(Ti ti, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ti> tis = tiMapper.selectByExample(null);
        return tis;
    }
}
