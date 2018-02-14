package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszySdInfo  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 标题
     */
    private String name;

    /**
     * 时段频道
     */
    private String tvPd;

    /**
     * 黄金时段折扣
     */
    private Long hjsdZk;

    /**
     * 非黄金时段折扣
     */
    private Long fhjsdZk;

    /**
     * 创建时间
     */
    private String cjsj;

    /**
     * 创建IP
     */
    private String cjip;

    /**
     * 
     */
    private String dszyId;

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
     * 标题
     * @return NAME 标题
     */
    public String getName() {
        return name;
    }

    /**
     * 标题
     * @param name 标题
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 时段频道
     * @return TV_PD 时段频道
     */
    public String getTvPd() {
        return tvPd;
    }

    /**
     * 时段频道
     * @param tvPd 时段频道
     */
    public void setTvPd(String tvPd) {
        this.tvPd = tvPd == null ? null : tvPd.trim();
    }

    /**
     * 黄金时段折扣
     * @return HJSD_ZK 黄金时段折扣
     */
    public Long getHjsdZk() {
        return hjsdZk;
    }

    /**
     * 黄金时段折扣
     * @param hjsdZk 黄金时段折扣
     */
    public void setHjsdZk(Long hjsdZk) {
        this.hjsdZk = hjsdZk;
    }

    /**
     * 非黄金时段折扣
     * @return FHJSD_ZK 非黄金时段折扣
     */
    public Long getFhjsdZk() {
        return fhjsdZk;
    }

    /**
     * 非黄金时段折扣
     * @param fhjsdZk 非黄金时段折扣
     */
    public void setFhjsdZk(Long fhjsdZk) {
        this.fhjsdZk = fhjsdZk;
    }

    /**
     * 创建时间
     * @return CJSJ 创建时间
     */
    public String getCjsj() {
        return cjsj;
    }

    /**
     * 创建时间
     * @param cjsj 创建时间
     */
    public void setCjsj(String cjsj) {
        this.cjsj = cjsj == null ? null : cjsj.trim();
    }

    /**
     * 创建IP
     * @return CJIP 创建IP
     */
    public String getCjip() {
        return cjip;
    }

    /**
     * 创建IP
     * @param cjip 创建IP
     */
    public void setCjip(String cjip) {
        this.cjip = cjip == null ? null : cjip.trim();
    }

    /**
     * 
     * @return DSZY_ID 
     */
    public String getDszyId() {
        return dszyId;
    }

    /**
     * 
     * @param dszyId 
     */
    public void setDszyId(String dszyId) {
        this.dszyId = dszyId == null ? null : dszyId.trim();
    }

    /**
     *
     * @mbggenerated 2017-12-21
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", name=").append(name);
        sb.append(", tvPd=").append(tvPd);
        sb.append(", hjsdZk=").append(hjsdZk);
        sb.append(", fhjsdZk=").append(fhjsdZk);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", cjip=").append(cjip);
        sb.append(", dszyId=").append(dszyId);
        sb.append("]");
        return sb.toString();
    }
}