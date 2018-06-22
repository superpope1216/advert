package com.pope.advert.service.cwgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.cwgl.CwglDjxxInfoMapper;
import com.pope.advert.dao.cwgl.extend.CwglDjxxInfoExtendMapper;
import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.PageUtil;

@Service("cwglDjxxInfoService")
public class CwglDjxxInfoServiceImpl implements CwglDjxxInfoService{
	@Autowired
	private CwglDjxxInfoMapper cwglDjxxInfoMapper;
	@Autowired
	private CwglDjxxInfoExtendMapper cwglDjxxInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglDjxxInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(CwglDjxxInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglDjxxInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<CwglDjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglDjxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(CwglDjxxInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglDjxxInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<CwglDjxxInfoExtend>> selectByCondition(QueryCondition<CwglDjxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<CwglDjxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<CwglDjxxInfoExtend> datas = cwglDjxxInfoExtendMapper.selectByCondition(condition);

            DataResult<List<CwglDjxxInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(cwglDjxxInfoExtendMapper.selectByCondition(condition));
        }
	}

}
