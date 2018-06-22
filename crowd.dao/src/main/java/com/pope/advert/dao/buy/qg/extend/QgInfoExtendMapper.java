package com.pope.advert.dao.buy.qg.extend;

import java.util.List;

import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;

public interface QgInfoExtendMapper {

	List<QgInfoExtend> selectByCondition(QueryCondition<QgInfoExtend> condition);
	
	List<QgInfoExtend> selectDisplayByCondition(QueryCondition<QgInfoExtend> condition);
}
