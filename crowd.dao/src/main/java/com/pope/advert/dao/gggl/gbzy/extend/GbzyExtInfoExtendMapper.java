package com.pope.advert.dao.gggl.gbzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;

public interface GbzyExtInfoExtendMapper {

	List<GbzyExtInfoExtend> selectByCondition(QueryCondition<GbzyExtInfoExtend> condition);
	
	Integer deleteByGbzyId(@Param("gbzyId") String gbzyId);
	
	List<GbzyExtInfoExtend> selectDisplayByCondition(QueryCondition<GbzyExtInfoExtend> condition);
}
