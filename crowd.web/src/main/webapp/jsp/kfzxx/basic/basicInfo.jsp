<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	
.met-upfile .file-drop-zone {
	border: 0px;
	margin: 0px;
}

.met-upfile .file-preview {
	border-radius: 0px;
	max-width: 220px;
} /*display:none;*/
.met-upfile .kv-upload-progress {
	max-width: 220px;
} /*display:none;*/
.met-upfile .kv-upload-progress .progress {
	border-radius: 0px;
} /*display:none;*/
.met-upfile .file-preview .file-actions {
	display: none;
}

.met-upfile .file-preview-frame {
	box-shadow: none;
	display: block;
	margin: 0px;
	border: 0;
	padding: 0px;
	float: none;
	height: auto;
}

.met-upfile .file-preview-frame img {
	width: 100% !important;
	height: auto !important;
}

.met-upfile .file-preview-frame:hover {
	box-shadow: none;
}

.met-upfile .file-drop-zone-title {
	font-size: 30px;
}

.met-upfile .fileinput-cancel-button {
	width: 76px;
}

.met-upfile .progress {
	margin-bottom: 10px;
}

.uploadBrower {
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

.sfzImg {
     width: 303px;
     height: 193px;
     position: relative;
     top: -1px;
     
}

.sfz-icon-container {
    width:303px;
    height:193px;
    background-color:#F3F3F3;    
    border: solid 1px #ddd;
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
}
</style>
   
     <input type="hidden" name="wid" id="kfzxxWid" />
     <input type="hidden" name="grzpfjid"  id="grzpfjid"/>
	<div class="form-group ">
		<label class="col-sm-2 control-label" style="font-size: 14px;margin-top:28px;">头像</label>
           <div class="col-sm-10" style="padding-bottom: 10px;">
		<div id="headUpload" class="bh-l-inline bi-icon-container uploadPosition" >
			 <img src="<%=request.getContextPath()%>/statics/images/card/header.png" id="headImg" class="headImg" />
		</div>
		<div id="headBrower" class="uploadBrower"></div>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;" >昵称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput " name="nc" 
				placeholder="请输入昵称"  data-bv-notempty="true"  
				data-bv-notempty-message="此项不能为空">
		</div>

	</div>
	<!-- <div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">所在地区</label>
		<div class="col-sm-10">
			<select class="form-control" name="szdq" required data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空" data-fv-field="szdq"
				data-checked=""><option value="">请选择所在地区</option>
				</select>
		</div>
	</div> -->
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住省</label>
		<div class="col-sm-10">
			<select class="form-control" name="perProvince"  data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空" 
				data-checked=""><option value="">请选择常住省</option>
				<c:forEach  items="${provinceList}" var="list">
                 <option value="${list.lbdm}">${list.lbmc}</option>
               </c:forEach>
				</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住市</label>
		<div class="col-sm-10">
			<select class="form-control" name="perCity" >
			  <option value="">请选择常住市</option>
				<c:forEach  items="${cityList}" var="list">
                <option value="${list.lbdm}">${list.lbmc}</option>
                </c:forEach>
				</select>
		 </div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住区</label>
		<div class="col-sm-10">
			<select class="form-control" name="perArea">
				<option value="">请选择常住区</option>
				<c:forEach  items="${areaList}" var="list">
               <option value="${list.lbdm}">${list.lbmc}</option>
                 </c:forEach>
				</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">生日</label>
		<div class="col-sm-10">
		<input class="form-control datepicker" type="text"  name="csrq"
			placeholder="请输入生日"data-bv-date="true" 
			data-bv-date-format="YYYY-MM-DD"
			data-bv-date-message="请输入正确的日期格式">
		</div>
	</div>
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">QQ</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="qq"
			data-bv-notempty="true" data-fv-notempty-message="此项不能为空" 
			placeholder="为了方便需求方与您沟通，请输入QQ号">
		</div>
	</div>
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">微信</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="wxh"
			  data-bv-notempty="true"  data-fv-notempty-message="此项不能为空" 
				placeholder="为了方便需求方与您沟通，请输入微信号">
		</div>
	</div>
	
	<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">用户类型</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="sfytd"  data-bv-notempty="true" 
			   data-fv-notempty-message="此项不能为空"  placeholder="用户类型">
			<option value="">---请选择用户类型---</option>
			<c:forEach  items="${rangeList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>

	