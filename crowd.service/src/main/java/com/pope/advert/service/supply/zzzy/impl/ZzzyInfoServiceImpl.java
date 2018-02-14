package com.pope.advert.service.supply.zzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.zzzy.ZzzyInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("zzzyInfoService")
public class ZzzyInfoServiceImpl implements ZzzyInfoService{

	@Autowired
	private ZzzyInfoMapper zzzyInfoMapper;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyInfoMapper.updateByPrimaryKeySelective(record));
	}
}
