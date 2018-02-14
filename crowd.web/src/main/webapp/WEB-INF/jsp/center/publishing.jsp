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

							<form id="formRbxxgl" class="addr-edit-form met-form-validation">
								<input type="hidden" name="wid" value="">
								
									<div class="form-group">
										<input type="text" class="form-control" name="rwjbxxInfo.rwmc"
											placeholder="请输入个人/公司名称" required
											data-fv-notempty-message="此项不能为空" value="">
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											name="rwjbxxInfo.xmysje" placeholder="请输入广告预算" required
											data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
											data-fv-regexp-message="请输入正确的正整数类型数字"
											data-fv-stringlength="true" data-fv-stringlength-min="1"
											data-fv-stringlength-max="6" value="">
									</div>
									<div class="form-group select-linkage">
										<select class="form-control prov" name="rwjbxxInfo.rwxs"
											required data-fv-notempty-message="此项不能为空">
											<option value="">---请选择求购地区---</option>
										</select>
									</div>
									<div class="form-group">
										<textarea class="form-control" rows="3" name="rwjbxxInfo.xmgs"
											placeholder="请输入需求描述" required
											data-fv-notempty-message="此项不能为空"><c:if
												test='${!empty rwjbxx}'>${rwjbxx.xmgs}</c:if></textarea>
									</div>

									<div class="form-group">
										<input class="form-control datepicker" type="text"
											name="rwjbxxInfo.zbjzrq" placeholder="请输入求购的有效开始时间" required
											data-fv-notempty-message="此项不能为空" data-bv-date="true"
											data-bv-date-format="YYYY-MM-DD"
											data-bv-date-message="请输入正确的日期格式"
											value="<c:if test='${!empty rwjbxx}'><fmt:formatDate value="${rwjbxx.zbjzrq}" pattern="yyyy-MM-dd" type="both"/></c:if>">
									</div>
									<div class="form-group">
										<input class="form-control datepicker" type="text"
											name="rwjbxxInfo.zbjzrq" placeholder="请输入求购的有效结束时间" required
											data-fv-notempty-message="此项不能为空" data-bv-date="true"
											data-bv-date-format="YYYY-MM-DD"
											data-bv-date-message="请输入正确的日期格式"
											value="<c:if test='${!empty rwjbxx}'><fmt:formatDate value="${rwjbxx.zbjzrq}" pattern="yyyy-MM-dd" type="both"/></c:if>">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="rwjbxxInfo.rwmc"
											placeholder="请输入联系人" required
											data-fv-notempty-message="此项不能为空" value="">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="rwjbxxInfo.rwmc"
											placeholder="请输入手机号" required
											data-fv-notempty-message="此项不能为空" value="">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="rwjbxxInfo.rwmc"
											placeholder="请输入邮箱号" required
											data-fv-notempty-message="此项不能为空" value="">
									</div>



							<div class="form-group">
									<button type="button" class="btn btn-primary btn-squared"
										id="btnNext">提交</button>
</div>

							</form>
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
			var _xmxx = "";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer2.jsp"%>

	</footer>
</body>
</html>