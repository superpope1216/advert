package com.pope.advert.entity.gggl.xmtzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class XmtzyInfo implements Serializable{
    private String wid;

    private String name;

    private String area;

    private String tvId;

    private String advertType;

    private BigDecimal ggjg;

    private String ggggxs;

    private String szrq;

    private String jycd;

    private String zyfb;

    private String srzk;

    private String xmtjj;

    private String cjsj;

    private String cjip;

    private String registerId;

    private String datastatus;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId == null ? null : tvId.trim();
    }

    public String getAdvertType() {
        return advertType;
    }

    public void setAdvertType(String advertType) {
        this.advertType = advertType == null ? null : advertType.trim();
    }

    public BigDecimal getGgjg() {
        return ggjg;
    }

    public void setGgjg(BigDecimal ggjg) {
        this.ggjg = ggjg;
    }

    public String getGgggxs() {
        return ggggxs;
    }

    public void setGgggxs(String ggggxs) {
        this.ggggxs = ggggxs == null ? null : ggggxs.trim();
    }

    public String getSzrq() {
        return szrq;
    }

    public void setSzrq(String szrq) {
        this.szrq = szrq == null ? null : szrq.trim();
    }

    public String getJycd() {
        return jycd;
    }

    public void setJycd(String jycd) {
        this.jycd = jycd == null ? null : jycd.trim();
    }

    public String getZyfb() {
        return zyfb;
    }

    public void setZyfb(String zyfb) {
        this.zyfb = zyfb == null ? null : zyfb.trim();
    }

    public String getSrzk() {
        return srzk;
    }

    public void setSrzk(String srzk) {
        this.srzk = srzk == null ? null : srzk.trim();
    }

    public String getXmtjj() {
        return xmtjj;
    }

    public void setXmtjj(String xmtjj) {
        this.xmtjj = xmtjj == null ? null : xmtjj.trim();
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    public String getCjip() {
        return cjip;
    }

    public void setCjip(String cjip) {
        this.cjip = cjip == null ? null : cjip.trim();
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    public String getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }
}