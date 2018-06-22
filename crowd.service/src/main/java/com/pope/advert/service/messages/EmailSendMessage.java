/**
 * Project Name:crowd-service
 * File Name:sms.java
 * Package Name:com.wisedu.crowd.message.email
 * Date:2017年8月23日上午11:40:25
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.pope.advert.service.messages;



import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.wisedu.crowd.common.util.CommonUtil;


/**
 * ClassName:sms <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月23日 上午11:40:25 <br/>
 * @author   de
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

public interface EmailSendMessage {
	boolean sendMessage(List<String> users,String title,String content)  throws Exception;

	boolean sendHtmlMessage(List<String> users,String title,String content)throws Exception;
  
}

