<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=DP8U5R94XzDnlI2cu5rwqmrMKbfToxx1"></script>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/yhgl/login.css'>
<style>
.met-member {
	background-color:;
}

.login_index {
	background-color:;
}

.pearl-icon {
	font-size: 14px;
}

.pearl-icon, .pearl-number {
	width: 28px;
	height: 28px;
}

.pearl-title {
	font-size: 14px;
}

.pearl.current .pearl-icon, .pearl.current .pearl-number {
	transform: scale(1);
}
#divSelect

 

.btn-primary


.focus
,
#divSelect

 

.btn-primary


:focus
,
#divSelect

 

.btn-primary


:hover


	

background-color


:


#89bceb


;
border-color


:


#89bceb


;
}
</style>
<body>
	<%@include file="/jsp/header_not_login.jsp"%>
	<div class="container" style="margin-top: 50px;">
		<div class="pearls blocks-4">
		    
			<li class="pearl m-b-0 current" id="liStep1">
				<div class="pearl-icon">
					<i class="fa fa-edit" aria-hidden="true"></i>
				</div> <span class="pearl-title">填写信息验证手机</span>
			</li>
			
			<li class="pearl m-b-0 disabled" id="liStep2">
				<div class="pearl-icon">
					<i class="fa fa-user-o" aria-hidden="true"></i>
				</div> <span class="pearl-title">注册成功选择身份 </span>
			</li>
			<li class="pearl m-b-0 disabled" id="liStep3">
				<div class="pearl-icon">
					<i class="fa fa-vcard-o" aria-hidden="true"></i>
				</div> <span class="pearl-title">完善企业和个人资料</span>
			</li>
			<li class="pearl m-b-0 disabled" id="liStep4">
				<div class="pearl-icon">
					<i class="fa fa-check" aria-hidden="true"></i>
				</div> <span class="pearl-title">注册成功发布信息</span>
			</li>
		</div>
	</div>
	<div class="register_index met-member" style="background: #FFF;">
		<div class="container" id="divStep1" style="display: none;">
			<form class="form-register met-form" method="post" action=""
				id="formRegister">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"></i></span>
						<input type="text" name="yhm" required class="form-control"
							placeholder="登录用户名" data-bv-remote="false"
							data-bv-notempty="true" data-bv-notempty-message="此项不能为空"
							data-bv-stringlength="true" data-bv-stringlength-min="4"
							data-bv-stringlength-max="30"
							data-bv-stringlength-message="用户名必须在4-30个字符之间的数字或者字符" />

					</div>
				</div>



				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"></i></span>
						<input type="password" name="mm" required class="form-control"
							placeholder="密码" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空" data-bv-identical="true"
							data-bv-identical-field="confirmYhmm"
							data-bv-identical-message="两次密码输入不一致" data-bv-stringlength="true"
							data-bv-stringlength-min="6" data-bv-stringlength-max="30"
							data-bv-stringlength-message="密码必须在6-30个字符之间">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"></i></span>
						<input type="password" name="confirmYhmm" required
							data-password="password" class="form-control" placeholder="重复密码"
							data-bv-identical="true" data-bv-identical-field="mm"
							data-bv-identical-message="两次密码输入不一致"
							data-bv-notempty-message="此项不能为空">

					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-mobile-phone"></i></span> <input type="text" name="sjh"
							required class="form-control" placeholder="手机号"
							data-bv-remote="false" data-bv-remote-url=""
							data-bv-remote-message="手机号已存在" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空" data-bv-stringlength="true"
							data-bv-stringlength-max="20" data-bv-stringlength-message="" />

					</div>
				</div>

				<div class="row login_code">
					<div class="col-xs-8">
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-shield"></i></span>
								<input type="text" value="" name="yzm" required
									class="form-control" placeholder="验证码" data-bv-notempty="true"
									data-bv-notempty-message="此项不能为空">
							</div>
						</div>
					</div>
					<div class="col-xs-4 login_code_img">

						<input type="button" value="点击获取验证码" name="code"
							class="form-control" id="btnGetVerification">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
						<input type="text" name="email" required class="form-control"
							placeholder="电子邮箱" data-bv-remote="false" data-bv-remote-url=""
							data-bv-remote-message="电子邮箱已存在" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空" data-bv-stringlength="true"
							data-bv-stringlength-max="40" />

					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					id="btnRegister">立即注册</button>
				<div class="login_link">
					<a href="<%=request.getContextPath()%>/login/index">已有账号？</a>
				</div>
			</form>
		</div>
		<div class="container" id="divStep2" style="display: none;">
			<div class="row" id="divSelect">
				<div class="col-xs-12 text-center"
					style="color: #AE1F23; font-size: 18px;">
					恭喜您，注册成功，为了更好的为您服务，请选择来本站的目的</div>
				<div class="col-xs-6">
					<button type="button" class="btn btn-primary btn-lg btn-block"
						id="btnSupply">我要卖广告</button>
				</div>
				<div class="col-xs-6">
					<button type="button" class="btn btn-default btn-lg btn-block"
						id="btnBuy">我要买广告</button>
				</div>

			</div>
			<div class="row" style="margin-top: 30px;" id="divSupplygg">
				<div class="col-xs-12 text-center"
					style="color: #004EA0; font-size: 18px;">
					好资源也怕巷子深，让有需求的客户发现你，最具影响力媒体价值营销平台</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q06.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">得客户</div>
					<div class="col-xs-12 text-center" style="color: #999;">包装展示资源价值</div>
					<div class="col-xs-12 text-center" style="color: #999;">让有需求的客户主动找上门</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q07.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">立品牌</div>
					<div class="col-xs-12 text-center" style="color: #999;">我们给广告主传播品牌</div>
					<div class="col-xs-12 text-center" style="color: #999;">广告主选我们也以品牌来选</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q08.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">展实力</div>
					<div class="col-xs-12 text-center" style="color: #999;">展示公司实力、服务实力</div>
					<div class="col-xs-12 text-center" style="color: #999;">资源实力的宣传阵地</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q09.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">传口碑</div>
					<div class="col-xs-12 text-center" style="color: #999;">把服务的客户传递给潜在需求客户</div>
					<div class="col-xs-12 text-center" style="color: #999;">传递服务口碑</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q10.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">立通路</div>
					<div class="col-xs-12 text-center" style="color: #999;">建立与潜在需求客户的信息通路</div>
					<div class="col-xs-12 text-center" style="color: #999;">展示最新政策和资源</div>
				</div>
				<form class="form-register met-form" method="post" action="">
					<button class="btn btn-lg btn-primary btn-block" type="button"
						id="btnKtSupply">马上开通商铺</button>
					<div class="login_link">
						<a href="<%=request.getContextPath()%>/login/index">跳转进入首页</a>
					</div>
				</form>
			</div>

			<div class="row" style="margin-top: 30px; display: none;"
				id="divBuygg">
				<div class="col-xs-12 text-center"
					style="color: #004EA0; font-size: 18px;">
					全面、系统、客观、专业的一站式广告资源采购平台</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q01.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">省钱</div>
					<div class="col-xs-12 text-center" style="color: #999;">价格不再被业务员忽悠</div>
					<div class="col-xs-12 text-center" style="color: #999;">明码标价，多家比较</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q02.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">省力</div>
					<div class="col-xs-12 text-center" style="color: #999;">投广告不用东奔西走</div>
					<div class="col-xs-12 text-center" style="color: #999;">求朋靠友，广告资源一网打尽</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q03.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">放心</div>
					<div class="col-xs-12 text-center" style="color: #999;">再不用担心被业务员忽悠</div>
					<div class="col-xs-12 text-center" style="color: #999;">多方比较，去伪存真</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q04.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">一站式</div>
					<div class="col-xs-12 text-center" style="color: #999;">全媒体广告资源展示平台</div>
					<div class="col-xs-12 text-center" style="color: #999;">一站式购齐，资讯和智库支持</div>
				</div>
				<div style="width: 18%; display: inline-block;">
					<div class="col-xs-12 text-center">
						<img
							src="<%=request.getContextPath()%>/statics/images/advert/reg16_q05.gif"
							width="70" height="70">
					</div>
					<div class="col-xs-12 text-center"
						style="color: #666; font-size: 16px;">招标</div>
					<div class="col-xs-12 text-center" style="color: #999;">可发起网络招标</div>
					<div class="col-xs-12 text-center" style="color: #999;">让有资源的一手公司竞标，省钱又省力</div>
				</div>
				<form class="form-register met-form" method="post" action="">
					<button class="btn btn-lg btn-primary btn-block" type="button"
						id="btnKtBuy">马上完善企业信息</button>
					<div class="login_link">
						<a href="<%=request.getContextPath()%>/login/index">跳转进入首页</a>
					</div>
				</form>
			</div>
		</div>
		<div class="container" id="divStep3" style="display: none;">
			<form class="form-register met-form form-horizontal" method="post"
				action="" role="form" id="formCompany">
				<input type="hidden" name="flag" value="1" />
				<input type="hidden" name="sfybz" value="0"/>
				<input type="hidden" name="lng" value=""/>
				<input type="hidden" name="lat" value=""/>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">公司名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name"
							placeholder="填写营业执照上的公司全称，真实齐全的公司名称增" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">公司地区</label>
					<div class="col-sm-10">
						<div class="col-sm-4" style="padding-left:0px;">
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
						<div class="col-sm-4" style="padding-right:0px;">
							<select class="form-control " name="xian">
								<option value="">--请选择--</option>

							</select>
						</div>

					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">经营地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="addr"
							placeholder="请填写实际的经营地址" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">标注</label>
					<div class="col-sm-10">
						<button type="button" id="btnBz" class="btn btn-default" style="color:red;"><i class="fa fa-close fa-lg"></i>未标注</button>
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">联系人</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="lxr"
							placeholder="建议填写真实姓名，赢取信任和机会" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">固定电话</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="gddh"
							placeholder="非常重要，真实无误电话增加咨询量" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">QQ号码</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="qq"
							placeholder="随时随地在线沟通，不错过任何商机" data-bv-notempty="true"
							data-bv-notempty-message="此项不能为空">
					</div>
				</div>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">网站地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="wzdz"
							placeholder="真实可访问，便于潜在客户获取信息">
					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					id="btnSaveCompany">提交并开通广告商铺</button>
			</form>
		</div>
		<div class="container" id="divStep4" style="display: none;">
			<div class="row">
				<div class="col-xs-12 text-center">
					<img alt=""
						src="<%=request.getContextPath()%>/statics/images/advert/reg16_c01.gif">
				</div>
				<div class="col-xs-12 text-center"
					style="color: #AE1F23; font-size: 22px;">恭喜您资料完善成功！</div>
			</div>
		</div>
	</div>
	<div class="modal fade modal-primary in" id="bzModal"
		aria-labelledby="bzModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">标注信息</h4>
				</div>
				<div class="modal-body">
						<div id="allmap" style="height:300px;width:100%;"></div>
				</div>
				<div class="modal-footer text-xs-left">
					<button type="button" class="btn btn-default btn-squared"
						data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<footer class="container met-footer">
		<script type="text/javascript">
			var page_type = "register";
			var flag="${flag}";
		</script>
		<%@ include file="/jsp/bottom.jsp"%>
		<%@ include file="/jsp/footer/footer_bq.jsp"%>

	</footer>
</body>
</html>