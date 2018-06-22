package com.pope.advert.service.yhgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.CompanyClassifyEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YhhyztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.yhgl.CompanyInfoMapper;
import com.pope.advert.dao.yhgl.extend.CompanyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.YhglDjxxInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("companyInfoService")
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Autowired
	private CompanyInfoMapper companyInfoMapper;
	
	@Autowired
	private CompanyInfoExtendMapper companyInfoExtendMapper;
	
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoServie;
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
		boolean insert=false;
		if(StringUtil.isEmpty(companyInfo.getWid())){
			insert=true;
			companyInfo.setWid(StringUtil.getUuId());
		}
		
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
		if(insert){
			this.insertSelective(companyInfo, log);
		}else{
			this.updateByPrimaryKeySelective(companyInfo, log);
		}
		return DataResult.success(companyInfo);
	}

	@Override
	public DataResult<List<CompanyInfoExtend>> selectByCondition(QueryCondition<CompanyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<CompanyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<CompanyInfoExtend> datas = companyInfoExtendMapper.selectByCondition(condition);

            DataResult<List<CompanyInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(companyInfoExtendMapper.selectByCondition(condition));
        }
	}

	@Override
	public DataResult<Integer> shSupply(String wid, String state,CustomOperateLog log) throws ServiceException {
		
		YhglDjxxInfo saveYhglDjxxInfo=new YhglDjxxInfo();
		
		saveYhglDjxxInfo.setKssj(DateUtil.getCurrentDateStr());
		String endDate=DateUtil.addDate(DateUtil.getCurrentDate(), 30);
		saveYhglDjxxInfo.setJssj(endDate);
		saveYhglDjxxInfo.setWid(StringUtil.getUuId());
		saveYhglDjxxInfo.setYhid(log.getUserId());
		saveYhglDjxxInfo.setDj("1");
		saveYhglDjxxInfo.setZts(20);
		saveYhglDjxxInfo.setSyts(20);
		saveYhglDjxxInfo.setVersion(0);
		long dayCount=DateUtil.getDaysBetween(DateUtil.getCurrentDateStr(), saveYhglDjxxInfo.getJssj());
		if(dayCount>=90) {
			saveYhglDjxxInfo.setYhzt(YhhyztEnum.ZC.getCode());
		}else {
			saveYhglDjxxInfo.setYhzt(YhhyztEnum.JJGQ.getCode());
		}
		yhglDjxxInfoServie.insertSelective(saveYhglDjxxInfo, log);
		
		CompanyInfo saveCompanyInfo=new CompanyInfo();
		saveCompanyInfo.setWid(wid);
		saveCompanyInfo.setSupplyShzt(state);
		return this.updateByPrimaryKeySelective(saveCompanyInfo, log);
	}

}
