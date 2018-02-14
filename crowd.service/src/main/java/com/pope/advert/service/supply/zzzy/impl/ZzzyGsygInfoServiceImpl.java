package com.pope.advert.service.supply.zzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.gbzy.GbzyQtInfoMapper;
import com.pope.advert.dao.gggl.zzzy.ZzzyGsygInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyGsygInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zzzyGsygInfoService")
public class ZzzyGsygInfoServiceImpl implements ZzzyGsygInfoService{
	@Autowired
	private ZzzyGsygInfoMapper zzzyGsygInfoMapper;
	
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
}
