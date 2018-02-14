package com.pope.advert.service.supply.bzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.bzzy.BzzyExtInfoMapper;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("bzzyExtInfoService")
public class BzzyExtInfoServiceImpl implements BzzyExtInfoService {

	@Autowired
	private BzzyExtInfoMapper bzzyExtInfoMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyExtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyExtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyExtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyExtInfoMapper.updateByPrimaryKeySelective(record));
	}

	
}
