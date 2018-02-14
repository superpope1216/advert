package com.pope.advert.dao.gggl.zzzy;

import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;

public interface ZzzyGsygInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(ZzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(ZzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    ZzzyGsygInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(ZzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(ZzzyGsygInfo record);
}