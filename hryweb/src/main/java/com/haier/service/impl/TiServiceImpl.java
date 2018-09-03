package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.SortEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcaseMapper;
import com.haier.mapper.TiCustomMapper;
import com.haier.mapper.TiMapper;
import com.haier.po.*;
import com.haier.vo.TiWithCaseVO;
import com.haier.service.TcaseService;
import com.haier.service.TiService;
import com.haier.util.ReflectUtil;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 16:21
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class TiServiceImpl implements TiService {
    @Autowired
    TiMapper tiMapper;
    @Autowired
    TiCustomMapper tiCustomMapper;
    @Autowired
    TcaseMapper tcaseMapper;
    @Autowired
    TcaseService tcaseService;

    @Override
    public Integer insertOne(Ti ti) {
        tiMapper.insertSelective(ti);
        return ti.getId();
    }

    @Override
    public Integer updateOne(Ti ti) {
        return tiMapper.updateByPrimaryKeySelective(ti);
    }

    /**
     * @description: 删除tservice表记录时, 会同时删除ti表的记录, 所以一定要谨慎
     * @params: [id]
     * @return: java.lang.Integer
     * @author: luqiwei
     * @date: 2018-05-24
     */
    @Override
    public Integer deleteOne(Integer id) {
        //1.先删除tcase表中的记录
        Tcase tcase = new Tcase();
        tcase.setIid(id);
        tcaseService.deleteByCondition(tcase);

        //2.再删除ti表中的记录
        Ti ti = new Ti();
        ti.setId(id);
        ti.setIstatus(-1);
        return tiMapper.updateByPrimaryKeySelective(ti);
    }

    @Override
    public Integer deleteByCondition(Ti ti) {
        if (ti.getServiceid() == null) {
            return null;
        }
        //先删除tcase表中的记录
        Ti t = new Ti();
        t.setServiceid(ti.getServiceid());
        List<Ti> tis = this.selectByCondition(t);
        if (tis.size() > 0) {
            for (Ti i : tis) {
                Tcase tcase = new Tcase();
                tcase.setIid(i.getId());
                tcaseService.deleteByCondition(tcase);
            }
        }

        //再删除ti中的记录
        TiExample tiExample = new TiExample();
        tiExample.createCriteria()
                .andIstatusGreaterThan(0)
                .andServiceidEqualTo(ti.getServiceid());
        Ti i = new Ti();
        i.setIstatus(-1);
        return tiMapper.updateByExampleSelective(i, tiExample);
    }

    @Override
    public Ti selectOne(Integer id) {
        return tiMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TiCustom> selectByCondition(TiCustom tiCustom, Integer pageNum, Integer pageSize) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tiCustom, true);
        //如果未传入分页信息,默认查询第一页总共10条数据
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        List<TiCustom> tiCustomList = tiCustomMapper.selectByCondition(tiCustom);
        PageInfo<TiCustom> pageInfo = new PageInfo<>(tiCustomList);
        return pageInfo;
    }

    @Override
    public List<Ti> selectByCondition(Ti ti) {
        TiExample tiExample = new TiExample();
        TiExample.Criteria criteria = tiExample.createCriteria();
        criteria.andIstatusGreaterThan(0);
        if (ti != null) {
            if (ti.getServiceid() != null) {
                criteria.andServiceidEqualTo(ti.getServiceid());
            }
            if (ti.getIuri() != null) {
                criteria.andIuriEqualTo(ti.getIuri().replaceAll("%", ""));//iUri精确查询
            }
            if (ti.getRemark() != null) {
                criteria.andRemarkLike(ti.getRemark());
            }
            if (ti.getIdev() != null) {
                criteria.andIdevLike(ti.getIdev());
            }
            if (ti.getIparamsample() != null) {
                criteria.andIparamsampleLike(ti.getIparamsample());
            }
        }
        return tiMapper.selectByExample(tiExample);
    }

    @Override
    public List<TiWithCaseVO> selectTiWithCaseVO(Ti ti) {
        List<TiWithCaseVO> list = new ArrayList<>();
        List<Ti> tis = this.selectByCondition(ti);
        Tcase condition = new Tcase();
        condition.setServiceid(ti.getServiceid());
        condition.setIid(ti.getId());
        List<Tcase> tcases = tcaseService.selectByCondition(condition);
        for (Ti i : tis) {
            TiWithCaseVO vo = new TiWithCaseVO();
            ReflectUtil.cloneParentToChild(i, vo);
            List<Tcase> retTcase = new ArrayList<>();
            if (tcases != null && tcases.size() > 0) {
                Iterator<Tcase> iterator = tcases.iterator();
                /**
                 * 替换下面的实现,改成iterator迭代
                 */
                while (iterator.hasNext()) {
                    Tcase next = iterator.next();
                    if (i.getId().equals(next.getIid())) {
                        retTcase.add(next);
                        iterator.remove();
                    }
                }
                /**
                 * 下面注解的部分会引发ConcurrentModificationException异常
                 * 在List迭代中如果需要移除元素,不可以使用list.remove,
                 * https://www.cnblogs.com/dolphin0520/p/3933551.html
                 */
                /*
                for (Tcase tcase : tcases) {
                    if (i.getId().equals(tcase.getIid())) {
                        retTcase.add(tcase);
                        tcases.remove(tcase);//已经被接口匹配到,这里移除掉,减少tcases数组的长度,为下一次循环提升效率
                    }
                }*/
            }
            vo.setTcases(retTcase);
            list.add(vo);
        }
        return list;
    }
}
