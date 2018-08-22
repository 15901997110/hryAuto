package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/1 14:56
 */
public enum RegexEnum {
    EMAIL_REGEX("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", "邮箱正则"),

    PWD_REGEX("^[A-Za-z0-9~`!@#\\$%^&\\*\\(\\),\\.\\+\\<>\\?\\-_\\=\\\\/:;\"'\\|\\[\\]\\{\\}]{6,}+$", "密码正则,字母,数字,英文符号不包括空格"),

    GROUP_SH_REGEX("^1[0-9]$", "上海组"),

    GROUP_HZ_REGEX("^2[0-9]$", "杭州组"),

    CLASSNAME_REGEX("[A-Z][A-Za-z0-9_]*","测试类名,首字符必须是大写字母,其余部分只能由字母或数字或下划线组成"),

    INVALID_CHAR_REGEX("/|-|\\.","匹配字符串中的'/'或者'-'或者'.'字符,iUri转测试方法时 需要将这类字符串替换成下划线"),

    SELECT_REGEX("^(?i)select.+","查询语句(以select开头)"),

    INSERT_REGEX("^(?i)insert.+","新增语句(以insert开头)"),

    UPDATE_REGEX("^(?i)update.+","更新语句(以update开头)")



    ;
    private String regex;
    private String desc;

    RegexEnum(String regex, String desc) {
        this.regex = regex;
        this.desc = desc;
    }

    public String getRegex() {
        return regex;
    }


    public String getDesc() {
        return desc;
    }

}
