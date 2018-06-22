/**
 * 
 */
$(document).ready(function() {

	
	var staticWlzyFormConfig=[
	                      {
	                    	  "field":"addr",
	                    	  "label":"网站地址"
	                      },
	                     
	                      {
	                    	  "field":"name",
	                    	  "label":"资源名称"
	                      },
	                      {
	                    	  "field":"ggwzDisplay",
	                    	  "label":"广告位置"
	                      },
	                      {
	                    	  "field":"wzms",
	                    	  "label":"位置描述"
	                      },
	                      {
	                    	  
	                    	  "fields":[{
	                    		"field":"zsxtDisplay"  
	                    	  },{"field":"zsfsDisplay"}],
	                    	  "label":"展示形态"
	                      },
	                      {
	                    	  "field":"zsccDisplay",
	                    	  "label":"尺寸"
	                      },{
	                    	  "field":"jffsDisplay",
	                    	  "label":"计费方式"
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
	var staticWlzyCurrentFormConfig=null;
	
	var staticWlzyScjfFormConfig=[
		                      {
		                    	  "field":"hourKlj",
		                    	  "label":"刊例价(元/小时)"
		                      },
		                     
		                      {
		                    	  "field":"hourXsj",
		                    	  "label":"销售价(元/小时)"
		                      },
		                      {
		                    	  "field":"dayKlj",
		                    	  "label":"刊例价(元/天)"
		                      },
		                     
		                      {
		                    	  "field":"dayXsj",
		                    	  "label":"销售价(元/天)"
		                      },
		                      {
		                    	  "field":"weekKlj",
		                    	  "label":"刊例价(元/周)"
		                      },
		                     
		                      {
		                    	  "field":"weekXsj",
		                    	  "label":"销售价(元/周)"
		                      },
		                      {
		                    	  "field":"halfMonthKlj",
		                    	  "label":"刊例价(元/半月)"
		                      },
		                     
		                      {
		                    	  "field":"halfMonthXsj",
		                    	  "label":"销售价(元/半月)"
		                      },
		                      {
		                    	  "field":"monthKlj",
		                    	  "label":"刊例价(元/月)"
		                      },
		                     
		                      {
		                    	  "field":"monthXsj",
		                    	  "label":"销售价(元/月)"
		                      },
		                      {
		                    	  "field":"jdKlj",
		                    	  "label":"刊例价(元/季度)"
		                      },
		                     
		                      {
		                    	  "field":"jdXsj",
		                    	  "label":"销售价(元/季度)"
		                      },
		                      {
		                    	  "field":"halfYearKlj",
		                    	  "label":"刊例价(元/半年)"
		                      },
		                     
		                      {
		                    	  "field":"halfYeafXsj",
		                    	  "label":"销售价(元/半年)"
		                      },
		                      {
		                    	  "field":"yearKlj",
		                    	  "label":"刊例价(元/年)"
		                      },
		                     
		                      {
		                    	  "field":"yeafXsj",
		                    	  "label":"销售价(元/年)"
		                      }
		                      ];
	var staticWlzyCpmFormConfig=[
			                      {
			                    	  "field":"cpmKlj",
			                    	  "label":"刊例价(每千次展示)"
			                      },
			                     
			                      {
			                    	  "field":"cpmXsj",
			                    	  "label":"销售价(每千次展示)"
			                      }
			                      ];
	var staticWlzyCpcFormConfig=[
			                      {
			                    	  "field":"cpcKlj",
			                    	  "label":"刊例价(每有效点击)"
			                      },
			                     
			                      {
			                    	  "field":"cpcXsj",
			                    	  "label":"销售价(每有效点击)"
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
	var tbl=createMyTable("#example",basePath+"/supplyInfo/getList?gglx=7",queryParam,tblColums);
	
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		var config={
				url:basePath+"/wlzyInfo/sh",
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
				"content":"<div id='divWlzy'></div><div id='divWlzyjffx'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig);
			$("body").append(detailMode);
		}
		
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
		doGet(basePath+"/wlzyInfo/selectWlzyInfo","wid="+key+"&ggxs="+ggxs,function(data){
			var _form1=createStaticForm(staticWlzyFormConfig,data.datas);
			$("#divWlzy").html(_form1);
			if(data.datas.jffs){
				if(data.datas.jffs=="1"){
					var _form2=createStaticForm(staticWlzyScjfFormConfig,data.datas);
					$("#divWlzyjffx").html(_form2);
				}else if(data.datas.jffs=="2"){
					var _form2=createStaticForm(staticWlzyCpmFormConfig,data.datas);
					$("#divWlzyjffx").html(_form2);
				}else if(data.datas.jffs=="3"){
					var _form2=createStaticForm(staticWlzyCpcFormConfig,data.datas);
					$("#divWlzyjffx").html(_form2);
				}
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
		confirm("确认删除吗？",function(){
			doPost(basePath+"/wlzyInfo/delete","wid="+key,function(){
				alert("删除成功！");
				tbl.draw();
			});
		});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});
});