package com.pope.advert.common.code;

public enum ShztEnum {
	CG("0", "草稿","您还没有注册为平台售卖方，请先注册完善资料！"),

	DSH("1", "待审核","抱歉，您的广告售卖方身份还在审核中，请耐心等待！"), YTG("2","已通过", "恭喜您，您的广告售卖方身份已审核通过"), WTG("3", "未通过","抱歉，您的平台售卖方身份审核未通过！");

	private String code;

	private String name;
	
	private String supplyContent;

	

	ShztEnum(String code, String name,String supplyContent) {
		this.code = code;
		this.name = name;
		this.supplyContent=supplyContent;
	}

	public String getSupplyContent() {
		return supplyContent;
	}
	public void setSupplyContent(String supplyContent) {
		this.supplyContent = supplyContent;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
