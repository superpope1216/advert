package com.pope.advert.entity.gggl.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.DszyZtInfo;

public class DszyZtInfoExtend extends DszyZtInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ztpdBmDisplay;
	
	private String sjdBmDisplay;

	public String getZtpdBmDisplay() {
		return ztpdBmDisplay;
	}

	public void setZtpdBmDisplay(String ztpdBmDisplay) {
		this.ztpdBmDisplay = ztpdBmDisplay;
	}

	public String getSjdBmDisplay() {
		return sjdBmDisplay;
	}

	public void setSjdBmDisplay(String sjdBmDisplay) {
		this.sjdBmDisplay = sjdBmDisplay;
	}

	
}