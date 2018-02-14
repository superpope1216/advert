package com.pope.advert.entity.gggl;

import java.io.Serializable;

public class SupplyInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 
     */
    private String wid;
    
    private String gglx;

    public String getGglx() {
		return gglx;
	}

	public void setGglx(String gglx) {
		this.gglx = gglx;
	}

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
    
    private String name;
    
    private String jg;

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTvId() {
		return tvId;
	}

	public void setTvId(String tvId) {
		this.tvId = tvId;
	}

	public String getAdvertType() {
		return advertType;
	}

	public void setAdvertType(String advertType) {
		this.advertType = advertType;
	}

	public String getShzt() {
		return shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	public String getCjsj() {
		return cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

	public String getCjip() {
		return cjip;
	}

	public void setCjip(String cjip) {
		this.cjip = cjip;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getDatastatus() {
		return datastatus;
	}

	public void setDatastatus(String datastatus) {
		this.datastatus = datastatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}
}
