package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.SortEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.TservicedetailService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description: TserviceService实现类
 * @Author: luqiwei
 * @Date: 2018/5/18 14:11
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class TserviceServiceImpl implements TserviceService {

    @Autowired
    TserviceMapper tserviceMapper;

    @Autowired
    TiMapper tiMapper;

    @Autowired
    TiService tiService;

    @Autowired
    TservicedetailService tservicedetailService;

    @Override
    public Tservice selectOne(Integer id) {
        return tserviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Tservice> selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        TserviceExample tserviceExample = new TserviceExample();

        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        //如果传入的对象不是null,则设置查询条件
        if (tservice != null) {
            if (tservice.getId() != null) {
                criteria.andIdEqualTo(tservice.getId());
            }
            if (tservice.getServicekey() != null) {
                criteria.andServicekeyLike("%" + tservice.getServicekey() + "%");
            }
            if (tservice.getServicename() != null) {
                criteria.andServicenameLike("%" + tservice.getServicename() + "%");
            }

            //除非调用者指定查询isdel==1的数据,则查询删除的数据
            if (tservice.getIsdel() != null && tservice.getIsdel() == 1) {
                criteria.andIsdelEqualTo(1);
            } else {//否则只查询未删除的数据
                criteria.andIsdelEqualTo(0);
            }
        } else {
            criteria.andIsdelEqualTo(0);
        }

        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());

        List<Tservice> tservices = tserviceMapper.selectByExample(tserviceExample);//如果tservice为null,则tserviceExample也为null,既不传任何条件

        PageInfo<Tservice> pageInfo = new PageInfo<>(tservices);

        return pageInfo;
    }

    @Override
    public List<Tservice> selectByCondition(Tservice tservice) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tservice, false);
        TserviceExample tserviceExample = new TserviceExample();
        tserviceExample.setOrderByClause("updateTime desc,id desc");
        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andIsdelNotEqualTo(1);

        if (tservice != null) {
            if (tservice.getId() != null)
                criteria.andIdEqualTo(tservice.getId());
            if (tservice.getServicekey() != null) {
                criteria.andServicekeyLike(tservice.getServicekey());
                criteria.andServicenameLike(tservice.getServicekey());
            }
            if (tservice.getEditor() != null)
                criteria.andEditorLike(tservice.getEditor());

        }

        return tserviceMapper.selectByExample(tserviceExample);
    }

    @Override
    public Integer updateOne(Tservice tservice) {
        verify(tservice);
        return tserviceMapper.updateByPrimaryKeySelective(tservice);
    }

    @Override
    public Integer insertOne(Tservice tservice) {
        ReflectUtil.setInvalidFieldToNull(tservice, false);
        //参数校验
        if (Objects.isNull(tservice) || tservice.getServicekey() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "servicekey必填");
        }
        verify(tservice);

        //插入数据
        tserviceMapper.insertSelective(tservice);
        return tservice.getId();//返回插入的主键,注意,此返回需要先在sqlMapperXml文件中配置
    }

    public void verify(Tservice tservice) {
        //数据重复性校验
        TserviceExample example = new TserviceExample();
        TserviceExample.Criteria criteriaServiceKey = example.createCriteria();//没有规则时,加载到规则中example中
        criteriaServiceKey.andServicekeyEqualTo(tservice.getServicekey()).andIsdelEqualTo(0);

        if (tservice.getClassname() != null) {
            TserviceExample.Criteria criteriaClassname = example.createCriteria();//已经有规则时,只是创建规则,并不会加入到example中
            criteriaClassname.andClassnameEqualTo(tservice.getClassname()).andIsdelEqualTo(0);
            example.or(criteriaClassname);
        }
        List<Tservice> tservices = tserviceMapper.selectByExample(example);
        if (tservices != null && tservices.size() > 0) {
            throw new HryException(StatusCodeEnum.EXIST_RECORD, "服务标识=" + tservice.getServicekey() + ",或者默认类名=" + tservice.getClassname() + " 的记录已经存在");
        }
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        //删除ti表中的记录
        Ti ti = new Ti();
        ti.setServiceid(id);
        tiService.deleteByCondition(ti);
        //删除tservicedetail表中的记录
        Tservicedetail tservicedetail = new Tservicedetail();
        tservicedetail.setServiceid(id);
        tservicedetailService.deleteByCondition(tservicedetail);

        //删除tservice表中的记录
        Tservice tservice = new Tservice();
        tservice.setId(id);
        tservice.setIsdel(1);
        return this.updateOne(tservice);
    }
}
