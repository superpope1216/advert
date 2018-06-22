package com.pope.advert.dao.gggl.wlzy;

import com.pope.advert.entity.gggl.wlzy.WlzyInfo;

public interface WlzyInfoMapper {
    /**
     *
     * @mbggenerated 2018-02-22
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-22
     */
    int insert(WlzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-22
     */
    int insertSelective(WlzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-22
     */
    WlzyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-22
     */
    int updateByPrimaryKeySelective(WlzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-22
     */
    int updateByPrimaryKey(WlzyInfo record);
}