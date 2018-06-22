package com.pope.advert.service.supply.zzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.gbzy.GbzyQtInfoMapper;
import com.pope.advert.dao.gggl.zzzy.ZzzyGsygInfoMapper;
import com.pope.advert.dao.gggl.zzzy.extend.ZzzyGsygInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyGsygInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zzzyGsygInfoService")
public class ZzzyGsygInfoServiceImpl extends BaseSupplyInfoService implements ZzzyGsygInfoService{
	@Autowired
	private ZzzyGsygInfoMapper zzzyGsygInfoMapper;
	@Autowired
	private ZzzyGsygInfoExtendMapper zzzyGsygInfoExtendMapper;
	@Autowired
	private ZzzyInfoService zzzyInfoService;
	@Autowired
	private ZzzyExtInfoService zzzyExtInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyGsygInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyGsygInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyGsygInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyGsygInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyGsygInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyGsygInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyGsygInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(ZzzyInfo zzzyInfo, ZzzyGsygInfo zzzyGsygInfo, ZzzyExtInfo zzzyExtInfo,
			CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=zzzyInfo.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			wid=StringUtil.getUuId();
			zzzyInfo.setWid(wid);
			zzzyInfo.setShzt(ShztEnum.DSH.getCode());
			zzzyInfo.setCjip(log.getCustomIp());
			zzzyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			zzzyInfo.setRegisterId(log.getUserId());
			zzzyGsygInfo.setWid(StringUtil.getUuId());
			zzzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		zzzyExtInfo.setDszyId(wid);
		zzzyInfo.setRegisterId(log.getUserId());
		zzzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		zzzyGsygInfo.setZzzyId(wid);
		if(insert){
			zzzyInfoService.insertSelective(zzzyInfo, log);
			this.insertSelective(zzzyGsygInfo, log);
			zzzyExtInfoService.insertSelective(zzzyExtInfo, log);
		}else{
			zzzyInfoService.updateByPrimaryKeySelective(zzzyInfo, log);
			this.updateByPrimaryKeySelective(zzzyGsygInfo, log);
			zzzyExtInfoService.updateByPrimaryKeySelective(zzzyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<ZzzyGsygInfoExtend>> selectByCondition(QueryCondition<ZzzyGsygInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyGsygInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZzzyGsygInfoExtend> datas = zzzyGsygInfoExtendMapper.selectByCondition(condition);

			DataResult<List<ZzzyGsygInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(zzzyGsygInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String zzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyGsygInfoExtendMapper.deleteByZzzyId(zzzyId));
	}

	@Override
	public DataResult<Integer> delete(String zzzyId, CustomOperateLog log) throws ServiceException {
		zzzyInfoService.deleteByPrimaryKey(zzzyId, log);
		this.deleteByGbzyId(zzzyId, log);
		zzzyExtInfoService.deleteByGbzyId(zzzyId, log);
		this.deleteSupply(zzzyId, log);
		return DataResult.success(1);
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return zzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}
	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return zzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
}
