package com.pope.advert.service.supply.wlzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.wlzy.WlzyInfo;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface WlzyInfoService {
	 /**
    *
    * @mbggenerated 2018-02-22
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


   /**
    *
    * @mbggenerated 2018-02-22
    */
   DataResult<Integer> insertSelective(WlzyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-22
    */
   DataResult<WlzyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-22
    */
   DataResult<Integer> updateByPrimaryKeySelective(WlzyInfo record,CustomOperateLog log) throws ServiceException;
   
   
   DataResult<Integer> publishing(WlzyInfo record,CustomOperateLog log) throws ServiceException;
   DataResult<List<WlzyInfoExtend>> selectDisplayByCondition(QueryCondition<WlzyInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> delete( String wlzyId,CustomOperateLog log) throws ServiceException;
   
   DataResult<Integer> sh( String wid,String shzt,CustomOperateLog log) throws ServiceException;

}
