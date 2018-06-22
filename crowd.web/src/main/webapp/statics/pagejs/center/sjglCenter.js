/**
 * 
 */

$(document).ready(function(){
	//$('.dataStatistics').dataStatistics({min:100,max:1500,time:30000,len:6});
	
	$("#paralist a").click(function(){
		var data_option=$(this).attr("data-option");
		$("#paralist a[data-option='"+data_option+"']").removeClass("queryActive");
		$(this).addClass("queryActive");
		getDllb(1,true);
	});
	if(sjlx){
		$("#ddGgxs span a").removeClass("queryActive");
		$("#ddGgxs span a[data-key='"+sjlx+"']").addClass("queryActive");
		
	}
	getDllb(1,true);
	function getDllb(pageNum,needPage){
		if(pageNum==undefined){
			pageNum=1;
		}
		var _sjlx=$("#paralist a.queryActive").attr("data-key");
		doGet(basePath+"/sjglCenter/queryAllList","pageNum="+pageNum+"&sjlx="+_sjlx,function(data){
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
					html+='	<div class="child">';
					html+='		<div class="left-bolck">';
					html+='			<div class="info-body">';
					html+='				<div class="info-body-title">';
					html+='					<a href="'+basePath+'/sjglDetail/index?wid='+_data.wid+'&sjlx='+_data.sjlx+'" target="_blank"	class="info-body-title-name">';
				
					html+='						<span class="number-title">';
					html+='							<span class="">'+_data.title+'</span>';
					html+='						</span>';
					html+='						<span class="tsxx tsxx-red">'+_data.sjlxDisplay+'</span>';
					html+='					</a>';
//					html+='					<span class="pull-right">';
//					html+='						<span	class="price"><span>预算：'+toStr(_data.jg,0)+'元</span></span>';
//					html+='					</span>';
					html+='				</div>';
					html+='			<div>';
					html+='			<div class="content1">';
					html+='				<label>主题简介：</label><span>'+toStr(_data.ztnr)+'</span>';
					html+='			</div>';
					
					html+='		</div>';
					html+='		<div class="time-content">';
					html+='			<span> <!-- react-text: 421 -->发布人：'+_data.companyName+'<!-- /react-text -->';
					html+='				<!-- react-text: 422 --><!-- /react-text -->';
					html+='			</span>';
					html+='			<span> <!-- react-text: 421 -->发布时间：'+_data.cjsj+'<!-- /react-text -->';
					html+='				<!-- react-text: 422 --><!-- /react-text -->';
					html+='			</span>';
					html+=' 	</div>';
					html+='	</div>';
					html+='</div>';
					html+='	</div>';
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