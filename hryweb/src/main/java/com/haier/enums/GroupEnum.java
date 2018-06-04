package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/4 12:19
 */
public enum GroupEnum {
    NULL(-1,"未分组"),
    ADMIN(1,"超级管理员"),
    LEADER(2,"领导"),
    PM(3,"项目经理"),
    TESTER_SH(11,"上海测试组"),
    DEVER_SH(12,"上海开发组"),
    PRODUCT_UED_SH(13,"上海产品及UED"),
    TESTER_HZ(21,"杭州测试组"),
    DEVER_HZ(22,"杭州开发组"),
    PRODUCT_UED_HZ(23,"杭州产品及UED"),

    ;
    private Integer groupId;
    private String desc;

    GroupEnum(Integer groupId, String desc) {
        this.groupId = groupId;
        this.desc = desc;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getDesc() {
        return desc;
    }
}
