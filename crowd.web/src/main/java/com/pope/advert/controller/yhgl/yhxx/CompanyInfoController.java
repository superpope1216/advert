package com.pope.advert.controller.yhgl.yhxx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
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
	/**
	 * 
	 * @param flag1表示售卖2表示购买
	 * @return
	 * @throws Exception
	 */
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("gsxz", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_COMPANYXZ, null));
		mv.addObject("yyed", dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_COMPANY_NYYE, null));
		CompanyInfo companyInfo=(CompanyInfo)request.getSession().getAttribute(ConstantsUtil.SESSION_COMPANY);
		if("1".equals(flag)){
			if(ShztEnum.DSH.getCode().equals(companyInfo.getSupplyShzt())){
				mv.addObject("msg", "您的广告售卖方身份正在审核中，请稍后！");
			}else if(ShztEnum.WTG.getCode().equals(companyInfo.getSupplyShzt())){
				mv.addObject("msg", "抱歉！您的广告售卖方身份申请不通过！");
			}else if(ShztEnum.YTG.getCode().equals(companyInfo.getSupplyShzt())){
				mv.addObject("msg", "恭喜您！您的广告售卖方身份已审核通过！");
			}
			mv.setViewName("yhgl/yhxx/companyInfo");
		}else if("2".equals(flag)){
			if(ShztEnum.DSH.getCode().equals(companyInfo.getBuyShzt())){
				mv.addObject("msg", "您的广告购买方身份正在审核中，请稍后！");
			}else if(ShztEnum.WTG.getCode().equals(companyInfo.getBuyShzt())){
				mv.addObject("msg", "抱歉！您的广告购买方身份申请不通过！");
			}else if(ShztEnum.YTG.getCode().equals(companyInfo.getBuyShzt())){
				mv.addObject("msg", "恭喜您！您的广告购买方身份已审核通过！");
			}
			mv.setViewName("yhgl/yhxx/buy/companyInfo");
		}
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
