<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top2.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet' href='<%=request.getContextPath()%>/statics/css/yhgl/login.css'>
<style>
.met-member {
	background-color:;
}

.login_index {
	background-color:;
}
</style>
<body>
	<%@include file="/jsp/yhgl/header.jsp" %>

	<div class="member-profile met-member">
		<div class="container">
			<div class="member-profile-content">
				<div class="row">

					<div class="col-sm-3 sidebar ">
						<%@ include file="/jsp/yhgl/left_menu.jsp"%>
					</div>

					<div class="col-xs-12 col-sm-9 met-member-index met-member-profile">
						<div class="panel m-b-0" boxmh-mh="" style="min-height: 401px;">
							<div class="panel-body shop-favorite">
								<div>
									<ul class="nav nav-tabs nav-tabs-line shop-favorite-state">
										<li class="nav-item"><a class="nav-link active" href=""
											data-toggle="tab" data-state="0">已收藏</a></li>
										<!--<li class='nav-item'><a class="nav-link" href="#state1" data-toggle="tab" data-state="1">已失效</a></li>-->
									</ul>
								</div>
							</div>
							<ul
									class="shop-favorite-list blocks-2 blocks-sm-3 blocks-md-4 blocks-xxl-5 m-t-20"
									data-scale="1" data-size="&amp;x=400&amp;y=400"
									data-ajax-url="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=domyfavorite"
									data-do-url="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite">

									<li><div class="card card-shadow text-xs-center">
											<figure class="card-img-top overlay overlay-hover">
												<img class="overlay-figure overlay-scale"
													src="<%=request.getContextPath() %>/statics/images/thumb.jpg"
													alt="男士活力醒肤乳" style="">
												<div class="overlay-panel vertical-align hidden-xl-up">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle">123123</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared pos-t-f favorite-remove">X</a>
												</div>
												<figcaption
													class="overlay-panel overlay-background overlay-fade vertical-align hidden-lg-down">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle m-r-5">查看</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared vertical-align-middle favorite-remove">删除</a>
												</figcaption>
											</figure>
											<div class="card-block p-10 bg-blue-grey-100">
												<h4 class="card-title m-b-0 font-size-14">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank">徐工系统开发</a>
												</h4>
												<p class="m-b-0 red-600">￥430.00元</p>
											</div>
										</div></li>
										<li><div class="card card-shadow text-xs-center">
											<figure class="card-img-top overlay overlay-hover">
												<img class="overlay-figure overlay-scale"
													src="<%=request.getContextPath() %>/statics/images/thumb.jpg"
													alt="男士活力醒肤乳" style="">
												<div class="overlay-panel vertical-align hidden-xl-up">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle">123123</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared pos-t-f favorite-remove">X</a>
												</div>
												<figcaption
													class="overlay-panel overlay-background overlay-fade vertical-align hidden-lg-down">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle m-r-5">查看</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared vertical-align-middle favorite-remove">删除</a>
												</figcaption>
											</figure>
											<div class="card-block p-10 bg-blue-grey-100">
												<h4 class="card-title m-b-0 font-size-14">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank">徐工系统开发</a>
												</h4>
												<p class="m-b-0 red-600">￥430.00元</p>
											</div>
										</div></li>
										<li><div class="card card-shadow text-xs-center">
											<figure class="card-img-top overlay overlay-hover">
												<img class="overlay-figure overlay-scale"
													src="<%=request.getContextPath() %>/statics/images/thumb.jpg"
													alt="男士活力醒肤乳" style="">
												<div class="overlay-panel vertical-align hidden-xl-up">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle">123123</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared pos-t-f favorite-remove">X</a>
												</div>
												<figcaption
													class="overlay-panel overlay-background overlay-fade vertical-align hidden-lg-down">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle m-r-5">查看</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared vertical-align-middle favorite-remove">删除</a>
												</figcaption>
											</figure>
											<div class="card-block p-10 bg-blue-grey-100">
												<h4 class="card-title m-b-0 font-size-14">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank">徐工系统开发</a>
												</h4>
												<p class="m-b-0 red-600">￥430.00元</p>
											</div>
										</div></li>
										<li><div class="card card-shadow text-xs-center">
											<figure class="card-img-top overlay overlay-hover">
												<img class="overlay-figure overlay-scale"
													src="<%=request.getContextPath() %>/statics/images/thumb.jpg"
													alt="男士活力醒肤乳" style="">
												<div class="overlay-panel vertical-align hidden-xl-up">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle">123123</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared pos-t-f favorite-remove">X</a>
												</div>
												<figcaption
													class="overlay-panel overlay-background overlay-fade vertical-align hidden-lg-down">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank"
														class="btn btn-xs btn-danger btn-squared vertical-align-middle m-r-5">查看</a><a
														href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn&amp;a=dofavorite"
														data-pid="86"
														class="btn btn-xs btn-default btn-squared vertical-align-middle favorite-remove">删除</a>
												</figcaption>
											</figure>
											<div class="card-block p-10 bg-blue-grey-100">
												<h4 class="card-title m-b-0 font-size-14">
													<a
														href="https://show.metinfo.cn/muban/M1156014/381/product/showproduct.php?lang=cn&amp;id=86"
														title="男士活力醒肤乳" target="_blank">徐工系统开发</a>
												</h4>
												<p class="m-b-0 red-600">￥430.00元</p>
											</div>
										</div></li>
								</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="container met-footer">
			<script type="text/javascript">
				var page_type = "yhjbxx";
			</script>
			<%@ include file="/jsp/bottom.jsp"%>
			<%@ include file="/jsp/footer/footer.jsp"%>

		</footer>
</body>
</html>