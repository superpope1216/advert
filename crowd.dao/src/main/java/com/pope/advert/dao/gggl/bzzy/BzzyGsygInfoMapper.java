package com.pope.advert.dao.gggl.bzzy;

import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;

public interface BzzyGsygInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-24
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insert(BzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int insertSelective(BzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    BzzyGsygInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKeySelective(BzzyGsygInfo record);

    /**
     *
     * @mbggenerated 2017-12-24
     */
    int updateByPrimaryKey(BzzyGsygInfo record);
}