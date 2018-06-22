package com.pope.advert.controller.qyzx.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("qyzxNewsEdit")
public class QyzxNewsEditController extends BaseController{
	@Autowired
	private QyzxNewsInfoService qyzxNewsInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", StringUtil.toStr(wid));
		mv.setViewName("qyzx/news/edit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<QyzxNewsInfo> select(String wid) throws Exception{
		return qyzxNewsInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<Integer> save(QyzxNewsInfo QyzxNewsInfo) throws Exception{
		return qyzxNewsInfoService.publishing(QyzxNewsInfo, this.createCustomOperateLog());
	}
}
