package com.pope.advert.controller.yhgl.yhxx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.DateUtil;

@Controller
@RequestMapping("companyInfo")
public class CompanyInfoController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gsxz", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_COMPANYXZ, null));
		mv.addObject("yyed", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_COMPANY_NYYE, null));
		mv.setViewName("yhgl/yhxx/companyInfo");
		return mv;
	}
	
	@RequestMapping("queryCompanyInfo")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<CompanyInfoExtend> queryCompanyInfo() throws Exception{
		CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
		queryCompanyInfoExtend.setRegisterId(this.getYhId());
		List<CompanyInfoExtend> datas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(new CompanyInfoExtend());
		
	}
	
	@RequestMapping("save")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> save(CompanyInfo companyInfo) throws Exception{
		companyInfo.setUpdateMan(this.getYhId());
		companyInfo.setUpdateTime(DateUtil.getCurrentDateTimeStr());
		return companyInfoService.updateByPrimaryKeySelective(companyInfo, this.createCustomOperateLog());
	}
}
