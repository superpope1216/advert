/**
 * 
 */
$(document).ready(function() {

	
	var staticXmtzyFormConfig=[
	                      
	                     
	                      {
	                    	  "field":"name",
	                    	  "label":"资源名称"
	                      },
	                      {
	                    	  "field":"advertTypeDisplay",
	                    	  "label":"新媒体类型"
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
	                    	  "field":"ggjg",
	                    	  "label":"广告价格(元/单位)"
	                      },{
	                    	  "field":"ggggxs",
	                    	  "label":"广告规格形式"
	                      },
	                      
	                      {
	                    	  "field":"szrqDisplay",
	                    	  "label":"受众人群"
	                      },
	                      {
	                    	  "field":"jycdDisplay",
	                    	  "label":"教育程度"
	                      },
	                      {
	                    	  "field":"zyfbDisplay",
	                    	  "label":"职业分布"
	                      },
	                      {
	                    	  "field":"srzkDisplay",
	                    	  "label":"收入状况"
	                      },
	                      {
	                    	  "field":"xmtjj",
	                    	  "label":"新媒体简介"
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=5",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/xmtzyInfo/sh",
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
				"content":"<div id='divXmtzy'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/xmtzyInfo/selectXmtzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form1=createStaticForm(staticXmtzyFormConfig,data.datas);
			$("#divXmtzy").html(_form1);
		});
		
		$("#detailModal").modal("show");
		
		
//		doGet(basePath+"/bzzyInfo/selectBzzyOtherInfo","bzzyId="+key+"&ggxs="+ggxs,function(data){
//			var _form=createStaticForm(staticBzzyFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("确认删除吗？",function(){
			doPost(basePath+"/xmtzyInfo/delete","wid="+key,function(){
				alert("删除成功！");
				tbl.draw();
			});
		});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});