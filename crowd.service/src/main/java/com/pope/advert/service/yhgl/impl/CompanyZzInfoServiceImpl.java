package com.pope.advert.service.yhgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.yhgl.CompanyZzInfoMapper;
import com.pope.advert.dao.yhgl.extend.CompanyZzInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.CompanyZzInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyZzInfoService;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("companyZzInfoService")
@Transactional
public class CompanyZzInfoServiceImpl implements CompanyZzInfoService{

	@Autowired
	private CompanyZzInfoMapper companyZzInfoMapper;
	@Autowired
	private CompanyZzInfoExtendMapper companyZzInfoExtendMapper;
	@Override
	public DataResult<Integer> insertSelective(CompanyZzInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyZzInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<CompanyZzInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyZzInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(CompanyZzInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(companyZzInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<CompanyZzInfoExtend>> selectDisplayByCondition(QueryCondition<CompanyZzInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<CompanyZzInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<CompanyZzInfoExtend> datas = companyZzInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<CompanyZzInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(companyZzInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> save(CompanyZzInfo companyZzInfo, CustomOperateLog log) throws ServiceException {
		if(StringUtil.isEmpty(companyZzInfo.getZzlx())){
			throw new ServiceException("资质类型不能为空，请重新选择！");
		}
		if(StringUtil.isEmpty(companyZzInfo.getZzlog())){
			throw new ServiceException("资质证书图片不能为空，请重新上传！");
		}
		companyZzInfo.setUpdateIp(log.getCustomIp());
		companyZzInfo.setUpdateTime(DateUtil.getCurrentDateTimeStr());
		companyZzInfo.setRegisterId(log.getUserId());
		companyZzInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(StringUtil.isEmpty(companyZzInfo.getWid())){
			companyZzInfo.setWid(StringUtil.getUuId());
			companyZzInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			companyZzInfo.setCjip(log.getCustomIp());
			companyZzInfo.setShzt(ShztEnum.DSH.getCode());
			this.insertSelective(companyZzInfo, log);
		}else{
			if(!companyZzInfo.getRegisterId().equals(log.getUserId())){
				throw new ServiceException("该资质信息不是您自身的，请重新确认！");
			}
			this.updateByPrimaryKeySelective(companyZzInfo, log);
		}
		
		return DataResult.success(1);
		
	}

	@Override
	public DataResult<Integer> updateByCondition(CompanyZzInfo companyZzInfo, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(companyZzInfoExtendMapper.updateByCondition(companyZzInfo));
	}

}
