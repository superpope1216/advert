package com.pope.advert.controller.yhgl.yhxx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.CompanyZzInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;
import com.pope.advert.interceptor.AuthIsSupplyAnnotation;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyZzInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.code.DictionaryEnum;
import com.wisedu.crowd.common.code.YesNoEnum;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("companyZzInfo")
public class CompanyZzInfoController extends BaseController {

	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private CompanyZzInfoService companyZzInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("yhgl/yhxx/companyZzInfo");
		mv.addObject("zzlx", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_COMPANY_ZZLX));
		return mv;
	}
	@ResponseBody
	@AuthIsSupplyAnnotation
	@RequestMapping("save")
	public DataResult<Integer> save(CompanyZzInfo companyZzInfo) throws Exception{
		
		return companyZzInfoService.save(companyZzInfo, this.createCustomOperateLog());
	}
	@ResponseBody
	@AuthSupplyAnnotation
	@RequestMapping("selectOne")
	public DataResult<CompanyZzInfoExtend> selectOne(String wid) throws Exception{
		CompanyZzInfoExtend querCompanyZzInfoExtend=new CompanyZzInfoExtend();
		querCompanyZzInfoExtend.setWid(wid);
		querCompanyZzInfoExtend.setRegisterId(this.getYhId());
		CompanyZzInfoExtend	datas=companyZzInfoService.selectDisplayByCondition(ConditionUtil.createCondition(querCompanyZzInfoExtend), this.createCustomOperateLog()).getDatas().get(0);
		return DataResult.success(datas);
	}
	@ResponseBody
	@AuthSupplyAnnotation
	@RequestMapping("query")
	public DataResult<List<CompanyZzInfoExtend>> query(Integer pageSize,Integer pageNum) throws Exception{
		CompanyZzInfoExtend querCompanyZzInfoExtend=new CompanyZzInfoExtend();
		PageInfo pageInfo=new PageInfo(pageSize,pageNum);
		 querCompanyZzInfoExtend.setRegisterId(this.getYhId());
		return companyZzInfoService.selectDisplayByCondition(ConditionUtil.createCondition(querCompanyZzInfoExtend, pageInfo), this.createCustomOperateLog());
		 
	}
	@ResponseBody
	@AuthIsSupplyAnnotation
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public DataResult<Integer> delete(String wid) throws Exception{
		CompanyZzInfo saveCompanyZzInfo=new CompanyZzInfo();
		saveCompanyZzInfo.setWid(wid);
		saveCompanyZzInfo.setRegisterId(this.getYhId());
		saveCompanyZzInfo.setDatastatus(YesNoEnum.NO.getCode());
		return companyZzInfoService.updateByCondition(saveCompanyZzInfo, this.createCustomOperateLog());
	}
}
