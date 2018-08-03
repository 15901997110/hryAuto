package com.haier.po;

import java.util.Date;

public class Ti {
    private Integer id;

    private Integer serviceid;

    private String iuri;

    private String remark;

    private Integer irequestmethod;

    private Integer icontenttype;

    private Integer iparamtype;

    private String iparamsample;

    private Integer iresponsetype;

    private String idev;

    private Integer istatus;

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

    public Integer getIrequestmethod() {
        return irequestmethod;
    }

    public void setIrequestmethod(Integer irequestmethod) {
        this.irequestmethod = irequestmethod;
    }

    public Integer getIcontenttype() {
        return icontenttype;
    }

    public void setIcontenttype(Integer icontenttype) {
        this.icontenttype = icontenttype;
    }

    public Integer getIparamtype() {
        return iparamtype;
    }

    public void setIparamtype(Integer iparamtype) {
        this.iparamtype = iparamtype;
    }

    public String getIparamsample() {
        return iparamsample;
    }

    public void setIparamsample(String iparamsample) {
        this.iparamsample = iparamsample == null ? null : iparamsample.trim();
    }

    public Integer getIresponsetype() {
        return iresponsetype;
    }

    public void setIresponsetype(Integer iresponsetype) {
        this.iresponsetype = iresponsetype;
    }

    public String getIdev() {
        return idev;
    }

    public void setIdev(String idev) {
        this.idev = idev == null ? null : idev.trim();
    }

    public Integer getIstatus() {
        return istatus;
    }

    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}