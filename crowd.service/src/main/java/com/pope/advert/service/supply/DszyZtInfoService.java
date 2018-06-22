package com.pope.advert.service.supply;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface DszyZtInfoService {
	/**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> insertSelective(DszyZtInfo record, CustomOperateLog log);

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<DszyZtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszyZtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(DszyInfo dszyInfo, DszyZtInfo dszyZtInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException;
   DataResult<List<DszyZtInfoExtend>> selectDisplayByCondition(QueryCondition<DszyZtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
DataResult<Integer> deleteByDszyId( String dszyId,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> delete( String dszyId,CustomOperateLog log) throws ServiceException;
}
