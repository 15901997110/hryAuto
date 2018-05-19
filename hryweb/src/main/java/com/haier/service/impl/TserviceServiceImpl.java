package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TserviceMapper;
import com.haier.po.Tservice;
import com.haier.po.TserviceExample;
import com.haier.service.TserviceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * @Description: TserviceService实现类
 * @Author: luqiwei
 * @Date: 2018/5/18 14:11
 */
public class TserviceServiceImpl implements TserviceService{

    @Autowired
    TserviceMapper tserviceMapper;

    @Override
    public Tservice selectOne(Integer id) {
        return tserviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tservice> selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize) {
        TserviceExample tserviceExample=new TserviceExample();

        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        //如果传入的对象不是null,则设置查询条件
        if(tservice!=null){
            criteria.andIdEqualTo(tservice.getId())
            .andServicekeyLike(tservice.getServicekey())
            .andServicenameLike(tservice.getServicename());
            //除非调用者指定查询isdel==1的数据,则查询删除的数据
            if(tservice.getIsdel()==1){
                criteria.andIsdelEqualTo((short)1);
            }else{//否则只查询未删除的数据
                criteria.andIsdelEqualTo((short)0);
            }
        }else{
            criteria.andIsdelEqualTo((short)0);//删除状态是0的记录
        }

        PageHelper.startPage(pageNum,pageSize);
        return tserviceMapper.selectByExample(tserviceExample);//如果tservice为null,则tserviceExample也为null,既不传任何条件
    }

    @Override
    public Integer updateOne(Integer id, Tservice tservice) {
        if(id==0||id==null||tservice==null||tservice.getServicekey()==null){
            //参数异常时,直接抛出
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tservice.setId(id);
        return tserviceMapper.updateByPrimaryKey(tservice);
    }

    @Override
    public Integer insertOne(Tservice tservice) {
        if(Objects.isNull(tservice)||tservice.getServicekey()==null||"".equals(tservice.getServicekey())){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tserviceMapper.insert(tservice);
        return tservice.getId();//返回插入的主键,注意,此返回需要先在sqlMapperXml文件中配置
    }
}
