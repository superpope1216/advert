package com.pope.advert.dao.gggl.hwzy;

import com.pope.advert.entity.gggl.hwzy.HwzyInfo;

public interface HwzyInfoMapper {
    /**
     *
     * @mbggenerated 2018-02-28
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-28
     */
    int insert(HwzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-28
     */
    int insertSelective(HwzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-28
     */
    HwzyInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-02-28
     */
    int updateByPrimaryKeySelective(HwzyInfo record);

    /**
     *
     * @mbggenerated 2018-02-28
     */
    int updateByPrimaryKey(HwzyInfo record);
}