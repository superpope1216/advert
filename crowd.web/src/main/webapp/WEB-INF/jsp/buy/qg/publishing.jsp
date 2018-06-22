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
					<%@include file="/jsp/buy/left_menu.jsp"%>

				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3>
									<i class="fa fa-edit my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>发布新求购资源
								</h3>
							</div>
							<div class="row my-mt-10">
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formQgInfo">
									<input type="hidden" name="wid" value="${wid}">
									<h4>求购信息</h4>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">名称<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">

											<div class="col-sm-4">
												<input type="text" name="name" class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
											<div class="col-sm-4">&nbsp;</div>
										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">预算<span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="jg" class="form-control" required
													data-fv-notempty-message="此项不能为空" pattern="^([1-9]\d*(\.\d+)?|0)$"	data-fv-regexp-message="请输入正确的数字类型"  data-fv-stringlength="true" data-fv-stringlength-min="1"
												data-fv-stringlength-max="6">
											</div>
											<div class="col-sm-4">元</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">求购内容 <span
											style="color: red">*</span></label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<textarea rows="10" class="form-control" name="content"
													required data-fv-notempty-message="此项不能为空"></textarea>
											</div>
										</div>
									</div>
									<div class="form-group" >
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
		var page_type = "buyQgPublishing";
		var wid = "${wid}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>