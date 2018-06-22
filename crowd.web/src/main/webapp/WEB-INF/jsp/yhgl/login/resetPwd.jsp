<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/yhgl/login.css'>
	
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>

<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/topcommon.css'>

<style>

.blocks, [class*=blocks-] {
  font-size: 80%;
}

#regTop ul {
    margin-left: 23%;
}
   
</style>
<body>
<div class="container met-head">

	<div class="row">
		<div class="col-xs-6 col-sm-6 logo">
			<ul class="list-none">
				<li><a href="<%=request.getContextPath()%>/index.jsp"
					class="met-logo"><img
						src="<%=request.getContextPath()%>/statics/images/header/logo.png" /></a></li>

				<li>找回密码</li>

			</ul>
		</div>

		<div class="col-xs-6 col-sm-6 user-info">
			<ol class="breadcrumb pull-right">

				<li style="float: right"><a
					href="<%=request.getContextPath()%>/index" title="返回首页">返回首页</a></li>
			</ol>
		</div>
	</div>

</div>

	<div class="register_index met-member" style="padding:30px 0">
		<div class="container">
		  
			
			<!-- 注册 -->
			<form  id="userRegister" class="form-register met-form" method="post" action="" style="display:block;">
				<div class="form-group">
					<h3 style="text-align: center">忘记密码</h3>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" name="sjh" required class="form-control"
							placeholder="手机号"  data-bv-notempty="true" data-bv-remote="false" data-bv-remote-url=""
							data-bv-notempty-message="此项不能为空" data-bv-regexp="true" 
			     data-bv-regexp-regexp="^1[34578]\d{9}$" 
			     data-bv-regexp-message="请输入正确的手机号格式"/>

					</div>
				</div>


				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"></i></span>
						<input type="password" name="newPassword" required class="form-control"
							placeholder="新密码" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空" data-bv-identical="true"
							data-bv-identical-field="confirmPassword"
							data-bv-identical-message="两次密码输入不一致" data-bv-stringlength="true"
							data-bv-stringlength-min="6" data-bv-stringlength-max="30"
							data-bv-stringlength-message="密码必须在6-30个字符之间">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"></i></span>
						<input type="password" name="confirmPassword" required
							data-password="password" class="form-control" placeholder="重复密码"
							data-bv-identical="true" data-bv-identical-field="newPassword"
							data-bv-identical-message="两次密码输入不一致"
							data-bv-notempty-message="此项不能为空">

					</div>
				</div>

				<div class="row login_code">
					<div class="col-xs-8">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-shield"></i></span>
								<input type="text" value="" name="yzm" required
									class="form-control" placeholder="验证码" data-bv-notempty="true"
									data-bv-notempty-message="此项不能为空">
							</div>
						</div>
					</div>
					<div class="col-xs-4 login_code_img">

						<input type="button" value="点击获取验证码" name="code"
							class="form-control" id="btnGetVerification"  style="cursor:pointer;">
					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					id="btnRegister">确认</button>
				<div class="login_link">
					<a href="<%=request.getContextPath()%>/login/index">已有账号？</a>
				</div>
			</form>
		</div>
	</div>
	
	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "resetPwd";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer_bq.jsp"%>

	</footer>
	<%@ include file="/jsp/bottom.jsp"%>

</body>
</html>