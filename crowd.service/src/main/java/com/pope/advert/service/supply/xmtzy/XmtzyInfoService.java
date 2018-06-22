package com.pope.advert.service.supply.xmtzy;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
import com.pope.advert.entity.gggl.xmtzy.XmtzyInfo;
import com.pope.advert.entity.gggl.xmtzy.extend.XmtzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface XmtzyInfoService {
	DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException;

	DataResult<Integer> insertSelective(XmtzyInfo record, CustomOperateLog log) throws ServiceException;

	DataResult<XmtzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException;

	DataResult<Integer> updateByPrimaryKeySelective(XmtzyInfo record, CustomOperateLog log) throws ServiceException;

	DataResult<Integer> publishing(XmtzyInfo record,CustomOperateLog log) throws ServiceException;
	
	DataResult<List<XmtzyInfoExtend>> selectDisplayByCondition(QueryCondition<XmtzyInfoExtend> condition,CustomOperateLog log) throws ServiceException;
	
	DataResult<Integer> delete(String xmtzyId, CustomOperateLog log);
	
	DataResult<Integer> sh(String wid,String shzt,CustomOperateLog log);
}
