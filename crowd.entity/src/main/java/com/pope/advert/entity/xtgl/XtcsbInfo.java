package com.pope.advert.entity.xtgl;

import java.io.Serializable;

public class XtcsbInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 参数名称
     */
    private String csmc;

    /**
     * 参数值
     */
    private String csz;

    /**
     * 参数说明
     */
    private String cssm;

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
     * 参数名称
     * @return CSMC 参数名称
     */
    public String getCsmc() {
        return csmc;
    }

    /**
     * 参数名称
     * @param csmc 参数名称
     */
    public void setCsmc(String csmc) {
        this.csmc = csmc == null ? null : csmc.trim();
    }

    /**
     * 参数值
     * @return CSZ 参数值
     */
    public String getCsz() {
        return csz;
    }

    /**
     * 参数值
     * @param csz 参数值
     */
    public void setCsz(String csz) {
        this.csz = csz == null ? null : csz.trim();
    }

    /**
     * 参数说明
     * @return CSSM 参数说明
     */
    public String getCssm() {
        return cssm;
    }

    /**
     * 参数说明
     * @param cssm 参数说明
     */
    public void setCssm(String cssm) {
        this.cssm = cssm == null ? null : cssm.trim();
    }

    /**
     *
     * @mbggenerated 2018-01-16
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", csmc=").append(csmc);
        sb.append(", csz=").append(csz);
        sb.append(", cssm=").append(cssm);
        sb.append("]");
        return sb.toString();
    }
}