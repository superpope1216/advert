package com.pope.advert.service.supply.bzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.bzzy.BzzyJyInfoMapper;
import com.pope.advert.dao.gggl.bzzy.BzzyRwInfoMapper;
import com.pope.advert.dao.gggl.bzzy.extend.BzzyRwInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyRwInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("bzzyRwInfoService")
public class BzzyRwInfoServiceImpl extends BaseSupplyInfoService implements BzzyRwInfoService {

	@Autowired
	private BzzyInfoService bzzyInfoService;
	@Autowired
	private BzzyExtInfoService bzzyExtInfoService;
	@Autowired
	private BzzyRwInfoMapper bzzyRwInfoMapper;
	@Autowired
	private BzzyRwInfoExtendMapper bzzyRwInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyRwInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyRwInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyRwInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyRwInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyRwInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyRwInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyRwInfoMapper.updateByPrimaryKeySelective(record));
	}
	
	@Override
	public DataResult<Integer> publishing(BzzyInfo bzzyInfo, BzzyRwInfo bzzyRwInfo, BzzyExtInfo bzzyExtInfo,
			CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=bzzyInfo.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			wid=StringUtil.getUuId();
			bzzyInfo.setWid(wid);
			bzzyInfo.setShzt(ShztEnum.DSH.getCode());
			bzzyInfo.setCjip(log.getCustomIp());
			bzzyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			bzzyInfo.setRegisterId(log.getUserId());
			bzzyRwInfo.setWid(StringUtil.getUuId());
			bzzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		bzzyExtInfo.setBzzyId(wid);
		bzzyInfo.setRegisterId(log.getUserId());
		bzzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		bzzyRwInfo.setBzzyId(wid);
		if(insert){
			bzzyInfoService.insertSelective(bzzyInfo, log);
			this.insertSelective(bzzyRwInfo, log);
			bzzyExtInfoService.insertSelective(bzzyExtInfo, log);
		}else{
			bzzyInfoService.updateByPrimaryKeySelective(bzzyInfo, log);
			this.updateByPrimaryKeySelective(bzzyRwInfo, log);
			bzzyExtInfoService.updateByPrimaryKeySelective(bzzyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<List<BzzyRwInfoExtend>> selectByCondition(QueryCondition<BzzyRwInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyRwInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyRwInfoExtend> datas = bzzyRwInfoExtendMapper.selectByCondition(condition);

			DataResult<List<BzzyRwInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(bzzyRwInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyRwInfoExtendMapper.deleteByBzzyId(bzzyId));
	}

	@Override
	public DataResult<Integer> delete(String bzzyId, CustomOperateLog log) throws ServiceException {
		bzzyInfoService.deleteByPrimaryKey(bzzyId, log);
		this.deleteByBzzyId(bzzyId, log);
		bzzyExtInfoService.deleteByBzzyId(bzzyId, log);
		this.deleteSupply(bzzyId, log);
		return DataResult.success(1);
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return bzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}
	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return bzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
}
