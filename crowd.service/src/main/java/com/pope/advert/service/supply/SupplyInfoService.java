package com.pope.advert.service.supply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface SupplyInfoService {
	DataResult<List<Map<String,Object>>> selectByCondition(QueryCondition<SupplyInfo> condition,CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> selectCountByCondition(QueryCondition<SupplyInfo> condition,CustomOperateLog log) throws ServiceException;
	
	DataResult<Map<String,Object>> selectDszyByCondition(String dszyId,String tableName,CustomOperateLog log);
	
	DataResult<Integer> deleteDszyByCondition(String dszyId,String tableName,CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> sendMsg(final String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
