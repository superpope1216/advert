package com.pope.advert.dao.yhgl.extend;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.yhgl.CompanyZzInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;

public interface CompanyZzInfoExtendMapper {
  List<CompanyZzInfoExtend> selectDisplayByCondition(QueryCondition<CompanyZzInfoExtend> condition);
  
  Integer updateByCondition(CompanyZzInfo companyZzInfo);
}