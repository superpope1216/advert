/**
 * Project Name:crowd-common
 * File Name:SessionUserUtil.java
 * Package Name:com.wisedu.crowd.common.util
 * Date:2017年8月29日下午1:44:57
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.wisedu.crowd.common.util;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * ClassName:SessionUserUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年8月29日 下午1:44:57 <br/>
 * 
 * @author 11651
 * @version
 * @since JDK 1.6
 * @see
 */
public class SessionUserUtil {

	public static boolean validateCaptchaCode(HttpServletRequest request, String key, String captchaCode) {
		return validateCaptchaCode(request, key, captchaCode, new Integer(5));
	}

	public static boolean validateCaptchaCode(HttpServletRequest request, String key, String captchaCode,
			Integer effectiveMinutes) {
		SessionUser sessionUser = getSessionUser(request, key);
		if (StringUtil.isEmpty(sessionUser) || StringUtil.isEmpty(sessionUser.getVerification())) {
			return false;
		}
		if (!StringUtil.isEmpty(effectiveMinutes) && !StringUtil.isEmpty(sessionUser.getSenddate())) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sessionUser.getSenddate());
			calendar.add(Calendar.MINUTE, effectiveMinutes);
			if (calendar.getTime().before(new Date())) {
				return false;
			}
		}
		return StringUtils.equals(captchaCode, sessionUser.getVerification());
	}

	public static SessionUser getSessionUser(HttpServletRequest request, String key) {
		if (StringUtils.isBlank(key)) {
			return null;
		}
		SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(key);
		return sessionUser;
	}

}
