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
						<div class="panel-body shop-order">
							<div>
								<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
								<li class='nav-item active'><a class="nav-link"
										data-toggle="tab" href data-state="0">全部(${cg+dsh+zbz+jxz+yjs})</a></li>
									<li class='nav-item '><a class="nav-link"
										data-toggle="tab" href data-state="1">草稿(${cg})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state1" data-state="2">待审核(${dsh})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state1" data-state="3">招标中(${zbz})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="4">进行中(${jxz})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="5">已结束(${yjs})</a></li>
								</ul>
							</div>
							<div class="shop-order-keyword m-y-20">
								<div class="form-group">
									<div class="input-search">
										<button type="submit" class="input-search-btn">
											<i class="icon wb-search" aria-hidden="true"></i>
										</button>
										<input type="text" class="form-control" name="keyword"
											data-table-search="true"
											placeholder="需求编号、需求名称、项目编号、项目名称、学校名称">
									</div>
								</div>
							</div>
							<div class="shop-order-list" data-scale="1" id="ulOrders">

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade modal-primary in" id="addr-edit-modal"
		aria-labelledby="addr-edit-modal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">修改日期</h4>
				</div>
				<form action="" id="formModifyDate">
					<input name="wid" type="hidden" value="">
					<div class="modal-body">
						<div class="form-group">
							<label for="name" class="required">招标截至日期</label> <input
								class="form-control datepicker" type="text" name="zbjzrq"
								placeholder="请输入需求招标截至日期，到达该日期后，如果没有投标或者选标，需求则会自动关闭" required
								data-fv-notempty-message="此项不能为空" data-bv-date="true"
								data-bv-date-format="YYYY-MM-DD"
								data-bv-date-message="请输入正确的日期格式">
						</div>
						<div class="form-group">
							<label for="name" class="require">交付日期</label> <input type="text"
								class="form-control datepicker" name="jfrq"
								placeholder="请输入预期交付日期日期，中标者将严格按照该日期交付需求相关信息" required
								data-fv-notempty-message="此项不能为空" data-bv-date="true"
								data-bv-date-format="YYYY-MM-DD"
								data-bv-date-message="请输入正确的日期格式">
						</div>
					</div>
					<div class="modal-footer text-xs-left">
						<button type="button" class="btn btn-primary btn-squared"
							id="btnSaveDate">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade modal-primary in" id="rebackModal"
		aria-labelledby="rebackModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">收回需求</h4>
				</div>
				<form action="" id="formReback">
					<input name="rwid" type="hidden" value="">
					<div class="modal-body">
						<div class="form-group">
							<textarea class="form-control" rows="3" name="shly"
								placeholder="请输入收回需求的原因" required=""
								data-fv-notempty-message="此项不能为空" data-fv-field="zone_a"></textarea>
						</div>
					</div>
					<div class="modal-footer text-xs-left">
						<button type="button" class="btn btn-primary btn-squared"
							id="btnSaveReback">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade modal-primary in" id="questionModal"
		aria-labelledby="questionModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">发布问题</h4>
				</div>
				<form action="" id="formQuestion">
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="rwid" value="">
							<input type="text" class="form-control" name="rwmc"
								placeholder="一个清晰的名字能帮助开发者快速的了解需求" required
								data-fv-notempty-message="此项不能为空"
								value="<c:if test='${!empty rwjbxx}'>${rwjbxx.rwmc}</c:if>">
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
							id="btnSaveQuestion">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		var page_type = "xqfOrder";
		var parentId="${parentId}";
	</script>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<%@ include file="/jsp/bottom.jsp"%>

</body>
</html>
