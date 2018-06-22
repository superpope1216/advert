package com.pope.advert.service.supply.gbzy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface GbzySdInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<Integer> insertSelective(GbzySdInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<GbzySdInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(GbzySdInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(GbzyInfo gbzyInfo, GbzySdInfo gbzySdInfo, GbzyExtInfo gbzyExtInfo,
			CustomOperateLog log) throws ServiceException;
   
	DataResult<List<GbzySdInfoExtend>> selectByCondition(QueryCondition<GbzySdInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
	DataResult<List<GbzySdInfoExtend>> selectDisplayByCondition(QueryCondition<GbzySdInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	DataResult<Integer> deleteByGbzyId(@Param("gbzyId") String gbzyId, CustomOperateLog log) throws ServiceException;
	
	
	DataResult<Integer> delete(String gbzyId, CustomOperateLog log) throws ServiceException;
}
