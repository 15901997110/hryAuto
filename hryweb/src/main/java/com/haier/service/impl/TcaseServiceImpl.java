package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.*;
import com.haier.exception.HryException;
import com.haier.mapper.*;
import com.haier.po.*;
import com.haier.service.TcaseService;
import com.haier.service.TiService;
import com.haier.util.AssertUtil;
import com.haier.util.BeforeUtil;
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
    TservicedetailMapper tservicedetailMapper;

    @Autowired
    TiService tiService;

    @Override
    public Integer insertOne(Tcase tcase) {
        return tcaseMapper.insertSelective(tcase);
    }

    @Override
    public Integer deleteOne(Integer id) {
        Tcase tcase = new Tcase();
        tcase.setId(id);
        tcase.setStatus(StatusEnum._ONE.getId());
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Integer deleteByCondition(Tcase tcase) {
       /* //暂时只实现根据iId,envId删除的功能
        ReflectUtil.setInvalidFieldToNull(tcase, false);
        if (tcase == null || (tcase.getIid() == null && tcase.getEnvid() == null)) {
            throw new HryException(StatusCodeEnum.DANGER_OPERATION, "只支持根据serviceid,iid和envid删除case");
        }*/
        TcaseExample tcaseExample = new TcaseExample();
        TcaseExample.Criteria criteria = tcaseExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tcase != null) {
            if (tcase.getIid() != null) {
                criteria.andIidEqualTo(tcase.getIid());
            }
            if (tcase.getEnvid() != null) {
                criteria.andEnvidEqualTo(tcase.getEnvid());
            }
            if (tcase.getServiceid() != null) {
                criteria.andServiceidEqualTo(tcase.getServiceid());
            }
        } else {
            return null;
        }
        Tcase t = new Tcase();
        t.setStatus(StatusEnum._ONE.getId());
        return tcaseMapper.updateByExampleSelective(t, tcaseExample);
    }

    @Override
    public Integer updateOne(Tcase tcase) {
        return tcaseMapper.updateByPrimaryKeySelective(tcase);
    }

    @Override
    public Tcase selectOne(Integer id) {
        return tcaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tcase> selectByCondition(Tcase tcase) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tcase, false);
        TcaseExample tcaseExample = new TcaseExample();
        TcaseExample.Criteria criteria = tcaseExample.createCriteria();
        criteria.andStatusGreaterThan(0);
        if (tcase != null) {
            if (tcase.getEnvid() != null) {
                criteria.andEnvidEqualTo(tcase.getEnvid());
            }
            if (tcase.getServiceid() != null) {
                criteria.andServiceidEqualTo(tcase.getServiceid());
            }
            if (tcase.getIid() != null) {
                criteria.andIidEqualTo(tcase.getIid());
            }
            if (tcase.getRequestparam() != null) {
                criteria.andRequestparamLike(tcase.getRequestparam());
            }
            if (tcase.getId() != null) {
                criteria.andIdEqualTo(tcase.getId());
            }
            if (tcase.getCasename() != null) {
                criteria.andCasenameLike(tcase.getCasename());
            }
            if (tcase.getAuthor() != null) {
                criteria.andAuthorLike(tcase.getAuthor());
            }
            if (tcase.getExpected() != null) {
                criteria.andExpectedLike(tcase.getExpected());
            }
            if (tcase.getRemark() != null) {
                criteria.andRemarkLike(tcase.getRemark());
            }
            if (tcase.getAsserttype() != null) {
                criteria.andAsserttypeEqualTo(tcase.getAsserttype());
            }
        }
        return tcaseMapper.selectByExample(tcaseExample);
    }

    @Override
    public PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom, Integer pageNum, Integer pageSize) {
        //javabean中的属性进行处理,针对String类型的并且存在非空值的属性,前后都添加%,这样在后面的查询中可以直接like
        ReflectUtil.setFieldAddPercentAndCleanZero(tcaseCustom, true);

        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        List<TcaseCustom> tcaseCustomList = tcaseCustomMapper.selectByCondition(tcaseCustom);
        PageInfo<TcaseCustom> pageInfo = new PageInfo<>(tcaseCustomList);
        return pageInfo;
    }


    @Override
    public RunOneResult runOne(Tcase tcase) throws HttpProcessException {
        ReflectUtil.setInvalidFieldToNull(tcase, false);
        //准备数据
        Integer iId = tcase.getIid();
        Integer envId = tcase.getEnvid();
        if (iId == null) {
            throw new HryException(StatusCodeEnum.PARAMETER_ERROR, "此case对应的接口不可为空!");
        }
        Ti ti = tiMapper.selectByPrimaryKey(iId);
        Tservice tservice = tserviceMapper.selectByPrimaryKey(ti.getServiceid());
        Integer httpType = tservice.getHttptype();
        TservicedetailExample tservicedetailExample = new TservicedetailExample();
        TservicedetailExample.Criteria criteria = tservicedetailExample.createCriteria();
        criteria.andStatusGreaterThan(0);//查询status>0的数据
        criteria.andServiceidEqualTo(tservice.getId());//查询serviceId
        if (envId != null) {
            criteria.andEnvidEqualTo(envId);//如果envId!=null,查询此envId,否则,查询所有envd数据
        }
        List<Tservicedetail> tservicedetailList = tservicedetailMapper.selectByExample(tservicedetailExample);
        if (tservicedetailList == null || tservicedetailList.size() < 1) {
            throw new HryException(StatusCodeEnum.NOT_FOUND, "服务环境映射表中未找到serviceId=" + tservice.getId() + ",envId=" + envId + "的数据" +
                    ",case必须基于环境来运行");
        }
        Object param;
        String requestparam = tcase.getRequestparam();


        RunOneResult runOneResult = new RunOneResult();
        runOneResult.setAssertType(AssertTypeEnum.getValue(tcase.getAsserttype()));
        runOneResult.setContentType(ContentTypeEnum.getValue(ti.getIcontenttype()));
        runOneResult.setExpected(tcase.getExpected());
        runOneResult.setIUri(ti.getIuri());
        runOneResult.setParam(requestparam);
        runOneResult.setPrarmType(RequestParamTypeEnum.getValue(ti.getIparamtype()));
        runOneResult.setRequestMethod(RequestMethodTypeEnum.getValue(ti.getIrequestmethod()));
        runOneResult.setResponseType(ResponseTypeEnum.getValue(ti.getIresponsetype()));
        runOneResult.setServiceKey(tservice.getServicekey());


        List<RunOneResultSub> list = new ArrayList<>();


        //根据环境信息,遍历执行用例
        for (Tservicedetail tservicedetail : tservicedetailList) {
            String actualParam = requestparam;
            if (ti.getIparamtype() != null) {//参数类型有填写
                //处理参数-前置统一处理,匹配各种<<<xxx>>>关键字
                if (requestparam != null && !"".equals(requestparam.trim())) {
                    actualParam = requestparam.replaceAll("\\n", "").trim();

                    JSONObject dbinfo = null;
                    try {
                        dbinfo = JSON.parseObject(tservicedetail.getDbinfo());
                    } catch (Exception e) {
                        log.warn("dbinfo转换异常,系统将当成dbinfo=null来处理");
                    }
                    while (BeforeUtil.needReplace(actualParam)) {
                        actualParam = BeforeUtil.replace(actualParam, dbinfo);
                    }
                }
                log.debug("实际请求参数:" + actualParam);

                if (actualParam != null && !"".equals(actualParam.trim())) {
                    //参数类型为Json,且参数内容不为空
                    if (RequestParamTypeEnum.JSON.getId() == ti.getIparamtype()) {
                        try {
                            param = JSON.parseObject(actualParam);
                        } catch (RuntimeException e) {
                            log.error("参数类型指定为JSON,然而实际参数无法转换成JSON", e);
                            throw new HryException(StatusCodeEnum.PARSE_JSON_ERROR, "参数类型指定为JSON,然而实际参数无法转换成JSON");
                        }
                    }

                    //参数类型为Map,且参数内容不为空
                    else if (RequestParamTypeEnum.MAP.getId() == ti.getIparamtype()) {
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
            RunOneResultSub runOneResultSub = new RunOneResultSub();
            runOneResultSub.setActualParam(actualParam);
            //发送http请求
            String url = HttpTypeEnum.getValue(httpType) + "://" + tservicedetail.getHostinfo() + ti.getIuri();
            String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod(), param);

            //断言结果
            Boolean result = AssertUtil.supperAssert(tcase.getAsserttype(), tcase.getExpected(), actual, ti.getIresponsetype());

            runOneResultSub.setActual(actual);
            runOneResultSub.setEnv(EnvEnum.getValue(tservicedetail.getEnvid()));
            runOneResultSub.setHostInfo(tservicedetail.getHostinfo());
            if (result) {
                runOneResultSub.setResult(AssertResultEnum.PASS);
            } else {
                runOneResultSub.setResult(AssertResultEnum.FAIL);
            }
            list.add(runOneResultSub);
        }
        runOneResult.setRunOneResultSubList(list);

        return runOneResult;
    }

    @Override
    public RunOneResult runOne(Integer id) throws HttpProcessException {
        Tcase tcase = tcaseMapper.selectByPrimaryKey(id);
        return this.runOne(tcase);
    }
}
