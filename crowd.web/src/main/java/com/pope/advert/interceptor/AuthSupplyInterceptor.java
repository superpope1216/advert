package com.pope.advert.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.code.CompanyClassifyEnum;
import com.wisedu.crowd.common.code.HttpCodeEnum;
import com.wisedu.crowd.common.code.ShztEnum;
import com.wisedu.crowd.common.util.ConstantsUtil;

public class AuthSupplyInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.print("================="+handler.getClass());
		if(!(handler instanceof HandlerMethod)){
    		return true;
    	}
		HttpSession session = request.getSession();
		HandlerMethod methodHandler=(HandlerMethod) handler;
		AuthSupplyAnnotation auth = methodHandler.getMethodAnnotation(AuthSupplyAnnotation.class);
		if (auth == null) {
			return true;
		}
        int errCode=-1;
        if(checkLogin(methodHandler,request)){
        	CompanyInfo com=(CompanyInfo)request.getSession().getAttribute(ConstantsUtil.SESSION_COMPANY);
        	if(com!=null && (com.getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode()) ||com.getFlag().equals(CompanyClassifyEnum.BOTH.getCode()))){
        		return true;
        	}else{
        		errCode=HttpCodeEnum.IS_NOT_SUPPLY.getCode();
        	}
        }else{
        	errCode=HttpCodeEnum.NOT_LOGIN.getCode();
        	
        }
		//request.getRequestDispatcher("/login/index").forward(request, response);
        if (request.getHeader("Accept").contains("application/json")){
        	response.getWriter().append(JSONObject.toJSONString(DataResult.error(errCode,"")));
        }else{
        	response.sendRedirect(request.getContextPath()+"/error/index?errorCode="+errCode);
        }
    	return false;
	}

	private boolean checkLogin(HandlerMethod methodHandler,HttpServletRequest request){
		   AuthLoginAnnotation auth=methodHandler.getMethodAnnotation(AuthLoginAnnotation.class);
	        
	        if(auth==null){
	        	return true;
	        }else{
	        	if (request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX) != null) {
	    			return true;
	    		}else{
	    			return false;
	    		}
	        }
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
