package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TenvMapper;
import com.haier.po.Tenv;
import com.haier.po.TenvExample;
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
        //先判断数据是否存在
        TenvExample example=new TenvExample();
        example.createCriteria().andEnvkeyEqualTo(tenv.getEnvkey());
        List<Tenv> tenvList = tenvMapper.selectByExample(example);
        if(tenvList!=null&&tenvList.size()>0){
            throw new HryException(StatusCodeEnum.EXIST_RECORD);//抛出异常:记录存在
        }
        return tenvMapper.insertSelective(tenv);
    }

    @Override
    public Integer deleteOne(Integer tenvId) {
        return  tenvMapper.deleteByPrimaryKey(tenvId);
    }
}
