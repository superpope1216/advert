package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyZtInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyZtInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyTbInfo;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyZtInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dszyZtInfoService")
public class DszyZtInfoServiceImpl extends BaseSupplyInfoService implements DszyZtInfoService{

	@Autowired
	private DszyZtInfoMapper dszyZtInfoMapper;
	@Autowired
	private DszyZtInfoExtendMapper dszyZtInfoExtendMapper;
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZtInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyZtInfo record, CustomOperateLog log) {
		return DataResult.success(dszyZtInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyZtInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZtInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyZtInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyZtInfoMapper.updateByPrimaryKeySelective(record));
	}
	
	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszyZtInfo dszyZtInfo, DszyExtInfo dszyExtInfo,
			CustomOperateLog log) throws ServiceException {
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
			dszyZtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszyZtInfo.setDszyId(wid);
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszyZtInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszyZtInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZtInfoExtendMapper.deleteByDszyId(dszyId));
	}

	@Override
	public DataResult<Integer> delete(String dszyId, CustomOperateLog log) throws ServiceException {
		dszyInfoService.deleteByPrimaryKey(dszyId, log);
		this.deleteByDszyId(dszyId, log);
		dszyExtInfoService.deleteByDszyId(dszyId, log);
		deleteSupply(dszyId, log);
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<DszyZtInfoExtend>> selectDisplayByCondition(QueryCondition<DszyZtInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszyZtInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyZtInfoExtend> datas = dszyZtInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszyZtInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyZtInfoExtendMapper.selectDisplayByCondition(condition));

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
