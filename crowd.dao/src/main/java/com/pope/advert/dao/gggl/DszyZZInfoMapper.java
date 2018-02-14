package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyZzInfo;

public interface DszyZZInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyZzInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyZzInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyZzInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyZzInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyZzInfo record);
}