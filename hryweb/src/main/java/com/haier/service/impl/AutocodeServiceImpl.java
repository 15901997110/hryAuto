package com.haier.service.impl;

import com.haier.po.Ti;
import com.haier.po.Tservice;
import com.haier.service.AutocodeService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import com.haier.util.FileUtil;
import com.haier.util.HryUtil;
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
            "import com.haier.anno.SKey;\n" +
            "import com.haier.anno.Uri;\n" +
            "import com.haier.po.HryTest;\n" +
            "import com.haier.util.HryHttpClientUtil;\n" +
            "\n";
    private static final String defaultHead = "package com.haier.testng.test;\n" +
            "\n" +
            "import com.haier.po.HryTest;\n" +
            "import com.haier.testng.base.${supperClassName};\n" +
            "import static com.haier.util.AssertUtil.supperAssert;\n" +
            "import lombok.extern.slf4j.Slf4j;\n" +
            /*            "import org.testng.Assert;\n"+*/
            "import org.testng.annotations.BeforeClass;\n" +
            "import org.testng.annotations.DataProvider;\n" +
            "import org.testng.annotations.Parameters;\n" +
            "import org.testng.annotations.Test;\n" +
            "\n" +
            "import java.lang.reflect.Method;\n" +
            "\n";
    private static final String baseClass = "/**\n" +
            " * @Description: ${baseClassName}\n" +
            " * @Author: 自动生成\n" +
            " * @Date: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\n" +
            " */\n" +
            "@SKey(\"${SKey}\")\n" +
            "public class ${baseClassName} extends Base ";

    private static final String defaultClass = "/**\n" +
            " * @Description: ${defaultClassName}\n" +
            " * @Author: 自动生成\n" +
            " * @Date: " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\n" +
            " */\n" +
            /*            "@SuppressWarnings(\"Duplicates\")\n" +*/
            "@Slf4j\n" +
            "public class ${defaultClassName} extends ${supperClassName}";

    private static final String defaultCommon = "    @Parameters({\"serviceId\", \"envId\", \"caseDesigner\", \"i_c\", \"i_c_zdy\"})\n" +
            "    @BeforeClass\n" +
            "    public void beforeClass(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy) {\n" +
            "        init(serviceId, envId, caseDesigner, i_c, i_c_zdy);\n" +
            "    }\n" +
            "\n" +
            "    @DataProvider(name = \"provider\")\n" +
            "    public Object[] getCase(Method method) {\n" +
            "        return provider(method);\n" +
            "    }\n" +
            "\n";


    private static final String baseMethod = "    @Uri(value = \"${annoTestName}\", desc = \"${annoDesc}\")\n" +
            "    public String _${testMethodName}(HryTest test) {\n" +
            "        return HryHttpClientUtil.send(test, this);\n" +
            "    }\n" +
            "\n";
    private static final String defaultMethod = "    @Test(testName = \"${annoTestName}\", dataProvider = \"provider\", description = \"${annoDesc}\")\n" +
            "    public void ${testMethodName}(HryTest hryTest) {\n" +
            "        String actual = this._${testMethodName}(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
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
            String className = sKey + "DefaultTest";
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
            String testMethodName = HryUtil.iUri2MethodName(iUri);
            String testMethod = defaultMethod.replaceAll("\\$\\{annoTestName\\}", iUri)
                    .replaceAll("\\$\\{annoDesc\\}", desc != null ? desc : "no desc")
                    .replaceAll("\\$\\{testMethodName\\}", testMethodName);
            sb.append(testMethod);
        }
    }
}
