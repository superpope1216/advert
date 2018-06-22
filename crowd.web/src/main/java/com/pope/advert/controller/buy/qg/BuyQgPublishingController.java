package com.pope.advert.controller.buy.qg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.buy.qg.QgInfo;
import com.pope.advert.interceptor.AuthBuyAnnotation;
import com.pope.advert.interceptor.AuthIsBuyAnnotation;
import com.pope.advert.service.buy.qg.QgInfoService;
import com.pope.advert.service.dto.DataResult;

@Controller
@RequestMapping("buyQgPublishing")
public class BuyQgPublishingController extends BaseController{
	@Autowired
	private QgInfoService qgInfoService;
	@RequestMapping("index")
	@AuthIsBuyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.setViewName("buy/qg/publishing");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthIsBuyAnnotation
	public DataResult<QgInfo> select(String wid) throws Exception{
		return qgInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	@RequestMapping("publishing")
	@AuthIsBuyAnnotation
	@ResponseBody
	public DataResult<Integer> publishing(QgInfo qgInfo) throws Exception{
		return qgInfoService.publishing(qgInfo, this.createCustomOperateLog());
	}
	
	
}
