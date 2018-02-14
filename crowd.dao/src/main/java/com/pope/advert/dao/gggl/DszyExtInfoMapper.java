package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyExtInfo;

public interface DszyExtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyExtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyExtInfo record);
}