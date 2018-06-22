package com.pope.advert.service.supply.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.SupplyCondition;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.util.PageUtil;

@Service("dszyInfoService")
public class DszyInfoServiceImpl extends BaseSupplyInfoService implements DszyInfoService {

	@Autowired
	private DszyInfoMapper dszyInfoMapper;
	@Autowired
	private DszyInfoExtendMapper dszyInfoExtendMapper;
	
	@Autowired
	private SupplyInfoService supplyInfoService;
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
	public DataResult<List<DszyInfoExtend>> selectDisplayByCondition(QueryCondition<DszyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<List<DszyInfoExtend>> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyInfoExtend> datas = dszyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		this.shSupply(wid, shzt, log);
		DszyInfo saveDszyInfo=new DszyInfo();
		saveDszyInfo.setWid(wid);
		saveDszyInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveDszyInfo, log);
		supplyInfoService.sendMsg(wid, shzt, log);
		return datas;
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}

	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
	

}
