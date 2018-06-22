package com.pope.advert.service.supply.hwzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.hwzy.HwzyInfoMapper;
import com.pope.advert.dao.gggl.hwzy.extend.HwzyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;
import com.pope.advert.entity.gggl.hwzy.HwzyInfo;
import com.pope.advert.entity.gggl.hwzy.extend.HwzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.hwzy.HwzyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("hwzyInfoService")
public class HwzyInfoServiceImpl extends BaseSupplyInfoService implements HwzyInfoService{
	@Autowired
	private HwzyInfoMapper hwzyInfoMapper;
	@Autowired
	private HwzyInfoExtendMapper hwzyInfoExtendMapper;
	@Autowired
	private SupplyInfoService supplyInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		this.deleteSupply(wid, log);
		return DataResult.success(hwzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(HwzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(hwzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<HwzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(hwzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(HwzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(hwzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(HwzyInfo hwzyInfo, CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=hwzyInfo.getWid();
		HwzyInfo saveHwzyInfo=new HwzyInfo();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			saveHwzyInfo.setWid(StringUtil.getUuId());
			saveHwzyInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			saveHwzyInfo.setCjip(log.getCustomIp());
			
		}else{
			saveHwzyInfo.setWid(hwzyInfo.getWid());
		}
		saveHwzyInfo.setAdvertType(hwzyInfo.getWid());
		saveHwzyInfo.setArea(hwzyInfo.getArea());
		saveHwzyInfo.setCity(hwzyInfo.getCity());
		saveHwzyInfo.setDatastatus(YesNoEnum.YES.getCode());
		saveHwzyInfo.setGgsyqzk(hwzyInfo.getGgsyqzk());
		saveHwzyInfo.setGjcll(hwzyInfo.getGjcll());
		saveHwzyInfo.setGjrll(hwzyInfo.getGjrll());
		saveHwzyInfo.setHwgljj(hwzyInfo.getHwgljj());
		saveHwzyInfo.setLat(hwzyInfo.getLat());
		saveHwzyInfo.setLng(hwzyInfo.getLng());
		saveHwzyInfo.setMtcz(hwzyInfo.getMtcz());
		saveHwzyInfo.setMtggG(hwzyInfo.getMtggG());
		saveHwzyInfo.setMtggK(hwzyInfo.getMtggK());
		saveHwzyInfo.setMtggM(hwzyInfo.getMtggM());
		saveHwzyInfo.setMtggPfm(hwzyInfo.getMtggPfm());
		saveHwzyInfo.setMtzt(hwzyInfo.getMtzt());
		saveHwzyInfo.setName(hwzyInfo.getName());
		saveHwzyInfo.setQy(hwzyInfo.getQy());
		saveHwzyInfo.setRegisterId(log.getUserId());
		saveHwzyInfo.setScxgt(hwzyInfo.getScxgt());
		saveHwzyInfo.setSfybz(hwzyInfo.getSfybz());
		saveHwzyInfo.setShzt(ShztEnum.DSH.getCode());
		saveHwzyInfo.setSsqdqr(hwzyInfo.getSsqdqr());
		saveHwzyInfo.setTvId(hwzyInfo.getTvId());
		saveHwzyInfo.setXian(hwzyInfo.getXian());
		saveHwzyInfo.setXs(hwzyInfo.getXs());
		saveHwzyInfo.setZcwzt(hwzyInfo.getZcwzt());
		saveHwzyInfo.setZmsj(hwzyInfo.getZmsj());
		saveHwzyInfo.setAdvertType(hwzyInfo.getAdvertType());
		saveHwzyInfo.setZxjgMonth(hwzyInfo.getZxjgMonth());
		saveHwzyInfo.setZxjgYear(hwzyInfo.getZxjgYear());
		saveHwzyInfo.setZxtfsl(hwzyInfo.getZxtfsl());
		saveHwzyInfo.setZxtfzq(hwzyInfo.getZxtfzq());
		saveHwzyInfo.setZztfrq(hwzyInfo.getZztfrq());
		saveHwzyInfo.setSctplj(hwzyInfo.getSctplj());
		if(insert){
			return this.insertSelective(saveHwzyInfo, log);
		}else{
			return this.updateByPrimaryKeySelective(saveHwzyInfo, log);
		}
	}

	@Override
	public DataResult<List<HwzyInfoExtend>> selectDisplayByCondition(QueryCondition<HwzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<HwzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<HwzyInfoExtend> datas = hwzyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<HwzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(hwzyInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		this.shSupply(wid, shzt, log);
		HwzyInfo saveHwzyInfo=new HwzyInfo();
		saveHwzyInfo.setWid(wid);
		saveHwzyInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveHwzyInfo, log);
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
