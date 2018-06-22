package com.pope.advert.service.supply.wlzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.wlzy.WlzyInfoMapper;
import com.pope.advert.dao.gggl.wlzy.extend.WlzyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.wlzy.WlzyInfo;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.supply.wlzy.WlzyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
@Service("wlzyInfoService")
@Transactional
public class WlzyInfoServiceImpl extends BaseSupplyInfoService implements WlzyInfoService {
	@Autowired
	private WlzyInfoMapper wlzyInfoMapper;
	@Autowired
	private WlzyInfoExtendMapper wlzyInfoExtendMapper;
	
	@Autowired
	private SupplyInfoService supplyInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(wlzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(WlzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(wlzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<WlzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(wlzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(WlzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(wlzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(WlzyInfo record, CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=record.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			
			record.setCjip(log.getCustomIp());
			record.setCjsj(DateUtil.getCurrentDateTimeStr());
			record.setShzt(ShztEnum.DSH.getCode());
			record.setWid(StringUtil.getUuId());
		}
		record.setDatastatus(YesNoEnum.YES.getCode());
		record.setRegisterId(log.getUserId());
		if(insert){
			this.insertSelective(record, log);
		}else{
			this.updateByPrimaryKeySelective(record, log);
		}
		return DataResult.success(1);
		
	}

	@Override
	public DataResult<List<WlzyInfoExtend>> selectDisplayByCondition(QueryCondition<WlzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<WlzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<WlzyInfoExtend> datas = wlzyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<WlzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(wlzyInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> delete(String wlzyId, CustomOperateLog log) throws ServiceException {
		this.deleteSupply(wlzyId, log);
		return this.deleteByPrimaryKey(wlzyId, log);
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		WlzyInfo saveWlzyInfo=new WlzyInfo();
		saveWlzyInfo.setWid(wid);
		saveWlzyInfo.setShzt(shzt);
		
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveWlzyInfo, log);
		supplyInfoService.sendMsg(wid, shzt, log);
		return datas;
		
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}
	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}
}
