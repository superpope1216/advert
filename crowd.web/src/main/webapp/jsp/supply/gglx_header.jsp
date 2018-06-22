<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-xs-12">
	<div class="pull-left" data-key="2" data-option="gglx">
		<%
			String gglx = StringUtil.toStr(request.getParameter("gglx"));
		%>

		<%
			if (StringUtil.isEmpty(gglx) || "2".equals(gglx)) {
		%>
		<i class="my-text-color my-border-color my-fa-i-border fa fa-tv fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-color my-fa-text text-center">电视资源</div>
		<%
			} else {
		%>
		<i class=" my-fa-i-border fa fa-tv fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class=" my-fa-text text-center">电视资源</div>
		<%
			}
		%>
	</div>
	<div class="pull-left" data-key="3" data-option="gglx">
		<%
			if ("3".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color  my-fa-i-border fa fa-podcast fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-color my-fa-text text-center">广播资源</div>
		<%
			} else {
		%>
		<i class=" my-fa-i-border fa fa-podcast fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class=" my-fa-text text-center">广播资源</div>
		<%
			}
		%>

	</div>
	<div class="pull-left" data-key="4" data-option="gglx">
		<%
			if ("4".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color my-fa-i-border fa fa-file-text-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-color my-fa-text text-center">报纸资源</div>
		<%
			} else {
		%>
		<i
			class="my-fa-i-border fa fa-file-text-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-fa-text text-center">报纸资源</div>
		<%
			}
		%>

	</div>
	<div class="pull-left" data-key="6" data-option="gglx">
		<%
			if ("6".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color my-fa-i-border fa fa-files-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-color my-fa-texttext-center">杂志资源</div>
		<%
			} else {
		%>
		<i class="my-fa-i-border fa fa-files-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class=" my-fa-texttext-center">杂志资源</div>
		<%
			}
		%>

	</div>
	<div class="pull-left" data-key="1" data-option="gglx">
		<%
			if ( "1".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color my-fa-i-border fa fa-files-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-color my-fa-texttext-center">户外广告</div>
		<%
			} else {
		%>
		<i class="my-fa-i-border fa fa-files-o fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class=" my-fa-texttext-center">户外广告</div>
		<%
			}
		%>

	</div>
	<div class="pull-left" data-key="7" data-option="gglx">
		<%
			if ( "7".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color my-fa-i-border fa fa-wifi fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class=" my-text-colormy-fa-text text-center">网络资源</div>
		<%
			} else {
		%>
		<i class="my-fa-i-border fa fa-wifi fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-fa-text text-center">网络资源</div>
		<%
			}
		%>

	</div>
	<div class="pull-left" data-key="5" data-option="gglx">
		<%
			if ("5".equals(gglx)) {
		%>
		<i
			class="my-text-color my-border-color  my-fa-i-border fa fa-video-camera fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-text-colormy-fa-text text-center">新媒体资源</div>
		<%
			} else {
		%>
		<i
			class="my-fa-i-border fa fa-video-camera fa-4x fa-pull-left fa-border"
			aria-hidden="true"></i>
		<div class="my-fa-text text-center">新媒体资源</div>
		<%
			}
		%>

	</div>
</div>

<script language="javascript">
	$(document).ready(function(){
		$("div [data-option='gglx']").click(function(){
			var _value=$(this).attr("data-key");
			if(_value=="2"){
				window.location.href=basePath+"/dszyPublishing/index?gglx="+_value;
			}
			if(_value=="3"){
				window.location.href=basePath+"/gbzyPublishing/index?gglx="+_value;
			}
			if(_value=="4"){
				window.location.href=basePath+"/bzzyPublishing/index?gglx="+_value;
			}
			if(_value=="6"){
				window.location.href=basePath+"/zzzyPublishing/index?gglx="+_value;
			}
			if(_value=="7"){
				window.location.href=basePath+"/wlzyPublishing/index?gglx="+_value;
			}
			if(_value=="5"){
				window.location.href=basePath+"/xmtzyPublishing/index?gglx="+_value;
			}
			if(_value=="1"){
				window.location.href=basePath+"/hwzyPublishing/index?gglx="+_value;
			}
		});
	})
</script>