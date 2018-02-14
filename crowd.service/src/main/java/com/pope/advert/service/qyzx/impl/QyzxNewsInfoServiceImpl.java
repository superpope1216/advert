package com.pope.advert.service.qyzx.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.qyzx.QyzxNewsInfoMapper;
import com.pope.advert.dao.qyzx.extend.QyzxNewsInfoExtendMapper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.QyzxGgInfo;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxGgInfoService;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("qyzxNewsInfoService")
public class QyzxNewsInfoServiceImpl implements QyzxNewsInfoService{
	@Autowired
	private QyzxNewsInfoMapper qyzxNewsInfoMapper;
	@Autowired
	private QyzxNewsInfoExtendMapper qyzxNewsInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxNewsInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(QyzxNewsInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxNewsInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<QyzxNewsInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxNewsInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(QyzxNewsInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(qyzxNewsInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeyWithBLOBs(QyzxNewsInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(qyzxNewsInfoMapper.updateByPrimaryKeyWithBLOBs(record));
	}

	@Override
	public DataResult<List<QyzxNewsInfoExtend>> selectDisplayByCondition(QueryCondition<QyzxNewsInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<QyzxNewsInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<QyzxNewsInfoExtend> datas = qyzxNewsInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<QyzxNewsInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(qyzxNewsInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}
	@Override
	public DataResult<Integer> publishing(QyzxNewsInfo qyzxInfo,CustomOperateLog log) throws ServiceException{
		if(StringUtil.isEmpty(qyzxInfo.getTitle())){
			throw new ServiceException("标题不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(qyzxInfo.getContent())){
			throw new ServiceException("内容正文不能为空，请重新输入！");
		}
		
		QyzxNewsInfo saveqyzxInfo=new QyzxNewsInfo();;
		saveqyzxInfo.setXgsj(DateUtil.getCurrentDateTimeStr());
	
		saveqyzxInfo.setTitle(qyzxInfo.getTitle());
		saveqyzxInfo.setShzt(SjztEnum.DSH.getCode());
		saveqyzxInfo.setContent(qyzxInfo.getContent());
		if(StringUtil.isEmpty(qyzxInfo.getWid())){
			saveqyzxInfo.setWid(StringUtil.getUuId());
			saveqyzxInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			saveqyzxInfo.setCompanyid(log.getCompanyId());
			
			this.insertSelective(saveqyzxInfo, log);
		}else{
			check(qyzxInfo.getWid(),log);
			saveqyzxInfo.setWid(qyzxInfo.getWid());
			this.updateByPrimaryKeySelective(saveqyzxInfo, log);
		}
		return DataResult.success(1);
	}
	
	private void check(String wid,CustomOperateLog log){
		QyzxNewsInfo oldqyzxInfo=this.selectByPrimaryKey(wid, log).getDatas();
		if(!log.getCompanyId().equals(oldqyzxInfo.getCompanyid())){
			throw new ServiceException("该信息不是您发布的信息，请重新确认！");
			
		}
		if(!SjztEnum.WTG.getCode().equals(oldqyzxInfo.getShzt()) && !SjztEnum.CG.getCode().equals(oldqyzxInfo.getShzt())){
			throw new ServiceException("该信息无法修改，请重新确认!");
		}
	}

	@Override
	public DataResult<Integer> delete(String wid, CustomOperateLog log) throws ServiceException {
		check(wid,log);
		return this.deleteByPrimaryKey(wid, log);
	}
}
