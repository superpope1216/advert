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
		<div style="clear:both;">
			<div class=" mobile-not-padding"
				style="margin-left: 10px; margin-right: 10px">
				<div class="product-cut auto">
					<div class="product-content index">
						<div class="product-list">
							<ul class="product-ul">

								<li class="product-li"><c:forEach items="${hwggxs}"
										var="data" varStatus="status">
										<div class="col-sm-6" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyHwzyCenter/index?flag=1&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self' style="padding: 5px;">
												${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${dsggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyDszyCenter/index?flag=2&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${gbggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyGbzyCenter/index?flag=3&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${bzggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyBzzyCenter/index?flag=4&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${zzggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyZzzyCenter/index?flag=6&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${xmtggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyXmtzyCenter/index?flag=5&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

						<div class="product-list">
							<ul class="product-ul">
								<li class="product-li"><c:forEach items="${wlggxs}"
										var="data" varStatus="status">
										<div class="col-sm-12" style="margin-bottom: 0px;">
											<a
												href="<%=request.getContextPath() %>/supplyZzzyCenter/index?flag=7&queryGgxs=${data.lbdm}"
												title="${data.lbmc}" target='_self'> ${data.lbmc} </a>
										</div>
									</c:forEach></li>

							</ul>
						</div>

					</div>
					<div class="row">
						<div class="col-xs-6" id="mainDiv" style="width: 60%">
							<div id="mainLeftDiv"
								style="width: 200px; float: left; height: 360px; position: relative;">
								<div
									class="product-class has-banner index swiper-container-vertical swiper-container-free-mode">
									<ul class="product-class-wrapper"
										style="transform: translate3d(0px, 0px, 0px);">

										<li class="product-class-slide swiper-slide-next"><a
											href="product/product.php?lang=cn&amp;class2=119"
											title="户外广告资源">户外广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=120"
											title="电视广告资源">电视广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=121"
											title="广播广告资源">广播广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=122"
											title="报纸广告资源">报纸广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=124"
											title="杂志广告资源">杂志广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=125"
											title="网络广告资源">网络广告资源</a><i class="fa fa-angle-right"></i></li>

										<li class="product-class-slide"><a
											href="product/product.php?lang=cn&amp;class2=126"
											title="新媒体广告资源">新媒体广告资源</a><i class="fa fa-angle-right"></i></li>


									</ul>
								</div>
							</div>

							<div
								style="float: left; height: 360px; width: calc(100% -200px); width: -webkit-calc(100% - 200px); width: -moz-calc(100% - 200px);"
								id="mainRightDiv">
								<div class="met-banner banner-ny-h index fixedheight"
									data-height="360|360|360">
									<div class="slick-slide">
										<img class="cover-image" style="height: 360px;"
											src="/crowd/statics/images/header/b1.png" alt="">

									</div>

									<div class="slick-slide">
										<img class="cover-image" style="height: 360px;"
											src="/crowd/statics/images/header/b1.png" alt="">

									</div>

									<div class="slick-slide">
										<img class="cover-image" style="height: 360px;"
											data-lazy="/crowd/statics/images/header/b1.png" alt="">

									</div>


								</div>
							</div>

						</div>
						<div class="col-xs-3" style="width: 20%; height: 360px;">
							<div style="padding-right: 2px;">
								<div
									style="border-top:1px dotted;border-bottom:1px dotted;text-align: center; color: #32c5d2 !important; font-size: 16px;  padding-bottom: 10px; font-weight: 700">广告求购
								</div>
								<ul class="feeds" id="tblQg" style="margin-top:4px;">

								</ul>
								<div class="btn-group btn-group-devided" data-toggle="buttons"
									style="margin-top: 10px">
									<button type="button" data-key="1" data-option="edit"
										class="btn btn-link">发布求购</button>
									<button type="button" data-key="1" data-option="more"
										class="btn btn-link">更多</button>
								</div>
							</div>
						</div>
						<div class="col-xs-3" style="width: 20%; height: 360px;">
							<div style="padding-left: 2px;">
								<div
									style="border-top:1px dotted;border-bottom:1px dotted;text-align: center; color: #32c5d2 !important; font-size: 16px; padding-bottom: 10px; font-weight: 700">广告招标
								</div>
								<ul class="feeds" id="tblZb" style="margin-top:4px;">

								</ul>
								<div class="btn-group btn-group-devided" data-toggle="buttons"
									style="margin-top: 10px">
									<button type="button" data-key="1" data-option="edit"
										class="btn btn-link">发布招标</button>
									<button type="button" data-key="1" data-option="more"
										class="btn btn-link">更多</button>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</header>
	<div class="container mobile-not-padding">
		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">户外广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="1"
							data-option="edit" class="toggle">发布户外广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="1" data-option="edit"
							class="more">更多户外广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulHwzy"></div>
				</div>
			</div>
		</div>
		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">电视广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<button type="button" data-key="2" data-option="edit"
							class="btn btn-link">发布电视广告资源</button>
						<button type="button" data-key="2" data-option="more"
							class="btn btn-link">更多电视广告资源</button>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulDszy"></div>
				</div>
			</div>
		</div>
		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">广播广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="3"
							data-option="edit" class="toggle">发布广播广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="3" data-option="edit"
							class="more">更多广播广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulGbzy"></div>
				</div>
			</div>
		</div>

		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">报纸广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="4"
							data-option="edit" class="toggle">发布报纸广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="4" data-option="edit"
							class="more">更多报纸广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulBzzy"></div>
				</div>
			</div>
		</div>


		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">杂志广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="6"
							data-option="edit" class="toggle">发布杂志广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="6" data-option="edit"
							class="more">更多杂志广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulZzzy"></div>
				</div>
			</div>
		</div>
		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">网络广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="7"
							data-option="edit" class="toggle">发布网络广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="7" data-option="edit"
							class="more">更多网络广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulWlzy"></div>
				</div>
			</div>
		</div>
		<div class="portlet light portlet-fit bordered"
			style="border: 0px solid #e7ecf1 !important; margin-bottom: 0px;">
			<div class="portlet-title">
				<div class="caption">
					<i class=" icon-layers font-green"></i> <span
						class="caption-subject font-green bold uppercase">新媒体广告资源</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active">
							<input type="radio" name="options" data-key="7"
							data-option="edit" class="toggle">发布新媒体广告资源
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input
							type="radio" name="options" data-key="7" data-option="edit"
							class="more">更多新媒体广告资源
						</label>
					</div>
				</div>

			</div>
			<div class="portlet-body">
				<div class="mt-element-card mt-element-overlay">
					<div class="row" id="ulXmtzy"></div>
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
		var jsonurl = '', totalurl = '', delurl = '', lang_emptycart = '购物车中还没有商品，赶紧选购吧！';
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
	<script
		src="<%=request.getContextPath()%>/statics/pagejs/hall/index.js"></script>
	<script src="<%=request.getContextPath()%>/statics/pagejs/index.js"></script>
</body>
</html>