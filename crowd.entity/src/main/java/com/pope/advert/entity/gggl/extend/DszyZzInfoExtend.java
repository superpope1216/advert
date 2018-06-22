package com.pope.advert.entity.gggl.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.DszyZzInfo;

public class DszyZzInfoExtend extends DszyZzInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sspdBmDisplay;

	private String sslmBmDisplay;
	
	private String ggjgBmDisplay;

	public String getGgjgBmDisplay() {
		return ggjgBmDisplay;
	}

	public void setGgjgBmDisplay(String ggjgBmDisplay) {
		this.ggjgBmDisplay = ggjgBmDisplay;
	}

	public String getSspdBmDisplay() {
		return sspdBmDisplay;
	}

	public void setSspdBmDisplay(String sspdBmDisplay) {
		this.sspdBmDisplay = sspdBmDisplay;
	}

	public String getSslmBmDisplay() {
		return sslmBmDisplay;
	}

	public void setSslmBmDisplay(String sslmBmDisplay) {
		this.sslmBmDisplay = sslmBmDisplay;
	}

}