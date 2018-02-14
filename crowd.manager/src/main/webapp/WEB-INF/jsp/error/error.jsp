<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top.jsp" %>
<body>
	<div class="container">
		<div class="col-xs-12 text-center" style="margin-top:100px;">
			<img src="<%=request.getContextPath() %>/statics/images/error.png">
		</div>
		<div class="col-xs-12 text-center" style="margin-top:10px;font-size:18px;">
			<c:choose>
		<c:when test="${errorCode eq '-10'}">
			您还没有登录系统，<span id="time">5</span>秒后将会自动跳转到登录画面，请耐心等待！
			
		</c:when>
		
		<c:when test="${errorCode eq '-7'}">
			您还没有申请成为需求方，<span id="time">5</span>秒后将会自动跳转到需求方申请画面，请耐心等待！
		</c:when>
		<c:when test="${errorCode eq '-8'}">
			您的需求方身份认证信息还正在审核中，<span id="time">5</span>秒后将会自动跳转到需求方申请画面，请耐心等待！
		</c:when>
		<c:when test="${errorCode eq '-9'}">
			您的需求方身份认证信息审核不通过，<span id="time">5</span>秒后将会自动跳转到需求方申请画面，请耐心等待！
		</c:when>
		<c:when test="${errorCode eq '-11'}">
			您还没有申请成为开发方，<span id="time">5</span>秒后将会自动跳转到申请画面，请耐心等待！
		</c:when>
		<c:when test="${errorCode eq '-12'}">
			您还没有申请成为开发方，<span id="time">5</span>秒后将会自动跳转到申请画面，请耐心等待！
		</c:when>
			<c:when test="${errorCode eq '-12'}">
			您的开发者身份没有审核通过，<span id="time">5</span>秒后将会自动跳转到申请画面，请耐心等待！
		</c:when>
	</c:choose>
	<p>急性子等不起!!!<i class="fa fa-hand-o-right" aria-hidden="true" style="margin-left:20px;"></i><button id="btn" type="button" class="btn btn-link">点击前往</button>
		</div>
	</div>
	
	<script src="<%=request.getContextPath()%>/statics/js/jquery.js"></script>
	
<script language="javascript">
	var errorCode="${errorCode}";
	var i=6;
	var timer=setInterval(function(){
		if(i==1){
			if(errorCode=="-1"){
				window.location.href=basePath+"/login.jsp";
			}
			
		}else{
			i--;
			$("#time").html(i);
		}
	},1000);
	
	$(document).ready(function(){
		$("#btn").click(function(){
			if(errorCode=="-1"){
				window.location.href=basePath+"/login.jsp";
			}
		});
	});
	
</script>
</body>
</html>