package com.pope.advert.dao.yhgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;

public interface CompanyInfoExtendMapper {
  List<CompanyInfoExtend> selectByCondition(QueryCondition<CompanyInfoExtend> records);
}