package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.SortEnum;
import com.haier.mapper.TreportMapper;
import com.haier.po.Treport;
import com.haier.po.TreportExample;
import com.haier.service.TreportService;
import com.haier.util.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/5 10:47
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class TreportServiceImpl implements TreportService {

    @Autowired
    TreportMapper treportMapper;

    @Override
    public Integer insertOne(Treport treport) {
        treportMapper.insertSelective(treport);
        return treport.getId();
    }

    @Override
    public Integer updateOne(Treport treport) {
        return treportMapper.updateByPrimaryKeySelective(treport);
    }

    @Override
    public Integer deleteOne(Integer id) {
        Treport treport = new Treport();
        treport.setId(id);
        treport.setStatus(-1);
        return this.updateOne(treport);
    }

    @Override
    public Integer getStatus(String reportname) {
        TreportExample example = new TreportExample();
        example.createCriteria().andReportnameEqualTo(reportname);
        List<Treport> treports = treportMapper.selectByExample(example);
        if(treports!=null&&treports.size()>0){
            return treports.get(0).getStatus();
        }
        else{
            return -1;
        }
    }


    @Override
    public PageInfo<Treport> selectByCondition(Treport treport, Date startTime, Date endTime, Integer pageNum, Integer pageSize) {
        ReflectUtil.setFieldAddPercentAndCleanZero(treport, false);
        TreportExample example = new TreportExample();
        TreportExample.Criteria criteria = example.createCriteria();
        criteria.andStatusGreaterThan(0);//筛选状态status>0的数据
        if (treport != null) {
            if (treport.getCustomid() != null) {
                criteria.andCustomidEqualTo(treport.getCustomid());
            }
            if (treport.getEnvid() != null) {
                criteria.andEnvidEqualTo(treport.getEnvid());
            }
            if (treport.getUserid() != null) {
                criteria.andUseridEqualTo(treport.getUserid());
            }
            if (treport.getCustomname() != null) {
                criteria.andCustomnameLike(treport.getCustomname());
            }
            if (treport.getEnvkey() != null) {
                criteria.andEnvkeyLike(treport.getEnvkey());
            }
            if (treport.getUsername() != null) {
                criteria.andUsernameLike(treport.getUsername());
            }
            if (treport.getReportname() != null) {
                criteria.andReportnameLike(treport.getReportname());
            }
            if (treport.getStatus() != null) {
                criteria.andStatusEqualTo(treport.getStatus());
            }
        }
        if (startTime != null) {
            criteria.andTesttimeGreaterThanOrEqualTo(startTime);//>=开始时间
        }
        if (endTime != null) {
            criteria.andTesttimeLessThan(endTime);//<结束时间
        }

        PageHelper.startPage(pageNum, pageSize, SortEnum.TESTTIME.getValue() + "," + SortEnum.ID.getValue());
        List<Treport> treports = treportMapper.selectByExample(example);
        PageInfo<Treport> pageInfo = new PageInfo<>(treports);
        return pageInfo;
    }
}
