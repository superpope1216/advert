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
.headImg {
	width: 97px;
	height: 97px;
	position: relative;
	top: -1px;
	border-radius: 52px;
}

.sfzImg {
	/*    width: 303px; */
	height: 193px;
	position: relative;
	top: -105px;
	z-index: -1;
}
</style>
<body>
	<%@include file="/jsp/header.jsp"%>
	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">
					<%@include file="/jsp/buy/left_menu.jsp"%>

				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3>
									<i class="fa fa-edit my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>公司信息
								</h3>
							</div>
							<div class="row my-mt-10">
								<div class="well well-sm my-padding-12">提示：企业资料也是展示资料，详细真实的企业资料信息，是赢得广告买方客户信任的前提和基础。因此，请认真细致的填写您的资料，详细可信任的公司简介和清晰的LOGO，是您企业实力的展现。</div>
								<div class="well well-sm my-padding-12"
									style="color: red; font-weight: bold;">${msg}</div>
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formCompany">
									<input type="hidden" name="wid" value="" />
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">公司名称<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="name"
													placeholder="填写营业执照上的公司全称，真实齐全的公司名称增"
													data-bv-notempty="true" data-bv-notempty-message="此项不能为空">
											</div>

										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">公司所在地<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
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
												<select class="form-control " name="city"
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="xian"
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">经营地址<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="addr"
													placeholder="请填写实际的经营地址" data-bv-notempty="true"
													data-bv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">联系人<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="lxr"
													placeholder="建议填写真实姓名，赢取信任和机会" data-bv-notempty="true"
													data-bv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">固定电话<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="gddh"
													placeholder="非常重要，真实无误电话增加咨询量" data-bv-notempty="true"
													data-bv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">QQ号码<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="qq"
													placeholder="随时随地在线沟通，不错过任何商机" data-bv-notempty="true"
													data-bv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">手机<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="sjh"
													data-bv-notempty="true" data-bv-notempty-message="此项不能为空"
													placeholder="请填写手机号" data-bv-regexp="true"
													data-bv-regexp-regexp="^1[34578]\d{9}$"
													data-bv-regexp-message="请输入正确的手机号格式">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">传真</label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="czh"
													placeholder="请填写正确的传真">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">网站地址</label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<input type="text" class="form-control" name="wzdz"
													placeholder="真实可访问，便于潜在客户获取信息">
											</div>
										</div>
									</div>

									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">公司性质<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<select class="form-control " name="gsxz" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${gsxz}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">年营业额<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<select class="form-control " name="nyye"
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${yyed}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">公司简介<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-8">
												<textarea name="gsjj" class="form-control" rows="4"
													placeholder="请简单描述公司的基本信息"></textarea>
											</div>

										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">商品LOG<span
											style="color: red">*</span></label>
										<div class="col-sm-8">
											<div class="well well-sm my-padding-12">注：商铺LOGO大小
												160*160 像素，请尽量按尺寸修改</div>
											<div class="uploaderImg">
												<div id="sfzzmztjidUpload"
													class="bh-l-inline sfz-icon-container pointed">
													<i class="bh-file-img-plus">+</i> <img src=""
														id="sfzzmztjidImg" class="sfzImg" />
												</div>
												<div id="sfzzmztjidBrower" class="uploadBrower"></div>
											</div>
											<input type="hidden" value="" name="gslog">
										</div>
									</div>
									<div class="form-group">
										<div style="margin-left: 25%; width: 75%;">
											<button class="btn btn-lg btn-primary" style="width: 200px;"
												type="button" id="btnSaveCompany">马上修改提交</button>
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
		var page_type = "companyInfoView";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>