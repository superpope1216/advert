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
									method="post" action="" role="form" id="formBzzy">
									<input type="hidden" name="bzzyInfo.wid" value="${wid}">
									<h4>报纸媒体信息添加</h4>
									<div class="well well-sm my-padding-12">请输入要发布的报纸媒体信息</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">地区<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="bzzyInfo.area" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${area}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="bzzyInfo.city">
													<option value="">--请选择--</option>

												</select>
											</div>
											<div class="col-sm-4 text-left my-form-bz">
												省为必选项，市区如不清楚可不选</div>

										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">报纸<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="bzzyInfo.tvId" required
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
												<input type="hidden" name="bzzyInfo.advertType"
													value="${ggfl}">
												<c:forEach items="${bzlx}" var="data" varStatus="status">
													<c:if test="${status.index==1}"></c:if>
													<c:choose>
														<c:when test="${status.index==0}">
															<input type="radio" name="bzzyInfo.advertType1"
																value="${data.lbdm}" checked>${data.lbmc}		
														</c:when>
														<c:otherwise>
															<input type="radio" name="bzzyInfo.advertType1"
																value="${data.lbdm}">${data.lbmc}
														</c:otherwise>
													</c:choose>

												</c:forEach>
											</div>
										</div>
									</div>

								</form>
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formBzzyGsyg"
									enctype="multipart/form-data">
									<input type="hidden" name="bzzyGsygInfo.wid">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布报纸工商硬广广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="bzzyGsygInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">折扣<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="bzzyGsygInfo.zk"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">折</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formBzzyXbmgg"
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
												<input type="text" name="bzzyXbmggInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" >
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">类型<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="bzzyXbmggInfo.lx"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach var="data" items="${xbmgglx}">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">尺寸<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<div class="col-sm-4">
													<input type="text" class="form-control"
														name="bzzyXbmggInfo.ccK" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-1">×</div>
												<div class="col-sm-4">
													<input type="text" class="form-control"
														name="bzzyXbmggInfo.ccG" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-3">（宽×高，单位cm）</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">刊例价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<div class="col-sm-4">
													<input type="text" class="form-control"
														name="bzzyXbmggInfo.kljg" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">元</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">销售价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<div class="col-sm-4">
													<input type="text" class="form-control"
														name="bzzyXbmggInfo.xxjg" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
												</div>
												<div class="col-sm-4">元</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">版位描述<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<div class="col-sm-4">
													<input type="text" class="form-control"
														name="bzzyXbmggInfo.bwms" required
														data-fv-notempty-message="此项不能为空">
												</div>
												<div class="col-sm-4">（如头版、末版等）</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">颜色<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<div class="col-sm-4">
													<select class="form-control " name="bzzyXbmggInfo.ys"
														required data-fv-notempty-message="此项不能为空">
														<option value="">--请选择--</option>
														<c:forEach var="data" items="${bzys}">
															<option value="${data.lbdm}">${data.lbmc}</option>
														</c:forEach>

													</select>
												</div>
												<div class="col-sm-4">（不选择系统默认为黑白）</div>
											</div>
										</div>
									</div>
								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" style="display: none;"
									id="formBzzyRw" enctype="multipart/form-data">
									<input type="hidden" name="bzzyRwInfo.wid">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布报纸软文广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="bzzyRwInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="bzzyRwInfo.btjg"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">正文价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="bzzyRwInfo.zwjg"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元</div>

										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">正文字数限制<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="bzzyRwInfo.zwzsxz"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">字之内</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" style="display: none;"
									id="formBzzyJy" enctype="multipart/form-data">
									<input type="hidden" name="bzzyJyInfo.wid">
									<div class="form-group">
										<label for="firstname"
											class="well well-sm my-padding-12 col-sm-12 col-md-12 control-label text-left">发布报纸软文广告代理信息详情</label>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="bzzyJyInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">单页价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="bzzyJyInfo.dyjg"
													class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元/份</div>
										</div>
									</div>

								</form>

								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formBzzyExt">
									<input type="hidden" name="bzzyExtInfo.wid" value="">
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">行业<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="radio" name="bzzyExtInfo.sfxzhy" required
													data-fv-notempty-message="此项不能为空" value=0 checked>不限行业
												<input type="radio" name="bzzyExtInfo.sfxzhy" required
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
													<input type="checkbox" name='bzzyExtInfo.hy'
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
													name="bzzyExtInfo.bcsm"></textarea>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告代理方式<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="bzzyExtInfo.ggdlfs"
													required data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${ggdlfs}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group" name="divScdlzs">
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
											<input type="hidden" value="" name="bzzyExtInfo.dlzslj">
										</div>
									</div>
									<div class="form-group">
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
											<input type="hidden" value="" name="bzzyExtInfo.sctulj">
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
		var page_type = "bzzyPublishing";
		var wid = "${wid}";
		var gglx = "${gglx}";
		var ggfl = "${ggfl}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>