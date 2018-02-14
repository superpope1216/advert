package com.pope.advert.dao.gggl.bzzy;

import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;

public interface BzzyExtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(BzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(BzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    BzzyExtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(BzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(BzzyExtInfo record);
}