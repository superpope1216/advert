package com.pope.advert.service.sjgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface DlxxInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


	DataResult<Integer> insertSelective(DlxxInfo record,CustomOperateLog log) throws ServiceException;

	DataResult<DlxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeySelective(DlxxInfo record,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeyWithBLOBs(DlxxInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<List<DlxxInfoExtend>> selectDisplayByCondition(QueryCondition<DlxxInfoExtend> condition,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> publishing(DlxxInfo dlxxInfo,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> delete(String wid,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
