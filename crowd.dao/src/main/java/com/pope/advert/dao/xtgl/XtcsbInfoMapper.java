package com.pope.advert.dao.xtgl;

import com.pope.advert.entity.xtgl.XtcsbInfo;

public interface XtcsbInfoMapper {
    /**
     *
     * @mbggenerated 2018-01-16
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insert(XtcsbInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int insertSelective(XtcsbInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    XtcsbInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKeySelective(XtcsbInfo record);

    /**
     *
     * @mbggenerated 2018-01-16
     */
    int updateByPrimaryKey(XtcsbInfo record);
}