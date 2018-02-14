package com.pope.advert.service.sjgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.dao.sjgl.extend.HzxxInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.HzxxInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("hzxxInfoService")
public class HzxxInfoServiceImpl implements HzxxInfoService{

	@Autowired
	private HzxxInfoMapper hzxxInfoMapper;
	@Autowired
	private HzxxInfoExtendMapper hzxxInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(hzxxInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(HzxxInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(hzxxInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<HzxxInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(hzxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(HzxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(hzxxInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeyWithBLOBs(HzxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(hzxxInfoMapper.updateByPrimaryKeyWithBLOBs(record));
	}

	@Override
	public DataResult<List<HzxxInfoExtend>> selectDisplayByCondition(QueryCondition<HzxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<HzxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<HzxxInfoExtend> datas = hzxxInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<HzxxInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(hzxxInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}
	
	@Override
	public DataResult<Integer> publishing(HzxxInfo hzxxInfo,CustomOperateLog log) throws ServiceException{
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
		
		HzxxInfo saveHzxxInfo=new HzxxInfo();
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
		HzxxInfo oldDlxxInfo=this.selectByPrimaryKey(wid, log).getDatas();
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
