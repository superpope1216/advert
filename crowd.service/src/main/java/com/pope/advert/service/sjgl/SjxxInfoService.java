package com.pope.advert.service.sjgl;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.service.dto.DataResult;

public interface SjxxInfoService {
	DataResult<List<SjxxInfo>> selectDisplayByCondition(QueryCondition<SjxxInfo> condition,CustomOperateLog log) throws ServiceException;
}
