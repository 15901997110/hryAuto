package com.haier.enums;

public enum RequestMethodTypeEnum {
    REQUEST_METHOD_POST(1,"post"),
    REQUEST_METHOD_GET(2,"get");
    private int id;
    private String value;
    RequestMethodTypeEnum(int id, String value){
        this.id =id;
        this.value=value;
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

    public static String getValue(int id){
        for(RequestMethodTypeEnum e:RequestMethodTypeEnum.values()){
            if(e.getId()==id){
                return e.getValue();
            }
        }
        return null;
    }
    public static Integer getId(String value){
        for(RequestMethodTypeEnum e:RequestMethodTypeEnum.values()){
            if(e.getValue().equalsIgnoreCase(value)){
                return e.getId();
            }
        }
        return null;
    }
}
