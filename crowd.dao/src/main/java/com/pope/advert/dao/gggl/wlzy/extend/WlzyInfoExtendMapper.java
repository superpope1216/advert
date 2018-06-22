package com.pope.advert.dao.gggl.wlzy.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;

public interface WlzyInfoExtendMapper {
	List<WlzyInfoExtend> selectDisplayByCondition(QueryCondition<WlzyInfoExtend> condition);
}
