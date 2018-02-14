package com.pope.advert.dao.gggl.zzzy;

import com.pope.advert.entity.gggl.zzzy.ZzzyRwInfo;

public interface ZzzyRwInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(ZzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(ZzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    ZzzyRwInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(ZzzyRwInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(ZzzyRwInfo record);
}