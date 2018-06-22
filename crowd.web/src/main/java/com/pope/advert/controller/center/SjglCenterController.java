package com.pope.advert.controller.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.DictionaryEnum;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.sjgl.SjxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.SjxxInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("sjglCenter")
public class SjglCenterController extends BaseController{

	@Autowired
	private  DictionaryService dictionaryService;
	@Autowired
	private SjxxInfoService sjxxInfoService;
	@RequestMapping("index")
	public ModelAndView index(String sjlx) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("center/sjglCenter");
		if(StringUtil.isEmpty(sjlx)){
			sjlx="";
		}
		mv.addObject("sjlx2", sjlx);
		mv.addObject("sjlx", dictionaryService.selectAllByTable(DictionaryEnum.T_ADVERT_SJZD_SJLX));
		return mv;
	}
	
	@RequestMapping("queryAllList")
	@ResponseBody
	public DataResult<List<SjxxInfo>> queryAllList(String sjlx,Integer pageNum,Integer pageSize) throws Exception{
		SjxxInfo sjxxInfo=new SjxxInfo();
		sjxxInfo.setShzt(SjztEnum.YTG.getCode());
		if(!StringUtil.isEmpty(sjlx)){
			sjxxInfo.setSjlx(sjlx);
		}
		sjxxInfo.setNeedCompanyInfo(true);
		return sjxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(sjxxInfo,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
}
