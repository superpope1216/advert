package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;

public interface DszySdInfoExtendMapper {
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
	
	List<DszySdInfoExtend> selectDisplayByCondition(QueryCondition<DszySdInfoExtend> condition);
}