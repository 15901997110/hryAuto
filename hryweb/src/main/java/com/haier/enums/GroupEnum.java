package com.haier.enums;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/6/4 12:19
 */
public enum GroupEnum {
    NULL(-1, "未分组"),
    ADMIN(1, "超级管理员"),
    /**
     * 2-10为系统预留,
     */

    //上海分组
    TESTER_SH(11, "测试组-SH"),
    DEVER_SH(12, "开发组-SH"),// 如果后续需要扩展多个开发组,可以120,121,122...
    PRODUCT_UED_SH(13, "产品及UED-SH"),
    PM_SH(14, "项目经理-SH"),
    OP_SH(15, "运维-SH"),
    OTHER_SH(16, "其它_SH"),

    //杭州分组
    TESTER_HZ(21, "测试组-HZ"),
    DEVER_HZ(22, "开发组-HZ"),
    PRODUCT_UED_HZ(23, "产品及UED-HZ"),
    PM_HZ(24, "项目经理-HZ"),
    OP_HZ(25, "运维-HZ"),
    OTHER_HZ(26, "其它-HZ"),

    BOSS(9999, "BOSS");
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
