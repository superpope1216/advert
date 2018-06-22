package com.pope.advert.entity.buy.qg.extend;

import java.io.Serializable;

import com.pope.advert.entity.buy.qg.QgInfo;

public class QgInfoExtend extends QgInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String shztDisplay;
	
	private String companyName;

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
