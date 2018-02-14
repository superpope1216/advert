package com.pope.advert.dao.sjgl;

import com.pope.advert.entity.sjgl.HzxxInfo;

public interface HzxxInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(HzxxInfo record);

    int insertSelective(HzxxInfo record);

    HzxxInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(HzxxInfo record);

    int updateByPrimaryKeyWithBLOBs(HzxxInfo record);

    int updateByPrimaryKey(HzxxInfo record);
}