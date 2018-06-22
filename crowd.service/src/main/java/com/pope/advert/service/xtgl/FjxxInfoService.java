package com.pope.advert.service.xtgl;


import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.xtgl.FjxxInfo;
import com.pope.advert.service.dto.DataResult;

public interface FjxxInfoService {

	   DataResult<FjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log)throws ServiceException;
	   
	   DataResult<FjxxInfo> insertSelective(FjxxInfo record,CustomOperateLog log)throws ServiceException;
       
	   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log)throws ServiceException;

	   

}
