package com.pope.advert.common.code;

public enum CompanyClassifyEnum {
	/**
	 * 卖方
	 */
	SUPPLY("1", "卖方"),
	/**
	 * 买方
	 */
	BUY("2", "买方"),
	BOTH("3","两者都是");
	private String code;

	private String name;

	CompanyClassifyEnum(String code, String name) {
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
