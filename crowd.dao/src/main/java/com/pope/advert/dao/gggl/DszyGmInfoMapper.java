package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyGmInfo;

public interface DszyGmInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyGmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyGmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyGmInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyGmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyGmInfo record);
}