package com.pope.advert.dao.gggl.bzzy;

import com.pope.advert.entity.gggl.bzzy.BzzyInfo;

public interface BzzyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(BzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(BzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    BzzyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(BzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(BzzyInfo record);
}