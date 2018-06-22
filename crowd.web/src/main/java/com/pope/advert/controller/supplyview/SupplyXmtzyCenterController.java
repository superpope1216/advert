package com.pope.advert.controller.supplyview;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.SupplyClassifyEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.dto.QueryCondition;
import com.pope.advert.entity.gggl.SupplyCondition;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.SupplyInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyXmtzyCenter")
public class SupplyXmtzyCenterController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private SupplyInfoService supplyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String flag,String queryGgxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("supplyview/xmtzyCenter");
		mv.addObject("flag", flag);
		if(StringUtil.isEmpty(queryGgxs)){
			queryGgxs="";
		}
		mv.addObject("queryGgxs",queryGgxs);
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gglx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGLX, null));
		mv.addObject("xmtlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTLX, null));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("list")
	public DataResult<List<Map<String,Object>>> list(String ggxs,String areaBm,String cityBm,String dst,Integer pageSize,Integer pageNum) throws Exception{
		SupplyInfo querySupplyInfo=new SupplyInfo();
		querySupplyInfo.setGglx(SupplyClassifyEnum.XMTGG.getCode());
		querySupplyInfo.setShzt(ShztEnum.YTG.getCode());
		if(!StringUtil.isEmpty(ggxs)){
			querySupplyInfo.setAdvertType(ggxs);
		}
		if(!StringUtil.isEmpty(areaBm)){
			querySupplyInfo.setArea(areaBm);
		}
		if(!StringUtil.isEmpty(cityBm)){
			querySupplyInfo.setCity(cityBm);
		}
		if(!StringUtil.isEmpty(dst)){
			querySupplyInfo.setTvId(dst);
		}
		querySupplyInfo.setNeedHy(true);
		QueryCondition<SupplyInfo> condition=new QueryCondition<SupplyInfo>();
		condition.setPageInfo(new PageInfo(pageSize,pageNum));
		condition.setQuery(querySupplyInfo);
		return supplyInfoService.selectByCondition(condition, this.createCustomOperateLog());
	}
}
