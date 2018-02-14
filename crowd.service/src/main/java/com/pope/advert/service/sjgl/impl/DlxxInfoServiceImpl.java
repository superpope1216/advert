package com.pope.advert.service.sjgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.dao.sjgl.DlxxInfoMapper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.dao.sjgl.extend.DlxxInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("dlxxInfoService")
public class DlxxInfoServiceImpl implements DlxxInfoService{
	@Autowired
	private DlxxInfoMapper dlxxInfoMapper;
	@Autowired
	private DlxxInfoExtendMapper dlxxInfoExtendMapper;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dlxxInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(DlxxInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dlxxInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<DlxxInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(dlxxInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(DlxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dlxxInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeyWithBLOBs(DlxxInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(dlxxInfoMapper.updateByPrimaryKeyWithBLOBs(record));
	}

	@Override
	public DataResult<List<DlxxInfoExtend>> selectDisplayByCondition(QueryCondition<DlxxInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<DlxxInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<DlxxInfoExtend> datas = dlxxInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<DlxxInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(dlxxInfoExtendMapper.selectDisplayByCondition(condition));

		}
	}
	@Override
	public DataResult<Integer> publishing(DlxxInfo dlxxInfo,CustomOperateLog log) throws ServiceException{
		if(StringUtil.isEmpty(dlxxInfo.getTitle())){
			throw new ServiceException("标题不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(dlxxInfo.getKssj())){
			throw new ServiceException("开始时间不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(dlxxInfo.getJssj())){
			throw new ServiceException("结束时间不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(dlxxInfo.getImgid())){
			throw new ServiceException("图片不能为空，请重新上传！");
		}
		if(StringUtil.isEmpty(dlxxInfo.getZtnr())){
		
			throw new ServiceException("主题简介不能为空，请重新输入！");
		}
		if(StringUtil.isEmpty(dlxxInfo.getContent())){
			throw new ServiceException("内容正文不能为空，请重新输入！");
		}
		
		DlxxInfo saveDlxxInfo=new DlxxInfo();
		saveDlxxInfo.setKssj(dlxxInfo.getKssj());
		saveDlxxInfo.setJssj(dlxxInfo.getJssj());
		saveDlxxInfo.setImgid(dlxxInfo.getImgid());
		saveDlxxInfo.setXgsj(DateUtil.getCurrentDateTimeStr());
	
		saveDlxxInfo.setTitle(dlxxInfo.getTitle());
		saveDlxxInfo.setShzt(SjztEnum.DSH.getCode());
		saveDlxxInfo.setZtnr(dlxxInfo.getZtnr());
		saveDlxxInfo.setContent(dlxxInfo.getContent());
		if(StringUtil.isEmpty(dlxxInfo.getWid())){
			saveDlxxInfo.setWid(StringUtil.getUuId());
			saveDlxxInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			saveDlxxInfo.setYhid(log.getCompanyId());
			
			this.insertSelective(saveDlxxInfo, log);
		}else{
			check(dlxxInfo.getWid(),log);
			saveDlxxInfo.setWid(dlxxInfo.getWid());
			this.updateByPrimaryKeySelective(saveDlxxInfo, log);
		}
		return DataResult.success(1);
	}
	
	private void check(String wid,CustomOperateLog log){
		DlxxInfo oldDlxxInfo=this.selectByPrimaryKey(wid, log).getDatas();
		if(!log.getCompanyId().equals(oldDlxxInfo.getYhid())){
			throw new ServiceException("该信息不是您发布的信息，请重新确认！");
			
		}
		if(!SjztEnum.WTG.getCode().equals(oldDlxxInfo.getShzt()) && !SjztEnum.CG.getCode().equals(oldDlxxInfo.getShzt())){
			throw new ServiceException("该信息无法修改，请重新确认!");
		}
	}

	@Override
	public DataResult<Integer> delete(String wid, CustomOperateLog log) throws ServiceException {
		check(wid,log);
		return this.deleteByPrimaryKey(wid, log);
	}
}
