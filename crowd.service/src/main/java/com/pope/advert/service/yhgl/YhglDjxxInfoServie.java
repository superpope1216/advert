package com.pope.advert.service.yhgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface YhglDjxxInfoServie {
	/**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<Integer> insertSelective(YhglDjxxInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
	DataResult<YhglDjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-04-15
    */
   DataResult<Integer> updateByPrimaryKeySelective(YhglDjxxInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<YhglDjxxInfoExtend>> selectByCondition(QueryCondition<YhglDjxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<YhglDjxxInfoExtend>> selectDisplayByCondition(QueryCondition<YhglDjxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> updateByVersion(YhglDjxxInfo yhglDjxxInfo,CustomOperateLog log) throws ServiceException;
}
