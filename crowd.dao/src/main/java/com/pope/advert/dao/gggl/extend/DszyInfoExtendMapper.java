package com.pope.advert.dao.gggl.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyCondition;

public interface DszyInfoExtendMapper {
   
	List<Map<String,Object>> selectDisplayViewByCondition(@Param("condition") String condition,@Param("registerId") String registerId);
	
	
	List<Map<String,Object>> selectDisplayByCondtion(QueryCondition<SupplyCondition> condition);
}