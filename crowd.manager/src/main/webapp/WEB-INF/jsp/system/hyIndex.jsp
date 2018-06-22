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
						<li><a href="#"><i class="fa fa-dashboard"></i> 系统管理</a></li>
						<li class="active">等级设置</li>
					</ol>
				</div>
				<div class="row-fluid">
					<div class="row">
						<form id="queryForm" class="form-horizontal" role="form">
							<div class="col-sm-1"><button type="button" class="btn btn-primary btn-sm"		id="btnNew">
							新建
								</button>
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
										<th>会员级别</th>
										<th>费用</th>
										<th>广告资源数量</th>
										<th>优先级别</th>
										<th>备注说明</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody >
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>

		<div class="modal fade" id="modal-sh">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">编辑</h4>
					</div>
					<div class="modal-body">
						<form id="shForm" class="form-horizontal" role="form">
							<input type="hidden" name="wid" value="">
							<div class="form-group ">
								<label for="firstname"
									class="col-sm-2 col-md-2 control-label ">会员级别<span
									style="color: red">*</span></label>
								<div class="col-sm-10 col-md-10">
									
										<input type="text" name="name" class="form-control" required
											data-fv-notempty-message="此项不能为空">
									
								</div>
							</div>
							<div class="form-group ">
								<label for="firstname"
									class="col-sm-2 col-md-2 control-label ">年费标准<span
									style="color: red">*</span></label>
								<div class="col-sm-10 col-md-10">
									
										<input type="text" name="fy" class="form-control" required
											data-fv-notempty-message="此项不能为空">
									
								</div>
							</div>
							<div class="form-group ">
								<label for="firstname"
									class="col-sm-2 col-md-2 control-label ">广告资源限制数量</label>
								<div class="col-sm-10 col-md-10">
									
										<input type="text" name="ggzyxzsl" class="form-control" placeholder="输入为空表示不限制数量">
									
								</div>
							</div>
							<div class="form-group ">
								<label for="firstname"
									class="col-sm-2 col-md-2 control-label ">优先级别<span
									style="color: red">*</span></label>
								<div class="col-sm-10 col-md-10">
									
										<input type="text" name="yxjb" class="form-control" required
											data-fv-notempty-message="此项不能为空">
									
								</div>
							</div>
							<div class="form-group ">
								<label for="firstname"
									class="col-sm-2 col-md-2 control-label ">备注</label>
								<div class="col-sm-10 col-md-10">
									
										<input type="text" name="bz" class="form-control" required
											data-fv-notempty-message="此项不能为空">
									
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default "
							data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="btnSh">保存</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
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
		src="<%=request.getContextPath()%>/static/pageJs/system/hyIndex.js"></script>

</body>
</html>