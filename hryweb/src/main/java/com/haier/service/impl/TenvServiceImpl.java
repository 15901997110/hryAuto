package com.haier.service.impl;

import com.haier.mapper.TenvMapper;
import com.haier.po.Tenv;
import com.haier.service.TenvService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 9:31
 */
@Service
public class TenvServiceImpl implements TenvService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TenvMapper tenvMapper;
    @Override
    public List<Tenv> selectAll() {
        List<Tenv> tenvs = tenvMapper.selectByExample(null);
        return tenvs;
    }

    @Override
    public Tenv selectOne(Integer tenvId) {
        return tenvMapper.selectByPrimaryKey(tenvId);
    }

    @Override
    public Integer updateOne(Integer tenvId, Tenv tenv) {
        return null;
    }

    @Override
    public Integer insertOne(Tenv tenv) {
        return tenvMapper.insert(tenv);
    }
}
