package com.pope.advert.dao.xtgl;

import com.pope.advert.entity.xtgl.FjxxInfo;

public interface FjxxInfoMapper {
    /**
     *
     * @mbggenerated 2018-01-16
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insert(FjxxInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insertSelective(FjxxInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    FjxxInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKeySelective(FjxxInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKey(FjxxInfo record);
}