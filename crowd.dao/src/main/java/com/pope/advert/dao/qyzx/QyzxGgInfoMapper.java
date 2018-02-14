package com.pope.advert.dao.qyzx;

import com.pope.advert.entity.qyzx.QyzxGgInfo;

public interface QyzxGgInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(QyzxGgInfo record);

    int insertSelective(QyzxGgInfo record);

    QyzxGgInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(QyzxGgInfo record);

    int updateByPrimaryKeyWithBLOBs(QyzxGgInfo record);

    int updateByPrimaryKey(QyzxGgInfo record);
}