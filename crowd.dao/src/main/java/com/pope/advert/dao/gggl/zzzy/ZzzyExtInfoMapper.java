package com.pope.advert.dao.gggl.zzzy;

import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;

public interface ZzzyExtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(ZzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(ZzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    ZzzyExtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(ZzzyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(ZzzyExtInfo record);
}