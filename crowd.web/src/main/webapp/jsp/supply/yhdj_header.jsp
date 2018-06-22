<%@page import="com.pope.advert.common.code.ShztEnum"%>
<%@page import="com.pope.advert.entity.yhgl.extend.CompanyInfoExtend"%>
<%@page import="com.pope.advert.entity.cwgl.extend.CwglDjxxInfoExtend"%>
<%@page import="com.pope.advert.service.cwgl.CwglDjxxInfoService"%>
<%@page import="java.util.List"%>
<%@page import="com.wisedu.crowd.common.util.CommonUtil"%>
<%@page import="com.wisedu.crowd.common.util.ConditionUtil"%>
<%@page import="com.pope.advert.service.yhgl.YhglDjxxInfoServie"%>
<%@page import="com.pope.advert.entity.yhgl.extend.YhglDjxxInfoExtend"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.pope.advert.entity.yhgl.extend.RegisterInfoExtend"%>
<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dj = "", djName = "基本用户", ggksrq = "", ggjzrq = "";
	Integer ggts = 0;
	String supplyShzt = "", supplyShMsg = "";
	WebApplicationContext wacDj = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
	
	YhglDjxxInfoServie yhglDjxxInfoServie = (YhglDjxxInfoServie) wacDj.getBean("yhglDjxxInfoServie");//如是注解的Service取注解
	YhglDjxxInfoExtend queryYhglDjxxInfoExtend = new YhglDjxxInfoExtend();
	queryYhglDjxxInfoExtend.setYhid(yhjbxxInfoExtend.getWid());
	
	List<YhglDjxxInfoExtend> djxxDatas = yhglDjxxInfoServie.selectByCondition(ConditionUtil.createCondition(queryYhglDjxxInfoExtend), null).getDatas();
	
	if(CommonUtil.isNotEmptyList(djxxDatas)){
		if (!StringUtil.isEmpty(djxxDatas.get(0).getDj())) {
			CwglDjxxInfoService cwglDjxxInfoService = (CwglDjxxInfoService) wacDj.getBean("cwglDjxxInfoService");//如是注解的Service取注解
			CwglDjxxInfoExtend queryCwglDjxxInfoExtend = new CwglDjxxInfoExtend();
			queryCwglDjxxInfoExtend.setWid(djxxDatas.get(0).getDj());
			List<CwglDjxxInfoExtend> cwglDatas = cwglDjxxInfoService
					.selectByCondition(ConditionUtil.createCondition(queryCwglDjxxInfoExtend), null).getDatas();
			if(CommonUtil.isNotEmptyList(cwglDatas)){
				djName = StringUtil.toStr(cwglDatas.get(0).getName(),djName);
			}
			
		}
		ggjzrq =  djxxDatas.get(0).getJssj();
		ggksrq = djxxDatas.get(0).getKssj();
		ggts = StringUtil.toInt(djxxDatas.get(0).getSyts(), 0);
	}

	
	String pageType = StringUtil.toStr(request.getAttribute("pageType"));
	System.out.println("=======pageType===="+pageType);
	Object companyObject = session.getAttribute(ConstantsUtil.SESSION_COMPANY);
	CompanyInfoExtend companyInfoExtend = null;
	if (companyObject != null) {
		companyInfoExtend = (CompanyInfoExtend) companyObject;
		supplyShzt = companyInfoExtend.getSupplyShzt();
		if (ShztEnum.DSH.getCode().equals(companyInfoExtend.getSupplyShzt())) {
			supplyShMsg = "您的广告售卖方身份正在审核中，请稍后！";
		} else if (ShztEnum.WTG.getCode().equals(companyInfoExtend.getSupplyShzt())) {
			supplyShMsg = "抱歉！您的广告售卖方身份申请不通过！";
		} else if (ShztEnum.YTG.getCode().equals(companyInfoExtend.getSupplyShzt())) {
			supplyShMsg = "恭喜您！您的广告售卖方身份已审核通过！";
		}
	}
%>
<div class="panel" style="margin-bottom: 5px;">
	<div class="panel-body">
		<h3 style="font-size: 18px;">
			<%=djName%>
			<%
				if (!"1".equals(pageType)) {
			%>
			<button type="button" id="btnYhxxDj" class="btn btn-danger">
				<i class="fa fa-edit my-text-color" aria-hidden="true"
					style="margin-right: 10px;"></i>升级会员
			</button>
			<%
				}
			%>
			<a href="javascript:void(0)" id="btnHydjsm"
				style="color: blue; font-size: 14px">会员等级说明</a>
		</h3>
		<span style="font-size: 14px; font-weight: normal; color: red;">
			<%
				if (ShztEnum.YTG.getCode().equals(supplyShzt)) {
			%> 根据您的会员级别，您还可以发布 <%=ggts%> 条资源信息,有效期为 <%=ggksrq%>至<%=ggjzrq%>
			<%
				} else {
			%> <%=supplyShMsg%> <%
 	}
 %>

		</span>
	</div>
</div>

<div class="modal fade" id="modalHydjsmTable">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">会员等级说明</h4>
			</div>
			<div class="modal-body">
				<table class="table table-hover mytable2">
					<thead>
						<tr>
							<th>序号</th>
							<th>会员级别</th>
							<th>年费标准（元）</th>
							<th>广告资源限制数量</th>
							<th>优先级别</th>
							<th>备注说明</th>
						</tr>
					</thead>
					<tbody id="tblHydjSmData">

					</tbody>
				</table>
				<div>
					说明：
					<p>1,不同用户级别，发布广告资源的数量不同，优先级别不同。 优先级别高的（数字大的），广告资源前台显示时排序在前面。</p>
					<p>2,优先级别高的（数字大的），广告资源前台显示时排序在前面。。</p>
				</div>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default " data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#btnYhxxDj").click(function() {
			window.location.href = basePath + "/cwgl/czjl/index";
		});

		$("#btnHydjsm").click(function() {
			$("#modalHydjsmTable").modal("show");
			doGet(basePath + "/cwgl/djsm/list", "", function(data) {
				var html = "";
				if (data && data.datas) {
					for (var i = 0; i < data.datas.length; i++) {
						var _data = data.datas[i];
						html += '<tr>';
						html += '<td>';
						html += (i + 1);
						html += '</td>';
						html += '<td>';
						html += toStr(_data.name)
						html += '</td>';
						html += '<td>';
						html += toStr(_data.fy)
						html += '</td>';
						html += '<td>';
						var sm = _data.ggzyxzsl;
						if (sm == null || sm == undefined) {
							sm = "无限制";
						}

						html += sm;
						html += '</td>';
						html += '<td>';
						html += toStr(_data.yxjb)
						html += '</td>';
						html += '<td>';
						html += toStr(_data.bz)
						html += '</td>';
						html += '</tr>';
					}
				}
				$("#tblHydjSmData").html(html);
			});
		});
	});
</script>