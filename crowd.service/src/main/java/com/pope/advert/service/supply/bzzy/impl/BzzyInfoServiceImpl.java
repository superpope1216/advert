package com.pope.advert.service.supply.bzzy.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.gggl.bzzy.BzzyInfoMapper;
import com.pope.advert.dao.gggl.bzzy.extend.BzzyInfoExtendMapper;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.sjgl.ZbxxInfo;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.sjgl.impl.ZbxxInfoServiceImpl;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.impl.BaseSupplyInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.MapUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;
import com.wisedu.crowd.common.util.ThreadUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Service("bzzyInfoService")
public class BzzyInfoServiceImpl extends BaseSupplyInfoService implements BzzyInfoService {
	private final Logger LOG = LoggerFactory.getLogger(ZbxxInfoServiceImpl.class);


	@Autowired
	private BzzyInfoMapper bzzyInfoMapper;

	@Autowired
	private BzzyInfoExtendMapper bzzyInfoExtendMapper;
	@Autowired
	private SupplyInfoService supplyInfoService;

	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(BzzyInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<BzzyInfo> selectByPrimaryKey(String wid, CustomOperateLog log) throws ServiceException {
		return DataResult.success(bzzyInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(BzzyInfo record, CustomOperateLog log)
			throws ServiceException {
		return DataResult.success(bzzyInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<BzzyInfoExtend>> selectDisplayByCondition(QueryCondition<BzzyInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<BzzyInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<BzzyInfoExtend> datas = bzzyInfoExtendMapper.selectDisplayByCondition(condition);

			DataResult<List<BzzyInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(bzzyInfoExtendMapper.selectDisplayByCondition(condition));

		}

	}

	@Override
	public DataResult<Integer> sh(String wid, String shzt, CustomOperateLog log) throws ServiceException {
		
		this.shSupply(wid,shzt, log);
		
		BzzyInfo saveBzzyInfo = new BzzyInfo();
		saveBzzyInfo.setWid(wid);
		saveBzzyInfo.setShzt(shzt);
		DataResult<Integer> datas=this.updateByPrimaryKeySelective(saveBzzyInfo, log);
		
		supplyInfoService.sendMsg(wid, shzt, log);
		
		return datas;
	}

	@Override
	protected String getUserIdByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getRegisterId();
	}

	@Override
	protected String getShztByWid(String wid, CustomOperateLog log) throws ServiceException {
		return this.selectByPrimaryKey(wid, log).getDatas().getShzt();
	}

}
