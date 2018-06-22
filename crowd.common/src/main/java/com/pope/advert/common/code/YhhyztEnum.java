package com.pope.advert.common.code;

/**
 * 用户会员装填
 * 
 * @author zhang
 *
 */
public enum YhhyztEnum {
	ZC("1", "正常"),

	JJGQ("2", "即将过期"),
	QF("3", "欠费");

	private String code;

	private String name;

	YhhyztEnum(String code, String name) {
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
