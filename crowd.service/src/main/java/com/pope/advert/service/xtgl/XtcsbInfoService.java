package com.pope.advert.service.xtgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface XtcsbInfoService {
	 DataResult<List<XtcsbInfoExtend>> selectByCondition(XtcsbInfoExtend record)throws ServiceException;
}
