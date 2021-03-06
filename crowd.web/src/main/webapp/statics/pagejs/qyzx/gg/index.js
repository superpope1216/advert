/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/qyzxGgEdit/index";
	});
	getPesronDllb(1,true);
	function getPesronDllb(pageNum,needPage){
		if(pageNum==undefined){
			pageNum=1;
		}
		doGet(basePath+"/qyzxGgView/queryPersonList","pageNum="+pageNum,function(data){
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
					html+="<td>"+toStr(_data.shztDisplay)+"</td>";
					html+="<td>";
						html+='<button type="button" data-option="edit" data-key="'+_data.wid+'" class="btn btn-primary btn-xs"><i class="fa fa-pencil" data-original-title="" title=""></i></button>';
						html+='<button type="button" data-option="delete" data-key="'+_data.wid+'" class="btn btn-danger btn-xs"><i class="fa fa-trash-o " data-original-title="" title=""></i></button>';
					
					
					html+="</td>";
					html+="</tr>";
				}
				$("#tblData").html(html);
				$("#tblData button").click(function(){
					var _option=$(this).attr("data-option");
					var _key=$(this).attr("data-key");
					if(_option=="view"){
						window.open(basePath+"/qyzxGgView/view?wid="+_key);
					}else if(_option=="edit"){
						window.location.href=basePath+"/qyzxGgEdit/index?wid="+_key;
					}else if(_option=="delete"){
						confirm("您确认删除该信息吗？",function(){
							doPost(basePath+"/qyzxGgView/delete","wid="+_key,function(){
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