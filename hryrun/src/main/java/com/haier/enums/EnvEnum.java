package com.haier.enums;

/**
 * 测试环境枚举
 */
public enum EnvEnum {
    ENV_CS1(1, "CS1"),//测试1
    ENV_CS2(2, "CS2"),//测试2
    ENV_CS3(3, "CS3"),//测试3
    ENV_CS4(4, "CS4"),//测试4
    ENV_ZSC(5, "ZSC");//准生产
    private int id;
    private String value;

    EnvEnum(int id, String value) {
        this.id = id;
        this.value = value;
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

    public static String getValue(int id) {
        for (EnvEnum e : EnvEnum.values()) {
            if (e.getId() == id) {
                return e.getValue();
            }
        }
        return null;
    }

    public static Integer getId(String value) {
        for (EnvEnum e : EnvEnum.values()) {
            if (e.getValue().equalsIgnoreCase(value)) {
                return e.getId();
            }
        }
        return null;
    }
}
