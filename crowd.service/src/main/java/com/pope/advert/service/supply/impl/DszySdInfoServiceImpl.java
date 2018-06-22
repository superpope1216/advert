package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszySdInfoMapper;
import com.pope.advert.dao.gggl.extend.DszySdInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszySdInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dszySdInfoService")
@Transactional
public class DszySdInfoServiceImpl extends BaseSupplyInfoService implements DszySdInfoService{

	@Autowired
	private DszySdInfoMapper dszySdInfoMapper; 
	@Autowired
	private DszySdInfoExtendMapper dszySdInfoExtendMapper; 
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszySdInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszySdInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszySdInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszySdInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszySdInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszySdInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszySdInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszySdInfo dszySdInfo, DszyExtInfo dszyExtInfo,CustomOperateLog log)
			throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=dszyInfo.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			wid=StringUtil.getUuId();
			dszyInfo.setWid(wid);
			dszyInfo.setShzt(ShztEnum.DSH.getCode());
			dszyInfo.setCjip(log.getCustomIp());
			dszyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			dszyInfo.setRegisterId(log.getUserId());
			dszySdInfo.setWid(StringUtil.getUuId());
			dszySdInfo.setCjip(log.getCustomIp());
			dszySdInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszySdInfo.setDszyId(wid);
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszySdInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszySdInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszySdInfoExtendMapper.deleteByDszyId(dszyId));
	}

	@Override
	public DataResult<Integer> delete(String dszyId, CustomOperateLog log) throws ServiceException {
		this.deleteSupply(dszyId, log);
		dszyInfoService.deleteByPrimaryKey(dszyId, log);
		this.deleteByDszyId(dszyId, log);
		dszyExtInfoService.deleteByDszyId(dszyId, log);
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<DszySdInfoExtend>> selectDisplayByCondition(QueryCondition<DszySdInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszySdInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszySdInfoExtend> datas = dszySdInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszySdInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszySdInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return dszyInfoService.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}
	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return dszyInfoService.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}

}
