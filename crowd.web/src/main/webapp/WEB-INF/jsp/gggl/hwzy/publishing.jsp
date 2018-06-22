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
									method="post" action="" role="form" id="formHwzy">
									<input type="hidden" name="wid" value="${wid}">

									<div class="form-group">
										<div class="well well-sm my-padding-12" style="clear: both;">户外广告信息添加</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">媒体类型<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="advertType" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${advertType}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<div id="divAdvertType" style="display: none;">
										<div class="form-group">
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">省<span style="color: red">*</span></label>
											<div class="col-sm-10 col-md-10">
												<div class="col-sm-3">
													<select class="form-control " name="area" required
														data-fv-notempty-message="此项不能为空">
														<option value="">--请选择--</option>
														<c:forEach items="${area}" var="data">
															<option value="${data.lbdm}">${data.lbmc}</option>
														</c:forEach>
													</select>
												</div>
												<label for="firstname"
													class="col-sm-1 col-md-1 control-label text-right">市</label>
												<div class="col-sm-3">
													<select class="form-control " name="city">
													</select>
												</div>
												<label for="firstname"
													class="col-sm-1 col-md-1 control-label text-right">县</label>
												<div class="col-sm-3">
													<select class="form-control " name="xian">
													</select>
												</div>
											</div>
											
										</div>
										<div class="form-group" id="divHwxx" style="display: none;">
												<label for="firstname"
													class="col-sm-2 col-md-2 control-label text-right" ><span id="labelName">选择信息</span><span style="color: red">*</span></label>
												<div class="col-sm-10 col-md-10">
													<div class="col-sm-4">
														<select class="form-control " name="tvId" required
													data-fv-notempty-message="此项不能为空">
														</select>
													</div>
												</div>
											</div>
											
									</div>
									<div class="form-group" id="divQy">
												<label for="firstname"
													class="col-sm-2 col-md-2 control-label text-right">选择区域<span style="color: red">*</span></label>
												<div class="col-sm-10 col-md-10">
													<div class="col-sm-4">
														<select class="form-control" name="qy" required
															data-fv-notempty-message="此项不能为空">
														</select>
													</div>
												</div>
											</div>
											<div class="form-group" id="divXs">
												<label for="firstname"
													class="col-sm-2 col-md-2 control-label text-right">选择形式<span style="color: red">*</span></label>
												<div class="col-sm-10 col-md-10">
													<div class="col-sm-4">
														<select class="form-control " name="xs" required
															data-fv-notempty-message="此项不能为空">
														</select>
													</div>
												</div>
											</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">媒体材质</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="mtcz" class="form-control" >
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="well well-sm my-padding-12" style="clear: both;">描述这个户外广告</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">估计人流量<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="gjcll" class="form-control"
													required data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">万人次/天 (必须是纯数字)</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">估计车流量<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="gjrll" class="form-control"
													required data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">万车次/天 (必须是纯数字)</div>
										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">户外媒体规格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<table>
												<tr>
													<td style="width: 100px;"><input type="text"
														name="mtggK" class="form-control" placeholder="宽" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
													<td style="padding-left: 5px; padding-right: 5px;">×</td>
													<td style="width: 100px;"><input type="text"
														name="mtggG" class="form-control" placeholder="高" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
													<td style="padding-left: 5px; padding-right: 5px;">×</td>
													<td style="width: 100px;"><input type="text"
														name="mtggM" class="form-control" placeholder="面" required
														data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
													<td style="padding-left: 5px; padding-right: 5px;">=</td>
													<td style="width: 60px;"><input type="text"
														name="mtggPfm" class="form-control" placeholder=""
														required data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6"></td>
													<td>平方米</td>
												</tr>
											</table>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">执行价格<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="zxjgMonth" class="form-control"
													required data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-1">元/月</div>
											<div class="col-sm-4">
												<input type="text" name="zxjgYear" class="form-control"
													required data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"
													
													data-fv-regexp-message="请输入正确的数字类型"
													data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-3">元/年 (必须是纯数字)</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">照明时间<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="zmsj" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${zmsj}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<!-- <div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传效果图</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4"></div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">上传位置图</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4"></div>
										</div>
									</div>
									 -->
									<div class="well well-sm my-padding-12" style="clear: both;">广告投放信息描述</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">媒体状态<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4 col-md-4">
												<select class="form-control " name="mtzt" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${mtzt}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">最小投放周期<span style="color: red">*</span></label>
											<div class="col-sm-4 col-md-4">

												<select class="form-control " name="zxtfzq" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${zxtfzq}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>

											</div>
										</div>

									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">最早投放时间<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4 col-md-4">
												<input class="form-control datepicker" type="text"
													name="zztfrq" placeholder="请输入最早投放时间" required
													data-fv-notempty-message="此项不能为空" data-bv-date="true"
													data-bv-date-format="YYYY-MM-DD"
													data-bv-date-message="请输入正确的日期格式" value="">
											</div>
											<label for="firstname"
												class="col-sm-2 col-md-2 control-label text-right">所有权到期日<span style="color: red">*</span></label>
											<div class="col-sm-4 col-md-4">
												<input class="form-control datepicker" type="text"
													name="ssqdqr" placeholder="请输入所有权到期日" required
													data-fv-notempty-message="此项不能为空" data-bv-date="true"
													data-bv-date-format="YYYY-MM-DD"
													data-bv-date-message="请输入正确的日期格式" value="">
											</div>
										</div>

									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">最小投放数量<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="zxtfsl" class="form-control"
													required data-fv-notempty-message="此项不能为空" pattern="^\+?[1-9]\d*$"
												data-fv-regexp-message="请输入正确的正整数类型数字"
												data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">个</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告所有权状况<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="ggsyqzk" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${ggsyqzk}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">户外广告简介<span style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-10">
												<textarea rows="5" name="hwgljj" class="form-control"
													required data-fv-notempty-message="此项不能为空"></textarea>
											</div>
										</div>
									</div>
									<div class="form-group" id="divSctplj">
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
											<input type="hidden" value="" name="sctplj">
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
		var page_type = "hwzyPublishing";
		var wid = "${wid}";
		var gglx = "${gglx}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>