package com.pope.advert.controller.yhgl.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.impl.calendar.BaseCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.CompanyClassifyEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend;
import com.pope.advert.interceptor.AuthLoginAnnotation;
import com.pope.advert.service.cwgl.CwglDjxxInfoService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.pope.advert.service.yhgl.YhglDjxxInfoServie;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

	@Autowired
	private RegisterInfoService registerInfoService;
	
	@Autowired
	private YhglDjxxInfoServie yhglDjxxInfoServie;
	@Autowired
	private CwglDjxxInfoService cwglDjxxInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("yhgl/login/login");
		return mv;
	}
	
	@RequestMapping("login")
	@ResponseBody
	public DataResult<Integer> login(@RequestParam String username,@RequestParam String password,String backurl,HttpServletRequest request,HttpServletResponse response) throws Exception{
		RegisterInfoExtend registerInfoExtend=registerInfoService.login(username, password, this.createCustomOperateLog()).getDatas();
		request.getSession(true).setAttribute(ConstantsUtil.SESSION_YHJBXX, registerInfoExtend);
		
		YhglDjxxInfoExtend queryYhglDjxxInfoExtend = new YhglDjxxInfoExtend();
		queryYhglDjxxInfoExtend.setYhid(registerInfoExtend.getWid());
		List<YhglDjxxInfoExtend> djxxDatas = yhglDjxxInfoServie
				.selectByCondition(ConditionUtil.createCondition(queryYhglDjxxInfoExtend), this.createCustomOperateLog()).getDatas();
		YhglDjxxInfoExtend yhglDjxxInfoExtend=new YhglDjxxInfoExtend();
		if (CommonUtil.isNotEmptyList(djxxDatas)) {
			yhglDjxxInfoExtend=djxxDatas.get(0);
			if (!StringUtil.isEmpty(djxxDatas.get(0).getDj())) {
				CwglDjxxInfoExtend queryCwglDjxxInfoExtend = new CwglDjxxInfoExtend();
				queryCwglDjxxInfoExtend.setWid(djxxDatas.get(0).getDj());
				List<CwglDjxxInfoExtend> cwglDjxxDatas = cwglDjxxInfoService
						.selectByCondition(ConditionUtil.createCondition(queryCwglDjxxInfoExtend), this.createCustomOperateLog()).getDatas();
				if (CommonUtil.isNotEmptyList(cwglDjxxDatas)) {
					yhglDjxxInfoExtend.setDjxx(cwglDjxxDatas.get(0));
				}else {
					yhglDjxxInfoExtend.setDjxx(new CwglDjxxInfoExtend());
				}
			}

		} else {
			yhglDjxxInfoExtend.setDjxx(new CwglDjxxInfoExtend());
		}
		request.getSession().setAttribute(ConstantsUtil.YHXX_DJXX, yhglDjxxInfoExtend);
		
		CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
		queryCompanyInfoExtend.setRegisterId(registerInfoExtend.getWid());
		DataResult<List<CompanyInfoExtend>> supplyData = companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend),
				null);
		if(CommonUtil.isNotEmptyList(supplyData.getDatas())){
			if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode())){
				if(ShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())
						|| ShztEnum.WTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
					request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY,true);
				}else {
					request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY,false);
				}
			}
			if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BUY.getCode())){
				if(ShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())
						||ShztEnum.WTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
					request.getSession().setAttribute(ConstantsUtil.IS_BUY,true);
				}else {
					request.getSession().setAttribute(ConstantsUtil.IS_BUY,false);
				}
			}
			if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BOTH.getCode())){
				if(ShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())
						|| ShztEnum.WTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
					request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY,true);
				}else {
					request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY,false);
				}
				if(ShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())
						||ShztEnum.WTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
					request.getSession().setAttribute(ConstantsUtil.IS_BUY,true);
				}else {
					request.getSession().setAttribute(ConstantsUtil.IS_BUY,false);
				}
			}
			request.getSession().setAttribute(ConstantsUtil.SESSION_COMPANY, supplyData.getDatas().get(0));
		}else{
			request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY,false);
			request.getSession().setAttribute(ConstantsUtil.IS_BUY,false);
			request.getSession().setAttribute(ConstantsUtil.SESSION_COMPANY, new CompanyInfoExtend());
		}
		return DataResult.success(1);
	}
	@AuthLoginAnnotation
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index");
	}
}
