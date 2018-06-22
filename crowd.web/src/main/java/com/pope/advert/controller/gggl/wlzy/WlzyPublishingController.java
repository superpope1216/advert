package com.pope.advert.controller.gggl.wlzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.wlzy.WlzyInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.wlzy.WlzyInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("wlzyPublishing")
public class WlzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private WlzyInfoService wlzyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid,String gglx,String ggfl) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/wlzy/publishing");
		mv.addObject("wid",StringUtil.toStr(wid));
		mv.addObject("gglx",StringUtil.toStr(gglx));
		mv.addObject("ggfl",StringUtil.toStr(ggfl).equals("")?"1":StringUtil.toStr(ggfl));
		mv.addObject("zywz", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_WLGZWZ, null));
		mv.addObject("zsxt", dictionaryService.selectByCondtion(DictionaryEnum.T_ADAVERT_SJZD_WLZY_XT, null));
		mv.addObject("jffs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADAVERT_SJZD_WLZY_JFFS, null));
		return mv;
	}
	
	@RequestMapping("publishing")
	@AuthIsSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> publishing(WlzyInfo wlzy) throws Exception{
		return wlzyInfoService.publishing(wlzy, this.createCustomOperateLog());
	}
	@ResponseBody
	@AuthIsSupplyAnnotation
	@RequestMapping("select")
	public DataResult<WlzyInfo> select(String wid) throws Exception{
		return wlzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@ResponseBody
	@AuthIsSupplyAnnotation
	@RequestMapping("delete")
	public DataResult<Integer> delete(String wid) throws Exception{
		return wlzyInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
}
