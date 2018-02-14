/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formModifyDate').bootstrapValidator();
	$$('#formRwcf').bootstrapValidator();
	
	$$("#formYsqr").bootstrapValidator();
	queryOrders("1");
	
	$(".nav-tabs>li>a").click(function(){
		queryOrders($(this).attr("data-state"));
	});
	$(document).on('show.bs.modal', '.modal', function (event) {
        var zIndex = 9999 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
    });
	
	$("#btnSaveYsqr").click(function(){
		var bootstrapValidator = $$('#formYsqr').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
				$("#btnSaveYsqr").attr("disabled",true);
				var param="cfrwid="+$("#formYsqr [name='wid']").val();
				param+="&sfjs="+$("#formYsqr [name='sfjs']").val();
				doPost(basePath+"/kfzOrder/supply",param,function(data){
					window.location.reload();
				},"#btnSaveYsqr")
		};
	});
	$("#btnSaveRwcf").click(function(){
		var bootstrapValidator = $$('#formRwcf').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			confirm("您确认将订单拆分给该开发者吗？",function(e){
				$("#btnSaveRwcf").attr("disabled",true);
				var _saveData=$("#formRwcf").serializeArray();
				for(var i=0;i<_saveData.length;i++){
					if(_saveData[i].name=="kfzid"){
						_saveData[i].value=$('#formRwcf [name="kfzid"]').attr("real-value");
					}
				}
				doPost(basePath+"/kfzOrder/rwcf",_saveData,function(data){
					window.location.reload();
				},"#btnSaveRwcf")
			});
		};
	});
	$('#formRwcf [name="kfzid"]').autocomplete({  
		   source:function(query,process){
			 if(query){
				 doPost(basePath+"/kfzOrder/kfzxxs","condition="+query,function(data){
					 process(data.datas);
				});
				 
			 }
		   }, 
		   formatItem:function(item){  
		       return item["xm"]+"("+item["gh"]+")";  
		    },  
		   setValue:function(item){  
		       return{'data-value':item["xm"],'real-value':item["wid"]};  
		    },
		    minLength:2
		}); 
	
	function queryOrders(state,pageNum){
		if(pageNum==undefined){
			pageNum=1;
		}
		
		doGet(basePath+"/kfzOrder/orders","state="+state+"&pageNum="+pageNum+"&pageSize=10",function(data){
			var html="";
			if(data && data.datas){
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<div class="shop-order-lists state-1">';
					html+='		<div class="row shop-order-top">';
					html+=' 		<div class="col-md-8 col-sm-8 ting">';
					html+='					<h4>'+_data.xmztDisplay+'</h4>';
					html+='					<span class="info">需求方：<a href="'+basePath+'/xqfview/index?xqfid='+_data.xqfid+'" target="_blank"> '+(_data.xqfnc?_data.xqfnc:_data.xqfxm)+'</a></span>';
					html+='			        <span class="info">需求编号:<a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" target="_blank">'+_data.rwbh+'</a></span>';
					html+='				    <span class="info">交付日期: '+_data.jfrq+'</span>';
					html+='			</div>';
					html+='			<div class="col-md-4 col-sm-4 ting text-sm-right">';
					var _je=_data.xmysje;
					if(_data.zbje){
						_je=_data.zbje;
					}
//					if(_data.jjbzje){
//						_je=_je+jjbzje;
//					}
					if(_data.ptbzje){
						_je=_je+_data.ptbzje;
					}
					
					html+='				金额 ：<span class="price  red-600">￥'+_je+'元</span>';
					html+='			</div>';
					html+='		</div>';
					html+='		<div class="row shop-order-bottom">';
					html+='			<div class="col-sm-6 col-xl-8">';
					html+='				<div class="media media-xs m-t-10">';
					html+='						<div class="media-body">';
					html+='							<h4 class="media-heading">';
					html+='								<a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" target="_blank">';
					html+='									'+_data.rwmc;
					html+='								</a>';
					html+='							</h4>';
					html+='						</div>';
					html+='				</div>';
					html+='			</div>';
					if( _data.kfzid && !_data.rwtbxxInfoExtend && _data.xmzt>=4 && _data.xmzt<=14){
					html+='			<div class="col-xs-6 col-sm-3 col-xl-2 ">';
					html+='				<div class="btn-group">';
					html+='						<a	href="javascript:void(0)" class="btn btn-outline btn-default btn-squared m-b-0 dropdown-toggle" data-toggle="dropdown">需求变更</a>';
					html+='						<ul class="dropdown-menu"   role="menu">';
					if(_data.xmzt=="4"){//开发中
						if(isnbkfz){
							html+='							<li><a data-option="rwcf" data-key="'+_data.wid+'" data-option="rwcf">订单拆分</a></li>';
						}
					}else if(_data.xmzt>=4 && _data.xmzt<=14 ){
						html+='							<li><a data-option="sqzz" data-key="'+_data.wid+'" href="#">申请终止</a></li>';
					}
					if(_data.childCount>0){
						html+='							<li><a data-option="edit" href="'+basePath+'/publishing/index?rwid='+_data.wid+'">问题列表('+_data.childCount+')</a></li>';
						
					}
					if(_data.rwcfCount && isnbkfz){
						html+='							<li><a data-option="rwcfxx" href="javascript:void(0);" data-key="'+_data.wid+'">拆分信息('+_data.rwcfCount+')</a></li>';
					}
					if(_data.childKfzCount && _data.childKfzCount>0){
						html+='							<li><a data-option="question" href="javascript:void(0);" data-key="'+_data.wid+'">问题记录('+_data.childKfzCount+')</a></li>';
					}
					
					//html+='							<li><a href="#">重新发布</a></li>';
					//html+='							<li class="divider"></li>';
				
					html+='						</ul>';
					html+='				</div>';
					html+='			</div>';
					html+='			<div class="col-xs-6 col-sm-3 col-xl-2">';
					html+='				<a href="'+basePath+'/kfzOrderAction/index?rwid='+_data.wid+'&flag=order" target="_blank" class="btn btn-danger btn-squared">';
					html+='					需求操作';
					html+='				</a> ';
					html+='			</div>';
					}
					html+='		</div>';
					html+='	</div>';
				}
			}
			if(html==""){
				html='<div class="h-200 vertical-align text-xs-center order-null animation-fade"><div class="vertical-align-middle font-size-18 blue-grey-500">没有符合条件的需求</div></div>'
			}
			$("#ulOrders").html(html);
			$("#ulOrders .dropdown-menu>li>a").click(function(){
				var data_option=$(this).attr("data-option");
				var data_key=$(this).attr("data-key");
				if(data_option=="rwcf"){
							func_rwcf(data_key);
				}else if(data_option=="rwcfxx"){
					func_rwcfHistory(data_key);
				}else if(data_option=="delete"){
					func_delete(data_key); 
				}
				//else if{
					//func_modifyData();
				//}
				
			})
			
		});
	}
	$('#addr-edit-moda').on('show.bs.modal', function() {  
        $$('#formModifyDate').bootstrapValidator('resetForm', true);  
        $('#formModifyDate')[0].reset();  
    });  
	
	function func_rwcf(rwid){
		$$('#formRwcf').bootstrapValidator('resetForm', true); 
		$("#formRwcf")[0].reset();
		$("#formRwcf [name='rwid']").val(rwid);
		$("#rwcfModal").modal("show");
	}
	
	function func_rwcfHistory(rwid){
		doGet(basePath+"/kfzOrder/rwcfHistory","rwid="+rwid,function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<tr>';
					html+='<td class="text-xs-center">';
					html+='<div class="btn-group btn-group-xs">';
					if(_data.rwzt=="0"){
						html+='<button type="button" class="btn  btn-danger" data-option="delete" data-key="'+_data.wid+'">删除</button>';
						html+='<button type="button" class="btn  btn-info" data-option="edit" data-key="'+_data.wid+'">修改</button>';
						
					}
					if(_data.rwzt=="2"){
						html+='<button type="button" class="btn  btn-success" data-option="ys" data-key="'+_data.wid+'">验收确认</button>';
					}
					html+='</div>';
					html+='</td>';
					html+='<td class="text-xs-left"><span class="tag tag-default">'+_data.kfzXm+'</span></td>';
					html+='<td class="text-xs-left"><span class="tag tag-default">'+_data.rwjg+'</span></td>';
					html+='<td class="text-xs-left"><span class="tag tag-default">'+(_data.sfsqfy=="1"?"是":"否")+'</span></td>';
					var _sjje=_data.rwjg;
					if(_data.sfsqfy=="1"){
						_sjje=   _sjje*(100-rwcfsqbl)/100;
					}
					html+='<td class="text-xs-left"><span class="tag tag-default">'+_sjje+'</span></td>';
					html+='<td class="text-xs-left"><span class="tag tag-default">'+_data.rwztDisplay+'</span></td>';
					html+='</tr>';
				}
				$("#tblRwcf").html(html);
				$("#tblRwcf button").click(function(){
					var data_option=$(this).attr("data-option");
					var data_key=$(this).attr("data-key");
					if(data_option=="delete"){
							func_rwcf_delete(data_key);
					}else if(data_option=="edit"){
						func_rwcf_edit(data_key);
					}else if(data_option=="ys"){
						func_rwcf_ys(data_key); 
					}
					//else if{
						//func_modifyData();
					//}
					
				})
			}
		});
		$("#rwcfJlModal").modal("show");
	}
	
	function func_rwcf_delete(cfrwid){
		confirm("您确认删除该拆分需求？",function(e){
			doPost(basePath+"/kfzOrder/deleteCfrw","cfrwid="+cfrwid,function(data){
				alert("任务删除成功");
				func_rwcfHistory(data.datas);
			})
		});
	}
	
	function func_rwcf_edit(cfrwid){
		$$('#formRwcf').bootstrapValidator('resetForm', true); 
		$("#formRwcf")[0].reset();
		doGet(basePath+"/kfzOrder/queryCfrw","cfrwid="+cfrwid,function(data){
			//func_rwcfHistory(data.datas);
		
			$("#formRwcf [name='wid']").val(data.datas.wid);
			$("#formRwcf [name='rwid']").val(data.datas.rwid);
			$("#formRwcf [name='kfzid']").val(data.datas.kfzXm);
			$("#formRwcf [name='kfzid']").attr("real-value",data.datas.kfzid);
			$("#formRwcf [name='rwjg']").val(data.datas.rwjg);
			$("#formRwcf [name='sfsqfy']").val(data.datas.sfsqfy);
			$("#formRwcf [name='rwnr']").val(data.datas.rwnr);
			
			
			
		});
		$("#rwcfModal").modal("show");
	}
	
	function func_rwcf_ys(cfrwid){
		$$('#formYsqr').bootstrapValidator('resetForm', true); 
		$("#formYsqr")[0].reset();
		$("#formYsqr [name='wid']").val(cfrwid);
		$("#ysqrModal").modal("show");
	}
});