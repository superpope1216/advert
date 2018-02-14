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
					<div class="panel">
						<div class="panel-body shop-order-check">
							<div class="row order-state-1">
								<div class="col-sm-4 shop-order-type">
									<h3 class="state_txt font-size-20">
										<i class="icon wb-payment orange-600" aria-hidden="true"
											style="font-size: 38px;"></i><span>${rwjbxx.xmztDisplay}</span>
											
									</h3>

								</div>

								<div class="col-sm-8 text-xs-right shop-order-type-btn">

									<a href="<%=request.getContextPath()%>/xqfOrder/index"
										data-id="15"
										class="btn btn-default btn-squared btn-outline shop-order-close">返回</a>
									<c:choose>
										<c:when test="${rwjbxx.xmzt == 5}">
											<a href="javascript:void(0);" data-option='jc'
												data-key='${rwjbxx.wid}' class="btn btn-danger btn-squared">检测</a>
										</c:when>
										<c:when test="${rwjbxx.xmzt== 8}">
											<a href="javascript:void(0);" data-option='ys'
												data-key='${rwjbxx.wid}' class="btn btn-danger btn-squared">验收确认</a>
										</c:when>
										<c:when test="${rwjbxx.xmzt== 11}">
											<a href="javascript:void(0);" data-option='sh'
												data-key='${rwjbxx.wid}' class="btn btn-danger btn-squared">售后确认</a>
										</c:when>
										<c:when test="${rwjbxx.xmzt==13}">
											<a href="javascript:void(0);" data-option='pj'
												data-key='${rwjbxx.wid}' class="btn btn-danger btn-squared">评价</a>
										</c:when>

									</c:choose>


								</div>

							</div>
						</div>
					</div>

					<div class="panel">
						<div class="panel-body row p-b-20">
							<div class="pearls blocks-4">
								<c:choose>
									<c:when test="${rwjbxx.xmzt  >= 8}">
										<li class="pearl m-b-0 current">
									</c:when>
									<c:otherwise>
										<li class="pearl m-b-0 disabled">
									</c:otherwise>
								</c:choose>
								<div class="pearl-icon">
									<i class="icon wb-clipboard" aria-hidden="true"></i>
								</div>
								<span class="pearl-title">开发者申请验收
									<p class="blue-grey-400 hidden-sm-down m-b-0">
										<c:if test='{not empty ysz}'>
											<c:forEach items="${ysz}" var="data">
													${data.czsj}
													<fmt:formatDate value="${data.czsj}"
													pattern="yyyy-MM-dd hh:mi:ss" />
											</c:forEach>
										</c:if>
									</p>
								</span>
								</li>
								<c:choose>
									<c:when test="${rwjbxx.xmzt>=9}">
										<li class="pearl m-b-0 current">
									</c:when>
									<c:otherwise>
										<li class="pearl m-b-0 disabled">
									</c:otherwise>
								</c:choose>

								<div class="pearl-icon">
									<i class="icon wb-payment" aria-hidden="true"></i>
								</div>
								<span class="pearl-title">需求方验收确认
									<p class="blue-grey-400 hidden-sm-down m-b-0">
										<c:if test='{not empty ystg}'>
											<c:forEach items="${ystg}" var="data">
													${data.czsj}
													<fmt:formatDate value="${data.czsj}"
													pattern="yyyy-MM-dd hh:mi:ss" />
											</c:forEach>
										</c:if>
									</p>
								</span>
								</li>
								<c:choose>
									<c:when test="${rwjbxx.xmzt>=10}">
										<li class="pearl m-b-0 current">
									</c:when>
									<c:otherwise>
										<li class="pearl m-b-0 disabled">
									</c:otherwise>
								</c:choose>

								<div class="pearl-icon">
									<i class="icon wb-map" aria-hidden="true"></i>
								</div>
								<span class="pearl-title">开发者申请售后
									<p class="blue-grey-400 hidden-sm-down m-b-0">
										<c:if test='{not empty sqshjs}'>
											<c:forEach items="${sqshjs}" var="data">
													${data.czsj}
													<fmt:formatDate value="${data.czsj}"
													pattern="yyyy-MM-dd hh:mi:ss" />
											</c:forEach>
										</c:if>
									</p>
								</span>
								</li>
								<c:choose>
									<c:when test="${rwjbxx.xmzt>=13}">
										<li class="pearl m-b-0 current">
									</c:when>
									<c:otherwise>
										<li class="pearl m-b-0 disabled">
									</c:otherwise>
								</c:choose>
								<div class="pearl-icon">
									<i class="icon wb-check" aria-hidden="true"></i>
								</div>
								<span class="pearl-title">需求方售后确认
									<p class="blue-grey-400 hidden-sm-down m-b-0">
										<c:if test='{not empty shjs}'>
											<c:forEach items="${shjs}" var="data">
													${data.czsj}
													<fmt:formatDate value="${data.czsj}"
													pattern="yyyy-MM-dd hh:mi:ss" />
											</c:forEach>
										</c:if>
									</p>
								</span>
								</li>
							</div>
						</div>
					</div>

					<div class="panel">
						<div class="panel-body">
							<div class="table-responsive text-xs-center">
								<table class="table table-striped m-b-0 mytable">
									<thead>
										<tr>
											<th class="text-xs-center" style="width: 100px;">需求编号</th>
											<th class="text-xs-left">需求名称</th>
											<th class="text-xs-center" style="width: 100px;">金额</th>
											<th class="text-xs-center" style="width: 100px;">开发者</th>
											<th class="text-xs-center" style="width: 100px;">需求方</th>
										</tr>
									</thead>
									<tbody>
										<tr>

											<td class="text-xs-left"><span class="tag tag-default">${rwjbxx.rwbh}</span>
											</td>
											<td><span class="tag tag-default"
												style="text-align: left;">${rwjbxx.rwmc}</span></td>
											<td><span class="tag tag-default"> <c:choose>
														<c:when test="${!empty rwjbxx.zbje}">
												${rwjbxx.zbje+rwjbxx.jjbzje}		
											</c:when>
														<c:otherwise>
												${rwjbxx.xmysje+rwjbxx.jjbzje}
											</c:otherwise>
													</c:choose>
											</span></td>
											<td><span class="tag tag-default">${rwjbxx.kfznc}</span></td>
											<td><span class="tag tag-default">${rwjbxx.xqfnc}</span></td>
										</tr>


									</tbody>
								</table>
							</div>
						</div>
					</div>
					<c:if test="${not empty rwjbxx.kfzid}">
						<div class="panel">
							<div class="panel-body">
								<div class="table-responsive text-xs-center">
									<table class="table table-striped m-b-0">
										<thead>
											<tr>
												<th class="text-xs-center">阶段</th>
												<th class="text-xs-center">支出金额</th>

												<th></th>
												<th class="text-xs-center">加急金额</th>
												<th></th>
												<th class="text-xs-center">总支付金额</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${sfxysh==true}">
													<tr>
														<td><span class="tag tag-default">验收</span></td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${(((not  empty rwjbxx.zbje) && rwjbxx.zbje!=0)?rwjbxx.zbje:rwjbxx.xmysje)*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>
														元</span></td>
														<td>+</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${rwjbxx.jjbzje*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>元</span></td>

														<td>=</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)*xmyssqbl/100+rwjbxx.jjbzje*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>
														元</span></td>
													</tr>
													<tr>
														<td><span class="tag tag-default">售后</span></td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)-((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>元</span></td>
														<td>+</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${rwjbxx.jjbzje-rwjbxx.jjbzje*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>元</span></td>

														<td>=</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)-((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)*xmyssqbl/100+rwjbxx.jjbzje-rwjbxx.jjbzje*xmyssqbl/100}" pattern="0.00" maxFractionDigits="2"/>
														元</span></td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td><span class="tag tag-default">验收</span></td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)}" pattern="0.00" maxFractionDigits="2"/>元</span></td>
														<td>+</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${(empty rwjbxx.jjbzje)?0:rwjbxx.jjbzje}" pattern="0.00" maxFractionDigits="2"/>元</span></td>

														<td>=</td>
														<td><span class="tag tag-default">￥
														<fmt:formatNumber type="number" value="${((!empty rwjbxx.zbje)?rwjbxx.zbje:rwjbxx.xmysje)+rwjbxx.jjbzje}" pattern="0.00" maxFractionDigits="2"/>元</span></td>
													</tr>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</c:if>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade modal-primary in" id="moadl_tbxx"
		aria-labelledby="moadl_ysxx" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content" style="min-height:400px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">验收确认</h4>
				</div>
				<div class="modal-body">
					<form id="formRbxxgl" class="form-horizontal" role="form">
						<input type="hidden" name="wid" value=""> <input
							type="hidden" name="rwid" value="">
						<div class="form-group">
							<label class="col-sm-2 control-label">验收结果：</label>
							<div class="col-sm-10">
								<select class="form-control prov" name="ysjg" required
									data-fv-notempty-message="此项不能为空">
									<option value="" SELECTED>---请选择验收结果---</option>
									<option value="1">验收通过</option>
									<option value="0">验收不通过</option>
								</select>
							</div>
						</div>
						<div data-option="divNone" style="height:200px;">
						</div> 
						
						<div data-option="divTgpjnr" style="display: none;">
							<div class="form-group">
								<label class="col-sm-2 control-lable">开发质量：</label>
								<div class="col-sm-10">
									<div data-option="kfzl" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-lable">服务质量：</label>
								<div class="col-sm-10">
									<div data-option="fwzl" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-lable">响应速度：</label>
								<div class="col-sm-10">
									<div data-option="xysd" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class=" form-group">
								<label class="col-sm-2 control-label">评价内容：</label>
								<div class="col-sm-10">
									<textarea rows="3" class="form-control" name="tgpjnr" required
									data-fv-notempty-message="此项不能为空"></textarea>
								</div>
							</div>
						</div>
						<div data-option="divBtgpjnr" style="display: none;">
							<div class=" form-group">
								<label class="col-sm-2 control-label">不通过原因：</label>
								<div class="col-sm-10">
									<textarea rows="3" class="form-control" name="btgyy" required
									data-fv-notempty-message="此项不能为空"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>

				<div class="modal-footer text-xs-left">
					<button type="button" class="btn btn-primary btn-squared"
						id="btnSaveYsjg">保存</button>
					<button type="button" class="btn btn-default btn-squared"
						data-dismiss="modal">取消</button>
				</div>


			</div>
		</div>
	</div>
	
	<div class="modal fade modal-primary in" id="moadl_shjsxx"
		aria-labelledby="moadl_shjsxx" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content" style="min-height:400px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">售后结束确认</h4>
				</div>
				<div class="modal-body">
					<form id="formRbxxglSh" class="form-horizontal" role="form">
						<input type="hidden" name="wid" value=""> <input
							type="hidden" name="rwid" value="">
						<div class="form-group">
							<label class="col-sm-2 control-label">售后结果：</label>
							<div class="col-sm-10">
								<select class="form-control prov" name="ysjg" required
									data-fv-notempty-message="此项不能为空">
									<option value="" SELECTED>---请选择售后结果---</option>
									<option value="1">售后通过</option>
									<option value="0">售后不通过</option>
								</select>
							</div>
						</div>
						<div data-option="divNone" style="height:200px;">
						</div> 
						
						<div data-option="divTgpjnr" style="display: none;">
							<div class="form-group">
								<label class="col-sm-2 control-lable">开发质量：</label>
								<div class="col-sm-10">
									<div data-option="kfzl" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-lable">服务质量：</label>
								<div class="col-sm-10">
									<div data-option="fwzl" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-lable">响应速度：</label>
								<div class="col-sm-10">
									<div data-option="xysd" class="block clearfix">
										<div class="star_score"></div>
									</div>

								</div>
							</div>
							<div class=" form-group">
								<label class="col-sm-2 control-label">评价内容：</label>
								<div class="col-sm-10">
									<textarea rows="3" class="form-control" name="tgpjnr" required 
									data-fv-notempty-message="此项不能为空">${pjnr}</textarea>
								</div>
							</div>
						</div>
						<div data-option="divBtgpjnr" style="display: none;">
							<div class=" form-group">
								<label class="col-sm-2 control-label">不通过原因：</label>
								<div class="col-sm-10">
									<textarea rows="3" class="form-control" name="btgyy" required
									data-fv-notempty-message="此项不能为空"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>

				<div class="modal-footer text-xs-left">
					<button type="button" class="btn btn-primary btn-squared"
						id="btnSaveShjg">保存</button>
					<button type="button" class="btn btn-default btn-squared"
						data-dismiss="modal">取消</button>
				</div>


			</div>
		</div>
	</div>
	<script>
		var page_type = "xqfOrderAction";
		var rwid="${rwjbxx.wid}";
		var kfzl="${kfzl}";
		var fwzl="${fwzl}";
		var xysd="${xysd}";
	</script>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>
