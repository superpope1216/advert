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
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qyzxNews")
public class QyzxNewsController extends BaseController{
	
	@Autowired
	private QyzxNewsInfoService qyzxNewsInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("center/qyzxNewsCenter");
		return mv;
	}
	
	@RequestMapping("getList")
	@ResponseBody
	public DataResult<List<QyzxNewsInfoExtend>> getList(Integer pageNum) throws Exception{
		QyzxNewsInfoExtend queryQyzxNewsInfoExtend=new QyzxNewsInfoExtend();
		queryQyzxNewsInfoExtend.setShzt(SjztEnum.YTG.getCode());
		queryQyzxNewsInfoExtend.setNeedCompanyInfo(true);
		return qyzxNewsInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQyzxNewsInfoExtend,new PageInfo(null,pageNum)), this.createCustomOperateLog());
		
	}
	
}
