/**
 * 
 */

$(document).ready(function() {


	
	
	var queryParam=[{
		"field":"companyName",
		"control":"#queryForm [name='name']"
	},
	{
		"field":"shzt",
		"control":"#queryForm [name='shzt']"
	},
   ];
	var staticFormConfig=[
	                      {
	                    	  "field":"companyName",
	                    	  "label":"公司名称"
	                      },
	                     
	                      {
	                    	  "field":"zzlxDisplay",
	                    	  "label":"资质类型"
	                      },
	                      {
	                    	  "field":"shztDisplay",
	                    	  "label":"状态"
	                      },
	                      {
	                    	  "field":"updateTime",
	                    	  "label":"创建时间"
	                      }
	                      ];
	var tblColums=[//对应上面thead里面的序列
		             {"data": "companyName"},
		             {"data":"zzlxDisplay"},
		             {"data": 'shztDisplay' },
		             {"data": 'updateTime' },
		             {"data": "","width":"160px",render:function(data2,type,full){
		            	 var _content="<div class='btn-group'>";
		            	 _content+="	<button data-key='"+full.wid+"' action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>详情</button>";
		            	 if(full.shzt=="1"){
			            	 _content+="	<button data-key='"+full.wid+"' action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>审核</button>";
			            	 }
		            	 _content+="	<button data-key='"+full.wid+"' action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
		            	 _content+="</div>";
		            	 
		            	 return _content;
		             }}
		         ];
	var tbl=createMyTable("#example",basePath+"/supplyZz/getList",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		$("#shForm [name='wid']").val(key);
		$("#modal-sh").modal("show");
	});
	$("#example").on("click","[action='detailRow']",function(){
		var key=$(this).attr("data-key");
		doGet(basePath+"/supplyZz/select","wid="+key,function(data){
			var _form=createStaticForm(staticFormConfig,data.datas);
			//openDialog(_form);
			alert(_form).set('resizable',true).resizeTo('70%',450).set('basic', true);  
		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/supplyZz/delete","wid="+key,function(){
				alert("删除成功！");
				tbl.draw();
			});
		});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
	$("#btnSh").click(function(){
		confirm("确认保存吗？",function(){
			doPost(basePath+"/supplyZz/sh",$("#shForm").serializeArray(),function(){
				$("#modal-sh").modal("hide");
				tbl.draw(false);
			});
		});
	});
	
});