package com.pope.advert.dao.sjgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;

public interface ZbxxInfoExtendMapper {
	List<ZbxxInfoExtend> selectDisplayByCondition(QueryCondition<ZbxxInfoExtend> condition);
}
