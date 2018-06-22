package com.pope.advert.service.cwgl.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.code.ZfztEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.cwgl.CwglCzjlInfoMapper;
import com.pope.advert.dao.cwgl.extend.CwglCzjlInfoExtendMapper;
import com.pope.advert.entity.cwgl.CwglCzjlInfo;
import com.pope.advert.entity.cwgl.CwglDjxxInfo;
import com.pope.advert.entity.cwgl.extend.CwglCzjlInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.service.cwgl.CwglCzjlInfoService;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.OrderNoInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.DecimalUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("cwglCzjlInfoService")
public class CwglCzjlInfoServiceImpl implements CwglCzjlInfoService{
	@Autowired
	private CwglCzjlInfoMapper cwglCzjlInfoMapper;
	
	@Autowired
	private CwglCzjlInfoExtendMapper cwglCzjlInfoExtendMapper;
	@Autowired
	private OrderNoInfoService orderNoInfoService;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;
	@Override
	public DataResult<Integer> deleteByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglCzjlInfoMapper.deleteByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> insertSelective(CwglCzjlInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglCzjlInfoMapper.insertSelective(record));
	}

	@Override
	public DataResult<CwglCzjlInfo> selectByPrimaryKey(String wid,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglCzjlInfoMapper.selectByPrimaryKey(wid));
	}

	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(CwglCzjlInfo record,CustomOperateLog log) throws ServiceException {
		return DataResult.success(cwglCzjlInfoMapper.updateByPrimaryKeySelective(record));
	}

	@Override
	public DataResult<List<CwglCzjlInfoExtend>> selectByCondition(QueryCondition<CwglCzjlInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<CwglCzjlInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<CwglCzjlInfoExtend> datas = cwglCzjlInfoExtendMapper.selectByCondition(condition);

            DataResult<List<CwglCzjlInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(cwglCzjlInfoExtendMapper.selectByCondition(condition));
        }
	}

	@Override
	public DataResult<String> recharge(String djid,Integer nx, CustomOperateLog log) throws ServiceException {
		CwglDjxxInfo cwglDjxxInfo=cwglDjxxInfoService.selectByPrimaryKey(djid, log).getDatas();
		if(cwglDjxxInfo==null) {
			throw new ServiceException("该会员等级已不存在，请重新确认！");
		}
		
		BigDecimal je=DecimalUtil.mul(cwglDjxxInfo.getFy(), DecimalUtil.toDecimal(StringUtil.toStr(nx)));
		
		CwglCzjlInfoExtend queryCwglCzjlInfoExtend=new CwglCzjlInfoExtend();
		List<String> orders=new ArrayList<String>();
		orders.add("t_advert_cwgl_czjl.jssj desc");
		queryCwglCzjlInfoExtend.setYhid(log.getUserId());
		QueryCondition<CwglCzjlInfoExtend> condition=ConditionUtil.createCondition(queryCwglCzjlInfoExtend);
		condition.setPageInfo(new PageInfo(1,1));
		condition.setQuery(queryCwglCzjlInfoExtend);
		condition.setOrderBy(orders);
		List<CwglCzjlInfoExtend> czjlDatas=this.selectByCondition(condition, log).getDatas();
		String kssj="";
		String jssj="";
		if(CommonUtil.isNotEmptyList(czjlDatas)) {
			String lastJssj=czjlDatas.get(0).getJssj();
			long dayCount=DateUtil.getDaysBetween(lastJssj, DateUtil.getCurrentDateStr());
			if(dayCount>0) {
				kssj=DateUtil.getCurrentDateStr();
			}else {
				kssj=DateUtil.addDate(DateUtil.parseDate(lastJssj),1);
			}
		}else {
			kssj=DateUtil.getCurrentDateStr();
		}
		jssj=DateUtil.addYear(kssj, nx);
		String wid=StringUtil.getUuId();
		String orderNo=orderNoInfoService.getMaxOrderNo(log).getDatas();
		CwglCzjlInfo saveCwglCzjlInfo=new CwglCzjlInfo();
		saveCwglCzjlInfo.setCjsj(DateUtil.getCurrentDateTimeStr());
		saveCwglCzjlInfo.setDdbh(orderNo);
		saveCwglCzjlInfo.setDj(djid);
		saveCwglCzjlInfo.setIp(log.getCustomIp());
		saveCwglCzjlInfo.setJe(je);
		saveCwglCzjlInfo.setJssj(jssj);
		saveCwglCzjlInfo.setKssj(kssj);
		saveCwglCzjlInfo.setNx(nx);
		saveCwglCzjlInfo.setWid(wid);
		saveCwglCzjlInfo.setYhid(log.getUserId());
		saveCwglCzjlInfo.setZfbbh("");
		saveCwglCzjlInfo.setZfzt(ZfztEnum.DZF.getCode());
		this.insertSelective(saveCwglCzjlInfo, log);
		return DataResult.success(wid);
		
		
	}

	@Override
	public DataResult<List<CwglCzjlInfoExtend>> selectDisplayByCondition(QueryCondition<CwglCzjlInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
            Page<CwglCzjlInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
            		condition.getPageInfo().getPageSize());
            List<CwglCzjlInfoExtend> datas = cwglCzjlInfoExtendMapper.selectDisplayByCondition(condition);

            DataResult<List<CwglCzjlInfoExtend>> dataResult = DataResult.success(datas);
            dataResult.setPageInfo(PageUtil.changePageInfo(page));
            return dataResult;
        } else {
            return DataResult.success(cwglCzjlInfoExtendMapper.selectDisplayByCondition(condition));
        }
	}

}
