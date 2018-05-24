package com.haier.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TiCustomMapper;
import com.haier.mapper.TiMapper;
import com.haier.po.Ti;
import com.haier.po.TiCustom;
import com.haier.po.TiExample;
import com.haier.service.TiService;
import com.haier.util.ReflectUtil;
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
    @Autowired
    TiCustomMapper tiCustomMapper;
    @Override
    public Integer insertOne(Ti ti) {
        //插入数据之前判断记录是否存在
        TiExample tiExample=new TiExample();
        tiExample.createCriteria()
                .andServiceidEqualTo(ti.getServiceid())
                .andIuriEqualTo(ti.getIuri())
                .andIstatusNotEqualTo((short)-1);
        List<Ti> tis = tiMapper.selectByExample(tiExample);
        if(tis!=null&&tis.size()>0){
            throw new HryException(StatusCodeEnum.EXIST_RECORD);
        }
        //插入数据
        tiMapper.insertSelective(ti);
        return ti.getId();
    }

    @Override
    public Integer updateOne(Integer id, Ti ti) {
        if(id==0||id==null|| Objects.isNull(ti)){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        ti.setId(id);
        return tiMapper.updateByPrimaryKeySelective(ti);
    }

    @Override
    public Ti selectOne(Integer id) {
        return tiMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TiCustom> selectByCondition(TiCustom tiCustom, Integer pageNum, Integer pageSize) {
        if(tiCustom!=null){
            try {
                ReflectUtil.setStringFields(tiCustom,true);
            } catch (IllegalAccessException e) {
                throw new HryException(6666,e.getMessage());
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TiCustom> tiCustomList = tiCustomMapper.selectByCondition(tiCustom);
        PageInfo<TiCustom> pageInfo=new PageInfo<>(tiCustomList);
        return pageInfo;
    }
}
