package com.pope.advert.controller.qyzx.gg;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.qyzx.QyzxGgInfo;
import com.pope.advert.entity.qyzx.QyzxNewsInfo;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.qyzx.QyzxGgInfoService;
import com.pope.advert.service.qyzx.QyzxNewsInfoService;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("qyzxGgEdit")
public class QyzxGgEditController extends BaseController{
	@Autowired
	private QyzxGgInfoService qyzxGgInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", StringUtil.toStr(wid));
		mv.setViewName("qyzx/gg/edit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<QyzxGgInfo> select(String wid) throws Exception{
		return qyzxGgInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<Integer> save(QyzxGgInfo QyzxNewsInfo) throws Exception{
		return qyzxGgInfoService.publishing(QyzxNewsInfo, this.createCustomOperateLog());
	}
}
