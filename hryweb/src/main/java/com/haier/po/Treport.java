package com.haier.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Treport {
    private Integer id;

    private String reportpath;

    private String reportname;

    private Integer userid;

    private String username;

    private Integer customid;

    private String customname;

    private Integer envid;

    private String envkey;

    private String serviceid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date testtime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportpath() {
        return reportpath;
    }

    public void setReportpath(String reportpath) {
        this.reportpath = reportpath == null ? null : reportpath.trim();
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname == null ? null : reportname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getCustomid() {
        return customid;
    }

    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname == null ? null : customname.trim();
    }

    public Integer getEnvid() {
        return envid;
    }

    public void setEnvid(Integer envid) {
        this.envid = envid;
    }

    public String getEnvkey() {
        return envkey;
    }

    public void setEnvkey(String envkey) {
        this.envkey = envkey == null ? null : envkey.trim();
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid == null ? null : serviceid.trim();
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}