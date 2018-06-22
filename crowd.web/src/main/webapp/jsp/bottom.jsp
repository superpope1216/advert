<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="//cdn.bootcss.com/tether/1.3.6/js/tether.min.js"></script>
<script src="<%=request.getContextPath()%>/statics/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/statics/plugins/vendor/swiper/swiper-3.4.2.jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/statics/plugins/vendor/swiper/swiper-3.4.2.jquery.min.js"></script>

	<script src="<%=request.getContextPath()%>/statics/plugins/vendor/bootstrap/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/statics/plugins/vendor/bootstrap/bootstrap.alpha.min.js"></script>		
	<script src="<%=request.getContextPath()%>/statics/plugins/vendor/core.min.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/assets/js/Site.min.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/breakpoints/breakpoints.min.js"></script>
			<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/slick/slick.min.js"></script>
			<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/alertify/3/alertify.min.js"></script>
				<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
				<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/bootstrap.autocomplete/bootstrap.autocomplete.js"></script>
		
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/jquery_lazyload/jquery.lazyload.extend.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/boot-strap-star-rating/js/star-rating.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/boot-strap-star-rating/js/locales/zh.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/jQuery-pingfen/js/starScore.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/ajaxImageUpload/js/upload.js"></script>
		<script
		src="<%=request.getContextPath()%>/statics/plugins/vendor/jquery.datastatistics_js/js/jquery.dataStatistics.js"></script>
		<script  src='<%=request.getContextPath() %>/statics/plugins/vendor/webui-popover/jquery.webui-popover.min.js'></script>
		<script  src='<%=request.getContextPath() %>/statics/plugins/vendor/echart/echarts.common.min.js'></script>
		<script  src='<%=request.getContextPath() %>/statics/plugins/vendor/pagination/jquery.pagination.js'></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/static/ueditor/ueditor.config.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/static/ueditor/ueditor.all.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/js/static_form.js"></script>
	    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/plugins/vendor/upload/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/statics/plugins/vendor/upload/imageUploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/statics/plugins/vendor/upload/uploaderFile.js"></script>
		<script src="<%=request.getContextPath()%>/statics/js/common.js"></script>
<script
	src="<%=request.getContextPath()%>/statics/plugins/vendor/jquery/seajs.js"></script>
<script src="<%=request.getContextPath()%>/statics/js/show_v3.js"></script>
<script type="text/javascript">
	var basePath="<%=request.getContextPath()%>";
	var plugins = basePath + "/statics/plugins";
	var pageJs = basePath + "/statics/pagejs";
	seajs.config({
		paths : {
			'plugins' :plugins,
			'pagejs' :pageJs
		},
		alias : {
			"jquery" : "jquery_seajs.js"
		}
	});
	seajs.use("pagejs/public");
</script>