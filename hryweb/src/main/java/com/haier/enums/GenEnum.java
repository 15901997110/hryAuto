package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/11/12 15:56
 */
public enum GenEnum {
    BRACE_LEFT("{\n", ""),
    BRACE_RIGHT("}\n", ""),

    BASE_PACKAGE("package com.haier.testng.base;\n", "包名"),
    BASE_IMPORT("import com.haier.anno.SKey;\n" +
            "import com.haier.anno.Uri;\n" +
            "import com.haier.po.HryTest;\n" +
            "import com.haier.util.HryHttpClientUtil;\n\n", "base类导包"),
    BASE_CLASS_ANNOTATION("@SKey(\"" + GenReplaceKWEnum.SKEY.getSample() + "\")\n", "测试基类注解"),
    BASE_CLASS_NAME("public class " + GenReplaceKWEnum.CLASS_NAME.getSample() + " extends Base\n", "基类类名"),
    BASE_CONSTRUCTOR("public " + GenReplaceKWEnum.CLASS_NAME.getSample() + "(Integer serviceId, Integer envId, String caseDesigner, String i_c, String i_c_zdy, String testingId) {\n" +
            "        super(serviceId, envId, caseDesigner, i_c, i_c_zdy, testingId);\n" +
            "    }\n", "测试基类构造器"),
    BASE_METHOD_ANNOTATION("@Uri(value = \"" + GenReplaceKWEnum.URI.getSample() + "\", desc = \"" + GenReplaceKWEnum.DESC.getSample() + "\")\n", "测试基类中方法注解"),
    BASE_METHOD("public String " + GenReplaceKWEnum.METHOD_NAME.getSample() + "(HryTest test) {\n" +
            "        return HryHttpClientUtil.send(test, this);\n" +
            "    }\n\n", "测试基类方法"),;

    private String code;
    private String desc;

    GenEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
