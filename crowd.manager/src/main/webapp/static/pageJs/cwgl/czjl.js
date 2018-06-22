/**
 * 
 */
$(document).ready(function(){
	var queryParam=[{
		"field":"companyName",
		"control":"#queryForm [name='companyName']"
	},
	{
		"field":"zfzt",
		"control":"#queryForm [name='zfzt']"
	},{
		"field":"dj",
		"control":"#queryForm [name='dj']"
	}
];


var tblCzjlColums=[//对应上面thead里面的序列
    {"data": "nx"},
    {"data":"ddbh"},
    {"data": 'zfztDisplay' },
    {"data": 'djDisplay' },
    {"data": 'kssj' },
    {"data": 'jssj' },
    {"data": 'yxj' },
    {"data": 'je' },
    {"data": 'je' }
];
var tbl=createMyTable("#example",basePath+"/czjlInfo/list",queryParam,tblCzjlColums);
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

