package com.pope.advert.controller.yhgl.yhxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.YesNoEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("companyMapInfo")
public class CompanyMapInfoController extends BaseController {


	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		if("1".equals(flag)){
			mv.setViewName("yhgl/yhxx/companyMapInfo");
		}else{
			mv.setViewName("yhgl/yhxx/buy/companyMapInfo");
		}
		
		mv.addObject("areaSelect", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("area", StringUtil.toStr(this.getCompanyInfo().getArea()));
		mv.addObject("areaDisplay", StringUtil.toStr(this.getCompanyInfo().getAreaDisplay()));
		mv.addObject("city", StringUtil.toStr(this.getCompanyInfo().getCity()));
		mv.addObject("cityDisplay", StringUtil.toStr(this.getCompanyInfo().getCityDisplay()));
		mv.addObject("xian",StringUtil.toStr( this.getCompanyInfo().getXian()));
		mv.addObject("xianDisplay",StringUtil.toStr( this.getCompanyInfo().getXianDisplay()));
		mv.addObject("companyInfo",this.getCompanyInfo());
		if(!StringUtil.isEmpty(this.getCompanyInfo().getArea())){
			mv.addObject("citySelect", dictionaryService.selectAreaByParent(this.getCompanyInfo().getArea(), this.createCustomOperateLog()).getDatas());
		}
		if(!StringUtil.isEmpty(this.getCompanyInfo().getCity())){
			mv.addObject("xianSelect", dictionaryService.selectAreaByParent(this.getCompanyInfo().getCity(), this.createCustomOperateLog()).getDatas());
		}
		mv.addObject("sfybz", StringUtil.toStr(this.getCompanyInfo().getSfybz()));
		mv.addObject("lng", StringUtil.toStr(this.getCompanyInfo().getLng()));
		mv.addObject("lat", StringUtil.toStr(this.getCompanyInfo().getLat()));
		return mv;
	}
	@AuthSupplyAnnotation
	@ResponseBody
	@RequestMapping("save")
	public DataResult<Integer> save(String lng,String lat) throws Exception{
		CompanyInfo saveCompanyInfo=new CompanyInfo();
		saveCompanyInfo.setWid(this.getCompanyInfo().getWid());
		saveCompanyInfo.setSfybz(YesNoEnum.YES.getCode());
		saveCompanyInfo.setLng(lng);
		saveCompanyInfo.setLat(lat);
		companyInfoService.updateByPrimaryKeySelective(saveCompanyInfo, this.createCustomOperateLog());
		CompanyInfoExtend companyInfoExtend=this.getCompanyInfo();
		companyInfoExtend.setSfybz(YesNoEnum.YES.getCode());
		companyInfoExtend.setLng(lng);
		companyInfoExtend.setLat(lat);
		request.setAttribute(ConstantsUtil.SESSION_COMPANY, companyInfoExtend);
		return DataResult.success(1);
	}
}
