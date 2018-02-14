package com.pope.advert.dao.gggl.gbzy;

import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;

public interface GbzyExtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(GbzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(GbzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    GbzyExtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(GbzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(GbzyExtInfo record);
}