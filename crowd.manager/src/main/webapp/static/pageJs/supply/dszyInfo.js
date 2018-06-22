/**
 * 
 */
$(document).ready(function() {

	
	var staticDszyFormConfig=[
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
	var staticDszyCurrentFormConfig=null;
	
	var staticDszySdFormConfig=[
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                     
		                      {
		                    	  "field":"tvPdDisplay",
		                    	  "label":"时段频道"
		                      },
		                     
		                      {
		                    	  "field":"hjsdZk",
		                    	  "label":"黄金时段折扣(折)"
		                      }
		                      ,
			                     
		                      {
		                    	  "field":"fhjsdZk",
		                    	  "label":"非黄金时段折扣(折)"
		                      }
		                      ];
	var staticDszyLmFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"pdIdDisplay",
			                    	  "label":"栏目频道"
			                      },
			                      {
			                    	  "field":"dllmDisplay",
			                    	  "label":"代理栏目"
			                      },
			                      {
			                    	  "field":"qscZk",
			                    	  "label":"全时长折扣(折)"
			                      },
			                      {
			                    	  "field":"fiveZk",
			                    	  "label":"5秒(折)"
			                      },
			                      {
			                    	  "field":"tenZk",
			                    	  "label":"10秒(折)"
			                      },			                     
			                      {
			                    	  "field":"fiveteenZk",
			                    	  "label":"15秒(折)"
			                      },			                     
			                      {
			                    	  "field":"twentyZk",
			                    	  "label":"20秒(折)"
			                      },
			                      {
			                    	  "field":"thirtyZk",
			                    	  "label":"30秒(折)"
			                      }
			                      ];
	var staticDszyTbFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"bhpdDisplay",
			                    	  "label":"频道"
			                      },
			                     
			                      {
			                    	  "field":"bcsmBmDisplay",
			                    	  "label":"播出频率"
			                      },
			                     
			                      {
			                    	  "field":"fiveMoney",
			                    	  "label":"套播价格5秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"seventMoney",
			                    	  "label":"套播价格7.5秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"tenMoney",
			                    	  "label":"套播价格10秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"fifteenMoney",
			                    	  "label":"套播价格15秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"twentyMoney",
			                    	  "label":"套播价格20秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"twentyFiveMoney",
			                    	  "label":"套播价格25秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"thirtyMoney",
			                    	  "label":"套播价格30秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"fortyFiveMoney",
			                    	  "label":"套播价格45秒(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"sixtyMoney",
			                    	  "label":"套播价格60秒(元)"
			                      }
			                      ];
	var staticDszyZtFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"ztpdBmDisplay",
			                    	  "label":"专题频道"
			                      },
			                     
			                      {
			                    	  "field":"sjdBmDisplay",
			                    	  "label":"时间段"
			                      },
			                     
			                      {
			                    	  "field":"bcsc",
			                    	  "label":"播出时长(分钟)"
			                      },
			                     
			                      {
			                    	  "field":"ggjg",
			                    	  "label":"广告价格(元/分钟)"
			                      }
			                      ];
	
	var staticDszyGmFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"sspdBmDisplay",
			                    	  "label":"所属频道"
			                      },
			                     
			                      {
			                    	  "field":"sslmBmDisplay",
			                    	  "label":"所属栏目"
			                      },
			                     
			                      {
			                    	  "field":"bcpc",
			                    	  "label":"播出频次(次/月)"
			                      },
			                     
			                      {
			                    	  "fields":[
			                    	            {"field":"ggjgBmDisplay"},
			                    	            {"field":"ggjgMoney"},
			                    	            ],
			                    	  "label":"广告价格(元)"
			                      }
			                      ];
	
	var staticDszyZzFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"sspdBmDisplay",
			                    	  "label":"所属频道"
			                      },
			                     
			                      {
			                    	  "field":"sslmBmDisplay",
			                    	  "label":"所属栏目"
			                      },
			                     
			                      {
			                    	  "field":"bcpc",
			                    	  "label":"播出频次(次/月)"
			                      },
			                     
			                      {
			                    	  "fields":[
			                    	            {"field":"ggjgBmDisplay"},
			                    	            {"field":"ggjgMoney"},
			                    	            ],
			                    	  "label":"广告价格(元)"
			                      }
			                      ];
	var staticDszyExtFormConfig=[
								{
									  "field":"sfxzhy",
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=2",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/dszyInfo/sh",
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
				"content":"<div id='divDszy'></div><div id='divDszyOther'></div><div id='divDszyExt'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/dszyInfo/selectDszyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticDszyFormConfig,data.datas);
			$("#divDszy").html(_form);  
		});
		if(ggxs=="1"){
			staticDszyCurrentFormConfig=staticDszySdFormConfig;
		}else if(ggxs=="2"){
			staticDszyCurrentFormConfig=staticDszyLmFormConfig;
		}else if(ggxs=="3"){
			staticDszyCurrentFormConfig=staticDszyTbFormConfig;
		}else if(ggxs=="4"){
			staticDszyCurrentFormConfig=staticDszyZtFormConfig;
		}else if(ggxs=="5"){
			staticDszyCurrentFormConfig=staticDszyGmFormConfig;
		}
		else if(ggxs=="6"){
			staticDszyCurrentFormConfig=staticDszyZzFormConfig;
		}
		doGet(basePath+"/dszyInfo/selectDszyOtherInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticDszyCurrentFormConfig,data.datas);
			$("#divDszyOther").html(_form);  
		});
		doGet(basePath+"/dszyInfo/selectDszyExtInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticDszyExtFormConfig,data.datas);
			$("#divDszyExt").html(_form);  
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
//			var _form=createStaticForm(staticDszyFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
			confirm("确认删除吗？",function(){
				doPost(basePath+"/dszyInfo/delete","wid="+key+"&ggxs="+ggxs,function(){
					alert("删除成功！");
					tbl.draw();
				});
			});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});