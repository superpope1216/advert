package com.pope.advert.dao.gggl;

import com.pope.advert.entity.gggl.DszyTbInfo;

public interface DszyTbInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyTbInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyTbInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyTbInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyTbInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyTbInfo record);
}