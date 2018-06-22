package com.pope.advert.controller.sjgl.zbgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.sjgl.ZbxxInfo;
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.ZbxxInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("zbglEdit")
public class ZbglEditController extends BaseController{
	@Autowired
	private ZbxxInfoService zbxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", StringUtil.toStr(wid));
		mv.setViewName("sjgl/zbgl/edit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<ZbxxInfo> select(String wid) throws Exception{
		return zbxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<Integer> save(ZbxxInfo ZbxxInfo) throws Exception{
		return zbxxInfoService.publishing(ZbxxInfo, this.createCustomOperateLog());
	}
}
