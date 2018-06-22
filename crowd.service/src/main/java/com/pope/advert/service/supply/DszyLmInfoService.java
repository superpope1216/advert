package com.pope.advert.service.supply;

import java.util.List;

import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;

public interface DszyLmInfoService {
	/**
	 *
	 * @mbggenerated 2017-12-21
	 */
	DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException;

	/**
	 *
	 * @mbggenerated 2017-12-21
	 */
	DataResult<Integer> insertSelective(DszyLmInfo record, CustomOperateLog log) throws ServiceException;

	/**
	 *
	 * @mbggenerated 2017-12-21
	 */
	DataResult<DszyLmInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException;

	/**
	 *
	 * @mbggenerated 2017-12-21
	 */
	DataResult<Integer> updateByPrimaryKeySelective(DszyLmInfo record, CustomOperateLog log) throws ServiceException;

	DataResult<Integer> publishing(DszyInfo dszyInfo, DszyLmInfo dszyLmInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException;

	DataResult<List<DszyLmInfoExtend>> selectDisplayByCondition(QueryCondition<DszyLmInfoExtend> condition,
			CustomOperateLog log) throws ServiceException;

	DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException;

	DataResult<Integer> delete(String dszyId, CustomOperateLog log) throws ServiceException;

}
