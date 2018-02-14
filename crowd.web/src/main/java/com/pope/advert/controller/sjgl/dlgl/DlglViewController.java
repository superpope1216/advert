package com.pope.advert.controller.sjgl.dlgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.dto.PageInfo;
import com.pope.advert.entity.sjgl.extend.DlxxInfoExtend;
import com.pope.advert.interceptor.AuthSupplyAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.sjgl.DlxxInfoService;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.code.SjztEnum;
import com.wisedu.crowd.common.util.ConditionUtil;

@Controller
@RequestMapping("dlglView")
public class DlglViewController extends BaseController{
	@Autowired
	private DlxxInfoService dlxxInfoService;
	@RequestMapping("index")
	@AuthSupplyAnnotation
	public String index() throws Exception{
		
		return "sjgl/dlgl/index";
	}
	@RequestMapping("view")
	public ModelAndView view(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("dlxx",dlxxInfoService.selectByPrimaryKey(wid, this.createCustomOperateLog()).getDatas());
		mv.setViewName("sjgl/dlgl/view");
		return mv;
	}
	@RequestMapping("queryAllList")
	
	@ResponseBody
	public DataResult<List<DlxxInfoExtend>> queryAllList(Integer pageNum,Integer pageSize) throws Exception{
		DlxxInfoExtend queryDlxxInfoExtend=new DlxxInfoExtend();
		queryDlxxInfoExtend.setShzt(SjztEnum.YTG.getCode());
		return dlxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("queryPersonList")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<List<DlxxInfoExtend>> queryPersonList(Integer pageNum,Integer pageSize) throws Exception{
		DlxxInfoExtend queryDlxxInfoExtend=new DlxxInfoExtend();
		queryDlxxInfoExtend.setYhid(this.getCompanyId());
		return dlxxInfoService.selectDisplayByCondition(ConditionUtil.createCondition(queryDlxxInfoExtend,new PageInfo(pageSize,pageNum)), this.createCustomOperateLog());
	}
	
	@RequestMapping("delete")
	@AuthSupplyAnnotation
	@ResponseBody
	public DataResult<Integer> delete(String wid) throws Exception{
		return dlxxInfoService.delete(wid, this.createCustomOperateLog());
	}
}
