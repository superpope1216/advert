/**
 * 
 */

$(document).ready(function() {


	function getQueryCondition(data){
		
        param.yhm=$("").val();
        param.sjh=$("#queryForm [name='sjh']").val();
        
        return param;
	}
	var staticFormConfig=[
	                      {
	                    	  "field":"yhm",
	                    	  "label":"用户名"
	                      },
	                     
	                      {
	                    	  "field":"sjh",
	                    	  "label":"手机号"
	                      },
	                      {
	                    	  "field":"email",
	                    	  "label":"邮箱"
	                      },
	                      {
	                    	  "field":"czsj",
	                    	  "label":"注册时间"
	                      }
	                      ];
	var tblColums=[//对应上面thead里面的序列
		             {"data": "yhm"},
		             {"data":"sjh"},
		             {"data": 'email' },
		             {"data": 'czsj' },
		             {"data": "","width":"120px",render:function(data2,type,full){
		            	 var _content="<div class='btn-group'>";
		            	 _content+="	<button data-key='"+full.wid+"' action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>详情</button>";
		            	
		            	 _content+="	<button data-key='"+full.wid+"' action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
		            	 _content+="</div>";
		            	 
		            	 return _content;
		             }}
		         ];
	var queryParam=[{
						"field":"yhm",
						"control":"#queryForm [name='yhm']"
					},
					{
						"field":"sjh",
						"control":"#queryForm [name='sjh']"
					},
	               ];
	var tbl=createMyTable("#example",basePath+"/registerUser/getList",queryParam,tblColums);
	
	$("#example").on("click","[action='detailRow']",function(){
		var key=$(this).attr("data-key");
		doGet(basePath+"/registerUser/select","wid="+key,function(data){
			var _form=createStaticForm(staticFormConfig,data.datas);
			//openDialog(_form);
			alert(_form).set('resizable',true).resizeTo('70%',450).set('basic', true);  
		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/registerUser/delete","wid="+key,function(){
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
			doPost(basePath+"/supply/sh",$("#shForm").serializeArray(),function(){
				$("#modal-sh").modal("hide");
				tbl.draw(false);
			});
		});
	});
	
});