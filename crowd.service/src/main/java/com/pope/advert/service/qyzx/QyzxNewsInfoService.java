package com.pope.advert.service.qyzx;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface QyzxNewsInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


	DataResult<Integer> insertSelective(QyzxNewsInfo record,CustomOperateLog log) throws ServiceException;

	DataResult<QyzxNewsInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeySelective(QyzxNewsInfo record,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeyWithBLOBs(QyzxNewsInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<List<QyzxNewsInfoExtend>> selectDisplayByCondition(QueryCondition<QyzxNewsInfoExtend> condition,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> publishing(QyzxNewsInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> delete(String wid,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
