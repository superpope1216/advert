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
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyWlzyCenter")
public class SupplyWlzyCenterController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszyInfoService dszyInfoService;
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
		SupplyCondition supplyConditon=new SupplyCondition();
		DszyInfoExtend queryDszyInfoExtend=new DszyInfoExtend();
		if(!StringUtil.isEmpty(ggxs)){
			queryDszyInfoExtend.setAdvertType(ggxs);
		}
		if(!StringUtil.isEmpty(areaBm)){
			queryDszyInfoExtend.setArea(areaBm);
		}
		if(!StringUtil.isEmpty(cityBm)){
			queryDszyInfoExtend.setCity(cityBm);
		}
		if(!StringUtil.isEmpty(dst)){
			queryDszyInfoExtend.setTvId(dst);
		}
		supplyConditon.setDszyInfoExtend(queryDszyInfoExtend);
		QueryCondition<SupplyCondition> condition=new QueryCondition<SupplyCondition>();
		condition.setPageInfo(new PageInfo(pageSize,pageNum));
		condition.setQuery(supplyConditon);
		return dszyInfoService.selectDisplayByCondtion(condition,this.createCustomOperateLog());
	}
}
