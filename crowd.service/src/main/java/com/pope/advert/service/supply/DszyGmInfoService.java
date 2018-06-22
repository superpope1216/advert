package com.pope.advert.service.supply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

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
   
   DataResult<List<DszyGmInfoExtend>> selectDisplayByCondition(QueryCondition<DszyGmInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
   DataResult<Integer> deleteByDszyId( String dszyId,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> delete( String dszyId,CustomOperateLog log) throws ServiceException;
}
