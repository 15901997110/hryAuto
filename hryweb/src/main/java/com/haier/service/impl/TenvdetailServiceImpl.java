package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TenvdetailCustomMapper;
import com.haier.mapper.TenvdetailMapper;
import com.haier.po.Tenvdetail;
import com.haier.po.TenvdetailCustom;
import com.haier.po.TenvdetailExample;
import com.haier.service.TenvdetailService;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/30 19:55
 */
@Slf4j
@Service
public class TenvdetailServiceImpl implements TenvdetailService {
    @Autowired
    TenvdetailMapper tenvdetailMapper;

    @Autowired
    TenvdetailCustomMapper tenvdetailCustomMapper;

    @Override
    public Integer insertOne(Tenvdetail tenvdetail) {
        if(tenvdetail==null||tenvdetail.getHostinfo()==null||tenvdetail.getServiceid()==null
                ||tenvdetail.getEnvid()==null||"".equals(tenvdetail.getHostinfo().trim())
                ||tenvdetail.getServiceid()==0||tenvdetail.getEnvid()==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }

        //先查询数据是否有重复
        TenvdetailExample tenvdetailExample=new TenvdetailExample();
        tenvdetailExample.createCriteria().andHostinfoLike("%"+tenvdetail.getHostinfo()+"%");
        List<Tenvdetail> tenvdetailList = tenvdetailMapper.selectByExample(tenvdetailExample);
        if(tenvdetailList!=null&&tenvdetailList.size()>0){
            throw new HryException(StatusCodeEnum.EXIST_RECORD);
        }
        //插入数据
        return tenvdetailMapper.insertSelective(tenvdetail);
    }

    @Override
    public Integer deleteOne(Tenvdetail tenvdetail) {
        if(tenvdetail==null){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        if(tenvdetail.getHostinfo()==null ||"".equals(tenvdetail.getHostinfo().trim())){
            throw new HryException(10086,"为了安全性,hostinfo必填!");
        }

        TenvdetailExample tenvdetailExample=new TenvdetailExample();
        tenvdetailExample.createCriteria().andHostinfoEqualTo(tenvdetail.getHostinfo().trim());
        return tenvdetailMapper.deleteByExample(tenvdetailExample);
    }

    @Override
    public PageInfo<TenvdetailCustom> selectByCondition(TenvdetailCustom tenvdetailCustom ,Integer pageNum,Integer pageSize) {
        if(tenvdetailCustom!=null){
            ReflectUtil.setStringFields(tenvdetailCustom,true);
        } else {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }

        PageHelper.startPage(pageNum,pageSize);
        List<TenvdetailCustom> tenvdetailCustomList = tenvdetailCustomMapper.selectByCondition(tenvdetailCustom);
        PageInfo<TenvdetailCustom> pageInfo=new PageInfo<>(tenvdetailCustomList);
        return pageInfo;
    }
}
