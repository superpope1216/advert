package com.pope.advert.service.cwgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface CwglDjxxInfoService {
	 /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> insertSelective(CwglDjxxInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<CwglDjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
   DataResult<Integer> updateByPrimaryKeySelective(CwglDjxxInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<CwglDjxxInfoExtend>> selectByCondition(QueryCondition<CwglDjxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
}
