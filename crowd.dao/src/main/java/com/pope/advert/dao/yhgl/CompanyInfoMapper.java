package com.pope.advert.dao.yhgl;

import com.pope.advert.entity.yhgl.CompanyInfo;

public interface CompanyInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}