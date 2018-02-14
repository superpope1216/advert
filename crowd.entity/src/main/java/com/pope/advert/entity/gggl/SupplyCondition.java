package com.pope.advert.entity.gggl;

import java.io.Serializable;

import com.pope.advert.entity.gggl.extend.DszyInfoExtend;

public class SupplyCondition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DszyInfoExtend dszyInfoExtend;
	
	private String condition;

	public DszyInfoExtend getDszyInfoExtend() {
		return dszyInfoExtend;
	}

	public void setDszyInfoExtend(DszyInfoExtend dszyInfoExtend) {
		this.dszyInfoExtend = dszyInfoExtend;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
}
