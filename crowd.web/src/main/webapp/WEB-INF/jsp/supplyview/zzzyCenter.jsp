
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html class="  ">
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/card.css'>
<style>
/*模板参数列表*/
.met-muban-paralist.in dl {
	opacity: 1;
	-moz-opacity: 1;
	filter: alpha(opacity = 100);
}

.met-muban-paralist .container {
	padding-right: 14px;
	padding-left: 0px !important;
}

.met-muban-paralist>div {
	padding-bottom: 0px;
}

@media ( max-width : 991px) {
	.met-muban-paralist>div {
		padding-bottom: 10px;
	}
}

@media ( max-width : 767px) {
	.met-muban-paralist>div {
		padding-bottom: 5px;
	}
}

.met-muban-paralist dl {
	overflow: hidden;
	margin-bottom: 0px;
	margin-top: 10px;
	color: #2a333c;
	transition: all 0.5s;
	-moz-transition: all 0.5s;
	-webkit-transition: all 0.5s;
	-o-transition: all 0.5s;
	filter: alpha(opacity = 0);
}

.met-muban-paralist dl dt {
	font-weight: 300;
}

.met-muban-paralist dl dd a.link {
	color: #5e7387;
}

.met-muban-paralist dl dd a.link:hover {
	color: #4e97d9;
}

@media ( min-width : 768px) {
	.met-muban-paralist dl dt {
		width: 100px;
		float: left;
		padding: 7px 0px;
		text-align: left;
	}
	.met-muban-paralist dl dd {
		margin-left: 100px;
	}
}

.met-muban-paralist dl .res-tips {
	top: 5px;
}
</style>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/header.css'>
</head>
<body style="background: #f0f2f5;">
	<!--[if lte IE 8]>
<div class="text-center padding-top-50 padding-bottom-50 bg-blue-grey-100">
  <p class="browserupgrade font-size-18">
	你正在使用一个<strong>过时</strong>的浏览器。请<a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
  </p>
</div>
<![endif]-->
	<div class="load-box"></div>
	<header>
		<%@include file="/jsp/header.jsp"%>
		<div id="header">
			<div class="overlay">
				<%@ include file="/jsp/supply/center_header.jsp"%>
				<!-- /.navbar-collapse -->
			</div>
		</div>
	</header>
	<div class="container">
		<div class="col-xs-12">
			<div class="panel" boxmh-mh>
				<div class="panel-body shop-order"
					style="margin-top: 20px; padding-top: 10px; padding-bottom: 10px;">

					<div class="column-side ">
						<div class="container mobile-not-padding">

							<div class="met-muban-paralist " id="paralist"
								aria-expanded="false" style="">
								<div>
									<div class="met-muban-paralist-body">
										<div class="container padding-bottom-10">
											<dl>
												<dt>
													<i class="fa fa-list" data-original-title="" title=""
														style="margin-right: 10px" id="btnQueryShow"></i>广告形式
												</dt>
												<dd id='ddGgxs'>
													<span style="width: 180px"><a class="btn queryActive link" href="javascript:void(0);"
															data-option="ggxs" title="全部"
															data-key="">全部</a></span>
													<c:forEach items="${ggxs}" var="data" varStatus="status">
														<span style="width: 180px"><a class="btn link" href="javascript:void(0);"
															data-option="ggxs" title="${data.lbmc}"
															data-key="${data.lbdm}">${data.lbmc}</a></span>
													</c:forEach>
												</dd>
											</dl>
											<dl id="dlArea" style="display: none;">
												<dt>
													<span style="margin-right: 19px">&nbsp;</span>地区
												</dt>
												<dd id='ddArea'>
													<span style="width: 180px"><a class="btn queryActive link" href="javascript:void(0);"
															data-option="area" title="全部"
															data-key="">全部</a></span>
													<c:forEach items="${area}" var="data" varStatus="status">

														<span style="width: 180px"><a class="btn link"
															href="javascript:void(0);" data-option="area"
															title="${data.lbmc}" data-key="${data.lbdm}">${data.lbmc}</a></span>
													</c:forEach>
												</dd>
											</dl>
											<dl style="display: none;" id="divQueryCity">
												<dt>
													<span style="margin-right: 19px">&nbsp;</span>城市
												</dt>
												<dd id="ddCity"></dd>
											</dl>
											<dl style="display: none;" id="divQueryDst">
												<dt>
													<span style="margin-right: 19px">&nbsp;</span>电视台
												</dt>
												<dd id="ddDst">

												</dd>
											</dl>
										</div>
									</div>
								</div>
							</div>
							<div class="column-hover">

								<ul></ul>
								<ul></ul>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-9">


				<div class="panel m-b-0" boxmh-mh>
					<div class="panel-body shop-order" style="padding-top: 10px;">
						<div class="row" style="min-height: 200px;">
							<div class="center-left-body">
								<!-- <header class="center-left-header">
								<span class="span-content"><input class="input-DvJ_0"><span
									class="fa fa-search search"></span></span>
							</header> -->
								<div>
									<span style="display: none;"></span>
									<div id="divContent"></div>
								</div>
								<footer class="bg-white">
									<div class="mypaging2 clearfix"></div>
								</footer>
							</div>
						</div>


					</div>
				</div>

			</div>

			<!-- <ul
			class="offers-section blocks-2 blocks-sm-3 blocks-md-4 blocks-xlg-5  met-page-ajax met-grid"
			id="crowd-grid" data-scale="1">
			

		</ul> -->

			<!-- <div class="grey-box">
		<div class="container">
			<div class="host-cut">
				<div class="host-list active">
					<ul class="blocks-2 blocks-sm-3 blocks-md-4 blocks-xlg-5  met-page-ajax met-grid"
						id="crowd-grid" data-scale='1'>

						

						

					</ul>

					<div class="hidden-xs">
						<div class='met_pager'>
							<span class='PreSpan'><</span><a href=../product / class='Ahover'>1</a><a
								href=product.php?lang=cn&class1=118&page=2>2</a><a
								href=product.php?lang=cn&class1=118&page=3>3</a><a
								href=product.php?lang=cn&class1=118&page=2 class='NextA'>></a> <span
								class='PageText'>转至第</span> <input type='text' id='metPageT'
								data-pageurl='product.php?lang=cn&class1=118&page=||3' value='1' />
							<input type='button' id='metPageB' value='页' />
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
 -->
			<div class="col-xs-3">
				<div class="panel m-b-0" boxmh-mh>
					<div class="panel-body shop-order">
						<%@include file="/jsp/supply/fbgglc.jsp" %>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="/jsp/footer/footer.jsp"%>
		<button type="button"
			class="btn btn-icon btn-primary btn-squared met-scroll-top hide">
			<i class="icon wb-chevron-up" aria-hidden="true"></i>
		</button>
		<script>
			var jsonurl = "";
			var classify = "${param.classify}";
			var lbdm = "${flag}";
			var queryGgxs="${queryGgxs}";
		</script>

		<%@ include file="/jsp/bottom.jsp"%>


		<script
			src="<%=request.getContextPath()%>/statics/pagejs/supplyview/index.js"></script>
		<script
			src="<%=request.getContextPath()%>/statics/pagejs/supplyview/zzzyCenter.js"></script>
</body>
</html>
