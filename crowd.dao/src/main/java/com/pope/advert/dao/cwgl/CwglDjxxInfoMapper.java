package com.pope.advert.dao.cwgl;

import com.pope.advert.entity.cwgl.CwglDjxxInfo;

public interface CwglDjxxInfoMapper {
    /**
     *
     * @mbggenerated 2018-04-15
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insert(CwglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int insertSelective(CwglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    CwglDjxxInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKeySelective(CwglDjxxInfo record);

    /**
     *
     * @mbggenerated 2018-04-15
     */
    int updateByPrimaryKey(CwglDjxxInfo record);
}