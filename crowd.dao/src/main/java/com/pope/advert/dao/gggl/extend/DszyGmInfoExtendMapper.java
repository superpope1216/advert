package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;

public interface DszyGmInfoExtendMapper {
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
	
	List<DszyGmInfoExtend> selectDisplayByCondition(QueryCondition<DszyGmInfoExtend> condition);
}
