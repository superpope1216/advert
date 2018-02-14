package com.pope.advert.service.supply.gbzy;

import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface GbzyQtInfoService {
	 /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<Integer> insertSelective(GbzyQtInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
	 DataResult<GbzyQtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(GbzyQtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(GbzyInfo gbzyInfo, GbzyQtInfo gbzyQtInfo, GbzyExtInfo gbzyExtInfo,
			CustomOperateLog log) throws ServiceException;;
}
