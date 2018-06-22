package com.pope.advert.dao.gggl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;

public interface SupplyInfoMapper {

	List<Map<String,Object>> selectByCondition(QueryCondition<SupplyInfo> condition);
	Integer selectCountByCondition(QueryCondition<SupplyInfo> condition);
	Map<String,Object> selectDszyByCondition(@Param("dszyId") String dszyId,@Param("tableName")String tableName);
	
	Integer deleteDszyByCondition(@Param("dszyId") String dszyId,@Param("tableName")String tableName);
}
