package com.pope.advert.dao.sjgl;

import com.pope.advert.entity.sjgl.ZbxxInfo;

public interface ZbxxInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ZbxxInfo record);

    int insertSelective(ZbxxInfo record);

    ZbxxInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ZbxxInfo record);

    int updateByPrimaryKeyWithBLOBs(ZbxxInfo record);

    int updateByPrimaryKey(ZbxxInfo record);
}