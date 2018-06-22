package com.pope.advert.service.xtgl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.dao.xtgl.OrderNoInfoMapper;
import com.pope.advert.dao.xtgl.extend.OrderNoInfoExtendMapper;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.log.CustomOperateLog;
import com.pope.advert.entity.xtgl.OrderNoInfo;
import com.pope.advert.entity.xtgl.extend.OrderNoInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.xtgl.OrderNoInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.PageUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Service("orderNoInfoService")
public class OrderNoInfoServiceImpl implements OrderNoInfoService{
	@Autowired
	private OrderNoInfoMapper orderNoInfoMapper;
	@Autowired
	private OrderNoInfoExtendMapper orderNoInfoExtendMapper;
	
	private Object object=new Object();
	@Override
	public DataResult<Integer> deleteByPrimaryKey(Integer id, CustomOperateLog log) throws ServiceException {
		return DataResult.success(orderNoInfoMapper.deleteByPrimaryKey(id));
	}
	@Override
	public DataResult<Integer> insertSelective(OrderNoInfo record, CustomOperateLog log) throws ServiceException {
		return DataResult.success(orderNoInfoMapper.insertSelective(record));
	}
	@Override
	public DataResult<OrderNoInfo> selectByPrimaryKey(Integer id, CustomOperateLog log) throws ServiceException {
		return DataResult.success(orderNoInfoMapper.selectByPrimaryKey(id));
	}
	@Override
	public DataResult<Integer> updateByPrimaryKeySelective(OrderNoInfo record, CustomOperateLog log)
			throws ServiceException {
		
		return DataResult.success(orderNoInfoMapper.updateByPrimaryKeySelective(record));
	}
	@Override
	public DataResult<List<OrderNoInfoExtend>> selectByCondition(QueryCondition<OrderNoInfoExtend> condition,
			CustomOperateLog log) throws ServiceException {
		if (condition.getPageInfo() != null) {
			Page<ZzzyGsygInfoExtend> page = PageHelper.startPage(condition.getPageInfo().getPageNum(),
					condition.getPageInfo().getPageSize());
			List<OrderNoInfoExtend> datas = orderNoInfoExtendMapper.selectByCondition(condition);

			DataResult<List<OrderNoInfoExtend>> dataResult = DataResult.success(datas);
			dataResult.setPageInfo(PageUtil.changePageInfo(page));
			return dataResult;
		} else {
			return DataResult.success(orderNoInfoExtendMapper.selectByCondition(condition));

		}
	}
	@Override
	public DataResult<String> getMaxOrderNo(CustomOperateLog log)
			throws ServiceException {
		OrderNoInfo saveOrderNoInfo=new OrderNoInfo();
		String orderNo="";
		synchronized (object) {
			OrderNoInfoExtend queryOrderNoInfoExtend=new OrderNoInfoExtend();
			String month=DateUtil.format(DateUtil.getCurrentDate(), "yyyyMM");
			queryOrderNoInfoExtend.setMonth(month);
			List<OrderNoInfoExtend> orderDatas=this.selectByCondition(ConditionUtil.createCondition(queryOrderNoInfoExtend,new PageInfo(1,1)), log).getDatas();
			
			if(CommonUtil.isNotEmptyList(orderDatas)) {
				orderNo=orderDatas.get(0).getOrderno();
				Integer iOrderNo=StringUtil.toInt(orderNo);
				iOrderNo+=1;
				orderNo=StringUtil.autoGenericCode(StringUtil.toStr(iOrderNo), 6);
			}else {
				orderNo=StringUtil.autoGenericCode("1", 6);
			}
			
			
			
			saveOrderNoInfo.setMonth(month);
			saveOrderNoInfo.setOrderno(orderNo);
			saveOrderNoInfo.setType("01");
			saveOrderNoInfo.setWid(StringUtil.getUuId());
			saveOrderNoInfo.setCsjs(DateUtil.getCurrentDateTimeStr());
			saveOrderNoInfo.setIp(log.getCustomIp());
			this.insertSelective(saveOrderNoInfo, log);
			
			
		}
		String newOrder=saveOrderNoInfo.getMonth()+saveOrderNoInfo.getType()+saveOrderNoInfo.getOrderno();
		return DataResult.success(newOrder);
		
	}
	
}
