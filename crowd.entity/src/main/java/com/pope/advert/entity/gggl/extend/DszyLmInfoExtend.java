package com.pope.advert.entity.gggl.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.DszyLmInfo;

public class DszyLmInfoExtend extends DszyLmInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pdIdDisplay;
	
	private String dllmDisplay;

	public String getPdIdDisplay() {
		return pdIdDisplay;
	}

	public void setPdIdDisplay(String pdIdDisplay) {
		this.pdIdDisplay = pdIdDisplay;
	}

	public String getDllmDisplay() {
		return dllmDisplay;
	}

	public void setDllmDisplay(String dllmDisplay) {
		this.dllmDisplay = dllmDisplay;
	} 
	
}