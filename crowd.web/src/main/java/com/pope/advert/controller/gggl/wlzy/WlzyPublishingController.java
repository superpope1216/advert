package com.pope.advert.controller.gggl.wlzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("wlzyPublishing")
public class WlzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/wlzy/publishing");
		mv.addObject("zywz", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_WLGZWZ, null));
		
		return mv;
	}
}
