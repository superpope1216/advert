package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;

public interface DszyTbInfoExtendMapper {
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
	
	List<DszyTbInfoExtend> selectDisplayByCondition(QueryCondition<DszyTbInfoExtend> condition);
}
