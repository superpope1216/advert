package com.pope.advert.common.code;

/**
 * 广告分类
 * @author wisedu
 *
 */
public enum SupplyClassifyEnum {
	HWGG("1", "户外广告"),
	DSGG("2","电视广告"),
	GBGG("3","广播广告"),
	BZGG("4","报纸广告"),
	XMTGG("5","新媒体广告"),
	ZZGG("6","杂志广告"),
	WLGG("7", "网络广告");
	private String code;

	private String name;

	SupplyClassifyEnum(String code, String name) {
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
