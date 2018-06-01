package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/1 14:56
 */
public enum RegexEnum {
    EMAIL_REGEX("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$","邮箱正则");
    private String regex;
    private String desc;

    RegexEnum(String regex,String desc){
        this.regex=regex;
        this.desc=desc;
    }

    public String getRegex() {
        return regex;
    }


    public String getDesc() {
        return desc;
    }

}
