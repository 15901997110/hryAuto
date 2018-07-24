package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TenvMapper;
import com.haier.po.Tcase;
import com.haier.po.Tenv;
import com.haier.po.TenvExample;
import com.haier.po.Tservicedetail;
import com.haier.service.TcaseService;
import com.haier.service.TenvService;
import com.haier.service.TservicedetailService;
import com.haier.util.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/9 9:31
 */
@Service
public class TenvServiceImpl implements TenvService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    TenvMapper tenvMapper;

    @Autowired
    TservicedetailService tservicedetailService;

    @Autowired
    TcaseService tcaseService;

    @Override
    public List<Tenv> selectAll() {
        List<Tenv> tenvs = tenvMapper.selectByExample(null);
        return tenvs;
    }

    @Override
    public Tenv selectOne(Integer id) {
        return tenvMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateOne(Integer id, Tenv tenv) {
        if (id == null || tenv == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        tenv.setId(id);
        return tenvMapper.updateByPrimaryKeySelective(tenv);
    }

    @Override
    public Integer insertOne(Tenv tenv) {
        ReflectUtil.setInvalidFieldToNull(tenv, false);
        if (tenv == null || tenv.getEnvkey() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "envkey必填");
        }
        //先判断数据是否存在
        TenvExample example = new TenvExample();
        example.createCriteria().andEnvkeyEqualTo(tenv.getEnvkey());
        List<Tenv> tenvList = tenvMapper.selectByExample(example);
        if (tenvList != null && tenvList.size() > 0) {
            throw new HryException(StatusCodeEnum.EXIST_RECORD, "envkey=" + tenv.getEnvkey() + "的记录已经存在");//抛出异常:记录存在
        }
        return tenvMapper.insertSelective(tenv);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        //先删除tservicedetail表中的记录
        Tservicedetail tservicedetail = new Tservicedetail();
        tservicedetail.setEnvid(id);
        tservicedetailService.deleteByCondition(tservicedetail);

        //删除tcase表中的记录
        Tcase tcase = new Tcase();
        tcase.setEnvid(id);
        tcaseService.deleteByCondition(tcase);

        //删除tenv表中的记录
        return tenvMapper.deleteByPrimaryKey(id);
    }
}
