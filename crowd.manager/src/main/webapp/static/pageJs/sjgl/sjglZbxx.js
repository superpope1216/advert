/**
 * 
 */

$(document).ready(function() {

	var imgUploader=null;
	var queryConfig=[{
		"type":"text",
		"name":"companyName",
		"label":"公司名称"
	},{
		"type":"select",
		"name":"shzt",
		"label":"审核状态",
		"table":DictionaryEnum.T_ADVERT_SJZD_SHZT
	}
	];
	createQueryForm(queryConfig,"#divQuery");
	
	
	var queryParam=[{
		"field":"name",
		"control":"#queryForm [name='name']"
	},
	{
		"field":"shzt",
		"control":"#queryForm [name='shzt']"
	},
   ];
	var staticFormConfig=[
	                      {
	                    	  "field":"title",
	                    	  "label":"招标标题",
	                    	  "col":1
	                      },
	                     
	                      {
	                    	  "field":"kssj",
	                    	  "label":"招标开始时间"
	                      },
	                      {
	                    	  "field":"jssj",
	                    	  "label":"招标结束时间"
	                      },
	                      
	                      {
	                    	  "field":"imgid",
	                    	  "label":"图片",
	                    	  "col":1,
	                    	  "type":"img",
	                    	  "id":"imgid"
	                    	  
	                      },
	                      {
	                    	  "field":"content",
	                    	  "label":"招标内容正文",
	                    	  "col":1
	                    		  
	                      },
	                      {
	                    	  "field":"ztnr",
	                    	  "label":"招标主题简介",
	                    	  "col":1
	                      },
	                      {
	                    	  "field":"shztDisplay",
	                    	  "label":"状态"
	                      },
	                      {
	                    	  "field":"xgsj",
	                    	  "label":"创建/刷新时间"
	                      }
	                      ];
					var tblColums=[//对应上面thead里面的序列
		             {"data": "companyName",render:function(data2,type,row){
		            	 var _content="";
		            	 _content+="";
		            	 _content+="";
		            	 return data2;
		             }},
		             {"data":"title"},
		             {"data":"kssj"},
		             {"data":"jssj"},
		             {"data": 'shztDisplay' },
		             {"data": 'xgsj' },
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
	var tbl=createMyTable("#example",basePath+"/sjglZbxx/getList",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		$("#shForm [name='wid']").val(key);
		$("#modal-sh").modal("show");
	});
	$("#example").on("click","[action='detailRow']",function(){
		var key=$(this).attr("data-key");
		doGet(basePath+"/sjglZbxx/select","wid="+key,function(data){
			var _form=createStaticForm(staticFormConfig,data.datas,2);
			if($("#detailModal").length<=0){
				var _detailModalConfig={
					"title":"详情",
					"needBtn":false,
					"id":"detailModal"
				};
				
				var detailMode=createModal(_detailModalConfig);
				$("body").append(detailMode);
			}
			$("#detailModal .modal-body").append(_form);
			imgUploader=new Uploader({id:"imgidDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)"});
			imgUploader.setValue(data.datas.imgid);
			$("#detailModal").modal("show");
			//openDialog(_form);
			//alert(_form).set('resizable',true).resizeTo('70%',450).set('basic', true);  
		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/sjglZbxx/delete","wid="+key,function(){
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
			doPost(basePath+"/sjglZbxx/sh",$("#shForm").serializeArray(),function(){
				$("#modal-sh").modal("hide");
				tbl.draw(false);
			});
		});
	});
	
});