/**
 * 
 */
$(document).ready(function() {

	
	var staticGbzyFormConfig=[
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
	                    	  "label":"广播电台"
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
	var staticGbzyCurrentFormConfig=null;
	
	var staticGbzySdFormConfig=[
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                     
		                      {
		                    	  "field":"gbpdBmDisplay",
		                    	  "label":"时段频道"
		                      },
		                     
		                      {
		                    	  "field":"zk",
		                    	  "label":"折扣"
		                      }
		                      ];
	var staticGbzyQtFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                      {
			                    	  "field":"gbpdBmDisplay",
			                    	  "label":"广播频道"
			                      },
			                      {
			                    	  "field":"ztMoney",
			                    	  "label":"专题折扣(折)"
			                      }
			                      ,
			                      {
			                    	  "field":"lbMoney",
			                    	  "label":"联播折扣(折)"
			                      }
			                      ,
			                      {
			                    	  "field":"gmMoney",
			                    	  "label":"冠名折扣(折)"
			                      },
			                      {
			                    	  "field":"tyMoney",
			                    	  "label":"特约折扣(折)"
			                      },
			                      {
			                    	  "field":"zdbsMoney",
			                    	  "label":"整点报时折扣(折)"
			                      }
			                      ];
	
	var staticGbzyExtFormConfig=[
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=3",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/gbzyInfo/sh",
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
				"content":"<div id='divGbzy'></div><div id='divGbzyOther'></div><div id='divGbzyExt'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/gbzyInfo/selectGbzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticGbzyFormConfig,data.datas);
			$("#divGbzy").html(_form);  
		});
		if(ggxs=="1"){
			staticGbzyCurrentFormConfig=staticGbzySdFormConfig;
		}else if(ggxs=="2"){
			staticGbzyCurrentFormConfig=staticGbzyQtFormConfig;
		}
		doGet(basePath+"/gbzyInfo/selectGbzyOtherInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticGbzyCurrentFormConfig,data.datas);
			$("#divGbzyOther").html(_form);  
		});
		doGet(basePath+"/gbzyInfo/selectGbzyExtInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticGbzyExtFormConfig,data.datas);
			$("#divGbzyExt").html(_form);  
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
//			var _form=createStaticForm(staticGbzyFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
			confirm("确认删除吗？",function(){
				doPost(basePath+"/gbzyInfo/delete","wid="+key+"&ggxs="+ggxs,function(){
					alert("删除成功！");
					tbl.draw();
				});
			});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});