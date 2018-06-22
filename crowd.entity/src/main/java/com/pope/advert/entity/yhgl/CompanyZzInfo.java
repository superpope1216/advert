package com.pope.advert.entity.yhgl;

import java.io.Serializable;

public class CompanyZzInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 资质类型
     */
    private String zzlx;

    /**
     * 资质图片
     */
    private String zzlog;

    /**
     * 
     */
    private String registerId;
    
    private String companyId;

    public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
     * 
     */
    private String cjsj;

    /**
     * 
     */
    private String cjip;

    /**
     * 
     */
    private String updateTime;

    /**
     * 
     */
    private String shzt;

    /**
     * 
     */
    private String updateIp;

    /**
     * 
     */
    private String datastatus;

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
     * 资质类型
     * @return ZZLX 资质类型
     */
    public String getZzlx() {
        return zzlx;
    }

    /**
     * 资质类型
     * @param zzlx 资质类型
     */
    public void setZzlx(String zzlx) {
        this.zzlx = zzlx == null ? null : zzlx.trim();
    }

    /**
     * 资质图片
     * @return ZZLOG 资质图片
     */
    public String getZzlog() {
        return zzlog;
    }

    /**
     * 资质图片
     * @param zzlog 资质图片
     */
    public void setZzlog(String zzlog) {
        this.zzlog = zzlog == null ? null : zzlog.trim();
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
     * @return UPDATE_TIME 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
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
     * @return UPDATE_IP 
     */
    public String getUpdateIp() {
        return updateIp;
    }

    /**
     * 
     * @param updateIp 
     */
    public void setUpdateIp(String updateIp) {
        this.updateIp = updateIp == null ? null : updateIp.trim();
    }

    /**
     * 
     * @return DATASTATUS 
     */
    public String getDatastatus() {
        return datastatus;
    }

    /**
     * 
     * @param datastatus 
     */
    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
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
        sb.append(", zzlx=").append(zzlx);
        sb.append(", zzlog=").append(zzlog);
        sb.append(", registerId=").append(registerId);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", cjip=").append(cjip);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", shzt=").append(shzt);
        sb.append(", updateIp=").append(updateIp);
        sb.append(", datastatus=").append(datastatus);
        sb.append("]");
        return sb.toString();
    }
}