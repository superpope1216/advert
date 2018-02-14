<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/train/download.css'>
<body>
	<header>
		<%@ include file="/jsp/header.jsp"%>
		<div class="met-banner banner-ny-h " data-height='' style=''>

			<div class="slick-slide">
				<img class="cover-image"
					src="<%=request.getContextPath()%>/statics/images/1507482307.jpg"
					sizes="(max-width: 767px) 767px" alt="全部产品栏目">

			</div>

		</div>
	</header>

	<div class="column-side ">
		<div class="container mobile-not-padding">
			<div class="page-content row" style="padding:0px 30px;">
				<div class="panel m-b-0">
					<div class="column-nav">
						<ol class="column-ul">
							<li class="column-li active"><a href="../product/"
								title="在线帮助">在线帮助</a></li>

							<li class="column-li  navs"><a
								href="../product/product.php?lang=cn&class2=119" title="帮助文档">帮助文档</a>
							</li>

							<li class="column-li  navs"><a
								href="../product/product.php?lang=cn&class2=120" title="在线视频">在线视频</a>
							</li>

							<li class="column-li  navs"><a
								href="../product/product.php?lang=cn&class2=121" title="O下载A">下载</a>
							</li>
						</ol>
					</div>

					<div class="column-hover">
						<ul></ul>
						<ul></ul>
					</div>
				</div>
			</div>


		</div>
	</div>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">
				<div class="panel m-b-0">

					<div id="floor1" class="floor">
						<div id="aside">
							<ul>
								<li class="active">新手引导</li>
								<li>EMAP下载</li>
								<li>前端框架与组件</li>
								<li>支持文档</li>
							</ul>
						</div>
						<img
							src="<%=request.getContextPath()%>/statics/images/train/1.png"
							alt="">
						<div class="main-content">
							<h2>初遇云工场的看过来</h2>
							<p>针对刚接触云工场的用户来说,建议通过云工场官方课堂《EMAP基础入门》视频教程,使用配套的教材及案列素材学习,全部免费,新来的小伙伴都去报名学习了</p>
							<div class="btn-group">
								<button>前往云工场</button>
								<button>下载配套材料</button>
								<button>学习圈</button>
							</div>
						</div>
					</div>
					<div id="floor2" class="floor">
						<img
							src="<%=request.getContextPath()%>/statics/images/train/2.png"
							alt="">
						<div class="main-content">
							<h2>EMAP快速开发平台V1.0正式版(含Mac OS版)</h2>
							<p>EMAP是基于Eclipse的快速集成开发平台.</p>
							<p>它依托模型与框架配置帮助开发人员快速实现应用开发,减少开发工作量.</p>
							<p>它的优势是拥有教育行业众多组件(如:选房、选课等)、能个性化自由构建和扩展这些组件.</p>
							<p>特点</p>
							<p>1、集成了使用最广泛的框架体系 springMVC JQuery + Ajax + JSON +
								requiredJS</p>
							<p>2、模型驱动前端组件(DATA模型、META模型)</p>
							<p>3、公共组件库,业务组件、公共组件、前端组件</p>
							<p>4、碎片化应用与运行容器分开,应用可以独立存在、独立运行、独立启停</p>
							<p>5、应用(组件)的开放性,可以开发自己的组件与应用,这个应用可以被其他应用继承</p>
							<div class="btn-group">
								<button>免费下载(Win)</button>
								<button>免费下载(Mac)</button>
							</div>
						</div>
					</div>
					<div id="floor3" class="floor">
						<img
							src="<%=request.getContextPath()%>/statics/images/train/3.png"
							alt="">
						<div class="main-content">
							<h2>前端框架与组件</h2>
							<p>EMAP是基于Eclipse的快速集成开发平台.</p>
							<p>它依托模型与框架配置帮助开发人员快速实现应用开发,减少开发工作量.</p>
							<p>它的优势是拥有教育行业众多组件(如:选房、选课等)、能个性化自由构建和扩展这些组件.</p>
							<div class="btn-group">
								<button>支持网站(jqx)</button>
								<button>课程</button>
							</div>
						</div>

						
					</div>
					<div id="floor4" class="floor">
							<img
								src="<%=request.getContextPath()%>/statics/images/train/4.png"
								alt="">
							<div class="main-content">
								<h2>支持文档</h2>
								<p>EMAP是基于Eclipse的快速集成开发平台.</p>
								<p>它依托模型与框架配置帮助开发人员快速实现应用开发,减少开发工作量.</p>
								<p>它的优势是拥有教育行业众多组件(如:选房、选课等)、能个性化自由构建和扩展这些组件.</p>
								<div class="btn-group">
									<button>支持网站(res)</button>
									<button>课程</button>
								</div>
							</div>
						</div>
					<div class="footer-img"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- <script src="http://res.wisedu.com/fe_components/jquery-1.11.3.js"></script> -->
	<!--<script type="text/javascript" src="/emap/sys/crowdCommon/public/js/public.js"></script>
  -->
	<%@ include file="/jsp/bottom.jsp"%>
	<script src="../public/js/newMain/js/download.js"></script>

	<script type="text/javascript">
		var bathPath = "/emap";
		var globeHasLogined = 0;
		function logout() {
			$.cookie("rememberMe", null);
			location.href = CONFIG_SERVICEAUTH
					+ "login/logout.do?action="
					+ encodeURIComponent(CONFIG_GATEWAYPATH
							+ "home/download.do");
		}
	</script>
</body>
</html>