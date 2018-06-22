package com.pope.advert.service.supply.xmtzy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.xmtzy.XmtzyInfoMapper;
import com.pope.advert.dao.gggl.xmtzy.extend.XmtzyInfoExtendMapper;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
import com.pope.advert.entity.gggl.xmtzy.XmtzyInfo;
import com.pope.advert.entity.gggl.xmtzy.extend.XmtzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.supply.xmtzy.XmtzyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("xmtzyInfoService")
public class XmtzyInfoServiceImpl extends BaseSupplyInfoService implements XmtzyInfoService{
	@Autowired
	private XmtzyInfoMapper xmtzyInfoMapper;
	
	@Autowired
	private XmtzyInfoExtendMapper xmtzyInfoExtendMapper;
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private SupplyInfoService supplyInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(xmtzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(XmtzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(xmtzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<XmtzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(xmtzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(XmtzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(xmtzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> publishing(XmtzyInfo record, CustomOperateLog log) throws ServiceException {
		checkPublishing(log.getUserId(), log);
		String wid=record.getWid();
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			record.setWid(StringUtil.getUuId());
			record.setCjsj(DateUtil.getCurrentDateTimeStr());
			record.setCjip(log.getCustomIp());
		
		}
		record.setShzt(ShztEnum.DSH.getCode());
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
	public DataResult<List<XmtzyInfoExtend>> selectDisplayByCondition(QueryCondition<XmtzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<XmtzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<XmtzyInfoExtend> datas = xmtzyInfoExtendMapper.selectDisplayByCondition(condition);
			changeSjzd(datas);
			DataResult<List<XmtzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			
			return dataResult;
		} else {
			List<XmtzyInfoExtend> datas = xmtzyInfoExtendMapper.selectDisplayByCondition(condition);
			changeSjzd(datas);
			return DataResult.success(datas);

		}
	}
	
	private void changeSjzd(List<XmtzyInfoExtend> datas){
		List<DictionaryInfo> szrqLst=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SZRQ);
		List<DictionaryInfo> jycdLst=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_XMTZY_JYCD);
		List<DictionaryInfo> zyfbLst=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_XMTZY_ZYFB);
		List<DictionaryInfo> srzkLst=dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SRZK);
		if(CommonUtil.isNotEmptyList(datas)){
			for(XmtzyInfoExtend xmtzyInfoExtend:datas){
				xmtzyInfoExtend.setSzrqDisplay(getDisplay(xmtzyInfoExtend.getSzrq(),szrqLst));
				xmtzyInfoExtend.setJycdDisplay(getDisplay(xmtzyInfoExtend.getJycd(),jycdLst));
				xmtzyInfoExtend.setZyfbDisplay(getDisplay(xmtzyInfoExtend.getZyfb(),zyfbLst));
				xmtzyInfoExtend.setSrzkDisplay(getDisplay(xmtzyInfoExtend.getSrzk(),srzkLst));
			}
		}
	}
	
	private String getDisplay(String value,List<DictionaryInfo> lst){
		String retuValue="";
		if(!StringUtil.isEmpty(value) && CommonUtil.isNotEmptyList(lst)){
			String[] data=value.split(",");
			for(String s:data){
				for(DictionaryInfo dictionaryInfo:lst){
					if(dictionaryInfo.getLbdm().equals(s)){
						retuValue+=","+dictionaryInfo.getLbmc();
						break;
					}
				}
			}
		}
		if(!StringUtil.isEmpty(retuValue)){
			retuValue= retuValue.substring(1);
		}
		return retuValue;
	}

	@Override
	public DataResult<Integer> delete(String xmtzyId, CustomOperateLog log) throws ServiceException {
		this.deleteSupply(xmtzyId, log);
		return this.deleteByPrimaryKey(xmtzyId, log);
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) {
		XmtzyInfo saveXmtzyInfo=new XmtzyInfo();
		saveXmtzyInfo.setWid(wid);
		saveXmtzyInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveXmtzyInfo, log);
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
