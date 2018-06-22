package com.pope.advert.controller.yhgl.supply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.advert.common.code.SupplyClassifyEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyInfo")
public class SupplyInfoController extends BaseController{

	@Autowired
	private SupplyInfoService supplyInfoService;
	
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<Map<String,Object>>> getList(String gglx,Integer pageNum,Integer pageSize,String companyName,String name,String shzt) throws Exception{
		SupplyInfo querySupplyInfo=new SupplyInfo();
		if(!StringUtil.isEmpty(name)){
			querySupplyInfo.setName(name);
		}
		if(!StringUtil.isEmpty(companyName)){
			querySupplyInfo.setCompanyName(companyName);
		}
		
		//querySupplyInfo.setRegisterId(this.getYhId());
		querySupplyInfo.setGglx(gglx);
		if(!StringUtil.isEmpty(shzt)) {
			querySupplyInfo.setShzt(shzt);
		}
		QueryCondition<SupplyInfo> condition=new QueryCondition<SupplyInfo>();
		condition.setPageInfo(new PageInfo(pageSize,pageNum));
		condition.setQuery(querySupplyInfo);
		DataResult<List<Map<String,Object>>>  datas=supplyInfoService.selectByCondition(condition, this.createCustomOperateLog());
		
		return datas; 
	}
	
}
