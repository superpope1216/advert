package com.pope.advert.service.cwgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.cwgl.CwglCzjlInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface CwglCzjlInfoService {
	 /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> insertSelective(CwglCzjlInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<CwglCzjlInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
   DataResult<Integer> updateByPrimaryKeySelective(CwglCzjlInfo record,CustomOperateLog log) throws ServiceException;
   
   /**
    * 充值
    * @param condition
    * @param log
    * @return
    * @throws ServiceException
    */
   DataResult<List<CwglCzjlInfoExtend>> selectByCondition(QueryCondition<CwglCzjlInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<CwglCzjlInfoExtend>> selectDisplayByCondition(QueryCondition<CwglCzjlInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<String> recharge(String djid,Integer nx, CustomOperateLog log) throws ServiceException ;
}
