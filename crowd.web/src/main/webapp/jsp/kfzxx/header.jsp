<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<nav class="navbar navbar-default box-shadow-none met-nav">
			<div class="container">
				<div class="row">
					<div class="navbar-header navbar-default pull-xs-left">
						<a
							href=""
							class="met-logo vertical-align block pull-xs-left p-y-5"
							title="智慧校园云工场">
							<h1 hidden>个人中心-智慧校园云工场</h1>
							<div class="vertical-align-middle">
								<img
									src="<%=request.getContextPath()%>/statics/images/logos.png"
									alt="智慧校园云工场">
							</div>
						</a>
					</div>
					<button type="button"
						class="navbar-toggler hamburger hamburger-close collapsed p-x-5 met-nav-toggler"
						data-target="#met-nav-collapse" data-toggle="collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="hamburger-bar"></span>
					</button>

					<button type="button"
						class="navbar-toggler collapsed m-0 p-x-5 met-head-user-toggler"
						data-target="#met-head-user-collapse" data-toggle="collapse">
						<i class="icon wb-user-circle" aria-hidden="true"></i> <i
							class="icon wb-user" aria-hidden="true"></i>
					</button>

					<div
						class="collapse navbar-collapse navbar-collapse-toolbar pull-md-right p-0"
						id='met-head-user-collapse'>

						<ul class="navbar-nav vertical-align p-l-0 m-b-0 met-head-user">

							<li class="dropdown vertical-align-middle met-head-user-column">
								<a href="javascript:;"
								class="navbar-avatar dropdown-toggle dropdown-item"
								data-toggle="dropdown"> <span class="avatar m-r-5"><img
										src="<%=request.getContextPath()%>/statics/images/12.png?1509528657049"
										alt="mycluster" style='position: relative; top: -2px;'></span>
									mycluster
							</a>
								<ul class="dropdown-menu dropdown-menu-right animate">

									<a
										href="<%=request.getContextPath() %>/kfzxx/index"
										class='dropdown-item'><i class="icon wb-user"
										aria-hidden="true"></i>开发者中心</a>
									<a
										href="https://show.metinfo.cn/muban/M1156014/381/shop/order.php?lang=cn"
										class='dropdown-item'><i class="icon wb-order"
										aria-hidden="true"></i>需求方中心</a>

									<a
										href="https://show.metinfo.cn/muban/M1156014/381/shop/favorite.php?lang=cn"
										class='dropdown-item'><i class="icon wb-heart"
										aria-hidden="true"></i>我的收藏</a>
									<a
										href="https://show.metinfo.cn/muban/M1156014/381/member/basic.php?lang=cn&nojump=1"
										target="_blank" class='dropdown-item'><i
										class="icon wb-settings" aria-hidden="true"></i>账户设置</a>
									<div class="dropdown-divider"></div>
									<a
										href="https://show.metinfo.cn/muban/M1156014/381/member/login.php?lang=cn&a=dologout"
										class='dropdown-item'><i class="icon wb-power"></i>退出</a>

								</ul>
							</li>

							<li class="dropdown vertical-align-middle"><a
								href="javascript:void(0)" title="购物车"
								class='dropdown-item topcart-btn' data-toggle="dropdown"> <i
									class="icon wb-shopping-cart" aria-hidden="true"></i> 消息中心<span
									class="tag tag-pill up tag-danger topcart-goodnum font-size-12"
									hidden></span>
							</a>
								<ul
									class="dropdown-menu dropdown-menu-right dropdown-menu-media animation-slide-bottom10">
									<li class="dropdown-menu-header">
										<h5>购物车</h5> <span
										class="tag tag-round tag-danger font-size-12">共 <span
											class="topcart-goodnum"></span> 件商品
									</span>
									</li>
									<li class="list-group" role="presentation">
										<div data-role="container">
											<div data-role="content" id="topcart-body"></div>
										</div>
									</li>
									<div class="dropdown-menu-footer cover p-y-10 p-x-20">
										<div>
											<a
												href="https://show.metinfo.cn/muban/M1156014/381/shop/cart.php?lang=cn"
												class="btn btn-squared btn-danger pull-xs-right">去购物车结算</a>
										</div>
										<span class="red-600 font-size-18 topcart-total"></span>
									</div>
								</ul></li>

						</ul>

					</div>

					<div class="collapse navbar-collapse navbar-collapse-toolbar pull-md-right p-0"
						id='met-nav-collapse'>

						<ul class="nav navbar-nav navlist">
							<li class='nav-item'><a
								href="<%=request.getContextPath() %>/index.jsp"
								title="首页" class="nav-link">首页</a></li>

							<li class="nav-item"><a
								href="<%=request.getContextPath() %>/center/index" title="众包大厅"
								class="nav-link">众包大厅</a></li>
							<li class="nav-item dropdown"><a
								href="../news/index.php?lang=cn" title="帮助中心闻"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								data-hover="dropdown">帮助中心</a>

								<div class="dropdown-menu dropdown-menu-right animate">
									<a href="../news/index.php?lang=cn" title="在线帮助"
										class='dropdown-item '>在线帮助</a> <a
										href="../news/news.php?lang=cn&class2=4" class="dropdown-item"
										title="帮助文档">帮助文档</a> <a
										href="../news/news.php?lang=cn&class2=5" class="dropdown-item"
										title="在线视频">在线视频</a>
										 <a
										href="../news/news.php?lang=cn&class2=6" class="dropdown-item"
										title="下载中心">下载中心</a>

								</div></li>
							<li class="nav-item"><a
								href="../about/show.php?lang=cn&id=187" title="互动社区"
								class="nav-link">互动社区</a></li>

							<li class="nav-item"><a
								href="../about/show.php?lang=cn&id=188" title="应用商店"
								class="nav-link">应用商店</a></li>

							<li class="nav-item"><a href="../message/index.php?lang=cn"
								title="加盟合作" class="nav-link">联系我们</a></li>




						</ul>

					</div>
				</div>
			</div>
		</nav>
		
		