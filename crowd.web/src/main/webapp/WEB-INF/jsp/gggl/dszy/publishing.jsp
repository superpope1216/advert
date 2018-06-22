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

<style>
</style>
<body>
	<%@include file="/jsp/header.jsp"%>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">
					<%@include file="/jsp/supply/left_menu.jsp"%>

				</div>

				<div class="col-lg-9">
					<%@include file="/jsp/supply/yhdj_header.jsp"%>
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3>
									<i class="fa fa-edit my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>发布新广告资源
								</h3>
							</div>
							
							<div class="row my-mt-10">
								<%@ include file="/jsp/supply/gglx_header.jsp"%>
							</div>
							<div class="row my-mt-10">
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszy">
									<input type="hidden" name="dszyInfo.wid" value="${wid}">
									<h4>电视广告信息添加</h4>
									<div class="well well-sm my-padding-12">请输入要发布的电视广告信息</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">地区<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyInfo.area" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${area}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="dszyInfo.city">
													<option value="">--请选择--</option>

												</select>
											</div>
											<div class="col-sm-4 text-left my-form-bz">
												省为必选项，市区如不清楚可不选</div>

										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">电视台<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyInfo.tvId" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告形式<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<input type="hidden" name="dszyInfo.advertType" value="${ggfl}">
												<c:forEach items="${ggxs}" var="data" varStatus="status">
													<c:if test="${status.index==1}"></c:if>
													<c:choose>
														<c:when test="${status.index==0}">
															<input type="radio" name="dszyInfo.advertType1"
																value="${data.lbdm}" checked>${data.lbmc}		
														</c:when>
														<c:otherwise>
															<input type="radio" name="dszyInfo.advertType1"
																value="${data.lbdm}">${data.lbmc}
														</c:otherwise>
													</c:choose>

												</c:forEach>
											</div>
										</div>
									</div>

								</form>
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszySd"
									enctype="multipart/form-data">
									<input type="hidden" name="dszySdInfo.wid">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视时段广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszySdInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">时段频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszySdInfo.tvPd"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">黄金时段折扣<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszySdInfo.hjsdZk"
													class="form-control" required pattern="^([1-9]\d*(\.\d+)?|0)$"
													data-fv-notempty-message="此项不能为空"
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">折</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">非黄金时段折扣<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszySdInfo.fhjsdZk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空"
													pattern="^([1-9]\d*(\.\d+)?|0)$"
													data-fv-notempty-message="此项不能为空"
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">折</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyLm"
									style="display: none;">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视栏目广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyLmInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">栏目频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyLmInfo.pdId"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">代理栏目<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyLmInfo.dllm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">全时长折扣<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyLmInfo.qscZk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													data-fv-notempty-message="此项不能为空"
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">
												折<a href="javascript:void(0);" style="margin-left: 10px;color:blue;"
													name="aScbt">时长不同，折扣不同</a>
											</div>
										</div>
									</div>
									<div class="form-group" style="display: none;" name="divBtsc">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">&nbsp;</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<table>
													<tr>
														<td>5秒</td>
														<td><input type="text" name="dszyLmInfo.fiveZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
														<td>折</td>
														<td>10秒</td>
														<td><input type="text" name="dszyLmInfo.tenZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
														<td>折</td>
													</tr>
													<tr>
														<td>15秒</td>
														<td><input type="text" name="dszyLmInfo.fiveteenZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
														<td>折</td>
														<td>20秒</td>
														<td><input type="text" name="dszyLmInfo.twentyZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
														<td>折</td>
													</tr>
													<tr>
														<td>30秒</td>
														<td><input type="text" name="dszyLmInfo.thirtyZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
														<td colspan="3">折</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</form>



								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyTb"
									style="display: none;">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视套播广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyTbInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">包含频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12" name="divTbBhpd">&nbsp;</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出次数<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyTbInfo.bcsmBm"
													required data-bv-notempty="true" data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${tbbccslx}" var="data"
														varStatus="status">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" name="dszyTbInfo.bcsmNum"
													class="form-control" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">次</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">套播价格</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<table>
													<tr>
														<td><input type="checkbox" name="dszyTbInfo.fiveHas"
															value="1">5秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.fiveMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox"
															name="dszyTbInfo.seventHas" value="1" > 7.5秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.seventMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox" name="dszyTbInfo.tenHas"
															value="1"> 10秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.tenMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
													</tr>
													<tr>

														<td><input type="checkbox"
															name="dszyTbInfo.fifteenHas" value="1">15秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.fifteenMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox"
															name="dszyTbInfo.twentyHas" value="1">20秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.twentyMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox"
															name="dszyTbInfo.twentyFiveHas" value="1">25秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.twentyFiveMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
													</tr>
													<tr>
														<td><input type="checkbox"
															name="dszyTbInfo.thirtyHas" value="1">30秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.thirtyMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox"
															name="dszyTbInfo.fortyFiveHas" value="1">45秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.fortyFiveMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
														<td><input type="checkbox" name="dszyTbInfo.sixtyHas"
															value="1">60秒</td>
														<td><input type="text" style="width: 50px;"
															name="dszyTbInfo.sixtyMoney" pattern="^([1-9]\d*(\.\d+)?|0)$">元</td>
													</tr>
												</table>
											</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyZt"
									style="display: none;">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视专题广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyZtInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" data-bv-notempty="true">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">专题频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZtInfo.ztpdBm"
													required data-fv-notempty-message="此项不能为空" data-bv-notempty="true">

													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">时间段<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZtInfo.sjdBm" 
													required data-fv-notempty-message="此项不能为空" data-bv-notempty="true">

													<option value="">--请选择--</option>
													<c:forEach var="data" items="${ztsjd}">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出时长<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyZtInfo.bcsc"
													class="form-control" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">分钟</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyZtInfo.ggjg" data-bv-notempty="true"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元/分钟</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyGm"
									style="display: none;">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视冠名广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyGmInfo.name" data-bv-notempty="true"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.sspdBm" data-bv-notempty="true"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属栏目<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.sslmBm" data-bv-notempty="true"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出频次<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" class="form-control"
													name="dszyGmInfo.bcpc" required  data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">次/月</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.ggjgBm" data-bv-notempty="true"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${gmggjgpc}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空"
													name="dszyGmInfo.ggjgMoney" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyZz"
									style="display: none;">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布电视赞助广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyZzInfo.name" data-bv-notempty="true"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属频道<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZzInfo.sspdBm" data-bv-notempty="true"
													required data-fv-notempty-message="此项不能为空">

													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属栏目<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">

												<select class="form-control " name="dszyZzInfo.sslmBm"
													required data-fv-notempty-message="此项不能为空">

													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出频次<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" class="form-control"
													name="dszyZzInfo.bcpc" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">次/月</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZzInfo.ggjgBm"
													required data-fv-notempty-message="此项不能为空" data-bv-notempty="true">
													<option value="">--请选择--</option>
													<c:forEach items="${gmggjgpc}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control"
													name="dszyZzInfo.dszyId" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元</div>
										</div>
									</div>

								</form>
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyExt">
									<input type="hidden" name="dszyExtInfo.wid" value=""/>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">行业<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="radio" name="dszyExtInfo.sfxzhy" required  data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" value="0" checked>不限行业
												<input type="radio" name="dszyExtInfo.sfxzhy" required data-bv-notempty="true"
													data-fv-notempty-message="此项不能为空" value="1">限制行业

											</div>
										</div>
									</div>
									<div class="form-group" name="divHy" style="display: none;">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">&nbsp;</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<c:forEach items="${hy}" var="data">
													<input type="checkbox" name='dszyExtInfo.hy'
														value="${data.lbdm}" />${data.lbmc}
												</c:forEach>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">补充说明</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<textarea rows="5" class="form-control"
													name="dszyExtInfo.bcsm">
													</textarea>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告代理方式<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyExtInfo.ggdlfs" data-bv-notempty="true"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${ggdlfs}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group" style="clear: both;">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传代理证书</label>
										<div class="col-sm-10 col-md-10">
											<div class="upload-box" id="dlzsljUploadBox">
												<div class="image-box clear">
													<section class="upload-section">
														<div class="upload-btn"></div>
														<input type="file" name="file" class="upload-input"
															id='dlzsljuploadBtn' value="" />
													</section>
												</div>
											</div>
											<input type="hidden" value="" name="dszyExtInfo.dlzslj">
										</div>
									</div>
									<div class="form-group" style="clear: both;">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传封面图片<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="upload-box" id="sctuljUploadBox">
												<div class="image-box clear">
													<section class="upload-section">
														<div class="upload-btn"></div>
														<input type="file" name="file" class="upload-input"
															id='sctuljuploadBtn' value="" />
													</section>
												</div>
											</div>
											<input type="hidden" value="" name="dszyExtInfo.sctulj">
										</div>
									</div>
									<div class="form-group" style="clear: both;">
										<div style="margin-left: 25%; width: 75%;">
											<button class="btn btn-lg btn-primary btn-block" type="button"
											id="btnPublishingSd" style="width: 200px;">马上发布</button>
										</div>
										
									</div>
								</form>
							</div>



						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var page_type = "dszyPublishing";
		var wid="${wid}";
		var gglx="${gglx}";
		var ggfl="${ggfl}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>