package com.pope.advert.controller.sjgl.dlgl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.sjgl.DlxxInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("dlglEdit")
public class DlglEditController extends BaseController{
	@Autowired
	private DlxxInfoService dlxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", StringUtil.toStr(wid));
		mv.setViewName("sjgl/dlgl/edit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<DlxxInfo> select(String wid) throws Exception{
		return dlxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<Integer> save(DlxxInfo dlxxInfo) throws Exception{
		return dlxxInfoService.publishing(dlxxInfo, this.createCustomOperateLog());
	}
}
