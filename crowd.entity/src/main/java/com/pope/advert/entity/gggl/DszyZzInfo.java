package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszyZzInfo  implements Serializable{
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
    private String sspdBm;

    /**
     * 
     */
    private String sslmBm;

    /**
     * 
     */
    private Integer bcpc;

    /**
     * 
     */
    private String ggjgBm;

    /**
     * 
     */
    private Long ggjgMoney;
    /**
     * 
     */
    private String dszyId;

    public String getDszyId() {
		return dszyId;
	}

	public void setDszyId(String dszyId) {
		this.dszyId = dszyId;
	}

    /**
     * 
     * @return wid 
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
     * @return name 
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
     * @return sspd_bm 
     */
    public String getSspdBm() {
        return sspdBm;
    }

    /**
     * 
     * @param sspdBm 
     */
    public void setSspdBm(String sspdBm) {
        this.sspdBm = sspdBm == null ? null : sspdBm.trim();
    }

    /**
     * 
     * @return sslm_bm 
     */
    public String getSslmBm() {
        return sslmBm;
    }

    /**
     * 
     * @param sslmBm 
     */
    public void setSslmBm(String sslmBm) {
        this.sslmBm = sslmBm == null ? null : sslmBm.trim();
    }

    /**
     * 
     * @return bcpc 
     */
    public Integer getBcpc() {
        return bcpc;
    }

    /**
     * 
     * @param bcpc 
     */
    public void setBcpc(Integer bcpc) {
        this.bcpc = bcpc;
    }

    /**
     * 
     * @return ggjg_bm 
     */
    public String getGgjgBm() {
        return ggjgBm;
    }

    /**
     * 
     * @param ggjgBm 
     */
    public void setGgjgBm(String ggjgBm) {
        this.ggjgBm = ggjgBm == null ? null : ggjgBm.trim();
    }

    /**
     * 
     * @return ggjg_money 
     */
    public Long getGgjgMoney() {
        return ggjgMoney;
    }

    /**
     * 
     * @param ggjgMoney 
     */
    public void setGgjgMoney(Long ggjgMoney) {
        this.ggjgMoney = ggjgMoney;
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
        sb.append(", sspdBm=").append(sspdBm);
        sb.append(", sslmBm=").append(sslmBm);
        sb.append(", bcpc=").append(bcpc);
        sb.append(", ggjgBm=").append(ggjgBm);
        sb.append(", ggjgMoney=").append(ggjgMoney);
        sb.append("]");
        return sb.toString();
    }
}