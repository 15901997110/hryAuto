package com.haier.service.impl;

import com.haier.po.Ti;
import com.haier.po.Tservice;
import com.haier.service.AutocodeService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import com.haier.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/25 11:26
 */
@Service
@Slf4j
public class AutocodeServiceImpl implements AutocodeService {
    private static final String sPackage = "package com.haier.testng.cases;\n";
    private static final String sImport = "import com.alibaba.fastjson.JSONArray;\n" +
            "import com.alibaba.fastjson.JSONObject;\n" +
            "import com.haier.enums.HttpTypeEnum;\n" +
            "import com.haier.po.*;\n" +
            "import com.haier.service.RunService;\n" +
            "import com.haier.util.AssertUtil;\n" +
            "import com.haier.util.BeforeUtil;\n" +
            "import com.haier.util.HryHttpClientUtil;\n" +
            "import com.haier.util.SpringContextHolder;\n" +
            "import lombok.extern.slf4j.Slf4j;\n" +
            "import org.testng.Assert;\n" +
            "import org.testng.Reporter;\n" +
            "import org.testng.SkipException;\n" +
            "import org.testng.annotations.BeforeClass;\n" +
            "import org.testng.annotations.DataProvider;\n" +
            "import org.testng.annotations.Parameters;\n" +
            "import org.testng.annotations.Test;\n" +
            "\n" +
            "import java.lang.reflect.Method;\n" +
            "import java.util.Iterator;\n" +
            "import java.util.List;";
    private static final String sClass = "@Slf4j\n" +
            "public class ${className}";
    private static final String sField = "private Integer serviceId;\n" +
            "    private Integer envId;\n" +
            "    private String caseDesigner;\n" +
            "    private String i_c;//接收外部传参,定制的用例\n" +
            "    private JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型\n" +
            "    private String baseUrl;//http://host:port\n" +
            "    private String url;\n" +
            "    private Tservice tservice;\n" +
            "    private Tservicedetail tservicedetail;\n" +
            "    private RunService runService = SpringContextHolder.getBean(RunService.class);\n";
    private static final String sMethodBefore = "@Parameters({\"serviceId\", \"envId\", \"caseDesigner\", \"i_c\"})\n" +
            "    @BeforeClass\n" +
            "    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {\n" +
            "        this.serviceId = serviceId;\n" +
            "        this.envId = envId;\n" +
            "        this.caseDesigner = caseDesigner;\n" +
            "        this.i_c = i_c;\n" +
            "        if (this.i_c != null && !\"\".equals(this.i_c)) {\n" +
            "            this.i_c_JSONObject = JSONObject.parseObject(i_c);\n" +
            "        }\n" +
            "        tservice = runService.getTservice(this.serviceId);\n" +
            "        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);\n" +
            "        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + \"://\" + tservicedetail.getHostinfo();\n" +
            "    }\n";
    private static final String sMethodProvider = " @DataProvider(name = \"provider\")\n" +
            "    public Object[] getCase(Method method) {\n" +
            "\n" +
            "        Object[] objects;\n" +
            "        String iUri;\n" +
            "        //testName可能未填写\n" +
            "        try {\n" +
            "            iUri = method.getAnnotation(Test.class).testName();\n" +
            "            if (iUri == null || \"\".equals(iUri)) {\n" +
            "                Reporter.log(\"测试方法中没有没有@Test(testName=\\\"\\\")注解\");\n" +
            "                throw new SkipException(\"测试方法中没有没有@Test(testName=\\\"\\\")注解\");\n" +
            "            }\n" +
            "        } catch (NullPointerException e) {\n" +
            "            log.error(\"获取测试方法的@Test注解异常:\" + method.getName(), e);\n" +
            "            throw new SkipException(\"获取测试方法的@Test注解异常\");\n" +
            "        }\n" +
            "\n" +
            "        Ti ti = runService.getTi(this.serviceId, iUri);\n" +
            "        if (ti == null) {\n" +
            "            return null;\n" +
            "        }\n" +
            "        //此接口对应的全部用例\n" +
            "        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);\n" +
            "        if (tcases == null || tcases.size() == 0) {\n" +
            "            return null;\n" +
            "        }\n" +
            "\n" +
            "        //如果用户有定制测试用例,则使用用户定制的用例来进行测试\n" +
            "        if (this.i_c_JSONObject != null && this.i_c_JSONObject.size() > 0) {\n" +
            "            JSONArray customCaseArray = i_c_JSONObject.getJSONArray(method.getName());\n" +
            "            if (customCaseArray != null && customCaseArray.size() > 0) {\n" +
            "                Iterator<Tcase> iterator = tcases.iterator();\n" +
            "                while (iterator.hasNext()) {\n" +
            "                    Tcase tcase = iterator.next();\n" +
            "                    //数据库中查到的caseid不在定制列表中,则移除掉\n" +
            "                    if (!customCaseArray.contains(tcase.getId())) {\n" +
            "                        iterator.remove();\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "        objects = new Object[tcases.size()];\n" +
            "        for (int i = 0; i < tcases.size(); i++) {\n" +
            "            Params params = new Params();\n" +
            "            params.setTi(ti);\n" +
            "            params.setTcase(tcases.get(i));\n" +
            "            objects[i] = params;\n" +
            "        }\n" +
            "        return objects;\n" +
            "    }\n";
    private static final String sMethodGetBoolResult = "  public Boolean getBoolResult(Params params) {\n" +
            "        if (params == null || params.getTcase() == null || params.getTcase() == null) {\n" +
            "            return false;\n" +
            "        }\n" +
            "        Ti ti = params.getTi();\n" +
            "        Tcase tcase = params.getTcase();\n" +
            "        url = baseUrl + ti.getIuri();\n" +
            "        String requestParam = BeforeUtil.replace(tcase.getRequestparam(), tservicedetail.getDbinfo());\n" +
            "        Reporter.log(\"实际请求参数 : \");\n" +
            "        Reporter.log(requestParam);\n" +
            "        String actual = HryHttpClientUtil.send(url, ti.getIrequestmethod() + 0, ti.getIcontenttype() + 0, ti.getIparamtype() + 0, requestParam);\n" +
            "        return AssertUtil.supperAssert(tcase.getAsserttype() + 0, tcase.getExpected(), actual, ti.getIresponsetype() + 0);\n" +
            "    }\n";
    private static final String sMethodTest = "    @Test(testName = \"${annoTestName}\", dataProvider = \"provider\", description = \"${annoDesc}\")\n" +
            "    public void ${testMethodName}(Params params) {\n" +
            "        Reporter.log(\"用例设计参数 : \");\n" +
            "        Reporter.log(params.getTcase().getRequestparam());\n" +
            "        Assert.assertTrue(this.getBoolResult(params));\n" +
            "    }\n";

    private static final String sBraceLeft = "{";
    private static final String sBraceRight = "}";

    @Value("${zdy.autoCodeDir}")
    String autoCodeDir;

    @Autowired
    TserviceService tserviceService;

    @Autowired
    TiService tiService;

    @Override
    public void generate() {
        List<Tservice> tservices = tserviceService.selectByCondition(null);
        for (Tservice tservice : tservices) {

            if (tservice.getClassname() == null || "".equals(tservice.getClassname())) {
                log.warn("服务id=" + tservice.getId() + ",默认测试类名未填写,无法生成测试类");
                continue;
            }
            Ti condition = new Ti();
            condition.setServiceid(tservice.getId());
            List<Ti> tis = tiService.selectByCondition(condition);
            if (tis == null || tis.size() == 0) {
                log.warn("服务id=" + tservice.getId() + ",此服务无有效接口信息,无需生成测试类");
                continue;
            }

            StringBuffer sb = new StringBuffer();
            String className = tservice.getClassname();
            sb.append(sPackage);
            sb.append(sImport);
            sb.append(sClass.replace("${className}", className));
            sb.append(sBraceLeft);
            sb.append(sField);
            sb.append(sMethodBefore);
            sb.append(sMethodProvider);
            sb.append(sMethodGetBoolResult);
            for (Ti ti : tis) {
                String iUri = ti.getIuri();
                String desc = ti.getRemark();
                String testMethodName = iUri.substring(iUri.indexOf("/") + 1).replaceAll("/", "_");
                String testMethod = sMethodTest.replaceAll("\\$\\{annoTestName\\}", iUri)
                        .replaceAll("\\$\\{annoDesc\\}", desc)
                        .replaceAll("\\$\\{testMethodName\\}", testMethodName);
                sb.append(testMethod);
            }
            sb.append(sBraceRight);

            String fileName = autoCodeDir + className + ".java";

            FileUtil.saveContent(sb.toString(), fileName);
        }
    }
}
