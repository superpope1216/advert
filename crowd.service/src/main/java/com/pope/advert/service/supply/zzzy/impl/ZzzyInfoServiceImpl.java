package com.pope.advert.service.supply.zzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.zzzy.ZzzyInfoMapper;
import com.pope.advert.dao.gggl.zzzy.extend.ZzzyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.wisedu.crowd.common.util.PageUtil;

@Service("zzzyInfoService")
public class ZzzyInfoServiceImpl extends BaseSupplyInfoService implements ZzzyInfoService{

	@Autowired
	private ZzzyInfoMapper zzzyInfoMapper;
	
	@Autowired
	private ZzzyInfoExtendMapper zzzyInfoExtendMapper;
	
	@Autowired
	private SupplyInfoService supplyInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<ZzzyInfoExtend>> selectDisplayByCondition(QueryCondition<ZzzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZzzyInfoExtend> datas = zzzyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<ZzzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(zzzyInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		this.shSupply(wid, shzt, log);
		
		ZzzyInfo saveZzzyInfo=new ZzzyInfo();
		saveZzzyInfo.setWid(wid);
		saveZzzyInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveZzzyInfo, log);
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
