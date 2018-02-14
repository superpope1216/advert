<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/jsp/top/top.jsp" %>
<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}
</style>
</head>
<body>
<%@ include file="/jsp/header.jsp" %>
	

	<div class="ui main text container">
		<h1 class="ui header">Semantic UI Fixed Template</h1>
		<p>This is a basic fixed menu template using fixed size
			containers.</p>
		<p>A text container is used for the main container, which is
			useful for single column layouts</p>
		<img class="wireframe"
			src="assets/images/wireframe/media-paragraph.png"> <img
			class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
		<img class="wireframe" src="assets/images/wireframe/paragraph.png">
	</div>

	
	<%@ include file="/jsp/footer/footer.jsp" %>
</body>
</html>