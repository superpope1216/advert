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
						<li><a href="#"><i class="fa fa-dashboard"></i>广告售卖管理</a></li>
						<li class="active">网络广告管理</li>
					</ol>
				</div>
				<div class="row-fluid">
					<div class="row">
						<form id="queryForm" class="form-horizontal" role="form">
							<div class="col-xs-12">
								<div class="form-group ">
									<label for="firstname" class="col-sm-1 control-label pull-left">用户名</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" name="companyName"
											placeholder="请输入公司名">
									</div>
									<label for="firstname" class="col-sm-1 control-label pull-left">资源标题</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" name="name"
											placeholder="请输入资源标题">
									</div>
									<label for="firstname" class="col-sm-1 control-label pull-left">审核状态</label>
									<div class="col-sm-2">
										<select name="shzt" class="form-control">
											<option value="">--请选择--</option>
											<c:forEach items="${shzt}" var="data">
												<option value="${data.lbdm}">${data.lbmc}</option>	
											</c:forEach>
										</select>
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
										<th>公司名称</th>
										<th>资源标题</th>
										<th>价格(元)</th>
										<th>发布/刷新时间</th>
										<th>媒体名称/类别</th>
										<th>广告形式</th>
										<th>显示状态</th>
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
		src="<%=request.getContextPath()%>/static/pageJs/supply/wlzyInfo.js"></script>

</body>
</html>