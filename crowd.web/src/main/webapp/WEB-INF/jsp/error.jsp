<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<script language="javascript">
	var errorCode = "${errorCode}";
	var i = 6;
	var timer = setInterval(function() {
		if (i == 1) {
			if (errorCode == "-10") {
				window.location.href = basePath + "/login/index";
			} else if (errorCode == "-11") {
				window.location.href = basePath + "/register/index?flag=1";

			} else if (errorCode == "-7") {
				window.location.href = basePath + "/register/index?flag=2";
			} else if (errorCode == "-8" || errorCode == "-9") {
				window.location.href = basePath + "/companyInfo/index?flag=2";
			} else if (errorCode == "-12" || errorCode == "-13") {
				window.location.href = basePath
						+ "/kfzConfrim/index?flag=kfzconfirm";
			}

		} else {
			i--;
			$("#time").html(i);
		}
	}, 1000);
</script>
<body>
	<div class="container">
		<div class="col-xs-12 text-center" style="margin-top: 100px;">
			<img src="<%=request.getContextPath()%>/statics/images/error.png">
		</div>
		<div class="col-xs-12 text-center"
			style="margin-top: 10px; font-size: 18px;">
			<c:choose>
				<c:when test="${errorCode eq '-10'}">
			您还没有登录系统，<span id="time">5</span>秒后将会自动跳转到登录画面，请耐心等待！
		</c:when>

				<c:when test="${errorCode eq '-7'}">
			您还没有申请成为广告购买方，<span id="time">5</span>秒后将会自动跳转到购买方申请画面，请耐心等待！
		</c:when>
				<c:when test="${errorCode eq '-8'}">
			您的广告购买方认证信息还正在审核中，<span id="time">5</span>秒后将会自动跳转到广告购买方认证画面，请耐心等待！
		</c:when>
				<c:when test="${errorCode eq '-9'}">
			您的广告购买方认证信息审核不通过，<span id="time">5</span>秒后将会自动跳转到广告购买方认证画面，请耐心等待！
		</c:when>
				<c:when test="${errorCode eq '-11'}">
			您还没有申请成为广告售卖方，<span id="time">5</span>秒后将会自动跳转到申请画面，请耐心等待！
		</c:when>
				<c:when test="${errorCode eq '-12'}">
			您的广告售卖方身份认证信息正在审核中，<span id="time">5</span>秒后将会自动跳转到身份认证画面，请耐心等待！
		</c:when>
				<c:when test="${errorCode eq '-13'}">
			您的广告售卖方审核没有审核通过，<span id="time">5</span>秒后将会自动跳转到身份认证画面，请耐心等待！
		</c:when>
			</c:choose>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/statics/js/jquery.js"></script>
</body>
</html>