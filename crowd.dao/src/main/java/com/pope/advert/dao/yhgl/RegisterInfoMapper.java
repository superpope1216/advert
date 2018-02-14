package com.pope.advert.dao.yhgl;

import com.pope.advert.entity.yhgl.RegisterInfo;

public interface RegisterInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-16
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-16
     */
    int insert(RegisterInfo record);

    /**
     *
     * @mbggenerated 2017-12-16
     */
    int insertSelective(RegisterInfo record);

    /**
     *
     * @mbggenerated 2017-12-16
     */
    RegisterInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-16
     */
    int updateByPrimaryKeySelective(RegisterInfo record);

    /**
     *
     * @mbggenerated 2017-12-16
     */
    int updateByPrimaryKey(RegisterInfo record);
}