package com.pope.advert.dao.gggl.gbzy.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;

public interface GbzyQtInfoExtendMapper {
List<GbzyQtInfoExtend> selectByCondition(QueryCondition<GbzyQtInfoExtend> condition);
List<GbzyQtInfoExtend> selectDisplayByCondition(QueryCondition<GbzyQtInfoExtend> condition);
	Integer deleteByGbzyId(@Param("gbzyId") String gbzyId);
}
