package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
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
        if(tenvId==null||tenv==null){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tenv.setId(tenvId);
        return tenvMapper.updateByPrimaryKeySelective(tenv);
    }

    @Override
    public Integer insertOne(Tenv tenv) {
        return tenvMapper.insertSelective(tenv);
    }

    @Override
    public Integer deleteOne(Integer tenvId) {
        return  tenvMapper.deleteByPrimaryKey(tenvId);
    }
}
