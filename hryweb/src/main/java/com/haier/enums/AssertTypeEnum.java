package com.haier.enums;

/**
 * @Description: 断言方式枚举
 * @Author: luqiwei
 * @Date: 2018/5/2 17:44
 */
public enum AssertTypeEnum {
    EQUAL(1, "equal", "实际值与期望值完全相等"),//完全相等
    CONTAIN(2, "contain", "实际值包含期望值,期望值可以填写正则表达式"),
    KEY_VALUE(3, "key-value", "实际值中解析出来的key-value与期望值中一致,期望值的格式必须是JSON,支持正则");

    AssertTypeEnum(int id, String value, String desc) {
        this.id = id;
        this.value = value;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int id;
    private String value;
    private String desc;

    public static String getValue(int id) {
        for (AssertTypeEnum e : AssertTypeEnum.values()) {
            if (e.getId() == id) {
                return e.getValue();
            }
        }
        return null;
    }

    public static Integer getId(String value) {
        for (AssertTypeEnum e : AssertTypeEnum.values()) {
            if (e.getValue().equalsIgnoreCase(value)) {
                return e.getId();
            }
        }
        return null;
    }
}
