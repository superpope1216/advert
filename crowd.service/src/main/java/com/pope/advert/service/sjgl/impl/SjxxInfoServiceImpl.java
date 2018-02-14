package com.pope.advert.service.sjgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.sjgl.SjxxInfoMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.SjxxInfoService;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.PageUtil;

@Service("sjxxInfoService")
public class SjxxInfoServiceImpl implements SjxxInfoService{
	@Autowired
	private SjxxInfoMapper sjxxInfoMapper;
	@Override
	public DataResult<List<SjxxInfo>> selectDisplayByCondition(QueryCondition<SjxxInfo> condition, CustomOperateLog log)
			throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<SjxxInfo> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<SjxxInfo> datas = sjxxInfoMapper.selectDisplayByCondition(condition);

			DataResult<List<SjxxInfo>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(sjxxInfoMapper.selectDisplayByCondition(condition));

		}
	}

}
