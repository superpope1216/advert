package com.pope.advert.dao.gggl.bzzy;

import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;

public interface BzzyJyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(BzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(BzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    BzzyJyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(BzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(BzzyJyInfo record);
}