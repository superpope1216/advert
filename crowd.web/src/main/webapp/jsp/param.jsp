<%@page import="com.pope.advert.entity.dto.QueryCondition"%>
<%@page import="com.wisedu.crowd.common.code.ShztEnum"%>
<%@page import="com.wisedu.crowd.common.util.StringUtil"%>
<%@page import="com.wisedu.crowd.common.util.ConstantsUtil"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="java.util.List"%>
<%@page import="com.wisedu.crowd.common.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<script type="text/javascript" >
    var basePath="<%=request.getContextPath()%>";
    var upfiletext="选择";
    var uploadUrl="";
    var page_type="";
    var jsonurl ="";
    var M=document.querySelector('meta[name="generator"]').getAttribute('data-variable'),D=M.split(',');M=new Array();M['weburl']=D[0];M['lang']=D[1];M['classnow']=parseInt(D[2]);M['id']=parseInt(D[3]);M['module']=parseInt(D[4]);M['tem']=D[0]+'templates/'+D[5];var deviceType = /iPad/.test(navigator.userAgent) ? 't' : /Mobile|iP(hone|od)|Android|BlackBerry|IEMobile|Silk/.test(navigator.userAgent) ? 'm' : 'd',is_ucbro=/UC/.test(navigator.userAgent);
    var met_prevArrow='<button type="button" class="slick-prev"><i class="icon pe-angle-left vertical-align-middle"></button>',met_nextArrow='<button type="button" class="slick-next"><i class="icon pe-angle-right vertical-align-middle"></i></button>';
</script>