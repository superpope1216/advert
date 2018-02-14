package com.pope.advert.controller.yhgl.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.impl.calendar.BaseCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.interceptor.AuthLoginAnnotation;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.RegisterInfoService;
import com.wisedu.crowd.common.util.ConstantsUtil;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

	@Autowired
	private RegisterInfoService registerInfoService;
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
		return DataResult.success(1);
	}
	@AuthLoginAnnotation
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
