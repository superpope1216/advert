package com.pope.advert.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pope.advert.controller.BaseController;
import com.pope.advert.entity.yhgl.extend.RegisterInfoExtend;
import com.pope.advert.service.dto.DataResult;
import com.pope.advert.service.yhgl.RegisterInfoService;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

	@Autowired
	private RegisterInfoService registerInfoService;
	@RequestMapping("login")
	public DataResult<RegisterInfoExtend> login(String userName,String password) throws Exception{
		return registerInfoService.loginAdmin(userName, password, this.createCustomOperateLog());
	}
}
