package com.pope.advert.controller.center.detail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyGsygInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyJyInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyRwInfoExtend;
import com.pope.advert.entity.gggl.bzzy.extend.BzzyXbmggInfoExtend;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.pope.advert.service.sjgl.HzxxInfoService;
import com.pope.advert.service.sjgl.SjxxInfoService;
import com.pope.advert.service.sjgl.ZbxxInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qyzxNewsDetail")
public class QyzxNewsDetailController extends BaseController {

	@Autowired
	private QyzxNewsInfoService qyzxNewsInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;

	@RequestMapping("index")
	public ModelAndView index(String wid, String sjlx) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("sjlx", sjlx);
		mv.setViewName("center/detail/qyzxNewsDetail");
		return mv;
	}

	@RequestMapping("select")
	@ResponseBody
	public DataResult<QyzxNewsInfoExtend> select(String wid) throws Exception {
		QyzxNewsInfoExtend queryDlxxInfoExtend = new QyzxNewsInfoExtend();
		queryDlxxInfoExtend.setWid(wid);
		queryDlxxInfoExtend.setNeedCompanyInfo(true);
		List<QyzxNewsInfoExtend> datas = qyzxNewsInfoService.selectDisplayByCondition(
				ConditionUtil.createCondition(queryDlxxInfoExtend), this.createCustomOperateLog()).getDatas();
		if (CommonUtil.isNotEmptyList(datas)) {
			return DataResult.success(datas.get(0));
		}
		return DataResult.success(queryDlxxInfoExtend);
	}

	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid, String sjlx) throws Exception {
		QyzxNewsInfo qyzxNewsInfo = qyzxNewsInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog())
				.getDatas();
		CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
		queryCompanyInfoExtend.setWid(qyzxNewsInfo.getCompanyid());

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
