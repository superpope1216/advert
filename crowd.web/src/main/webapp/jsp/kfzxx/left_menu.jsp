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
		if (StringUtil.isEmpty(_menuFlag) && "kfzxx".equals(flag)) {
			return " active ";
		}
		return "";
	}%>
<div class="dropdown m-b-15 hidden-lg-up shop-user-nav">
		<button type="button" class="btn btn-primary btn-block dropdown-toggle" data-toggle="dropdown">开发者中心</button>
		<div class="dropdown-menu animate w-full" role="menu">
			<a class="dropdown-item <%=setActive(menuFlag, "kfzxx")%>" href="<%=request.getContextPath()%>/kfzxx/index?flag=kfzxx">个人中心</a>
			<a class="dropdown-item <%=setActive(menuFlag, "kfzconfirm")%>" href="<%=request.getContextPath() %>/kfzConfrim/index?flag=kfzconfirm">基本信息</a>
			<a class="dropdown-item <%=setActive(menuFlag, "order")%>" href="<%=request.getContextPath()%>/kfzOrder/index?flag=order">我的订单</a>
			<a class="dropdown-item <%=setActive(menuFlag, "kfzCfOrder")%>" href="<%=request.getContextPath()%>/kfzCfOrder/index?flag=kfzCfOrder">合作订单</a>
			<a class="dropdown-item <%=setActive(menuFlag, "deskstop")%>" href="<%=request.getContextPath()%>/deskstop/index?flag=deskstop">我的云桌面</a>
			<a class="dropdown-item <%=setActive(menuFlag, "kfzrbgl")%>" href="<%=request.getContextPath()%>/kfzrbgl/index?flag=kfzrbgl">我的日报</a>
			<a class="dropdown-item <%=setActive(menuFlag, "money")%>" href="<%=request.getContextPath()%>/kfzmonty/index?flag=money" >结算明细</a>
		</div>
	</div>
<div class="panel row m-b-0 m-r-15 hidden-md-down" boxmh-h>
	<div class="panel-body">
		<h2 class="m-l-30 font-size-18 font-weight-unset">广告主中心</h2>
		<ul class="list-group m-l-15 met-sidebar-nav">
			<li class="list-group-item <%=setActive(menuFlag, "kfzxx")%>"><a
				href="<%=request.getContextPath()%>/kfzxx/index?flag=kfzxx">个人中心</a></li>
			<li class="list-group-item <%=setActive(menuFlag, "kfzconfirm")%>"><a
				href="<%=request.getContextPath() %>/kfzConfrim/index?flag=kfzconfirm">基本信息</a></li>
			<li class="list-group-item <%=setActive(menuFlag, "order")%>"><a
				href="<%=request.getContextPath()%>/kfzOrder/index?flag=order">我的求购</a></li>
				<li class="list-group-item <%=setActive(menuFlag, "order")%>"><a
				href="<%=request.getContextPath()%>/kfzOrder/index?flag=order">我的购物车</a></li>
					<li class="list-group-item <%=setActive(menuFlag, "order")%>"><a
				href="<%=request.getContextPath()%>/kfzOrder/index?flag=order">广告执行管理</a></li>
				<li class="list-group-item <%=setActive(menuFlag, "order")%>"><a
				href="<%=request.getContextPath()%>/kfzOrder/index?flag=order">广告统计报表</a></li>
		</ul>
	</div>
</div>