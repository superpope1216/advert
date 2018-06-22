package com.pope.advert.controller.djsm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.XtcsEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.gggl.SupplyInfo;
import com.pope.advert.entity.xtgl.extend.XtcsbInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.supply.SupplyInfoService;
import com.pope.advert.service.xtgl.XtcsbInfoService;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("cwgl/djsm")
public class DjsmInfoController extends BaseController{
@Autowired
	private XtcsbInfoService xtcsbInfoService;

	@Autowired
	private SupplyInfoService supplyInfoService;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;
	
	@RequestMapping("list")
	@ResponseBody
	public DataResult<List<CwglDjxxInfoExtend>> list() throws Exception{
		CwglDjxxInfoExtend queryCwglDjxxInfoExtend=new CwglDjxxInfoExtend();
		return cwglDjxxInfoService.selectByCondition(ConditionUtil.createCondition(queryCwglDjxxInfoExtend), this.createCustomOperateLog());
	}
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		RegisterInfoExtend register=(RegisterInfoExtend)request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("cwgl/djsm");
		mv.addObject("dj", register.getDjxx().getDj());
		SupplyInfo supplyInfo=new SupplyInfo();
		supplyInfo.setRegisterId(this.getYhId());
		Integer yfbts=supplyInfoService.selectCountByCondition(ConditionUtil.createCondition(supplyInfo), this.createCustomOperateLog()).getDatas();
		mv.addObject("yfbts", yfbts);
		yfbts=StringUtil.toInt(yfbts, 0);//已发布条数
		if(StringUtil.isEmpty(register.getDjxx().getDj())) {
			XtcsbInfoExtend queryXtcsbInfoExtend=new XtcsbInfoExtend();
			queryXtcsbInfoExtend.setCsmc(XtcsEnum.DEFAULT_GGSJ.getCode());
			mv.addObject("mrts", xtcsbInfoService.selectByCondition(queryXtcsbInfoExtend).getDatas().get(0));
			queryXtcsbInfoExtend.setCsmc(XtcsEnum.DEFAULT_GGSJ.getCode());
			Integer mrts=StringUtil.toInt(xtcsbInfoService.selectByCondition(queryXtcsbInfoExtend).getDatas().get(0), 0);
			mv.addObject("mrts", mrts);
			mv.addObject("syts",mrts-yfbts);
		}
		mv.addObject("djName", register.getDjxx().getDjxx().getName());
		return mv;
	}
}
