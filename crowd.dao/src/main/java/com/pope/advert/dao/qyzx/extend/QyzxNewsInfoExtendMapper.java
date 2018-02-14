package com.pope.advert.dao.qyzx.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;

public interface QyzxNewsInfoExtendMapper {
	List<QyzxNewsInfoExtend> selectDisplayByCondition(QueryCondition<QyzxNewsInfoExtend> condition);
}