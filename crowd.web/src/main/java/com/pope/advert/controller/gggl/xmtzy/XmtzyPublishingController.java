package com.pope.advert.controller.gggl.xmtzy;

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
@RequestMapping("xmtzyPublishing")
public class XmtzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/xmtzy/publishing");
		mv.addObject("xmtlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTLX, null));
		mv.addObject("szrq", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SZRQ, null));
		mv.addObject("jycd", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_JYCD, null));
		mv.addObject("zyfb", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_ZYFB, null));
		mv.addObject("srzk", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XMTZY_SRZK, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		return mv;
	}
}
