package com.pope.advert.service.yhgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.CompanyZzInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface CompanyZzInfoService {

   /**
    *
    * @mbggenerated 2018-01-16
    */
   DataResult<Integer> insertSelective(CompanyZzInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-01-16
    */
   DataResult<CompanyZzInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;
   /**
    *
    * @mbggenerated 2018-01-16
    */
   DataResult<Integer> updateByPrimaryKeySelective(CompanyZzInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<CompanyZzInfoExtend>> selectDisplayByCondition(QueryCondition<CompanyZzInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<Integer> updateByCondition(CompanyZzInfo companyZzInfo,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> save(CompanyZzInfo companyZzInfo,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
