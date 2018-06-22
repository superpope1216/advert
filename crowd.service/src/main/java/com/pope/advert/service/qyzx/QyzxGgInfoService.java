package com.pope.advert.service.qyzx;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.QyzxGgInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface QyzxGgInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;


	DataResult<Integer> insertSelective(QyzxGgInfo record,CustomOperateLog log) throws ServiceException;

	DataResult<QyzxGgInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeySelective(QyzxGgInfo record,CustomOperateLog log) throws ServiceException;

    DataResult<Integer> updateByPrimaryKeyWithBLOBs(QyzxGgInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<List<QyzxGgInfoExtend>> selectDisplayByCondition(QueryCondition<QyzxGgInfoExtend> condition,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> publishing(QyzxGgInfo record,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> delete(String wid,CustomOperateLog log) throws ServiceException;
    
    DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log) throws ServiceException;
}
