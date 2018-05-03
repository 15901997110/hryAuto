package com.haier.enums;

public enum ResponseTypeEnum {
    JSON(1,"json");

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

    private int id;
    private String value;
    private ResponseTypeEnum(int id, String value){
        this.id =id;
        this.value=value;
    }
}
