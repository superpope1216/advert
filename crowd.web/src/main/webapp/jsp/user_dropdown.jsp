
<%@page import="com.pope.advert.common.code.CompanyClassifyEnum"%>
<%@page import="com.wisedu.crowd.common.util.ConditionUtil"%>
<%@page import="com.pope.advert.entity.yhgl.extend.CompanyInfoExtend"%>
<%@page import="com.pope.advert.service.yhgl.CompanyInfoService"%>
<%@page import="com.pope.advert.entity.yhgl.extend.RegisterInfoExtend"%>
<%@page import="com.pope.advert.service.dto.DataResult"%>
<%@page import="com.pope.advert.entity.dto.QueryCondition"%>
<%@page import="com.pope.advert.common.code.ShztEnum"%>
<%@page import="com.wisedu.crowd.common.util.CommonUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@page import="com.wisedu.crowd.common.util.ConstantsUtil"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	boolean isSupply = false;
	
	
	
	boolean isBuy = false;
	if(session.getAttribute(ConstantsUtil.IS_SUPPLY)!=null){
		isSupply=(boolean)session.getAttribute(ConstantsUtil.IS_SUPPLY);
	}
	if(session.getAttribute(ConstantsUtil.IS_BUY)!=null){
		isBuy=(boolean)session.getAttribute(ConstantsUtil.IS_BUY);
	}
	WebApplicationContext wac = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
	Object yhjbxxObject = session.getAttribute(ConstantsUtil.SESSION_YHJBXX);
	if (yhjbxxObject != null) {
		RegisterInfoExtend yhjbxxInfo = (RegisterInfoExtend) request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX);
		if (yhjbxxInfo != null && !StringUtil.isEmpty(yhjbxxInfo.getWid())) {
			System.out.println("=======================1");
			Object companyObject = session.getAttribute(ConstantsUtil.SESSION_COMPANY);
			System.out.println("=======================companyObject===="+companyObject);
			CompanyInfoExtend companyInfoExtend=null;
			if (companyObject == null) {
				System.out.println("=======================2");
				CompanyInfoService companyInfoService = (CompanyInfoService) wac.getBean("companyInfoService");//如是注解的Service取注解
				CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
				queryCompanyInfoExtend.setRegisterId(yhjbxxInfo.getWid());
				DataResult<List<CompanyInfoExtend>> supplyData = companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend),
						null);
				if(CommonUtil.isNotEmptyList(supplyData.getDatas())){
					companyInfoExtend=supplyData.getDatas().get(0);
					System.out.println("==========supplyData.getDatas().get(0)=="+supplyData.getDatas().get(0));
					session.setAttribute(ConstantsUtil.SESSION_COMPANY, companyInfoExtend);
				}
			}else{
				System.out.println("=======================3");
				companyInfoExtend=(CompanyInfoExtend)companyObject;
				if(isSupply==false ||isBuy==false){
					System.out.println("=======================4");
			    	CompanyInfoService companyInfoService = (CompanyInfoService) wac.getBean("companyInfoService");//如是注解的Service取注解
					CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
			    	System.out.println("====="+yhjbxxInfo.getWid());
					queryCompanyInfoExtend.setRegisterId(yhjbxxInfo.getWid());
					DataResult<List<CompanyInfoExtend>> supplyData = companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend),
							null);
					if (CommonUtil.isNotEmptyList(supplyData.getDatas())) {
						companyInfoExtend=supplyData.getDatas().get(0);
						session.setAttribute(ConstantsUtil.SESSION_COMPANY, companyInfoExtend);
					}
				}
			}
			if (companyInfoExtend != null) {
				System.out.println("=======su2=="+companyInfoExtend.getSupplyShzt());
				
			    if(isSupply==false ||isBuy==false){
						if(companyInfoExtend.getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode())){
							if(ShztEnum.YTG.getCode().equals(companyInfoExtend.getSupplyShzt())
									|| ShztEnum.WTG.getCode().equals(companyInfoExtend.getSupplyShzt())){
								isSupply=true;
							}
						}
						if(companyInfoExtend.getFlag().equals(CompanyClassifyEnum.BUY.getCode())){
							if(ShztEnum.YTG.getCode().equals(companyInfoExtend.getBuyShzt())
									||ShztEnum.WTG.getCode().equals(companyInfoExtend.getBuyShzt())){
								isBuy=true;
							}
						}
						if(companyInfoExtend.getFlag().equals(CompanyClassifyEnum.BOTH.getCode())){
							if(ShztEnum.YTG.getCode().equals(companyInfoExtend.getSupplyShzt())
									|| ShztEnum.WTG.getCode().equals(companyInfoExtend.getSupplyShzt())){
								isSupply=true;
							}
							if(ShztEnum.YTG.getCode().equals(companyInfoExtend.getBuyShzt())
									||ShztEnum.WTG.getCode().equals(companyInfoExtend.getBuyShzt())){
								isBuy=true;
							}
						}
			    	
			    }
			}
		}
	}
	System.out.println("==========================is_supply===="+isSupply);
	System.out.println("==========================isBuy===="+isBuy);
	session.setAttribute(ConstantsUtil.IS_BUY, isBuy);
	session.setAttribute(ConstantsUtil.IS_SUPPLY, isSupply);
%>
<%
	if (yhjbxxObject != null) {
		RegisterInfoExtend yhjbxxInfo = (RegisterInfoExtend) request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX);
%>

<li class="dropdown"><a href="javascript:;"
	class="navbar-avatar dropdown-toggle" data-toggle="dropdown"
	aria-expanded="false"> <span
		class="avatar avatar-online margin-right-5"> <img
			src="<%=request.getContextPath()%>/statics/images/12.png"
			alt="mycluster">
	</span>
	<span class="caret" style="border-top:0px;"><%=yhjbxxInfo.getYhm() %></span>
</a>
	<ul class="dropdown-menu dropdown-menu-right animate" role="menu">
		<c:if test="${(!empty sessionScope.SESSION_COMPANY)  and ((sessionScope.SESSION_COMPANY.flag eq '1') ||(sessionScope.SESSION_COMPANY.flag eq '3'))}">
			<li role="presentation"><a
				href="<%=request.getContextPath()%>/companyInfo/index?flag=1" role="menuitem">
					<i class="icon wb-user" aria-hidden="true"></i>我是广告卖方
			</a></li>
		</c:if>
		<c:if test="${(!empty sessionScope.SESSION_COMPANY)  and ((sessionScope.SESSION_COMPANY.flag eq '2') ||(sessionScope.SESSION_COMPANY.flag eq '3'))}">
			<li role="presentation"><a
				href="<%=request.getContextPath()%>/companyInfo/index?flag=2" role="menuitem"><i
					class="icon wb-user" aria-hidden="true"></i>我是广告买方</a></li>
		</c:if>



		<li class="divider" role="presentation"></li>
		<li role="presentation"><a
			href="<%=request.getContextPath()%>/login/logout" role="menuitem"><i
				class="icon wb-power" aria-hidden="true"></i> 退出</a></li>
	</ul></li>


<%
	} else {
%>
<a class="login" href="<%=request.getContextPath()%>/login/index">登录</a>
<hr>
<a class="login" href="<%=request.getContextPath()%>/register/index">注册</a>
<%
	}
%>