
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
	</header>
	<div class="met-position  pattern-show">
		<div class="container">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/index"
						title="首页> <i class="icon wb-home" aria-hidden="true"></i>首页
					</a></li>
					<li><a href="<%=request.getContextPath()%>/qyzxNews/index" title="新闻信息">新闻信息</a></li>
				</ol>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-xs-12">
			<div class="panel m-b-0" boxmh-mh style="margin-top: 5px; ">
				<div class="panel-body shop-order" style="padding-top: 10px;">
					<div class="row" style="min-height: 200px;">
						<div class="center-left-body">
							<!-- <header class="center-left-header">
								<span class="span-content"><input class="input-DvJ_0"><span
									class="fa fa-search search"></span></span>
							</header> -->
							<div>
								<div id="divContent"></div>
							</div>
							<footer class="bg-white">
								<div class="mypaging2 clearfix" id="pageContent"></div>
							</footer>
						</div>
					</div>
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
		</script>

		<%@ include file="/jsp/bottom.jsp"%>


		<script
			src="<%=request.getContextPath()%>/statics/pagejs/supplyview/index.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/pagejs/center/qyzxNewsCenter.js"></script>
</body>
</html>
