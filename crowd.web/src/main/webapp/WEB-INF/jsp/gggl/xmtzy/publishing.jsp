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
									method="post" action="" role="form" id="formXmtzy">
									<input type="hidden" name="wid">
									<h4>新媒体信息添加</h4>
									<div class="well well-sm my-padding-12">请输入要发布的新媒体信息</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">地区<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="area" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${area}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="city">
													<option value="">--请选择--</option>

												</select>
											</div>
											<div class="col-sm-4 text-left my-form-bz">
												省为必选项，市区如不清楚可不选</div>

										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">新媒体类型<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="advertType" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${xmtlx}" var="data" varStatus="status">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告价格<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="ggjg" class="form-control" required
													data-fv-notempty-message="此项不能为空"
													pattern="^([1-9]\d*(\.\d+)?|0)$"
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
													data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元/单位</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告规格形式<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="ggggxs" class="form-control"
													required data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group" id="divZytp">
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
												<input type="hidden" value="" name="zytp">
											</div>

										</div>
									</div>
									<div style="clear: both"></div>
									<div class="well well-sm my-padding-12">描述这个新媒体</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">受众人群<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${szrq}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="szrq" required
															data-fv-notempty-message="此项不能为空" value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">教育程度<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${jycd}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="jycd" required
															data-fv-notempty-message="此项不能为空" value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">职业分布<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${zyfb}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="zyfb" required
															data-fv-notempty-message="此项不能为空" value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">收入状况<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${srzk}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="srzk" required
															data-fv-notempty-message="此项不能为空" value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">新媒体简介<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<textarea class="form-control" name="xmtjj" required
													data-fv-notempty-message="此项不能为空"></textarea>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div style="margin-left: 25%; width: 75%;">
											<button class="btn btn-lg btn-primary btn-block"
												type="button" id="btnPublishingSd" style="width: 200px;">马上发布</button>
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
		var page_type = "xmtzyPublishing";
		var wid = "${wid}";
		var gglx = "${gglx}";
		var ggfl = "${ggfl}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>