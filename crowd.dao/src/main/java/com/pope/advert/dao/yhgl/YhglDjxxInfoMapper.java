package com.pope.advert.dao.yhgl;

import com.pope.advert.entity.yhgl.YhglDjxxInfo;

public interface YhglDjxxInfoMapper {
    /**
     *
     * @mbggenerated 2018-04-15
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insert(YhglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insertSelective(YhglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    YhglDjxxInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKeySelective(YhglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKey(YhglDjxxInfo record);
}