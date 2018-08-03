package com.haier.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Ti {
    private Integer id;

    private Integer serviceid;

    private String iuri;

    private String remark;

    private Short irequestmethod;

    private Short icontenttype;

    private Short iparamtype;

    private String iparamsample;

    private Short iresponsetype;

    private String idev;

    private Short istatus;

    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getIuri() {
        return iuri;
    }

    public void setIuri(String iuri) {
        this.iuri = iuri == null ? null : iuri.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getIrequestmethod() {
        return irequestmethod;
    }

    public void setIrequestmethod(Short irequestmethod) {
        this.irequestmethod = irequestmethod;
    }

    public Short getIcontenttype() {
        return icontenttype;
    }

    public void setIcontenttype(Short icontenttype) {
        this.icontenttype = icontenttype;
    }

    public Short getIparamtype() {
        return iparamtype;
    }

    public void setIparamtype(Short iparamtype) {
        this.iparamtype = iparamtype;
    }

    public String getIparamsample() {
        return iparamsample;
    }

    public void setIparamsample(String iparamsample) {
        this.iparamsample = iparamsample == null ? null : iparamsample.trim();
    }

    public Short getIresponsetype() {
        return iresponsetype;
    }

    public void setIresponsetype(Short iresponsetype) {
        this.iresponsetype = iresponsetype;
    }

    public String getIdev() {
        return idev;
    }

    public void setIdev(String idev) {
        this.idev = idev == null ? null : idev.trim();
    }

    public Short getIstatus() {
        return istatus;
    }

    public void setIstatus(Short istatus) {
        this.istatus = istatus;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}