package com.pope.advert.service.supply.bzzy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface BzzyExtInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(BzzyExtInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<BzzyExtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(BzzyExtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyExtInfoExtend>> selectByCondition(QueryCondition<BzzyExtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;
   DataResult<List<BzzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException;
	
}
