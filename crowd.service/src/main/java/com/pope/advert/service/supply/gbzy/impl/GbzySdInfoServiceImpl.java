package com.pope.advert.service.supply.gbzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.advert.dao.gggl.gbzy.GbzySdInfoMapper;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("gbzySdInfoService")
public class GbzySdInfoServiceImpl implements GbzySdInfoService{
	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;
	@Autowired
	private GbzySdInfoMapper gbzySdInfoMapper;
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
		String wid=gbzySdInfo.getWid();
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

}
