package com.pope.advert.dao.gggl.zzzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;

public interface ZzzyInfoExtendMapper {
	List<ZzzyInfoExtend> selectDisplayByCondition(QueryCondition<ZzzyInfoExtend> condition);
}