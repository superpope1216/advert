package com.pope.advert.service.xtgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.xtgl.OrderNoInfo;
import com.pope.advert.entity.xtgl.extend.OrderNoInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface OrderNoInfoService {
	  /**
    *
    * @mbggenerated 2018-05-30
    */
   DataResult<Integer> deleteByPrimaryKey(Integer id,CustomOperateLog log) throws ServiceException;


   /**
    *
    * @mbggenerated 2018-05-30
    */
   DataResult<Integer> insertSelective(OrderNoInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-05-30
    */
   DataResult<OrderNoInfo> selectByPrimaryKey(Integer id,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-05-30
    */
   DataResult<Integer> updateByPrimaryKeySelective(OrderNoInfo record,CustomOperateLog log) throws ServiceException;

   
   DataResult<List<OrderNoInfoExtend>>  selectByCondition(QueryCondition<OrderNoInfoExtend> record,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<String> getMaxOrderNo(CustomOperateLog log) throws ServiceException;
}
