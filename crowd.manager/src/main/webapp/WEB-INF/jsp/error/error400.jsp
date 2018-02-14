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
			抱歉！！！错误的请求异常
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/statics/js/jquery.js"></script>
</body>
</html>