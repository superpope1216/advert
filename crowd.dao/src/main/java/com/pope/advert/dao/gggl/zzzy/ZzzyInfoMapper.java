package com.pope.advert.dao.gggl.zzzy;

import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;

public interface ZzzyInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(ZzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(ZzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    ZzzyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(ZzzyInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(ZzzyInfo record);
}