package com.pope.advert.entity.gggl.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.DszyTbInfo;

public class DszyTbInfoExtend  extends DszyTbInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String bhpdDisplay;
	
	private String bcsmBmDisplay;

	public String getBhpdDisplay() {
		return bhpdDisplay;
	}

	public void setBhpdDisplay(String bhpdDisplay) {
		this.bhpdDisplay = bhpdDisplay;
	}

	public String getBcsmBmDisplay() {
		return bcsmBmDisplay;
	}

	public void setBcsmBmDisplay(String bcsmBmDisplay) {
		this.bcsmBmDisplay = bcsmBmDisplay;
	}
	

}