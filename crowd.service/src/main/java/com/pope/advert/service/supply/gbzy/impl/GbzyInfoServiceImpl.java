package com.pope.advert.service.supply.gbzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.gbzy.GbzyInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("gbzyInfoService")
public class GbzyInfoServiceImpl implements GbzyInfoService{

	@Autowired
	private GbzyInfoMapper gbzyInfoMapper;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzyInfoMapper.updateByPrimaryKeySelective(record));
	}
	
	
}
