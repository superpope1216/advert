package com.pope.advert.service.supply.zzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.zzzy.ZzzyExtInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("zzzyExtInfoService")
public class ZzzyExtInfoServiceImpl implements ZzzyExtInfoService{
	@Autowired
	private ZzzyExtInfoMapper zzzyExtInfoMapper;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}
}
