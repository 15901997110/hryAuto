package com.haier.po;

public class Tenvdetail {
    private Integer serviceid;

    private Integer envid;

    private String hostinfo;

    private String dbinfo;

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getEnvid() {
        return envid;
    }

    public void setEnvid(Integer envid) {
        this.envid = envid;
    }

    public String getHostinfo() {
        return hostinfo;
    }

    public void setHostinfo(String hostinfo) {
        this.hostinfo = hostinfo == null ? null : hostinfo.trim();
    }

    public String getDbinfo() {
        return dbinfo;
    }

    public void setDbinfo(String dbinfo) {
        this.dbinfo = dbinfo == null ? null : dbinfo.trim();
    }
}