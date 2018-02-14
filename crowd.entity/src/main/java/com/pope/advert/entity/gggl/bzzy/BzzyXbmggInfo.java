package com.pope.advert.entity.gggl.bzzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class BzzyXbmggInfo implements Serializable{
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
    private String lx;

    /**
     * 
     */
    private BigDecimal ccK;

    /**
     * 
     */
    private BigDecimal ccG;

    /**
     * 
     */
    private BigDecimal kljg;

    /**
     * 
     */
    private String bwms;

    /**
     * 
     */
    private BigDecimal xxjg;

    /**
     * 
     */
    private String ys;

    /**
     * 
     */
    private String bzzyId;

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
     * @return LX 
     */
    public String getLx() {
        return lx;
    }

    /**
     * 
     * @param lx 
     */
    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    /**
     * 
     * @return CC_K 
     */
    public BigDecimal getCcK() {
        return ccK;
    }

    /**
     * 
     * @param ccK 
     */
    public void setCcK(BigDecimal ccK) {
        this.ccK = ccK;
    }

    /**
     * 
     * @return CC_G 
     */
    public BigDecimal getCcG() {
        return ccG;
    }

    /**
     * 
     * @param ccG 
     */
    public void setCcG(BigDecimal ccG) {
        this.ccG = ccG;
    }

    /**
     * 
     * @return KLJG 
     */
    public BigDecimal getKljg() {
        return kljg;
    }

    /**
     * 
     * @param kljg 
     */
    public void setKljg(BigDecimal kljg) {
        this.kljg = kljg;
    }

    /**
     * 
     * @return BWMS 
     */
    public String getBwms() {
        return bwms;
    }

    /**
     * 
     * @param bwms 
     */
    public void setBwms(String bwms) {
        this.bwms = bwms == null ? null : bwms.trim();
    }

    /**
     * 
     * @return XXJG 
     */
    public BigDecimal getXxjg() {
        return xxjg;
    }

    /**
     * 
     * @param xxjg 
     */
    public void setXxjg(BigDecimal xxjg) {
        this.xxjg = xxjg;
    }

    /**
     * 
     * @return YS 
     */
    public String getYs() {
        return ys;
    }

    /**
     * 
     * @param ys 
     */
    public void setYs(String ys) {
        this.ys = ys == null ? null : ys.trim();
    }

    /**
     * 
     * @return BZZY_ID 
     */
    public String getBzzyId() {
        return bzzyId;
    }

    /**
     * 
     * @param bzzyId 
     */
    public void setBzzyId(String bzzyId) {
        this.bzzyId = bzzyId == null ? null : bzzyId.trim();
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
        sb.append(", lx=").append(lx);
        sb.append(", ccK=").append(ccK);
        sb.append(", ccG=").append(ccG);
        sb.append(", kljg=").append(kljg);
        sb.append(", bwms=").append(bwms);
        sb.append(", xxjg=").append(xxjg);
        sb.append(", ys=").append(ys);
        sb.append(", bzzyId=").append(bzzyId);
        sb.append("]");
        return sb.toString();
    }
}