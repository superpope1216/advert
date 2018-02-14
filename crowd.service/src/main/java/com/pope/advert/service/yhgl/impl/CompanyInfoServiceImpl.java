package com.pope.advert.service.yhgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.yhgl.CompanyInfoMapper;
import com.pope.advert.dao.yhgl.extend.CompanyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.code.CompanyClassifyEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("companyInfoService")
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Autowired
	private CompanyInfoMapper companyInfoMapper;
	
	@Autowired
	private CompanyInfoExtendMapper companyInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(CompanyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<CompanyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(CompanyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(companyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<CompanyInfo> saveCompanyInfo(CompanyInfo companyInfo, CustomOperateLog log)
			throws ServiceException {
		if(StringUtil.isEmpty(companyInfo.getName())){
			throw new ServiceException("公司名称不能为空！");
		}
		if(StringUtil.isEmpty(companyInfo.getArea())){
			throw new ServiceException("公司地址不能为空！");
		}
		if(StringUtil.isEmpty(companyInfo.getAddr())){
			throw new ServiceException("经营地址不能为空！");
		}
		if(StringUtil.isEmpty(companyInfo.getLxr())){
			throw new ServiceException("联系人不能为空！");
		}
		if(StringUtil.isEmpty(companyInfo.getGddh())){
			throw new ServiceException("固定电话不能为空！");
		}
		companyInfo.setWid(StringUtil.getUuId());
		companyInfo.setRegisterId(log.getUserId());
		if(CompanyClassifyEnum.BUY.getCode().equals(companyInfo.getFlag())){
			companyInfo.setBuyShzt(ShztEnum.DSH.getCode());
		}else if(CompanyClassifyEnum.SUPPLY.getCode().equals(companyInfo.getFlag())){
			companyInfo.setSupplyShzt(ShztEnum.DSH.getCode());
		}else if(CompanyClassifyEnum.BOTH.getCode().equals(companyInfo.getFlag())){
			companyInfo.setSupplyShzt(ShztEnum.DSH.getCode());
			companyInfo.setBuyShzt(ShztEnum.DSH.getCode());
		}
		
		companyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
		companyInfo.setCjip(log.getCustomIp());
		this.insertSelective(companyInfo, log);
		return DataResult.success(companyInfo);
	}

	@Override
	public DataResult<List<CompanyInfoExtend>> selectByCondition(QueryCondition<CompanyInfoExtend> records,
			CustomOperateLog log) throws ServiceException {
		return DataResult.success(companyInfoExtendMapper.selectByCondition(records));
	}

}
