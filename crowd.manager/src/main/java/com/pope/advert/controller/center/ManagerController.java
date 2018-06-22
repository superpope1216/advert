package com.pope.advert.controller.center;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager")
public class ManagerController {

	@RequestMapping("index")
	public String index() throws Exception{
		return "center/manager";
	}
}
