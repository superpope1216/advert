package com.pope.advert.service.supply.zzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface ZzzyJyInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(ZzzyJyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<ZzzyJyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(ZzzyJyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(ZzzyInfo zzzyInfo, ZzzyJyInfo zzzyJyInfo, ZzzyExtInfo zzzyExtInfo,
			CustomOperateLog log) throws ServiceException;
   
   DataResult<List<ZzzyJyInfoExtend>> selectByCondition(QueryCondition<ZzzyJyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;

	DataResult<Integer> deleteByGbzyId(String zzzyId, CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> delete(String zzzyId, CustomOperateLog log) throws ServiceException;
}
