package com.pope.advert.controller.yhgl.login;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.interceptor.AuthLoginAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.code.AreaClassifyEnum;
import com.wisedu.crowd.common.exception.ServiceException;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.SessionUser;
import com.wisedu.crowd.common.util.SessionUserUtil;
import com.wisedu.crowd.common.util.StringUtil;

@Controller
@RequestMapping("register")
public class RegisterController extends BaseController{
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private RegisterInfoService registerInfoService;
	
	@Autowired
	private CompanyInfoService companyInfoService;
	@RequestMapping("index")
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("flag", flag);
		mv.setViewName("yhgl/login/register");
		return mv;
	}
	
	@RequestMapping("sendVerification")
	@ResponseBody
	public DataResult<Integer> sendVerification(@RequestParam String phone,HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(phone)){
			throw new ServiceException("手机号不能为空，请输入！");
		}
		String verification=StringUtil.radomString(4);
		try{
		//String content=SmsMessageTempleateEnum.TITLE.getName()+String.format(SmsMessageTempleateEnum.REGISTER.getName(), verification);
	//	smsSendMessage.sendMessage(phone, content);
		}catch(Exception e){
			throw new ServiceException("发送失败");
		}
		SessionUser sessionUser=new SessionUser(phone, verification, new Date());
		request.getSession().setAttribute(ConstantsUtil.PHONE_VERIFICATION, sessionUser);
		return DataResult.success(1);
	}
	@ResponseBody
	@RequestMapping("register")
	public DataResult<Integer> register(RegisterInfoExtend yhjbxxInfo,String confirmYhmm,String yzm,HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(yzm)){
			throw new ServiceException("验证码不能为空，请重新输入！");
		}
//		if(!validateCaptchaCode(request,yhjbxxInfo.getSjh(),yzm))
//		{
//			throw new ServiceException("验证码错误，请重新输入！");
//		}
		
		
		RegisterInfoExtend datas=registerInfoService.register(yhjbxxInfo, confirmYhmm,this.createCustomOperateLog()).getDatas();
		request.getSession(true).setAttribute(ConstantsUtil.SESSION_YHJBXX, datas);
		return DataResult.success(1);
	}
	
	 private boolean validateCaptchaCode(HttpServletRequest request, String username, String captchaCode) {
			return SessionUserUtil.validateCaptchaCode(request, "verification", captchaCode);
		}
	 
	 @AuthLoginAnnotation
	 @ResponseBody
	 @RequestMapping("saveCompanyInfo")
	 public DataResult<CompanyInfo> saveCompanyInfo(CompanyInfo companyInfo) throws Exception{
		 return companyInfoService.saveCompanyInfo(companyInfo, this.createCustomOperateLog());
				 
	 }
}
