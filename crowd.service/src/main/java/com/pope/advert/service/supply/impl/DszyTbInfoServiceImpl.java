package com.pope.advert.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.DszyTbInfoMapper;
import com.pope.advert.dao.gggl.extend.DszyTbInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyTbInfo;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyTbInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dszyTbInfoService")
public class DszyTbInfoServiceImpl extends BaseSupplyInfoService implements DszyTbInfoService{

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszyTbInfoMapper dszyTbInfoMapper;
	

	@Autowired
	private DszyTbInfoExtendMapper dszyTbInfoExtendMapper;
	
	@Autowired
	private DszyInfoService dszyInfoService;
	
	@Autowired
	private DszyExtInfoService dszyExtInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyTbInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DszyTbInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyTbInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DszyTbInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyTbInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DszyTbInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dszyTbInfoMapper.updateByPrimaryKeySelective(record));
	}
	@Override
	public DataResult<Integer> publishing(DszyInfo dszyInfo, DszyTbInfo dszyTbInfo, DszyExtInfo dszyExtInfo,
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
			dszyTbInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setWid(StringUtil.getUuId());
			dszyExtInfo.setDszyId(wid);
			
		}
		dszyInfo.setRegisterId(log.getUserId());
		dszyTbInfo.setDszyId(wid);
		dszyInfo.setDatastatus(YesNoEnum.YES.getCode());
		if(insert){
			dszyInfoService.insertSelective(dszyInfo, log);
			this.insertSelective(dszyTbInfo, log);
			dszyExtInfoService.insertSelective(dszyExtInfo, log);
		}else{
			dszyInfoService.updateByPrimaryKeySelective(dszyInfo, log);
			this.updateByPrimaryKeySelective(dszyTbInfo, log);
			dszyExtInfoService.updateByPrimaryKeySelective(dszyExtInfo, log);
		}
		return DataResult.success(1);
	}

	@Override
	public DataResult<Integer> deleteByDszyId(String dszyId, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dszyTbInfoExtendMapper.deleteByDszyId(dszyId));
	}

	@Override
	public DataResult<Integer> delete(String dszyId, CustomOperateLog log) throws ServiceException {
		dszyInfoService.deleteByPrimaryKey(dszyId, log);
		this.deleteByDszyId(dszyId, log);
		dszyExtInfoService.deleteByDszyId(dszyId, log);
		this.deleteSupply(dszyId, log);
		return DataResult.success(1);
	}

	private void getPd(List<DszyTbInfoExtend> datas){
		List<DictionaryInfo> pdList=dictionaryService.selectAllByTable(DictionaryEnum.T_CROWD_SJZD_SDPD);
		if(CommonUtil.isNotEmptyList(datas)){
			DszyTbInfoExtend dszyTbInfoExtend=datas.get(0);
			if(!StringUtil.isEmpty(dszyTbInfoExtend.getBhpd())){
				String[] pd=dszyTbInfoExtend.getBhpd().split(",");
				String pdDisplay="";
				for(String s:pd){
					if(CommonUtil.isNotEmptyList(pdList)){
						for(DictionaryInfo _pd:pdList){
							if(s.equals(_pd.getLbdm())){
								pdDisplay+=","+_pd.getLbmc();
								 break;
							}
						}
					}
					
				}
				if(!StringUtil.isEmpty(pdDisplay)){
					pdDisplay=pdDisplay.substring(1);
				}
				dszyTbInfoExtend.setBhpdDisplay(pdDisplay);
			}
		}
	}
	@Override
	public DataResult<List<DszyTbInfoExtend>> selectDisplayByCondition(QueryCondition<DszyTbInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DszyTbInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DszyTbInfoExtend> datas = dszyTbInfoExtendMapper.selectDisplayByCondition(condition);
			getPd(datas);
			DataResult<List<DszyTbInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			List<DszyTbInfoExtend> datas =dszyTbInfoExtendMapper.selectDisplayByCondition(condition);
			getPd(datas);
			return DataResult.success(datas);

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
