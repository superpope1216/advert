/**
 * Project Name:entity
 * File Name:PageInfo.java
 * Package Name:com.wisedu.crowd.dto
 * Date:2017年8月9日下午5:13:55
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.pope.advert.entity.dto;

import java.io.Serializable;

/**
 * ClassName:PageInfo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月9日 下午5:13:55 <br/>
 * @author   de
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class PageInfo implements Serializable {
/**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
   

  

    private int pageSize=10;
    
    private int pageNum=1;
    
    private int totalPage=0;
  

    public PageInfo(){
    	
    }
    
    public PageInfo(Integer pageSize,Integer pageNum){
    	if(pageSize!=null){
    	this.pageSize=pageSize;
    	}
    	if(pageNum!=null){
    	this.pageNum=pageNum;
    	}
    }
	private long totalSize;

	  
    public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}

