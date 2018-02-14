<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/order.css'>
<style>
.blocks-4>li {
	width: 16%;
}
</style>
<!--[if lte IE 8]>
<div class="text-xs-center m-b-0 bg-blue-grey-100 alert">
    <button type="button" class="close" aria-label="Close" data-dismiss="alert">
        <span aria-hidden="true">×</span>
    </button>
    你正在使用一个 <strong>过时</strong> 的浏览器。请 <a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
</div>
<![endif]-->

<body>

	<%@ include file="/jsp/header.jsp"%>

	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">
				<div class="col-lg-9">
					<div class="panel m-b-0" boxmh-mh>
						<div class="panel-body shop-order">
							<div class="panel">
								<div class="panel-body row p-b-20">
									<div class="pearls blocks-4">
										<li class="pearl m-b-0 current">
											<div class="pearl-icon">
												<i class="icon wb-clipboard" aria-hidden="true"></i>
											</div> <span class="pearl-title">发布需求</span>
										</li>
										<li class="pearl m-b-0 disabled">
											<div class="pearl-icon">
												<i class="icon wb-payment" aria-hidden="true"></i>
											</div> <span class="pearl-title">审核需求
												<p class="blue-grey-400 hidden-sm-down m-b-0"></p>
										</span>
										</li>
										<li class="pearl m-b-0 disabled">
											<div class="pearl-icon">
												<i class="icon wb-check" aria-hidden="true"></i>
											</div> <span class="pearl-title">选标</span>
										</li>
										<li class="pearl m-b-0 disabled">
											<div class="pearl-icon">
												<i class="icon wb-clipboard" aria-hidden="true"></i>
											</div> <span class="pearl-title">验收</span>
										</li>
										<li class="pearl m-b-0 disabled">
											<div class="pearl-icon">
												<i class="icon wb-clipboard" aria-hidden="true"></i>
											</div> <span class="pearl-title">售后</span>
										</li>
										<li class="pearl m-b-0 disabled">
											<div class="pearl-icon">
												<i class="icon wb-clipboard" aria-hidden="true"></i>
											</div> <span class="pearl-title">评价结项</span>
										</li>
									</div>
								</div>
							</div>
							<div id="rwjbxx">
							<form id="formRbxxgl" class="addr-edit-form met-form-validation">
									<input type="hidden" name="wid" value="<c:if test='${!empty rwjbxx}'>${rwjbxx.wid}</c:if>">
									<div class="modal-body">
										<div class="form-group">
											<input type="text" class="form-control" name="rwmc"
												placeholder="一个清晰的名字能帮助开发者快速的了解需求" required
												data-fv-notempty-message="此项不能为空" value="<c:if test='${!empty rwjbxx}'>${rwjbxx.rwmc}</c:if>">
										</div>
										<div class="form-group">
											<input class="form-control datepicker" type="text"  name="zbjzrq"
												placeholder="请输入需求招标截至日期，到达该日期后，如果没有投标或者选标，需求则会自动关闭"
												required data-fv-notempty-message="此项不能为空"
												data-bv-date="true" data-bv-date-format="YYYY-MM-DD"
												data-bv-date-message="请输入正确的日期格式" value="<c:if test='${!empty rwjbxx}'><fmt:formatDate value="${rwjbxx.zbjzrq}" pattern="yyyy-MM-dd" type="both"/></c:if>">
										</div>
										<div class="form-group">
											<input type="text" 
												class="form-control datepicker" name="jfrq"
												placeholder="请输入预期交付日期日期，中标者将严格按照该日期交付需求相关信息" required
												data-fv-notempty-message="此项不能为空" data-bv-date="true"
												data-bv-date-format="YYYY-MM-DD"
												data-bv-date-message="请输入正确的日期格式" value="<c:if test='${!empty rwjbxx}'>${rwjbxx.jfrq}</c:if>">
										</div>

										<div class="form-group">
											<textarea class="form-control" rows="3" name="xmgs"
												placeholder="请输入需求描述" required
												data-fv-notempty-message="此项不能为空"><c:if test='${!empty rwjbxx}'>${rwjbxx.xmgs}</c:if></textarea>
										</div>


									</div>
									<div class="modal-footer text-xs-left">
										<button type="button" class="btn btn-primary btn-squared"
											id="btnNext">提交需求</button>
									</div>
								

							</form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="panel row m-b-15 m-r-15 hidden-md-down" boxmh-h>
						<div class="panel-body">
							<p>不会发布需求？来参考下</p>
						</div>
					</div>
					<div class="panel row m-b-15 m-r-15 hidden-md-down" boxmh-h>
						<div class="panel-body">
							<h2 class="m-l-30 font-size-18 font-weight-unset">接包明星榜单</h2>
							<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
								<li class='nav-item'><a class="nav-link active"
									data-toggle="tab" href data-state="all">企业</a></li>
								<li class='nav-item'><a class="nav-link" data-toggle="tab"
									href="#state1" data-state="1">个人</a></li>
							</ul>
						</div>
					</div>
					<div class="panel row m-b-0 m-r-15 hidden-md-down" boxmh-h>
						<div class="panel-body">
							<h2 class="m-l-30 font-size-18 font-weight-unset">最新中标单</h2>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="modal fade modal-primary" id="rbxx-edit-modal"
		aria-hidden="true" aria-labelledby="rbxx-modal-title" role="dialog"
		tabindex="-1">
		<div class="modal-dialog modal-center modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="rbxx-modal-title">日报编辑</h4>
				</div>

			</div>
		</div>
	</div>
	<!-- End Modal -->
	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "publishing";
			var _xmxx="";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer2.jsp"%>

	</footer>
</body>
</html>