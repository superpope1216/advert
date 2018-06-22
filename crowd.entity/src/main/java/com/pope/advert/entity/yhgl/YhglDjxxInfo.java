package com.pope.advert.entity.yhgl;

import java.io.Serializable;

public class YhglDjxxInfo implements Serializable{
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
    private String yhid;

    /**
     * 
     */
    private String dj;

    /**
     * 
     */
    private String kssj;

    /**
     * 
     */
    private String jssj;

    /**
     * 剩余条数
     */
    private Integer syts;

    /**
     * 
     */
    private Integer zts;

    /**
     * 
     */
    private Integer version;

    /**
     * 用户状态
     */
    private String yhzt;

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
     * @return YHID 
     */
    public String getYhid() {
        return yhid;
    }

    /**
     * 
     * @param yhid 
     */
    public void setYhid(String yhid) {
        this.yhid = yhid == null ? null : yhid.trim();
    }

    /**
     * 
     * @return DJ 
     */
    public String getDj() {
        return dj;
    }

    /**
     * 
     * @param dj 
     */
    public void setDj(String dj) {
        this.dj = dj == null ? null : dj.trim();
    }

    /**
     * 
     * @return KSSJ 
     */
    public String getKssj() {
        return kssj;
    }

    /**
     * 
     * @param kssj 
     */
    public void setKssj(String kssj) {
        this.kssj = kssj == null ? null : kssj.trim();
    }

    /**
     * 
     * @return JSSJ 
     */
    public String getJssj() {
        return jssj;
    }

    /**
     * 
     * @param jssj 
     */
    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    /**
     * 剩余条数
     * @return SYTS 剩余条数
     */
    public Integer getSyts() {
        return syts;
    }

    /**
     * 剩余条数
     * @param syts 剩余条数
     */
    public void setSyts(Integer syts) {
        this.syts = syts;
    }

    /**
     * 
     * @return ZTS 
     */
    public Integer getZts() {
        return zts;
    }

    /**
     * 
     * @param zts 
     */
    public void setZts(Integer zts) {
        this.zts = zts;
    }

    /**
     * 
     * @return version 
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 用户状态
     * @return yhzt 用户状态
     */
    public String getYhzt() {
        return yhzt;
    }

    /**
     * 用户状态
     * @param yhzt 用户状态
     */
    public void setYhzt(String yhzt) {
        this.yhzt = yhzt == null ? null : yhzt.trim();
    }

    /**
     *
     * @mbggenerated 2018-05-28
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", yhid=").append(yhid);
        sb.append(", dj=").append(dj);
        sb.append(", kssj=").append(kssj);
        sb.append(", jssj=").append(jssj);
        sb.append(", syts=").append(syts);
        sb.append(", zts=").append(zts);
        sb.append(", version=").append(version);
        sb.append(", yhzt=").append(yhzt);
        sb.append("]");
        return sb.toString();
    }
}