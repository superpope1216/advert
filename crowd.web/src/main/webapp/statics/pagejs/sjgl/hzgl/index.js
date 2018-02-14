/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/hzglEdit/index";
	});
	$(".nav-tabs-line a").click(function(){
		var _key=$(this).attr("data-key");
		if(_key=="1"){
			$("#divDllb").show();
			$("#divWddl").hide();
		}else{
			$("#divDllb").hide();
			$("#divWddl").show();
		}
	});
	getDllb(1,true);
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
					html+="<td>0</td>";
					html+="<td>";
					html+='<button type="button" data-option="view" data-key="'+_data.wid+'" class="btn btn-link">详情</button>';
					if(_data.shzt==0 || _data.shzt==3){
						html+='|<button type="button" data-option="edit" data-key="'+_data.wid+'" class="btn btn-link">编辑</button>';
						html+='|<button type="button" data-option="delete" data-key="'+_data.wid+'" class="btn btn-link">删除</button>';
					}
					
					html+="</td>";
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
	function getDllb(pageNum,needPage){
		if(pageNum==undefined){
			pageNum=1;
		}
		doGet(basePath+"/hzglView/queryAllList","pageNum="+pageNum,function(data){
			if(data && data.datas){
				if(needPage){
					$('#pageContent').pagination({
						pageCount:data.pageInfo.totalPage,
					    showData:data.pageInfo.pageSize,
					    coping:true,
					    callback:function(api){
					    	var _cPage=api.getCurrent();
					    	getDllb(_cPage,false);
					    }
					});
				}
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<div class="center-left-body-block">';
					html+='		<div class="child">';
					html+='			<div class="img-div col-xs-2 col-sm-2">';
					html+='				<a href="'+basePath+'/hzglView/view?wid='+_data.wid+'" target="_blank" style="display:block;">';
					html+='					<img class="img-responsive" src="'+basePath+'/statics/images/home/emap.png">';
					html+='				</a>';
					html+='			</div>';
					html+='			<div class="left-bolck col-xs-9 col-sm-9">';
					html+='				<div class="info-body">';
					html+='					<div class="info-body-title">';
					html+='						<a href="'+basePath+'/hzglView/view?wid='+_data.wid+'" target="_blank"	class="info-body-title-name">';
					html+='							<span class="number-title">';
					html+='								<span class="">'+_data.title+'</span>';
					html+='							</span>';
					html+='						</a>';
					html+='					</div>';
					html+='				</div>';
					html+='				<div class="content1">';
					html+='					<span>'+_data.ztnr+'<span>';
					html+='				</div>';
					
					
					html+='				<div class="time-content">';
					html+='					<span> <!-- react-text: 421 -->'+_data.cjsj+'<!-- /react-text -->';
					html+='						<!-- react-text: 422 -->发布<!-- /react-text -->';
					html+='					</span>';
					html+='					<!-- react-text: 423 -->|<!-- /react-text -->';
					html+='					<span> <!-- react-text: 425 -->100<!-- /react-text -->';
					html+='						<!-- react-text: 426 --> 人阅读<!-- /react-text -->';
					html+='					</span>';
					html+=' 			</div>';
					html+='			</div>';
					html+='		</div>';
					html+='</div>';
				}
				$("#divContent").html(html);
			}
		});
		
		
		
	}
});