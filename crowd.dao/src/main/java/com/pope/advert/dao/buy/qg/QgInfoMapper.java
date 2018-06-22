package com.pope.advert.dao.buy.qg;

import com.pope.advert.entity.buy.qg.QgInfo;

public interface QgInfoMapper {
    /**
     *
     * @mbggenerated 2018-02-25
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-25
     */
    int insert(QgInfo record);

    /**
     *
     * @mbggenerated 2018-02-25
     */
    int insertSelective(QgInfo record);

    /**
     *
     * @mbggenerated 2018-02-25
     */
    QgInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-25
     */
    int updateByPrimaryKeySelective(QgInfo record);

    /**
     *
     * @mbggenerated 2018-02-25
     */
    int updateByPrimaryKey(QgInfo record);
}