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
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TenvdetailMapper tenvdetailMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TenvdetailCustomMapper tenvdetailCustomMapper;

    @Override
    public Integer insertOne(Tenvdetail tenvdetail) {
        if (tenvdetail == null || tenvdetail.getHostinfo() == null || tenvdetail.getServiceid() == null
                || tenvdetail.getEnvid() == null
                || "".equals(tenvdetail.getHostinfo().trim()) || tenvdetail.getServiceid() == 0 || tenvdetail.getEnvid() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "serviceId,envId,hostInfo必填");
        }
        ReflectUtil.setInvalidFieldToNull(tenvdetail, false);
        //先查询数据是否有重复
        TenvdetailExample tenvdetailExample = new TenvdetailExample();
        tenvdetailExample.createCriteria()
                .andServiceidEqualTo(tenvdetail.getServiceid())
                .andEnvidEqualTo(tenvdetail.getEnvid())
                .andStatusGreaterThan(0);

        List<Tenvdetail> tenvdetailList = tenvdetailMapper.selectByExample(tenvdetailExample);
        if (tenvdetailList != null && tenvdetailList.size() > 0) {
            throw new HryException(StatusCodeEnum.EXIST_RECORD, "tenvdetail表中serviceId=" + tenvdetail.getServiceid() + ",envId=" + tenvdetail.getEnvid() + "的数据存在");
        }
        //插入数据
        return tenvdetailMapper.insertSelective(tenvdetail);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        Tenvdetail tenvdetail = new Tenvdetail();
        tenvdetail.setId(id);
        tenvdetail.setStatus(-1);
        return this.updateOne(tenvdetail);
    }

    /**
     * 根据条件删除tenvdetail记录,现在支持的条件 有serviceid和envid
     *
     * @param tenvdetail
     * @return
     */
    @Override
    public Integer deleteByCondition(Tenvdetail tenvdetail) {
        ReflectUtil.setInvalidFieldToNull(tenvdetail, false);
        if (tenvdetail == null || (tenvdetail.getServiceid() == null && tenvdetail.getEnvid() == null)) {
            throw new HryException(StatusCodeEnum.DANGER_OPERATION, "暂时只支持根据serviceid和envid删除tenvdetail记录");
        }
        TenvdetailExample tenvdetailExample = new TenvdetailExample();
        TenvdetailExample.Criteria criteria = tenvdetailExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tenvdetail.getServiceid() != null)
            criteria.andServiceidEqualTo(tenvdetail.getServiceid());
        if (tenvdetail.getEnvid() != null)
            criteria.andEnvidEqualTo(tenvdetail.getEnvid());
        Tenvdetail t = new Tenvdetail();
        t.setStatus(-1);
        return tenvdetailMapper.updateByExampleSelective(t, tenvdetailExample);
    }

    @Override
    public Tenvdetail selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return tenvdetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateOne(Tenvdetail tenvdetail) {
        ReflectUtil.setInvalidFieldToNull(tenvdetail, false);
        if (tenvdetail == null || tenvdetail.getId() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return tenvdetailMapper.updateByPrimaryKeySelective(tenvdetail);
    }

    @Override
    public List<Tenvdetail> selectByCondition(Tenvdetail tenvdetail) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tenvdetail, false);
        TenvdetailExample tenvdetailExample = new TenvdetailExample();
        TenvdetailExample.Criteria criteria = tenvdetailExample.createCriteria();
        if (tenvdetail != null) {
            if (tenvdetail.getId() != null)
                criteria.andIdEqualTo(tenvdetail.getId());
            if (tenvdetail.getServiceid() != null)
                criteria.andServiceidEqualTo(tenvdetail.getServiceid());
            if (tenvdetail.getEnvid() != null)
                criteria.andEnvidEqualTo(tenvdetail.getEnvid());
            if (tenvdetail.getHostinfo() != null)
                criteria.andHostinfoLike(tenvdetail.getHostinfo());
            if (tenvdetail.getDbinfo() != null)
                criteria.andDbinfoLike(tenvdetail.getDbinfo());
            if (tenvdetail.getSwaggerurl() != null)
                criteria.andSwaggerurlLike(tenvdetail.getSwaggerurl());
        }
        criteria.andStatusGreaterThan(0);
        List<Tenvdetail> tenvdetailList = tenvdetailMapper.selectByExample(tenvdetailExample);
        return tenvdetailList;
    }

    @Override
    public List<TenvdetailCustom> selectByCondition(TenvdetailCustom tenvdetailCustom) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tenvdetailCustom, true);
        List<TenvdetailCustom> tenvdetailCustomList = tenvdetailCustomMapper.selectByCondition(tenvdetailCustom);
        return tenvdetailCustomList;
    }

    @Override
    public PageInfo<TenvdetailCustom> selectByCondition(TenvdetailCustom tenvdetailCustom, Integer pageNum, Integer pageSize) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tenvdetailCustom, true);
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize, "serviceId ,envId");
        List<TenvdetailCustom> tenvdetailCustomList = tenvdetailCustomMapper.selectByCondition(tenvdetailCustom);
        PageInfo<TenvdetailCustom> pageInfo = new PageInfo<>(tenvdetailCustomList);
        return pageInfo;
    }
}
