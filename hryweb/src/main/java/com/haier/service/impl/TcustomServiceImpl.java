package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcustomMapper;
import com.haier.po.Tcustom;
import com.haier.po.TcustomExample;
import com.haier.service.TcustomService;
import com.haier.util.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:36
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class TcustomServiceImpl implements TcustomService {
    @Autowired
    TcustomMapper tcustomMapper;

    @Override
    public Integer insertOne(Tcustom tcustom) {
        ReflectUtil.setInvalidFieldToNull(tcustom, false);
        if (tcustom == null || tcustom.getEnvid() == null || tcustom.getServiceid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id,envId,serviceId必填!");
        }
        return tcustomMapper.insertSelective(tcustom);
    }

    @Override
    public Integer updateOne(Tcustom tcustom) {
        ReflectUtil.setInvalidFieldToNull(tcustom, false);
        if (tcustom == null || tcustom.getId() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填!");
        }

        return tcustomMapper.updateByPrimaryKeySelective(tcustom);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if(id==null||id==0){
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR,"id必填");
        }
        Tcustom tcustom=new Tcustom();
        tcustom.setId(id);
        tcustom.setStatus(-1);
        return this.updateOne(tcustom);
    }

    @Override
    public List<Tcustom> selectByCondition(Tcustom tcustom) {
        TcustomExample tcustomExample=new TcustomExample();
        TcustomExample.Criteria criteria = tcustomExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if(tcustom!=null){
            if(tcustom.getUserid()!=null){
                criteria.andUseridEqualTo(tcustom.getUserid());
            }
        }
        return tcustomMapper.selectByExample(tcustomExample);
    }
}
