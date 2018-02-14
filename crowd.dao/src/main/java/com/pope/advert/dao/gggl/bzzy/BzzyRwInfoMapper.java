package com.pope.advert.dao.gggl.bzzy;

import com.pope.advert.entity.gggl.bzzy.BzzyRwInfo;

public interface BzzyRwInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(BzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(BzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    BzzyRwInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(BzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(BzzyRwInfo record);
}