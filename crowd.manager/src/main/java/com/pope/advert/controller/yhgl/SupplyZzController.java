package com.pope.advert.controller.yhgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyZzInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyZzInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("supplyZz")
public class SupplyZzController extends BaseController{

	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private CompanyZzInfoService companyZzInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("yhgl/supplyZz");
		mv.addObject("shzt", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SHZT));
		return mv;
	}
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<CompanyZzInfoExtend>> getList(String companyName,String shzt,Integer pageNum) throws Exception{
		CompanyZzInfoExtend queryCompanyZzInfoExtend=new CompanyZzInfoExtend();
		if(!StringUtil.isEmpty(companyName)){
			queryCompanyZzInfoExtend.setCompanyName(companyName);
		}
		if(!StringUtil.isEmpty(shzt)) {
			queryCompanyZzInfoExtend.setShzt(shzt);
		}
		return companyZzInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryCompanyZzInfoExtend,new PageInfo(null,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("sh")
	@ResponseBody
	public DataResult<Integer> sh(String wid,String shzt) throws Exception{
		return companyZzInfoService.sh(wid, shzt, this.createCustomOperateLog());
	}
	@RequestMapping("delete")
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return companyZzInfoService.deleteByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@RequestMapping("select")
	@ResponseBody
	public DataResult<CompanyZzInfoExtend> select(String wid) throws Exception{
		CompanyZzInfoExtend queryCompanyZzInfoExtend=new CompanyZzInfoExtend();
		queryCompanyZzInfoExtend.setWid(wid);
		List<CompanyZzInfoExtend> datas=companyZzInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryCompanyZzInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryCompanyZzInfoExtend);
	}
}
