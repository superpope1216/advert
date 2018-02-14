<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top3.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/yhgl/login.css'>
<style>
.met-member {
	background-color:;
}

.login_index {
	background-color:;
}
</style>
<body>
	<%@include file="/jsp/yhgl/header.jsp" %>
	<div class="member-profile met-member">
		<div class="container">
			<div class="member-profile-content">
				<div class="row">

					<div class="col-sm-3 sidebar ">
						<%@ include file="/jsp/yhgl/left_menu.jsp" %>
					</div>

					<div class="col-xs-12 col-sm-9 met-member-index met-member-profile">
						<div class="panel panel-default basic">
							<div class="panel-heading">个人信息</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-xs-3">手机号</div>
									<div class="col-xs-9">mycluster</div>
								</div>
								<div class="row">
									<div class="col-xs-3">最后登录IP</div>
									<div class="col-xs-9">61.132.52.116</div>
								</div>
							</div>
						</div>

						<form class="met-form" method="post"
							action="<%=request.getContextPath() %>/yhjbxx/save">
							<div class="panel panel-default">
								<div class="panel-heading">更多资料</div>
								<div class="panel-body">
									<div class="form-group met-form-choice met-upfile">
										<div class="row">
											<div class="met-form-file-title col-md-3"></div>
											<div class="col-md-9">
												<input
													data-url="https://show.metinfo.cn/muban/M1156014/381/app/system/entrance.php?c=uploadify&m=include&lang=cn&a=dohead"
													type="file" name="head"
													value="https://show.metinfo.cn/muban/M1156014/381/upload/head/12.png?1509528657049">
											</div>
										</div>
									</div>



									<div class="form-group met-form-choice">
										<div class="row">
											<div class="met-form-file-title col-md-3">昵称</div>
											<div class="col-md-9">
												<input type="text" required name="nc" class="form-control"
													value="" data-bv-notempty="true" data-bv-notempty-message="此项不能为空" placeholder="请输入昵称">
											</div>
										</div>
									</div>
									<div class="form-group met-form-choice">
										<div class="row">
											<div class="met-form-file-title col-md-3">所在地</div>
											<div class="col-md-9">
												<div class="col-md-4" style="padding-left:0px;">
													<select class="form-control" name="szdq" required  data-fv-notempty-message="此项不能为空" data-fv-field="szdq" data-checked=""><option value="">请选择所在地区</option><option value="北京市">北京市</option><option value="天津市">天津市</option><option value="河北省">河北省</option><option value="山西省">山西省</option><option value="内蒙古自治区">内蒙古自治区</option><option value="辽宁省">辽宁省</option><option value="吉林省">吉林省</option><option value="黑龙江省">黑龙江省</option><option value="上海市">上海市</option><option value="江苏省">江苏省</option><option value="浙江省">浙江省</option><option value="安徽省">安徽省</option><option value="福建省">福建省</option><option value="江西省">江西省</option><option value="山东省">山东省</option><option value="河南省">河南省</option><option value="湖北省">湖北省</option><option value="湖南省">湖南省</option><option value="广东省">广东省</option><option value="广西壮族自治区">广西壮族自治区</option><option value="海南省">海南省</option><option value="重庆市">重庆市</option><option value="四川省">四川省</option><option value="贵州省">贵州省</option><option value="云南省">云南省</option><option value="西藏自治区">西藏自治区</option><option value="陕西省">陕西省</option><option value="甘肃省">甘肃省</option><option value="青海省">青海省</option><option value="宁夏回族自治区">宁夏回族自治区</option><option value="新疆维吾尔自治区">新疆维吾尔自治区</option><option value="香港特别行政区">香港特别行政区</option><option value="澳门特别行政区">澳门特别行政区</option><option value="台湾">台湾</option><option value="国外">国外</option></select>
												</div>
												<div class="col-md-4">
													<select class="form-control" name="szdq1" required  data-fv-notempty-message="此项不能为空" data-fv-field="szdq1" data-checked=""><option value="">请选择所在地区</option><option value="北京市">北京市</option><option value="天津市">天津市</option><option value="河北省">河北省</option><option value="山西省">山西省</option><option value="内蒙古自治区">内蒙古自治区</option><option value="辽宁省">辽宁省</option><option value="吉林省">吉林省</option><option value="黑龙江省">黑龙江省</option><option value="上海市">上海市</option><option value="江苏省">江苏省</option><option value="浙江省">浙江省</option><option value="安徽省">安徽省</option><option value="福建省">福建省</option><option value="江西省">江西省</option><option value="山东省">山东省</option><option value="河南省">河南省</option><option value="湖北省">湖北省</option><option value="湖南省">湖南省</option><option value="广东省">广东省</option><option value="广西壮族自治区">广西壮族自治区</option><option value="海南省">海南省</option><option value="重庆市">重庆市</option><option value="四川省">四川省</option><option value="贵州省">贵州省</option><option value="云南省">云南省</option><option value="西藏自治区">西藏自治区</option><option value="陕西省">陕西省</option><option value="甘肃省">甘肃省</option><option value="青海省">青海省</option><option value="宁夏回族自治区">宁夏回族自治区</option><option value="新疆维吾尔自治区">新疆维吾尔自治区</option><option value="香港特别行政区">香港特别行政区</option><option value="澳门特别行政区">澳门特别行政区</option><option value="台湾">台湾</option><option value="国外">国外</option></select>
												</div>
												<div class="col-md-4" style="padding-right:0px;">
													<select class="form-control" name="szdq2" required  data-fv-notempty-message="此项不能为空" data-fv-field="szdq2" data-checked=""><option value="">请选择所在地区</option><option value="北京市">北京市</option><option value="天津市">天津市</option><option value="河北省">河北省</option><option value="山西省">山西省</option><option value="内蒙古自治区">内蒙古自治区</option><option value="辽宁省">辽宁省</option><option value="吉林省">吉林省</option><option value="黑龙江省">黑龙江省</option><option value="上海市">上海市</option><option value="江苏省">江苏省</option><option value="浙江省">浙江省</option><option value="安徽省">安徽省</option><option value="福建省">福建省</option><option value="江西省">江西省</option><option value="山东省">山东省</option><option value="河南省">河南省</option><option value="湖北省">湖北省</option><option value="湖南省">湖南省</option><option value="广东省">广东省</option><option value="广西壮族自治区">广西壮族自治区</option><option value="海南省">海南省</option><option value="重庆市">重庆市</option><option value="四川省">四川省</option><option value="贵州省">贵州省</option><option value="云南省">云南省</option><option value="西藏自治区">西藏自治区</option><option value="陕西省">陕西省</option><option value="甘肃省">甘肃省</option><option value="青海省">青海省</option><option value="宁夏回族自治区">宁夏回族自治区</option><option value="新疆维吾尔自治区">新疆维吾尔自治区</option><option value="香港特别行政区">香港特别行政区</option><option value="澳门特别行政区">澳门特别行政区</option><option value="台湾">台湾</option><option value="国外">国外</option></select>
												</div>
												
											</div>
										</div>
									</div>
									<div class="form-group met-form-choice">
										<div class="row">
											<div class="met-form-file-title col-md-3">生日</div>
											<div class="col-md-9">
												<input type="date" name="csrq" class="form-control"
													value="" placeholder="请输入生日" required data-bv-notempty="true" data-bv-notempty-message="此项不能为空" >
											</div>
										</div>
									</div>
									<div class="form-group met-form-choice">
										<div class="row">
											<div class="met-form-file-title col-md-3">QQ号</div>
											<div class="col-md-9">
												<input type="text" name="qq" class="form-control"
													value="" placeholder="请输入QQ号" required data-bv-notempty="true" data-bv-notempty-message="此项不能为空" >
											</div>
										</div>
									</div>









									<div class="form-group met-form-choice">
										<div class="row">
											<div class="met-form-file-title col-md-3">微信号</div>
											<div class="col-md-9">
												<input type="text" name="wxh" class="form-control"
													value="" placeholder="请输入微信号">
											</div>
										</div>
									</div>
									<div class="row" style="border-bottom: none;">
										<div class="col-xs-3"></div>
										<div class="col-xs-9">
											<button class="btn btn-primary" type="submit">保存资料</button>
										</div>
									</div>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "yhjbxx";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer.jsp"%>

	</footer>
</body>
</html>