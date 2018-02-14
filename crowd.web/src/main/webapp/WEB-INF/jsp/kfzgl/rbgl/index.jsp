<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%@ include file="/jsp/top/top.jsp"%>
<%@ include file="/jsp/top/other.jsp"%>
<%@ include file="/jsp/param.jsp"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/statics/css/order.css'>
<!--[if lte IE 8]>
<div class="text-xs-center m-b-0 bg-blue-grey-100 alert">
    <button type="button" class="close" aria-label="Close" data-dismiss="alert">
        <span aria-hidden="true">×</span>
    </button>
    你正在使用一个 <strong>过时</strong> 的浏览器。请 <a href="http://browsehappy.com/" target="_blank">升级您的浏览器</a>，以提高您的体验。
</div>
<![endif]-->

<body>
	<%@include file="/jsp/header.jsp"%>

	<div class="page bg-pagebg1">
		<div class="container">
			<div class="page-content row">

				<div class="col-lg-3">

					<%@include file="/jsp/kfzxx/left_menu.jsp"%>
				</div>

				<div class="col-lg-9">
					<div class="panel m-b-0" boxmh-mh>
						<div class="panel-body shop-order">
							<div>
								<!-- <button type="button"
									class="btn header-btn1 addr-btn btn-squared " id="btnAddRbxx">新建</button> -->
									<button type="button"
									class="btn  header-btn1 btn-lg" id="btnAddRbxx">新建</button>

								<div class="cart-list animation-fade" data-scale="1">
									<div class="table-responsive">
										<table class="table table-hover table-striped">
											<thead>
												<tr>
													<th class="text-xs-center w-100">任务编号</th>
													<th class="w-200">任务名称</th>
													<th class="text-xs-center">日期</th>
													<th class="text-xs-center">时间段</th>
													<th class="text-xs-center w-150">实际工作量</th>
													<th class="text-xs-center w-100">操作</th>
												</tr>
											</thead>
											<tbody>
												 <c:forEach  items="${rbglList}" var="list">
                                                   <tr class="text-xs-center">
													<td>${list.rwbh}</td>
													<td class="text-xs-left">${list.rwmc}</td>
													<td>${list.rq}</td>
													<td>${list.sjdDisplay}</td>
													<td><span class="red-600 subtotal" data-id="32">${list.sjgzl}</span></td>
													<td><a href="#" ><i
															class="icon wb-edit" aria-hidden="true" onclick="editRbxx('${list.wid}')"></i></a>
															<a href="#"><i
															class="icon wb-trash" aria-hidden="true" onclick="delRbxx('${list.wid}')"></i></a></td>
												   </tr>
                                                 </c:forEach>
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade modal-primary" id="rbxx-edit-modal" 
		aria-hidden="true" aria-labelledby="rbxx-modal-title" role="dialog"
		tabindex="-1">
		<div class="modal-dialog modal-center modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="rbxx-modal-title">日报编辑</h4>
				</div>
				<form id="formRbxxgl"
					class="addr-edit-form met-form-validation" >
					<input name="wid" type="hidden"  id="wid">
					<div class="modal-body">
						<div class="form-group col-md-12">
							<label class="col-sm-2 control-label" style="font-size: 14px;">任务编号</label>
						    <div class="col-sm-10">
							<input type="text" class="form-control" name="rwbh"
								placeholder="请输入任务编号模糊查询"  data-bv-notempty="true"  
			           	data-bv-notempty-message="此项不能为空">
							</div>
						</div>
						<div class="form-group col-md-12"  style="display:none">
							<label class="col-sm-2 control-label" style="font-size: 14px;">任务名称</label>
							<div class="col-sm-10">
							<input type="text" class="form-control" name="rwmc"
								placeholder="请输入任务名称" readonly >
							</div>
						</div>
						
							<div class="form-group col-md-12">
							<label class="col-sm-2 control-label" style="font-size: 14px;">日期</label>
							<div class="col-sm-10">
							<input type="text" class="form-control datepicker" name="rq"
								placeholder="请输入日期"  data-bv-date="true" 
									data-bv-date-format="YYYY-MM-DD"
									data-bv-date-message="请输入正确的日期格式"
									data-bv-notempty="true"  
			                       	data-bv-notempty-message="此项不能为空">
							</div>
						</div>
                         
						<div class="form-group select-linkage col-md-12">
							<label class="col-sm-2 control-label" style="font-size: 14px;">时间段</label>
						   <div class="col-sm-10">
							<select class="form-control prov" name="sjd" data-bv-notempty="true"  
			          	data-bv-notempty-message="此项不能为空" placeholder="请选择时间段">
								 <option value="">请选择时间段</option>
							    <c:forEach  items="${sjdList}" var="list">
					             <option value="${list.lbdm}">${list.lbmc}</option>
					            </c:forEach>
							   </select>
							   </div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-sm-2 control-label" style="font-size: 14px;">实际工作量</label>
							 <div class="col-sm-10">
						      <input type="text" class="form-control" name="sjgzl"
								placeholder="请输入实际工作量(小时)" data-bv-notempty="true"  
				     data-bv-notempty-message="此项不能为空"  data-bv-regexp="true" 
			   data-bv-regexp-regexp="^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$" 
			   data-bv-regexp-message="身份证号格式不正确">
							 </div>
						</div>
						
						<div class="form-group col-md-12">
						<label class="col-sm-2 control-label" style="font-size: 14px;">工作内容说明</label>
						    <div class="col-sm-10">
							<textarea class="form-control" rows="3" name="gznrsm"
								placeholder="请输入工作内容说明" 
								data-bv-notempty="true"  
			                	data-bv-notempty-message="此项不能为空"></textarea>
								</div>
						</div>
						
						<div class="form-group m-b-0 col-md-12">
						<label class="col-sm-2 control-label" style="font-size: 14px;">备注</label>
						 <div class="col-sm-10">
							<textarea class="form-control" rows="3" name="bz"
								placeholder="请输入备注"  
								data-bv-notempty="true"  
			            	data-bv-notempty-message="此项不能为空"></textarea>
						  </div>
						</div>
					</div>
					<div class="modal-footer text-xs-left">
						<button type="button" class="btn btn-primary btn-squared" id="btnSave">保存</button>
						<button type="button" class="btn btn-default btn-squared"
							data-dismiss="modal">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- End Modal -->
	
	<%@include file="/jsp/footer/footer2.jsp" %>
		<script type="text/javascript">
			var page_type = "kfzrbgl";
		</script>
	<%@ include file="/jsp/bottom.jsp"%>
</body>
</html>