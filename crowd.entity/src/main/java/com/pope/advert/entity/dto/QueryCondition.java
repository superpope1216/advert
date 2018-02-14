/**
 * Project Name:entity
 * File Name:QueryCondition.java
 * Package Name:com.wisedu.crowd.dto
 * Date:2017年8月10日下午12:40:29
 * Copyright (c) 2017, 01113232@wisedu.com All Rights Reserved.
 *
*/

package com.pope.advert.entity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * ClassName:QueryCondition通用查询条件 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年8月10日 下午12:40:29 <br/>
 * @author   de
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class QueryCondition<T> implements Serializable {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    /**
     * 查询条件
     */
    private T query;
    
    private PageInfo pageInfo;
   
    public QueryCondition(){
    	
    }
    public QueryCondition(T query,PageInfo pageInfo){
    	this.query=query;
    	this.pageInfo=pageInfo;
    }
    public QueryCondition(T query,List<String> orderBy){
    	this.query=query;
    	this.orderBy=orderBy;
    }
    public QueryCondition(T query,PageInfo pageInfo,List<String> orderBy){
    	this.query=query;
    	this.pageInfo=pageInfo;
    	this.orderBy=orderBy;
    }

    /**
     * 排序条件
     */
    private List<String> orderBy;

    
    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public List<String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<String> orderBy) {
        this.orderBy = orderBy;
    }
    
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}

