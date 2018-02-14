package com.pope.advert.service.supply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.SupplyCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface DszyInfoService {
	 /**
    *
    * @mbggenerated 2017-12-17
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
   DataResult<Integer> insertSelective(DszyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
   DataResult<DszyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<Map<String,Object>>> selectDisplayViewByCondition(String condition, String registerId,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<Map<String,Object>>> selectDisplayByCondtion(QueryCondition<SupplyCondition> condition,CustomOperateLog log) throws ServiceException;

}
