package com.pope.advert.entity.gggl.bzzy.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.advert.entity.gggl.bzzy.BzzyXbmggInfo;

public class BzzyXbmggInfoExtend extends BzzyXbmggInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型
	 */
	private String lxDisplay;
	/**
	 * 颜色
	 */
	private String ysDisplay;

	public String getLxDisplay() {
		return lxDisplay;
	}

	public void setLxDisplay(String lxDisplay) {
		this.lxDisplay = lxDisplay;
	}

	public String getYsDisplay() {
		return ysDisplay;
	}

	public void setYsDisplay(String ysDisplay) {
		this.ysDisplay = ysDisplay;
	}
	
	

}