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
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.pope.advert.service.sjgl.HzxxInfoService;
import com.pope.advert.service.sjgl.SjxxInfoService;
import com.pope.advert.service.sjgl.ZbxxInfoService;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("sjglDetail")
public class SjglDetailController extends BaseController{

	@Autowired
	private  DictionaryService dictionaryService;
	@Autowired
	private SjxxInfoService sjxxInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@Autowired
	private DlxxInfoService dlxxInfoService;
	
	@Autowired
	private HzxxInfoService hzxxInfoService;
	
	@Autowired
	private ZbxxInfoService zbxxInfoService;
	
	@RequestMapping("index")
	public ModelAndView index(String wid,String sjlx) throws Exception{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("sjlx", sjlx);
		mv.setViewName("center/detail/sjglDetail");
		return mv;
	}
	
	
	@RequestMapping("selectSjglInfo")
	@ResponseBody
	public DataResult<Object> selectSjglInfo(String wid,String sjlx) throws Exception{
		if("1".equals(sjlx)){
			
			DlxxInfoExtend queryDlxxInfoExtend=new DlxxInfoExtend();
			queryDlxxInfoExtend.setWid(wid);
			List<DlxxInfoExtend> datas=dlxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend), this.createCustomOperateLog()).getDatas();
		
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("2".equals(sjlx)){
			HzxxInfoExtend queryHzxxInfoExtend=new HzxxInfoExtend();
			queryHzxxInfoExtend.setWid(wid);
			List<HzxxInfoExtend> datas=hzxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryHzxxInfoExtend), this.createCustomOperateLog()).getDatas();
			
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}else if("3".equals(sjlx)){
			ZbxxInfoExtend queryZbxxInfoExtend=new ZbxxInfoExtend();
			queryZbxxInfoExtend.setWid(wid);
			List<ZbxxInfoExtend> datas=zbxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryZbxxInfoExtend), this.createCustomOperateLog()).getDatas();
			if(CommonUtil.isNotEmptyList(datas)){
				return DataResult.success((Object)datas.get(0));
			}
			
		}
		return DataResult.success(null);
		
	}
	@ResponseBody
	@RequestMapping("selectCompanyInfo")
	public DataResult<CompanyInfoExtend> selectCompanyInfo(String wid,String sjlx) throws Exception {
		
		SjxxInfo querySjxxInfo=new SjxxInfo();
		querySjxxInfo.setWid(wid);
		List<SjxxInfo> datas=	sjxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(querySjxxInfo), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isNotEmptyList(datas)){
			SjxxInfo sjxxInfo=datas.get(0);
			CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
			queryCompanyInfoExtend.setWid(sjxxInfo.getYhid());

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
		}
		
		return DataResult.success(new CompanyInfoExtend());
	}

}
