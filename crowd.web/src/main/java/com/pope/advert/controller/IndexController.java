package com.pope.advert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.service.dictionary.DictionaryService;

@Controller

public class IndexController {

	@Autowired
	private DictionaryService dictionaryService;
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("hwggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HWZY_LX, null));
		mv.addObject("dsggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGXS, null));
		mv.addObject("gbggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GBLX, null));
		mv.addObject("bzggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZLX, null));
		mv.addObject("zzggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_ZZZYLX, null));
		mv.addObject("wlggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_WLGZWZ, null));
		mv.addObject("xmtggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTLX, null));
		return mv;
	}
}
