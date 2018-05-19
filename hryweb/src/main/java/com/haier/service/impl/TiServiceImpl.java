package com.haier.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TiMapper;
import com.haier.po.Ti;
import com.haier.service.TiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        tiMapper.insert(ti);
        return ti.getId();
    }

    @Override
    public Integer updateOne(Integer id, Ti ti) {
        if(id==0||id==null|| Objects.isNull(ti)||ti.getIuri()==null||ti.getServiceid()==null||"".equals(ti.getIuri())||
                "".equals(ti.getServiceid())){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
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
