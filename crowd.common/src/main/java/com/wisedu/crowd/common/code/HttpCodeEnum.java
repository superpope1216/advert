/**
 * Project Name:service
 * File Name:HttpCodeEnum.java
 * Package Name:com.wisedu.crowd.state
 * Date:2017年8月10日下午5:23:39
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.wisedu.crowd.common.code;

/**
 * ClassName:HttpCodeEnum <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年8月10日 下午5:23:39 <br/>
 * 
 * @author de
 * @version
 * @since JDK 1.6
 * @see
 */
public enum HttpCodeEnum {

	/**
	 * 有效
	 */
	SUCCESS(0, "服务查询成功"),
	/**
	 * 无效
	 */
	FAIL(-1, "服务查询失败"),
	/**
	 * 登录失败
	 */
	LOGIN_FAIL(-2, "用户名/密码错误"),
	/**
	 * 用户注册失败
	 */
	REGISTER_FAIL(-3, "用户注册失败"),
	/**
	 * 手机号码已存在
	 */
	EXIST_PHONE(-4, "手机号码已存在，请重新输入!"),
	/**
	 * 昵称已存在
	 */
	EXIST_NICK_NAME(-5, "昵称已存在，请重新输入!"),
	/**
	 * 用户失效
	 */
	USER_INVALID(-6, "用户失效,请重新登录"),

	IS_NOT_BUY(-7, "不是购买方"),

	BUY_SFRZ_NOT_SUBMIT(-10, "购买方身份认证信息还未提交"),

	BUY_SFRZ_PASSING(-8, "购买方身份认证信息正在审核中"),

	BUY_SFRZ_NOT_PASS(-9, "购买方身份认证信息审核未通过"),

	NOT_LOGIN(-10, "未登录"), IS_NOT_SUPPLY(-11, "不是发布方"), SUPPLY_SFRZ_PASSING(-12, "发布方身份认证信息正在审核中"),

	SUPPLY_SFRZ_NOT_PASS(-13, "发布方身份认证信息审核未通过"),SUPPLY_SFRZ_NOT_SUBMIT(-14, "发布方身份认证信息还未提交");

	public int code;
	private String name;

	HttpCodeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
