package com.pope.advert.entity.gggl.gbzy.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;

public class GbzyQtInfoExtend extends GbzyQtInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gbpdBmDisplay;

	public String getGbpdBmDisplay() {
		return gbpdBmDisplay;
	}

	public void setGbpdBmDisplay(String gbpdBmDisplay) {
		this.gbpdBmDisplay = gbpdBmDisplay;
	}
	
}