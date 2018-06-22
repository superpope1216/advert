package com.pope.advert.entity.gggl.gbzy.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.gbzy.GbzyInfo;

public class GbzyInfoExtend extends GbzyInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String areaDisplay;

	private String cityDisplay;

	private String tvIdDisplay;

	private String advertTypeDisplay;

	private String shztDisplay;

	private String companyName;

	public String getAreaDisplay() {
		return areaDisplay;
	}

	public void setAreaDisplay(String areaDisplay) {
		this.areaDisplay = areaDisplay;
	}

	public String getCityDisplay() {
		return cityDisplay;
	}

	public void setCityDisplay(String cityDisplay) {
		this.cityDisplay = cityDisplay;
	}

	public String getTvIdDisplay() {
		return tvIdDisplay;
	}

	public void setTvIdDisplay(String tvIdDisplay) {
		this.tvIdDisplay = tvIdDisplay;
	}

	public String getAdvertTypeDisplay() {
		return advertTypeDisplay;
	}

	public void setAdvertTypeDisplay(String advertTypeDisplay) {
		this.advertTypeDisplay = advertTypeDisplay;
	}

	public String getShztDisplay() {
		return shztDisplay;
	}

	public void setShztDisplay(String shztDisplay) {
		this.shztDisplay = shztDisplay;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}