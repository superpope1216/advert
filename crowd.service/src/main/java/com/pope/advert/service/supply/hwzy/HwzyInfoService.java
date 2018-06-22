package com.pope.advert.service.supply.hwzy;

import java.awt.geom.CubicCurve2D;
import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.hwzy.HwzyInfo;
import com.pope.advert.entity.gggl.hwzy.extend.HwzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.ZbxxInfo;
import com.pope.advert.service.dto.DataResult;

public interface HwzyInfoService {
	 /**
    *
    * @mbggenerated 2018-02-28
    */
   DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


   /**
    *
    * @mbggenerated 2018-02-28
    */
   DataResult<Integer> insertSelective(HwzyInfo record,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-28
    */
   DataResult<HwzyInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

   /**
    *
    * @mbggenerated 2018-02-28
    */
   DataResult<Integer> updateByPrimaryKeySelective(HwzyInfo record,CustomOperateLog log) throws ServiceException;
   
   
	DataResult<Integer> publishing(HwzyInfo hwzyInfo,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<HwzyInfoExtend>> selectDisplayByCondition(QueryCondition<HwzyInfoExtend> condition,CustomOperateLog log) throws ServiceException;;
	DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
