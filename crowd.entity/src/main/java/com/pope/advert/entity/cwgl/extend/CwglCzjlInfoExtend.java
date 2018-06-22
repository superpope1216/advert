package com.pope.advert.entity.cwgl.extend;

import java.io.Serializable;

import com.pope.advert.entity.cwgl.CwglCzjlInfo;


public class CwglCzjlInfoExtend extends CwglCzjlInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private  String zfztDisplay;

	private String djDisplay;
	
	private String companyName;
	
	private String hyje;
	
	public String getHyje() {
		return hyje;
	}

	public void setHyje(String hyje) {
		this.hyje = hyje;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String yxj;
	public String getYxj() {
		return yxj;
	}

	public void setYxj(String yxj) {
		this.yxj = yxj;
	}

	public String getDjDisplay() {
		return djDisplay;
	}

	public void setDjDisplay(String djDisplay) {
		this.djDisplay = djDisplay;
	}

	public String getZfztDisplay() {
		return zfztDisplay;
	}

	public void setZfztDisplay(String zfztDisplay) {
		this.zfztDisplay = zfztDisplay;
	}

	
}