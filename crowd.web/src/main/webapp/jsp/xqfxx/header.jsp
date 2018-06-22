<%@page import="com.wisedu.crowd.entity.yhgl.extend.YhjbxxInfoExtend"%>
<%@page import="com.wisedu.crowd.common.util.ConstantsUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object userInfoObj = session.getAttribute(ConstantsUtil.SESSION_YHJBXX);
	YhjbxxInfoExtend yhjbxxInfoExtend = null;
	if (userInfoObj != null) {
		yhjbxxInfoExtend = (YhjbxxInfoExtend) userInfoObj;
	}
%>
<style>
	.badge{
		display:inline-block;
		min-width:10px;
		padding:3px 7px;
		font-size:12px;
		font-weight:400;
		line-height:1;
		color:#76838f;
		text-align:center;
		white-space:nowrap;
		vertical-align:middle;
		background-color:#e4eaec;
		border-radius:10px
	}
	.badge:empty{display:none}
	.btn .badge{position:relative;top:-1px}
</style>
<div class="head-box">
	<div class="container">

		<div class="head-left">
			<div class="head-left-wrapper">
				<div class="head-left-slide">
					<p>
						欢迎光临某某广告平台！<a style="margin-left:10px;color:#FFFFFF;" href="<%=request.getContextPath()%>/publishing/index">我要求购</a><a style="margin-left:10px;color:#FFFFFF;">我要发布</a>
					</p>

					

				</div>
			</div>
		</div>

		<div class="head-right">
			<ul>
				
						<%@include file="/jsp/user_dropdown.jsp" %>
					
				<li class="dropdown shopcut"><a href="javascript:void(0)"
					title="消息中心" data-toggle="dropdown" aria-expanded="false"
					data-animation="slide-bottom10" role="button"> <i
						class="icon wb-shopping-cart" aria-hidden="true"></i> <font>消息中心</font>
						<span class="badge badge-danger up hide topcart-goodnum"></span>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-right dropdown-menu-media topcartremove animation-slide-bottom10"
						role="menu">
						<li class="dropdown-menu-header">
							<h5>购物车</h5> <span class="label label-round label-danger">共
								<span class="topcart-goodnum"></span> 件商品
						</span>
						</li>
						<li class="list-group dropdown-scrollable" role="presentation">
							<div data-role="container">
								<div data-role="content" id="topcart-body"></div>
							</div>
						</li>
						<li class="dropdown-menu-footer" role="presentation">
							<div class="dropdown-menu-footer-btn">
								<a
									href=""
									class="btn btn-squared btn-danger margin-bottom-5 margin-right-10">去购物车结算</a>
							</div> <span class="red-600 font-size-18 topcarttotal"></span>
						</li>
					</ul></li>
			</ul>

		</div>

	</div>
</div>

<nav>
	<div class="neck-box">
		<div class="container">

			<div class="logo-box">
				<a href="<%=request.getContextPath() %>/index.jsp" title="智慧校园云工场"
					target='_self'> <img
					src="<%=request.getContextPath()%>/statics/images/header/logo.png"
					alt="智慧校园云工场"> <img
					src="<%=request.getContextPath()%>/statics/images/header/logo.png"
					alt="智慧校园云工场">
				</a>
			</div>


			<div class="nav-box ">
				<div class="nav-cut">
					<ul class="nav-ul">

						<li class="nav-li "><a
							href="<%=request.getContextPath()%>/index.jsp" title="首页">首页</a></li>

						<li class="nav-li   margin-left-0"><a
							href="<%=request.getContextPath()%>/center/index" title="企业商铺管理">企业商铺管理</a></li>

						<li class="nav-li  navs margin-left-0"><a
							href="javascript:void(0);" title="广告媒体管理">广告媒体管理</a></li>
						<li class="nav-li  navs margin-left-0"><a
							href="javascript:void(0);" title="基本服务费管理">基本服务费管理</a></li>
							<li class="nav-li  navs margin-left-0"><a
							href="javascript:void(0);" title="基本服务费管理">商机管理</a></li>
							<li class="nav-li  navs margin-left-0"><a
							href="javascript:void(0);" title="基本服务费管理">企业资讯管理</a></li>
							<li class="nav-li  navs margin-left-0"><a
							href="javascript:void(0);" title="基本服务费管理">财务管理</a></li>
					</ul>
				</div>

				<div class="nav-hover">

					<ul></ul>

					<ul>

					</ul>

					<ul>
						

					</ul>

					<ul>

					</ul>

					<ul>

					</ul>

					<ul>

					</ul>

					<ul>

					</ul>

				</div>

			</div>

		</div>
	</div>
</nav>
<script
	src="<%=request.getContextPath()%>/statics/plugins/vendor/jquery_lazyload/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/pagejs/common/header.js"></script>

