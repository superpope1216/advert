package com.pope.advert.service.supply.gbzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.gbzy.GbzyExtInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("gbzyExtInfoService")
public class GbzyExtInfoServiceImpl implements GbzyExtInfoService {

	@Autowired
	private GbzyExtInfoMapper gbzyExtInfoMapper;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}
	
}
