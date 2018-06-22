package com.pope.advert.entity.yhgl.extend;

import java.io.Serializable;
import java.util.List;

import com.pope.advert.entity.yhgl.CompanyInfo;

public class CompanyInfoExtend extends CompanyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String areaDisplay;
	
	private String cityDisplay;
	
	private String xianDisplay;
	
	private String supplyShztDisplay;
	
	private String buyShztDisplay;
	
	private String gsxzDisplay;
	
	private String nyyeDisplay;
	
	
	private String sfybzDisplay;
	
	private List<String> flags;

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public String getSfybzDisplay() {
		return sfybzDisplay;
	}

	public void setSfybzDisplay(String sfybzDisplay) {
		this.sfybzDisplay = sfybzDisplay;
	}

	public String getGsxzDisplay() {
		return gsxzDisplay;
	}

	public void setGsxzDisplay(String gsxzDisplay) {
		this.gsxzDisplay = gsxzDisplay;
	}

	public String getNyyeDisplay() {
		return nyyeDisplay;
	}

	public void setNyyeDisplay(String nyyeDisplay) {
		this.nyyeDisplay = nyyeDisplay;
	}

	public String getSupplyShztDisplay() {
		return supplyShztDisplay;
	}

	public void setSupplyShztDisplay(String supplyShztDisplay) {
		this.supplyShztDisplay = supplyShztDisplay;
	}

	public String getBuyShztDisplay() {
		return buyShztDisplay;
	}

	public void setBuyShztDisplay(String buyShztDisplay) {
		this.buyShztDisplay = buyShztDisplay;
	}

	public String getAreaDisplay() {
		return areaDisplay;
	}

	public void setAreaDisplay(String areaDisplay) {
		this.areaDisplay = areaDisplay;
	}

	public String getCityDisplay() {
		return cityDisplay;
	}

	public void setCityDisplay(String cityDisplay) {
		this.cityDisplay = cityDisplay;
	}

	public String getXianDisplay() {
		return xianDisplay;
	}

	public void setXianDisplay(String xianDisplay) {
		this.xianDisplay = xianDisplay;
	}
 
}