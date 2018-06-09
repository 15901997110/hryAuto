package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.*;
import com.haier.exception.HryException;
import com.haier.mapper.*;
import com.haier.po.*;
import com.haier.service.TcaseService;
import com.haier.util.AssertUtil;
import com.haier.util.HryHttpClientUtil;
import com.haier.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/24 17:07
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class TcaseServiceImpl implements TcaseService {

    @Autowired
    TcaseMapper tcaseMapper;

    @Autowired
    TcaseCustomMapper tcaseCustomMapper;

    @Autowired
    TiMapper tiMapper;

    @Autowired
    TserviceMapper tserviceMapper;

    @Autowired
    TenvMapper tenvMapper;

    @Autowired
    TenvdetailMapper tenvdetailMapper;

    @Override
    public Integer insertOne(Tcase tcase) {
        //参数校验,注意,这些参数应该在前端直接js校验效果会更好
        if (tcase == null || tcase.getIid() == null || tcase.getCasename() == null
                || tcase.getIid() == 0 || "".equals(tcase.getCasename())) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return tcaseMapper.insertSelective(tcase);
    }

    @Override
    public Integer deleteOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        Tcase tcase = new Tcase();
        tcase.setId(id);
        tcase.setStatus((short) -1);
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Integer deleteByCondition(Tcase tcase){
        //暂时只实现根据iId,envId删除的功能
        ReflectUtil.setInvalidFieldToNull(tcase,false);
        if(tcase==null||(tcase.getIid()==null&&tcase.getEnvid()==null)){
            throw new HryException(StatusCodeEnum.DANGER_OPERATION,"只支持根据iid和envid删除case");
        }
        TcaseExample tcaseExample=new TcaseExample();
        TcaseExample.Criteria criteria = tcaseExample.createCriteria();
        criteria.andStatusGreaterThan((short)0);
        if(tcase.getIid()!=null){
            criteria.andIidEqualTo(tcase.getIid());
        }
        if(tcase.getEnvid()!=null){
            criteria.andEnvidEqualTo(tcase.getEnvid());
        }
        Tcase t=new Tcase();
        t.setStatus((short)-1);
        return tcaseMapper.updateByExampleSelective(t, tcaseExample);
    }

    @Override
    public Integer updateOne(Integer id, Tcase tcase) {
        if (tcase == null || tcase.getId() == null || tcase.getId() == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        tcase.setId(id);
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Tcase selectOne(Integer id) {
        if (id == null || id == 0) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR);
        }
        return tcaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom, Integer pageNum, Integer pageSize) {
        //javabean中的属性进行处理,针对String类型的并且存在非空值的属性,前后都添加%,这样在后面的查询中可以直接like
        if (tcaseCustom != null) {
            ReflectUtil.setFieldAddPercentAndCleanZero(tcaseCustom, true);
        }

        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        List<TcaseCustom> tcaseCustomList = tcaseCustomMapper.selectByCondition(tcaseCustom);
        PageInfo<TcaseCustom> pageInfo = new PageInfo<>(tcaseCustomList);
        return pageInfo;
    }


    @Override
    public RunOneResult runOne(Tcase tcase) throws HttpProcessException {
        ReflectUtil.setInvalidFieldToNull(tcase, false);

        if (tcase == null || tcase.getIid() == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "接口id必填!");
        }
        //准备数据
        Integer iId = tcase.getIid();
        Integer envId = tcase.getEnvid();
        if (iId == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "此case对应的接口不可为空!");
        }
        Ti ti = tiMapper.selectByPrimaryKey(iId);
        Tservice tservice = tserviceMapper.selectByPrimaryKey(ti.getServiceid());
        Integer httpType = tservice.getHttptype() + 0;
        TenvdetailExample tenvdetailExample = new TenvdetailExample();
        TenvdetailExample.Criteria criteria = tenvdetailExample.createCriteria();
        criteria.andStatusGreaterThan(0);//查询status>0的数据
        criteria.andServiceidEqualTo(tservice.getId());//查询serviceId
        if (envId != null) {
            criteria.andEnvidEqualTo(envId);//如果envId!=null,查询此envId,否则,查询所有envd数据
        }
        List<Tenvdetail> tenvdetailList = tenvdetailMapper.selectByExample(tenvdetailExample);
        if (tenvdetailList == null && tenvdetailList.size() < 1) {
            throw new HryException(StatusCodeEnum.NOT_FOUND, "服务环境映射表中未找到serviceId=" + tservice.getId() + ",envId=" + envId + "的数据");
        }
        Object param;
        if (ti.getIparamtype() != null) {
            if (tcase.getRequestparam() != null && "".equals(tcase.getRequestparam().trim())) {
                //参数类型为Json,且参数内容不为空
                if (RequestParamTypeEnum.REQUEST_PARAM_TYPE_JSON.getId() == ti.getIparamtype() + 0) {
                    param = JSON.parseObject(tcase.getRequestparam());
                }
                //参数类型为Map,且参数内容不为空
                else if (RequestParamTypeEnum.REQUEST_PARAM_TYPE_MAP.getId() == ti.getIparamtype() + 0) {
                    //暂未实现,具体遇到此种情况,再来实现
                    throw new HryException(StatusCodeEnum.PARAMS_FORMAT_ERROR, "现在仅支持Json格式参数!不支持Map");
                } else {
                    throw new HryException(StatusCodeEnum.PARAMS_FORMAT_ERROR, "现在仅支持Json格式参数!");
                }
            } else {
                log.warn("注意:参数值为null,系统将传空参数发送请求!!!");
                param = null;
            }
        } else {
            log.warn("注意:并没有指定参数类型,系统将传空参数发送请求!!!");
            param = null;
        }

        RunOneResult runOneResult=new RunOneResult();
        runOneResult.setAssertType(AssertTypeEnum.getValue(tcase.getAsserttype()));
        runOneResult.setContentType(ContentTypeEnum.getValue(ti.getIcontenttype()));
        runOneResult.setExpected(tcase.getExpected());
        runOneResult.setIUri(ti.getIuri());
        runOneResult.setParam(tcase.getRequestparam());
        runOneResult.setPrarmType(RequestParamTypeEnum.getValue(ti.getIparamtype()));
        runOneResult.setRequestMethod(RequestMethodTypeEnum.getValue(ti.getIrequestmethod()+0));
        runOneResult.setResponseType(ResponseTypeEnum.getValue(ti.getIresponsetype()));
        runOneResult.setServiceKey(tservice.getServicekey());


        List<RunOneResultSub> list=new ArrayList<>();

        for (Tenvdetail tenvdetail : tenvdetailList) {
            RunOneResultSub runOneResultSub =new RunOneResultSub();
            //发送http请求
            String url = HttpTypeEnum.getValue(httpType) + "://" + tenvdetail.getHostinfo() + ti.getIuri();
            String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod()+0, param);

            //断言结果
            Boolean result=AssertUtil.supperAssert(tcase.getAsserttype()+0,tcase.getExpected(),actual,ti.getIresponsetype()+0);

            runOneResultSub.setActual(actual);
            runOneResultSub.setEnv(EnvEnum.getValue(tenvdetail.getEnvid()));
            runOneResultSub.setHostInfo(tenvdetail.getHostinfo());
            if(result){
                runOneResultSub.setResult(AssertResultEnum.PASS);
            }else{
                runOneResultSub.setResult(AssertResultEnum.FAIL);
            }
            list.add(runOneResultSub);
        }
        runOneResult.setRunOneResultSubList(list);

        return runOneResult;
    }
}
