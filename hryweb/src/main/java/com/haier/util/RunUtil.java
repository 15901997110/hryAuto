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
    public static void run(Integer userId, Integer customId, String reportPath, List<String> clazzs) {
        List<String> distinctClazzs = HryUtil.distinct(clazzs);
        if (distinctClazzs == null) {
            return;
        }
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "report_" + userId + "_" + customId + "_" + date + ".html";
        runNG(null, reportPath, reportName, clazzs);
    }

    private static void runNG(Map<String, String> params, String reportPath, String reportName, List<String> classes) {
        if (classes == null || classes.size() == 0) {
            return;
        }
        log.info("运行的测试集合:" + classes.toString());

        TestNG testNG = new TestNG();

        XmlSuite suite = new XmlSuite();
        List<XmlClass> clazzes = new ArrayList<>();

        for (String _clazz : classes) {
            XmlClass clazz = new XmlClass(_clazz);
            clazz.setName(_clazz);
            clazzes.add(clazz);
        }

        XmlTest test = new XmlTest(suite);
        test.setName("FirstTest");
        test.setClasses(clazzes);
        List<XmlTest> tests = new ArrayList<>();
        tests.add(test);


        suite.setName("FirstSuite");
        suite.setTests(tests);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.addListener(new HryReporter(reportPath, reportName));

        testNG.run();

    }
}
