package com.pope.advert.entity.gggl.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.DszySdInfo;

public class DszySdInfoExtend extends DszySdInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tvPdDisplay;

	public String getTvPdDisplay() {
		return tvPdDisplay;
	}

	public void setTvPdDisplay(String tvPdDisplay) {
		this.tvPdDisplay = tvPdDisplay;
	}


}