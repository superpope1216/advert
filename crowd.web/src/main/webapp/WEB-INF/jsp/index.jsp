<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html class="  ">
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/components.css'>

<style>
.index-table {
	table-layout: fixed;
	width: 100%;
}

.index-table, .index-table tr th, .index-table tr td {
	border: 1px dotted #e7ecf1 !important;
}

.index-table tr td, .index-table tr th {
	height: 32px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.index-table tr td {
	font-size: 13px;
	font-family: 宋体;
}

button {
	color: #37474f;
}
</style>
<body>
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
	<div class="news_list_met_27_1 met-index-body newsbox     bgpic"
		m-id="4">
		<div class="container newsbox">
			<!--左边新闻(带轮播图)-->
			<div class="item  col-xs-12 col-md-8">
				<div class="met-banner banner-ny-h index fixedheight"
					data-height="360|360|360">
					<div class="slick-slide">
						<img class="cover-image" style="height: 360px;"
							src="<%=request.getContextPath()%>/statics/images/1521783550332076.jpg"
							alt="">

					</div>

					<div class="slick-slide">
						<img class="cover-image" style="height: 360px;"
							src="<%=request.getContextPath()%>/statics/images/1521783504110901.jpg"
							alt="">

					</div>


				</div>


			</div>
			<div class="item news_list_met_27_2 col-xs-12 col-md-4">
				<div class="met-index-news ">
					<div class="title clearfix">
						<h2 class="news-h">求购</h2>
						<p class="news-desc">
							<a href="<%=request.getContextPath()%>/buyQgPublishing/index"
								style="margin-right: 10px;" title="" target="_self">发布</a> <a
								href="<%=request.getContextPath()%>/qgCenter/index?flag=1"
								title="" target="_self">更多</a>
						</p>

					</div>
					<ul class="news-list" id="tblQg">

					</ul>
				</div>
				<div class="met-index-news " style="margin-top: 10px;">
					<div class="title clearfix">
						<h2 class="news-h">招标</h2>
						<p class="news-desc">
							<a href="<%=request.getContextPath()%>/zbglView/index"
								style="margin-right: 10px;" title="" target="_self">发布</a> <a
								href="<%=request.getContextPath()%>/sjglCenter/index?flag=3"
								title="" target="_self">更多</a>
						</p>

					</div>
					<ul class="news-list" id="tblZb">

					</ul>
					<!-- <div class="more">
						<a href="https://show.metinfo.cn/m/mui089/367/news1/" title=""
							target="_self">更多</a>
					</div> -->
				</div>
			</div>
		</div>
	</div>

	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">户外广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">

								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="1" data-option="edit" value="">发布户外广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="1" data-option="more">更多户外广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulHwzy"></div>
			</div>

		</div>
	</section>
	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="电视广告资源">电视广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">


								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="2" data-option="edit" value="">发布电视广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="2" data-option="more">更多电视广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulDszy"></div>
			</div>

		</div>
	</section>
	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">广播广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">
								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="3" data-option="edit" value="">发布广播广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="3" data-option="more">更多广播广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulGbzy"></div>
			</div>

		</div>
	</section>


	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">报纸广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">
								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="4" data-option="edit" value="">发布报纸广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="4" data-option="more">更多报纸广告资源</button>

							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulBzzy"></div>
			</div>

		</div>
	</section>

	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">杂志广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">

								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="6" data-option="edit" value="">发布杂志广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="6" data-option="more">更多杂志广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulZzzy"></div>
			</div>

		</div>
	</section>
	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">网络广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">

								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="7" data-option="edit" value="">发布网络广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="7" data-option="more">更多网络广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulWlzy"></div>
			</div>

		</div>
	</section>
	<section class="main" style="min-height: 119px;">
		<div class="width-box">
			<div class="column-box ">
				<div
					class="column-nav transform-box swiper-container-horizontal swiper-container-free-mode active">
					<div class="row">
						<div class="col-md-8" style="margin-bottom: 0px;">
							<ol class="column-ul">

								<li class="column-li active swiper-slide-active"><a
									href="javascript:void(0);" title="户外广告资源">新媒体广告资源</a></li>


							</ol>
						</div>
						<div class="col-md-4 text-right" style="margin-bottom: 0px;">
							<div class="btn-group btn-group-devided" data-toggle="buttons">

								<button class="btn red btn-outline btn-circle btn-sm active"
									data-key="7" data-option="edit" value="">发布新媒体广告资源</button>
								<button class="btn red btn-outline btn-circle btn-sm"
									data-key="7" data-option="more">更多新媒体广告资源</button>
							</div>
						</div>
					</div>
				</div>

			</div>

			<div class="mt-element-card mt-element-overlay"
				style="margin-top: 10px;">
				<div class="row" id="ulXmtzy"></div>
			</div>

		</div>
	</section>

	<%@ include file="/jsp/footer/footer.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top hide">
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var jsonurl = '', totalurl = '', delurl = '', lang_emptycart = '购物车中还没有商品，赶紧选购吧！';
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
	<script
		src="<%=request.getContextPath()%>/statics/pagejs/hall/index.js"></script>
	<script src="<%=request.getContextPath()%>/statics/pagejs/index.js"></script>
</body>
</html>