/**
 * 
 */
$(document).ready(function() {

	
	var staticZzzyFormConfig=[
	                      {
	                    	  "field":"areaDisplay",
	                    	  "label":"省"
	                      },
	                     
	                      {
	                    	  "field":"cityDisplay",
	                    	  "label":"市"
	                      },
	                      {
	                    	  "field":"tvIdDisplay",
	                    	  "label":"杂志"
	                      },
	                      {
	                    	  "field":"advertTypeDisplay",
	                    	  "label":"版面"
	                      },
	                      {
	                    	  "field":"cjsj",
	                    	  "label":"创建时间"
	                      },
	                      {
	                    	  "field":"shztDisplay",
	                    	  "label":"审核状态"
	                      }
	                      ];
	var staticZzzyCurrentFormConfig=null;
	
	var staticZzzyGyygFormConfig=[
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                     
		                      {
		                    	  "field":"zk",
		                    	  "label":"折扣"
		                      }
		                      ];
	var staticBzzyXbmggFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"zk",
			                    	  "label":"折扣"
			                      }
			                      ];
	var staticZzzyRwFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"jg",
			                    	  "label":"价格(元/篇)"
			                      },
			                     
			                      {
			                    	  "field":"zk",
			                    	  "label":"折扣(折)"
			                      }
			                      ];
	var staticZzzyJyFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"dyjg",
			                    	  "label":"单页价格(元/份)"
			                      }
			                      ];
	var staticZzzyExtFormConfig=[
								{
									  "field":"sfxzhyDisplay",
									  "label":"行业要求"
								},
								{
									  "field":"hyDisplay",
									  "label":"具体行业"
								},
			                      {
			                    	  "field":"bcsm",
			                    	  "label":"补充说明",
			                      },
			                     
			                      {
			                    	  "field":"ggdlfsDisplay",
			                    	  "label":"广告代理方式"
			                      },{
			                    	  "field":"dlzslj",
			                    	  "label":"代理证书图片",
			                    	  "type":"img"
			                      },{
			                    	  "field":"sctulj",
			                    	  "label":"图片",
			                    	  "type":"img"
			                      }
			                     ];
	
		
	var tblColums=[//对应上面thead里面的序列
		             {"data": "companyName"},
		             {"data":"name"},
		             {"data": 'jg' },
		             {"data": 'cjsj' },
		             {"data": 'dst_display' },
		             {"data": 'ggxs_display' },
		             {"data": 'shzt_display' },
		             {"data": "","width":"160px",render:function(data2,type,full){
		            	 var _content="<div class='btn-group'>";
		            	 _content+="	<button data-key='"+full.wid+"' data-ggxs='"+full.advert_type+"' action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>详情</button>";
		            	 if(full.shzt=="1"){
			            	 _content+="	<button data-key='"+full.wid+"' data-ggxs='"+full.advert_type+"' action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>审核</button>";
			            }
		            	 _content+="	<button data-key='"+full.wid+"' data-ggxs='"+full.advert_type+"' action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
		            	 _content+="</div>";
		            	 
		            	 return _content;
		             }}
		         ];
	var queryParam=[{
						"field":"companyName",
						"control":"#queryForm [name='companyName']"
					},
					{
						"field":"name",
						"control":"#queryForm [name='name']"
					},
					{
						"field":"shzt",
						"control":"#queryForm [name='shzt']"
					}
	];
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=6",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/zzzyInfo/sh",
				hidden:[
				        	{name:"wid",
				        		value:key
				        	}
				        ],
						callback:function(){
							tbl.draw();
						}
			};
		createShModal(config);
	});
	$("#example").on("click","[action='detailRow']",function(){
		if($("#detailModal").length<=0){
			var _detailModalConfig={
				"title":"详情",
				"needBtn":false,
				"id":"detailModal",
				"content":"<div id='divZzzy'></div><div id='divZzzyOther'></div><div id='divZzzyExt'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/zzzyInfo/selectZzzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticZzzyFormConfig,data.datas);
			$("#divZzzy").html(_form);  
		});
		if(ggxs=="1"){
			staticZzzyCurrentFormConfig=staticZzzyGyygFormConfig;
		}else if(ggxs=="2"){
			staticZzzyCurrentFormConfig=staticZzzyRwFormConfig;
		}else if(ggxs=="3"){
			staticZzzyCurrentFormConfig=staticZzzyJyFormConfig;
		}
		doGet(basePath+"/zzzyInfo/selectZzzyOtherInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticZzzyCurrentFormConfig,data.datas);
			$("#divZzzyOther").html(_form);  
		});
		doGet(basePath+"/zzzyInfo/selectZzzyExtInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticZzzyExtFormConfig,data.datas);
			$("#divZzzyExt").html(_form);  
			if(data.datas.dlzslj){
			var imgUploader=new Uploader({id:"dlzsljDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)"});
				imgUploader.setValue(data.datas.dlzslj);
			}
			if(data.datas.sctulj){
				var imgUploader=new Uploader({id:"sctuljDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)"});
					imgUploader.setValue(data.datas.sctulj);
				}
		});
		
		$("#detailModal").modal("show");
		
		
//		doGet(basePath+"/bzzyInfo/selectBzzyOtherInfo","bzzyId="+key+"&ggxs="+ggxs,function(data){
//			var _form=createStaticForm(staticZzzyFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/zzzyInfo/delete","wid="+key+"&ggxs="+ggxs,function(){
				alert("删除成功！");
				tbl.draw();
			});
		});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});