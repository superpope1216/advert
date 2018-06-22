package com.pope.advert.common.code;

public enum AreaClassifyEnum {

	/**
	 * 省
	 */
	AREA("1", "省"),
	/**
	 * 市
	 */
	CITY("2", "市"),
	/**
	 * 县
	 */
	XIAN("3","县");
	private String code;

	private String name;

	AreaClassifyEnum(String code, String name) {
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
