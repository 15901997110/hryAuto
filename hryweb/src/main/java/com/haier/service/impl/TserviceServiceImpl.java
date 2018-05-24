package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.Ti;
import com.haier.po.TiExample;
import com.haier.po.Tservice;
import com.haier.po.TserviceExample;
import com.haier.service.TserviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * @Description: TserviceService实现类
 * @Author: luqiwei
 * @Date: 2018/5/18 14:11
 */
@Slf4j
@Service
public class TserviceServiceImpl implements TserviceService{

    @Autowired
    TserviceMapper tserviceMapper;

    @Autowired
    TiMapper tiMapper;

    @Override
    public Tservice selectOne(Integer id) {
        return tserviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Tservice> selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize) {
        TserviceExample tserviceExample=new TserviceExample();

        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        //如果传入的对象不是null,则设置查询条件
        if(tservice!=null){
            if(tservice.getId()!=null){
                criteria.andIdEqualTo(tservice.getId());
            }
            if(tservice.getServicekey()!=null)
            {
                criteria.andServicekeyLike("%"+tservice.getServicekey()+"%");
            }
            if(tservice.getServicename()!=null) {
                criteria.andServicenameLike("%"+tservice.getServicename()+"%");
            }

            //除非调用者指定查询isdel==1的数据,则查询删除的数据
            if(tservice.getIsdel()!=null&&tservice.getIsdel()==1){
                criteria.andIsdelEqualTo((short)1);
            }else{//否则只查询未删除的数据
                criteria.andIsdelEqualTo((short)0);
            }
        }else{
            criteria.andIsdelEqualTo((short)0);
        }


        PageHelper.startPage(pageNum,pageSize);

        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);//如果tservice为null,则tserviceExample也为null,既不传任何条件

        PageInfo<Tservice> pageInfo=new PageInfo<>(tservices);

        return pageInfo;
    }

    @Override
    public Integer updateOne(Integer id, Tservice tservice) {
        if(id==0||id==null||tservice==null){
            //参数异常时,直接抛出
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tservice.setId(id);
        return tserviceMapper.updateByPrimaryKeySelective(tservice);
    }

    @Override
    public Integer insertOne(Tservice tservice) {
        //参数校验
        if(Objects.isNull(tservice)||tservice.getServicekey()==null||"".equals(tservice.getServicekey())){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        //数据重复性校验
        TserviceExample tserviceExample=new TserviceExample();
        tserviceExample.createCriteria()
                .andServicekeyEqualTo(tservice.getServicekey())
                .andIsdelEqualTo((short)0);
        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);
        if(tservices!=null&&tservices.size()>0){
            throw new HryException(StatusCodeEnum.EXIST_RECORD);
        }
        //插入数据
        tserviceMapper.insertSelective(tservice);
        return tservice.getId();//返回插入的主键,注意,此返回需要先在sqlMapperXml文件中配置
    }

    @Override
    public Integer deleteOne(Integer id) {
        if(id==null||id==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        //先删除ti表的数据
        Ti ti=new Ti();
        ti.setIstatus((short)-1);
        TiExample tiExample=new TiExample();
        tiExample.createCriteria().andServiceidEqualTo(id);
        tiMapper.updateByExampleSelective(ti,tiExample);
        //再删除tservice表的数据
        Tservice tservice=new Tservice();
        tservice.setId(id);
        tservice.setIsdel((short)1);
        return tserviceMapper.updateByPrimaryKeySelective(tservice);
    }
}
