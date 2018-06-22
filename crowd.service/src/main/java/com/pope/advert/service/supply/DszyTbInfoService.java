package com.pope.advert.service.supply;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyTbInfo;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface DszyTbInfoService {
	 /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer>  insertSelective(DszyTbInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<DszyTbInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-21
    */
   DataResult<Integer>  updateByPrimaryKeySelective(DszyTbInfo record,CustomOperateLog log) throws ServiceException;

   DataResult<Integer> publishing(DszyInfo dszyInfo, DszyTbInfo dszyTbInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException;

   DataResult<List<DszyTbInfoExtend>> selectDisplayByCondition(QueryCondition<DszyTbInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
DataResult<Integer> deleteByDszyId( String dszyId,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> delete( String dszyId,CustomOperateLog log) throws ServiceException;
}
