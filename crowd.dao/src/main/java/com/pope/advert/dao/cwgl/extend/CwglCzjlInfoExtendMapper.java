package com.pope.advert.dao.cwgl.extend;

import java.util.List;

import com.pope.advert.entity.cwgl.CwglCzjlInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;

public interface CwglCzjlInfoExtendMapper {
	List<CwglCzjlInfoExtend> selectByCondition(QueryCondition<CwglCzjlInfoExtend> condition);
	
	List<CwglCzjlInfoExtend> selectDisplayByCondition(QueryCondition<CwglCzjlInfoExtend> condition);
	
}