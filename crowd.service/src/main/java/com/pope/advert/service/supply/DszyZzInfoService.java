package com.pope.advert.service.supply;

import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface DszyZzInfoService {
	 /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> insertSelective(DszyZzInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<DszyZzInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszyZzInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(DszyInfo dszyInfo, DszyZzInfo dszyZzInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException;;
}
