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
.myTable {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

.myTable th, .myTable td {
	border: 1px solid #ccc;
}

.mytable2 {
	font-size: 13px;
}

.mytable2 thead {
	font-weight: bold;
	background: rgb(238, 238, 238);
}
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
									method="post" action="" role="form" id="formWlzy">
									<input type="hidden" name="wid">
									<h4>网络广告资源信息添加</h4>
									<div class="well well-sm my-padding-12">广告基本信息</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">网站地址<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" class="form-control " name="addr"
													required data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告标题<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" class="form-control " name="name"
													required data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告位置<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<table style="width: 100%">
													<tr>
														<c:forEach var="data" items="${zywz}"
															varStatus="dataStatus">
															<td><c:choose>
																	<c:when test="${dataStatus.index==0}">
																		<input type="radio" name="ggwz" checked
																			value="${data.lbdm}">
																	</c:when>
																	<c:otherwise>
																		<input type="radio" name="ggwz" value="${data.lbdm}">
																	</c:otherwise>
																</c:choose> ${data.lbmc}</td>
														</c:forEach>
													</tr>
												</table>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">位置描述</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<textarea cols="5" rows="5" class="form-control "
													name="wzms" required data-fv-notempty-message="此项不能为空">
													
												</textarea>
											</div>
										</div>
									</div>

									<div class="form-group" id="divZytp1">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">资源图片<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
													<div class="upload-box" id="sctuljUploadBox">
													<div class="image-box clear">
														<section class="upload-section">
															<div class="upload-btn"></div>
															<input type="file" name="file" class="upload-input"
																id='sctuljuploadBtn' value="" />
														</section>
													</div>
												</div>
												<input type="hidden" value="" name="zytp1">
											</div>
											
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">展现形态及尺寸</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">展示形态<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="zsxt" required
													data-fv-notempty-message="此项不能为空">
													<option value="">---请选择---</option>
													<c:forEach items="${zsxt}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="zsfs" required
													data-fv-notempty-message="此项不能为空">
													<option value="">---请选择---</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group" id="divZscc">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">尺寸<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="zscc" required
													data-fv-notempty-message="此项不能为空">
													<option value="">---请选择---</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">计费及价格</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">计费方式<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<table style="width: 100%;">
													<tr>
														<c:forEach items="${jffs}" var="data"
															varStatus="dataStatus">
															<td><c:choose>
																	<c:when test="${dataStatus.index==0}">
																		<input type="radio" name="jffs" checked
																			value="${data.lbdm}">
																	</c:when>
																	<c:otherwise>
																		<input type="radio" name="jffs" value="${data.lbdm}">
																	</c:otherwise>
																</c:choose>${data.lbmc}</td>
														</c:forEach>

													</tr>
												</table>
											</div>
										</div>
									</div>
									<div class="form-group" id="divScjf">
										<table class="table table-hover mytable2">
											<thead>
												<tr>
													<th class="text-xs-center">投放周期</th>
													<th class="text-xs-center">刊例价（元）<span
											style="color: red">*</span></th>
													<th class="text-xs-center">销售价（元）<span
											style="color: red">*</span></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td align="center">小时</td>
													<td><input type="text" class="form-control "
														name="hourKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="hourXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">天</td>
													<td><input type="text" class="form-control "
														name="dayKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="dayXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">周</td>
													<td><input type="text" class="form-control "
														name="weekKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="weekXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">半月</td>
													<td><input type="text" class="form-control "
														name="halfMonthKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="halfMonthXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">月</td>
													<td><input type="text" class="form-control "
														name="monthKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="monthXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">季度</td>
													<td><input type="text" class="form-control "
														name="jdKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="jdXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">半年</td>
													<td><input type="text" class="form-control "
														name="halfYearKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="halfYeafXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
												<tr>
													<td align="center">年</td>
													<td><input type="text" class="form-control "
														name="yearKlj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
													<td><input type="text" class="form-control "
														name="yeafXsj" pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div id="divCpm" style="display: none;">
										<div class="form-group">
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">刊例价<span
											style="color: red">*</span></label>
											<div class="col-sm-10 col-md-10">
												<div class="col-sm-4">
													<input type="text" name="cpmKlj" value=""
														class="form-control" required
														data-fv-notempty-message="此项不能为空"
														pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"
														data-fv-stringlength="true" data-fv-stringlength-min="1"
														data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">每千次展示</div>
											</div>
										</div>
										<div class="form-group">
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">销售价<span
											style="color: red">*</span></label>
											<div class="col-sm-10 col-md-10">
												<div class="col-sm-4">
													<input type="text" name="cpmXsj" value=""
														class="form-control" required
														data-fv-notempty-message="此项不能为空"
														pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"
														data-fv-stringlength="true" data-fv-stringlength-min="1"
														data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">每千次展示</div>
											</div>
										</div>
									</div>
									<div id="divCpc" style="display: none;">
										<div class="form-group">
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">刊例价<span
											style="color: red">*</span></label>
											<div class="col-sm-10 col-md-10">
												<div class="col-sm-4">
													<input type="text" name="cpcKlj" value=""
														class="form-control" required
														data-fv-notempty-message="此项不能为空"
														pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"
														data-fv-stringlength="true" data-fv-stringlength-min="1"
														data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">每有效点击</div>
											</div>
										</div>
										<div class="form-group">
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">销售价<span
											style="color: red">*</span></label>
											<div class="col-sm-10 col-md-10">
												<div class="col-sm-4">
													<input type="text" name="cpcXsj" value=""
														class="form-control" required
														data-fv-notempty-message="此项不能为空"
														pattern="^([1-9]\d*(\.\d+)?|0)$"
														data-fv-regexp-message="请输入正确的数字类型"
														data-fv-stringlength="true" data-fv-stringlength-min="1"
														data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">每有效点击</div>
											</div>
										</div>
									</div>
									<div class="form-group">
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
		var page_type = "wlzyPublishing";
		var wid = "${wid}";
		var gglx = "${gglx}";
		var ggfl = "${ggfl}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>