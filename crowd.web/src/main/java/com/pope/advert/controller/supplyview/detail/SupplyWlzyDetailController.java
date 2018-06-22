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
import com.pope.advert.entity.gggl.wlzy.WlzyInfo;
import com.pope.advert.entity.gggl.wlzy.extend.WlzyInfoExtend;
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
import com.pope.advert.service.supply.wlzy.WlzyInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("supplyWlzyDetail")
public class SupplyWlzyDetailController extends BaseController {

	@Autowired
	private WlzyInfoService wlzyInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;

	@RequestMapping("index")
	public ModelAndView index(String wid, String ggxs) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ggxs", ggxs);
		mv.addObject("wid", wid);
		mv.setViewName("supplyview/detail/wlzyDetail");
		return mv;
	}

	@RequestMapping("selectWlzyInfo")
	@ResponseBody
	public DataResult<WlzyInfoExtend> selectWlzyInfo(String wid) throws Exception {
		WlzyInfoExtend queryWlzyInfoExtend = new WlzyInfoExtend();
		queryWlzyInfoExtend.setWid(wid);
		List<WlzyInfoExtend> datas = wlzyInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryWlzyInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new WlzyInfoExtend());
		}
	}

	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception {
		WlzyInfo wlzyInfo = wlzyInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas();

		CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
		queryCompanyInfoExtend.setRegisterId(wlzyInfo.getRegisterId());

		List<CompanyInfoExtend> companyInfoDatas = companyInfoService
				.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend), this.createCustomOperateLog())
				.getDatas();
		if (CommonUtil.isNotEmptyList(companyInfoDatas)) {
			CompanyInfoExtend companyInfoExtend = companyInfoDatas.get(0);
			CompanyInfoExtend retCompanyInfoExtend = new CompanyInfoExtend();
			retCompanyInfoExtend.setWid(companyInfoExtend.getWid());
			retCompanyInfoExtend.setName(companyInfoExtend.getName());
			retCompanyInfoExtend.setGslog(companyInfoExtend.getGslog());
			return DataResult.success(retCompanyInfoExtend);
		}
		return DataResult.success(new CompanyInfoExtend());
	}
}
