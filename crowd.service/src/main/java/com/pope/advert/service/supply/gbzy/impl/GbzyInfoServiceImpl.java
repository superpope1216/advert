package com.pope.advert.service.supply.gbzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.gbzy.GbzyInfoMapper;
import com.pope.advert.dao.gggl.gbzy.extend.GbzyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.PageUtil;

@Service("gbzyInfoService")
public class GbzyInfoServiceImpl extends BaseSupplyInfoService implements GbzyInfoService{

	@Autowired
	private GbzyInfoMapper gbzyInfoMapper;

	@Autowired
	private GbzyInfoExtendMapper gbzyInfoExtendMapper;
	@Autowired
	private SupplyInfoService supplyInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<GbzyInfoExtend>> selectDisplayByCondition(QueryCondition<GbzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzyInfoExtend> datas = gbzyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<GbzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzyInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		this.shSupply(wid, shzt, log);
		GbzyInfo saveGbzy=new GbzyInfo();
		saveGbzy.setWid(wid);
		saveGbzy.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveGbzy, log);
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
