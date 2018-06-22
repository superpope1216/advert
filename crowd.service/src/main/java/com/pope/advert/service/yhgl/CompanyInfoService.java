package com.pope.advert.service.yhgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface CompanyInfoService {
	 /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> insertSelective(CompanyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<CompanyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> updateByPrimaryKeySelective(CompanyInfo record,CustomOperateLog log) throws ServiceException;
   
   DataResult<CompanyInfo> saveCompanyInfo(CompanyInfo companyInfo,CustomOperateLog log) throws ServiceException;
   
   DataResult<List<CompanyInfoExtend>> selectByCondition(QueryCondition<CompanyInfoExtend> records,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<Integer> shSupply(String wid,String state,CustomOperateLog log) throws ServiceException;
}
