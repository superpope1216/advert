package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;

public interface DszyZtInfoExtendMapper {
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
	List<DszyZtInfoExtend> selectDisplayByCondition(QueryCondition<DszyZtInfoExtend> condition);
}
