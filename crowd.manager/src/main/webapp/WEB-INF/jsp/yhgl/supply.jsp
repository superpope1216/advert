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
						<c:choose>
							<c:when test="${'1' eq flag}">
								<li class="active">广告卖方信息</li>		
							</c:when>
							<c:otherwise>
								<li class="active">广告买方信息</li>
							</c:otherwise>
						</c:choose>
						
					</ol>
				</div>
				<div class="row-fluid">
					<div class="row">
						<form id="queryForm" class="form-horizontal" role="form">
							<div class="col-xs-12">
								<div class="form-group ">
									<label for="firstname" class="col-sm-1 control-label pull-left">名字</label>
									<div class="col-sm-2">
										<input type="text" class="form-control" name="name"
											placeholder="请输入姓名">
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
										<th>姓名</th>
										<th>联系地址</th>
										<th>联系人</th>
										<th>手机号</th>
										<th>创建时间</th>
										<th>状态</th>
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


	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
	<div class="modal fade" id="modal-sh" >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span></button>
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
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="btnSh">审核</button>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
	<%@ include file="/jsp/bottom.jsp"%>
	<script type="text/javascript">
		var flag="${flag}";
	</script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/static/pageJs/yhgl/supply.js"></script>

</body>
</html>