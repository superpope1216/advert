package com.pope.advert.controller.gggl.bzzy;

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
import com.pope.advert.entity.gggl.bzzy.BzzyExtInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyGsygInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyJyInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyRwInfo;
import com.pope.advert.entity.gggl.bzzy.BzzyXbmggInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyExtInfo;
import com.pope.advert.entity.gggl.gbzy.GbzyInfo;
import com.pope.advert.entity.gggl.gbzy.GbzySdInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyJyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.bzzy.BzzyXbmggInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("bzzyPublishing")
public class BzzyPublishingController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private BzzyGsygInfoService bzzyGsygInfoService;
	@Autowired
	private BzzyXbmggInfoService bzzyXbmggInfoService;
	@Autowired
	private BzzyRwInfoService bzzyRwInfoService;
	@Autowired
	private BzzyJyInfoService bzzyJyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/bzzy/publishing");
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("bzlx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZLX, null));
		mv.addObject("xbmgglx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_XBMGGLX, null));
		mv.addObject("bzys", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_BZYS, null));
		return mv;
	}
	
	@InitBinder("bzzyInfo")
	public void initBinderBzzyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@InitBinder("bzzyExtInfo")
	public void initBinderBzzyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyExtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@InitBinder("bzzyGsygInfo")
	public void initBinderBzzyGsygForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyGsygInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@ResponseBody
	@RequestMapping("publishingBzzyGsyg")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyGsyg(BzzyInfo bzzyInfo,BzzyGsygInfo bzzyGsygInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyGsygInfoService.publishing(bzzyInfo, bzzyGsygInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyXbmggInfo")
	public void initBinderBzzyXbmggForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyXbmggInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyXbmgg")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyXbmgg(BzzyInfo bzzyInfo,BzzyXbmggInfo bzzyXbmggInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyXbmggInfoService.publishing(bzzyInfo, bzzyXbmggInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyRwInfo")
	public void initBinderBzzyRwForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyRwInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyRw")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyRw(BzzyInfo bzzyInfo,BzzyRwInfo bzzyRwInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyRwInfoService.publishing(bzzyInfo, bzzyRwInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("bzzyJyInfo")
	public void initBinderBzzyJyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("bzzyJyInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingBzzyJy")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingBzzyJy(BzzyInfo bzzyInfo,BzzyJyInfo bzzyJyInfo,BzzyExtInfo bzzyExtInfo) throws Exception{
		return bzzyJyInfoService.publishing(bzzyInfo, bzzyJyInfo,bzzyExtInfo,this.createCustomOperateLog());
	}
}
