package com.pope.advert.dao.yhgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;

public interface RegisterInfoExtendMapper {
    List<RegisterInfoExtend> selectByCondition(QueryCondition<RegisterInfoExtend> record);
	
}