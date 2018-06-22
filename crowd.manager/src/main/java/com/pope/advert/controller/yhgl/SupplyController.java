package com.pope.advert.controller.yhgl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.CompanyClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supply")
public class SupplyController extends BaseController{
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("flag", flag);
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		mv.setViewName("yhgl/supply");
		return mv;
	}
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<CompanyInfoExtend>>  getList(String flag,String name,String shzt,Integer pageNum,String state,String order) throws Exception{
		CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
		if(!StringUtil.isEmpty(name)){
			queryCompanyInfoExtend.setName(name.trim());
		}
		if("1".equals(flag)){
		if(!StringUtil.isEmpty(shzt)){
			queryCompanyInfoExtend.setSupplyShzt(shzt.trim());
		}
		}else{
			if(!StringUtil.isEmpty(shzt)){
				queryCompanyInfoExtend.setBuyShzt(shzt.trim());
			}
		}
		List<String> orders=new ArrayList<String>();
		if(!StringUtil.isEmpty(order)){
			
			orders.add(order);
		}
		List<String> flags=new ArrayList<String>();
		flags.add(CompanyClassifyEnum.BOTH.getCode());
		if("1".equals(flag)){
			flags.add(CompanyClassifyEnum.SUPPLY.getCode());
		}else{
			flags.add(CompanyClassifyEnum.BUY.getCode());
		}
		queryCompanyInfoExtend.setFlags(flags);
		
		DataResult<List<CompanyInfoExtend>> datas= companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend,new PageInfo(null,pageNum),orders),this.createCustomOperateLog());
		return datas;
	}
	
	@RequestMapping("sh")
	@ResponseBody
	public DataResult<Integer> sh(String wid,String shzt,String flag) throws Exception{
		if("1".equals(flag)){
			return companyInfoService.shSupply(wid, shzt, this.createCustomOperateLog());
		}else{
			CompanyInfo saveCompanyInfo=new CompanyInfo();
			saveCompanyInfo.setWid(wid);
			saveCompanyInfo.setBuyShzt(shzt);
			return companyInfoService.updateByPrimaryKeySelective(saveCompanyInfo, this.createCustomOperateLog());
		}
		
	}
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid,String flag) throws Exception{
		CompanyInfo companyInfo=companyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas();
		if(CompanyClassifyEnum.BOTH.getCode().equals(companyInfo.getFlag())){
			CompanyInfo saveCompanyInfo=new CompanyInfo();
			saveCompanyInfo.setWid(wid);
			
			if("1".equals(flag)){
				saveCompanyInfo.setFlag(CompanyClassifyEnum.BUY.getCode());
				saveCompanyInfo.setSupplyShzt("");
				
			}else{
				saveCompanyInfo.setFlag(CompanyClassifyEnum.SUPPLY.getCode());
				saveCompanyInfo.setBuyShzt("");
			}
			return companyInfoService.updateByPrimaryKeySelective(saveCompanyInfo, this.createCustomOperateLog());
		}else{
			return companyInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
		}
		
	}
	@RequestMapping("select")
	@ResponseBody
	public DataResult<CompanyInfoExtend> select(String wid) throws Exception{
		CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
		queryCompanyInfoExtend.setWid(wid);
		List<CompanyInfoExtend> datas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryCompanyInfoExtend);
	}
}
