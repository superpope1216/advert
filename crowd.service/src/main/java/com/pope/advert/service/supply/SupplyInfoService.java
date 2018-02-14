package com.pope.advert.service.supply;

import java.util.List;
import java.util.Map;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface SupplyInfoService {
	DataResult<List<Map<String,Object>>> selectByCondition(QueryCondition<SupplyInfo> condition,CustomOperateLog log) throws ServiceException;
}
