package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyZZInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyZZInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyZzInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dszyZzInfoService")
public class DszyZzInfoServiceImpl extends BaseSupplyInfoService implements DszyZzInfoService {

	@Autowired
	private DszyZZInfoMapper dszyZZInfoMapper;
	
	@Autowired
	private DszyZZInfoExtendMapper dszyZZInfoExtendMapper;
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZZInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyZzInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZZInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyZzInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZZInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyZzInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyZZInfoMapper.updateByPrimaryKeySelective(record));
	}
	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszyZzInfo dszyZzInfo, DszyExtInfo dszyExtInfo,
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
			dszyZzInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszyZzInfo.setDszyId(wid);
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszyZzInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszyZzInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyZZInfoExtendMapper.deleteByDszyId(dszyId));
	}

	@Override
	public DataResult<Integer> delete(String dszyId, CustomOperateLog log) throws ServiceException {
		dszyInfoService.deleteByPrimaryKey(dszyId, log);
		this.deleteByDszyId(dszyId, log);
		dszyExtInfoService.deleteByDszyId(dszyId, log);
		this.deleteSupply(dszyId, log);
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<DszyZzInfoExtend>> selectDisplayByCondition(QueryCondition<DszyZzInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszyZzInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyZzInfoExtend> datas = dszyZZInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszyZzInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyZZInfoExtendMapper.selectDisplayByCondition(condition));

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
