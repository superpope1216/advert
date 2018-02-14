package com.pope.advert.entity.gggl.bzzy;

import java.io.Serializable;
import java.math.BigDecimal;

public class BzzyRwInfo implements Serializable{
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
    private BigDecimal zwjg;

    /**
     * 
     */
    private BigDecimal btjg;

    /**
     * 
     */
    private Integer zwzsxz;

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
     * @return ZWJG 
     */
    public BigDecimal getZwjg() {
        return zwjg;
    }

    /**
     * 
     * @param zwjg 
     */
    public void setZwjg(BigDecimal zwjg) {
        this.zwjg = zwjg;
    }

    /**
     * 
     * @return BTJG 
     */
    public BigDecimal getBtjg() {
        return btjg;
    }

    /**
     * 
     * @param btjg 
     */
    public void setBtjg(BigDecimal btjg) {
        this.btjg = btjg;
    }

    /**
     * 
     * @return ZWZSXZ 
     */
    public Integer getZwzsxz() {
        return zwzsxz;
    }

    /**
     * 
     * @param zwzsxz 
     */
    public void setZwzsxz(Integer zwzsxz) {
        this.zwzsxz = zwzsxz;
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
        sb.append(", zwjg=").append(zwjg);
        sb.append(", btjg=").append(btjg);
        sb.append(", zwzsxz=").append(zwzsxz);
        sb.append(", bzzyId=").append(bzzyId);
        sb.append("]");
        return sb.toString();
    }
}