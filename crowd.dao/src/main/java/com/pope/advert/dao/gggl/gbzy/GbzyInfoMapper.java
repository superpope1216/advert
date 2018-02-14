package com.pope.advert.dao.gggl.gbzy;

import com.pope.advert.entity.gggl.gbzy.GbzyInfo;

public interface GbzyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(GbzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(GbzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    GbzyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(GbzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(GbzyInfo record);
}