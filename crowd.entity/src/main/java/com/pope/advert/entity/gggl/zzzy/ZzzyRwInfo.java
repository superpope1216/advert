package com.pope.advert.entity.gggl.zzzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZzzyRwInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String bjlx;

    /**
     * 
     */
    private BigDecimal jg;

    /**
     * 
     */
    private BigDecimal zk;

    /**
     * 
     */
    private String zzzyId;

    /**
     * 
     * @return WID 
     */
    public String getWid() {
        return wid;
    }

    /**
     * 
     * @param wid 
     */
    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    /**
     * 
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return BJLX 
     */
    public String getBjlx() {
        return bjlx;
    }

    /**
     * 
     * @param bjlx 
     */
    public void setBjlx(String bjlx) {
        this.bjlx = bjlx == null ? null : bjlx.trim();
    }

    /**
     * 
     * @return JG 
     */
    public BigDecimal getJg() {
        return jg;
    }

    /**
     * 
     * @param jg 
     */
    public void setJg(BigDecimal jg) {
        this.jg = jg;
    }

    /**
     * 
     * @return ZK 
     */
    public BigDecimal getZk() {
        return zk;
    }

    /**
     * 
     * @param zk 
     */
    public void setZk(BigDecimal zk) {
        this.zk = zk;
    }

    /**
     * 
     * @return ZZZY_ID 
     */
    public String getZzzyId() {
        return zzzyId;
    }

    /**
     * 
     * @param zzzyId 
     */
    public void setZzzyId(String zzzyId) {
        this.zzzyId = zzzyId == null ? null : zzzyId.trim();
    }

    /**
     *
     * @mbggenerated 2017-12-24
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", bjlx=").append(bjlx);
        sb.append(", jg=").append(jg);
        sb.append(", zk=").append(zk);
        sb.append(", zzzyId=").append(zzzyId);
        sb.append("]");
        return sb.toString();
    }
}