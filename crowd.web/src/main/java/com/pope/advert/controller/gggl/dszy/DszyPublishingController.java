package com.pope.advert.controller.gggl.dszy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.gggl.DszyExtInfo;
import com.pope.advert.entity.gggl.DszyGmInfo;
import com.pope.advert.entity.gggl.DszyInfo;
import com.pope.advert.entity.gggl.DszyLmInfo;
import com.pope.advert.entity.gggl.DszySdInfo;
import com.pope.advert.entity.gggl.DszyTbInfo;
import com.pope.advert.entity.gggl.DszyZzInfo;
import com.pope.advert.entity.gggl.DszyZtInfo;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyGmInfoService;
import com.pope.advert.service.supply.DszyLmInfoService;
import com.pope.advert.service.supply.DszySdInfoService;
import com.pope.advert.service.supply.DszyTbInfoService;
import com.pope.advert.service.supply.DszyZtInfoService;
import com.pope.advert.service.supply.DszyZzInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;

@Controller
@RequestMapping("dszyPublishing")
public class DszyPublishingController extends BaseController{

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private DszySdInfoService dszySdInfoService;
	
	@Autowired
	private DszyLmInfoService dszyLmInfoService;
	@Autowired
	private DszyTbInfoService dszyTbInfoService;
	@Autowired
	private DszyZtInfoService dszyZtInfoService;
	@Autowired
	private DszyGmInfoService dszyGmInfoService;
	@Autowired
	private DszyZzInfoService dszyZzInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gggl/dszy/publishing");
		mv.addObject("ggxs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGXS, null));
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("hy", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_HY, null));
		mv.addObject("ggdlfs", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GGDLFS, null));
		mv.addObject("tbbccslx", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_TBBCCSLX, null));
		mv.addObject("ztsjd", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_ZTSJD, null));
		mv.addObject("gmggjgpc", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_GMGGJGPC, null));
		
		
		return mv;
	}
	
	@InitBinder("dszySdInfo")
	public void initBinderDszySdForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszySdInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	
	@InitBinder("dszyInfo")
	public void initBinderDszyForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyInfo.");
	}
	@InitBinder("dszyExtInfo")
	public void initBinderDszyExtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyExtInfo.");
	}
	@ResponseBody
	@RequestMapping("publishingDszySd")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszySd(DszyInfo dszyInfo,DszySdInfo dszySdInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszySdInfoService.publishing(dszyInfo, dszySdInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyLmInfo")
	public void initBinderDszyLmForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyLmInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyLm")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyLm(DszyInfo dszyInfo,DszyLmInfo dszyLmInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyLmInfoService.publishing(dszyInfo, dszyLmInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyTbInfo")
	public void initBinderDszyTbForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyTbInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyTb")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyTb(DszyInfo dszyInfo,DszyTbInfo dszyTbInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyTbInfoService.publishing(dszyInfo, dszyTbInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyZtInfo")
	public void initBinderDszyZtForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyZtInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyZt")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyZt(DszyInfo dszyInfo,DszyZtInfo dszyZtInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyZtInfoService.publishing(dszyInfo, dszyZtInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	
	@InitBinder("dszyGmInfo")
	public void initBinderDszyGmForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyGmInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyGm")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyGm(DszyInfo dszyInfo,DszyGmInfo dszyGmInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyGmInfoService.publishing(dszyInfo, dszyGmInfo,dszyExtInfo,this.createCustomOperateLog());
	}
	@InitBinder("dszyZzInfo")
	public void initBinderDszyZzForm(WebDataBinder binder){
		binder.setFieldDefaultPrefix("dszyZzInfo.");
		binder.registerCustomEditor(Date.class,   new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}
	@ResponseBody
	@RequestMapping("publishingDszyZz")
	@AuthIsSupplyAnnotation
	public DataResult<Integer> publishingDszyZz(DszyInfo dszyInfo,DszyZzInfo dszyZzInfo,DszyExtInfo dszyExtInfo) throws Exception{
		return dszyZzInfoService.publishing(dszyInfo, dszyZzInfo,dszyExtInfo,this.createCustomOperateLog());
	}
}
