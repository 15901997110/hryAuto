package com.haier.enums;

/**
 * @Description: 入参匹配正则表达式
 * @Author: luqiwei
 * @Date: 2018/6/19 9:39
 */
public enum BeforeRegexEnum {
    UUID("(?i)<<<uuid>>>"),//匹配rd
    DATE("(?i)<<<date:?-?\\d*>>>"),//匹配日期,"<<<date" 开头,后面跟0或者1个:,后面跟0或者1个-,后面跟0或者多个数字,以">>>"结尾
    DATETIME("(?i)<<<datetime:?-?\\d*>>>"),//匹配datetime,yyyy-MM-dd HH:mm:ss
    TIME("(?i)<<<time:?-?\\d*>>>"),//匹配时间
    SQL("((?i)<<<sql:)((?!.*?<<<).*?)(>>>)"),//匹配以 "<<<sql:" 开头,中间不包含 "<<<" 字符串,以 ">>>" 结尾(非贪心)
    VAR("((?i)<<<var:)((?!.*?<<<).*?)(>>>)"),//匹配以 "<<<var:" 开头,中间不包含 "<<<" 字符串,以 ">>>" 结尾(非贪心)

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
