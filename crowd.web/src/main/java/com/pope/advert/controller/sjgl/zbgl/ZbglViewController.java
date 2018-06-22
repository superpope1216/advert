package com.pope.advert.controller.sjgl.zbgl;

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
import com.pope.advert.entity.sjgl.extend.ZbxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.ZbxxInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("zbglView")
public class ZbglViewController extends BaseController{
	@Autowired
	private ZbxxInfoService zbxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public String index() throws Exception{
		
		return "sjgl/zbgl/index";
	}
	
	@RequestMapping("view")
	public ModelAndView view(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("dlxx",zbxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas());
		mv.setViewName("sjgl/dlgl/view");
		return mv;
	}
	@RequestMapping("queryAllList")
	
	@ResponseBody
	public DataResult<List<ZbxxInfoExtend>> queryAllList(Integer pageNum,Integer pageSize) throws Exception{
		ZbxxInfoExtend queryZbxxInfoExtend=new ZbxxInfoExtend();
		queryZbxxInfoExtend.setShzt(SjztEnum.YTG.getCode());
		return zbxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryZbxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("queryPersonList")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<List<ZbxxInfoExtend>> queryPersonList(Integer pageNum,Integer pageSize) throws Exception{
		ZbxxInfoExtend queryZbxxInfoExtend=new ZbxxInfoExtend();
		queryZbxxInfoExtend.setYhid(this.getCompanyId());
		return zbxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryZbxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("delete")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return zbxxInfoService.delete(wid, this.createCustomOperateLog());
	}
}
