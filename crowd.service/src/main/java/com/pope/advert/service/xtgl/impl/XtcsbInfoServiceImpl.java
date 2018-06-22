package com.pope.advert.service.xtgl.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.xtgl.extend.XtcsbInfoExtendMapper;
import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.XtcsbInfoService;

@Service("xtcsbInfoService")
public class XtcsbInfoServiceImpl implements XtcsbInfoService{

	@Autowired
	private XtcsbInfoExtendMapper xtcsbInfoExtendMapper;
	@Override
	public DataResult<List<XtcsbInfoExtend>> selectByCondition(XtcsbInfoExtend record) throws ServiceException {
		return DataResult.success(xtcsbInfoExtendMapper.selectByCondition(record));
	}

}
