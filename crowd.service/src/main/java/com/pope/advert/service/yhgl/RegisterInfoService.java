package com.pope.advert.service.yhgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface RegisterInfoService {

	 /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

  
   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> insertSelective(RegisterInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<RegisterInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-16
    */
   DataResult<Integer> updateByPrimaryKeySelective(RegisterInfo record,CustomOperateLog log) throws ServiceException;
	
   DataResult<List<RegisterInfoExtend>> selectByCondition(QueryCondition<RegisterInfoExtend> record,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<RegisterInfoExtend> register(RegisterInfoExtend yhjbxxInfo, String confirmPassword, CustomOperateLog log) throws ServiceException;
   DataResult<RegisterInfoExtend> login(String userName,String password,CustomOperateLog log) throws ServiceException;
   
   DataResult<RegisterInfoExtend> loginAdmin(String userName,String password,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> resetPwd(String phone,String password,String confirmPassword,CustomOperateLog log) throws ServiceException;
  
}
