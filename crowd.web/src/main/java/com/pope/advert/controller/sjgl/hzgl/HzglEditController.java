package com.pope.advert.controller.sjgl.hzgl;

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
import com.pope.advert.entity.sjgl.HzxxInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.HzxxInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("hzglEdit")
public class HzglEditController extends BaseController{
	@Autowired
	private HzxxInfoService hzxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", StringUtil.toStr(wid));
		mv.setViewName("sjgl/hzgl/edit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<HzxxInfo> select(String wid) throws Exception{
		return hzxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog());
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	@AuthSupplyAnnotation
	public DataResult<Integer> save(HzxxInfo HzxxInfo) throws Exception{
		return hzxxInfoService.publishing(HzxxInfo, this.createCustomOperateLog());
	}
}
