package com.pope.advert.dao.gggl.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyCondition;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;

public interface DszyInfoExtendMapper {
	
	List<DszyInfoExtend> selectDisplayByCondition(QueryCondition<DszyInfoExtend> condition);
}