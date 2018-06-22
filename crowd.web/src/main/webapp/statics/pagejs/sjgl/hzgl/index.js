/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/hzglEdit/index";
	});

	getPesronDllb(1,true);
	function getPesronDllb(pageNum,needPage){
		if(pageNum==undefined){
			pageNum=1;
		}
		doGet(basePath+"/hzglView/queryPersonList","pageNum="+pageNum,function(data){
			if(data && data.datas){
				if(needPage){
					$('#pageData').pagination({
						pageCount:data.pageInfo.totalPage,
					    showData:data.pageInfo.pageSize,
					    coping:true,
					    callback:function(api){
					    	var _cPage=api.getCurrent();
					    	getPesronDllb(_cPage,false);
					    }
					});
				}
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<tr>";
					html+="<td>"+toStr(_data.title)+"</td>";
					html+="<td>"+toStr(_data.kssj)+"</td>";
					html+="<td>"+toStr(_data.jssj)+"</td>";
					html+="<td>"+toStr(_data.shztDisplay)+"</td>";
				
					html+='<td><button  data-key="'+_data.wid+'" data-option="edit" class="btn btn-primary btn-xs" data-original-title="" title=""><i class="fa fa-pencil" data-original-title="" title=""></i></button>';
                    html+='<button   data-key="'+_data.wid+'" data-option="delete" class="btn btn-danger btn-xs" data-original-title="" title=""><i class="fa fa-trash-o " data-original-title="" title=""></i></button></td>';
					html+="</tr>";
				}
				$("#tblData").html(html);
				$("#tblData button").click(function(){
					var _option=$(this).attr("data-option");
					var _key=$(this).attr("data-key");
					if(_option=="view"){
						window.open(basePath+"/hzglView/view?wid="+_key);
					}else if(_option=="edit"){
						window.location.href=basePath+"/hzglEdit/index?wid="+_key;
					}else if(_option=="delete"){
						confirm("您确认删除该信息吗？",function(){
							doPost(basePath+"/hzglView/delete","wid="+_key,function(){
								alert("删除成功！");
								getPesronDllb(1,true);
							});
						})
					}
					
				});
			}
		})
	}
});