package com.pope.advert.controller.yhgl.login;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.advert.common.code.HttpCodeEnum;
import com.pope.advert.common.exception.ServiceException;
import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.messages.SmsSendMessage;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.CommonUtil;
import com.wisedu.crowd.common.util.ConditionUtil;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.SessionUser;
import com.wisedu.crowd.common.util.SessionUserUtil;
import com.wisedu.crowd.common.util.StringUtil;

import SmsMessageTempleateEnum.SmsMessageTempleateEnum;

@Controller
@RequestMapping("resetPwd")
public class ResetPwdController extends BaseController{
	
	@Autowired
	private SmsSendMessage smsSendMessage;
	
	@Autowired
	private RegisterInfoService registerInfoService;
	

	/**
	 * 忘记密码页面
	 * @return
	 */
	@RequestMapping("index")
	public String resetPwd(Model model){
		return "yhgl/login/resetPwd";
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("doResetPwd")
	public DataResult<Integer> doResetPwd(String yzm,String phone,String newPassword,String confirmPassword ) throws Exception{
		if(StringUtil.isEmpty(yzm)){
			  throw new ServiceException(-2,"验证码不能为空，请输入！");
	        }
		    if(!validatePhoneCaptchaCode(request,phone,yzm)){
			  throw new ServiceException(-3,"验证码错误，请重新确认");
           }
		    return registerInfoService.resetPwd(phone, newPassword, confirmPassword,this.createCustomOperateLog());
			
	}
	
	/**
	 *  忘记密码  发送验证码
	 * @param phone
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("sendVerification")
	@ResponseBody
	public DataResult<Integer> sendVerification(@RequestParam String phone,HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(phone)){
			throw new ServiceException("手机号不能为空，请输入！");
		}
		String verification=StringUtil.radomString(4);
		
		//判断手机号是否存在   不存在异常
		RegisterInfoExtend  registerInfoExtend=new RegisterInfoExtend();
		registerInfoExtend.setSjh(phone);
		List<RegisterInfoExtend> datas=registerInfoService.selectByCondition(ConditionUtil.createCondition(registerInfoExtend), this.createCustomOperateLog()).getDatas();
		if(CommonUtil.isEmptyList(datas)) {
			throw new ServiceException("该手机号不存在，请重新确认！");
		}
		try{
		String content=SmsMessageTempleateEnum.TITLE.getName()+String.format(SmsMessageTempleateEnum.REGISTER.getName(), verification);
		smsSendMessage.sendMessage(phone, content);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException("发送失败");
		}
		SessionUser sessionUser=new SessionUser(phone, verification, new Date());
		request.getSession().setAttribute(ConstantsUtil.PHONE_VERIFICATION, sessionUser);
		return DataResult.success(1);
	}
	  
	 private boolean validatePhoneCaptchaCode(HttpServletRequest request, String username, String captchaCode) {
			return SessionUserUtil.validateCaptchaCode(request,ConstantsUtil.PHONE_VERIFICATION, captchaCode);
		}
}
