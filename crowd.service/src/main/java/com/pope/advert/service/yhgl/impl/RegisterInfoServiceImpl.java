package com.pope.advert.service.yhgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.common.exception.ResponseCode;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.yhgl.RegisterInfoMapper;
import com.pope.advert.dao.yhgl.extend.RegisterInfoExtendMapper;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringEncrypt;
import com.wisedu.crowd.common.util.StringUtil;

@Service("registerInfoService")
public class RegisterInfoServiceImpl implements RegisterInfoService {

	@Autowired
	private RegisterInfoMapper registerInfoMapper;

	@Autowired
	private RegisterInfoExtendMapper registerInfoExtendMapper;
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoServie;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(registerInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(RegisterInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(registerInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<RegisterInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(registerInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(RegisterInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(registerInfoMapper.updateByPrimaryKeySelective(record));
	}

	public DataResult<RegisterInfoExtend> register(RegisterInfoExtend yhjbxxInfo, String confirmPassword,
			CustomOperateLog log) throws ServiceException {
		if (yhjbxxInfo == null) {
			throw new ServiceException(ResponseCode.error.getMsg());
		}

		if (StringUtil.isEmpty(yhjbxxInfo.getYhm())) {
			throw new ServiceException("用户名不能为空！");
		}
		if (StringUtil.isEmpty(yhjbxxInfo.getSjh())) {
			throw new ServiceException("手机号不能为空！");
		}
		if (StringUtil.isEmpty(yhjbxxInfo.getEmail())) {
			throw new ServiceException("邮箱不能为空！");
		}
		if (StringUtil.isEmpty(yhjbxxInfo.getMm())) {
			throw new ServiceException("密码不能为空！");
		}
		if (StringUtil.isEmpty(confirmPassword.trim())) {
			throw new ServiceException("确认密码不能为空！");
		}
		if (!yhjbxxInfo.getMm().trim().equals(confirmPassword.trim())) {
			throw new ServiceException("两次输入的秘密不一致！");
		}

		RegisterInfoExtend queryRegisterInfoExtend = new RegisterInfoExtend();
		queryRegisterInfoExtend.setYhm(yhjbxxInfo.getYhm());
		List<RegisterInfoExtend> datas = this
				.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend), log).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			throw new ServiceException("用户名已存在，请重新确认！");
		}
		RegisterInfoExtend saveRegisterInfoExtend = new RegisterInfoExtend();

		saveRegisterInfoExtend.setWid(StringUtil.getUuId());
		saveRegisterInfoExtend.setCzsj(DateUtil.getCurrentDateTimeStr());
		saveRegisterInfoExtend.setCzip(log.getCustomIp());
		saveRegisterInfoExtend.setEmail(yhjbxxInfo.getEmail());
		saveRegisterInfoExtend.setYhm(yhjbxxInfo.getYhm());
		saveRegisterInfoExtend.setMm(StringEncrypt.encrypt(yhjbxxInfo.getMm()));
		saveRegisterInfoExtend.setSjh(yhjbxxInfo.getSjh());
		System.out.println("=====================================" + saveRegisterInfoExtend.getMm().length());
		this.insertSelective(saveRegisterInfoExtend, log);
		return DataResult.success(saveRegisterInfoExtend);
	}

	@Override
	public DataResult<List<RegisterInfoExtend>> selectByCondition(QueryCondition<RegisterInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<RegisterInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<RegisterInfoExtend> datas = registerInfoExtendMapper.selectByCondition(condition);

			DataResult<List<RegisterInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(registerInfoExtendMapper.selectByCondition(condition));
		}

	}

	@Override
	public DataResult<RegisterInfoExtend> login(String userName, String password, CustomOperateLog log)
			throws ServiceException {
		if (StringUtil.isEmpty(userName)) {
			throw new ServiceException("用户名称不能为空！");
		}
		if (StringUtil.isEmpty(password)) {
			throw new ServiceException("密码不能为空！");
		}
		RegisterInfoExtend queryRegisterInfoExtend = new RegisterInfoExtend();
		queryRegisterInfoExtend.setYhm(userName.trim());
		List<RegisterInfoExtend> datas = this
				.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend), log).getDatas();
		if (CommonUtil.isEmptyList(datas)) {
			throw new ServiceException("用户名/密码错误，请重新确认！");
		} else {
			RegisterInfoExtend registerInfoExtend = datas.get(0);
			if (!registerInfoExtend.getMm().equals(StringEncrypt.encrypt(password))) {
				throw new ServiceException("用户名/密码错误，请重新确认！");
			}
		}
		datas.get(0).setMm("");
		

		return DataResult.success(datas.get(0));
	}

	@Override
	public DataResult<RegisterInfoExtend> loginAdmin(String userName, String password, CustomOperateLog log)
			throws ServiceException {
		if (StringUtil.isEmpty(userName)) {
			throw new ServiceException("用户名称不能为空！");
		}
		if (StringUtil.isEmpty(password)) {
			throw new ServiceException("密码不能为空！");
		}
		RegisterInfoExtend queryRegisterInfoExtend = new RegisterInfoExtend();
		queryRegisterInfoExtend.setYhm(userName.trim());
		List<RegisterInfoExtend> datas = this
				.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend), log).getDatas();
		if (CommonUtil.isEmptyList(datas)) {
			throw new ServiceException("用户名/密码错误，请重新确认！");
		} else {
			RegisterInfoExtend registerInfoExtend = datas.get(0);
			if (!registerInfoExtend.getMm().equals(StringEncrypt.encrypt(password))) {
				throw new ServiceException("用户名/密码错误，请重新确认！");
			}
			if (!YesNoEnum.YES.getCode().equals(registerInfoExtend.getAdminFlag())) {
				throw new ServiceException("您不是系统管理员，无法登陆系统，请重新确认！");
			}
		}
		datas.get(0).setMm("");
		return DataResult.success(datas.get(0));
	}

	@Override
	public DataResult<Integer> resetPwd(String phone, String password, String confirmPassword, CustomOperateLog log)
			throws ServiceException {
		if (StringUtil.isEmpty(phone)) {
			throw new ServiceException(-6, "手机号不能为空，请输入");
		}
		if (StringUtil.isEmpty(password)) {
			throw new ServiceException(-4, "密码不能为空，请输入");
		}
		if (StringUtil.isEmpty(password)) {
			throw new ServiceException(-5, "确认密码不能为空，请输入");
		}
		if (!password.equals(confirmPassword)) {
			throw new ServiceException(-5, "两次输入密码不一致，请输入");
		}
		RegisterInfoExtend registerInfoExtend = new RegisterInfoExtend();
		registerInfoExtend.setSjh(phone);
		List<RegisterInfoExtend> datas = this.selectByCondition(ConditionUtil.createCondition(registerInfoExtend), log)
				.getDatas();
		if (CommonUtil.isEmptyList(datas)) {
			throw new ServiceException("该手机号不存在，请重新确认！");
		}
		RegisterInfo saveRegisterInfo = new RegisterInfo();
		saveRegisterInfo.setWid(datas.get(0).getWid());
		saveRegisterInfo.setMm(StringEncrypt.encrypt(password));
		return this.updateByPrimaryKeySelective(saveRegisterInfo, log);
	}

}
