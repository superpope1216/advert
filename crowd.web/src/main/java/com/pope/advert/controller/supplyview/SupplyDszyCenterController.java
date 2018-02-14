package com.pope.advert.controller.supplyview;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;
import com.wisedu.crowd.common.code.SupplyClassifyEnum;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyDszyCenter")
public class SupplyDszyCenterController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszyInfoService dszyInfoService;
	@Autowired
	private SupplyInfoService supplyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("supplyview/dszyCenter");
		mv.addObject("flag", flag);
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gglx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGLX, null));
		mv.addObject("ggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGXS, null));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("list")
	public DataResult<List<Map<String,Object>>> list(String ggxs,String areaBm,String cityBm,String dst,Integer pageSize,Integer pageNum) throws Exception{
		SupplyInfo querySupplyInfo=new SupplyInfo();
		querySupplyInfo.setGglx(SupplyClassifyEnum.DSGG.getCode());
		
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
		QueryCondition<SupplyInfo> condition=new QueryCondition<SupplyInfo>();
		condition.setPageInfo(new PageInfo(pageSize,pageNum));
		condition.setQuery(querySupplyInfo);
		return supplyInfoService.selectByCondition(condition, this.createCustomOperateLog());
	}
}
