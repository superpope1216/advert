package com.pope.advert.service.supply.bzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface BzzyJyInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(BzzyJyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<BzzyJyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(BzzyJyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(BzzyInfo bzzyInfo, BzzyJyInfo bzzyJyInfo, BzzyExtInfo bzzyExtInfo,
			CustomOperateLog log) throws ServiceException;
   

   DataResult<List<BzzyJyInfoExtend>> selectByCondition(QueryCondition<BzzyJyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;

	DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> delete(String bzzyId, CustomOperateLog log) throws ServiceException;
}
