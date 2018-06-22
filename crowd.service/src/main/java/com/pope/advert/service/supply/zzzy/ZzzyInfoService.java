package com.pope.advert.service.supply.zzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface ZzzyInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(ZzzyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<ZzzyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(ZzzyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<ZzzyInfoExtend>> selectDisplayByCondition(QueryCondition<ZzzyInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
