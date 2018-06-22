package com.pope.advert.service.supply.gbzy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface GbzyExtInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(GbzyExtInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<GbzyExtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(GbzyExtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<GbzyExtInfoExtend>> selectByCondition(QueryCondition<GbzyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	
   DataResult<Integer> deleteByGbzyId(@Param("gbzyId") String gbzyId,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<GbzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<GbzyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
}
