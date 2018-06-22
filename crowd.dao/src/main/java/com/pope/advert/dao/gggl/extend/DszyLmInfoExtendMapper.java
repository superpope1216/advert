package com.pope.advert.dao.gggl.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;

public interface DszyLmInfoExtendMapper {
	Integer deleteByDszyId(@Param("dszyId") String dszyId);
	
	List<DszyLmInfoExtend> selectDisplayByCondition(QueryCondition<DszyLmInfoExtend> condition);
}
