package com.haier.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcaseMapper;
import com.haier.mapper.TiCustomMapper;
import com.haier.mapper.TiMapper;
import com.haier.po.*;
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
    @Autowired
    TcaseMapper tcaseMapper;
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

    /**
     *@description: 删除tservice表记录时,会同时删除ti表的记录,所以一定要谨慎
     *@params: [id]
     *@return: java.lang.Integer
     *@author: luqiwei
     *@date: 2018-05-24
     */
    @Override
    public Integer deleteOne(Integer id) {
        //0.简单的参数校验
        if(Objects.isNull(id)||id==0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }

        //1.先删除tcase表中的记录
        Tcase tcase=new Tcase();
        tcase.setStatus((short)-1);
        TcaseExample tcaseExample=new TcaseExample();
        tcaseExample.createCriteria().andIidEqualTo(id);
        tcaseMapper.updateByExampleSelective(tcase,tcaseExample);

        //2.再删除ti表中的记录
        Ti ti=new Ti();
        ti.setId(id);
        ti.setIstatus((short)-1);
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
