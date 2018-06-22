/**
 * Project Name:crowd-entity
 * File Name:CustormOperateLog.java
 * Package Name:com.wisedu.crowd.entity.log
 * Date:2017年8月17日下午4:35:34
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.pope.advert.entity.log;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * ClassName:CustormOperateLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月17日 下午4:35:34 <br/>
 * @author   de
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
/**
 * 客户端操作日志
 * ClassName: CustormOperateLog <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年8月17日 下午4:37:41 <br/>
 *
 * @author de
 * @version 
 * @since JDK 1.6
 */
public class CustomOperateLog implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /**
     * 用户ID
     */
    private String userId;
    
    private String companyId;
    
    private boolean isAdmin;
    
    public boolean getIsAdmin(){
    	return isAdmin;
    }
    
    public void setIsAdmin(boolean isAdmin){
    	this.isAdmin=isAdmin;
    }
    
    public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	private String sjh;
    
    public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getNc() {
		return nc;
	}

	public void setNc(String nc) {
		this.nc = nc;
	}

	private String xm;
    
    private String nc;
    
    /**
     * 客户端IP
     */
    private String customIp;
    
    /**
     * 客户端时间
     */
    private String dateTime;
    
    private String pageId;
    
    private String logType;
    
    private String logContent;
    
    private String content;

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomIp() {
        return customIp;
    }

    public void setCustomIp(String customIp) {
        this.customIp = customIp;
    }
    
}

