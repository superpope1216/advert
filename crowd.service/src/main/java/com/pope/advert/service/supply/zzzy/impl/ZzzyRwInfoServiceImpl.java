package com.pope.advert.service.supply.zzzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.zzzy.ZzzyGsygInfoMapper;
import com.pope.advert.dao.gggl.zzzy.ZzzyRwInfoMapper;
import com.pope.advert.dao.gggl.zzzy.extend.ZzzyRwInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.ZzzyExtInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyGsygInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyInfo;
import com.pope.advert.entity.gggl.zzzy.ZzzyRwInfo;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyRwInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyRwInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zzzyRwInfoService")
public class ZzzyRwInfoServiceImpl extends BaseSupplyInfoService implements ZzzyRwInfoService{
	@Autowired
	private ZzzyRwInfoMapper zzzyRwInfoMapper;
	@Autowired
	private ZzzyRwInfoExtendMapper zzzyRwInfoExtendMapper;
	@Autowired
	private ZzzyInfoService zzzyInfoService;
	@Autowired
	private ZzzyExtInfoService zzzyExtInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyRwInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZzzyRwInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyRwInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZzzyRwInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyRwInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZzzyRwInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zzzyRwInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(ZzzyInfo zzzyInfo, ZzzyRwInfo zzzyRwInfo, ZzzyExtInfo zzzyExtInfo,
			CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
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
			zzzyRwInfo.setWid(StringUtil.getUuId());
			zzzyExtInfo.setWid(StringUtil.getUuId());
			
			
		}
		zzzyExtInfo.setDszyId(wid);
		zzzyInfo.setRegisterId(log.getUserId());
		zzzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		zzzyRwInfo.setZzzyId(wid);
		if(insert){
			zzzyInfoService.insertSelective(zzzyInfo, log);
			this.insertSelective(zzzyRwInfo, log);
			zzzyExtInfoService.insertSelective(zzzyExtInfo, log);
		}else{
			zzzyInfoService.updateByPrimaryKeySelective(zzzyInfo, log);
			this.updateByPrimaryKeySelective(zzzyRwInfo, log);
			zzzyExtInfoService.updateByPrimaryKeySelective(zzzyExtInfo, log);
		}
		return DataResult.success(1);
	}
	
	@Override
	public DataResult<List<ZzzyRwInfoExtend>> selectByCondition(QueryCondition<ZzzyRwInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyRwInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZzzyRwInfoExtend> datas = zzzyRwInfoExtendMapper.selectByCondition(condition);

			DataResult<List<ZzzyRwInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(zzzyRwInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> deleteByGbzyId(String zzzyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zzzyRwInfoExtendMapper.deleteByZzzyId(zzzyId));
	}

	@Override
	public DataResult<Integer> delete(String zzzyId, CustomOperateLog log) throws ServiceException {
		zzzyInfoService.deleteByPrimaryKey(zzzyId, log);
		this.deleteByGbzyId(zzzyId, log);
		zzzyExtInfoService.deleteByGbzyId(zzzyId, log);
		this.deleteSupply(zzzyId, log);
		return DataResult.success(1);
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return zzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}
	
	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return zzzyInfoService.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
}
