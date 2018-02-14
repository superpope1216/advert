package com.pope.advert.service.supply.gbzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.gbzy.GbzyQtInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("gbzyQtInfoService")
public class GbzyQtInfoServiceImpl implements GbzyQtInfoService{

	@Autowired
	private GbzyQtInfoMapper gbzyQtInfoMapper;
	
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
}
