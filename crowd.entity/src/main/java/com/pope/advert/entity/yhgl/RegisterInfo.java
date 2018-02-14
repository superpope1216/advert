package com.pope.advert.entity.yhgl;

import java.io.Serializable;

public class RegisterInfo implements Serializable{
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
    private String yhm;

    /**
     * 
     */
    private String mm;

    /**
     * 
     */
    private String sjh;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String czsj;

    /**
     * 
     */
    private String czip;
    
    /**
     * 是否系统管理员   1 是0否
     */
    private String adminFlag;

    public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

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
     * @return YHM 
     */
    public String getYhm() {
        return yhm;
    }

    /**
     * 
     * @param yhm 
     */
    public void setYhm(String yhm) {
        this.yhm = yhm == null ? null : yhm.trim();
    }

    /**
     * 
     * @return MM 
     */
    public String getMm() {
        return mm;
    }

    /**
     * 
     * @param mm 
     */
    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    /**
     * 
     * @return SJH 
     */
    public String getSjh() {
        return sjh;
    }

    /**
     * 
     * @param sjh 
     */
    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    /**
     * 
     * @return EMAIL 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * @return CZSJ 
     */
    public String getCzsj() {
        return czsj;
    }

    /**
     * 
     * @param czsj 
     */
    public void setCzsj(String czsj) {
        this.czsj = czsj == null ? null : czsj.trim();
    }

    /**
     * 
     * @return CZIP 
     */
    public String getCzip() {
        return czip;
    }

    /**
     * 
     * @param czip 
     */
    public void setCzip(String czip) {
        this.czip = czip == null ? null : czip.trim();
    }

    /**
     *
     * @mbggenerated 2017-12-16
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", yhm=").append(yhm);
        sb.append(", mm=").append(mm);
        sb.append(", sjh=").append(sjh);
        sb.append(", email=").append(email);
        sb.append(", czsj=").append(czsj);
        sb.append(", czip=").append(czip);
        sb.append("]");
        return sb.toString();
    }
}