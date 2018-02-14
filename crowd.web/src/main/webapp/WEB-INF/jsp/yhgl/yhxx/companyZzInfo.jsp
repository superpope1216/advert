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
.uploadBrower {
	width: 106px;
	position: absolute;
	top: 8px;
	left: 166px;
	visibility: hidden;
}

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

.bh-file-img-plus {
	position: relative;
	color: #bbb;
	font-size: 60px;
	display: block;
	font-style: normal;
	left: 40%;
	top: 20%;
}

#sfzzmztjidImg{
	width:303px;
	z-index:0px;
	
}
.sfz-icon-container {
	width: 303px;
	height: 193px;
	background-color: #F3F3F3;
	border: solid 1px #ddd;
}

.uploadPosition {
	border-radius: 52px;
	vertical-align: middle;
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
									<i class="fa fa-edit my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>公司资质信息
									<div class="pull-right">
										<button type="button" id="btnAddZz" class="btn btn-link">
											<i class="fa fa-edit my-text-color" aria-hidden="true"
												style="margin-right: 10px;"></i>添加资质
										</button>
									</div>
								</h3>

							</div>
							<div class="row my-mt-10">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>证书预览</th>
											<th>证件名称</th>
											<th>状态</th>
											<th>更新时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="tblMain">

									</tbody>
								</table>
								<footer class="bg-white">
									<div class="mypaging2 clearfix"></div>
								</footer>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/jsp/footer/footer2.jsp"%>
	<div class="modal fade modal-primary in" id="zzzsViewModal"
		aria-labelledby="ysqrModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">资质证书预览</h4>
				</div>
				<div class="modal-body">
					<img src="" style="width:300px;height:200px" id="imgZzzsView">
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade modal-primary in" id="ysqrModal"
		aria-labelledby="ysqrModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">资质证书</h4>
				</div>
				<div class="modal-body">
					<form class="form-register met-form form-horizontal" method="post"
						action="" role="form" id="formCompanyZz">
						<input type="hidden" name="wid" value="" />
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">证书类型</label>
							<div class="col-sm-10">
								<div class="col-sm-8">
									<select class="form-control " name="zzlx" required
										data-fv-notempty-message="此项不能为空">
										<option value="">--请选择--</option>
										<c:forEach items="${zzlx}" var="data">
											<option value="${data.lbdm}">${data.lbmc}</option>
										</c:forEach>

									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">上传证书</label>
							<div class="col-sm-10">
								<div id="sfzzmztjidUpload"
									class="bh-l-inline sfz-icon-container pointed">
									<i class="bh-file-img-plus">+</i> <img src=""
										id="sfzzmztjidImg" class="sfzImg" />
								</div>
								<div id="sfzzmztjidBrower" class="uploadBrower"></div>
								<input type="hidden" value="" name="zzlog">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer text-xs-left">
					<button type="button" class="btn btn-primary btn-squared"
						id="btnSaveZzzs">保存</button>
					<button type="button" class="btn btn-default btn-squared"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top" hidden>
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<script>
		var page_type = "companyZzInfo";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>