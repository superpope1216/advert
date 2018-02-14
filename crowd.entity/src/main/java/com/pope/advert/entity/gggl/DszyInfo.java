package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class DszyInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;

    /**
     * 省
     */
    private String area;

    /**
     * 市
     */
    private String city;

    /**
     * 电视台
     */
    private String tvId;

    /**
     * 广告形式
     */
    private String advertType;

    /**
     * 审核状态
     */
    private String shzt;

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
    private String registerId;
    
    private String datastatus;

    public String getDatastatus() {
		return datastatus;
	}

	public void setDatastatus(String datastatus) {
		this.datastatus = datastatus;
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
     * 省
     * @return AREA 省
     */
    public String getArea() {
        return area;
    }

    /**
     * 省
     * @param area 省
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 市
     * @return CITY 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 电视台
     * @return TV_ID 电视台
     */
    public String getTvId() {
        return tvId;
    }

    /**
     * 电视台
     * @param tvId 电视台
     */
    public void setTvId(String tvId) {
        this.tvId = tvId == null ? null : tvId.trim();
    }

    /**
     * 广告形式
     * @return ADVERT_TYPE 广告形式
     */
    public String getAdvertType() {
        return advertType;
    }

    /**
     * 广告形式
     * @param advertType 广告形式
     */
    public void setAdvertType(String advertType) {
        this.advertType = advertType == null ? null : advertType.trim();
    }

    /**
     * 审核状态
     * @return SHZT 审核状态
     */
    public String getShzt() {
        return shzt;
    }

    /**
     * 审核状态
     * @param shzt 审核状态
     */
    public void setShzt(String shzt) {
        this.shzt = shzt == null ? null : shzt.trim();
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
     * @mbggenerated 2017-12-17
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wid=").append(wid);
        sb.append(", area=").append(area);
        sb.append(", city=").append(city);
        sb.append(", tvId=").append(tvId);
        sb.append(", advertType=").append(advertType);
        sb.append(", shzt=").append(shzt);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", cjip=").append(cjip);
        sb.append(", registerId=").append(registerId);
        sb.append("]");
        return sb.toString();
    }
}