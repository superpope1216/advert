package com.pope.advert.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pope.advert.common.code.CompanyClassifyEnum;
import com.pope.advert.common.code.HttpCodeEnum;
import com.pope.advert.common.code.ShztEnum;
import com.pope.advert.entity.yhgl.CompanyInfo;
import com.pope.advert.service.dto.DataResult;
import com.wisedu.crowd.common.util.ConstantsUtil;

public class AuthIsBuyInterceptor implements HandlerInterceptor {
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
		if(!(handler instanceof HandlerMethod)){
    		return true;
    	}
		HttpSession session = request.getSession();
		HandlerMethod methodHandler=(HandlerMethod) handler;
		AuthIsBuyAnnotation auth = methodHandler.getMethodAnnotation(AuthIsBuyAnnotation.class);
		if (auth == null) {
			return true;
		}
        int errCode=-1;
        if(checkLogin(methodHandler,request)){
        	CompanyInfo com=(CompanyInfo)request.getSession().getAttribute(ConstantsUtil.SESSION_COMPANY);
        	if(com!=null && (com.getFlag().equals(CompanyClassifyEnum.BUY.getCode()) ||com.getFlag().equals(CompanyClassifyEnum.BOTH.getCode()))){
        		if(ShztEnum.DSH.getCode().equals(com.getBuyShzt())){
        			errCode=HttpCodeEnum.BUY_SFRZ_PASSING.getCode();
        		}else if(ShztEnum.WTG.getCode().equals(com.getBuyShzt())){
        			errCode=HttpCodeEnum.BUY_SFRZ_NOT_PASS.getCode();
        		}else if(ShztEnum.CG.getCode().equals(com.getBuyShzt())) {
        			errCode=HttpCodeEnum.IS_NOT_BUY.getCode();
        		}
        		else{
        			return true;
        		}
        	}else{
        		errCode=HttpCodeEnum.IS_NOT_BUY.getCode();
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
	        	AuthIsBuyAnnotation authIsBuyAnnotation=methodHandler.getMethodAnnotation(AuthIsBuyAnnotation.class);
	        	if(authIsBuyAnnotation==null){
	        		return true;
	        	}else{
	        		if (request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX) != null) {
		    			return true;
		    		}else{
		    			return false;
		    		}
	        	}
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
