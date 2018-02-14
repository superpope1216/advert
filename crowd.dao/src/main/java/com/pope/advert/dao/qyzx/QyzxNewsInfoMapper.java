package com.pope.advert.dao.qyzx;

import com.pope.advert.entity.qyzx.QyzxNewsInfo;

public interface QyzxNewsInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(QyzxNewsInfo record);

    int insertSelective(QyzxNewsInfo record);

    QyzxNewsInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(QyzxNewsInfo record);

    int updateByPrimaryKeyWithBLOBs(QyzxNewsInfo record);

    int updateByPrimaryKey(QyzxNewsInfo record);
}