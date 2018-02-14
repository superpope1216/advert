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
</style>
   
     <input type="hidden" name="wid" id="wid" />
     <input type="hidden" name="zpfjid"  id="zpfjid"/>
     <input type="hidden" name="sfzzmztjid" id="sfzzmztjid"/>
     <input type="hidden" name="sfzfmztjid"  id="sfzfmztjid"/>
	<div class="form-group  met-upfile">
		<label class="col-sm-2 control-label" style="font-size: 14px;">头像</label>
		<div class="col-sm-10" style="padding-bottom: 10px;">
			<input
				data-url="../attr/upload"
				type="file" name="head"  id="head"
				value="../statics/images/card/header.png">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;" >需求方单位名称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput " name="xqfdwmc" 
				placeholder="需求方单位名称">
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;" >昵称</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput " name="nc"
				placeholder="请输入昵称"  data-bv-notempty="true" 
				data-bv-notempty-message="此项不能为空" >
		</div>
	</div>
	

	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住省</label>
		<div class="col-sm-10">
			<select class="form-control" name="perProvince"  data-bv-notempty="true" 
				data-bv-notempty-message="此项不能为空"  ><option value="">请选择常住省</option>
				<c:forEach  items="${provinceList}" var="list">
                 <option value="${list.lbdm}">${list.lbmc}</option>
               </c:forEach>
				</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住市</label>
		<div class="col-sm-10">
			<select class="form-control" name="perCity" ><option value="">请选择常住市</option>
				<c:forEach  items="${cityList}" var="list">
                <option value="${list.lbdm}">${list.lbmc}</option>
                </c:forEach>
				</select>
		 </div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">常住区</label>
		<div class="col-sm-10">
			<select class="form-control" name="perArea"><option value="">请选择常住区</option>
				<c:forEach  items="${areaList}" var="list">
               <option value="${list.lbdm}">${list.lbmc}</option>
                 </c:forEach>
				</select>
		</div>
	</div>
	
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">QQ</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="qqh"  data-bv-notempty="true" 
				data-bv-notempty-message="此项不能为空" 
			placeholder="为了方便需求方与您沟通，请输入QQ号">
		</div>
	</div>
	<div class="form-group col-md-12">
		<label class="col-sm-2 control-label" style="font-size: 14px;">微信</label>
		<div class="col-sm-10">
			<input type="text" class="form-control myinput" name="wxh"  data-bv-notempty="true" 
				data-bv-notempty-message="此项不能为空" 
				placeholder="为了方便需求方与您沟通，请输入微信号">
		</div>
	</div>
	
	<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">用户类型</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="userRange"  placeholder="用户类型"  data-bv-notempty="true" 
				data-bv-notempty-message="此项不能为空" >
			<option value="">---请选择用户类型---</option>
			<c:forEach  items="${rangeList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>


	