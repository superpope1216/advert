<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html class="  ">
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/rwgl/rwxxDetail.css'>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/card.css'>
</head>
<body>
	<!--[if lte IE 8]>
<div class="text-center padding-top-50 padding-bottom-50 bg-blue-grey-100">
  <p class="browserupgrade font-size-18">
	你正在使用一个<strong>过时</strong>的浏览器。请<a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
  </p>
</div>
<![endif]-->
	<header>
		<%@include file="/jsp/header.jsp"%>
	</header>
	<div class="met-position  pattern-show">
		<div class="container">
			<div class="row">
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/center/index"
						title="众包大厅"> <i class="icon wb-home" aria-hidden="true"></i>众包大厅
					</a></li>
					<li class="dropdown"><a href="../product/" title="全部产品栏目"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false">开发专区<i class="caret"></i></a>
						<ul class="dropdown-menu ">

							<li><a href="../product/product.php?lang=cn&amp;class2=119"
								title="开发专区">开发专区</a></li>

							<li><a href="../product/product.php?lang=cn&amp;class2=120"
								title="实施专区">实施专区</a></li>
						</ul></li>

					<li><a href="javascript:void(0);" title="人事">人事</a></li>
				</ol>
			</div>
		</div>
	</div>
	<section class="met-shownews animsition">
		<div class="container">
			<div class="col-md-9 met-shownews-body">
				<div class="row">
					<div class="met-shownews-header">
						<div class="col-md-12 info "
							style="padding-bottom: 5px; border-bottom: 0px;">
							<div class="col-md-8 color-333">
								<h1>
									<span>${rwjbxx.rwmc}</span> <span class="label label-success"
										style="font-size: 13px; vertical-align: middle; color: #fff">${rwjbxx.xmztDisplay}</span>
								</h1>

								<div class="col-md-12 info2">
									<span>需求编号:${rwjbxx.rwbh}</span><span>交付日期:${rwjbxx.jfrq}</span><span>需求性质:${rwjbxx.rwxsDisplay}</span>
									<span>需求类型:${rwjbxx.rwlxDisplay} </span> <span>需求级别: <c:choose>
											<c:when test="${empty rwjbxx.rwnyd}">
												易
											</c:when>
											<c:otherwise>
												${rwjbxx.rwnydDisplay}
											</c:otherwise>
										</c:choose>
									</span> <span>定制级别: <c:choose>
											<c:when test="${empty rwjbxx.dzjb}">
												暂无
											</c:when>
											<c:otherwise>
												${rwjbxx.dzjbDisplay}
											</c:otherwise>
										</c:choose>
									</span>
								</div>
								<div>

									<p>
										<span id="price" class="red-600" title="123123"
											style="font-size: 32px"> <c:choose>
												<c:when
													test="${(empty rwjbxx.ptbzje) || (rwjbxx.ptbzje=='0')} ">
													<c:choose>
														<c:when
															test="${(not empty rwjbxx.zbje) and rwjbxx.zbje!='0'}">
															${rwjbxx.zbje}
														</c:when>
														<c:otherwise>
															${rwjbxx.xmysje}
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when
															test="${(not empty rwjbxx.zbje) and rwjbxx.zbje!='0'}">
															${rwjbxx.zbje+rwjbxx.ptbzje}
														</c:when>
														<c:otherwise>
															${rwjbxx.xmysje+rwjbxx.ptbzje}
														</c:otherwise>
													</c:choose>

												</c:otherwise>
											</c:choose> 元
										</span>
										<c:choose>
											<c:when
												test="${(empty rwjbxx.ptbzje) or (rwjbxx.ptbzje=='0')}">
											</c:when>
											<c:otherwise>
												<del>￥${rwjbxx.xmysje}元</del>
											</c:otherwise>
										</c:choose>
										<a> </a>
									</p>
								</div>
							</div>
							<div class="col-md-4"
								style="text-align: right; vertical-align: middle;">
								<p>
									招标截至日期:
									<fmt:formatDate value="${rwjbxx.zbjzrq}" pattern="yyyy-MM-dd" />
								</p>
								<p>已有${rwtbxxCount}人投标</p>
								<c:choose>
									<c:when test="${rwjbxx.xmzt eq '1'}">

									</c:when>
								</c:choose>

								<c:choose>
									<c:when test="${hasTb==true}">
										<a href="javascript:void(0);"
											class="btn btn-lg btn-squared btn-default margin-right-20 product-tocart">
											<i class="fa fa-cart-plus"></i>已投标
										</a>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${rwjbxx.xmzt eq '3'}">
												<a href="javascript:void(0);" id="btnOpenTb"
													class="btn btn-lg btn-squared btn-primary margin-right-20 product-tocart">
													<i class="fa fa-cart-plus"></i> 我要投标
												</a>
											</c:when>
											<c:when test="${(rwjbxx.xmzt eq '16')}">
												<a href="javascript:void(0);"
													class="btn btn-lg btn-squared btn-default margin-right-20 product-tocart">
													<i class="fa fa-cart-plus"></i> 已关闭
												</a>
											</c:when>
											<c:when test="${(rwjbxx.xmzt eq '14')}">
												<a href="javascript:void(0);"
													class="btn btn-lg btn-squared btn-default margin-right-20 product-tocart">
													<i class="fa fa-cart-plus"></i> 已结束
												</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0);"
													class="btn btn-lg btn-squared btn-default margin-right-20 product-tocart">
													<i class="fa fa-cart-plus"></i> 进行中
												</a>
											</c:otherwise>
										</c:choose>
									</c:otherwise>

								</c:choose>
							</div>
						</div>

						<div style="clear: both;"></div>
					</div>
					<div class="met-editor lazyload clearfix">
						<div class="editorlightgallery">
							<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
								<li class="nav-item "><a class="nav-link active"
									data-toggle="tab" href="" data-state="all">详情信息</a></li>

							</ul>
							<div style="padding-top: 20px;">
								<table style="width: 100%;">
									<tr>
										<td
											style="width: 80px; text-align: right; padding-right: 10px;">项目编号:</td>
										<td>UK-12345</td>
									</tr>
									<tr>
										<td
											style="width: 80px; text-align: right; padding-right: 10px;">所属学校:</td>
										<td>南京大学</td>
									</tr>
									<tr>
										<td
											style="width: 80px; text-align: right; padding-right: 10px;">业务线:</td>
										<td>${rwjbxx.ywxlbDisplay}</td>
									</tr>
									<tr>
										<td
											style="width: 80px; text-align: right; padding-right: 10px;">模块:</td>
										<td>年度考核</td>
									</tr>
									<tr>
										<td
											style="width: 80px; text-align: right; padding-right: 10px;"
											valign="top">需求描述:</td>
										<td>
											<p>${rwjbxx.xmgs}</p>
										</td>
									</tr>
								</table>
							</div>
							<c:if
								test="${isXqf==true and (not empty xqfId) and (xqfId eq rwjbxx.xqfid)}">
								<ul class="nav nav-tabs nav-tabs-line m-b-0 shop-order-state">
									<li class="nav-item "><a class="nav-link active"
										data-toggle="tab" href="" data-state="all">投标信息(${rwtbxxCount}人)</a></li>
								</ul>
								<div class="host-list active">
									<ul class="offers-section blocks-2 blocks-sm-3 blocks-md-4 blocks-xlg-5  met-page-ajax met-grid" id="ulTbzxx" data-scale="1">
										<c:if test="${not empty rwtbxx}">
											<c:forEach items="${rwtbxx}" var="data">
													<li class=" shown offer wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
    													<a href="<%=request.getContextPath() %>/kfzview/index?kfzid=${data.kfzid}" title="${(not empty data.kfzNc)?data.kfzNc:data.kfzXm}" target="_blank" style="padding: 2px; background: #fff;">
    														<article class="inner-box" style="border: 1px solid #f5f5f5;">
    															<figure class="image" style="margin-bottom:0px;">
    																<img src="<%=request.getContextPath() %>/statics/images/12.png" title="${(not empty data.kfzNc)?data.kfzNc:data.kfzXm}" alt="${(not empty data.kfzNc)?data.kfzNc:data.kfzXm}">
    																<div class="overlay-box">
    																	<div class="date">${(not empty data.kfzNc)?data.kfzNc:data.kfzXm}</div>
    				    											</div>
    							    							</figure>
    				              								 <div class="text">
    																<div class="desc">
    																	<p style="overflow: auto;">
    																		<span style="text-align: left; float: left; display: inline-block;">${(not empty data.kfzNc)?data.kfzNc:data.kfzXm}</span>
    																		<span style="text-align: center; float: right; display: inline-block; width: 40px; background-color: #ddd; border: none; font-size: 12px; border-radius: 3px; cursor: pointer; display: inline-block; background-color: #65C279; color: #FFF;">${data.zbztDisplay}</span>
    								       								</p>
    								        							<p>
    																		<b style="text-align: center;  display: inline-block;" class="price">￥${data.tbje}元</b>
    								        							</p>
    																</div>
    																<c:if test="${rwjbxx.xmzt eq '3' }">
	    																<div class="link text-center">
	    																	<a href="javascript:void(0);" data-option="selectTA" data-key="${data.wid}" title="选中TA" target="_self" class="theme-btn btn-skew style-two btn-sm">选中TA</a>
	    					                							</div>
    					                							</c:if>
    				                							</div>
    													   </article>
    													</a>
    											</li>
											</c:forEach>
										</c:if>

									</ul>
								</div>

							</c:if>


						</div>
					</div>
					<!-- <div class="met-shownews-footer">

						<ul class="pager pager-round">
							<li class="previous "><a
								href="shownews.php?lang=cn&amp;id=49"
								title="DONGTIAN品牌首次亮相连卡佛 新品彩妆闪耀上市"> 上一篇 <span
									aria-hidden="true" class="hidden-xs">：DONGTIAN品牌首次亮相连卡佛
										新品彩妆闪耀上市</span>
							</a></li>
							<li class="next "><a href="shownews.php?lang=cn&amp;id=53"
								title="本色肌肤 晶采生活 urara悠莱晶采双瓶全新上市"> 下一篇 <span
									aria-hidden="true" class="hidden-xs">：本色肌肤 晶采生活
										urara悠莱晶采双瓶全新上市</span>
							</a></li>
						</ul>
					</div>
					 -->
				</div>
			</div>
			<div class="col-md-3">
				<div class="row">

					<div class="met-news-bar">
						<div class="card m-b-0" style="text-align: center;">
							<div
								class="card-header  text-xs-center p-30 p-b-15 xqf_header_bg"
								style="text-align: center;">
								<a class="avatar avatar-100 img-bordered m-b-10 bg-white"
									target="_blank" href="javascript:void(0);" title="mycluster">
									<img
									src="<%=request.getContextPath()%>/statics/images/12.png?1509528657049"
									alt="mycluster">
								</a>
								<div class="font-size-20 ">
									<c:choose>
										<c:when test="${empty xqfxx.nc}">
										${xqfxx.xm}
									</c:when>
										<c:otherwise>
										${xqfxx.nc}
									</c:otherwise>
									</c:choose>
								</div>
								<div class="grey-600 font-size-14">企业开发者</div>
								<div class="grey-600 font-size-14">信誉分：${score}分</div>
							</div>
						</div>


						<div class="recommend news-list-md">
							<h3>为您推荐</h3>
							<ul class="list-group list-group-bordered">

								<li class="list-group-item"><a
									href="../news/shownews.php?lang=cn&amp;id=52"
									title="西安首家泊美Shopping Mall新鲜开业" target="_self">西安首家泊美Shopping
										Mall新鲜开业</a></li>

								<li class="list-group-item"><a
									href="../news/shownews.php?lang=cn&amp;id=53"
									title="本色肌肤 晶采生活 urara悠莱晶采双瓶全新上市" target="_self">本色肌肤 晶采生活
										urara悠莱晶采双瓶全新上市</a></li>

								<li class="list-group-item"><a
									href="../news/shownews.php?lang=cn&amp;id=54"
									title="玫瑰香氛梳MINI 让颜值和自由齐飞" target="_self">玫瑰香氛梳MINI
										让颜值和自由齐飞</a></li>

								<li class="list-group-item"><a
									href="../news/shownews.php?lang=cn&amp;id=55"
									title="每一个放大镜下的女明星都想证明：谁脸小谁骄傲" target="_self">每一个放大镜下的女明星都想证明：谁脸小谁骄傲</a></li>

								<li class="list-group-item"><a
									href="../news/shownews.php?lang=cn&amp;id=49"
									title="DONGTIAN品牌首次亮相连卡佛 新品彩妆闪耀上市" target="_self">DONGTIAN品牌首次亮相连卡佛
										新品彩妆闪耀上市</a></li>

							</ul>
						</div>

						<ul class="column">
							<li><a href="../news/" title="所有文章" target="_self">所有文章</a></li>

							<li><a href="../news/news.php?lang=cn&amp;class2=4"
								title="公司动态">公司动态</a></li>

							<li><a href="../news/news.php?lang=cn&amp;class2=5"
								class="active" title="业界资讯">业界资讯</a></li>

						</ul>

					</div>

				</div>
			</div>
		</div>
	</section>


	<%@ include file="/jsp/footer/footer.jsp"%>
	<button type="button"
		class="btn btn-icon btn-primary btn-squared met-scroll-top hide">
		<i class="icon wb-chevron-up" aria-hidden="true"></i>
	</button>
	<div class="modal fade modal-primary in" id="moadl_tbxx"
		aria-labelledby="moadl_tbxx" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-center">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">我要投标</h4>
				</div>
				<div class="modal-body">
					<form id="formRbxxgl" class="form-horizontal" role="form">
						<input type="hidden" name="wid" value=""> <input
							type="hidden" name="rwid" value="${rwjbxx.wid}">
						<div class="well well-sm" style="padding: 10px;">如果可以提供更具竞争力的价格，可增加中标机率；如果是遵循发包预算价，则此项可不填;投标价格只能在预算价格上下范围${fdxt}%以内</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">您的报价：</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" name="tbje"
									value="${rwjbxx.xmysje}" placeholder="投标价格只能在预算价格上下范围30%以内"
									required data-fv-notempty-message="此项不能为空"
									pattern="^\+?[1-9]\d*$" data-fv-regexp-message="请输入正确的正整数类型数字"
									data-fv-stringlength="true" data-fv-stringlength-min="1"
									data-fv-stringlength-max="6">
							</div>
							
							<div class="col-sm-8">
							
								<p class="form-control-static">
								<c:if test="${(not empty rwjbxx.ptbzje) && (rwjbxx.ptbzje != '0')}">
									<span>+平台补助:<span name="spanPtbzje">${rwjbxx.ptbzje}</span>-平台费用<span></span>=我的收入
									</span><span class="red-600 control-label" style="font-size: 32px;" name="spanAllje">${rwjbxx.xmysje+rwjbxx.ptbzje}</span>元
									</c:if>
								</p>
								
							
							</div>
						</div>
						<div class=" form-group">
							<label class="col-sm-2 control-label">您的优势：</label>
							<div class="col-sm-10">
								<textarea rows="3" class="form-control" name="tbcs"></textarea>
							</div>
						</div>
					</form>
				</div>

				<div class="modal-footer text-xs-left">
					<button type="button" class="btn btn-primary btn-squared"
						id="btnSaveTbxx">保存</button>
					<button type="button" class="btn btn-default btn-squared"
						data-dismiss="modal">取消</button>
				</div>


			</div>
		</div>
	</div>
	<script>
		var jsonurl = "";
		var rwid = "${rwid}";
	</script>

	<%@ include file="/jsp/bottom.jsp"%>


	<script
		src="<%=request.getContextPath()%>/statics/pagejs/center/rwxxDetail.js"></script>
</body>
</html>
