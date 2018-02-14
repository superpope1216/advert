<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<form class="kfzCardInfoForm" method="post">
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">工作类别</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="gzlbdm"  data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空" >
			<option value="">---请选择擅长的工作类别---</option>
		    <c:forEach  items="${gzlxList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>

<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">擅长技术</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="scjsdm"  data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空"  >
			<option value="">---请选择擅长的技术---</option>
			<c:forEach  items="${scjsList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>

<div class="form-group col-md-12">
	<label class="col-sm-2 control-label myinput" style="font-size: 14px;">其他技能</label>
	<div class="col-sm-10">
		<input type="text" class="form-control myinput" name="qtjn"
			placeholder="请输入其他技能">
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">工作年限</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="gznx"  data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空" >
			<option value="">---请选择擅长的技术---</option>
			<c:forEach  items="${gznxList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">教育工作年限</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="jygznx">
			<option value="">---请选择教育工作年限---</option>
			<c:forEach  items="${gznxList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">工作经历</label>
	<div class="col-sm-10">
		<textarea class="form-control myinput" name="gzjl" > </textarea>
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">项目经验</label>
	<div class="col-sm-10">
		<textarea class="form-control myinput" name="xmjy">
				</textarea>
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">作品展示链接</label>
	<div class="col-sm-10">
		<input class="form-control myinput" name="zslj" >
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">工作现状</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="gzxz"  data-bv-notempty="true" 
				data-fv-notempty-message="此项不能为空">
			<option value="">---请选择工作现状---</option>
			<c:forEach items="${gzxzList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>
<div class="form-group col-md-12">
	<label class="col-sm-2 control-label" style="font-size: 14px;">空闲时间</label>
	<div class="col-sm-10">
		<select class="form-control myinput" name="kxsjid" >
			<option value="">---请选择空闲时间--</option>
			<c:forEach items="${kxsjList}" var="list">
             <option value="${list.lbdm}">${list.lbmc}</option>
           </c:forEach>
		</select>
	</div>
</div>
</form>