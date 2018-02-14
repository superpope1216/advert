package com.pope.advert.dao.gggl;

import java.util.List;
import java.util.Map;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;

public interface SupplyInfoMapper {

	List<Map<String,Object>> selectByCondition(QueryCondition<SupplyInfo> condition);
}
