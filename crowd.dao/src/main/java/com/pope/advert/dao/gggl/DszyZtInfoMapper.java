package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyZtInfo;

public interface DszyZtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyZtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyZtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyZtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyZtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyZtInfo record);
}