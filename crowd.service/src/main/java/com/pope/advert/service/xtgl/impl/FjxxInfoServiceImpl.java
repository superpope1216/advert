package com.pope.advert.service.xtgl.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.xtgl.FjxxInfoMapper;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.xtgl.FjxxInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.FjxxInfoService;

@Service("fjxxInfoService")
@Transactional
public class FjxxInfoServiceImpl implements FjxxInfoService{

	@Autowired
	private  FjxxInfoMapper fjxxInfoMapper;

	@Override
	public DataResult<FjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return  DataResult.success(fjxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<FjxxInfo> insertSelective(FjxxInfo record,CustomOperateLog log) throws ServiceException {
		fjxxInfoMapper.insertSelective(record);
		return  DataResult.success(record);
	}

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(fjxxInfoMapper.deleteByPrimaryKey(wid));
	}
	
	

	
    
}
