
<%@page import="com.wisedu.crowd.common.code.CompanyClassifyEnum"%>
<%@page import="com.wisedu.crowd.common.util.ConditionUtil"%>
<%@page import="com.pope.advert.entity.yhgl.extend.CompanyInfoExtend"%>
<%@page import="com.pope.advert.service.yhgl.CompanyInfoService"%>
<%@page import="com.pope.advert.entity.yhgl.extend.RegisterInfoExtend"%>
<%@page import="com.pope.advert.service.dto.DataResult"%>
<%@page import="com.pope.advert.entity.dto.QueryCondition"%>
<%@page import="com.wisedu.crowd.common.code.ShztEnum"%>
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
	WebApplicationContext wac = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
	Object yhjbxxObject = session.getAttribute(ConstantsUtil.SESSION_YHJBXX);
	if (yhjbxxObject != null) {
		RegisterInfoExtend yhjbxxInfo = (RegisterInfoExtend) request.getSession().getAttribute(ConstantsUtil.SESSION_YHJBXX);
		if (yhjbxxInfo != null && !StringUtil.isEmpty(yhjbxxInfo.getWid())) {
			
			Object companyObject = session.getAttribute(ConstantsUtil.SESSION_COMPANY);
			if (companyObject == null) {
				CompanyInfoService companyInfoService = (CompanyInfoService) wac.getBean("companyInfoService");//如是注解的Service取注解
				CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
				queryCompanyInfoExtend.setRegisterId(yhjbxxInfo.getWid());

				DataResult<List<CompanyInfoExtend>> supplyData = companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend),
						null);
				if (CommonUtil.isNotEmptyList(supplyData.getDatas())) {
					session.setAttribute(ConstantsUtil.SESSION_COMPANY, supplyData.getDatas().get(0));
					if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode())){
						//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
							isSupply=true;
						//}
					}
					if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BUY.getCode())){
						//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
							isBuy=true;
						//}
					}
					if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BOTH.getCode())){
						//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
							isSupply=true;
						//}
						//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
							isBuy=true;
						//}
					}

				}
			}else{
				CompanyInfoExtend supplyCompanyInfo=(CompanyInfoExtend)companyObject;
			    if(!supplyCompanyInfo.getSupplyShzt().equals(ShztEnum.YTG.getCode())
			    		|| !supplyCompanyInfo.getBuyShzt().equals(ShztEnum.YTG.getCode())){
			    	CompanyInfoService companyInfoService = (CompanyInfoService) wac.getBean("companyInfoService");//如是注解的Service取注解
					CompanyInfoExtend queryCompanyInfoExtend = new CompanyInfoExtend();
					queryCompanyInfoExtend.setRegisterId(yhjbxxInfo.getWid());

					DataResult<List<CompanyInfoExtend>> supplyData = companyInfoService.selectByCondition(ConditionUtil.createCondition(queryCompanyInfoExtend),
							null);
					if (CommonUtil.isNotEmptyList(supplyData.getDatas())) {
						session.setAttribute(ConstantsUtil.SESSION_COMPANY, supplyData.getDatas().get(0));
						if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.SUPPLY.getCode())){
							//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
								isSupply=true;
							//}
						}
						if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BUY.getCode())){
							//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
								isBuy=true;
							//}
						}
						if(supplyData.getDatas().get(0).getFlag().equals(CompanyClassifyEnum.BOTH.getCode())){
							//if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getSupplyShzt())){
								isSupply=true;
							//}
						//	if(YhxxShztEnum.YTG.getCode().equals(supplyData.getDatas().get(0).getBuyShzt())){
								isBuy=true;
							//}
						}

					}
			    	
			    }
			}
		}
	}
	System.out.println("==========================is_supply===="+isSupply);
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
		
	<span class="caret"><%=yhjbxxInfo.getYhm() %></span>
</a>
	<ul class="dropdown-menu dropdown-menu-right animate" role="menu">
		<c:if test="${(!empty sessionScope.SESSION_IS_SUPPLY)  and (sessionScope.SESSION_IS_SUPPLY==true)}">
			<li role="presentation"><a
				href="<%=request.getContextPath()%>/dszyPublishing/index" role="menuitem">
					<i class="icon wb-user" aria-hidden="true"></i>我是广告卖方
			</a></li>
		</c:if>
		<c:if test="${(!empty sessionScope.SESSION_IS_BUY) and (sessionScope.SESSION_IS_BUY==true)}">
			<li role="presentation"><a
				href="<%=request.getContextPath()%>/xqfxx/index" role="menuitem"><i
					class="icon wb-user" aria-hidden="true"></i>我是广告买方</a></li>
		</c:if>



		<li role="presentation"><a
			href="https://show.metinfo.cn/muban/M1156014/381/member/basic.php?lang=cn&nojump=1"
			target="_blank" role="menuitem"><i class="icon wb-settings"
				aria-hidden="true"></i> 账户设置</a></li>
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