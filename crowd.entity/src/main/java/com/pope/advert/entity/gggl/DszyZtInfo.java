package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszyZtInfo  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;
    
    private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
     * 
     */
    private String ztpdBm;

    /**
     * 
     */
    private String sjdBm;

    /**
     * 
     */
    private Long bcsc;

    /**
     * 
     */
    private Long ggjg;
    
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
     * @return ztpd_bm 
     */
    public String getZtpdBm() {
        return ztpdBm;
    }

    /**
     * 
     * @param ztpdBm 
     */
    public void setZtpdBm(String ztpdBm) {
        this.ztpdBm = ztpdBm == null ? null : ztpdBm.trim();
    }

    /**
     * 
     * @return sjd_bm 
     */
    public String getSjdBm() {
        return sjdBm;
    }

    /**
     * 
     * @param sjdBm 
     */
    public void setSjdBm(String sjdBm) {
        this.sjdBm = sjdBm == null ? null : sjdBm.trim();
    }

    /**
     * 
     * @return bcsc 
     */
    public Long getBcsc() {
        return bcsc;
    }

    /**
     * 
     * @param bcsc 
     */
    public void setBcsc(Long bcsc) {
        this.bcsc = bcsc;
    }

    /**
     * 
     * @return ggjg 
     */
    public Long getGgjg() {
        return ggjg;
    }

    /**
     * 
     * @param ggjg 
     */
    public void setGgjg(Long ggjg) {
        this.ggjg = ggjg;
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
        sb.append(", ztpdBm=").append(ztpdBm);
        sb.append(", sjdBm=").append(sjdBm);
        sb.append(", bcsc=").append(bcsc);
        sb.append(", ggjg=").append(ggjg);
        sb.append("]");
        return sb.toString();
    }
}