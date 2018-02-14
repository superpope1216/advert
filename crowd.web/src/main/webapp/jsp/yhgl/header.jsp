<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container met-head">
	<div class="row">
		<div class="col-xs-6 col-sm-6 logo">
			<ul class="list-none">
				<li><a
					href="<%=request.getContextPath() %>/index.jsp"
					class="met-logo"><img
						src="<%=request.getContextPath()%>/statics/images/header/logo.png" /></a></li>

				<li>用户中心</li>

			</ul>
		</div>

		<div class="col-xs-6 col-sm-6 user-info">
			<ol class="breadcrumb pull-right">
				<li>${sessionScope.SESSION_YHJBXX.sjh}</li>
				<li><a
					href="https://show.metinfo.cn/muban/M1156014/381/member/login.php?lang=cn&a=dologout"
					title="退出登录">退出登录</a></li>

				<li><a
					href="<%=request.getContextPath() %>/index.jsp"
					title="返回首页">返回首页</a></li>
			</ol>
		</div>
	</div>

</div>