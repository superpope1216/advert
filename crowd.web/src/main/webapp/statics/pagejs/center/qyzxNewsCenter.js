/**
 * 
 */

$(document).ready(function(){
	getDllb(1,true);
	function getDllb(pageNum,needPage){
		if(pageNum==undefined){
			pageNum=1;
		}
		doGet(basePath+"/qyzxNews/getList","pageNum="+pageNum,function(data){
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
			
					html+='			<div class="left-bolck col-xs-9 col-sm-9">';
					html+='				<div class="info-body">';
					html+='					<div class="info-body-title">';
					html+='						<a href="'+basePath+'/qyzxNewsDetail/index?wid='+_data.wid+'" target="_blank"	class="info-body-title-name">';
					html+='							<span class="number-title">';
					html+='								<span class="">'+_data.title+'</span>';
					html+='							</span>';
					//html+='						<span class="tsxx tsxx-red">'+_data.sjlxDisplay+'</span>';
					html+='						</a>';
					html+='					</div>';
//					html+='				<div class="content1">';
//					html+='					<span>'+_data.content+'<span>';
//					html+='				</div>';
					
					
					html+='				<div class="time-content">';
					html+='					<span> <!-- react-text: 421 -->发布人：'+_data.companyName+'<!-- /react-text -->';
					html+='						<!-- react-text: 422 -->发布<!-- /react-text -->';
					html+='					</span>';
					html+='					<span> <!-- react-text: 421 -->发布时间：'+_data.xgsj+'<!-- /react-text -->';
					html+='						<!-- react-text: 422 -->发布<!-- /react-text -->';
					html+='					</span>';
					html+=' 			</div>';
					html+='				</div>';
					
					html+='			</div>';
					html+='		</div>';
					html+='</div>';
				}
				if(html==""){
					html='<div class="h-200 vertical-align text-xs-center order-null animation-fade"><div class="vertical-align-middle font-size-18 blue-grey-500">没有符合条件的需求</div></div>';
				}
				$("#divContent").html(html);
			}
		});
		
		
		
	}
	
});