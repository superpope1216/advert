<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/order.css'>
<style>
.met-member {
	background-color:;
}

.login_index {
	background-color:;
}

.offers-section {
	position: relative;
	width: 100%;
	padding: 0px;
}

.offers-section .offer {
	position: relative;
	margin-bottom: 10px;
}

.offers-section .offer .image {
	position: relative;
	display: block;
	margin-bottom: 22px;
	overflow: hidden;
}

.offers-section .offer .image img {
	position: relative;
	display: block;
	width: 100%;
	height: auto;
}

.offers-section .offer .text {
	position: relative;
	padding-left:10px;
	padding-right:10px;
}


.offers-section .offer .text h3 a {
	color: #505050;
	font-weight: 600;
	position: relative;
}

.xq-title{
	display: block;
	color: #333;
	font-weight: normal;
	font-size: 15px;
	max-height: 22px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.offers-section .offer .text h3 a:hover {
	color: #f254b1;
}

.offers-section .offer .text h3 .price {
	color: #7d3cf3;
	font-size: 18px;
	font-family: 'Playfair Display', serif;
	font-style: italic;
	font-weight: 600;
}

.offers-section .offer .desc {
	position: relative;
	margin-bottom: 15px;
}

.offers-section .offer .overlay-box {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	padding: 40px 25px;
	overflow: auto;
	color: #ffffff;
	z-index: 3;
	background: rgba(242, 84, 177, 0.80);
	opacity: 0;
}

.offers-section .offer:hover .overlay-box {
	opacity: 1;
	-ms-animation-name: fadeInLeft;
	-moz-animation-name: fadeInLeft;
	-op-animation-name: fadeInLeft;
	-webkit-animation-name: fadeInLeft;
	animation-name: fadeInLeft;
	-ms-animation-duration: 500ms;
	-moz-animation-duration: 500ms;
	-op-animation-duration: 500ms;
	-webkit-animation-duration: 500ms;
	animation-duration: 500ms;
	-ms-animation-timing-function: linear;
	-moz-animation-timing-function: linear;
	-op-animation-timing-function: linear;
	-webkit-animation-timing-function: linear;
	animation-timing-function: linear;
	-ms-animation-iteration-count: 1;
	-moz-animation-iteration-count: 1;
	-op-animation-iteration-count: 1;
	-webkit-animation-iteration-count: 1;
	animation-iteration-count: 1;
}

.offers-section .offer .overlay-box .date, .offers-section .offer .overlay-box .time,
	.offers-section .offer .overlay-box .author {
	position: relative;
	font-size: 14px;
	margin-bottom: 0px;
}

.offers-section .offer .overlay-box .date .fa, .offers-section .offer .overlay-box .time .fa,
	.offers-section .offer .overlay-box .author .fa {
	padding-right: 10px;
}

.offers-section .offer .share-it {
	position: relative;
	padding-top: 18px;
}

.offers-section .offer .share-it a {
	position: relative;
	display: inline-block;
	margin: 0px 2px 2px;
	width: 24px;
	height: 24px;
	line-height: 22px;
	color: #ffffff;
	border: 1px solid #ffffff;
	font-size: 14px;
	text-align: center;
	transition: all 500ms ease;
	-webkit-transition: all 500ms ease;
	-ms-transition: all 500ms ease;
	-o-transition: all 500ms ease;
	-moz-transition: all 500ms ease;
}

.offers-section .offer .share-it a:hover {
	background: #ffffff;
	color: #f254b1;
}
</style>
<body>
	<%@ include file="/jsp/kfzxx/header.jsp"%>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">

					<%@include file="/jsp/kfzxx/left_menu.jsp"%>
				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0" boxmh-mh>
						<div class="panel-body shop-order">
							<div>
								<ul class="nav nav-tabs nav-tabs-line shop-favorite-state">
									<li class="nav-item"><a class="nav-link active" href=""
										data-toggle="tab" data-state="0">已收藏</a></li>
									<!--<li class='nav-item'><a class="nav-link" href="#state1" data-toggle="tab" data-state="1">已失效</a></li>-->
								</ul>
							</div>

						</div>
						<section class="offers-section">
							<div class="row clearfix">

								<!--Offer-->
								<div
									class="col-md-4 col-sm-6 col-xs-12 offer wow fadeInUp animated"
									data-wow-delay="0ms" data-wow-duration="1500ms"
									style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
									<article class="inner-box">
										<figure class="image">
											<a href="server/showproduct.php?lang=cn&amp;id=2"
												title="脸部美容" target="_self"><img
												src="<%=request.getContextPath()%>/statics/images/home/emap.png?x-oss-process=image/resize,m_fill,h_251,w_370,limit_0"
												title="脸部美容" alt="脸部美容">
												<div class="overlay-box">
													<div class="date">
														<span class="fa fa-calendar"></span> Valid Till &ensp;
														04-28-2016
													</div>
													<div class="time">
														<span class="fa fa-clock-o"></span> 08:00:00 AM
													</div>
													<div class="share-it">
														<p style="overflow: auto;">
															<span
																style="text-align: left; float: left; display: inline-block; font-size: 16px;">￥103.00元</span>
															<span
																style="text-align: center; float: right; display: inline-block; width: 40px; background-color: #ddd; border: none; font-size: 12px; border-radius: 3px; cursor: pointer; display: inline-block; background-color: #65C279; color: #FFF;">进行中</span>'
														</p>
													</div>
												</div> </a>
										</figure>
										<div class="text">
											<div class="desc">
												<p >
													<a class="pull-left xq-title"
													href="server/showproduct.php?lang=cn&amp;id=7" title="精致修眉"
													target="_self">我的测试数据我的测试数据我的测试数据123123</a>
													</p>
												
												<p style="overflow: auto;">
													<span
														style="text-align: left; float: left; display: inline-block; " class="price">￥103.00元</span>
													<span
														style="text-align: center; float: right; display: inline-block; width: 40px; background-color: #ddd; border: none; font-size: 12px; border-radius: 3px; cursor: pointer; display: inline-block; background-color: #65C279; color: #FFF;">进行中</span>
												</p>
											</div>

											<p	style="overflow: auto; border-top: solid 1px #ddd; color: #999; padding-top: 4px;">
							   	 <span style="text-align: left; float: left; display: inline-block;">EMAP</span>
									<span style="text-align: center; float: right; cursor: pointer; display: inline-block;">10天</span>
					     	 </p>
										</div>
									</article>
								</div>

								<!--Offer-->
								<div
									class="col-md-4 col-sm-6 col-xs-12 offer wow fadeInUp animated"
									data-wow-delay="0ms" data-wow-duration="1500ms"
									style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
									<article class="inner-box">
										<figure class="image">
											<a href="server/showproduct.php?lang=cn&amp;id=7"
												title="精致修眉" target="_self"><img
												src="<%=request.getContextPath()%>/statics/images/meter/1461848324.jpg?x-oss-process=image/resize,m_fill,h_251,w_370,limit_0"
												title="精致修眉" alt="精致修眉">
												<div class="overlay-box">
													<div class="date">
														<span class="fa fa-calendar"></span> Valid Till &ensp;
														04-28-2016
													</div>
													<div class="time">
														<span class="fa fa-clock-o"></span> 08:00:00 AM
													</div>
													<div class="share-it">
														“十次美容不如一次拨筋”，疏泄经络堆积的杂物废物，让气血能够顺畅运行，并激发皮肤免疫功能，活
														血行气，运输营养到达面部一些细微处，让脸部焕发光彩，有着高 级化妆<br>
													</div>
												</div> </a>
										</figure>
										<div class="text">
											<h3 class="clearfix">
												<a class="pull-left"
													href="server/showproduct.php?lang=cn&amp;id=7" title="精致修眉"
													target="_self">精致修眉</a>
											</h3>
											<div class="desc">
												<p>“十次美容不如一次拨筋”，疏泄经络堆积的杂物废物，让气血能够顺畅运行，并激发皮肤免疫功能，活
													血行气，运输营养到达面部一些细微处，让脸部焕发光彩，有着高 级化妆</p>
											</div>

											<div class="link text-right">
												<a href="server/showproduct.php?lang=cn&amp;id=7"
													title="精致修眉" target="_self"
													class="theme-btn btn-skew style-two btn-sm">查看详情</a>
											</div>


										</div>
									</article>
								</div>

								<!--Offer-->
								<div
									class="col-md-4 col-sm-6 col-xs-12 offer wow fadeInUp animated"
									data-wow-delay="0ms" data-wow-duration="1500ms"
									style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
									<article class="inner-box">
										<figure class="image">
											<a href="server/showproduct.php?lang=cn&amp;id=18"
												title="脸部刮痧/美白补水" target="_self"><img
												src="<%=request.getContextPath()%>/statics/images/meter/1461848927.jpg?x-oss-process=image/resize,m_fill,h_251,w_370,limit_0"
												title="脸部刮痧/美白补水" alt="脸部刮痧/美白补水">
												<div class="overlay-box">
													<div class="date">
														<span class="fa fa-calendar"></span> Valid Till &ensp;
														04-29-2016
													</div>
													<div class="time">
														<span class="fa fa-clock-o"></span> 08:00:00 AM
													</div>
													<div class="share-it">
														全效面部拨筋美疗服务流程与时长：消毒-卸妆-清洁-爽肤-角质调整-拨筋-粉刺清理（视肤质状况而定）-滋润面膜-润肤-约120分钟裸露在外的面部肌肤每天经历风吹雨<br>
													</div>
												</div> </a>
										</figure>
										<div class="text">
											<h3 class="clearfix">
												<a class="pull-left"
													href="server/showproduct.php?lang=cn&amp;id=18"
													title="脸部刮痧/美白补水" target="_self">脸部刮痧/美白补水</a>
											</h3>
											<div class="desc">
												<p>全效面部拨筋美疗服务流程与时长：消毒-卸妆-清洁-爽肤-角质调整-拨筋-粉刺清理（视肤质状况而定）-滋润面膜-润肤-约120分钟裸露在外的面部肌肤每天经历风吹雨</p>
											</div>

											<div class="link text-right">
												<a href="server/showproduct.php?lang=cn&amp;id=18"
													title="脸部刮痧/美白补水" target="_self"
													class="theme-btn btn-skew style-two btn-sm">查看详情</a>
											</div>


										</div>
									</article>
								</div>

							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer.jsp"%>

	</footer>
</body>
</html>