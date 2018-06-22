package com.pope.advert.service.buy.qg;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface QgInfoService {
	/**
    *
    * @mbggenerated 2018-02-25
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-25
    */
   DataResult<Integer> insertSelective(QgInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-25
    */
   DataResult<QgInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-25
    */
   DataResult<Integer> updateByPrimaryKeySelective(QgInfo record,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<List<QgInfoExtend>> selectByCondition(QueryCondition<QgInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	
   DataResult<List<QgInfoExtend>> selectDisplayByCondition(QueryCondition<QgInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> publishing(QgInfo qgInfo,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
