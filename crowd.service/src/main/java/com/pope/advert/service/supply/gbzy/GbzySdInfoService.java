package com.pope.advert.service.supply.gbzy;

import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

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
			CustomOperateLog log) throws ServiceException;;
}
