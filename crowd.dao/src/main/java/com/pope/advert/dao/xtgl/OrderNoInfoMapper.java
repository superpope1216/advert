package com.pope.advert.dao.xtgl;

import com.pope.advert.entity.xtgl.OrderNoInfo;

public interface OrderNoInfoMapper {
    /**
     *
     * @mbggenerated 2018-05-30
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-05-30
     */
    int insert(OrderNoInfo record);

    /**
     *
     * @mbggenerated 2018-05-30
     */
    int insertSelective(OrderNoInfo record);

    /**
     *
     * @mbggenerated 2018-05-30
     */
    OrderNoInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-05-30
     */
    int updateByPrimaryKeySelective(OrderNoInfo record);

    /**
     *
     * @mbggenerated 2018-05-30
     */
    int updateByPrimaryKey(OrderNoInfo record);
}