package com.wisedu.crowd.common.code;

public enum YesNoEnum {
	YES("1", "开发"),

	NO("0", "实施");
	private String code;

	private String name;

	YesNoEnum(String code, String name) {
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
