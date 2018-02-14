package com.pope.advert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("error")
public class ErrorController {

	@RequestMapping("index")
	public ModelAndView index(int errorCode){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errorCode", errorCode);
		return mv;
	}
}
