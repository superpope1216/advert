package com.pope.advert.dao.gggl.gbzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;

public interface GbzySdInfoExtendMapper {
	List<GbzySdInfoExtend> selectByCondition(QueryCondition<GbzySdInfoExtend> condition);
	List<GbzySdInfoExtend> selectDisplayByCondition(QueryCondition<GbzySdInfoExtend> condition);
	Integer deleteByGbzyId(@Param("gbzyId") String gbzyId);
}
