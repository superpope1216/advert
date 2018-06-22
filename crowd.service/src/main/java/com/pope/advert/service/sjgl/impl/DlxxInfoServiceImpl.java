package com.pope.advert.service.sjgl.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.sjgl.DlxxInfoMapper;
import com.pope.advert.dao.sjgl.HzxxInfoMapper;
import com.pope.advert.dao.sjgl.extend.DlxxInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.qyzx.impl.QyzxNewsInfoServiceImpl;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
import com.wisedu.crowd.common.util.ThreadUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Service("dlxxInfoService")
public class DlxxInfoServiceImpl implements DlxxInfoService {
	private final Logger LOG = LoggerFactory.getLogger(DlxxInfoServiceImpl.class);
	@Autowired
	private DlxxInfoMapper dlxxInfoMapper;
	@Autowired
	private DlxxInfoExtendMapper dlxxInfoExtendMapper;
	@Autowired
	private SmsSendMessage smsSendMessage;
	@Autowired
	private RegisterInfoService registerInfoService;

	@Autowired
	private CompanyInfoService companyInfoService;

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
	public DataResult<Integer> publishing(DlxxInfo dlxxInfo, CustomOperateLog log) throws ServiceException {
		if (StringUtil.isEmpty(dlxxInfo.getTitle())) {
			throw new ServiceException("标题不能为空，请重新输入！");
		}
		if (StringUtil.isEmpty(dlxxInfo.getKssj())) {
			throw new ServiceException("开始时间不能为空，请重新输入！");
		}
		if (StringUtil.isEmpty(dlxxInfo.getJssj())) {
			throw new ServiceException("结束时间不能为空，请重新输入！");
		}
		if (StringUtil.isEmpty(dlxxInfo.getImgid())) {
			throw new ServiceException("图片不能为空，请重新上传！");
		}
		if (StringUtil.isEmpty(dlxxInfo.getZtnr())) {

			throw new ServiceException("主题简介不能为空，请重新输入！");
		}
		if (StringUtil.isEmpty(dlxxInfo.getContent())) {
			throw new ServiceException("内容正文不能为空，请重新输入！");
		}

		DlxxInfo saveDlxxInfo = new DlxxInfo();
		saveDlxxInfo.setKssj(dlxxInfo.getKssj());
		saveDlxxInfo.setJssj(dlxxInfo.getJssj());
		saveDlxxInfo.setImgid(dlxxInfo.getImgid());
		saveDlxxInfo.setXgsj(DateUtil.getCurrentDateTimeStr());

		saveDlxxInfo.setTitle(dlxxInfo.getTitle());
		saveDlxxInfo.setShzt(SjztEnum.DSH.getCode());
		saveDlxxInfo.setZtnr(dlxxInfo.getZtnr());
		saveDlxxInfo.setContent(dlxxInfo.getContent());
		if (StringUtil.isEmpty(dlxxInfo.getWid())) {
			saveDlxxInfo.setWid(StringUtil.getUuId());
			saveDlxxInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
			saveDlxxInfo.setYhid(log.getCompanyId());

			this.insertSelective(saveDlxxInfo, log);
		} else {
			check(dlxxInfo.getWid(), log);
			saveDlxxInfo.setWid(dlxxInfo.getWid());
			this.updateByPrimaryKeySelective(saveDlxxInfo, log);
		}
		return DataResult.success(1);
	}

	private void check(String wid, CustomOperateLog log) {
		if (log.getIsAdmin()) {
			return;
		}
		DlxxInfo oldDlxxInfo = this.selectByPrimaryKey(wid, log).getDatas();
		if (!log.getCompanyId().equals(oldDlxxInfo.getYhid())) {
			throw new ServiceException("该信息不是您发布的信息，请重新确认！");

		}
		// if(!SjztEnum.WTG.getCode().equals(oldDlxxInfo.getShzt()) &&
		// !SjztEnum.CG.getCode().equals(oldDlxxInfo.getShzt())){
		// throw new ServiceException("该信息无法修改，请重新确认!");
		// }
	}

	@Override
	public DataResult<Integer> delete(String wid, CustomOperateLog log) throws ServiceException {
		check(wid, log);
		return this.deleteByPrimaryKey(wid, log);
	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		DlxxInfo saveDlxxInfo = new DlxxInfo();
		saveDlxxInfo.setWid(wid);
		saveDlxxInfo.setShzt(shzt);
		saveDlxxInfo.setShsj(DateUtil.getCurrentDateTimeStr());
		DataResult<Integer> datas = this.updateByPrimaryKeySelective(saveDlxxInfo, log);
		// 发送消息
		DlxxInfo oldQyzxGgInfo = this.selectByPrimaryKey(wid, log).getDatas();

		CompanyInfo companyInfo = companyInfoService.selectByPrimaryKey(oldQyzxGgInfo.getYhid(), log).getDatas();
		final RegisterInfo registerInfo = registerInfoService.selectByPrimaryKey(companyInfo.getRegisterId(), log)
				.getDatas();
		String message = SmsMessageTempleateEnum.AD_DL.getName();
		String shztName = "审核不通过";
		if (SjztEnum.YTG.getCode().equals(shzt)) {
			shztName = "审核通过";
		}
		message = SmsMessageTempleateEnum.TITLE + String.format(message, oldQyzxGgInfo.getTitle(), shztName);
		final String content = message;
		ThreadUtil.getSortTimeOutThread(new Runnable() {
			@Override
			public void run() {
				try {
					smsSendMessage.sendMessage(registerInfo.getSjh(), content);
				} catch (Exception e) {
					LOG.error("===广告代理信息发送邮件失败===" + e.getMessage());
				}
			}
		});
		return datas;

	}
}
