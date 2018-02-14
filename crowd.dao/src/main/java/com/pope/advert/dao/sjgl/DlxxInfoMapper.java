package com.pope.advert.dao.sjgl;

import com.pope.advert.entity.sjgl.DlxxInfo;

public interface DlxxInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(DlxxInfo record);

    int insertSelective(DlxxInfo record);

    DlxxInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(DlxxInfo record);

    int updateByPrimaryKeyWithBLOBs(DlxxInfo record);

    int updateByPrimaryKey(DlxxInfo record);
}