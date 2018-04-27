package com.haier.enums;

public enum ResponseType {
    JSON(1,"json"),TEXT(2,"text");
    private int key;
    private String value;
    private ResponseType(int key,String value){
        this.key=key;
        this.value=value;
    }
    public int getKey(){
        return this.key;
    }
    public String getValue(int key){
        return this.value;
    }
}
