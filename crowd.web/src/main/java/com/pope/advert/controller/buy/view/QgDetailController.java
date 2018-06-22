package com.pope.advert.controller.buy.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyInfoExtend;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qgDetail")
public class QgDetailController extends BaseController {
	@Autowired
	private QgInfoService qgInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;

	@RequestMapping("index")
	public ModelAndView index(String wid) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("wid", wid);
		mv.setViewName("buy/view/qgDetail");
		return mv;
	}

	@ResponseBody
	@RequestMapping("select")
	public DataResult<QgInfoExtend> select(String wid) throws Exception {
		QgInfoExtend queryQgInfoExtend = new QgInfoExtend();
		queryQgInfoExtend.setWid(wid);
		List<QgInfoExtend> datas = qgInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryQgInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		} else {
			return DataResult.success(new QgInfoExtend());
		}
	}

	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid) throws Exception {
		QgInfo qgInfo = qgInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas();

		CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
		queryCompanyInfoExtend.setRegisterId(qgInfo.getRegisterId());

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
