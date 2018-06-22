/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/buyQgPublishing/index";
	});
	queryList();
	
	$("#tblData").on("click","button[data-option='edit']",function(){
		var key=$(this).attr("data-key");
		window.location.href=basePath+"/buyQgPublishing/index?wid="+key;
		
	});
	$("#tblData").on("click","button[data-option='delete']",function(){
		var key=$(this).attr("data-key");
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/buyQg/delete","wid="+key,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
	});
	function queryList(){
		doGet(basePath+"/buyQg/list","",function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<tr>";
					html+="<td>"+_data.name+"</td>";
					html+="<td>"+_data.jg+"</td>";
					html+="<td>"+_data.xgsj+"</td>";
					html+="<td>"+_data.shztDisplay+"</td>";
					html+='<td><button  data-key="'+_data.wid+'" data-option="edit" class="btn btn-primary btn-xs" data-original-title="" title=""><i class="fa fa-pencil" data-original-title="" title=""></i></button>';
                    html+='<button   data-key="'+_data.wid+'" data-option="delete" class="btn btn-danger btn-xs" data-original-title="" title=""><i class="fa fa-trash-o " data-original-title="" title=""></i></button></td>';
					html+="</tr>";
				}
				$("#tblData").html(html);
			}
		});
	}
});