package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.SortEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcaseCustomMapper;
import com.haier.mapper.TcaseMapper;
import com.haier.po.Tcase;
import com.haier.po.TcaseCustom;
import com.haier.service.TcaseService;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/24 17:07
 */
@Slf4j
@Service
public class TcaseServiceImpl implements TcaseService {

    @Autowired
    TcaseMapper tcaseMapper;

    @Autowired
    TcaseCustomMapper tcaseCustomMapper;

    @Override
    public Integer insertOne(Tcase tcase) {
        //参数校验,注意,这些参数应该在前端直接js校验效果会更好
        if (tcase == null || tcase.getIid() == null || tcase.getCasename() == null
                || tcase.getIid() == 0 || "".equals(tcase.getCasename())) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return tcaseMapper.insertSelective(tcase);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        Tcase tcase = new Tcase();
        tcase.setId(id);
        tcase.setStatus((short) -1);
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Integer updateOne(Integer id, Tcase tcase) {
        if (tcase == null || tcase.getId() == null || tcase.getId() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tcase.setId(id);
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Tcase selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return tcaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom, Integer pageNum, Integer pageSize) {
        //javabean中的属性进行处理,针对String类型的并且存在非空值的属性,前后都添加%,这样在后面的查询中可以直接like
        if (tcaseCustom != null) {
            ReflectUtil.setFieldAddPercentAndCleanZero(tcaseCustom, true);
        }

        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        List<TcaseCustom> tcaseCustomList = tcaseCustomMapper.selectByCondition(tcaseCustom);
        PageInfo<TcaseCustom> pageInfo = new PageInfo<>(tcaseCustomList);
        return pageInfo;
    }

    @Override
    public Void runOne(Tcase tcase) {
        if(tcase==null){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR,"tcase对象不可为空!");
        }
        //准备数据


        //发送http请求

        //断言结果

        return null;
    }
}
