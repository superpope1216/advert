package com.pope.advert.entity.cwgl;

import java.io.Serializable;
import java.math.BigDecimal;

public class CwglDjxxInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 名称
     */
    private String name;

    /**
     * 费用
     */
    private BigDecimal fy;

    /**
     * 广告资源数据
     */
    private Integer ggzyxzsl;

    /**
     * 优先级别
     */
    private Integer yxjb;

    /**
     * 
     */
    private String bz;

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
     * 名称
     * @return NAME 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 费用
     * @return FY 费用
     */
    public BigDecimal getFy() {
        return fy;
    }

    /**
     * 费用
     * @param fy 费用
     */
    public void setFy(BigDecimal fy) {
        this.fy = fy;
    }

    /**
     * GGXZSL
     * @return GGZYXZSL GGXZSL
     */
    public Integer getGgzyxzsl() {
        return ggzyxzsl;
    }

    /**
     * GGXZSL
     * @param ggzyxzsl GGXZSL
     */
    public void setGgzyxzsl(Integer ggzyxzsl) {
        this.ggzyxzsl = ggzyxzsl;
    }

    /**
     * 优先级别
     * @return YXJB 优先级别
     */
    public Integer getYxjb() {
        return yxjb;
    }

    /**
     * 优先级别
     * @param yxjb 优先级别
     */
    public void setYxjb(Integer yxjb) {
        this.yxjb = yxjb;
    }

    /**
     * 
     * @return BZ 
     */
    public String getBz() {
        return bz;
    }

    /**
     * 
     * @param bz 
     */
    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    /**
     *
     * @mbggenerated 2018-04-15
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", fy=").append(fy);
        sb.append(", ggzyxzsl=").append(ggzyxzsl);
        sb.append(", yxjb=").append(yxjb);
        sb.append(", bz=").append(bz);
        sb.append("]");
        return sb.toString();
    }
}