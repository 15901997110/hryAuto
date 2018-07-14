package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/10 16:00
 */
public enum ParamKeyEnum {
    SERVICEID("serviceId", "服务ID"),
    ENVID("envId", "环境ID"),
    DESIGNER("caseDesigner", "用例设计人"),
    I_C("i_c","接口用例选择,存储Map<String,List<Integer>>,String-接口对应的测试方法名,List<Integer>-用例id集合"),
    ;

    ParamKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String key;
    private String desc;

}
