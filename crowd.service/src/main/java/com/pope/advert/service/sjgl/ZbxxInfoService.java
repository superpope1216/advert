package com.pope.advert.service.sjgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.ZbxxInfo;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface ZbxxInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


	DataResult<Integer> insertSelective(ZbxxInfo record,CustomOperateLog log) throws ServiceException;

	DataResult<ZbxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeySelective(ZbxxInfo record,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeyWithBLOBs(ZbxxInfo record,CustomOperateLog log) throws ServiceException;
    DataResult<List<ZbxxInfoExtend>> selectDisplayByCondition(QueryCondition<ZbxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> publishing(ZbxxInfo hzxxInfo,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> delete(String wid,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
