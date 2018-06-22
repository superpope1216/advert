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
				<h1>&nbsp;</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">行业资讯管理</a></li>
					<li class="active">公告信息</li>
				</ol>

				<div class="row" id="divQuery"></div>

			</section>
			<section class="content ">
				<div class="row">
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>公司名称</th>
								<th>公告标题</th>
								<th>状态</th>
								<th>创建/刷新时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
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


	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
	<div class="modal fade" id="modal-sh">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">审核信息</h4>
				</div>
				<div class="modal-body">
					<form id="shForm" role="form">
						<input type="hidden" name="wid" value="">
						<div class="form-group ">
							<select name="shzt" class="form-control">
								<option value="2">通过</option>
								<option value="3">不通过</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="btnSh">审核</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<%@ include file="/jsp/bottom.jsp"%>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/pageJs/hyzx/hyzxGg.js"></script>

</body>
</html>