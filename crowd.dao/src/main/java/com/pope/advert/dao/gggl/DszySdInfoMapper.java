package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszySdInfo;

public interface DszySdInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszySdInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszySdInfo record);
}