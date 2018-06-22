package com.pope.advert.controller.buy.publishing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pope.advert.interceptor.AuthIsBuyAnnotation;

@Controller
@RequestMapping("buyPublishing")
public class BuyPublishingController {

	@RequestMapping("index")
	@AuthIsBuyAnnotation
	public ModelAndView index() throws Exception{ 
		ModelAndView mv=new ModelAndView();
		mv.setViewName("buy/publishing");
		return mv;
	}
}
