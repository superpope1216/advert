<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html class="  ">
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/rwgl/rwxxDetail.css'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/card.css'>
	<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/advert.css'>
</head>
<body>
	<!--[if lte IE 8]>
<div class="text-center padding-top-50 padding-bottom-50 bg-blue-grey-100">
  <p class="browserupgrade font-size-18">
	你正在使用一个<strong>过时</strong>的浏览器。请<a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
  </p>
</div>
<![endif]-->
	<header>
		<%@include file="/jsp/header.jsp"%>
	</header>
	<div class="met-position  pattern-show">
		<div class="container">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/supplyHwzyCenter/index"
						title="广告出售"> <i class="icon wb-home" aria-hidden="true"></i>广告出售
					</a></li>
					<li><a href="<%=request.getContextPath()%>/supplyXmtzyCenter/index" title="新媒体广告">新媒体广告</a></li>
				</ol>
			</div>
		</div>
	</div>
	<section class="met-shownews animsition">
		<div class="container">
			<div class="col-md-9 met-shownews-body">
				<div class="row">
					<div class="met-shownews-header">
						<div class="col-md-12 info "
							style="padding-bottom: 5px; border-bottom: 0px;margin-bottom:0px;">
							<div class="col-md-8 color-333">
								<h1>
									<span id="spanName"></span> <span class="label tsxx tsxx-green"
										style="font-size: 13px; vertical-align: middle; " id="spanAdverType"></span>
								</h1>
								<!-- <p style="margin-bottom:0px;">
										<span class="info2">价格/折扣:</span><span id="price" class="red-600" 
											style="font-size: 25px"></span>
								</p> -->
							</div>
						</div>

						<div style="clear: both;"></div>
					</div>
					<div class="met-editor lazyload clearfix" style="padding-top:0px">
						<div class="editorlightgallery">
							<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
								<li class="nav-item "><a class="nav-link active"
									data-toggle="tab" href="" data-state="all">详情信息</a></li>

							</ul>
							<div style="padding-top: 20px;">
									<div id="divDszyInfo">
										
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="row">

					<div class="met-news-bar">
						<div class="card m-b-0" style="text-align: center;">
							<div
								class="card-header  text-xs-center p-30 p-b-15 xqf_header_bg"
								style="text-align: center;">
								<a class="avatar avatar-100 img-bordered m-b-10 bg-white"
									target="_blank" href="javascript:void(0);" title="mycluster">
									<img src="" id="imgCompanyLog">
								</a>
								<div class="font-size-20 " id="divComanyName">
									
								</div>
							</div>
						</div>


						

					</div>

				</div>
			</div>
		</div>
	</section>


	<%@ include file="/jsp/footer/footer.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top hide">
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	
	<script>
		var jsonurl = "";
		var wid = "${wid}";
		var ggxs="${ggxs}";
	</script>

	<%@ include file="/jsp/bottom.jsp"%>


	<script
		src="<%=request.getContextPath()%>/statics/pagejs/supplyview/detail/xmtzyDetail.js"></script>
</body>
</html>
