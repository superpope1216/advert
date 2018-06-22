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
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyExtInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyJyInfoExtend;
import com.pope.advert.entity.gggl.zzzy.extend.ZzzyRwInfoExtend;
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
import com.pope.advert.service.supply.zzzy.ZzzyExtInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyGsygInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyJyInfoService;
import com.pope.advert.service.supply.zzzy.ZzzyRwInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyZzzyDetail")
public class SupplyZzzyDetailController extends BaseController{

	@Autowired
	private ZzzyInfoService zzzyInfoService;
	@Autowired
	private ZzzyExtInfoService zzzyExtInfoService;
	@Autowired
	private ZzzyGsygInfoService zzzyGsygInfoService;
	@Autowired
	private ZzzyRwInfoService zzzyRwInfoService;
	@Autowired
	private ZzzyJyInfoService zzzyJyInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid,String ggxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/zzzyDetail");
		return mv;
	}
	
	@RequestMapping("selectZzzyInfo")
	@ResponseBody
	public DataResult<ZzzyInfoExtend> selectZzzyInfo(String wid) throws Exception {
		ZzzyInfoExtend queryZzzyInfoExtend = new ZzzyInfoExtend();
		queryZzzyInfoExtend.setWid(wid);

		List<ZzzyInfoExtend> datas = zzzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryZzzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new ZzzyInfoExtend());
		}
	}
	@RequestMapping("selectZzzyExtInfo")
	@ResponseBody
	public DataResult<ZzzyExtInfoExtend> selectZzzyExtInfo(String zzzyId) throws Exception{
		
		
		ZzzyExtInfoExtend queryZzzyExtInfoExtend=new ZzzyExtInfoExtend();
		queryZzzyExtInfoExtend.setDszyId(zzzyId);
		
		List<ZzzyExtInfoExtend> datas=zzzyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryZzzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			ZzzyExtInfoExtend zzzyExtInfoExtend=datas.get(0);
			
			return DataResult.success(zzzyExtInfoExtend);
		}else{
			return DataResult.success(new ZzzyExtInfoExtend());
		}
	}

	@RequestMapping("selectZzzyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectZzzyOtherInfo(String zzzyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			ZzzyGsygInfoExtend queryZzzyGsygInfoExtend=new ZzzyGsygInfoExtend();
			queryZzzyGsygInfoExtend.setZzzyId(zzzyId);
			List<ZzzyGsygInfoExtend> datas=zzzyGsygInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyGsygInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			ZzzyRwInfoExtend queryZzzyRwInfoExtend=new ZzzyRwInfoExtend();
			queryZzzyRwInfoExtend.setZzzyId(zzzyId);
			List<ZzzyRwInfoExtend> datas=zzzyRwInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyRwInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("3".equals(ggxs)){
			ZzzyJyInfoExtend queryZzzyJyInfoExtend=new ZzzyJyInfoExtend();
			queryZzzyJyInfoExtend.setZzzyId(zzzyId);
			
			List<ZzzyJyInfoExtend> datas=zzzyJyInfoService.selectByCondition(ConditionUtil.createCondition(queryZzzyJyInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}
		return DataResult.success(null);
	}
	
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception{

		ZzzyInfoExtend queryZzzyInfoExtend = new ZzzyInfoExtend();
		queryZzzyInfoExtend.setWid(wid);

		List<ZzzyInfoExtend> datas = zzzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryZzzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			ZzzyInfoExtend zzzyInfoExtend=datas.get(0);
			CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
			queryCompanyInfoExtend.setRegisterId(zzzyInfoExtend.getRegisterId());
			
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
