package com.pope.advert.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pope.advert.common.code.HttpCodeEnum;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.ConstantsUtil;
import com.wisedu.crowd.common.util.StringUtil;

public class LoginInterceptor implements HandlerInterceptor {
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
		String uri=request.getRequestURI();
		if(uri.indexOf("/static/")>=0 
				|| uri.indexOf("/jsp/")>=0
				|| uri.indexOf("/login/")>=0){
			return true;
		}
		HttpSession session = request.getSession();
		HandlerMethod methodHandler=(HandlerMethod) handler;
        int errCode=-1;
        if(checkLogin(methodHandler,request)){
        	return true;
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
		HttpSession session=request.getSession();
		if(session.getAttribute(ConstantsUtil.SESSION_YHJBXX)!=null){
			return true;
		}
		return false;
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
