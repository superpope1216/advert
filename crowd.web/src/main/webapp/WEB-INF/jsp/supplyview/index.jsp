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


				<div class="col-lg-12">
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="col-xs-10">
								<h4>北京人民广播电台广告代理信息</h4>
								<div>
									<table width="100%" class="mytable-border" bgcolor="#cdcdcd"
										style="font-size: 14px;">
										<tbody>
											<tr bgcolor="#FEFCEF">
												<td colspan="2">
													<div class="pull-left">
														<strong class="supply-detail-table-th">代理媒体</strong>：
														北京人民广播电台北京新闻广播FM100.6 &nbsp;&nbsp;&nbsp;时段广告
													</div>
													<div class="pull-right text-right">
														<a
															href="http://www.admaimai.com/BroadCast/DTDetail6_226.htm"
															target="_blank" class="supply-detail-table-gray">北京人民广播电台广告代理公司大全</a>
													</div>
												</td>
											</tr>
											<tr>
												<td width="50%" bgcolor="#FEFCEF">
													<div class="pull-left">
														<strong class="supply-detail-table-th">广告折扣</strong>：<span>2</span>
														折&nbsp;&nbsp;<a
															href="http://www.admaimai.com/Shop/BroadCast/1/599/.htm"
															target="_blank"><img
															src="http://image1.admaimai.com/shop/images/byb01.gif"
															data-bd-imgshare-binded="1"></a>
													</div>
													<div class="pull-right text-right">
														<a
															href="http://www.admaimai.com/BroadCast/PdDetail2_599.htm"
															target="_blank" class="supply-detail-table-gray">查看刊例</a>
													</div>
												</td>
												<td width="50%" bgcolor="#FEFCEF">
													<div class="St_lf">
														<strong class="Sz_f6">广告代理方式</strong>：<strong>一般代理</strong>
													</div>
													<div class="St_rh"></div>
												</td>
											</tr>
											<tr bgcolor="#FEFCEF">
												<td colspan="2"><strong class="Sz_f6">行业限制</strong>：限 <span
													class="Sz_f3">房地产</span> | <span class="Sz_f3">保健品药品</span>
													类客户投放</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div
									style="font-size: 14px; color: #053594; font-size: 14px; margin-top: 30px;">
									补充说明：
									</h5>
									<div class="row">
										<p style="padding-left: 50px;">123123123</p>
									</div>
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
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>