<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top.jsp"%>
<body class="skin-blue sidebar-mini"
	style="height: auto; min-height: 100%;">
	<div class="wrapper" style="height: auto; min-height: 100%;">

		<!-- Main Header -->
		<%@include file="/jsp/header.jsp"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="/jsp/left.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 929px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="row">
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 用户信息</a></li>
						<li class="active">注册用户信息</li>
					</ol>
				</div>
				<div class="row-fluid">
					<div class="row">
						<form id="queryForm" class="form-horizontal" role="form">
							<div class="col-xs-12">
								<div class="form-group ">
									<label for="firstname" class="col-sm-1 control-label pull-left">用户名</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" name="yhm"
											placeholder="请输入用户名">
									</div>
									<label for="firstname" class="col-sm-1 control-label pull-left">手机号</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" name="sjh"
											placeholder="请输入手机号">
									</div>
									
									<div class="col-sm-1"><button type="button" class="btn btn-primary btn-sm"
									id="btnQuery">
									<i class="fa fa-search"></i> 查詢
								</button>
									</div>
								</div>

								
							</div>
						</form>
					</div>
				</div>
			</section>
			<section class="content container-fluid">
				<div class="row">
					<div class="box">
						<div class="box-body">
							<table id="example" class="display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>用户名</th>
										<th>手机号</th>
										<th>邮箱</th>
										<th>注册时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>


			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@include file="/jsp/footer.jsp"%>

		<!-- Control Sidebar -->
		<%@include file="/jsp/left_scroll.jsp"%>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->


	
	<%@ include file="/jsp/bottom.jsp"%>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/pageJs/yhgl/register.js"></script>

</body>
</html>