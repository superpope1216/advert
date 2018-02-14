package com.pope.advert.dao.gggl.xmtzy;

import com.pope.advert.entity.gggl.xmtzy.XmtzyInfo;

public interface XmtzyInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(XmtzyInfo record);

    int insertSelective(XmtzyInfo record);

    XmtzyInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(XmtzyInfo record);

    int updateByPrimaryKey(XmtzyInfo record);
}