package com.pope.advert.dao.yhgl;

import com.pope.advert.entity.yhgl.CompanyZzInfo;

public interface CompanyZzInfoMapper {
    /**
     *
     * @mbggenerated 2018-01-16
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insert(CompanyZzInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insertSelective(CompanyZzInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    CompanyZzInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKeySelective(CompanyZzInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKey(CompanyZzInfo record);
}