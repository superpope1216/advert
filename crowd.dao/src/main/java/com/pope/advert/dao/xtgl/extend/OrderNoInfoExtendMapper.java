package com.pope.advert.dao.xtgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.xtgl.OrderNoInfo;
import com.pope.advert.entity.xtgl.extend.OrderNoInfoExtend;

public interface OrderNoInfoExtendMapper {
	List<OrderNoInfoExtend>  selectByCondition(QueryCondition<OrderNoInfoExtend> record);
}