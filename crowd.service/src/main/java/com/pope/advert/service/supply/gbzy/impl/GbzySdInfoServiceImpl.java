package com.pope.advert.service.supply.gbzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.gbzy.GbzySdInfoMapper;
import com.pope.advert.dao.gggl.gbzy.extend.GbzySdInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("gbzySdInfoService")
public class GbzySdInfoServiceImpl extends BaseSupplyInfoService implements GbzySdInfoService{
	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;
	@Autowired
	private GbzySdInfoMapper gbzySdInfoMapper;
	
	 @Autowired
	private GbzySdInfoExtendMapper gbzySdInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzySdInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(GbzySdInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzySdInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<GbzySdInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzySdInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(GbzySdInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(gbzySdInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(GbzyInfo gbzyInfo, GbzySdInfo gbzySdInfo, GbzyExtInfo gbzyExtInfo,
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
			gbzySdInfo.setWid(StringUtil.getUuId());
			gbzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		gbzyExtInfo.setGbzyId(wid);
		gbzyInfo.setRegisterId(log.getUserId());
		gbzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		gbzySdInfo.setGbzyBm(wid);
		if(insert){
			gbzyInfoService.insertSelective(gbzyInfo, log);
			this.insertSelective(gbzySdInfo, log);
			gbzyExtInfoService.insertSelective(gbzyExtInfo, log);
		}else{
			gbzyInfoService.updateByPrimaryKeySelective(gbzyInfo, log);
			this.updateByPrimaryKeySelective(gbzySdInfo, log);
			gbzyExtInfoService.updateByPrimaryKeySelective(gbzyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<GbzySdInfoExtend>> selectByCondition(QueryCondition<GbzySdInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		// TODO Auto-generated method stub
		if (condition.getPageInfo() != null) {
			Page<GbzySdInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzySdInfoExtend> datas = gbzySdInfoExtendMapper.selectByCondition(condition);

			DataResult<List<GbzySdInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzySdInfoExtendMapper.selectByCondition(condition));

		}
		
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String gbzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(gbzySdInfoExtendMapper.deleteByGbzyId(gbzyId));
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
	public DataResult<List<GbzySdInfoExtend>> selectDisplayByCondition(QueryCondition<GbzySdInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<GbzySdInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<GbzySdInfoExtend> datas = gbzySdInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<GbzySdInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(gbzySdInfoExtendMapper.selectDisplayByCondition(condition));

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
