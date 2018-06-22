package com.pope.advert.dao.gggl;

import java.util.List;

import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;

public interface DszyExtInfoMapper {
    /**
     *
     * @mbggenerated 2017-12-21
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insert(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int insertSelective(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    DszyExtInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKeySelective(DszyExtInfo record);

    /**
     *
     * @mbggenerated 2017-12-21
     */
    int updateByPrimaryKey(DszyExtInfo record);
    
    
}