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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/25 11:26
 */
@Service
@Slf4j
public class AutocodeServiceImpl implements AutocodeService {
    private static final String baseHead = "package com.haier.testng.base;\n" +
            "\n" +
            "import com.alibaba.fastjson.JSONArray;\n" +
            "import com.alibaba.fastjson.JSONObject;\n" +
            "import com.haier.anno.SKey;\n" +
            "import com.haier.anno.Uri;\n" +
            "import com.haier.enums.HttpTypeEnum;\n" +
            "import com.haier.po.*;\n" +
            "import com.haier.service.RunService;\n" +
            "import com.haier.util.HryHttpClientUtil;\n" +
            "import com.haier.util.SpringContextHolder;\n" +
            "import lombok.extern.slf4j.Slf4j;\n" +
            "import org.apache.commons.lang3.StringUtils;\n" +
            "import org.testng.Reporter;\n" +
            "import org.testng.SkipException;\n" +
            "import org.testng.annotations.Test;\n" +
            "\n" +
            "import java.lang.reflect.Method;\n" +
            "import java.util.Iterator;\n" +
            "import java.util.List;\n";
    private static final String defaultHead = "package com.haier.testng.test;\n" +
            "\n" +
            "import com.haier.po.Params;\n" +
            "import com.haier.testng.base.${supperClassName};\n" +
            "import com.haier.util.AssertUtil;\n" +
            "import lombok.extern.slf4j.Slf4j;\n" +
            "import org.testng.annotations.BeforeClass;\n" +
            "import org.testng.annotations.DataProvider;\n" +
            "import org.testng.annotations.Parameters;\n" +
            "import org.testng.annotations.Test;\n" +
            "\n" +
            "import java.lang.reflect.Method;\n";
    private static final String baseClass = "/**\n" +
            " * @Description: ${baseClassName}\n" +
            " * @Author: 自动生成\n" +
            " * @Date: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\n" +
            " */\n" +
            "@SuppressWarnings(\"Duplicates\")\n" +
            "@Slf4j\n" +
            "@SKey(\"${SKey}\")\n" +
            "public class ${baseClassName}";

    private static final String defaultClass = "/**\n" +
            " * @Description: ${defaultClassName}\n" +
            " * @Author: 自动生成\n" +
            " * @Date: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\n" +
            " */\n" +
            "@SuppressWarnings(\"Duplicates\")\n" +
            "@Slf4j\n" +
            "public class ${defaultClassName} extends ${supperClassName}";

    private static final String defaultCommon = "    @Parameters({\"serviceId\", \"envId\", \"caseDesigner\", \"i_c\"})\n" +
            "    @BeforeClass\n" +
            "    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c) {\n" +
            "        init(serviceId, envId, caseDesigner, i_c);\n" +
            "    }\n" +
            "\n" +
            "    @DataProvider(name = \"provider\")\n" +
            "    public Object[] getCase(Method method) {\n" +
            "        return provider(method);\n" +
            "    }\n\n";

    private static final String baseCommon = "    public Integer serviceId;\n" +
            "    public Integer envId;\n" +
            "    public String caseDesigner;\n" +
            "    public JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型\n" +
            "    public String baseUrl;//http://host:port\n" +
            "    public String dbInfo;\n" +
            "    public Tservice tservice;\n" +
            "    public Tservicedetail tservicedetail;\n" +
            "    public RunService runService = SpringContextHolder.getBean(RunService.class);\n" +
            "\n" +
            "    public void init(Integer serviceId, Integer envId, String caseDesigner, String i_c) {\n" +
            "        this.serviceId = serviceId;\n" +
            "        this.envId = envId;\n" +
            "        this.caseDesigner = caseDesigner;\n" +
            "        if (StringUtils.isNotBlank(i_c)) {\n" +
            "            this.i_c_JSONObject = JSONObject.parseObject(i_c);\n" +
            "        }\n" +
            "        tservice = runService.getTservice(this.serviceId);\n" +
            "        tservicedetail = runService.getTservicedetail(this.serviceId, this.envId);\n" +
            "        baseUrl = HttpTypeEnum.getValue(tservice.getHttptype()) + \"://\" + tservicedetail.getHostinfo();\n" +
            "        dbInfo = tservicedetail.getDbinfo();\n" +
            "    }\n" +
            "\n" +
            "    public Object[] provider(Method method) {\n" +
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
            "            throw new SkipException(\"测试服务下面没有接口:\" + iUri);\n" +
            "        }\n" +
            "        //此接口对应的全部用例\n" +
            "        List<Tcase> tcases = runService.getTcase(ti.getId(), this.envId, this.caseDesigner);\n" +
            "        if (tcases == null || tcases.size() == 0) {\n" +
            "            throw new SkipException(\"此接口无可用的测试用例\");\n" +
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
            "    }\n\n";
    private static final String baseMethod = "    @Uri(value = \"${annoTestName}\", desc = \"${annoDesc}\")\n" +
            "    public String ${testMethodName}(String baseUrl, String dbInfo, Params params) {\n" +
            "        return HryHttpClientUtil.send(baseUrl, dbInfo, params,this);\n" +
            "    }\n\n";
    private static final String defaultMethod = "    @Test(testName = \"${annoTestName}\", dataProvider = \"provider\", description = \"${annoDesc}\")\n" +
            "    public void ${testMethodName}(Params params) {\n" +
            "        String actual = this.${testMethodName}(baseUrl, dbInfo, params);\n" +
            "        AssertUtil.supperAssert(params.getTcase().getAsserttype(), params.getTcase().getExpected(), actual, params.getTi().getIresponsetype());\n" +
            "    }\n\n";


    private static final String braceLeft = "{\n";
    private static final String braceRight = "}\n";

    @Value("${zdy.autoCodeDir}")
    String autoCodeDir;

    @Autowired
    TserviceService tserviceService;

    @Autowired
    TiService tiService;

    @Override
    public Map<String, String> generateBaseClass() {

        List<Tservice> tservices = tserviceService.selectByCondition(null);
        Map<String, String> ret = new HashMap<>();
        if (tservices == null || tservices.size() == 0) {
            return null;
        }
        for (Tservice tservice : tservices) {
            Ti condition = new Ti();
            condition.setServiceid(tservice.getId());
            List<Ti> tis = tiService.selectByCondition(condition);
            if (tis == null || tis.size() == 0) {
                log.warn("服务id=" + tservice.getId() + ",此服务无有效接口信息,无需生成base类");
                ret.put(tservice.getServicekey() + "(" + tservice.getId() + ")", "此服务无有效接口信息,无需生成base类");
                continue;
            }

            StringBuffer sb = new StringBuffer();
            String sKey = tservice.getServicekey();
            String className = sKey + "Base";
            sb.append(baseHead);
            sb.append(baseClass.replaceAll("\\$\\{baseClassName\\}", className)
                    .replaceAll("\\$\\{SKey\\}", sKey));
            sb.append(braceLeft);
            sb.append(baseCommon);
            getMethodSB(tis, sb, baseMethod);
            sb.append(braceRight);

            String fileName = autoCodeDir + className + ".java";
            FileUtil.saveContent(sb.toString(), fileName);
            ret.put(tservice.getServicekey() + "(" + tservice.getId() + ")", fileName);
        }
        return ret;
    }

    @Override
    public Map<String, String> generateDefaultTestClass() {
        List<Tservice> tservices = tserviceService.selectByCondition(null);
        Map<String, String> ret = new HashMap<>();
        if (tservices == null || tservices.size() == 0) {
            return null;
        }
        for (Tservice tservice : tservices) {
            Ti condition = new Ti();
            condition.setServiceid(tservice.getId());
            List<Ti> tis = tiService.selectByCondition(condition);
            if (tis == null || tis.size() == 0) {
                log.warn("服务id=" + tservice.getId() + ",此服务无有效接口信息,无需生成base类");
                ret.put(tservice.getServicekey() + "(" + tservice.getId() + ")", "此服务无有效接口信息,无需生成base类");
                continue;
            }

            StringBuffer sb = new StringBuffer();
            String sKey = tservice.getServicekey();
            String className = sKey + "TestDefault";
            String supperClassName = sKey + "Base";
            sb.append(defaultHead.replaceAll("\\$\\{supperClassName\\}", supperClassName));
            sb.append(defaultClass.replaceAll("\\$\\{defaultClassName\\}", className)
                    .replaceAll("\\$\\{supperClassName\\}", supperClassName));
            sb.append(braceLeft);
            sb.append(defaultCommon);
            getMethodSB(tis, sb, defaultMethod);
            sb.append(braceRight);

            String fileName = autoCodeDir + className + ".java";
            FileUtil.saveContent(sb.toString(), fileName);
            ret.put(tservice.getServicekey() + "(" + tservice.getId() + ")", fileName);
        }
        return ret;
    }

    public void getMethodSB(List<Ti> tis, StringBuffer sb, String defaultMethod) {
        for (Ti ti : tis) {
            String iUri = ti.getIuri();
            String desc = ti.getRemark();
            String testMethodName = iUri.substring(iUri.indexOf("/") + 1).replaceAll("/", "_");
            String testMethod = defaultMethod.replaceAll("\\$\\{annoTestName\\}", iUri)
                    .replaceAll("\\$\\{annoDesc\\}", desc != null ? desc : "no desc")
                    .replaceAll("\\$\\{testMethodName\\}", testMethodName);
            sb.append(testMethod);
        }
    }
}
