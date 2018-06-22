package com.pope.advert.controller.yhgl.login;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.common.code.AreaClassifyEnum;
import com.pope.advert.common.code.CompanyClassifyEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.entity.yhgl.RegisterInfo;
import com.pope.advert.entity.yhgl.extend.CompanyInfoExtend;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.interceptor.AuthLoginAnnotation;
import com.pope.advert.service.dictionary.DictionaryService;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.yhgl.CompanyInfoService;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.DateUtil;
import com.wisedu.crowd.common.util.SessionUser;
import com.wisedu.crowd.common.util.SessionUserUtil;
import com.wisedu.crowd.common.util.StringUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Controller
@RequestMapping("register")
public class RegisterController extends BaseController{
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Autowired
	private RegisterInfoService registerInfoService;
	
	@Autowired
	private CompanyInfoService companyInfoService;
	@Autowired
	private SmsSendMessage smsSendMessage;
	@RequestMapping("index")
	public ModelAndView index(String flag) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("area", dictionaryService.selectAreaByClassify(AreaClassifyEnum.AREA.getCode(), this.createCustomOperateLog()).getDatas());
		mv.addObject("flag", StringUtil.toStr(flag));
		mv.addObject("isBuy", request.getSession().getAttribute(ConstantsUtil.IS_BUY)==null?false:request.getSession().getAttribute(ConstantsUtil.IS_BUY));
		mv.addObject("isSupply", request.getSession().getAttribute(ConstantsUtil.IS_SUPPLY)==null?false:request.getSession().getAttribute(ConstantsUtil.IS_SUPPLY));
		
		mv.setViewName("yhgl/login/register");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	public DataResult<CompanyInfo> select(){
		Object object=(Object)request.getSession().getAttribute(ConstantsUtil.SESSION_COMPANY);
		CompanyInfo companyInfo=new CompanyInfo();
		if(object!=null){
			companyInfo=(CompanyInfo)object;
		}
		return DataResult.success(companyInfo);
	}
	@ResponseBody
	@RequestMapping("register")
	public DataResult<Integer> register(RegisterInfoExtend yhjbxxInfo,String confirmYhmm,String yzm,HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(yzm)){
			throw new ServiceException("验证码不能为空，请重新输入！");
		}
		if(!validateCaptchaCode(request,yhjbxxInfo.getSjh(),yzm))
		{
			throw new ServiceException("验证码错误，请重新输入！");
		}
		
		
		RegisterInfoExtend datas=registerInfoService.register(yhjbxxInfo, confirmYhmm,this.createCustomOperateLog()).getDatas();
		request.getSession(true).setAttribute(ConstantsUtil.SESSION_YHJBXX, datas);
		return DataResult.success(1);
	}
	
	 private boolean validateCaptchaCode(HttpServletRequest request, String username, String captchaCode) {
			return SessionUserUtil.validateCaptchaCode(request, ConstantsUtil.PHONE_VERIFICATION, captchaCode);
		}
	 
	 @AuthLoginAnnotation
	 @ResponseBody
	 @RequestMapping("saveCompanyInfo")
	 public DataResult<CompanyInfo> saveCompanyInfo(CompanyInfo companyInfo,String registerFlag) throws Exception{
		 if("1".equals(registerFlag)){
			boolean isBuy=(boolean) request.getSession().getAttribute(ConstantsUtil.IS_BUY);
			if(isBuy){
				companyInfo.setFlag(CompanyClassifyEnum.BOTH.getCode());
			}else{
				companyInfo.setFlag(CompanyClassifyEnum.SUPPLY.getCode());
			}
		 }else {
			 boolean isSupply=(boolean) request.getSession().getAttribute(ConstantsUtil.IS_SUPPLY);
				if(isSupply){
					companyInfo.setFlag(CompanyClassifyEnum.BOTH.getCode());
				}else{
					companyInfo.setFlag(CompanyClassifyEnum.BUY.getCode());
				}
		 }
		 CompanyInfo retCompanyInfo=companyInfoService.saveCompanyInfo(companyInfo, this.createCustomOperateLog()).getDatas();
		
		 if(retCompanyInfo.getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode())){
			 request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY, true);
		 }
		 if(retCompanyInfo.getFlag().equals(CompanyClassifyEnum.BUY.getCode())){
			 request.getSession().setAttribute(ConstantsUtil.IS_BUY, true);
		 }
		 if(retCompanyInfo.getFlag().equals(CompanyClassifyEnum.BOTH.getCode())){
			 request.getSession().setAttribute(ConstantsUtil.IS_SUPPLY, true);
			 request.getSession().setAttribute(ConstantsUtil.IS_BUY, true);
		 }
		 return DataResult.success(retCompanyInfo);
	 }
	 
	 @RequestMapping("sendVerification")
		@ResponseBody
		public DataResult<Integer> sendVerification(@RequestParam String phone,HttpServletRequest request) throws Exception{
			if(StringUtil.isEmpty(phone)){
				throw new ServiceException("手机号不能为空，请输入！");
			}
			String verification=StringUtil.radomString(4);
			
			//判断手机号是否存在
			RegisterInfoExtend  queryRegisterInfoExtend=new RegisterInfoExtend();
			queryRegisterInfoExtend.setSjh(phone);
			List<RegisterInfoExtend> list=registerInfoService.selectByCondition(ConditionUtil.createCondition(queryRegisterInfoExtend), this.createCustomOperateLog()).getDatas();
			
			if(CommonUtil.isNotEmptyList(list)){
				throw new ServiceException(-4,"该手机号已注册，请重新输入手机号！");
	        }
			try{
			String content=SmsMessageTempleateEnum.TITLE.getName()+String.format(SmsMessageTempleateEnum.REGISTER.getName(), verification);
			smsSendMessage.sendMessage(phone, content);
			}catch(Exception e){
				throw new ServiceException("发送失败");
			}
			SessionUser sessionUser=new SessionUser(phone, verification, new Date());
			request.getSession().setAttribute(ConstantsUtil.PHONE_VERIFICATION, sessionUser);
			return DataResult.success(1);
		}
}
