package com.pope.advert.common.code;

public enum YhxxDjEnum {
	XTGL_FJLJ("XTGL_FJLJ","附件路径");
	private String code;

	private String name;

	YhxxDjEnum(String code, String name) {
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
