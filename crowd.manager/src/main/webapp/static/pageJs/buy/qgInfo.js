/**
 * 
 */
$(document).ready(function(){
	var staticFormConfig=[
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                     
		                      {
		                    	  "field":"jg",
		                    	  "label":"价格(元)"
		                      },
		                      {
		                    	  "field":"content",
		                    	  "label":"求购内容",
		                    	  "col":1
		                      },
		                      {
		                    	  "field":"xgsj",
		                    	  "label":"发布/刷新时间"
		                      },
		                      {
		                    	  "field":"shztDisplay",
		                    	  "label":"审核状态"
		                      }
		                      ];
	var queryParam=[{
		"field":"companyName",
		"control":"#queryForm [name='companyName']"
	},
	{
		"field":"name",
		"control":"#queryForm [name='name']"
	},{
		"field":"shzt",
		"control":"#queryForm [name='shzt']"
	}
];

var tblColums=[//对应上面thead里面的序列
	             {"data": "companyName"},
	             {"data":"name"},
	             {"data": 'jg' },
	             {"data": 'xgsj' },
	             {"data": 'shztDisplay' },
	             {"data": "","width":"160px",render:function(data2,type,full){
	            	 var _content="<div class='btn-group'>";
	            	 _content+="	<button data-key='"+full.wid+"'  action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>详情</button>";
	            	 if(full.shzt=="1"){
		            	 _content+="	<button data-key='"+full.wid+"'  action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>审核</button>";
		            }
	            	 _content+="	<button data-key='"+full.wid+"'  action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
	            	 _content+="</div>";
	            	 
	            	 return _content;
	             }}
	         ];

var tbl=createMyTable("#example",basePath+"/qgInfo/list",queryParam,tblColums);

$("#example").on("click","[action='shRow']",function(){
	var key=$(this).attr("data-key");
	var config={
			url:basePath+"/qgInfo/sh",
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
				"content":"<div id='divBzzy'></div>"
			};
			
			var detailMode=createModal(_detailModalConfig,null,2);
			$("body").append(detailMode);
			
		}
		var key=$(this).attr("data-key");
		doGet(basePath+"/qgInfo/select","wid="+key,function(data){
			var _form=createStaticForm(staticFormConfig,data.datas);
			$("#divBzzy").html(_form);  
		});
		$("#detailModal").modal("show");
	});
	
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		var ggxs=$(this).attr("data-ggxs");
			confirm("确认删除吗？",function(){
				doPost(basePath+"/qgInfo/delete","wid="+key+"&ggxs="+ggxs,function(){
					alert("删除成功！");
					tbl.draw();
				});
			});
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});

});

