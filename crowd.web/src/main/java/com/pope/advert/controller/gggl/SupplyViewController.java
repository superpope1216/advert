package com.pope.advert.controller.gggl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyInfoService;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("supplyView")
public class SupplyViewController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszyInfoService dszyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String key) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("key", key);
		mv.setViewName("gggl/index");
		mv.addObject("gglx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_LX, null));
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("list")
	public DataResult<List<Map<String,Object>>> list(String condition) throws Exception{
		return dszyInfoService.selectDisplayViewByCondition(condition, this.getYhjbxx().getWid(), this.createCustomOperateLog());
	}
}
