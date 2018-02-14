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



/* .uploadBrower {
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

.uploadPosition {
     border-radius: 52px;
     vertical-align: middle;
}

.bi-icon-container {
    width:97px;
    height:97px;
    background-color:#F3F3F3;    
    border: solid 1px #ddd;
} */
</style>

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
			   data-fv-notempty-message="此项不能为空" 
			   data-bv-regexp="true" 
			   data-bv-regexp-regexp="^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$" 
			   data-bv-regexp-message="身份证号格式不正确">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">认证须知</label>
		<div class="col-sm-10">
			<p style="margin-bottom:15px;background-color:#EEE;padding:10px;font-size:12px;color:#999;">您的个人信息不会透露给第三方，请放心填写。已经提交的认证信息无法自行修改，如果需要修改认证信息请 <a>联系客服</a></p>
			
		</div>
	</div>
	
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">参考样例</label>
		<div class="col-sm-10">
            <img src="../statics/images/card/certificateFront.png" style="width:300px;float:left"/>
            <img src="../statics/images/card/certificateBack.png" style="width:300px;float:right"/>	
		</div>
	</div>
	
	
	
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">身份证正面照附件</label>
		<div class="col-sm-10" style="padding-bottom: 10px;">
			<div id="sfzzmztjidUpload" class="bh-l-inline sfz-icon-container ">
				<img
					src="<%=request.getContextPath()%>/statics/images/card/certificateFront.png"
					id="sfzzmztjidImg" class="sfzImg" />
			</div>
			<div id="sfzzmztjidBrower" class="uploadBrower"></div>
		</div>
	</div>
	
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">身份证反面照附件</label>
		<div class="col-sm-10" style="padding-bottom: 10px;">
			<div id="sfzfmztjidUpload" class="bh-l-inline sfz-icon-container ">
				<img
					src="<%=request.getContextPath()%>/statics/images/card/certificateBack.png"
					id="sfzfmztjidImg" class="sfzImg" />
			</div>
			<div id="sfzfmztjidBrower" class="uploadBrower"></div>
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
