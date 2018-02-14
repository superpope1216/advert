package com.pope.advert.service.qyzx.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.qyzx.QyzxGgInfoMapper;
import com.pope.advert.dao.qyzx.extend.QyzxGgInfoExtendMapper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.QyzxGgInfo;
import com.pope.advert.entity.qyzx.extend.QyzxGgInfoExtend;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxGgInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("qyzxGgInfoService")
public class QyzxGgInfoServiceImpl implements QyzxGgInfoService{
	@Autowired
	private QyzxGgInfoMapper qyzxGgInfoMapper;
	@Autowired
	private QyzxGgInfoExtendMapper qyzxGgInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxGgInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(QyzxGgInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxGgInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<QyzxGgInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(qyzxGgInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(QyzxGgInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(qyzxGgInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeyWithBLOBs(QyzxGgInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(qyzxGgInfoMapper.updateByPrimaryKeyWithBLOBs(record));
	}

	@Override
	public DataResult<List<QyzxGgInfoExtend>> selectDisplayByCondition(QueryCondition<QyzxGgInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<QyzxGgInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<QyzxGgInfoExtend> datas = qyzxGgInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<QyzxGgInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(qyzxGgInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}
	@Override
	public DataResult<Integer> publishing(QyzxGgInfo qyzxInfo,CustomOperateLog log) throws ServiceException{
		if(StringUtil.isEmpty(qyzxInfo.getTitle())){
			throw new ServiceException("标题不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(qyzxInfo.getContent())){
			throw new ServiceException("内容正文不能为空，请重新输入！");
		}
		
		QyzxGgInfo saveqyzxInfo=new QyzxGgInfo();;
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
		QyzxGgInfo oldqyzxInfo=this.selectByPrimaryKey(wid, log).getDatas();
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
