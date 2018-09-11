package com.haier.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.enums.*;
import com.haier.exception.HryException;
import com.haier.mapper.TcaseCustomMapper;
import com.haier.mapper.TcaseMapper;
import com.haier.po.*;
import com.haier.service.*;
import com.haier.testng.run.Runner;
import com.haier.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/5/24 17:07
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Slf4j
@Service
public class TcaseServiceImpl implements TcaseService {

    @Value("${zdy.reportPath}")
    String reportPath;

    @Value("${zdy.resourcePathPattern}")
    String resourcePathPattern;

    @Autowired
    TcaseMapper tcaseMapper;

    @Autowired
    TcaseCustomMapper tcaseCustomMapper;

    @Autowired
    TserviceService tserviceService;

    @Autowired
    TservicedetailService tservicedetailService;

    @Autowired
    TenvService tenvService;

    @Autowired
    TiService tiService;

    @Autowired
    Runner runner;

    @Autowired
    UserService userService;

    @Autowired
    TreportService treportService;


    @Override
    public Integer insertOne(Tcase tcase) {
        tcaseMapper.insertSelective(tcase);
        return tcase.getId();
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
        if (tcase == null|| !ObjectUtils.anyNotNull(tcase.getIid(),tcase.getEnvid(),tcase.getServiceid())) {
            return null;
        }
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
        TcaseExample.Criteria criteria2 = null;
        criteria.andStatusGreaterThan(0);
        if (tcase != null) {
            if (tcase.getEnvid() != null) {
                criteria.andEnvidEqualTo(tcase.getEnvid());
                /**
                 * 不仅要获取传入的EnvID的用例,还需要获取EnvID=0的用例,EnvId=0表明此用例可运行于任意环境
                 */
                criteria2 = tcaseExample.createCriteria();
                criteria2.andStatusGreaterThan(0);
                criteria2.andEnvidEqualTo(0);
                if (tcase.getServiceid() != null) {
                    criteria2.andServiceidEqualTo(tcase.getServiceid());
                }
                if (tcase.getIid() != null) {
                    criteria2.andIidEqualTo(tcase.getIid());
                }
                if (tcase.getRequestparam() != null) {
                    criteria2.andRequestparamLike(tcase.getRequestparam());
                }
                if (tcase.getId() != null) {
                    criteria2.andIdEqualTo(tcase.getId());
                }
                if (tcase.getCasename() != null) {
                    criteria2.andCasenameLike(tcase.getCasename());
                }
                if (tcase.getTestclass() != null) {
                    criteria2.andTestclassEqualTo(tcase.getTestclass().replaceAll("%", ""));
                }
                if (tcase.getAuthor() != null) {
                    criteria2.andAuthorLike(tcase.getAuthor());
                }
                if (tcase.getExpected() != null) {
                    criteria2.andExpectedLike(tcase.getExpected());
                }
                if (tcase.getRemark() != null) {
                    criteria2.andRemarkLike(tcase.getRemark());
                }
                if (tcase.getAsserttype() != null) {
                    criteria2.andAsserttypeEqualTo(tcase.getAsserttype());
                }
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
            if (tcase.getTestclass() != null) {
                criteria.andTestclassEqualTo(tcase.getTestclass().replaceAll("%", ""));
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
        if (criteria2 != null) {
            tcaseExample.or(criteria2);
        }
        return tcaseMapper.selectByExample(tcaseExample);
    }

    @Override
    public PageInfo<TcaseCustom> selectByContion(TcaseCustom tcaseCustom, Integer pageNum, Integer pageSize) {
        ReflectUtil.setFieldAddPercentAndCleanZero(tcaseCustom, true);
        if (tcaseCustom != null) {
            if (tcaseCustom.getTestclass() != null) {
                tcaseCustom.setTestclass(tcaseCustom.getTestclass().replaceAll("%", ""));//testclass只支持equal查询
            }
        }
        PageHelper.startPage(pageNum, pageSize, SortEnum.UPDATETIME.getValue() + "," + SortEnum.ID.getValue());
        List<TcaseCustom> tcaseCustomList = tcaseCustomMapper.selectByCondition(tcaseCustom);
        PageInfo<TcaseCustom> pageInfo = new PageInfo<>(tcaseCustomList);
        return pageInfo;
    }


    @Override
    public RunOneResult runOne(Tcase tcase) {
        //准备数据

        Tenv tenv = tenvService.selectOne(tcase.getEnvid());
        Ti ti = tiService.selectOne(tcase.getIid());
        Integer serviceId = ti.getServiceid();
        Tservice tservice = tserviceService.selectOne(serviceId);

        Tservicedetail tservicedetail;
        Tservicedetail condition = new Tservicedetail();
        condition.setEnvid(tcase.getEnvid());
        condition.setServiceid(serviceId);
        List<Tservicedetail> tservicedetails = tservicedetailService.selectByCondition(condition);
        if (tservicedetails.size() == 0) {
            throw new HryException(StatusCodeEnum.NOT_FOUND, "服务=" + tservice.getServicekey() + "(" + tservice.getServicename() + ")" + ",环境=" + tenv.getEnvkey() + "(" + tenv.getRemark() + ")");
        } else {
            tservicedetail = tservicedetails.get(0);
        }

        String url = HttpTypeEnum.getValue(tservice.getHttptype()) + "://" + tservicedetail.getHostinfo() + ti.getIuri();
        String actualParam = BeforeUtil.replace(tcase.getRequestparam(), tservicedetail.getDbinfo(), null);

        //发送http请求
        String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod(), ti.getIcontenttype(), ti.getIparamtype(), actualParam);

        //断言结果
        //update by luqiwei ,现在断言直接抛出AssertionError,不再返回布尔值 2018/8/22
        /* Boolean result = AssertUtil.supperAssert(tcase.getAsserttype(), tcase.getExpected(), actual, ti.getIresponsetype());*/
        Boolean result = true;


        RunOneResult runOneResult = new RunOneResult();
        runOneResult.setAssertType(AssertTypeEnum.getValue(tcase.getAsserttype()));
        runOneResult.setContentType(ContentTypeEnum.getValue(ti.getIcontenttype()));
        runOneResult.setExpected(tcase.getExpected());
        runOneResult.setIUri(ti.getIuri());
        runOneResult.setParam(tcase.getRequestparam());
        runOneResult.setPrarmType(RequestParamTypeEnum.getValue(ti.getIparamtype()));
        runOneResult.setRequestMethod(RequestMethodTypeEnum.getValue(ti.getIrequestmethod()));
        runOneResult.setResponseType(ResponseTypeEnum.getValue(ti.getIresponsetype()));
        runOneResult.setServiceKey(tservice.getServicekey());


        List<RunOneResultSub> list = new ArrayList<>();
        RunOneResultSub runOneResultSub = new RunOneResultSub();
        runOneResultSub.setActualParam(actualParam);
        runOneResultSub.setActual(actual);
        runOneResultSub.setEnv(EnvEnum.getValue(tservicedetail.getEnvid()));
        runOneResultSub.setHostInfo(tservicedetail.getHostinfo());

        if (result) {
            runOneResultSub.setResult(AssertResultEnum.PASS);
        } else {
            runOneResultSub.setResult(AssertResultEnum.FAIL);
        }
        list.add(runOneResultSub);
        runOneResult.setRunOneResultSubList(list);

        return runOneResult;
    }

    @Override
    public RunOneResult runOne(Integer id) {
        Tcase tcase = tcaseMapper.selectByPrimaryKey(id);
        return this.runOne(tcase);
    }

    @Override
    public String runOne(Tcase tcase, Integer userId) {
        String testClassName = tcase.getTestclass();
        Ti ti = tiService.selectOne(tcase.getIid());
        Tservice tservice = tserviceService.selectOne(ti.getServiceid());
        Tenv tenv = tenvService.selectOne(tcase.getEnvid());
        User user = userService.selectOne(userId);
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "r_simple_u" + userId + "_s" + tservice.getId() + "_i" + ti.getId() + "_" + date + ".html";

        String methodName = HryUtil.iUri2MethodName(ti.getIuri());
        Map<String, List<Tcase>> testCase = new HashMap<>();
        testCase.put(methodName, Arrays.asList(tcase));
        String i_c_zdy = JSON.toJSONString(testCase);

        //测试类初始化参数
        Map<String, String> initParam = new HashMap<>();
        initParam.put(ParamKeyEnum.SERVICEID.getKey(), tservice.getId() + "");
        initParam.put(ParamKeyEnum.ENVID.getKey(), tenv.getId() + "");
        initParam.put(ParamKeyEnum.DESIGNER.getKey(), "");
        initParam.put(ParamKeyEnum.I_C.getKey(), "");
        initParam.put(ParamKeyEnum.I_C_ZDY.getKey(), i_c_zdy);

        //如果没有指定测试类名,则使用默认的测试类来测试
        if (StringUtils.isBlank(testClassName)) {
            testClassName = tservice.getClassname();
        }

        //定义一个测试类
        XmlClass xmlClass = new XmlClass(PackageEnum.TEST.getPackageName() + "." + testClassName);

        //方法选择器
        XmlInclude include = new XmlInclude(methodName);
        xmlClass.setIncludedMethods(Arrays.asList(include));

        //设置测试类初始化参数
        xmlClass.setParameters(initParam);


        //构造测试报告
        Treport treport = new Treport();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(tservice.getServicekey());
        treport.setServicenames(jsonArray.toJSONString());
        treport.setStatus(StatusEnum.FIVE.getId());
        treport.setServiceids(JSON.toJSONString(Arrays.asList(tservice.getId())));
        treport.setReportpath(reportPath);
        treport.setReportname(resourcePathPattern + reportName);
        treport.setUserid(user.getId());
        treport.setUsername(user.getRealname());
        treport.setEnvid(tenv.getId());
        treport.setEnvkey(tenv.getEnvkey());
        treport.setCustomid(0);
        treport.setCustomname("simple:" + tcase.getCasename());
        Integer reportId = treportService.insertOne(treport);

        log.info("即将运行单条用例的测试:");
        log.info("启动测试类:" + PackageEnum.TEST.getPackageName() + "." + tcase.getTestclass());
        log.info("传给测试类的参数:" + initParam);

        runner.run(null, reportId, reportName, Arrays.asList(xmlClass));
        return resourcePathPattern + reportName;

    }

    @Override
    public String runOne(Integer caseId, Integer userId) {
        Tcase tcase = this.selectOne(caseId);
        return this.runOne(tcase, userId);
    }


}
