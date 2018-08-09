package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.SortEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TservicedetailCustomMapper;
import com.haier.mapper.TservicedetailMapper;
import com.haier.po.Tservicedetail;
import com.haier.po.TservicedetailCustom;
import com.haier.po.TservicedetailExample;
import com.haier.service.TservicedetailService;
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
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class TservicedetailServiceImpl implements TservicedetailService {
    @Autowired
    TservicedetailMapper tservicedetailMapper;

    @Autowired
    TservicedetailCustomMapper tservicedetailCustomMapper;

    @Override
    public Integer insertOne(Tservicedetail tservicedetail) {
        return tservicedetailMapper.insertSelective(tservicedetail);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        Tservicedetail tservicedetail = new Tservicedetail();
        tservicedetail.setId(id);
        tservicedetail.setStatus(-1);
        return this.updateOne(tservicedetail);
    }

    /**
     * 根据条件删除tservicedetail记录,现在支持的条件 有serviceid和envid
     *
     * @param tservicedetail
     * @return
     */
    @Override
    public Integer deleteByCondition(Tservicedetail tservicedetail) {
        ReflectUtil.setInvalidFieldToNull(tservicedetail, false);
        if (tservicedetail == null || (tservicedetail.getServiceid() == null && tservicedetail.getEnvid() == null)) {
            throw new HryException(StatusCodeEnum.DANGER_OPERATION, "暂时只支持根据serviceid和envid删除tservicedetail记录");
        }
        TservicedetailExample tservicedetailExample = new TservicedetailExample();
        TservicedetailExample.Criteria criteria = tservicedetailExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tservicedetail.getServiceid() != null)
            criteria.andServiceidEqualTo(tservicedetail.getServiceid());
        if (tservicedetail.getEnvid() != null)
            criteria.andEnvidEqualTo(tservicedetail.getEnvid());
        Tservicedetail t = new Tservicedetail();
        t.setStatus(-1);
        return tservicedetailMapper.updateByExampleSelective(t, tservicedetailExample);
    }

    @Override
    public Tservicedetail selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return tservicedetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public Tservicedetail selectOne(Integer serviceId, Integer envId) {
        if (serviceId == null || envId == null) {
            return null;
        }
        Tservicedetail tservicedetail = new Tservicedetail();
        tservicedetail.setServiceid(serviceId);
        tservicedetail.setEnvid(envId);
        List<Tservicedetail> tservicedetails = this.selectByCondition(tservicedetail);
        if (tservicedetails != null && tservicedetails.size() > 0) {
            return tservicedetails.get(0);
        }
        return null;
    }

    @Override
    public Integer updateOne(Tservicedetail tservicedetail) {
        return tservicedetailMapper.updateByPrimaryKeySelective(tservicedetail);
    }

    @Override
    public List<Tservicedetail> selectByCondition(Tservicedetail tservicedetail) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tservicedetail, false);
        TservicedetailExample example = new TservicedetailExample();

        TservicedetailExample.Criteria criteria = example.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tservicedetail != null) {
            if (tservicedetail.getId() != null)
                criteria.andIdEqualTo(tservicedetail.getId());
            if (tservicedetail.getServiceid() != null)
                criteria.andServiceidEqualTo(tservicedetail.getServiceid());
            if (tservicedetail.getEnvid() != null)
                criteria.andEnvidEqualTo(tservicedetail.getEnvid());
            if (tservicedetail.getHostinfo() != null)
                criteria.andHostinfoLike(tservicedetail.getHostinfo());
            if (tservicedetail.getDbinfo() != null)
                criteria.andDbinfoLike(tservicedetail.getDbinfo());
            if (tservicedetail.getSwaggerurl() != null)
                criteria.andSwaggerurlLike(tservicedetail.getSwaggerurl());
        }

        List<Tservicedetail> tservicedetailList = tservicedetailMapper.selectByExample(example);
        return tservicedetailList;
    }

    @Override
    public List<TservicedetailCustom> selectByCondition(TservicedetailCustom tservicedetailCustom) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tservicedetailCustom, true);
        List<TservicedetailCustom> tservicedetailCustomList = tservicedetailCustomMapper.selectByCondition(tservicedetailCustom);
        return tservicedetailCustomList;
    }

    @Override
    public PageInfo<TservicedetailCustom> selectByCondition(TservicedetailCustom tservicedetailCustom, Integer pageNum, Integer pageSize) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tservicedetailCustom, true);
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize, SortEnum.ID.getValue());
        List<TservicedetailCustom> tservicedetailCustomList = tservicedetailCustomMapper.selectByCondition(tservicedetailCustom);
        PageInfo<TservicedetailCustom> pageInfo = new PageInfo<>(tservicedetailCustomList);
        return pageInfo;
    }
}
