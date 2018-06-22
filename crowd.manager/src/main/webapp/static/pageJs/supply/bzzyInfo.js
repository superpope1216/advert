/**
 * 
 */
$(document).ready(function() {

	
	var staticBzzyFormConfig=[
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
	                    	  "label":"报纸"
	                      },
	                      {
	                    	  "field":"advertTypeDisplay",
	                    	  "label":"广告形式"
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
	var staticBzzyCurrentFormConfig=null;
	
	var staticBzzyGyygFormConfig=[
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                     
		                      {
		                    	  "field":"lxDisplay",
		                    	  "label":"类型"
		                      },
		                     
		                      {
		                    	  "field":"ccK",
		                    	  "label":"尺寸(宽)"
		                      }
		                      ,
			                     
		                      {
		                    	  "field":"ccG",
		                    	  "label":"尺寸(高)"
		                      },
			                     
		                      {
		                    	  "field":"kljg",
		                    	  "label":"刊例价格(元)"
		                      }
		                      ,
			                     
		                      {
		                    	  "field":"xxjg",
		                    	  "label":"销售价格(元)"
		                      },
			                     
		                      {
		                    	  "field":"bwms",
		                    	  "label":"版位描述"
		                      },
			                     
		                      {
		                    	  "field":"ysDisplay",
		                    	  "label":"颜色"
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
	var staticBzzyRwFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"btjg",
			                    	  "label":"标题价格(元)"
			                      },
			                     
			                      {
			                    	  "field":"zwjg",
			                    	  "label":"正文价格(元)"
			                      },
			                     
			                      {
			                    	  "field":"zwzsxz",
			                    	  "label":"正文字数限制"
			                      }
			                      ];
	var staticBzzyJyFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"dyjg",
			                    	  "label":"单页价格(元/份)"
			                      }
			                      ];
	var staticBzzyExtFormConfig=[
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=4",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/bzzyInfo/sh",
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
				"content":"<div id='divBzzy'></div><div id='divBzzyOther'></div><div id='divBzzyExt'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/bzzyInfo/selectBzzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticBzzyFormConfig,data.datas);
			$("#divBzzy").html(_form);  
		});
		if(ggxs=="1"){
			staticBzzyCurrentFormConfig=staticBzzyGyygFormConfig;
		}else if(ggxs=="2"){
			staticBzzyCurrentFormConfig=staticBzzyGyygFormConfig;
		}else if(ggxs=="3"){
			staticBzzyCurrentFormConfig=staticBzzyRwFormConfig;
		}else if(ggxs=="4"){
			staticBzzyCurrentFormConfig=staticBzzyJyFormConfig;
		}
		doGet(basePath+"/bzzyInfo/selectBzzyOtherInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticBzzyCurrentFormConfig,data.datas);
			$("#divBzzyOther").html(_form);  
		});
		doGet(basePath+"/bzzyInfo/selectBzzyExtInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticBzzyExtFormConfig,data.datas);
			$("#divBzzyExt").html(_form);  
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
//			var _form=createStaticForm(staticBzzyFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
			confirm("确认删除吗？",function(){
				doPost(basePath+"/bzzyInfo/delete","wid="+key+"&ggxs="+ggxs,function(){
					alert("删除成功！");
					tbl.draw();
				});
			});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});