<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<%@ include file="/jsp/top.jsp"%>
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet">
<body class="skin-blue sidebar-mini" style="height: auto; min-height: 100%;">
<div class="wrapper" style="height: auto; min-height: 100%;">

  <%@include file="/jsp/header.jsp" %>
  <%@include file="/jsp/left.jsp" %>
  <div class="content-wrapper" style="min-height: 929px;">
    <section class="content-header">
      <h1>
                      云工场数据一览
        <small>2017财年</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 数据中心</a></li>
        <li class="active">需求方发布任务详情</li>
      </ol>
    </section>

    <section class="content container-fluid">

     <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>姓名</th>
				<th>已发布</th>
				<th>待审核</th>
				<th>招标中</th>
				<th>开发中</th>
				<th>验收中</th>
				<th>已完成</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>姓名</th>
				<th>已发布</th>
				<th>待审核</th>
				<th>招标中</th>
				<th>开发中</th>
				<th>验收中</th>
				<th>已完成</th>
            </tr> 
        </tfoot>
    </table>
    </section>
  </div>
  
  
  
  

  <%@include file="/jsp/footer.jsp" %>

  <%@include file="/jsp/left_scroll.jsp" %>
  
  <div class="control-sidebar-bg"></div>
</div>
	<%@ include file="/jsp/bottom.jsp"%>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/static/pageJs/detail/xqfgzjdxq.js"></script>
</body>
</html>
