package com.pope.advert.entity.qyzx.extend;

import java.io.Serializable;

import com.pope.advert.entity.qyzx.QyzxGgInfo;

public class QyzxGgInfoExtend extends QyzxGgInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String shztDisplay;
	
	private String companyName;
	
	private boolean needCompanyInfo;

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

	public boolean isNeedCompanyInfo() {
		return needCompanyInfo;
	}

	public void setNeedCompanyInfo(boolean needCompanyInfo) {
		this.needCompanyInfo = needCompanyInfo;
	}
}