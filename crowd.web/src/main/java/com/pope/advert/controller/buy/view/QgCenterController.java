package com.pope.advert.controller.buy.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.extend.QgInfoExtend;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qgCenter")
public class QgCenterController extends BaseController{

	@Autowired
	private QgInfoService qgInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("buy/view/qgCenter");
		return mv;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<QgInfoExtend>> list(Integer pageSize,Integer pageNum) throws Exception{
		QgInfoExtend queryQgInfoExtend=new QgInfoExtend();
		queryQgInfoExtend.setShzt(ShztEnum.YTG.getCode());
		return qgInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQgInfoExtend, new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
}
