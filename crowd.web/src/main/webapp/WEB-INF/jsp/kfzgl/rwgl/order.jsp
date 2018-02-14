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

					<%@include file="/jsp/kfzxx/left_menu.jsp"%>
				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0" boxmh-mh>
						<div class="panel-body shop-order">
							<div>
								<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
									<li class='nav-item'><a class="nav-link active" data-toggle="tab"
										href="#state1" data-state="1">开发中(${kfz})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="2">进行中(${jxz})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="3">已结束(${yjs})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="4">招标中(${zbz})</a></li>
									<li class='nav-item'><a class="nav-link" data-toggle="tab"
										href="#state0" data-state="5">未中标(${wzb})</a></li>
								</ul>
							</div>
							<div class="shop-order-keyword m-y-20">
								<div class="form-group">
									<div class="input-search">
										<button type="submit" class="input-search-btn">
											<i class="icon wb-search" aria-hidden="true"></i>
										</button>
										<input type="text" class="form-control" name="keyword"
											data-table-search="true" placeholder="需求编号、需求名称、项目编号、项目名称、学校名称">
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
	
	<div class="modal fade modal-primary in" id="rwcfModal"
		aria-labelledby="questionModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">订单拆分</h4>
				</div>
				<form action="" id="formRwcf">
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="wid" value=""/>
							<input type="hidden" name="rwid" value=""/>
							<input type="text" class="form-control" name="kfzid"
								placeholder="请输入用户名称、昵称、工号等进去搜索" required data-fv-notempty-message="此项不能为空" value="">
						</div>
						<div class="form-group">
								<input type="text" class="form-control" name="rwjg"
									placeholder="请输入拆分订单金额(元)" required
									data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
									data-fv-regexp-message="请输入正确的正整数类型数字"
									data-fv-stringlength="true" data-fv-stringlength-min="1"
									data-fv-stringlength-max="6" value="">
						</div>
						<div class="form-group">
								<select class="form-control prov" name="sfsqfy" required
									data-fv-notempty-message="此项不能为空" >
									<option value="">---请选择是否选择${rwcfsqbl}%订单费用---</option>
									<option value="1">是</option>
									<option value="0">否</option> 
								</select>
						</div>
						<div class="form-group">
								<textarea class="form-control" name="rwnr" placeholder="请输入拆分内容" required data-fv-notempty-message="此项不能为空" >
								</textarea>
						</div>
					</div>
					<div class="modal-footer text-xs-left">
						<button type="button" class="btn btn-primary btn-squared"
							id="btnSaveRwcf">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade modal-primary in" id="rwcfJlModal"
		aria-labelledby="questionModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">订单拆分记录</h4>
				</div>
					<div class="modal-body">
						<div class="table-responsive text-xs-center">
								<table class="table table-striped m-b-0 mytable">
									<thead>
										<tr>
											<th class="text-xs-center" style="width: 100px;">操作</th>
											<th class="text-xs-center" style="width: 100px;">合作者</th>
											<th class="text-xs-center">拆分金额</th>
											<th class="text-xs-center" style="width: 100px;">是否收取${rwcfsqbl}%费用</th>
											<th class="text-xs-center" style="width: 100px;">实际支出金额</th>
											<th class="text-xs-center" style="width: 100px;">拆分状态</th>
										</tr>
									</thead>
									<tbody id="tblRwcf">
										
									</tbody>
								</table>
							</div>
					</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade modal-primary in" id="ysqrModal"
		aria-labelledby="ysqrModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">订单确认</h4>
				</div>
				<form action="" id="formYsqr">
					<div class="modal-body">
						<div class="form-group">
								<input type="hidden" name="wid">
								<select class="form-control prov" name="sfjs" required
									data-fv-notempty-message="此项不能为空" >
									<option value="">---请选择是否验收通过---</option>
									<option value="1">是</option>
									<option value="0">否</option> 
								</select>
						</div>
					</div>
					<div class="modal-footer text-xs-left">
						<button type="button" class="btn btn-primary btn-squared"
							id="btnSaveYsqr">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
	var page_type="kfzOrder";
	var rwid="${rwid}";
	var isnbkfz=${isnbkfz};
	var rwcfsqbl=${rwcfsqbl};
	</script>

	<%@include file="/jsp/footer/footer2.jsp" %>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>
