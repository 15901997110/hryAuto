package com.haier.util;

import com.haier.testng.listener.HryReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 15:11
 */
@Slf4j
public class RunUtil {
    public static void run(Integer userId, String reportPath, List<String> clazzs) {
        List<String> distinctClazzs = HryUtil.distinct(clazzs);
        if (distinctClazzs == null) {
            return;
        }
        runNG(null,reportPath,clazzs);
    }

    private static void runNG(Map<String, String> params,String reportPath, List<String> classes) {
        if (classes == null || classes.size() == 0) {
            return;
        }
        log.info("运行的测试集合:" + classes.toString());
        String dateStr = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());

        TestNG testNG=new TestNG();

        XmlSuite suite=new XmlSuite();

        XmlClass clazz=new XmlClass(com.haier.testng.cases.TestTest.class);
        clazz.setName("FirstClass");
        List<XmlClass> clazzes=new ArrayList<>();
        clazzes.add(clazz);

        XmlTest test=new XmlTest(suite);
        test.setName("FirstTest");
        test.setClasses(clazzes);
        List<XmlTest> tests=new ArrayList<>();
        tests.add(test);


        suite.setName("FirstSuite");
        suite.setTests(tests);

        List<XmlSuite> suites=new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.addListener(new HryReporter(reportPath));

        testNG.run();

    }
}
