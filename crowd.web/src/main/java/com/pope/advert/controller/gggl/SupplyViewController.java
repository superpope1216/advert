package com.pope.advert.controller.gggl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyView")
public class SupplyViewController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszyInfoService dszyInfoService;
	@Autowired
	private SupplyInfoService supplyInfoService;
	
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String key) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("key", key);
		mv.setViewName("gggl/index");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("list")
	@AuthSupplyAnnotation
	public DataResult<List<Map<String,Object>>> list(Integer pageNum,String gglx,String condition) throws Exception{
		//return dszyInfoService.selectDisplayViewByCondition(condition, this.getYhjbxx().getWid(), this.createCustomOperateLog());
		SupplyInfo querySupplyInfo=new SupplyInfo();
		if(!StringUtil.isEmpty(condition)){
			querySupplyInfo.setName(condition);
		}
		querySupplyInfo.setRegisterId(this.getYhId());
		querySupplyInfo.setGglx(gglx);
		return supplyInfoService.selectByCondition(ConditionUtil.createCondition(querySupplyInfo,new PageInfo(null,pageNum)), this.createCustomOperateLog());
	}
	@ResponseBody
	@RequestMapping("listCount")
	@AuthSupplyAnnotation
	public DataResult<List<Map<String,Object>>> listCount() throws Exception{
		List<DictionaryInfo> gglx=dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_LX, null);
		SupplyInfo querySupplyInfo=new SupplyInfo();
		Integer all=supplyInfoService.selectCountByCondition(ConditionUtil.createCondition(querySupplyInfo), this.createCustomOperateLog()).getDatas();
		all=StringUtil.toInt(all, 0);
		List<Map<String,Object>> lst=new ArrayList<Map<String,Object>>();
		Map<String,Object> allMap=new HashMap<String,Object>();
		allMap.put("count", all);
		allMap.put("gglx", "");
		allMap.put("name","全部广告");
		lst.add(allMap);
		if(CommonUtil.isNotEmptyList(gglx)){
			for(DictionaryInfo info:gglx){
				Map<String,Object> map=new HashMap<String,Object>();
				querySupplyInfo.setGglx(info.getLbdm());
				Integer count=supplyInfoService.selectCountByCondition(ConditionUtil.createCondition(querySupplyInfo), this.createCustomOperateLog()).getDatas();
				count=StringUtil.toInt(count, 0);
				map.put("count", count);
				map.put("gglx", info.getLbdm());
				map.put("name", info.getLbmc());
				lst.add(map);
			}
		}
		return DataResult.success(lst);
	}
	
}
