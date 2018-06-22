package com.pope.advert.controller.buy.qg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.interceptor.AuthBuyAnnotation;
import com.pope.advert.interceptor.AuthIsBuyAnnotation;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("buyQg")
public class BuyQgController extends BaseController{
	@Autowired
	private QgInfoService qgInfoService;
	@RequestMapping("index")
	@AuthBuyAnnotation
	public String index() throws Exception{
		return "buy/qg/index";
	}
	
	@RequestMapping("delete")
	@AuthIsBuyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return qgInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@RequestMapping("list")
	@ResponseBody
	@AuthBuyAnnotation
	public DataResult<List<QgInfoExtend>> list(Integer pageNum,Integer pageSize) throws Exception{
		QgInfoExtend queryQgInfoExtend=new QgInfoExtend();
		queryQgInfoExtend.setRegisterId(this.getYhId());
		return qgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQgInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
}
