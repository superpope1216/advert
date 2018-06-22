package com.pope.advert.service.supply.bzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyXbmggInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface BzzyXbmggInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(BzzyXbmggInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<BzzyXbmggInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(BzzyXbmggInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(BzzyInfo bzzyInfo, BzzyXbmggInfo bzzyXbmggInfo, BzzyExtInfo bzzyExtInfo,
			CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyXbmggInfoExtend>> selectByCondition(QueryCondition<BzzyXbmggInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyXbmggInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyXbmggInfoExtend> condition,CustomOperateLog log) throws ServiceException;

	DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> delete(String bzzyId, CustomOperateLog log) throws ServiceException;
}
