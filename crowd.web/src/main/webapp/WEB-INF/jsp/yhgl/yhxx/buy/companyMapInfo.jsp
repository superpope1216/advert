<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=DP8U5R94XzDnlI2cu5rwqmrMKbfToxx1"></script>
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

.bi-icon-container {
	width: 97px;
	height: 97px;
	background-color: #F3F3F3;
	border: solid 1px #ddd;
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
										style="margin-right: 10px;"></i>公司地址地图标注
								</h3>
							</div>
							<div class="row my-mt-10">
								<div class="well well-sm my-padding-12">公司地图标注数据在广告买卖网有很多应用及调用，准确、翔实、有效的地址数据，增加广告买家的信赖。并在很多地方得到推广和调用，因此请根据公司真实的经营地址准确标注。
									请在您公司位置上点右键，选“标注”</div>
								<div class="col-xs-12">
									<div class="col-xs-2">公司所在地</div>
									<div class="col-xs-2">
										<select id="selArea" class="form-control">
											<option value="">--请选择--</option>
											<c:forEach items="${areaSelect}" var="data">
												<option value="${data.lbdm}">${data.lbmc}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-xs-2">
										<select id="selCity" class="form-control">
											<option value="">--请选择--</option>
											<c:if test="${not empty citySelect}">
											<c:forEach items="${citySelect}" var="data">
												<option value="${data.lbdm}">${data.lbmc}</option>
											</c:forEach>
											</c:if>
										</select>
									</div>
									<div class="col-xs-2">
										<select id="selXian" class="form-control">
											<option value="">--请选择--</option>
											<c:if test="${not empty xianSelect}">
											<c:forEach items="${xianSelect}" var="data">
												<option value="${data.lbdm}">${data.lbmc}</option>
											</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="map_01">
									<div class="map_01_1">
										<a href="javascript:;">标注/浏览</a>
									</div>
									<div class="map_01_3">
										<div class="dt_lf">
											<c:choose>
												<c:when test="${companyInfo.sfybz eq '1'}">
													<span id="spanYbz" style="color: green"><i
														class="fa fa-check"></i> 已标注</span>
													<span id="spanWbz" style="color: red; display: none;"><i
														class="fa fa-close"></i> 未标注</span>
												</c:when>
												<c:otherwise>
													<span id="spanYbz" style="color: green; display: none;"><i
														class="fa fa-check"></i> 已标注</span>
													<span id="spanWbz" style="color: red"><i
														class="fa fa-close"></i> 未标注</span>
												</c:otherwise>
											</c:choose>
										</div>

									</div>
								</div>
								<div class="map_07">
									<div class="map_07_01" id="allmap"></div>
								</div>
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
		var page_type = "companyMapInfo";
		var area="${area}";
		var areaDisplay="${areaDisplay}";
		var city="${city}";
		var cityDisplay="${cityDisplay}";
		var xian="${xian}";
		var xianDisplay="${xianDisplay}";
		var sfybz="${sfybz}";
		var lng="${lng}";
		var lat="${lat}";
	</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>