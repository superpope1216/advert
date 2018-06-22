package com.pope.advert.entity.gggl.wlzy.extend;

import java.io.Serializable;

import com.pope.advert.entity.gggl.wlzy.WlzyInfo;

public class WlzyInfoExtend extends WlzyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ggwzDisplay;
	private String zsxtDisplay;
	private String zsfsDisplay;
	public String getZsfsDisplay() {
		return zsfsDisplay;
	}
	public void setZsfsDisplay(String zsfsDisplay) {
		this.zsfsDisplay = zsfsDisplay;
	}
	private String zsccDisplay;
	private String jffsDisplay;
	private String shztDisplay;
	private String companyName;
	public String getGgwzDisplay() {
		return ggwzDisplay;
	}
	public void setGgwzDisplay(String ggwzDisplay) {
		this.ggwzDisplay = ggwzDisplay;
	}
	public String getZsxtDisplay() {
		return zsxtDisplay;
	}
	public void setZsxtDisplay(String zsxtDisplay) {
		this.zsxtDisplay = zsxtDisplay;
	}
	public String getZsccDisplay() {
		return zsccDisplay;
	}
	public void setZsccDisplay(String zsccDisplay) {
		this.zsccDisplay = zsccDisplay;
	}
	public String getJffsDisplay() {
		return jffsDisplay;
	}
	public void setJffsDisplay(String jffsDisplay) {
		this.jffsDisplay = jffsDisplay;
	}
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
