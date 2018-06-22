package com.pope.advert.service.supply.bzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.bzzy.BzzyGsygInfoMapper;
import com.pope.advert.dao.gggl.bzzy.extend.BzzyGsygInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("bzzyGsygInfoService")
public class BzzyGsygInfoServiceImpl extends BaseSupplyInfoService implements BzzyGsygInfoService {

	@Autowired
	private BzzyGsygInfoMapper bzzyGsygInfoMapper;
	@Autowired
	private BzzyGsygInfoExtendMapper bzzyGsygInfoExtendMapper;
	@Autowired
	private BzzyInfoService bzzyInfoService;
	@Autowired
	private BzzyExtInfoService bzzyExtInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyGsygInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyGsygInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyGsygInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyGsygInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyGsygInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyGsygInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyGsygInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(BzzyInfo bzzyInfo, BzzyGsygInfo bzzyGsygInfo, BzzyExtInfo bzzyExtInfo,
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
			bzzyGsygInfo.setWid(StringUtil.getUuId());
			bzzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		bzzyExtInfo.setBzzyId(wid);
		bzzyInfo.setRegisterId(log.getUserId());
		bzzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		bzzyGsygInfo.setBzzyId(wid);
		if(insert){
			bzzyInfoService.insertSelective(bzzyInfo, log);
			this.insertSelective(bzzyGsygInfo, log);
			bzzyExtInfoService.insertSelective(bzzyExtInfo, log);
		}else{
			bzzyInfoService.updateByPrimaryKeySelective(bzzyInfo, log);
			this.updateByPrimaryKeySelective(bzzyGsygInfo, log);
			bzzyExtInfoService.updateByPrimaryKeySelective(bzzyExtInfo, log);
		}
		return DataResult.success(1);
	}


	@Override
	public DataResult<List<BzzyGsygInfoExtend>> selectByCondition(QueryCondition<BzzyGsygInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyGsygInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyGsygInfoExtend> datas = bzzyGsygInfoExtendMapper.selectByCondition(condition);

			DataResult<List<BzzyGsygInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(bzzyGsygInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByBzzyId(String bzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyGsygInfoExtendMapper.deleteByBzzyId(bzzyId));
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
	public DataResult<List<BzzyGsygInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyGsygInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyGsygInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyGsygInfoExtend> datas = bzzyGsygInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<BzzyGsygInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(bzzyGsygInfoExtendMapper.selectDisplayByCondition(condition));

		}
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
