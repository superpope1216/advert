<%@page import="com.pope.advert.entity.dictionary.DictionaryInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.pope.advert.common.code.DictionaryEnum"%>
<%@page import="com.pope.advert.service.dictionary.DictionaryService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.panel-group {<!--
	max-height: 770px; -->
	overflow: hidden;
}

.leftMenu {
	margin: 10px;
	margin-top: 5px;
}

.panel-group .panel-title:after {
	content: "";
}

.panel-group .panel-title:before {
	content: "";
}

.leftMenu .panel-heading {
	font-size: 14px;
	padding-left: 20px;
	height: 36px;
	line-height: 36px;
	color: white;
	position: relative;
	cursor: pointer;
} /*转成手形图标*/
.leftMenu .panel-heading span {
	position: absolute;
	right: 10px;
	top: 12px;
}

.leftMenu .menu-item-left {
	padding: 2px;
	background: transparent;
	border: 1px solid transparent;
	border-radius: 6px;
}

.leftMenu .menu-item-left:hover {
	background: #C4E3F3;
	border: 1px solid #1E90FF;
}

.mypanel-collapse {
	overflow-x: hidden;
}
</style>
<%
	String menuFlag = request.getParameter("flag");

	boolean isXqf = false;
	WebApplicationContext wac1 = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
	DictionaryService dictionaryService = (DictionaryService) wac1.getBean("dictionaryService");
	List<DictionaryInfo> gglxList = dictionaryService.selectByCondtion(DictionaryEnum.T_ADVERT_SJZD_LX, null);
	request.setAttribute("gglxList", gglxList);
%>
<%!public String setActive(String _menuFlag, String flag) {

		if (flag.equals(_menuFlag)) {
			return " active ";
		}
		if (StringUtil.isEmpty(_menuFlag) && "kfzxx".equals(flag)) {
			return " active ";
		}
		return "";
	}%>
<div class="panel row m-b-0 m-r-15 hidden-md-down" boxmh-h>
	<div class="panel-body">
		<h2 class="m-l-30 font-size-18 font-weight-unset">广告购买中心</h2>
		<div class="panel-group table-responsive my-table-responsive"
			role="tablist">
			<div class="panel panel-primary leftMenu">
				<!-- 利用data-target指定要折叠的分组列表 -->
				<div class="panel-heading" id="collapseListGroupHeading1"
					data-toggle="collapse" data-target="#collapseListGroup1" role="tab">
					<h4 class="panel-title">
						企业信息 <span class="glyphicon glyphicon-chevron-up right"></span>
					</h4>
				</div>
				<!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
				<div id="collapseListGroup1"
					class="panel-collapse collapse in mypanel-collapse" role="tabpanel"
					aria-labelledby="collapseListGroupHeading1">
					<ul class="list-group" id="ulYhxx">
						<li class="list-group-item">
							<!-- 利用data-target指定URL -->
							<button class="menu-item-left" data-key="1">
								<!-- <span class="glyphicon glyphicon-triangle-right"></span> -->
								公司介绍
							</button>
						</li>
						
						<li class="list-group-item">
							<button class="menu-item-left" data-key="3">
								<!--<span class="glyphicon glyphicon-triangle-right"></span>-->
								公司位置地图标注
							</button>
						</li>
					</ul>
				</div>
			</div>
			<!--panel end-->
			<div class="panel panel-primary leftMenu">
				<div class="panel-heading" id="collapseListGroupHeading2"
					data-toggle="collapse" data-target="#collapseListGroup2" role="tab">
					<h4 class="panel-title">
						广告求购<span class="glyphicon glyphicon-chevron-down right"></span>
					</h4>
				</div>
				<div id="collapseListGroup2"
					class="panel-collapse collapse mypanel-collapse" role="tabpanel"
					aria-labelledby="collapseListGroupHeading2">
					<ul class="list-group" id="ulBuy">
						<li class="list-group-item">
									<button class="menu-item-left" data-key="1">
										求购信息管理
									</button>
								</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$(".panel-heading").click(function(e) {
			/*切换折叠指示图标*/
			$(this).find("span").toggleClass("glyphicon-chevron-down");
			$(this).find("span").toggleClass("glyphicon-chevron-up");
			$(".mypanel-collapse").removeClass("in");
		});
		
		$("#ulGgqg button").click(function(){
			var data_key=$(this).attr("data-key");
			window.location.href=basePath+"/supplyView/index?key="+data_key;
		})
		
		
		$("#ulBuy button").click(function(){
			var data_key=$(this).attr("data-key");
			if(data_key=="1"){
				window.location.href=basePath+"/buyQg/index";
			}else if(data_key=="2"){
				window.location.href=basePath+"/buyZb/index";
			}
		});
		$("#ulYhxx button").click(function(){
			var data_key=$(this).attr("data-key");
			if(data_key=="1"){
				window.location.href=basePath+"/companyInfo/index?flag=2";	
			}else if(data_key=="2"){
				window.location.href=basePath+"/companyZzInfo/index?flag=2";
			}else if(data_key=="3"){
				window.location.href=basePath+"/companyMapInfo/index?falg=2";
			}
			
		});
		
		$("#ulSjgl button").click(function(){
			var data_key=$(this).attr("data-key");
			if(data_key=="1"){
				window.location.href=basePath+"/dlglView/index";	
			}else if(data_key=="2"){
				window.location.href=basePath+"/hzglView/index";
			}else if(data_key=="3"){
				window.location.href=basePath+"/zbglView/index";
			}
		});
		
		$("#ulQyzx button").click(function(){
			var data_key=$(this).attr("data-key");
			if(data_key=="1"){
				window.location.href=basePath+"/qyzxNewsView/index";	
			}else if(data_key=="2"){
				window.location.href=basePath+"/qyzxGgView/index";
			}
		});
	});
</script>