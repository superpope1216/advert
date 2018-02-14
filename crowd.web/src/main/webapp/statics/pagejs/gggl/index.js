/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/dszyPublishing/index";
	});
	queryList();
	function queryList(){
		doGet(basePath+"/supplyView/list","condition=",function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<tr>";
					html+="<td>"+_data.gglx_display+"</td>";
					html+="<td>"+_data.name+"</td>";
					html+="<td>"+getDszyMoney(_data)+"</td>";
					
					
					html+="<td>"+_data.cjsj+"</td>";
					html+="<td>"+_data.dst_display+"</td>";
					html+="<td>"+_data.ggxs_display+"</td>";
					html+="<td>"+_data.shzt_display+"</td>";
					html+="<td>"+0+"</td>";
					html+='<td><button data-key="'+_data.wid+'" data-option="edit" class="btn btn-primary btn-xs" data-original-title="" title=""><i class="fa fa-pencil" data-original-title="" title=""></i></button>';
                    html+='<button  data-key="'+_data.wid+'" data-option="delete" class="btn btn-danger btn-xs" data-original-title="" title=""><i class="fa fa-trash-o " data-original-title="" title=""></i></button></td>';
					html+="</tr>";
				}
				$("#tblData").html(html);
			}
		});
	}
});