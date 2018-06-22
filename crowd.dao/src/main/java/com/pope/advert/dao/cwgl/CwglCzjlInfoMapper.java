package com.pope.advert.dao.cwgl;

import com.pope.advert.entity.cwgl.CwglCzjlInfo;

public interface CwglCzjlInfoMapper {
    /**
     *
     * @mbggenerated 2018-04-15
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insert(CwglCzjlInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insertSelective(CwglCzjlInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    CwglCzjlInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKeySelective(CwglCzjlInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKey(CwglCzjlInfo record);
}