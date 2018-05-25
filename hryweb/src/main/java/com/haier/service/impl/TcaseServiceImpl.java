package com.haier.service.impl;

import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcaseMapper;
import com.haier.po.Tcase;
import com.haier.po.TcaseCustom;
import com.haier.po.TcaseExample;
import com.haier.service.TcaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Integer insertOne(Tcase tcase) {
        if(tcase==null||tcase.getIid()==null||tcase.getIid()==0){
            log.error("接收到的参数为:"+tcase);
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return tcaseMapper.insertSelective(tcase);
    }

    @Override
    public Integer deleteOne(Integer tcaseId) {

        return null;
    }

    @Override
    public Integer updateOne(Integer tcaseId, Tcase tcase) {
        if(tcaseId==null||tcaseId==0) {
            throw new HryException(10086,"tcaseId参数不正确");
        }
        tcase.setId(tcaseId);
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Tcase selectOne(Integer tcaseId) {
        return tcaseMapper.selectByPrimaryKey(tcaseId);
    }

    @Override
    public PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom, Integer pageNum, Integer pageSize) {
        return null;
    }
}
