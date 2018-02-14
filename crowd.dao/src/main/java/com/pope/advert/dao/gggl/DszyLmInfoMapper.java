package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyLmInfo;

public interface DszyLmInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyLmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyLmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyLmInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyLmInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyLmInfo record);
}