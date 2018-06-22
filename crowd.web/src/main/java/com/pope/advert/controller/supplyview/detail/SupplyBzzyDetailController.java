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
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyBzzyDetail")
public class SupplyBzzyDetailController extends BaseController{

	@Autowired
	private BzzyInfoService bzzyInfoService;
	@Autowired
	private BzzyXbmggInfoService bzzyXbmggInfoService;
	@Autowired
	private BzzyGsygInfoService bzzyGsygInfoService;
	@Autowired
	private BzzyRwInfoService bzzyRwInfoService;
	@Autowired
	private BzzyJyInfoService bzzyJyInfoService;
	@Autowired
	private BzzyExtInfoService bzzyExtInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid,String ggxs) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/bzzyDetail");
		return mv;
	}
	
	@RequestMapping("selectBzzyInfo")
	@ResponseBody
	public DataResult<BzzyInfoExtend> selectBzzyInfo(String wid) throws Exception {
		BzzyInfoExtend queryBzzyInfoExtend = new BzzyInfoExtend();
		queryBzzyInfoExtend.setWid(wid);

		List<BzzyInfoExtend> datas = bzzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryBzzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new BzzyInfoExtend());
		}
	}
	@RequestMapping("selectBzzyExtInfo")
	@ResponseBody
	public DataResult<BzzyExtInfoExtend> selectBzzyExtInfo(String bzzyId) throws Exception{
		
		
		BzzyExtInfoExtend queryBzzyExtInfoExtend=new BzzyExtInfoExtend();
		queryBzzyExtInfoExtend.setBzzyId(bzzyId);
		
		List<BzzyExtInfoExtend> datas=bzzyExtInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyExtInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			BzzyExtInfoExtend bzzyExtInfoExtend=datas.get(0);
			return DataResult.success(bzzyExtInfoExtend);
		}else{
			return DataResult.success(new BzzyExtInfoExtend());
		}
	}

	@RequestMapping("selectBzzyOtherInfo")
	@ResponseBody
	public DataResult<Object> selectBzzyOtherInfo(String bzzyId,String ggxs) throws Exception{
		if("1".equals(ggxs)){
			BzzyGsygInfoExtend queryBzzyGsygInfoExtend=new BzzyGsygInfoExtend();
			queryBzzyGsygInfoExtend.setBzzyId(bzzyId);
			List<BzzyGsygInfoExtend> datas=bzzyGsygInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyGsygInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(ggxs)){
			BzzyXbmggInfoExtend queryBzzyXbmggInfoExtend=new BzzyXbmggInfoExtend();
			queryBzzyXbmggInfoExtend.setBzzyId(bzzyId);
			List<BzzyXbmggInfoExtend> datas=bzzyXbmggInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryBzzyXbmggInfoExtend),this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("3".equals(ggxs)){
			BzzyRwInfoExtend queryBzzyRwInfoExtend=new BzzyRwInfoExtend();
			queryBzzyRwInfoExtend.setBzzyId(bzzyId);
			List<BzzyRwInfoExtend> datas=bzzyRwInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyRwInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("4".equals(ggxs)){
			BzzyJyInfoExtend queryBzzyJyInfoExtend=new BzzyJyInfoExtend();
			queryBzzyJyInfoExtend.setBzzyId(bzzyId);
			
			List<BzzyJyInfoExtend> datas=bzzyJyInfoService.selectByCondition(ConditionUtil.createCondition(queryBzzyJyInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
		}
		return DataResult.success(null);
		
	}
	
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception{
		BzzyInfoExtend queryBzzyInfoExtend = new BzzyInfoExtend();
		queryBzzyInfoExtend.setWid(wid);

		List<BzzyInfoExtend> datas = bzzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryBzzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			BzzyInfoExtend bzzyInfoExtend=datas.get(0);
			CompanyInfoExtend queryCompanyInfoExtend=new CompanyInfoExtend();
			queryCompanyInfoExtend.setRegisterId(bzzyInfoExtend.getRegisterId());
			
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
