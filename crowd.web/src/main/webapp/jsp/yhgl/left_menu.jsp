<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String menuFlag=request.getParameter("flag");
	%>
	<%! 
	public String setActive(String _menuFlag,String flag){
		
		if(flag.equals(_menuFlag)){
			return " active ";
		}
		if(StringUtil.isEmpty(_menuFlag) && "yhjbxx".equals(flag)){
			return "active";
		}
		return "";
	}
	%>
<div class="sidebar-box">
	<div class="list-group">
		<a
			href="<%=request.getContextPath() %>/yhjbxx/index?flag=yhjbxx"
			class="list-group-item <%=setActive(menuFlag,"yhjbxx")%>" title="个人信息">个人信息</a> <a
			href=""
			class="list-group-item <%=setActive(menuFlag,"accountSafe")%>" title="账号安全">账号安全</a>
			 <a
			href="<%=request.getContextPath() %>/favority/index?flag=favortity"
			class="list-group-item <%=setActive(menuFlag,"favortity")%>" title="我的收藏">我的收藏</a>
			 <a
			href="<%=request.getContextPath() %>/messages/index?flag=messages"
			class="list-group-item <%=setActive(menuFlag,"messages")%>" title="消息中心">消息中心</a>

	</div>
</div>