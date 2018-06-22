/**
 * 
 */
$(document).ready(function() {

	
	var staticHwzyFormConfig1=[
							{
								  "field":"name",
								  "label":"标题",
								  "col":1
							},
							{
								  "field":"advertTypeDisplay",
								  "label":"媒体类型",
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
	                    	  "field":"tvIdDisplay",
	                    	  "label":"媒体信息"
	                      },
	                      
	                      {
	                    	  "field":"qyDisplay",
	                    	  "label":"区域"
	                      },{
	                    	  "field":"xsDisplay",
	                    	  "label":"形式"
	                      },
	                      
	                      {
	                    	  "field":"mtcz",
	                    	  "label":"媒体材质"
	                      },
	                      {
	                    	  "field":"cjsj",
	                    	  "label":"创建时间"
	                      },
	                      {
	                    	  "field":"shztDisplay",
	                    	  "label":"审核状态",
	                    	  "col":1
	                      }
	                      ];
	
	var staticHwzyFormConfig2=[
								{
									  "field":"gjcll",
									  "label":"估计人流量(万人次/天 )"
								},
								{
									  "field":"gjrll",
									  "label":"估计车流量(万车次/天)",
								},
								
		                      {
		                    	  "field":"mtggK",
		                    	  "label":"户外媒体规格(宽)"
		                      },
		                      {
		                    	  "field":"mtggG",
		                    	  "label":"户外媒体规格(高)"
		                      },
		                      {
		                    	  "field":"mtggM",
		                    	  "label":"户外媒体规格(面)"
		                      },
		                      {
		                    	  "field":"mtggPfm",
		                    	  "label":"户外媒体规格(平方米)"
		                      },
		                      
		                      {
		                    	  "field":"zxjgMonth",
		                    	  "label":"执行价格(元/月)"
		                      },{
		                    	  "field":"zxjgYear",
		                    	  "label":"执行价格(元/年)"
		                      },
		                      
		                      {
		                    	  "field":"zmsjDisplay",
		                    	  "label":"照明时间",
		                    	  "col":1
		                      }
		                      ];
	var staticHwzyFormConfig3=[
								{
									  "field":"mtztDisplay",
									  "label":"媒体状态"
								},
								{
									  "field":"zxtfzqDisplay",
									  "label":"最小投放周期",
								},
								
		                      {
		                    	  "field":"zztfrq",
		                    	  "label":"最早投放时间"
		                      },
		                      {
		                    	  "field":"ssqdqr",
		                    	  "label":"所有权到期日"
		                      },
		                      {
		                    	  "field":"zxtfsl",
		                    	  "label":"最小投放数量(个)"
		                      },
		                      {
		                    	  "field":"ggsyqzk",
		                    	  "label":"广告所有权状况"
		                      },
		                      
		                      {
		                    	  "field":"hwgljj",
		                    	  "label":"户外广告简介",
		                    	  "col":1
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=1",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/hwzyInfo/sh",
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
				"content":"<div id='divHwzy1'></div><div id='divHwzy2'></div><div id='divHwzy3'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/hwzyInfo/selectHwzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form1=createStaticForm(staticHwzyFormConfig1,data.datas);
			$("#divHwzy1").html(_form1);
			var _form2=createStaticForm(staticHwzyFormConfig2,data.datas);
			$("#divHwzy2").html(_form2);
			var _form3=createStaticForm(staticHwzyFormConfig3,data.datas);
			$("#divHwzy3").html(_form3);
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
			doPost(basePath+"/hwzyInfo/delete","wid="+key,function(){
				alert("删除成功！");
				tbl.draw();
			});
		});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});