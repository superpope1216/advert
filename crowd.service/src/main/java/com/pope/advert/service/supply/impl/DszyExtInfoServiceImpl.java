package com.pope.advert.service.supply.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.DszyExtInfoMapper;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("dszyExtInfoService")
public class DszyExtInfoServiceImpl implements DszyExtInfoService {
@Autowired
	private DszyExtInfoMapper dszyExtInfoMapper;

@Override
public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.deleteByPrimaryKey(wid));
}

@Override
public DataResult<Integer> insertSelective(DszyExtInfo record, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.insertSelective(record));
}

@Override
public DataResult<DszyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.selectByPrimaryKey(wid));
}

@Override
public DataResult<Integer> updateByPrimaryKeySelective(DszyExtInfo record, CustomOperateLog log)
		throws ServiceException {
	return DataResult.success(dszyExtInfoMapper.updateByPrimaryKeySelective(record));
} 
	 
}
