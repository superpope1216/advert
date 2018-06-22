package com.pope.advert.controller.sjgl.hzgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.common.code.SjztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.sjgl.extend.HzxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.HzxxInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("hzglView")
public class HzglViewController extends BaseController{
	@Autowired
	private HzxxInfoService hzxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public String index() throws Exception{
		
		return "sjgl/hzgl/index";
	}
	
	@RequestMapping("view")
	public ModelAndView view(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("dlxx",hzxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas());
		mv.setViewName("sjgl/dlgl/view");
		return mv;
	}
	@RequestMapping("queryAllList")
	
	@ResponseBody
	public DataResult<List<HzxxInfoExtend>> queryAllList(Integer pageNum,Integer pageSize) throws Exception{
		HzxxInfoExtend queryHzxxInfoExtend=new HzxxInfoExtend();
		queryHzxxInfoExtend.setShzt(SjztEnum.YTG.getCode());
		return hzxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryHzxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("queryPersonList")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<List<HzxxInfoExtend>> queryPersonList(Integer pageNum,Integer pageSize) throws Exception{
		HzxxInfoExtend queryHzxxInfoExtend=new HzxxInfoExtend();
		queryHzxxInfoExtend.setYhid(this.getCompanyId());
		return hzxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryHzxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("delete")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return hzxxInfoService.delete(wid, this.createCustomOperateLog());
	}
}
