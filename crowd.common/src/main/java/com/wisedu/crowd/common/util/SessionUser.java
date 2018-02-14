/**
 * Project Name:crowd-common
 * File Name:SessionUser.java
 * Package Name:com.wisedu.crowd.common.util
 * Date:2017年8月29日下午1:39:00
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.wisedu.crowd.common.util;

import java.util.Date;

/**
 * ClassName:SessionUser <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年8月29日 下午1:39:00 <br/>
 * 
 * @author 11651
 * @version
 * @since JDK 1.6
 * @see
 */
public class SessionUser {

	private String	username;		// 用户名 或者 手机号
	private String	verification;	// 验证码
	private Date	senddate;		// 发送时间

	public SessionUser(String username,  String verification, Date senddate) {
		super();
		this.username = username;
		this.verification = verification;
		this.senddate = senddate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

}
