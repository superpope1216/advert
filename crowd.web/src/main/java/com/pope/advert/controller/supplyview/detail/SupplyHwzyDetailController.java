package com.pope.advert.controller.supplyview.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
import com.pope.advert.entity.gggl.hwzy.HwzyInfo;
import com.pope.advert.entity.gggl.hwzy.extend.HwzyInfoExtend;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.DszyExtInfoService;
import com.pope.advert.service.supply.DszyGmInfoService;
import com.pope.advert.service.supply.DszyInfoService;
import com.pope.advert.service.supply.DszyLmInfoService;
import com.pope.advert.service.supply.DszySdInfoService;
import com.pope.advert.service.supply.DszyTbInfoService;
import com.pope.advert.service.supply.DszyZtInfoService;
import com.pope.advert.service.supply.DszyZzInfoService;
import com.pope.advert.service.supply.hwzy.HwzyInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyHwzyDetail")
public class SupplyHwzyDetailController extends BaseController{

	@Autowired
	private HwzyInfoService hwzyInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid,String ggxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/hwzyDetail");
		return mv;
	}
	
	@RequestMapping("selectHwzyInfo")
	@ResponseBody
	public DataResult<HwzyInfoExtend> selectDszyInfo(String wid) throws Exception {
		HwzyInfoExtend queryHwzyInfoExtend = new HwzyInfoExtend();
		queryHwzyInfoExtend.setWid(wid);
		queryHwzyInfoExtend.setShzt(ShztEnum.YTG.getCode());
		List<HwzyInfoExtend> datas = hwzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryHwzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new HwzyInfoExtend());
		}
	}
	
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception{
		HwzyInfo hwzyInfo=hwzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas();
		
			CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
			queryCompanyInfoExtend.setRegisterId(hwzyInfo.getRegisterId());
			
			List<CompanyInfoExtend> companyInfoDatas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(companyInfoDatas)){
				CompanyInfoExtend companyInfoExtend=companyInfoDatas.get(0);
				CompanyInfoExtend retCompanyInfoExtend=new CompanyInfoExtend();
				retCompanyInfoExtend.setWid(companyInfoExtend.getWid());
				retCompanyInfoExtend.setName(companyInfoExtend.getName());
				retCompanyInfoExtend.setGslog(companyInfoExtend.getGslog());
				return DataResult.success(retCompanyInfoExtend);
			}
		
		return DataResult.success(new CompanyInfoExtend());
	}
}
