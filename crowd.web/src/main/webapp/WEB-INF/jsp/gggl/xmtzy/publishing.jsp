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
									<i class="fa fa-edit my-text-color" aria-hidden="true"
										style="margin-right: 10px;"></i>发布新广告资源
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
									method="post" action="" role="form" id="formXmtzy">
									<input type="hidden" name="xmtzyInfo.wid">
									<h4>新媒体信息添加</h4>
									<div class="well well-sm my-padding-12">请选择所要发布的新媒体信息</div>

									<input type="hidden" name="flag" value="1" />
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">标题</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<input type="text" name="xmtzyInfo.name"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">地区</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="xmtzyInfo.area" required
													data-fv-notempty-message="此项不能为空">
													<option value="">--请选择--</option>
													<c:forEach items="${area}" var="data">
														<option value="${data.lbdm}">${data.lbmc}</option>
													</c:forEach>

												</select>
											</div>
											<div class="col-sm-4">
												<select class="form-control " name="xmtzyInfo.city">
													<option value="">--请选择--</option>

												</select>
											</div>
											<div class="col-sm-4 text-left my-form-bz">
												省为必选项，市区如不清楚可不选</div>

										</div>
									</div>

									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">新媒体类型</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<select class="form-control " name="xmtzyInfo.advertType"
													required data-fv-notempty-message="此项不能为空">
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
											class="col-sm-2 col-md-2 control-label text-right">广告价格</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="xmtzyInfo.ggjg"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">广告规格形式</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-4">
												<input type="text" name="xmtzyInfo.ggggxs"
													class="form-control" required
													data-fv-notempty-message="此项不能为空">
											</div>
										</div>
									</div>
									<div style="clear: both"></div>
									<div class="well well-sm my-padding-12">描述这个新媒体</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">受众人群：</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${szrq}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="xmtzyInfo.szrq"
															value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">教育程度：</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${jycd}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="xmtzyInfo.jycd"
															value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">职业分布：</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${zyfb}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="xmtzyInfo.zyfb"
															value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">收入状况：</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-12">
												<c:forEach items="${srzk}" var="data">
													<div class="col-sm-4">
														<input type="checkbox" name="xmtzyInfo.srzk"
															value="${data.lbdm}">${data.lbmc}
													</div>

												</c:forEach>

											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="firstname"
											class="col-sm-2 col-md-2 control-label text-right">新媒体简介：</label>
										<div class="col-sm-10 col-md-10">
											<div class="col-sm-8">
												<textarea class="form-control" name="xmtzyInfo.xmtjj"></textarea>
											</div>
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
		var page_type = "xmtzyPublishing";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>