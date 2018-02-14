package com.pope.advert.dao.sjgl;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;

public interface SjxxInfoMapper {
	List<SjxxInfo> selectDisplayByCondition(QueryCondition<SjxxInfo> condition);
}
