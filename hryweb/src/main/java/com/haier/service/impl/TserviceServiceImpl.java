package com.haier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.anno.SKey;
import com.haier.enums.PackageEnum;
import com.haier.enums.SortEnum;
import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TiMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.TservicedetailService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import com.haier.util.ClassUtil;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Tservice selectOne(String className) {
        if (className == null)
            return null;
        Tservice tservice = new Tservice();
        tservice.setClassname(className);
        List<Tservice> tservices = this.selectByCondition(tservice);
        if (tservices != null && tservices.size() > 0) {
            return tservices.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<Tservice> selectByCondition(Tservice tservice, Integer pageNum, Integer pageSize) {
        TserviceExample tserviceExample = new TserviceExample();

        TserviceExample.Criteria criteria = tserviceExample.createCriteria();
        criteria.andIsdelNotEqualTo(1);
        //如果传入的对象不是null,则设置查询条件
        if (tservice != null) {
            if (tservice.getId() != null) {
                criteria.andIdEqualTo(tservice.getId());
            }
            if (tservice.getServicekey() != null) {
                criteria.andServicekeyLike(tservice.getServicekey());
            }
            if (tservice.getServicename() != null) {
                criteria.andServicenameLike(tservice.getServicename());
            }
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
        tserviceExample.setOrderByClause(SortEnum.UPDATETIME.getValue());
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
            if (tservice.getClassname() != null)
                criteria.andClassnameEqualTo(tservice.getClassname().replaceAll("%", ""));
        }
        return tserviceMapper.selectByExample(tserviceExample);
    }

    @Override
    public Integer updateOne(Tservice tservice) {
        return tserviceMapper.updateByPrimaryKeySelective(tservice);
    }

    @Override
    public Integer insertOne(Tservice tservice) {
        tserviceMapper.insertSelective(tservice);
        return tservice.getId();
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

    @Override
    public Map<String, List<String>> getTestClasses() {
        Map<String, List<String>> ret = new HashMap<>();
        List<String> baseClassNames = ClassUtil.getClassName(PackageEnum.BASE.getPackageName());
        List<String> testClassNames = ClassUtil.getClassName(PackageEnum.TEST.getPackageName());
        //循环base类,找到Skey
        for (String baseClassName : baseClassNames) {
            List<String> list = new ArrayList<>();
            String baseClassSkeyValue = null;
            try {
                Class<?> baseClass = Class.forName(baseClassName);
                try {
                    baseClassSkeyValue = baseClass.getAnnotation(SKey.class).value();

                    //循环test类
                    for (String testClassName : testClassNames) {
                        String simpleTestClassName;
                        try {
                            Class<?> testClass = Class.forName(testClassName);
                            simpleTestClassName = testClass.getSimpleName();
                            try {
                                String testClassSkeyValue = testClass.getAnnotation(SKey.class).value();
                                if (testClassSkeyValue.equals(baseClassSkeyValue)) {
                                    list.add(simpleTestClassName);
                                }
                            } catch (NullPointerException e) {

                            }
                        } catch (ClassNotFoundException e) {

                        }
                    }
                } catch (NullPointerException e) {

                }

            } catch (ClassNotFoundException e) {

            }
            if (StringUtils.isNotBlank(baseClassSkeyValue)) {
                ret.put(baseClassSkeyValue, list);
            }
        }
        return ret;
    }

    @Override
    public List<String> getTestClasses(String sKey) {
        Map<String, List<String>> testClasses = this.getTestClasses();
        List<String> strings = testClasses.get(sKey);
        return strings == null ? new ArrayList<>() : strings;
    }
}
