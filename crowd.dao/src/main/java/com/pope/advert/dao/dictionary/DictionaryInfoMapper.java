package com.pope.advert.dao.dictionary;

import com.pope.advert.entity.dictionary.DictionaryInfo;

public interface DictionaryInfoMapper {
    /**
     *
     * @mbggenerated 2017-11-17
     */
    int deleteByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-11-17
     */
    int insert(DictionaryInfo record);

    /**
     *
     * @mbggenerated 2017-11-17
     */
    int insertSelective(DictionaryInfo record);

    /**
     *
     * @mbggenerated 2017-11-17
     */
    DictionaryInfo selectByPrimaryKey(String wid);

    /**
     *
     * @mbggenerated 2017-11-17
     */
    int updateByPrimaryKeySelective(DictionaryInfo record);

    /**
     *
     * @mbggenerated 2017-11-17
     */
    int updateByPrimaryKey(DictionaryInfo record);
}