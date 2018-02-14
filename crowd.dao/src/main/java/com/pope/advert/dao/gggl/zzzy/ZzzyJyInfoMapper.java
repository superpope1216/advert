package com.pope.advert.dao.gggl.zzzy;

import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;

public interface ZzzyJyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(ZzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(ZzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    ZzzyJyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(ZzzyJyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(ZzzyJyInfo record);
}