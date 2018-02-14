package com.pope.advert.service.supply;

import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface DszySdInfoService {
	 /**
    *
    * @mbggenerated 2017-12-17
    */
	 DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
	 DataResult<Integer> insertSelective(DszySdInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
	 DataResult<DszySdInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2017-12-17
    */
   DataResult<Integer> updateByPrimaryKeySelective(DszySdInfo record,CustomOperateLog log) throws ServiceException;
   
   /**
	 * 发布电视资源时段信息
	 * @param dszyInfo
	 * @param dszySdInfo
	 * @param log
	 * @return
	 * @throws ServiceException
	 */
	public DataResult<Integer> publishing(DszyInfo dszyInfo,DszySdInfo dszySdInfo,DszyExtInfo dszyExtInfo,CustomOperateLog log) throws ServiceException;
}
