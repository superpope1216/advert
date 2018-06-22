package com.pope.advert.entity.buy.qg;

import java.io.Serializable;
import java.math.BigDecimal;

public class QgInfo implements Serializable{
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
    private BigDecimal jg;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String cjsj;

    /**
     * 
     */
    private String xgsj;

    /**
     * 
     */
    private String shzt;

    /**
     * 
     */
    private String cjip;

    /**
     * 
     */
    private String registerId;

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
     * @return CONTENT 
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content 
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 
     * @return CJSJ 
     */
    public String getCjsj() {
        return cjsj;
    }

    /**
     * 
     * @param cjsj 
     */
    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    /**
     * 
     * @return XGSJ 
     */
    public String getXgsj() {
        return xgsj;
    }

    /**
     * 
     * @param xgsj 
     */
    public void setXgsj(String xgsj) {
        this.xgsj = xgsj == null ? null : xgsj.trim();
    }

    /**
     * 
     * @return SHZT 
     */
    public String getShzt() {
        return shzt;
    }

    /**
     * 
     * @param shzt 
     */
    public void setShzt(String shzt) {
        this.shzt = shzt == null ? null : shzt.trim();
    }

    /**
     * 
     * @return CJIP 
     */
    public String getCjip() {
        return cjip;
    }

    /**
     * 
     * @param cjip 
     */
    public void setCjip(String cjip) {
        this.cjip = cjip == null ? null : cjip.trim();
    }

    /**
     * 
     * @return REGISTER_ID 
     */
    public String getRegisterId() {
        return registerId;
    }

    /**
     * 
     * @param registerId 
     */
    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    /**
     *
     * @mbggenerated 2018-02-25
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", jg=").append(jg);
        sb.append(", content=").append(content);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", xgsj=").append(xgsj);
        sb.append(", shzt=").append(shzt);
        sb.append(", cjip=").append(cjip);
        sb.append(", registerId=").append(registerId);
        sb.append("]");
        return sb.toString();
    }
}