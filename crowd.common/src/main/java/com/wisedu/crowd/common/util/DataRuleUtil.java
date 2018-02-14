package com.wisedu.crowd.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataRuleUtil {

	/**
	 * 组成动作返回的数据格式
	 * @param code
	 * @param action
	 * @param datas
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public static Map<String,Object> getReturnValue(int code,String action,List<Map<String, Object>> datas,int pageSize,int pageNumber,int totalSize){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("code", code);
		Map<String,Object> mapDatas=new HashMap<String,Object>();
		map.put("datas", mapDatas);
		Map<String,Object> mapAction=new HashMap<String,Object>();
		mapDatas.put(action, mapAction);
		mapAction.put("pageSize", pageSize);
		mapAction.put("pageNumber", pageNumber);
		mapAction.put("totalSize", totalSize);
		mapAction.put("rows", datas);
		return map;
	}
	
}
