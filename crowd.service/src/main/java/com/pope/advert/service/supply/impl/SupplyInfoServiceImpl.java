package com.pope.advert.service.supply.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.SupplyInfoMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.sjgl.impl.ZbxxInfoServiceImpl;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.MapUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
import com.wisedu.crowd.common.util.ThreadUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Service("supplyInfoService")
public class SupplyInfoServiceImpl implements SupplyInfoService{
	private final Logger LOG = LoggerFactory.getLogger(SupplyInfoServiceImpl.class);
	@Autowired
	private SmsSendMessage smsSendMessage;
	@Autowired
	private RegisterInfoService registerInfoService;
	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	@Override
	public DataResult<List<Map<String, Object>>> selectByCondition(QueryCondition<SupplyInfo> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<List<Map<String, Object>>> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<Map<String,Object>> datas = supplyInfoMapper.selectByCondition(condition);

			DataResult<List<Map<String,Object>>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(supplyInfoMapper.selectByCondition(condition));

		}
	}
	@Override
	public DataResult<Map<String, Object>> selectDszyByCondition(String dszyId, String tableName,CustomOperateLog log) {
		return DataResult.success(supplyInfoMapper.selectDszyByCondition(dszyId, tableName));
	}
	@Override
	public  DataResult<Integer> deleteDszyByCondition(String dszyId,String tableName,CustomOperateLog log) throws ServiceException{
		return DataResult.success(supplyInfoMapper.deleteDszyByCondition(dszyId, tableName));
	}
	@Override
	public DataResult<Integer> selectCountByCondition(QueryCondition<SupplyInfo> condition, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(supplyInfoMapper.selectCountByCondition(condition));
	}
	@Override
	public DataResult<Integer> sendMsg(final String wid, String shzt,CustomOperateLog log) throws ServiceException {

		SupplyInfo querySupplyInfo=new SupplyInfo();
		querySupplyInfo.setWid(wid);
		Map<String,Object> map=this.selectByCondition(ConditionUtil.createCondition(querySupplyInfo), log).getDatas().get(0);
		map=MapUtil.changeKeyToLower(map);
		final RegisterInfo registerInfo = registerInfoService.selectByPrimaryKey(StringUtil.toStr(map.get("register_id")), log)
				.getDatas();
		String message = SmsMessageTempleateEnum.AD_ZS.getName();
		String shztName = "审核不通过";
		if (SjztEnum.YTG.getCode().equals(shzt)) {
			shztName = "审核通过";
		}
		message = SmsMessageTempleateEnum.TITLE + String.format(message, StringUtil.toStr(map.get("name")), shztName);
		final String content = message;
		ThreadUtil.getSortTimeOutThread(new Runnable() {
			@Override
			public void run() {
				try {
					smsSendMessage.sendMessage(registerInfo.getSjh(), content);
				} catch (Exception e) {
					LOG.error("===广告信息发送邮件失败==="+wid + e.getMessage());
				}
			}
		});
		return DataResult.success(1);
	}
	

}
