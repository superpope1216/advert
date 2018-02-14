package com.pope.advert.service.supply.bzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.bzzy.BzzyInfoMapper;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.wisedu.crowd.common.exception.ServiceException;

@Service("bzzyInfoService")
public class BzzyInfoServiceImpl implements BzzyInfoService {

	@Autowired
	private BzzyInfoMapper bzzyInfoMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyInfoMapper.updateByPrimaryKeySelective(record));
	}

}
