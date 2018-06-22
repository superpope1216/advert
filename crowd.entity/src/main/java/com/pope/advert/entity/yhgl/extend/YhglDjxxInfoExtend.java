package com.pope.advert.entity.yhgl.extend;

import java.io.Serializable;

import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;

public class YhglDjxxInfoExtend extends YhglDjxxInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CwglDjxxInfoExtend  djxx;
	
	private CompanyInfoExtend companyInfo;
	
	private String yhztDisplay;

	public String getYhztDisplay() {
		return yhztDisplay;
	}

	public void setYhztDisplay(String yhztDisplay) {
		this.yhztDisplay = yhztDisplay;
	}

	public CompanyInfoExtend getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfoExtend companyInfo) {
		this.companyInfo = companyInfo;
	}

	public CwglDjxxInfoExtend getDjxx() {
		return djxx;
	}

	public void setDjxx(CwglDjxxInfoExtend djxx) {
		this.djxx = djxx;
	}

}