package com.pope.advert.controller.gggl.gbzy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyQtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("gbzyPublishing")
public class GbzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private GbzySdInfoService gbzySdInfoService;
	@Autowired
	private GbzyQtInfoService gbzyQtInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/gbzy/publishing");
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gblx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GBLX, null));
		
		return mv;
	}
	
	@InitBinder("gbzyInfo")
	public void initBinderGbzyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("gbzyExtInfo")
	public void initBinderGbzyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyExtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("gbzySdInfo")
	public void initBinderGbzySdForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzySdInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingGbzySd")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingGbzySd(GbzyInfo gbzyInfo,GbzySdInfo gbzySdInfo,GbzyExtInfo gbzyExtInfo) throws Exception{
		return gbzySdInfoService.publishing(gbzyInfo, gbzySdInfo,gbzyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("gbzyQtInfo")
	public void initBinderGbzyQtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("gbzyQtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingGbzyQt")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingGbzyQt(GbzyInfo gbzyInfo,GbzyQtInfo gbzyQtInfo,GbzyExtInfo gbzyExtInfo) throws Exception{
		return gbzyQtInfoService.publishing(gbzyInfo, gbzyQtInfo,gbzyExtInfo,this.createCustomOperateLog());
	}
}
