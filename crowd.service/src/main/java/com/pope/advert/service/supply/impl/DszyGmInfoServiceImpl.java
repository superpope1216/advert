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
import com.pope.advert.dao.gggl.DszyGmInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyGmInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyGmInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
@Transactional
@Service("dszyGmInfoService")
public class DszyGmInfoServiceImpl extends BaseSupplyInfoService implements DszyGmInfoService {

	@Autowired
	private DszyGmInfoMapper dszyGmInfoMapper;
	
	@Autowired
	private DszyGmInfoExtendMapper dszyGmInfoExtendMapper;
	
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyGmInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyGmInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyGmInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyGmInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyGmInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyGmInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyGmInfoMapper.updateByPrimaryKeySelective(record));
	}
	
	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszyGmInfo dszyGmInfo, DszyExtInfo dszyExtInfo,
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
			dszyGmInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		dszyGmInfo.setDszyId(wid);
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszyGmInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszyGmInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyGmInfoExtendMapper.deleteByDszyId(dszyId));
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
	public DataResult<List<DszyGmInfoExtend>> selectDisplayByCondition(QueryCondition<DszyGmInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszyGmInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyGmInfoExtend> datas = dszyGmInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszyGmInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyGmInfoExtendMapper.selectDisplayByCondition(condition));

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
