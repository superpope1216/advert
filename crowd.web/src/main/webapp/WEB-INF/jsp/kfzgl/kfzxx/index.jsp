<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<!--[if lte IE 8]>
<div class="text-xs-center m-b-0 bg-blue-grey-100 alert">
    <button type="button" class="close" aria-label="Close" data-dismiss="alert">
        <span aria-hidden="true">×</span>
    </button>
    你正在使用一个 <strong>过时</strong> 的浏览器。请 <a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
</div>
<![endif]-->

<body>
		<%@include file="/jsp/header.jsp"%>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">
					<%@include file="/jsp/kfzxx/left_menu.jsp"%>

				</div>

				<div class="col-lg-9 shop-profile">
					<div class="card m-b-0">
						<div class="card-header bg-blue-600 text-xs-center p-30 p-b-15">
							<a class="avatar avatar-100 img-bordered m-b-10 bg-white"
								target="_blank"
								href="https://show.metinfo.cn/muban/M1156014/381/member/basic.php?lang=cn&nojump=1"
								title='mycluster'> <img
								src="<%=request.getContextPath()%>/image/preView?wid=${kfzxx.grzpfjid}"
								alt="mycluster">
							</a>
							<div class="font-size-20 white">${kfzxx.nc}(${kfzxx.sfytdDisplay}开发者)</div>
							<div class="grey-300 font-size-14 m-b-20">信誉分：100分</div>
						</div>
						<div class="card-content">
							<div class="row p-y-20 text-xs-center">
								<div class='col-xs-4 col-sm-4 offset-xs-2 offset-sm-1'>
									<div class="counter">
										<span class="counter-number cyan-600"><a
											href="https://show.metinfo.cn/muban/M1156014/381/shop/order.php?lang=cn#state_1">1</a></span>
										<div class="counter-label">已提现</div>
									</div>
								</div>
								<div class='col-xs-4 col-sm-2'>
									<div class="counter">
										<span class="counter-number cyan-600"><a
											href="https://show.metinfo.cn/muban/M1156014/381/shop/order.php?lang=cn#state_3">0</a></span>
										<div class="counter-label">累积收入</div>
									</div>
								</div>
								<div class='col-xs-12 col-sm-4'>
									<div class="counter">
										<span class="counter-number cyan-600"><a
											href="https://show.metinfo.cn/muban/M1156014/381/shop/finance.php?lang=cn">￥0.00元</a></span>
										<div class="counter-label">账户余额</div>
									</div>
								</div>
							</div>
						</div>
						<div class="card-content">
							<ul class="list-group list-group-bordered m-b-0">
								<a href="<%=request.getContextPath()%>/kfzOrder/index?flag=order"
									class="list-group-item p-y-15"> <i class="icon wb-order"
									aria-hidden="true"></i>查看我的需求<span class="site-menu-arrow"></span>
								</a>
								<a
									href="https://show.metinfo.cn/muban/M1156014/381/shop/finance.php?lang=cn"
									class="list-group-item p-y-15"> <i class="icon wb-payment"
									aria-hidden="true"></i>结算信息<span class="site-menu-arrow"></span>
								</a>
								<a
									href="<%=request.getContextPath()%>/kfzrbgl/index?flag=kfzrbgl"
									class="list-group-item p-y-15"> <i class="icon wb-bookmark"
									aria-hidden="true"></i>我的日报<span class="site-menu-arrow"></span>
								</a>
								<a
									href="<%=request.getContextPath()%>/kfzConfrim/index?flag=kfzconfirm"
									class="list-group-item p-y-15"> <i class="icon wb-map"
									aria-hidden="true"></i>我的认证<span class="site-menu-arrow"></span>
								</a>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/jsp/footer/footer2.jsp" %>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var jsonurl = 'https://show.metinfo.cn/muban/M1156014/381/shop/cart.php?lang=cn&a=dojson_cart_list', totalurl = 'https://show.metinfo.cn/muban/M1156014/381/shop/cart.php?lang=cn&a=domodify', delurl = 'https://show.metinfo.cn/muban/M1156014/381/shop/cart.php?lang=cn&a=dodel', price_prefix = '￥', price_suffix = '元';
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
	
</body>
</html>
