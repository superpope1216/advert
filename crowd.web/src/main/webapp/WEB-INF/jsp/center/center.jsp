<%@page import="com.wisedu.crowd.common.code.CenterTypeEnum"%>
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
	padding-bottom: 20px;
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
	opacity: 0;
	-moz-opacity: 0;
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
</head>
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
		<div class="met-banner banner-ny-h " data-height='' style=''>

			<div class="slick-slide">
				<img class="cover-image"
					src="<%=request.getContextPath()%>/statics/images/header/banner_number.png"
					sizes="(max-width: 767px) 767px" alt="全部产品栏目">
				<div class="container datas" id="containerHeader">
					<div class="row">
						<div class="col-sm-12 col-md-8">

							<div class="dataStatistics">
								<div style="float: left;">
									<div class="fbxq">发布</div>
									<div class="fbxq">需求</div>
								</div>
								<div class="digit_set" style="margin-left:20px;" id="divNum1">0</div>
								<div class="digit_set" id="divNum2">
									0
								</div>
								<div class="digit_set" id="divNum3">0</div>
								<div class="digit_set" id="divNum4">0</div>
								<div class="digit_set" id="divNum5">0</div>
								<div class="digit_set" id="divNum6">0</div>
								<div style="float: left; margin-left:20px;">
									<div class="fbxq" style="line-height:130px;">万元</div>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-1 col-md-1 text-center">
							
									<button type="button" class="btn  header-btn1 btn-lg " id="btnPublishing">我有需求</button>
									<br>
											<button type="button" class="btn header-btn2  btn-lg" id="btnTb">我要投标</button>
							
						</div>
					</div>
				</div>
			</div>

		</div>
	</header>
	<div class="column-side ">
		<div class="container mobile-not-padding">
			<div class="column-nav">
				<ol class="column-ul">
					<c:forEach items="${rwxs}" var="data" varStatus="xh">

						<c:choose>
							<c:when test="${empty  param.classify }">
								<c:choose>
									<c:when test="${xh.index ==0}">
										<li class="column-li active">
									</c:when>
									<c:otherwise>
										<li class="column-li">
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when
								test="${(param.classify eq '0') && (param.lbdm eq data.lbdm)}">
								<li class="column-li active">
							</c:when>
							<c:otherwise>
								<li class="column-li">
							</c:otherwise>
						</c:choose>

						<a
							href="<%=request.getContextPath() %>/center/index?classify=<%=CenterTypeEnum.NORMAL.getCode() %>&lbdm=${data.lbdm}"
							title="${data.lbmc}">${data.lbmc}</a>
						</li>
					</c:forEach>

					<c:choose>
						<c:when test="${empty  param.classify }">
							<li class="column-li  navs">
						</c:when>
						<c:when test="${(param.classify eq '1')}">
							<li class="column-li  navs active">
						</c:when>
						<c:otherwise>
							<li class="column-li  navs">
						</c:otherwise>
					</c:choose>
					<a
						href="<%=request.getContextPath()%>/center/index?classify=<%=CenterTypeEnum.NEW.getCode()%>&lbdm=1"
						title="新手专区">新手专区</a>
					</li>
					<c:choose>
						<c:when test="${empty  param.classify }">
							<li class="column-li  navs">
						</c:when>
						<c:when test="${(param.classify eq '2')}">
							<li class="column-li  navs active">
						</c:when>
						<c:otherwise>
							<li class="column-li  navs">
						</c:otherwise>
					</c:choose>
					<a
						href="<%=request.getContextPath()%>/center/index?classify=<%=CenterTypeEnum.OLD.getCode()%>&lbdm=2"
						title="老友记">老友记</a>
					</li>
					<li class="column-li  navs"><a href="#paralist"
						data-toggle="collapse" class="link" title="更多筛选"
						aria-expanded="false"><i class="icon wb-chevron-down"
							aria-hidden="true"></i></a></li>
				</ol>
			</div>
			<div class="met-muban-paralist collapse" id="paralist"
				aria-expanded="false" style="">
				<div>
					<div class="met-muban-paralist-body bg-white">
						<div class="container padding-bottom-10">

							<dl>
								<dt>按业务域</dt>
								<dd>

									<a class="btn queryActive link" href="javascript:void(0);"
										title="全部" data-key="" data-option="ywx">全部</a>
									<c:forEach items="${ywx}" var="data">
										<a class="btn link" href="javascript:void(0);"
											data-option="ywx" title="${data.lbmc}"
											data-key="${data.lbdm}">${data.lbmc}</a>
									</c:forEach>


								</dd>
							</dl>
							<dl>
								<dt>按开发框架</dt>
								<dd>

									<a class="btn queryActive link" href="javascript:void(0);"
										title="全部" data-key="" data-option="kfkj">全部</a>
									<c:forEach items="${kfkj}" var="data">
										<a class="btn link" href="javascript:void(0);"
											data-key="${data.lbdm}" data-option="kfkj"
											title="${data.lbmc}">${data.lbmc} </a>
									</c:forEach>

								</dd>
							</dl>
							<dl>
								<dt>按需求状态</dt>
								<dd>

									<a class="btn queryActive link" href="javascript:void(0);"
										title="全部" data-key="" data-option="rwzt">全部</a>
									<c:forEach items="${rwjd}" var="data">
										<a class="btn link" href="javascript:void(0);"
											data-key="${data.lbdm}" title="${data.lbmc}"
											data-option="rwzt">${data.lbmc} </a>
									</c:forEach>

								</dd>
							</dl>
							<!-- <dl>
								<dt>按价格</dt>
								<dd>

									<a class="btn queryActive link" href="https://www.metinfo.cn/product/"
										title="全部">全部</a> <a class="btn link"
										href="index.php?lang=cn&amp;searchlist=199" title="199 元">199
										元</a> <a class="btn link"
										href="index.php?lang=cn&amp;searchlist=299" title="299 元">299
										元</a> <a class="btn link"
										href="index.php?lang=cn&amp;searchlist=399" title="399 元">399
										元</a> <a> <i
										class="icon pe-help1 font-size-20 hidden-xs res-tips"
										aria-hidden="true" data-plugin="webuiPopover"
										data-trigger="hover" data-width="500"
										data-content="<div style='white-space: nowrap;'>199 元：单独的电脑模板或手机模板<br>299 元：第一版响应式，满足企业网站基本的「多终端」展示需求<br>399 元：第二版响应式，性能更强，体验更佳，效果更炫的「多终端」展示</div>"
										data-animation="fade" data-target="webuiPopover1"></i>
									</a>

								</dd>
							</dl>
 -->
						</div>
					</div>
				</div>
			</div>
			<div class="column-hover">

				<ul></ul>
				<ul></ul>
				<!-- 
		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=119" title="美容护肤" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=130" title="洁面 磨砂膏" >洁面 磨砂膏</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=131" title="面膜" >面膜</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=132" title="明星爽肤水" >明星爽肤水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=133" title="防晒隔离" >防晒隔离</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=134" title="晚安粉 出浴粉" >晚安粉 出浴粉</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=135" title="芦荟胶" >芦荟胶</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=136" title="去角质" >去角质</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=137" title="黑头导出液" >黑头导出液</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=138" title="面部护理套装" >面部护理套装</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=120" title="彩妆 靓妆" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=139" title="眼线笔 液 胶" >眼线笔 液 胶</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=143" title="BB霜" >BB霜</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=141" title="睫毛膏" >睫毛膏</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=142" title="卸妆品" >卸妆品</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=140" title="粉饼" >粉饼</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=144" title="散粉 蜜粉" >散粉 蜜粉</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=121" title="眼部 唇部护理" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=145" title="唇部精华" >唇部精华</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=146" title="睫毛滋养液" >睫毛滋养液</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=147" title="眼部精华" >眼部精华</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=148" title="润唇膏" >润唇膏</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=149" title="唇部去角质品" >唇部去角质品</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=150" title="眼霜" >眼霜</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=151" title="滴 洗眼液" >滴 洗眼液</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=152" title="眼唇膜" >眼唇膜</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=122" title="香氛 香水" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=153" title="女士香水" >女士香水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=154" title="男士香水" >男士香水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=155" title="中性香水" >中性香水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=156" title="固体香膏" >固体香膏</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=161" title="香水套装" >香水套装</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=123" title="美发 乌黑亮发" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=162" title="洗发水" >洗发水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=163" title="护发素" >护发素</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=164" title="修复 造型" >修复 造型</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=124" title="精油spa" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=157" title=" 精油" > 精油</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=158" title="花水 纯露" >花水 纯露</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=159" title="基础油" >基础油</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=160" title="香薰用具" >香薰用具</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=125" title="肌肤护理 修复" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=172" title="脱毛膏" >脱毛膏</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=173" title="爽身粉" >爽身粉</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=174" title="防嗮油" >防嗮油</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=126" title="身体保洁" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=165" title="身体保湿" >身体保湿</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=166" title="身体清洁 去角质" >身体清洁 去角质</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=167" title="手足护理" >手足护理</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=168" title="婴儿护理" >婴儿护理</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=127" title="化妆工具" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=175" title="彩妆修正笔" >彩妆修正笔</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=176" title="化妆镜" >化妆镜</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=177" title="化妆海绵 棉棒" >化妆海绵 棉棒</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=178" title="化妆包 箱" >化妆包 箱</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=179" title="假睫毛 胶水" >假睫毛 胶水</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=180" title="化妆刷" >化妆刷</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=181" title="吸油面纸" >吸油面纸</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=182" title="双眼皮贴 胶" >双眼皮贴 胶</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=128" title="男神专区" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=169" title="洁面 剃须" >洁面 剃须</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=170" title="爽肤" >爽肤</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=171" title="面部滋养" >面部滋养</a></li>

		</ul> 

		<ul class="has">

		  <li class="all"><a href="../product/product.php?lang=cn&class2=129" title="其他" >全部</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=183" title="礼物" >礼物</a></li>

		  <li><a href="../product/product.php?lang=cn&class3=184" title="明星组合套装" >明星组合套装</a></li>

		</ul> 
   -->
			</div>

		</div>
	</div>
	<div class="grey-box">
		<div class="container">
			<div class="host-list active">
				<ul
					class="offers-section blocks-2 blocks-sm-3 blocks-md-4 blocks-xlg-5  met-page-ajax met-grid"
					id="crowd-grid" data-scale="1">


				</ul>
			</div>
		</div>

	</div>
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
	<%@ include file="/jsp/footer/footer.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top hide">
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var jsonurl = "";
		var classify = "${param.classify}";
		var lbdm = "${param.lbdm}";
	</script>

	<%@ include file="/jsp/bottom.jsp"%>


	<script
		src="<%=request.getContextPath()%>/statics/pagejs/hall/index.js"></script>
	<script
		src="<%=request.getContextPath()%>/statics/pagejs/center/center.js"></script>
</body>
</html>
