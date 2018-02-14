package com.pope.advert.service.sjgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.dao.sjgl.ZbxxInfoMapper;
import com.pope.advert.dao.sjgl.extend.ZbxxInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.ZbxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.ZbxxInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("zbxxInfoService")
public class ZbxxInfoServiceImpl implements ZbxxInfoService{
	@Autowired
	private ZbxxInfoMapper zbxxInfoMapper;
	@Autowired
	private ZbxxInfoExtendMapper zbxxInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zbxxInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(ZbxxInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zbxxInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<ZbxxInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(zbxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(ZbxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zbxxInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeyWithBLOBs(ZbxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(zbxxInfoMapper.updateByPrimaryKeyWithBLOBs(record));
	}

	@Override
	public DataResult<List<ZbxxInfoExtend>> selectDisplayByCondition(QueryCondition<ZbxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZbxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<ZbxxInfoExtend> datas = zbxxInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<ZbxxInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(zbxxInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}
	

	@Override
	public DataResult<Integer> publishing(ZbxxInfo hzxxInfo,CustomOperateLog log) throws ServiceException{
		if(StringUtil.isEmpty(hzxxInfo.getTitle())){
			throw new ServiceException("标题不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(hzxxInfo.getKssj())){
			throw new ServiceException("开始时间不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(hzxxInfo.getJssj())){
			throw new ServiceException("结束时间不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(hzxxInfo.getImgid())){
			throw new ServiceException("图片不能为空，请重新上传！");
		}
		if(StringUtil.isEmpty(hzxxInfo.getZtnr())){
		
			throw new ServiceException("主题简介不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(hzxxInfo.getContent())){
			throw new ServiceException("内容正文不能为空，请重新输入！");
		}
		
		ZbxxInfo saveHzxxInfo=new ZbxxInfo();
		saveHzxxInfo.setKssj(hzxxInfo.getKssj());
		saveHzxxInfo.setJssj(hzxxInfo.getJssj());
		saveHzxxInfo.setImgid(hzxxInfo.getImgid());
		saveHzxxInfo.setXgsj(DateUtil.getCurrentDateTimeStr());
	
		saveHzxxInfo.setTitle(hzxxInfo.getTitle());
		saveHzxxInfo.setShzt(SjztEnum.DSH.getCode());
		saveHzxxInfo.setZtnr(hzxxInfo.getZtnr());
		saveHzxxInfo.setContent(hzxxInfo.getContent());
		if(StringUtil.isEmpty(hzxxInfo.getWid())){
			saveHzxxInfo.setWid(StringUtil.getUuId());
			saveHzxxInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			saveHzxxInfo.setYhid(log.getCompanyId());
			
			this.insertSelective(saveHzxxInfo, log);
		}else{
			check(hzxxInfo.getWid(),log);
			saveHzxxInfo.setWid(hzxxInfo.getWid());
			this.updateByPrimaryKeySelective(saveHzxxInfo, log);
		}
		return DataResult.success(1);
	}
	
	private void check(String wid,CustomOperateLog log){
		ZbxxInfo oldDlxxInfo=this.selectByPrimaryKey(wid, log).getDatas();
		if(!log.getCompanyId().equals(oldDlxxInfo.getYhid())){
			throw new ServiceException("该信息不是您发布的信息，请重新确认！");
			
		}
		if(!SjztEnum.WTG.getCode().equals(oldDlxxInfo.getShzt()) || !SjztEnum.CG.getCode().equals(oldDlxxInfo.getShzt())){
			throw new ServiceException("该信息无法修改，请重新确认!");
		}
	}

	@Override
	public DataResult<Integer> delete(String wid, CustomOperateLog log) throws ServiceException {
		check(wid,log);
		return this.deleteByPrimaryKey(wid, log);
	}
}
