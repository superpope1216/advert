package com.pope.advert.service.supply.zzzy;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface ZzzyExtInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(ZzzyExtInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<ZzzyExtInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(ZzzyExtInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<ZzzyExtInfoExtend>> selectByCondition(QueryCondition<ZzzyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	
   DataResult<Integer> deleteByGbzyId(String zzzyId,CustomOperateLog log) throws ServiceException;
   DataResult<List<ZzzyExtInfoExtend>> selectDisplayByCondition(QueryCondition<ZzzyExtInfoExtend> condition,CustomOperateLog log) throws ServiceException;
}
