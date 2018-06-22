package com.pope.advert.entity.yhgl.extend;

import java.io.Serializable;

import com.pope.advert.entity.yhgl.RegisterInfo;

public class RegisterInfoExtend extends RegisterInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String yhmLike;
	/**
	 * 表示用like查询方式
	 */
	private String sjhLike;
	
	private YhglDjxxInfoExtend djxx;
	public YhglDjxxInfoExtend getDjxx() {
		return djxx;
	}
	public void setDjxx(YhglDjxxInfoExtend djxx) {
		this.djxx = djxx;
	}
	public String getYhmLike() {
		return yhmLike;
	}
	public void setYhmLike(String yhmLike) {
		this.yhmLike = yhmLike;
	}
	public String getSjhLike() {
		return sjhLike;
	}
	public void setSjhLike(String sjhLike) {
		this.sjhLike = sjhLike;
	}
}
