<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="  ">
<head>
<%@ include file="/jsp/top2.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet' href='<%=request.getContextPath()%>/statics/css/yhgl/login.css'><style>
</head>
<style>
.met-member {
	background-color:;
}

.login_index {
	background-color:;
}
</style>
<body>
	<%@include file="/jsp/header_not_login.jsp" %>

	<div class="login_index met-member">
		<div class="container">
			<form method="post">
				<div class="form-group">
					<input type="text" name="username" required class="form-control"
						placeholder="手机号" data-bv-notempty="true"
						data-bv-notempty-message="此项不能为空">
				</div>
				<div class="form-group">
					<input type="password" name="password" required
						class="form-control" placeholder="密码" data-bv-notempty="true"
						data-bv-notempty-message="此项不能为空">
				</div>

				<div class="login_link">
					<a
						href="javascript:void(0)">忘记密码？</a>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					id="btnLogin">登录</button>


				<a class="btn btn-lg btn-info btn-block"
					href="<%=request.getContextPath()%>/register/index">没有账号？现在去注册</a>

			</form>
		</div>
	</div>

	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "login";
			var backurl="${backurl}";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer_bq.jsp"%>

	</footer>

</body>
</html>