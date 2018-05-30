package com.haier.po;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Tcase {
    private Integer id;

    private String casename;

    private String remark;

    private Integer iid;

    private Integer envid;

    private String requestparam;

    private Short asserttype;

    private String expected;

    private Short status;

    private String author;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename == null ? null : casename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getEnvid() {
        return envid;
    }

    public void setEnvid(Integer envid) {
        this.envid = envid;
    }

    public String getRequestparam() {
        return requestparam;
    }

    public void setRequestparam(String requestparam) {
        this.requestparam = requestparam == null ? null : requestparam.trim();
    }

    public Short getAsserttype() {
        return asserttype;
    }

    public void setAsserttype(Short asserttype) {
        this.asserttype = asserttype;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected == null ? null : expected.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}