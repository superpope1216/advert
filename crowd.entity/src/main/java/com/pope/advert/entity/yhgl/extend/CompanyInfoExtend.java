package com.pope.advert.entity.yhgl.extend;

import java.io.Serializable;

import com.pope.advert.entity.yhgl.CompanyInfo;

public class CompanyInfoExtend extends CompanyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String areaDisplay;
	
	private String cityDisplay;
	
	private String xianDisplay;

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

	public String getXianDisplay() {
		return xianDisplay;
	}

	public void setXianDisplay(String xianDisplay) {
		this.xianDisplay = xianDisplay;
	}
 
}