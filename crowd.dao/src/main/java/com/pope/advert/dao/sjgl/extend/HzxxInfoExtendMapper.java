package com.pope.advert.dao.sjgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;

public interface HzxxInfoExtendMapper {
	List<HzxxInfoExtend> selectDisplayByCondition(QueryCondition<HzxxInfoExtend> condition);
}
