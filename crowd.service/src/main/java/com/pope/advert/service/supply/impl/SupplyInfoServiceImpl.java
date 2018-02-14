package com.pope.advert.service.supply.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.gggl.SupplyInfoMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.PageUtil;

@Service("supplyInfoService")
public class SupplyInfoServiceImpl implements SupplyInfoService{

	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	@Override
	public DataResult<List<Map<String, Object>>> selectByCondition(QueryCondition<SupplyInfo> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<List<Map<String, Object>>> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<Map<String,Object>> datas = supplyInfoMapper.selectByCondition(condition);

			DataResult<List<Map<String,Object>>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(supplyInfoMapper.selectByCondition(condition));

		}
	}

}
