package com.haier.service.impl;

import com.haier.enums.GenEnum;
import com.haier.enums.GenReplaceKWEnum;
import com.haier.po.Tcase;
import com.haier.po.Ti;
import com.haier.po.Tservice;
import com.haier.service.GenerateService;
import com.haier.service.TcaseService;
import com.haier.service.TiService;
import com.haier.service.TserviceService;
import com.haier.util.HryUtil;
import com.itranswarp.compiler.JavaStringCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description: 自动生成测试类并编译至内存中
 * @Author: luqiwei
 * @Date: 2018/11/12 15:47
 */
@Service
public class GenerateServiceImpl implements GenerateService {
    private String brace_left = GenEnum.BRACE_LEFT.getCode();
    private String brace_right = GenEnum.BRACE_RIGHT.getCode();

    private String base_package = GenEnum.BASE_PACKAGE.getCode();
    private String base_import = GenEnum.BASE_IMPORT.getCode();
    private String base_class_annotation = GenEnum.BASE_CLASS_ANNOTATION.getCode();
    private String base_class_name = GenEnum.BASE_CLASS_NAME.getCode();
    private String base_constructor = GenEnum.BASE_CONSTRUCTOR.getCode();
    private String base_method_annotation = GenEnum.BASE_METHOD_ANNOTATION.getCode();
    private String base_method = GenEnum.BASE_METHOD.getCode();

    @Autowired
    TcaseService tcaseService;

    @Autowired
    TiService tiService;

    @Autowired
    TserviceService tserviceService;


    @Override
    public String generateBase(Tcase tcase) {
        try {
            this.test();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       /* Tservice tservice = tserviceService.selectOne(tcase.getServiceid());
        Ti ti = tiService.selectOne(tcase.getIid());


        StringBuffer sb = new StringBuffer();
        sb.append(base_package).append(base_import);//包名与导包
        sb.append(base_class_annotation.replaceAll(GenReplaceKWEnum.SKEY.getRegex(), tservice.getServicekey()));//类注解
        sb.append(base_class_name.replaceAll(GenReplaceKWEnum.CLASS_NAME.getRegex(), tservice.getServicekey() + "Test"));//类名
        sb.append(brace_left);
        sb.append(base_constructor.replaceAll(GenReplaceKWEnum.CLASS_NAME.getRegex(), tservice.getServicekey() + "Test"));
        sb.append(base_method_annotation
                .replaceAll(GenReplaceKWEnum.URI.getRegex(), ti.getIuri())
                .replaceAll(GenReplaceKWEnum.DESC.getRegex(), ti.getRemark() != null ? ti.getRemark() : "")
        );
        sb.append(base_method.replaceAll(GenReplaceKWEnum.METHOD_NAME.getRegex(), HryUtil.iUri2MethodName(ti.getIuri())));
        sb.append(brace_right);

        return sb.toString();*/
       return "success";
    }

    @Override
    public String generateBase(Integer caseId) {
        return this.generateBase(tcaseService.selectOne(caseId));
    }

    private static final String pgwDefaultTest = "package com.haier.testng.test;\n" +
            "\n" +
            "import com.haier.po.HryTest;\n" +
            "import com.haier.testng.base.PgwBase;\n" +
            "import static com.haier.util.AssertUtil.supperAssert;\n" +
            /*"import lombok.extern.slf4j.Slf4j;\n" +*/
            "import org.testng.annotations.DataProvider;\n" +
            "import org.testng.annotations.Parameters;\n" +
            "import org.testng.annotations.Test;\n" +
            "\n" +
            "import java.lang.reflect.Method;\n" +
            "\n" +
            "/**\n" +
            " * @Description: PgwDefaultTest\n" +
            " * @Author: 自动生成\n" +
            " * @Date: 2018/11/12 14:21:00\n" +
            " */\n" +
            /*"@Slf4j\n" +*/
            "public class PgwDefaultTest extends PgwBase{\n" +
            "    @Parameters({\"serviceId\", \"envId\", \"caseDesigner\", \"i_c\", \"i_c_zdy\" ,\"testingId\"})\n" +
            "    public PgwDefaultTest(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {\n" +
            "        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);\n" +
            "    }\n" +
            "\n" +
            "    @DataProvider(name = \"provider\")\n" +
            "    public Object[] getCase(Method method) {\n" +
            "        return provider(method);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/accountBalanceQueryFacade/accountBalanceQuery\", dataProvider = \"provider\", description = \"账户余额查询\")\n" +
            "    public void accountBalanceQueryFacade_accountBalanceQuery(HryTest hryTest) {\n" +
            "        String actual = super._accountBalanceQueryFacade_accountBalanceQuery(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/fundPurchaseFacade/fundPurchase\", dataProvider = \"provider\", description = \"基金申购\")\n" +
            "    public void fundPurchaseFacade_fundPurchase(HryTest hryTest) {\n" +
            "        String actual = super._fundPurchaseFacade_fundPurchase(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/fundShareQueryFacade/fundShareQuery\", dataProvider = \"provider\", description = \"基金份额查询\")\n" +
            "    public void fundShareQueryFacade_fundShareQuery(HryTest hryTest) {\n" +
            "        String actual = super._fundShareQueryFacade_fundShareQuery(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/gatewayPostNotifyFacade/kjtPayNotify\", dataProvider = \"provider\", description = \"快捷通回调\")\n" +
            "    public void gatewayPostNotifyFacade_kjtPayNotify(HryTest hryTest) {\n" +
            "        String actual = super._gatewayPostNotifyFacade_kjtPayNotify(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/instantTradeFacade/instantTrade\", dataProvider = \"provider\", description = \"即时收单\")\n" +
            "    public void instantTradeFacade_instantTrade(HryTest hryTest) {\n" +
            "        String actual = super._instantTradeFacade_instantTrade(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/payToAccountFacade/payToAccount\", dataProvider = \"provider\", description = \"转账到账户\")\n" +
            "    public void payToAccountFacade_payToAccount(HryTest hryTest) {\n" +
            "        String actual = super._payToAccountFacade_payToAccount(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/payToCardFacade/payToCard\", dataProvider = \"provider\", description = \"付款到卡\")\n" +
            "    public void payToCardFacade_payToCard(HryTest hryTest) {\n" +
            "        String actual = super._payToCardFacade_payToCard(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "    @Test(testName = \"/tradeQueryFacade/tradeQuery\", dataProvider = \"provider\", description = \"交易查询\")\n" +
            "    public void tradeQueryFacade_tradeQuery(HryTest hryTest) {\n" +
            "        String actual = super._tradeQueryFacade_tradeQuery(hryTest);\n" +
            "        supperAssert(actual, hryTest);\n" +
            "    }\n" +
            "\n" +
            "}\n";

    public void test() throws IOException, ClassNotFoundException {
        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> result = compiler.compile("PgwDefaultTest.java", pgwDefaultTest);
        Class<?> pgw = compiler.loadClass("com.haier.testng.test.PgwDefaultTest", result);
        Constructor<?>[] constructors = pgw.getConstructors();
        Constructor constructor=constructors[0];
        /*constructor.newInstance()*/
    }

}
