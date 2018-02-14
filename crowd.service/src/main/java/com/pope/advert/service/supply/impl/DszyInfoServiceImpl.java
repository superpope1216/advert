package com.pope.advert.service.supply.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.gggl.DszyInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.SupplyCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.PageUtil;

@Service("dszyInfoService")
public class DszyInfoServiceImpl implements DszyInfoService {

	@Autowired
	private DszyInfoMapper dszyInfoMapper;
	@Autowired
	private DszyInfoExtendMapper dszyInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<Map<String, Object>>> selectDisplayViewByCondition(String condition, String registerId,
			CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyInfoExtendMapper.selectDisplayViewByCondition(condition, registerId));
	}

	@Override
	public DataResult<List<Map<String, Object>>> selectDisplayByCondtion(QueryCondition<SupplyCondition> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<List<Map<String, Object>>> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<Map<String,Object>> datas = dszyInfoExtendMapper.selectDisplayByCondtion(condition);

			DataResult<List<Map<String,Object>>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyInfoExtendMapper.selectDisplayByCondtion(condition));

		}
	}
	

}
