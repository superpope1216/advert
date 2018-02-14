/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formModifyDate').bootstrapValidator();
	$$('#formQuestion').bootstrapValidator();
	queryOrders();
	$("#btnSaveDate").click(function(){
		var bootstrapValidator = $$('#formModifyDate').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			confirm("您确认修改需求的日期信息？",function(e){
				doPost(basePath+"/xqfOrder/modifyDate",$("#formModifyDate").serializeArray(),function(data){
					window.location.reload();
				})
			});
		}
	});
	
	$("#btnSaveQuestion").click(function(){
		var bootstrapValidator = $$('#formQuestion').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			confirm("您确认发布该问题吗？",function(e){
				doPost(basePath+"/xqfOrder/publishingQuestion",$("#formQuestion").serializeArray(),function(data){
					window.location.reload();
				})
			});
		}
	});
	//收回需求
	
	$("#btnSaveReback").click(function(){
		var bootstrapValidator = $$('#formReback').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			confirm("您确认收回该需求？",function(e){
				doPost(basePath+"/xqfOrder/reback",$("#formReback").serializeArray(),function(data){
					if(data && data.datas){
						window.location.reload();
					}
				});
			});
			
		}
	});
	$(".nav-tabs>li>a").click(function(){
		queryOrders($(this).attr("data-state"));
	})
	function queryOrders(states,pageNum){
		if(pageNum==undefined){
			pageNum=1;
		}
		doGet(basePath+"/xqfOrder/orders","states="+states+"&parentId="+parentId+"&pageNum="+pageNum+"&pageSize=10",function(data){
			var html="";
			if(data && data.datas){
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<div class="shop-order-lists state-1">';
					html+='		<div class="row shop-order-top">';
					html+=' 		<div class="col-md-8 col-sm-8 ting">';
					html+='					<h4>'+_data.xmztDisplay+'</h4>';
					if(_data.kfzid){
						html+='					<span class="info">开发者：<a href="'+basePath+'/kfzview/index?kfzid='+_data.kfzid+'" target="_blank"> '+toStr(_data.kfznc)+'</a></span>';
					}
					html+='			        <span class="info">需求编号:<a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" target="_blank">'+_data.rwbh+'</a></span>';
					html+='				    <span class="info">交付日期: '+_data.jfrq+'</span>';
					html+='			</div>';
					html+='			<div class="col-md-4 col-sm-4 ting text-sm-right">';
					var _je=_data.xmysje;
					if(_data.zbje){
						_je=_data.zbje;
					}
					if(_data.jjbzje){
						_je=_je+_data.jjbzje;
					}
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
					html+='			<div class="col-xs-6 col-sm-3 col-xl-2 ">';
					html+='				<div class="btn-group">';
					html+='						<a	href="javascript:void(0)" class="btn btn-outline btn-default btn-squared m-b-0 dropdown-toggle" data-toggle="dropdown">需求变更';
					if(_data.childCount && _data.childCount>0){
					html+='                     ('+_data.childCount+')';
					}
					html+='						</a>';
					html+='						<ul class="dropdown-menu"   role="menu">';
					if(_data.xmzt=="0"){//草稿
						html+='							<li><a data-option="edit" href="'+basePath+'/publishing/index?rwid='+_data.wid+'">编辑需求</a></li>';
						html+='							<li><a data-option="delete" data-key="'+_data.wid+'" href="javascript:void(0);">删除需求</a></li>';
					}else if(_data.xmzt=="1"){
						html+='							<li><a data-option="reback" data-key="'+_data.wid+'" href="javascript:void(0);">收回需求</a></li>';
					}
					else if(_data.xmzt=="2"){
						html+='							<li><a data-option="edit" href="'+basePath+'/publishing/index?rwid='+_data.wid+'">编辑需求</a></li>';
						
					}else if(_data.xmzt=="3"){
						html+='							<li><a data-option="modifyDate" data-key="'+_data.wid+'" href="javascript:void(0);" >修改日期</a></li>';
					}else if(_data.xmzt>=4 && _data.kfzid && _data.xmzt!=15 && _data.xmzt!=16 && _data.xmzt!=17){
						html+='							<li><a href="javascript:void(0);" data-option="publishingBug" data-key="'+_data.wid+'">发布问题</a></li>';
						html+='							<li><a href="'+basePath+'/xqfOrder/index?flag=order&parentId='+_data.wid+'" target="_blank" data-option="historyQuestion" data-key="'+_data.wid+'">历史问题('+_data.childCount+')</a></li>';
						
					}else if(_data.xmzt>=4 && _data.xmzt<=9 && _data.kfzid ){
						html+='							<li><a data-option="sqzz" data-key="'+_data.wid+'" href="#">申请终止</a></li>';
					}
					
					html+='							<li><a data-option="reSupplish" href="'+basePath+'/publishing/index?rwid='+_data.wid+'&rePublish=1">发布相似需求</a></li>';
					//html+='							<li><a href="#">重新发布</a></li>';
					//html+='							<li class="divider"></li>';
				
					html+='						</ul>';
					html+='				</div>';
					html+='			</div>';
					
						html+='			<div class="col-xs-6 col-sm-3 col-xl-2">';
						html+='				<a href="'+basePath+'/xqfOrderAction/index?rwid='+_data.wid+'&flag=order" target="_blank" class="btn btn-danger btn-squared">';
						html+='					需求操作';
						html+='				</a> ';
						html+='			</div>';
					
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
				if(data_option=="reback"){
							func_reback(data_key);
					
					
				}else if(data_option=="modifyDate"){
					func_modifyData(data_key);
				}else if(data_option=="delete"){
					func_delete(data_key); 
				}else if(data_option=="publishingBug"){
					func_publishingBug(data_key);
				}else if(data_option=="historyQuestion"){
					//func_historyQuestion(data_key);
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
	/**
	 * 发布BUG
	 */
	function func_publishingBug(rwid){
		$$('#formQuestion').bootstrapValidator('resetForm', true); 
		$("#formQuestion")[0].reset();
		$("#formQuestion [name='rwid']").val(rwid);
		$("#questionModal").modal("show");
	}
	
	
	function func_reback(rwid){
		$$('#formReback').bootstrapValidator('resetForm', true);  
        $('#formReback')[0].reset();
        $('#formReback [name="rwid"]').val(rwid);
        var modal = $('#rebackModal');
		modal.modal("show");
	}
	
	function func_delete(rwid){
		confirm("您确认删除该需求？",function(e){
			doPost(basePath+"/xqfOrder/delete","rwid="+rwid,function(data){
				alert("任务删除成功");
				queryOrders();
			})
		});
	}
	function func_modifyData(rwid){
		var modal = $('#addr-edit-modal');
		
		doGet(basePath+"/xqfOrder/queryDate","rwid="+rwid,function(data){
			if(data && data.datas){
				$("#formModifyDate [name='wid']").val(data.datas.wid);
				$("#formModifyDate [name='zbjzrq']").val(data.datas.zbjzrq);
				$("#formModifyDate [name='jfrq']").val(data.datas.jfrq);
				modal.modal("show");
			}
		});
	}
});