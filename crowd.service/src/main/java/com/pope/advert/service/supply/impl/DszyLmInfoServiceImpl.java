package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyLmInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyLmInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyLmInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
@Service("dszyLmInfoService")
public class DszyLmInfoServiceImpl extends BaseSupplyInfoService implements  DszyLmInfoService{

	@Autowired
	private DszyLmInfoMapper dszyLmInfoMapper;
	@Autowired
	private DszyLmInfoExtendMapper dszyLmInfoExtendMapper;
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyLmInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyLmInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyLmInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyLmInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyLmInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyLmInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyLmInfoMapper.updateByPrimaryKeySelective(record));
	}


	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszyLmInfo dszyLmInfo, DszyExtInfo dszyExtInfo,
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
			dszyLmInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszyLmInfo.setDszyId(wid);
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszyLmInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszyLmInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyLmInfoExtendMapper.deleteByDszyId(dszyId));
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
	public DataResult<List<DszyLmInfoExtend>> selectDisplayByCondition(QueryCondition<DszyLmInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszyLmInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyLmInfoExtend> datas = dszyLmInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DszyLmInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dszyLmInfoExtendMapper.selectDisplayByCondition(condition));

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
