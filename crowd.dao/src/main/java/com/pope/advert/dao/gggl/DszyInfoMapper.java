package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyInfo;

public interface DszyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-17
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-17
     */
    int insert(DszyInfo record);

    /**
     *
     * @mbggenerated 2017-12-17
     */
    int insertSelective(DszyInfo record);

    /**
     *
     * @mbggenerated 2017-12-17
     */
    DszyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-17
     */
    int updateByPrimaryKeySelective(DszyInfo record);

    /**
     *
     * @mbggenerated 2017-12-17
     */
    int updateByPrimaryKey(DszyInfo record);
}