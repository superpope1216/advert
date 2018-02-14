package com.pope.advert.dao.gggl.gbzy;

import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;

public interface GbzySdInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(GbzySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(GbzySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    GbzySdInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(GbzySdInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(GbzySdInfo record);
}