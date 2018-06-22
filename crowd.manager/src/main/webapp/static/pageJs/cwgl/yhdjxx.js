/**
 * 
 */
$(document).ready(function(){
	var staticFormConfig=[
		                      {
		                    	  "field":"companyName",
		                    	  "label":"用户名称"
		                      },
		                     
		                      {
		                    	  "field":"djDisplay",
		                    	  "label":"当前会员级别"
		                      },
		                      {
		                    	  "field":"kssj",
		                    	  "label":"开始时间",
		                    	  "col":1
		                      },
		                      {
		                    	  "field":"jssj",
		                    	  "label":"结束时间"
		                      },
		                      {
		                    	  "field":"yhztDisplay",
		                    	  "label":"会员状态"
		                      }
		                      ];
	var queryParam=[{
		"field":"companyInfo.name",
		"control":"#queryForm [name='companyInfo.name']"
	},
	{
		"field":"yhzt",
		"control":"#queryForm [name='yhzt']"
	},{
		"field":"dj",
		"control":"#queryForm [name='dj']"
	}
];

var tblColums=[//对应上面thead里面的序列
	             {"data": "companyInfo.name"},
	             {"data":"djxx.name"},
	             {"data": 'kssj' },
	             {"data": 'jssj' },
	             {"data": 'yhztDisplay' },
	             {"data": "","width":"160px",render:function(data2,type,full){
	            	 var _content="<div class='btn-group'>";
	            	 _content+="	<button data-key='"+full.yhid+"'  action='detailRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-search'></i>充值记录</button>";
	            	 _content+="</div>";
	            	 
	            	 return _content;
	             }}
	         ];

var tblCzjlColums=[//对应上面thead里面的序列
    {"data": "nx"},
    {"data":"ddbh"},
    {"data": 'zfztDisplay' },
    {"data": 'djDisplay' },
    {"data": 'kssj' },
    {"data": 'jssj' },
    {"data": 'yxj' },
    {"data": 'hyje' },
    {"data": 'je' }
];
var tbl=createMyTable("#example",basePath+"/yhdjxxInfo/list",queryParam,tblColums);
var tblCzjl=null;
	$("#example").on("click","[action='detailRow']",function(){
		
		var key=$(this).attr("data-key");
//		doGet(basePath+"/qgInfo/select","wid="+key,function(data){
//			var _form=createStaticForm(staticFormConfig,data.datas);
//			$("#divBzzy").html(_form);  
//		});
		
		tblCzjl=createMyTable("#tblCzjl",basePath+"/yhdjxxInfo/listCzjl","yhid="+key,tblCzjlColums,{destroy:true});
		$("#modalCzjl").modal("show");
	});
	
	$("#btnQuery").click(function(){
		tbl.draw();
	});

});

