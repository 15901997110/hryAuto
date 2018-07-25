package com.haier.service.impl;

import com.haier.service.AutocodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/25 11:26
 */
@Service
@Slf4j
public class AutocodeServiceImpl implements AutocodeService {
    private String sPackage="package com.haier.testng.cases;\n";
    private String sImport="import com.alibaba.fastjson.JSONArray;\n" +
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
    private String sClass="@Slf4j\n" +
            "public class PgwTest";
    private String sField="private Integer serviceId;\n" +
            "    private Integer envId;\n" +
            "    private String caseDesigner;\n" +
            "    private String i_c;//接收外部传参,定制的用例\n" +
            "    private JSONObject i_c_JSONObject;//将定制的用例从String类型转成JSONObject类型\n" +
            "    private String baseUrl;//http://host:port\n" +
            "    private String url;\n" +
            "    private Tservice tservice;\n" +
            "    private Tservicedetail tservicedetail;\n" +
            "    private RunService runService = SpringContextHolder.getBean(RunService.class);\n";
    private String sMethodOne="";
    private String sMethodMore="";
    private String sBraceLeft="{";
    private String sBraceRight="}";
    @Override
    public void autocode() {

    }
}
