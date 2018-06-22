package com.pope.advert.service.supply.gbzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.gbzy.GbzyQtInfoMapper;
import com.pope.advert.dao.gggl.gbzy.extend.GbzyQtInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("gbzyQtInfoService")
public class GbzyQtInfoServiceImpl extends BaseSupplyInfoService implements GbzyQtInfoService{

	@Autowired
	private GbzyQtInfoMapper gbzyQtInfoMapper;
	
	@Autowired
	private GbzyQtInfoExtendMapper gbzyQtInfoExtendMapper;
	
	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyQtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzyQtInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyQtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzyQtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyQtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzyQtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzyQtInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(GbzyInfo gbzyInfo, GbzyQtInfo gbzyQtInfo, GbzyExtInfo gbzyExtInfo,
			CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=gbzyInfo.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			wid=StringUtil.getUuId();
			gbzyInfo.setWid(wid);
			gbzyInfo.setShzt(ShztEnum.DSH.getCode());
			gbzyInfo.setCjip(log.getCustomIp());
			gbzyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			gbzyInfo.setRegisterId(log.getUserId());
			gbzyQtInfo.setWid(StringUtil.getUuId());
			gbzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		gbzyExtInfo.setGbzyId(wid);
		gbzyInfo.setRegisterId(log.getUserId());
		gbzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		gbzyQtInfo.setGbzyBm(wid);
		if(insert){
			gbzyInfoService.insertSelective(gbzyInfo, log);
			this.insertSelective(gbzyQtInfo, log);
			gbzyExtInfoService.insertSelective(gbzyExtInfo, log);
		}else{
			gbzyInfoService.updateByPrimaryKeySelective(gbzyInfo, log);
			this.updateByPrimaryKeySelective(gbzyQtInfo, log);
			gbzyExtInfoService.updateByPrimaryKeySelective(gbzyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<GbzyQtInfoExtend>> selectByCondition(QueryCondition<GbzyQtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzyQtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzyQtInfoExtend> datas = gbzyQtInfoExtendMapper.selectByCondition(condition);

			DataResult<List<GbzyQtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzyQtInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String gbzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzyQtInfoExtendMapper.deleteByGbzyId(gbzyId));
	}

	@Override
	public DataResult<Integer> delete(String gbzyId, CustomOperateLog log) throws ServiceException {
		gbzyInfoService.deleteByPrimaryKey(gbzyId, log);
		this.deleteByGbzyId(gbzyId, log);
		gbzyExtInfoService.deleteByGbzyId(gbzyId, log);
		this.deleteSupply(gbzyId, log);
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<GbzyQtInfoExtend>> selectDisplayByCondition(QueryCondition<GbzyQtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzyQtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzyQtInfoExtend> datas = gbzyQtInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<GbzyQtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzyQtInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return gbzyInfoService.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}

	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return gbzyInfoService.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
}
