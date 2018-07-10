package com.haier.util;

import com.haier.po.Treport;
import com.haier.testng.listener.HryReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/29 15:11
 */
@Slf4j
public class RunUtil {

/*    public static void run(Integer userId, Integer customId, String reportPath,String resourcePathPattern, List<XmlClass> xmlClasses) {
        List<XmlClass> distinctClazzs = HryUtil.distinct(xmlClasses);
        if (distinctClazzs == null) {
            return;
        }
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "report_" + userId + "_" + customId + "_" + date + ".html";
        runNG(null, reportPath,resourcePathPattern, reportName, xmlClasses);
    }*/

/*    private static void runNG(Map<String, String> params, String reportPath, String resourcePathPattern,String reportName, List<XmlClass> xmlClasses) {


        if (xmlClasses == null || xmlClasses.size() == 0) {
            return;
        }
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        List<XmlTest> xmlTests = new ArrayList<>();
        for(XmlClass c:xmlClasses){
            XmlTest test=new XmlTest(suite);
            test.setName(c.getName().substring(c.getName().lastIndexOf(".")+1));
            test.setClasses(Arrays.asList(c));
            xmlTests.add(test);
        }

        suite.setName("AutoSuite");
        suite.setTests(xmlTests);

        testNG.setXmlSuites(Arrays.asList(suite));
        testNG.addListener(new HryReporter(reportPath, reportName));

        testNG.run();

    }*/
}
