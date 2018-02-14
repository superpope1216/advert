<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/order.css'>
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

					<%@include file="/jsp/xqfxx/left_menu.jsp"%>
				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0" boxmh-mh>
						<div class="panel-body shop-order-check">

							<div class="row order-state-1">
								<div class="col-md-6 col-xs-12 shop-order-type">
									<h3 class="state_txt font-size-20">
										<i class="icon wb-payment orange-600" aria-hidden="true"
											style="font-size: 38px;"></i><span>收支明细</span> <small
											style="bottom: 7px; position: relative; font-size: 12px;">仅显示最近12个月的收支统计</small>
									</h3>
				
								</div>
								<div class="col-md-6 col-xs-12 text-right shop-order-type" style="line-height:35px;">总支出：当前冻结：余额：</div>
							</div>
							<div class="col-md-12">
								<div id="main" style="height:400px"></div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script>
		var page_type = "xqfMoney";
		var rwid = "${rwid}";
		var isnbkfz = $
		{
			isnbkfz
		};
		var rwcfsqbl = $
		{
			rwcfsqbl
		};
	</script>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<%@ include file="/jsp/bottom.jsp"%>

</body>
</html>
