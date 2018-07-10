package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/7/10 10:56
 */
public enum StatusEnum {
    ONE(1,"正常"),
    _ONE(-1,"删除"),
    FIVE(5,"流程进行中"),
    TEN(10,"流程结束")
    ;

    private Integer id;
    private String desc;

    StatusEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
