package com.pope.advert.service.supply.bzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface BzzyGsygInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(BzzyGsygInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<BzzyGsygInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(BzzyGsygInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(BzzyInfo bzzyInfo, BzzyGsygInfo bzzyGsygInfo, BzzyExtInfo BzzyExtInfo,
			CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyGsygInfoExtend>> selectByCondition(QueryCondition<BzzyGsygInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyGsygInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyGsygInfoExtend> condition,CustomOperateLog log) throws ServiceException;

	DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> delete(String bzzyId, CustomOperateLog log) throws ServiceException;
}
