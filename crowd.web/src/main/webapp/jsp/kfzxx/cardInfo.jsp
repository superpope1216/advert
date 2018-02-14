<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.cardInfo .met-upfile .file-drop-zone {
	border: 0px;
	margin: 0px;
}

.cardInfo .met-upfile .file-preview {
	border-radius: 0px;
	max-width: 220px;
} /*display:none;*/
.cardInfo .met-upfile .kv-upload-progress {
	max-width: 220px;
} /*display:none;*/
.cardInfo .met-upfile .kv-upload-progress .progress {
	border-radius: 0px;
} /*display:none;*/
.cardInfo .met-upfile .file-preview .file-actions {
	display: none;
}

.cardInfo .met-upfile .file-preview-frame {
	box-shadow: none;
	display: block;
	margin: 0px;
	border: 0;
	padding: 0px;
	float: none;
	height: auto;
}

.cardInfo .met-upfile .file-preview-frame img {
	width: 100% !important;
	height: auto !important;
}

.cardInfo .met-upfile .file-preview-frame:hover {
	box-shadow: none;
}

.cardInfo .met-upfile .file-drop-zone-title {
	font-size: 30px;
}

.cardInfo .met-upfile .fileinput-cancel-button {
	width: 76px;
}

.cardInfo .met-upfile .progress {
	margin-bottom: 10px;
}
</style>

<form class="kfzCardInfoForm" method="post">
<div class="cardInfo">
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">真实姓名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="xm"
				placeholder="请输入真实姓名" data-bv-notempty="true" 
			   data-fv-notempty-message="此项不能为空" >
		</div>

	</div>
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">身份证号</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="sfzjh"
				placeholder="请输入身份证号"  data-bv-notempty="true" 
			   data-fv-notempty-message="此项不能为空" >
		</div>
	</div>
	
	
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">身份证正面照附件</label>

		<div class="col-sm-10" style="padding-bottom: 10px;">
			<input
				data-url="../attr/upload"
				type="file" name="sfzzmztjidImg"  id="sfzzmztjidImg"
					value="../statics/images/card/certificateFront.png">
		</div>
	</div>
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">身份证反面照附件</label>

		<div class="col-sm-10" style="padding-bottom: 10px;">
			<input
			data-url="../attr/upload"
				type="file" name="sfzfmztjidImg"  id="sfzfmztjidImg"
				value="../statics/images/card/certificateBack.png">
		</div>
	</div>
	<!-- <div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">授权书照片附件</label>

		<div class="col-sm-10" style="padding-bottom: 10px;">
			<input
				data-url="https://show.metinfo.cn/muban/M1156014/381/app/system/entrance.php?c=uploadify&m=include&lang=cn&a=dohead"
				type="file" name="sqszpfjid"
				value="https://show.metinfo.cn/muban/M1156014/381/upload/head/12.png?1509528657049">
		</div>
	</div>
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">个人照片附件</label>

		<div class="col-sm-10" style="padding-bottom: 10px;">
			<input
				data-url="https://show.metinfo.cn/muban/M1156014/381/app/system/entrance.php?c=uploadify&m=include&lang=cn&a=dohead"
				type="file" name="grzpfjid"
				value="https://show.metinfo.cn/muban/M1156014/381/upload/head/12.png?1509528657049">
		</div>
	</div> -->
</div>
</form>