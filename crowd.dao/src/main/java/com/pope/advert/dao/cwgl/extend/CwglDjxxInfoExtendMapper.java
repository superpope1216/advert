package com.pope.advert.dao.cwgl.extend;

import java.util.List;

import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;

public interface CwglDjxxInfoExtendMapper {
	List<CwglDjxxInfoExtend> selectByCondition(QueryCondition<CwglDjxxInfoExtend> condition);
}