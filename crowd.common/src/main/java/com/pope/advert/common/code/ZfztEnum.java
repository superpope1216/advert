package com.pope.advert.common.code;

public enum ZfztEnum {
	DZF("1", "待支付"),
	ZFBZFCG("2", "支付宝支付成功"),
	XTZFCG("3", "系统支付成功");
	private String code;

	private String name;

	ZfztEnum(String code, String name) {
		this.code = code;
		this.name = name;
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
