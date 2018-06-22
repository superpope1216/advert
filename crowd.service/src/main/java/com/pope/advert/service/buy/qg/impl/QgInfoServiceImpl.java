package com.pope.advert.service.buy.qg.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.buy.qg.QgInfoMapper;
import com.pope.advert.dao.buy.qg.extend.QgInfoExtendMapper;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
import com.wisedu.crowd.common.util.ThreadUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Service("qgInfoService")
public class QgInfoServiceImpl implements QgInfoService{
	
	private final Logger LOG=LoggerFactory.getLogger(QgInfoServiceImpl.class);
	@Autowired
	private QgInfoMapper qgInfoMapper;
	@Autowired
	private QgInfoExtendMapper qgInfoExtendMapper;
	
	@Autowired
	private SmsSendMessage smsSendMessage;
	@Autowired
	private RegisterInfoService registerInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qgInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(QgInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qgInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<QgInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qgInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(QgInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(qgInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<QgInfoExtend>> selectByCondition(QueryCondition<QgInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<QgInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<QgInfoExtend> datas = qgInfoExtendMapper.selectByCondition(condition);

			DataResult<List<QgInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(qgInfoExtendMapper.selectByCondition(condition));

		}
	}

	@Override
	public DataResult<List<QgInfoExtend>> selectDisplayByCondition(QueryCondition<QgInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<QgInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<QgInfoExtend> datas = qgInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<QgInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(qgInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}

	@Override
	public DataResult<Integer> publishing(QgInfo qgInfo, CustomOperateLog log) throws ServiceException {
		String wid=qgInfo.getWid();
		QgInfo saveQgInfo=new QgInfo();
		if(StringUtil.isEmpty(qgInfo.getName())){
			throw new ServiceException("请输入名称！");
		}
		if(StringUtil.isEmpty(qgInfo.getJg())){
			throw new ServiceException("请输入预算！");
		}
		if(StringUtil.isEmpty(qgInfo.getContent())){
			throw new ServiceException("请输入求购内容！");
		}
		boolean insert=false;
		if(StringUtil.isEmpty(wid)){
			insert=true;
			wid=StringUtil.getUuId();
			saveQgInfo.setCjip(log.getCustomIp());
			saveQgInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			
		}
		saveQgInfo.setName(qgInfo.getName());
		saveQgInfo.setJg(qgInfo.getJg());
		saveQgInfo.setXgsj(DateUtil.getCurrentDateTimeStr());
		saveQgInfo.setContent(qgInfo.getContent());
		saveQgInfo.setRegisterId(log.getUserId());
		saveQgInfo.setShzt(ShztEnum.DSH.getCode());
		saveQgInfo.setWid(wid);
		
		if(insert){
			return this.insertSelective(saveQgInfo, log);
		}else{
			return this.updateByPrimaryKeySelective(saveQgInfo, log);
		}
		
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		QgInfo saveQgInfo=new QgInfo();
		saveQgInfo.setWid(wid);
		saveQgInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveQgInfo, log);
		QgInfo oldQginfo=this.selectByPrimaryKey(wid, log).getDatas();
		final RegisterInfo registerInfo=registerInfoService.selectByPrimaryKey(oldQginfo.getRegisterId(), log).getDatas();
		 String message=SmsMessageTempleateEnum.AD_QG.getName();
		String shztName="审核不通过";
		if(SjztEnum.YTG.getCode().equals(shzt)) {
			shztName="审核通过";
		}
		message=SmsMessageTempleateEnum.TITLE+String.format(message,oldQginfo.getName(),shztName);
		final String content=message;
		ThreadUtil.getSortTimeOutThread(new Runnable() {
			@Override
			public void run() {
				try {
				smsSendMessage.sendMessage(registerInfo.getSjh(), content);
				}catch(Exception e) {
					LOG.error("===求购信息发送邮件失败==="+e.getMessage());
				}
			}
		});
		return datas;
		
	}
	
}
