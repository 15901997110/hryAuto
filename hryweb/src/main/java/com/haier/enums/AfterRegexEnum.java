package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/9/28 10:36
 */
public enum AfterRegexEnum {
    /**
     * <putJ(key,value)> put tempValue from json(response)
     */
    PUTJ("(?i)<putJ\\(w+,[^<>]*\\)>"),

    ;
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    AfterRegexEnum(String pattern) {
        this.pattern = pattern;
    }
}
