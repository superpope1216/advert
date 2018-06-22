package com.pope.advert.dao.gggl.gbzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;

public interface GbzyInfoExtendMapper {
	List<GbzyInfoExtend> selectDisplayByCondition(QueryCondition<GbzyInfoExtend> condition);
}