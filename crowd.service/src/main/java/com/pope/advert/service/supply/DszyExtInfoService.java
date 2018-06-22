package com.pope.advert.service.supply;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface DszyExtInfoService {
	 /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> insertSelective(DszyExtInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<DszyExtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszyExtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<DszyExtInfoExtend>> selectByCondition(QueryCondition<DszyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<DszyExtInfoExtend>> selectDisplayByCondition(QueryCondition<DszyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   DataResult<Integer> deleteByDszyId( String dszyId,CustomOperateLog log) throws ServiceException;
}
