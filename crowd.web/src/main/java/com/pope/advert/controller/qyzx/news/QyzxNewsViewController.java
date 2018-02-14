package com.pope.advert.controller.qyzx.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.qyzx.extend.QyzxNewsInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("qyzxNewsView")
public class QyzxNewsViewController extends BaseController{
	@Autowired
	private QyzxNewsInfoService qyzxNewsInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public String index() throws Exception{
		
		return "qyzx/news/index";
	}
	@RequestMapping("view")
	public ModelAndView view(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("dlxx",qyzxNewsInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas());
		mv.setViewName("qyzx/news/view");
		return mv;
	}
	
	@RequestMapping("queryPersonList")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<List<QyzxNewsInfoExtend>> queryPersonList(Integer pageNum,Integer pageSize) throws Exception{
		QyzxNewsInfoExtend queryQyzxNewsInfoExtend=new QyzxNewsInfoExtend();
		queryQyzxNewsInfoExtend.setCompanyid(this.getCompanyId());
		return qyzxNewsInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryQyzxNewsInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("delete")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return qyzxNewsInfoService.delete(wid, this.createCustomOperateLog());
	}
}
