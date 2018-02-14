package com.pope.advert.service.supply;

import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface DszyGmInfoService {
	/**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> insertSelective(DszyGmInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<DszyGmInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszyGmInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(DszyInfo dszyInfo, DszyGmInfo dszyGmInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException ;
}
