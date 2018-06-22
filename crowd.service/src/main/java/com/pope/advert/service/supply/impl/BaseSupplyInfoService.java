package com.pope.advert.service.supply.impl;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DateUtil;

public abstract class BaseSupplyInfoService {

	@Autowired
	protected YhglDjxxInfoServie yhglDjxxInfoServie;
	@Autowired
	protected CompanyInfoService companyInfoService;
	
	protected abstract String getUserIdByWid(String wid,CustomOperateLog log) throws ServiceException;
	protected abstract String getShztByWid(String wid,CustomOperateLog log) throws ServiceException;
	public void shSupply(String wid,String shzt,CustomOperateLog log) throws ServiceException {
		if(!ShztEnum.YTG.getCode().equals(shzt)) {
			return;
		}
		String userId=getUserIdByWid(wid,log);
		checkPublishing(userId, log);
		updateDjxx(userId,-1,log);
	}
	
	public void deleteSupply(String wid,CustomOperateLog log) throws ServiceException{
		String userId=getUserIdByWid(wid,log);
		updateDjxx(userId,1,log);
	}
	
	
	protected void checkSupplyInfo(String yhid,CustomOperateLog log) throws ServiceException{
		CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
		queryCompanyInfoExtend.setRegisterId(yhid);
		List<CompanyInfoExtend> companyDatas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), log).getDatas();
		if(CommonUtil.isNotEmptyList(companyDatas)) {
			
			if(ShztEnum.CG.getCode().equals(companyDatas.get(0).getSupplyShzt())) {
				throw new ServiceException(ShztEnum.CG.getSupplyContent());
			}else if(ShztEnum.DSH.getCode().equals(companyDatas.get(0).getSupplyShzt())) {
				throw new ServiceException(ShztEnum.DSH.getSupplyContent());
			}else if(ShztEnum.WTG.getCode().equals(companyDatas.get(0).getSupplyShzt())) {
				throw new ServiceException(ShztEnum.WTG.getSupplyContent());
			}
			
		}else {
			throw new ServiceException(ShztEnum.CG.getSupplyContent());
		}
	}
	
	private void updateDjxx(String yhid,int num,CustomOperateLog log) throws ServiceException{
		YhglDjxxInfoExtend queryYhglDjxxInfoExtend=new YhglDjxxInfoExtend();
		queryYhglDjxxInfoExtend.setYhid(yhid);
		List<YhglDjxxInfoExtend> djxxs=yhglDjxxInfoServie.selectByCondition(ConditionUtil.createCondition(queryYhglDjxxInfoExtend), log).getDatas();
		if(CommonUtil.isNotEmptyList(djxxs)) {
			YhglDjxxInfoExtend saveYhglDjxxInfoExtend=new YhglDjxxInfoExtend();
			saveYhglDjxxInfoExtend.setSyts(djxxs.get(0).getSyts()+num);
			saveYhglDjxxInfoExtend.setVersion(djxxs.get(0).getVersion());
			saveYhglDjxxInfoExtend.setWid(djxxs.get(0).getWid());
			Integer count=yhglDjxxInfoServie.updateByVersion(saveYhglDjxxInfoExtend, log).getDatas();
			if(count==0) {
				throw new ServiceException("保存失败，请重新保存!");
			}
			
		}else {
			throw new ServiceException(ShztEnum.CG.getSupplyContent());
		}
	}
	
	
	public void checkPublishing(String yhid,CustomOperateLog log) throws ServiceException{
		
		//checkSupplyInfo(yhid,log);
		YhglDjxxInfoExtend queryYhglDjxxInfoExtend=new YhglDjxxInfoExtend();
		queryYhglDjxxInfoExtend.setYhid(yhid);
		List<YhglDjxxInfoExtend> djxxs=yhglDjxxInfoServie.selectByCondition(ConditionUtil.createCondition(queryYhglDjxxInfoExtend), log).getDatas();
		if(CommonUtil.isNotEmptyList(djxxs)) {
			if(djxxs.get(0).getSyts()!=null) {
				if(djxxs.get(0).getSyts()<=0) {
					throw new ServiceException("剩余发布广告条数为"+djxxs.get(0).getSyts()+"条广告，无法再发布广告了！");
				}
			}
			long dayCount=DateUtil.getDaysBetween(djxxs.get(0).getJssj(), DateUtil.getCurrentDateStr());
			if(dayCount>0) {
				throw new ServiceException("会员日期已到期，请重新确认！");
			}
		}else {
			throw new ServiceException(ShztEnum.CG.getSupplyContent());
		}
	}
}
