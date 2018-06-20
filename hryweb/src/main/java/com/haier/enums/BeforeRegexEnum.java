package com.haier.enums;

/**
 * @Description: 入参匹配正则表达式
 * @Author: luqiwei
 * @Date: 2018/6/19 9:39
 */
public enum BeforeRegexEnum {
    UUID("(?i)<<<uuid>>>"),//匹配rd
    SQL("((?i)<<<sql:)((?!.*?<<<).*?)(>>>)"),//匹配以 "<<<sql:" 开头,中间不包含 "<<<" 字符串,以 ">>>" 结尾(非贪心)


    ;
    private String pattern;

    BeforeRegexEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
