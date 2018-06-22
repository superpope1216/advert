package com.pope.advert.service.yhgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.yhgl.YhglDjxxInfoMapper;
import com.pope.advert.dao.yhgl.extend.YhglDjxxInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.PageUtil;

@Service("yhglDjxxInfoServie")
public class YhglDjxxInfoServiceImpl implements YhglDjxxInfoServie{
	@Autowired
	private YhglDjxxInfoMapper yhglDjxxInfoMapper;
	@Autowired
	private YhglDjxxInfoExtendMapper yhglDjxxInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(yhglDjxxInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(YhglDjxxInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(yhglDjxxInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<YhglDjxxInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(yhglDjxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(YhglDjxxInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(yhglDjxxInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<YhglDjxxInfoExtend>> selectByCondition(QueryCondition<YhglDjxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<YhglDjxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<YhglDjxxInfoExtend> datas = yhglDjxxInfoExtendMapper.selectByCondition(condition);

            DataResult<List<YhglDjxxInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(yhglDjxxInfoExtendMapper.selectByCondition(condition));
        }
	}

	@Override
	public DataResult<Integer> updateByVersion(YhglDjxxInfo yhglDjxxInfo, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(yhglDjxxInfoExtendMapper.updateByVersion(yhglDjxxInfo));
	}

	@Override
	public DataResult<List<YhglDjxxInfoExtend>> selectDisplayByCondition(QueryCondition<YhglDjxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<YhglDjxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<YhglDjxxInfoExtend> datas = yhglDjxxInfoExtendMapper.selectDisplayByCondition(condition);

            DataResult<List<YhglDjxxInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(yhglDjxxInfoExtendMapper.selectDisplayByCondition(condition));
        }
	}
}
