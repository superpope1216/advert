package com.wisedu.crowd.common.util;

import java.util.List;

import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;

public class ConditionUtil {

	public static <T> QueryCondition<T> createCondition(T t){
		return createCondition(t,null,null);
	}
	
	public static <T> QueryCondition<T> createCondition(T t,PageInfo pageInfo){
		return createCondition(t,pageInfo,null);
	}
	
	public static <T> QueryCondition<T> createCondition(T t,List<String> orders){
		return createCondition(t,null,orders);
	}
	
	public static <T> QueryCondition<T> createCondition(T t,PageInfo pageInfo,List<String> orders){
		QueryCondition<T> condition=new QueryCondition<T>();
		condition.setQuery(t);
		condition.setPageInfo(pageInfo);
		condition.setOrderBy(orders);
		return condition;
	}
}
