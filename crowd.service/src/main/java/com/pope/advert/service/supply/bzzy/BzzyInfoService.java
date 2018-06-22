package com.pope.advert.service.supply.bzzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface BzzyInfoService {
	  /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> insertSelective(BzzyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<BzzyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-24
    */
   DataResult<Integer> updateByPrimaryKeySelective(BzzyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<BzzyInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
