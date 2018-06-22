package com.wisedu.crowd.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {
	@SuppressWarnings("unchecked")
	public static <T,E>  Map<T,E> changeKeyToLower(Map<T,E> map){
		Map<T,E> newMap=new HashMap<T,E>();
		if(CommonUtil.isNotEmptyMap(map)){
			for (Map.Entry<T,E> entry : map.entrySet()) { 
				newMap.put((T)StringUtil.toStr(entry.getKey()).toLowerCase(), entry.getValue()); 
			}
		}
		return newMap;
	}
	
	public static <T,E>  List<Map<T,E>> changeKeyToLower(List<Map<T,E>> list){
		List<Map<T,E>> datas=new ArrayList<Map<T,E>>();
		if(CommonUtil.isNotEmptyList(list)){
			for(Map<T,E> map:list){
				datas.add(changeKeyToLower(map));
			}
		}
		return datas;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T,E>  Map<T,E> changeKeyToUpper(Map<T,E> map){
		Map<T,E> newMap=new HashMap<T,E>();
		if(CommonUtil.isNotEmptyMap(map)){
			for (Map.Entry<T,E> entry : map.entrySet()) { 
				newMap.put((T)StringUtil.toStr(entry.getKey()).toUpperCase(), entry.getValue()); 
			}
		}
		return newMap;
	}
	
	public static <T,E>  List<Map<T,E>> changeKeyToUpper(List<Map<T,E>> list){
		List<Map<T,E>> datas=new ArrayList<Map<T,E>>();
		if(CommonUtil.isNotEmptyList(list)){
			for(Map<T,E> map:list){
				datas.add(changeKeyToUpper(map));
			}
		}
		return datas;
	}
}
