package com.pope.advert.controller.supplyview.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dictionary.DictionaryInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyExtInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyExtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyGmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyLmInfoExtend;
import com.pope.advert.entity.gggl.extend.DszySdInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyTbInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZtInfoExtend;
import com.pope.advert.entity.gggl.extend.DszyZzInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyExtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzyQtInfoExtend;
import com.pope.advert.entity.gggl.gbzy.extend.GbzySdInfoExtend;
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
import com.pope.advert.service.supply.bzzy.BzzyExtInfoService;
import com.pope.advert.service.supply.bzzy.BzzyGsygInfoService;
import com.pope.advert.service.supply.bzzy.BzzyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyJyInfoService;
import com.pope.advert.service.supply.bzzy.BzzyRwInfoService;
import com.pope.advert.service.supply.bzzy.BzzyXbmggInfoService;
import com.pope.advert.service.supply.gbzy.GbzyExtInfoService;
import com.pope.advert.service.supply.gbzy.GbzyInfoService;
import com.pope.advert.service.supply.gbzy.GbzyQtInfoService;
import com.pope.advert.service.supply.gbzy.GbzySdInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyGbzyDetail")
public class SupplyGbzyDetailController extends BaseController{

	@Autowired
	private GbzyInfoService gbzyInfoService;
	@Autowired
	private GbzyExtInfoService gbzyExtInfoService;
	@Autowired
	private GbzySdInfoService gbzySdInfoService;
	@Autowired
	private GbzyQtInfoService gbzyQtInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid,String ggxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/gbzyDetail");
		return mv;
	}
	
	@RequestMapping("selectGbzyInfo")
	@ResponseBody
	public DataResult<GbzyInfoExtend> selectGbzyInfo(String wid) throws Exception {
		GbzyInfoExtend queryGbzyInfoExtend = new GbzyInfoExtend();
		queryGbzyInfoExtend.setWid(wid);

		List<GbzyInfoExtend> datas = gbzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryGbzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new GbzyInfoExtend());
		}
	}
	@RequestMapping("selectGbzyExtInfo")
	@ResponseBody
	public DataResult<GbzyExtInfoExtend> selectGbzyExtInfo(String gbzyId) throws Exception{
		
		
		GbzyExtInfoExtend queryGbzyExtInfoExtend=new GbzyExtInfoExtend();
		queryGbzyExtInfoExtend.setGbzyId(gbzyId);
		
		List<GbzyExtInfoExtend> datas=gbzyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			GbzyExtInfoExtend gbzyExtInfoExtend=datas.get(0);
			
			return DataResult.success(gbzyExtInfoExtend);
		}else{
			return DataResult.success(new GbzyExtInfoExtend());
		}
	}

	@RequestMapping("selectGbzyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectGbzyOtherInfo(String gbzyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			GbzySdInfoExtend queryGbzySdInfoExtend=new GbzySdInfoExtend();
			queryGbzySdInfoExtend.setGbzyBm(gbzyId);
			List<GbzySdInfoExtend> datas=gbzySdInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzySdInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			
			GbzyQtInfoExtend queryGbzyQtInfoExtend=new GbzyQtInfoExtend();
			queryGbzyQtInfoExtend.setGbzyBm(gbzyId);
			List<GbzyQtInfoExtend> datas=gbzyQtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryGbzyQtInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}
		return DataResult.success(null);
		
	}
	
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception{
		GbzyInfoExtend queryGbzyInfoExtend = new GbzyInfoExtend();
		queryGbzyInfoExtend.setWid(wid);

		List<GbzyInfoExtend> datas = gbzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryGbzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			GbzyInfoExtend gbzyInfoExtend=datas.get(0);
			CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
			queryCompanyInfoExtend.setRegisterId(gbzyInfoExtend.getRegisterId());
			
			List<CompanyInfoExtend> companyInfoDatas=companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(companyInfoDatas)){
				CompanyInfoExtend companyInfoExtend=companyInfoDatas.get(0);
				CompanyInfoExtend retCompanyInfoExtend=new CompanyInfoExtend();
				retCompanyInfoExtend.setWid(companyInfoExtend.getWid());
				retCompanyInfoExtend.setName(companyInfoExtend.getName());
				retCompanyInfoExtend.setGslog(companyInfoExtend.getGslog());
				return DataResult.success(retCompanyInfoExtend);
			}
		}
		return DataResult.success(new CompanyInfoExtend());
	}
}
