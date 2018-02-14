<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
    <%
    response.setHeader("Pragma","No-cache");  
    response.setHeader("Cache-Control","no-cache");  
    response.setDateHeader("Expires", 0);
    %>
<head>
<title>智慧校园云工场</title>
<meta name="renderer" content="webkit">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="generator" content="CROWD"  data-variable="123,cn,10001,,10001,123" />
<meta name="description" content="智慧校园云工场" />
<meta name="keywords" content="智慧校园云工场" />
<link href="<%=request.getContextPath() %>/static/images/favicon1.ico" rel="shortcut icon" type="image/x-icon" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/plugins/AdminLTE-master/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/plugins/AdminLTE-master/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/plugins/AdminLTE-master/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/plugins/AdminLTE-master/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/plugins/AdminLTE-master/dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  
  <script>
  var basePath="<%=request.getContextPath() %>";
  </script>