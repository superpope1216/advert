/**
 * 
 */

$(document).ready(function() {


	function getQueryCondition(data){
		var param = {};
		param.pageNum=parseInt(data.start)/parseInt(data.length)+1;
		param.pageSize = data.length;  
        param.draw = data.draw;  
        param.name=$("#queryForm [name='name']").val();
        param.shzt=$("#queryForm [name='shzt']").val();
        
        return param;
	}
	var staticFormConfig=[
	                      {
	                    	  "field":"name",
	                    	  "label":"姓名"
	                      },
	                     
	                      {
	                    	  "field":"areaDisplay",
	                    	  "label":"省"
	                      },
	                      {
	                    	  "field":"cityDisplay",
	                    	  "label":"市"
	                      },
	                      {
	                    	  "field":"xianDisplay",
	                    	  "label":"县"
	                      },
	                      {
	                    	  "field":"addr",
	                    	  "label":"经营地址"
	                      },
	                      {
	                    	  "field":"lxr",
	                    	  "label":"联系人"
	                      },
	                      
	                      {
	                    	  "field":"gddh",
	                    	  "label":"固定电话"
	                      },
	                      {
	                    	  "field":"qq",
	                    	  "label":"QQ号码"
	                      },
	                      {
	                    	  "field":"sjh",
	                    	  "label":"手机"
	                      },
	                      {
	                    	  "field":"czh",
	                    	  "label":"传真"
	                      },
	                      {
	                    	  "field":"wzdz",
	                    	  "label":"网站地址"
	                      },
	                      {
	                    	  "field":"gsxzDisplay",
	                    	  "label":"公司性质"
	                      },
	                      {
	                    	  "field":"nyyeDisplay",
	                    	  "label":"年营业额"
	                      },
	                      {
	                    	  "field":"sfybzDisplay",
	                    	  "label":"是否已标注"
	                      },
	                      {
	                    	  "field":"gsjj",
	                    	  "label":"公司简介",
	                    	  "col":2
	                      }
	                      
	                      ];
	var tbl=$('#example').DataTable($.extend(true,{},DATATABLE_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
		 ajax:function(data,callback,setting){
			 var param = getQueryCondition(data);  
			 doGet(basePath+"/supply/getList?flag="+flag,param,function(data){
			  	  var dataSources={};
			  	  dataSources.draw=data.draw;
			  	  dataSources.data=data.datas;
			  	  dataSources.recordsTotal = data.pageInfo.totalSize;//返回数据全部记录，对象属性为固定格式不可更改，影响表格信息显示
			  	  dataSources.recordsFiltered = data.pageInfo.totalSize;
			    	callback(dataSources);
			    });
		 },
		 columns: [//对应上面thead里面的序列
		             {"data": "name"},
		             {"data":"addr"},
		             {"data": 'lxr' },
		             {"data": 'sjh' },
		             {"data": 'updateTime'},
		             {"data": 'supplyShztDisplay'},
		             {"data": "","width":"160px",render:function(data2,type,full){
		            	 var _content="<div class='btn-group'>";
		            	 _content+="	<button data-key='"+full.wid+"' action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>详情</button>";
		            	 
		            	 if(flag ==1 &&full.supplyShzt=="1"){
		            		 _content+="	<button data-key='"+full.wid+"' action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>审核</button>";
		            	 }else{
		            		 if(full.buyShzt=="1"){
		            			 _content+="	<button data-key='"+full.wid+"' action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>审核</button>";
		            		 }
		            	 }
		            	 _content+="	<button data-key='"+full.wid+"' action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
		            	 _content+="</div>";
		            	 
		            	 return _content;
		             }}
		         ]
	}));
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		$("#shForm [name='wid']").val(key);
		$("#modal-sh").modal("show");
	});
	$("#example").on("click","[action='detailRow']",function(){
		var key=$(this).attr("data-key");
		doGet(basePath+"/supply/select","wid="+key,function(data){
			var _form=createStaticForm(staticFormConfig,data.datas);
			//openDialog(_form);
			alert(_form).set('resizable',true).resizeTo('70%',450).set('basic', true);  
		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/supply/delete","wid="+key+"&flag="+flag,function(){
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
			doPost(basePath+"/supply/sh?flag="+flag,$("#shForm").serializeArray(),function(){
				$("#modal-sh").modal("hide");
				tbl.draw(false);
			});
		});
	});
	
});