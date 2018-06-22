package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;

public interface DszyExtInfoExtendMapper {

	List<DszyExtInfoExtend> selectByCondition(QueryCondition<DszyExtInfoExtend> condition);
	
	List<DszyExtInfoExtend> selectDisplayByCondition(QueryCondition<DszyExtInfoExtend> condition);
	
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
}
