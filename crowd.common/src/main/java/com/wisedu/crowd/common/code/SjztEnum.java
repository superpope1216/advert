package com.wisedu.crowd.common.code;

/**
 * 商机状态
 * @author wisedu
 *
 */
public enum SjztEnum {
	CG("0", "草稿"),

	DSH("1", "待审核"), YTG("2", "已通过"), WTG("3", "未通过"),YJS("5","已结束");

	private String code;

	private String name;

	SjztEnum(String code, String name) {
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
