<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">


		<!-- /.search form -->

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu tree" data-widget="tree">
			
			<!-- Optionally, you can add icons to the links -->
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>用户信息</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/registerUser/index">注册用户</a></li>
					<li><a href="<%=request.getContextPath()%>/supply/index?flag=1">广告卖方审核</a></li>
					<li><a href="<%=request.getContextPath()%>/supply/index?flag=2">广告买方审核</a></li>
					<li><a href="<%=request.getContextPath()%>/supplyZz/index">广告资质审核</a></li>
					
				</ul></li>
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>商机信息管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/sjglDlxx/index">代理管理</a></li>
					<li><a href="<%=request.getContextPath()%>/sjglHzxx/index">合作管理</a></li>
					<li><a href="<%=request.getContextPath()%>/sjglZbxx/index">招商管理</a></li>
				</ul></li>

			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>广告售卖管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/hwzyInfo/index">户外广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/dszyInfo/index">电视广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/gbzyInfo/index">广播广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/bzzyInfo/index">报纸广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/xmtzyInfo/index">新媒体广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/zzzyInfo/index">杂志广告管理</a></li>
					<li><a href="<%=request.getContextPath()%>/wlzyInfo/index">网络广告管理</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>广告求购信息管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/qgInfo/index">广告求购信息</a></li>
				</ul>
			</li>
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>行业资讯信息管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/hyzxNews/index">行业新闻信息</a></li>
					<li><a href="<%=request.getContextPath()%>/hyzxGg/index">行业公告信息</a></li>
				</ul>
			</li>
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>会员管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/yhdjxxInfo/index">会员信息</a></li>
					<li><a href="<%=request.getContextPath()%>/czjlInfo/index">充值记录</a></li>
				</ul>
			</li>
			<li class="treeview"><a href="#"><i class="fa fa-link"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="<%=request.getContextPath()%>/system/hy/index">会员等级设置</a></li>
				</ul>
			</li>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>