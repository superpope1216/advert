<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String menuFlag = request.getParameter("flag");
%>
<%!public String setActive(String _menuFlag, String flag) {

		if (flag.equals(_menuFlag)) {
			return " active ";
		}
		if (StringUtil.isEmpty(_menuFlag) && "xqfxx".equals(flag)) {
			return " active ";
		}
		return "";
	}%>
<div class="dropdown m-b-15 hidden-lg-up shop-user-nav">
		<button type="button" class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">需求方中心</button>
		<div class="dropdown-menu animate w-full" role="menu">
			<a class="dropdown-item <%=setActive(menuFlag, "xqfxx")%>" href="<%=request.getContextPath()%>/xqfxx/index?flag=xqfxx">个人中心</a>
			<a class="dropdown-item <%=setActive(menuFlag, "xqfconfirm")%>" href="<%=request.getContextPath()%>/xqfConfrim/index?flag=xqfconfirm">基本信息</a>
	        <a class="dropdown-item <%=setActive(menuFlag, "order")%>" href="<%=request.getContextPath()%>/xqfOrder/index?flag=order">我的需求</a>
			<a class="dropdown-item <%=setActive(menuFlag, "money")%>" href="<%=request.getContextPath()%>/xqfMoney/index?flag=money">结算信息</a>
		</div>
	</div>
<div class="panel row m-b-0 m-r-15 hidden-md-down" boxmh-h>
	<div class="panel-body">
		<h2 class="m-l-30 font-size-18 font-weight-unset">企业商铺管理</h2>
		<ul class="list-group m-l-15 met-sidebar-nav">
			<li class="list-group-item <%=setActive(menuFlag, "xqfxx")%>"><a
				href="<%=request.getContextPath()%>/xqfxx/index?flag=xqfxx">基本信息管理</a></li>
			<li class="list-group-item <%=setActive(menuFlag, "xqfconfirm")%>"><a
				href="<%=request.getContextPath() %>/xqfConfrim/index?flag=xqfconfirm">地图位置管理</a></li>
			<li class="list-group-item <%=setActive(menuFlag, "order")%>"><a
				href="<%=request.getContextPath()%>/xqfOrder/index?flag=order">企业认证管理</a></li>
			<!-- 
			<li class="list-group-item <%=setActive(menuFlag, "deskstop")%>"><a
				href="<%=request.getContextPath()%>/deskstop/index?flag=deskstop">我的云桌面</a></li> -->
			
			<li class="list-group-item <%=setActive(menuFlag, "money")%>"><a
				href="<%=request.getContextPath()%>/xqfMoney/index?flag=money">企业资质管理</a></li>
						<li class="list-group-item <%=setActive(menuFlag, "money")%>"><a
				href="<%=request.getContextPath()%>/xqfMoney/index?flag=money">联系方式管理</a></li>
			
		</ul>
	</div>
</div>