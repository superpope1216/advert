package com.pope.advert.dao.gggl.gbzy;

import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;

public interface GbzyQtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(GbzyQtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(GbzyQtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    GbzyQtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(GbzyQtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(GbzyQtInfo record);
}