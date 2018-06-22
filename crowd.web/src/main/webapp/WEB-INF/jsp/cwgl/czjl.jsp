<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<!--[if lte IE 8]>
<div class="text-xs-center m-b-0 bg-blue-grey-100 alert">
    <button type="button" class="close" aria-label="Close" data-dismiss="alert">
        <span aria-hidden="true">×</span>
    </button>
    你正在使用一个 <strong>过时</strong> 的浏览器。请 <a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
</div>
<![endif]-->

<style>
.myTable {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

.myTable th, .myTable td {
	border: 1px solid #ccc;
}

.mygglx-parent {
	float: left;
	margin-left: 1px;
	display: inline;
}

.mygglx {
	float: left;
	border: 1px solid #dcdcdc;
	background-color: #fff;
	width: 100px;
	text-align: center;
	padding: 5px 0px;
	margin-left: -1px;
	display: inline;
}

.mygglx a {
	color: #666;
	font-size: 14px;
	padding-top: 15px;
}

.mygglx strong {
	color: #004CA0;
	font-size: 14px;
}

.mygglx a:hover {
	color: #666;
	font-size: 14px;
}

.mygglx-active {
	float: left;
	border: 1px solid #004CA0;
	background-color: #004CA0;
	width: 100px;
	text-align: center;
	padding: 5px 0px;
	margin-left: -1px;
	display: inline;
}

.mygglx-active>a {
	color: #FFF;
	font-size: 14px;
}

.mygglx-active>a:hover {
	color: #FFF;
	font-size: 14px;
}

.mygglx-active>strong {
	color: #FFF;
	font-size: 14px;
}

.mytable2 {
	font-size: 13px;
}

.mytable2 thead {
	font-weight: bold;
	background: rgb(238, 238, 238);
}
</style>
<body>
	<%@include file="/jsp/header.jsp"%>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">
					<%@include file="/jsp/supply/left_menu.jsp"%>
				</div>

				<div class="col-lg-9">
					<%@include file="/jsp/supply/yhdj_header.jsp"%>
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3 style="font-size: 18px;">
									<i class="fa fa-gear my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>充值记录
									<div class="pull-right">
										<button type="button" id="btnSupply" class="btn btn-link">
											<i class="fa fa-edit my-text-color" aria-hidden="true"
												style="margin-right: 10px;"></i>我要充值
										</button>
									</div>
								</h3>
							</div>
							<div class="row my-mt-20">
								<div class="mygglx-parent" id="headerGg"></div>
							</div>

							<div class="row " style="margin-top: 20px;">
								<table class="table table-hover mytable2">
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
									<tbody id="tblData">

									</tbody>
								</table>
								<div  class="mypaging2 clearfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalCz">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">会员充值</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="post" action="" role="form"
						id="formCzInfo">
						<div class="form-group">
							<label for="firstname" class="col-sm-4 control-label">会员等级选择</label>
							<div class="col-sm-8">
								<select class="form-control " name="djxx" required
									data-fv-notempty-message="此项不能为空">
									<option value="">--请选择--</option>
									<c:forEach items="${djxx}" var="data">
										<option value="${data.wid}">${data.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">年费标准（元）</label>
							<div class="col-sm-8">
								<p class="form-control-static" name="fy">&nbsp;</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">广告资源限制数量（条）</label>
							<div class="col-sm-8">
								<p class="form-control-static" name="ggts">&nbsp;</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">优先级别</label>
							<div class="col-sm-8">
								<p class="form-control-static" name="yxjb">&nbsp;</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">备注说明</label>
							<div class="col-sm-8">
								<p class="form-control-static" name="bz">&nbsp;</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">充值年数</label>
							<div class="col-sm-8">
								<select class="form-control " name="ns" required
									data-fv-notempty-message="此项不能为空">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">充值总金额</label>
							<div class="col-sm-8">
								<p class="form-control-static" style="color: red;" name="czzje">&nbsp;</p>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-private " id="btnFk" >付款</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var page_type = "cwglCzjl";
		var key = "${key}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>