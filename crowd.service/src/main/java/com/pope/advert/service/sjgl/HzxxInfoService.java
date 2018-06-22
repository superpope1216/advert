package com.pope.advert.service.sjgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface HzxxInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


	DataResult<Integer> insertSelective(HzxxInfo record,CustomOperateLog log) throws ServiceException;

	DataResult<HzxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeySelective(HzxxInfo record,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeyWithBLOBs(HzxxInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<List<HzxxInfoExtend>> selectDisplayByCondition(QueryCondition<HzxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
   DataResult<Integer> publishing(HzxxInfo hzxxInfo,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> delete(String wid,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
