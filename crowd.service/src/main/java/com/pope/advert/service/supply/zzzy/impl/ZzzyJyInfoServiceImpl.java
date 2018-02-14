package com.pope.advert.service.supply.zzzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.zzzy.ZzzyGsygInfoMapper;
import com.pope.advert.dao.gggl.zzzy.ZzzyJyInfoMapper;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyJyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyJyInfoService;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zzzyJyInfoService")
public class ZzzyJyInfoServiceImpl implements ZzzyJyInfoService{
	@Autowired
	private ZzzyJyInfoMapper zzzyJyInfoMapper;
	
	@Autowired
	private ZzzyInfoService zzzyInfoService;
	@Autowired
	private ZzzyExtInfoService zzzyExtInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyJyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyJyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyJyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyJyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyJyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyJyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyJyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(ZzzyInfo zzzyInfo, ZzzyJyInfo zzzyJyInfo, ZzzyExtInfo zzzyExtInfo,
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
			zzzyJyInfo.setWid(StringUtil.getUuId());
			zzzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		zzzyExtInfo.setDszyId(wid);
		zzzyInfo.setRegisterId(log.getUserId());
		zzzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		zzzyJyInfo.setZzzyId(wid);
		if(insert){
			zzzyInfoService.insertSelective(zzzyInfo, log);
			this.insertSelective(zzzyJyInfo, log);
			zzzyExtInfoService.insertSelective(zzzyExtInfo, log);
		}else{
			zzzyInfoService.updateByPrimaryKeySelective(zzzyInfo, log);
			this.updateByPrimaryKeySelective(zzzyJyInfo, log);
			zzzyExtInfoService.updateByPrimaryKeySelective(zzzyExtInfo, log);
		}
		return DataResult.success(1);
	}
}
