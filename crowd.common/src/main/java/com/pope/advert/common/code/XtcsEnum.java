package com.pope.advert.common.code;

public enum XtcsEnum {
	/**
	 * 附件路径
	 */
	XTGL_FJLJ("XTGL_FJLJ","附件路径"),
	DEFAULT_GGSJ("DEFAULT_GGSJ","默认用户广告周期"),
	DEFAULT_GGTS("DEFAULT_GGTS","默认用户广告条数");
	;
	private String code;

	private String name;

	XtcsEnum(String code, String name) {
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
