package com.haier.service.impl;

import com.haier.enums.StatusCodeEnum;
import com.haier.exception.HryException;
import com.haier.mapper.TcustomMapper;
import com.haier.mapper.TenvMapper;
import com.haier.mapper.TserviceMapper;
import com.haier.po.*;
import com.haier.service.TcustomService;
import com.haier.service.TserviceService;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/28 15:36
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class TcustomServiceImpl implements TcustomService {
    @Autowired
    TcustomMapper tcustomMapper;

    @Autowired
    TenvMapper tenvMapper;

    @Autowired
    TserviceMapper tserviceMapper;

    @Autowired
    TserviceService tserviceService;

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
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        Tcustom tcustom = new Tcustom();
        tcustom.setId(id);
        tcustom.setStatus(-1);
        return this.updateOne(tcustom);
    }

    @Override
    public Tcustom selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "id必填");
        }
        return tcustomMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tcustom> selectByCondition(Tcustom tcustom) {
        TcustomExample tcustomExample = new TcustomExample();
        TcustomExample.Criteria criteria = tcustomExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tcustom != null) {
            if (tcustom.getUserid() != null) {
                criteria.andUseridEqualTo(tcustom.getUserid());
            }
        }
        return tcustomMapper.selectByExample(tcustomExample);
    }


    @Override
    public List<TcustomCustom> selectTcustomCustomByCondition(Tcustom tcustom) {
        List<TcustomCustom> tcustomCustoms = new ArrayList<>();
        List<Tcustom> tcustoms = this.selectByCondition(tcustom);

        if (tcustoms != null && tcustoms.size() > 0) {
            List<Tservice> var1=tserviceService.selectByCondition(null);
            //拿到所有Tservice
            Map<Integer,Tservice> map=new HashMap<>();
            if(var1!=null&&var1.size()>0){
                for(Tservice var2:var1){
                    map.put(var2.getId(),var2);
                }
            }

            for (Tcustom t : tcustoms) {
                TcustomCustom tcustomCustom = new TcustomCustom();
                ReflectUtil.clone(t, tcustomCustom);
                if (tcustomCustom.getEnvid() != null) {
                    Tenv tenv = tenvMapper.selectByPrimaryKey(tcustomCustom.getEnvid());
                    tcustomCustom.setEnvkey(tenv.getEnvkey());
                }
                String serviceid = tcustomCustom.getServiceid();
                List<Tservice> list = new ArrayList<>();
                if (serviceid != null) {
                    String[] ids = serviceid.trim().split(",");
                    for (String id : ids) {
                        try {
                            int i = Integer.parseInt(id);
                            Tservice tservice = map.get(i);
                            if (tservice != null)
                                list.add(tservice);
                        } catch (NumberFormatException e) {
                            log.error("serviceId String强转Integer失败");
                        }
                    }
                }
                tcustomCustom.setTserviceList(list);
                tcustomCustoms.add(tcustomCustom);
            }
            return tcustomCustoms;
        }
        return null;
    }

    @Override
    public void run(Integer id) {
        //
        Tcustom tcustom = new Tcustom();

        //this.selectByCondition()
    }
}
