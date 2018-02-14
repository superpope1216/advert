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
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3>
									<i class="fa fa-edit my-text-color" aria-hidden="true" style="margin-right:10px;"></i>发布新广告资源
								</h3>
							</div>
							<div class="row my-mt-20">
								<div class="col-xs-6 col-sm-3"
									style="padding-left: 0px; padding-right: 0px;">
									<button type="button" class="btn btn-primary btn-sm btn-block"
										id="btnSupply">媒体广告资源</button>
								</div>
								<div class="col-xs-6 col-sm-3"
									style="padding-left: 0px; padding-right: 0px;">
									<button type="button" class="btn btn-default btn-sm btn-block"
										id="btnBuy">服务/设备/非广告资源</button>
								</div>
							</div>
							<div class="row my-mt-10">
								<%@ include file="/jsp/supply/gglx_header.jsp"%>
							</div>
							<div class="row my-mt-10">
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszy">
									<input type="hidden" name="formDszy.wid">
									<h4>电视广告代理信息添加</h4>
									<div class="well well-sm my-padding-12">请选择所要发布的电视媒体</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">地区</label>
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
											class="col-sm-2 col-md-2 control-label text-right">电视台</label>
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
											class="col-sm-2 col-md-2 control-label text-right">广告形式</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<input type="hidden" name="dszyInfo.advertType" value="1">
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
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
											class="col-sm-2 col-md-2 control-label text-right">时段频道</label>
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
											class="col-sm-2 col-md-2 control-label text-right">黄金时段折扣</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszySdInfo.hjsdZk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">折</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">非黄金时段折扣</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszySdInfo.fhjsdZk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
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
											class="col-sm-2 col-md-2 control-label text-right">栏目频道</label>
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
											class="col-sm-2 col-md-2 control-label text-right">代理栏目</label>
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
											class="col-sm-2 col-md-2 control-label text-right">全时长折扣</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyLmInfo.qscZk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">
												折<a href="javascript:void(0);" style="margin-left: 10px"
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
															style="width: 80px; height: 30px;">
															</td>
															<td>折</td>
															<td>10秒</td>
														<td><input type="text" name="dszyLmInfo.tenZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;">
															</td>
															<td>折</td>
													</tr>
													<tr>
														<td>15秒</td>
														<td><input type="text" name="dszyLmInfo.fiveteenZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;">
															</td>
															<td>折</td>
															<td>20秒</td>
														<td><input type="text" name="dszyLmInfo.twentyZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;">
															</td>
															<td>折</td>
													</tr>
													<tr>
														<td>30秒</td>
														<td ><input type="text" name="dszyLmInfo.thirtyZk"
															class="form-control" required
															data-fv-notempty-message="此项不能为空"
															style="width: 80px; height: 30px;">
															</td>
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyTbInfo.name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">包含频道</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12" name="divTbBhpd">
												&nbsp;
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出次数</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyTbInfo.bcsmBm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${tbbccslx}" var="data" varStatus="status">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" name="dszyTbInfo.bcsmNum" class="form-control" required
													data-fv-notempty-message="此项不能为空">
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
														<td>
															<input type="checkbox" name="dszyTbInfo.fiveHas" value="1">5秒
															</td>
														<td>
															<input type="text"
															style="width: 50px;" name="dszyTbInfo.fiveMoney">元
														</td>
														<td><input type="checkbox" name="dszyTbInfo.seventHas" value="1">
														7.5秒</td><td><input type="text"
															style="width: 50px;" name="dszyTbInfo.seventMoney">元
														</td>
															<td>
															<input type="checkbox" name="dszyTbInfo.tenHas" value="1">
															10秒
															</td><td><input type="text"
															style="width: 50px;" name="dszyTbInfo.tenMoney">元
														</td>
													</tr>
													<tr>
													
														<td><input type="checkbox" name="dszyTbInfo.fifteenHas" value="1">15秒
														</td><td><input type="text"
															style="width: 50px;" name="dszyTbInfo.fifteenMoney">元
														</td>
														<td>	
														<input type="checkbox" name="dszyTbInfo.twentyHas" value="1">20秒</td>
														<td><input type="text"
															style="width: 50px;" name="dszyTbInfo.twentyMoney">元
														</td>
														<td><input type="checkbox" name="dszyTbInfo.twentyFiveHas" value="1">25秒</td>
														<td><input type="text"
															style="width: 50px;" name="dszyTbInfo.twentyFiveMoney">元
														</td>
													</tr>
													<tr>
														<td>
															<input type="checkbox" name="dszyTbInfo.thirtyHas" value="1">30秒</td>
															<td><input type="text"
															style="width: 50px;" name="dszyTbInfo.thirtyMoney">元
														</td>
														<td>
															<input type="checkbox" name="dszyTbInfo.fortyFiveHas" value="1">45秒</td>
															<td><input type="text"
															style="width: 50px;" name="dszyTbInfo.fortyFiveMoney">元
														</td>
														<td>
															<input type="checkbox" name="dszyTbInfo.sixtyHas" value="1">60秒</td>
															<td><input type="text"
															style="width: 50px;" name="dszyTbInfo.sixtyMoney">元
														</td>
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyZtInfo.name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">专题频道</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZtInfo.ztpdBm"
													required data-fv-notempty-message="此项不能为空">

													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">时间段</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZtInfo.sjdBm"
													required data-fv-notempty-message="此项不能为空">

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
											class="col-sm-2 col-md-2 control-label text-right">播出时长</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyZtInfo.bcsc" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">分钟</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="dszyZtInfo.ggjg" class="form-control" required
													data-fv-notempty-message="此项不能为空">
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyGmInfo.name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属频道</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.sspdBm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属栏目</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.sslmBm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">播出频次</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" class="form-control" name="dszyGmInfo.bcpc" required data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">次/月</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyGmInfo.ggjgBm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${gmggjgpc}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>	
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control"  required data-fv-notempty-message="此项不能为空" name="dszyGmInfo.ggjgMoney">
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
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="dszyZzInfo.name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属频道</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZzInfo.sspdBm"
													required data-fv-notempty-message="此项不能为空">

													<option value="">--请选择--</option>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">所属栏目</label>
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
											class="col-sm-2 col-md-2 control-label text-right">播出频次</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" class="form-control" name="dszyZzInfo.bcpc" required data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">次/月</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyZzInfo.ggjgBm"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${gmggjgpc}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>	
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="dszyZzInfo.dszyId"
													required data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">元</div>
										</div>
									</div>

								</form>
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDszyExt">
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">行业</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="radio" name="dszyExtInfo.sfxzhy" required
													data-fv-notempty-message="此项不能为空" value=0 checked>不限行业
												<input type="radio" name="dszyExtInfo.sfxzhy" required
													data-fv-notempty-message="此项不能为空" value=1>限制行业

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
											class="col-sm-2 col-md-2 control-label text-right">广告代理方式</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="dszyExtInfo.ggdlfs"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${ggdlfs}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<a href="javascript:void(0);" name="aScdlzs">上传代理证书</a>
											</div>
										</div>
									</div>
									<div class="form-group" name="divScdlzs" style="display: none;">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传代理证书</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="file">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传图片</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="file">
											</div>
											<div class="col-sm-4"></div>
										</div>
									</div>
									<button class="btn btn-lg btn-primary btn-block" type="button"
										id="btnPublishingSd">马上发布</button>
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
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>