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

.mygglx-parent {
	float: left;
	margin-left: 1px;
	display: inline;
}

.mygglx {
	float: left;
	border: 1px solid #dcdcdc;
	background-color: #fff;
	width: 100px;
	text-align: center;
	padding: 5px 0px;
	margin-left: -1px;
	display: inline;
}

.mygglx a {
	color: #666;
	font-size: 14px;
	padding-top: 15px;
}

.mygglx strong {
	color: #004CA0;
	font-size: 14px;
}

.mygglx a:hover {
	color: #666;
	font-size: 14px;
}

.mygglx-active {
	float: left;
	border: 1px solid #004CA0;
	background-color: #004CA0;
	width: 100px;
	text-align: center;
	padding: 5px 0px;
	margin-left: -1px;
	display: inline;
}

.mygglx-active>a {
	color: #FFF;
	font-size: 14px;
}

.mygglx-active>a:hover {
	color: #FFF;
	font-size: 14px;
}

.mygglx-active>strong {
	color: #FFF;
	font-size: 14px;
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
					<div class="panel m-b-0">
						<div class="panel-body">
							<div class="row" style="border-bottom: 1px solid #999">
								<h3>
									<i class="fa fa-gear my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>代理信息列表
									<div class="pull-right">
										<button type="button" id="btnSupply" class="btn btn-link">
											<i class="fa fa-edit my-text-color" aria-hidden="true"
												style="margin-right: 10px;"></i>返回代理信息列表
										</button>
									</div>
								</h3>
							</div>

							
							<div class="row"  style="margin-top:20px;">
								<form class="form-register met-form form-horizontal"
									method="post" action="" role="form" id="formDlxx">
									<input type="hidden" name="wid" value="" />
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">代理标题<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-10">
												<input type="text" class="form-control" name="title"
													placeholder="请输入代理信息标题"
													data-bv-notempty="true" data-bv-notempty-message="此项不能为空">
											</div>

										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">代理开始时间<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-4">
												<input class="form-control datepicker" type="text"
												name="kssj"
												placeholder="请输入代理开始时间"
												required data-fv-notempty-message="此项不能为空"
												data-bv-date="true" data-bv-date-format="YYYY-MM-DD"
												data-bv-date-message="请输入正确的日期格式"
												value="">
											</div>
											<div class="col-sm-2">
												代理结束时间<span
											style="color: red">*</span>
											</div>
											<div class="col-sm-4">
												<input class="form-control datepicker" type="text"
												name="jssj"
												placeholder="请输入代理结束时间"
												required data-fv-notempty-message="此项不能为空"
												data-bv-date="true" data-bv-date-format="YYYY-MM-DD"
												data-bv-date-message="请输入正确的日期格式"
												value="">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">上传图片<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-10">
												<div class="upload-box" id="sctuljUploadBox">
												<div class="image-box clear">
													<section class="upload-section">
														<div class="upload-btn"></div>
														<input type="file" name="file" class="upload-input"
															id='sctuljuploadBtn' value="" />
													</section>
												</div>
												</div>
												<input type="hidden" name="imgid"/>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">代理内容正文<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-10">
												<input type="hidden" name="content">
												<SCRIPT id="txtContent" align="center" name="txtContent"
													type=text/plain></SCRIPT>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname" class="col-sm-2 control-label">代理主题简介<span
											style="color: red">*</span></label>
										<div class="col-sm-10">
											<div class="col-sm-10">
												<textarea class="form-control" cols="8" name="ztnr" placeholder="请输入代理主题简介"
													data-bv-notempty="true" data-bv-notempty-message="此项不能为空"></textarea>
											</div>
										</div>
									</div>
									<div class="form-group" style="clear: both;">
									<div style="margin-left: 25%; width: 75%;">
										<button class="btn btn-lg btn-primary" style="width: 200px;"
											type="button" id="btnSaveCompany">马上发布</button>
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
		var page_type = "dlglEdit";
		var wid="${wid}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>