package com.pope.advert.service.xtgl;

import java.util.List;

import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.exception.ServiceException;

public interface XtcsbInfoService {
	 DataResult<List<XtcsbInfoExtend>> selectByCondition(XtcsbInfoExtend record)throws ServiceException;
}
