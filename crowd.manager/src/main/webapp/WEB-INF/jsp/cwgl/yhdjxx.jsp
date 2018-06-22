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
						<li><a href="#"><i class="fa fa-dashboard"></i>会员管理</a></li>
						<li class="active">会员信息</li>
					</ol>
				</div>
				<div class="row-fluid">
					<div class="row">
						<form id="queryForm" class="form-horizontal" role="form">
							<div class="col-xs-12">
								<div class="form-group ">
									<label for="firstname" class="col-sm-1 control-label pull-left">用户名</label>
									<div class="col-sm-2">
										<input type="text" class="form-control"
											name="companyInfo.name" placeholder="请输入公司名">
									</div>
									<label for="firstname" class="col-sm-1 control-label pull-left">会员等级</label>
									<div class="col-sm-2">
										<select name="dj" class="form-control">
											<option value="">--请选择--</option>
											<c:forEach items="${djxx}" var="data">
												<option value="${data.wid}">${data.name}</option>
											</c:forEach>
										</select>
									</div>
									<label for="firstname" class="col-sm-1 control-label pull-left">会员状态</label>
									<div class="col-sm-2">
										<select name="yhzt" class="form-control">
											<option value="">--请选择--</option>
											<c:forEach items="${hyzt}" var="data">
												<option value="${data.lbdm}">${data.lbmc}</option>
											</c:forEach>
										</select>
									</div>

									<div class="col-sm-1">
										<button type="button" class="btn btn-primary btn-sm"
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
										<th>公司名称</th>
										<th>当前会员等级</th>
										<th>开始时间</th>
										<th>结束时间</th>
										<th>用户状态</th>
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

		<div class="modal fade" id="modalCzjl">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">充值记录</h4>
					</div>
					<div class="modal-body">
						<table id="tblCzjl" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>缴费年限</th>
									<th>订单号</th>
									<th>订单状态</th>
									<th>会员级别</th>
									<th>服务开始日期</th>
									<th>服务截止日期</th>
									<th>优先级</th>
									<th>年费标准（元）</th>
									<th>本期金额（元）</th>
								</tr>
							</thead>
						</table>
					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
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
		src="<%=request.getContextPath()%>/static/pageJs/cwgl/yhdjxx.js"></script>

</body>
</html>