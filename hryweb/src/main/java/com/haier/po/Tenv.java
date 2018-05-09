package com.haier.po;

public class Tenv {
    private Integer id;

    private String envkey;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvkey() {
        return envkey;
    }

    public void setEnvkey(String envkey) {
        this.envkey = envkey == null ? null : envkey.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}