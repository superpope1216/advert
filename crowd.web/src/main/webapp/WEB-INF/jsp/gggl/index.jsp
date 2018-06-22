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
										style="margin-right: 10px;"></i>管理广告资源
									<div class="pull-right">
										<button type="button" id="btnSupply" class="btn btn-link">
											<i class="fa fa-edit my-text-color" aria-hidden="true"
												style="margin-right: 10px;"></i>发布新广告资源
										</button>
									</div>
								</h3>
								
							</div>
							<div class="row my-mt-20">
								<div class="mygglx-parent" id="headerGg"></div>
							</div>

							<div class="row " style="margin-top: 20px;">
								<div class="row ">
									<div class="col-sm-12 pull-right">
										<button type="button"
											class="btn btn-primary btn-sm  pull-right" id="btnSearch">搜索</button>
										<input type="text" id="txtSearch"
											style="width: 150px; height: 30px;"
											class="form-control pull-right">

									</div>
								</div>
								<table class="table table-hover mytable2">
									<thead>
										<tr>
											<th>类别</th>
											<th>资源标题</th>
											<th>价格(元)</th>
											<th>发布/刷新时间</th>
											<th>媒体名称/类别</th>
											<th>广告形式</th>
											<th>显示状态</th>
											<th>操作</th>
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
	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var page_type = "supplyIndex";
		var key = "${key}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>