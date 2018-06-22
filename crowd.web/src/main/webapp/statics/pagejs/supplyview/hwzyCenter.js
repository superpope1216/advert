/**
 * 
 */

$(document).ready(function(){
	//$('.dataStatistics').dataStatistics({min:100,max:1500,time:30000,len:6});
	/**
	$(".column-side li a[data-toggle='collapse']").click(function() {
		if($(this).find("i.icon").hasClass("wb-chevron-down")){
			
			
			$(this).find("i.icon").removeClass("wb-chevron-down").addClass("wb-chevron-up");
		}else{
			$(this).find("i.icon").removeClass("wb-chevron-up").addClass("wb-chevron-down");
		}
	});
	*/
	

	$("#btnQueryShow").click(function(){
		if($("#dlArea").css("display")=="none"){
			$("#dlArea").show();
			if($("#ddArea a.queryActive").size()>0){
				$("#divQueryCity").show();
			}
			if($("#ddCity a.queryActive").size()>0){
				$("#divQueryDst").show();
			}
			
		}else{
			$("#dlArea").hide();
			$("#divQueryCity").hide();
			$("#divQueryDst").hide();
		}
	});
	
	$("#ddGgxs a").click(function(){
		$("#ddGgxs a").removeClass("queryActive");
		$(this).addClass("queryActive");
		queryRwjbxx(getParam(1));
	});
	
	$("#ddArea a").click(function(){
		var _areaBm=$(this).attr("data-key");
		$("#ddArea a").removeClass("queryActive");
		$(this).addClass("queryActive");
		doGet(basePath+"/dictionary/selectCity","parentBm="+_areaBm,function(data){
			if(data && data.datas){
				var html="";
				html+='<span style="width:180px;"><a class="btn queryActive link" href="javascript:void(0);" data-option="city"  title="全部"	data-key="">全部</a></span>';
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<span style="width:180px;"><a class="btn link" href="javascript:void(0);" data-option="city"  title="'+_data.lbmc+'"	data-key="'+_data.lbdm+'">'+_data.lbmc+'</a></span>';
				}
				
				$("#ddCity").html(html);
				$("#divQueryCity").show();
			}
		});
		$("#divQueryDst").html("");
		queryRwjbxx(getParam(1));
	});
	
	$("#ddCity").on("click","a",function(){
		var _areaBm=$(this).attr("data-key");
		$("#divQueryCity a").removeClass("queryActive");
		$(this).addClass("queryActive");
		doGet(basePath+"/dictionary/selectCity","parentBm="+_areaBm,function(data){
			if(data && data.datas){
				var html="";
				html+='<span style="width:180px;"><a class="btn queryActive link" href="javascript:void(0);" data-option="dst"  title="全部"	data-key="">全部</a></span>';
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<span style="width:180px;"><a class="btn link" href="javascript:void(0);"  data-option="dst" title="'+_data.lbmc+'"	data-key="'+_data.lbdm+'">'+_data.lbmc+'</a></span>';
				}
				
				$("#ddDst").html(html);
				if(html){
					$("#divQueryDst").show();
				}else{
					$("#divQueryDst").hide();
				}
			}else{
				$("#divQueryDst").hide();
			}
		});
		queryRwjbxx(getParam(1));
	});
	$("#ddDst").on("click","a",function(){
		var _dst=$(this).attr("data-key");
		$("#ddDst a").removeClass("queryActive");
		$(this).addClass("queryActive");
		queryRwjbxx(getParam(1));
		
	});
	$("#header_navbar").css("margin-left",($("#mycontainer").width()-$("#header_navbar").width())/2)
	
	
	function getParam(pageNum,pageSize){
		var param="ggxs="+toStr($("#paralist a[data-option='ggxs'].queryActive").attr("data-key"));
		param+="&areaBm="+toStr($("#paralist a[data-option='area'].queryActive").attr("data-key"));
		param+="&cityBm="+toStr($("#paralist a[data-option='city'].queryActive").attr("data-key"));
		param+="&xianBm="+toStr($("#paralist a[data-option='dst'].queryActive").attr("data-key"));
		if(pageSize){
			param+="&pageSize="+pageSize;
		}
		if(pageNum){
			param+="&startPage="+pageNum;
		}
		
		return param;
	}
	function setTimeValue(value){
		
	};
	
	if(queryGgxs){
		$("#ddGgxs span a").removeClass("queryActive");
		$("#ddGgxs span a[data-key='"+queryGgxs+"']").addClass("queryActive");
		
	}
	
	queryRwjbxx(getParam(1));
	function queryRwjbxx(param){
		doGet(basePath+"/supplyHwzyCenter/list",param,function(data){
			var html="";
			if(data && data.datas){
				$('.mypaging2').pagination({
					pageCount:data.pageInfo.totalPage,
				    showData:data.pageInfo.pageSize,
				    coping:true,
				    callback:function(api){
				    	var _cPage=api.getCurrent();
				    	queryRwjbxx(getParam(_cPage));
				    }
				});
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					var jg=getDszyMoney(_data);
//					var xmje=_data.xmysje;
//					if(_data.zbje){
//						xmje=_data.zbje;
//					}
//					if(_data.ptbzje){
//						xmje=xmje+_data.ptbzje;
//					}
//					var _jd=""
//					if(_data.rwjd=="1"){
//						_jd="tsxx-green";
//					}else if(_data.rwjd=="2"){
//						_jd="tsxx-red";
//					}else if( _data.rwjd=="3" || _data.rwjd=="4"){
//						_jd="tsxx-blue";
//					}else{
//						_jd="tsxx-gray";
//					}
					var imgSrc=basePath+"/image/preView?wid="+_data.IMGID;
					html+='<div class="center-left-body-block">';
					html+='		<div class="child">';
					html+='			<div class="img-div col-xs-2 col-sm-2">';
					html+='				<a href="'+basePath+'/supplyHwzyDetail/index?wid='+_data.wid+'" target="_blank">';
					html+='					<img  class="img-responsive" src="'+imgSrc+'">';
					html+='				</a>';
					html+='			</div>';
					html+='			<div class="left-bolck col-xs-10 col-sm-10">';
					html+='				<div class="info-body">';
					html+='					<div class="info-body-title">';
					html+='						<a href="'+basePath+'/supplyHwzyDetail/index?wid='+_data.wid+'&ggxs='+_data.advert_type+'" target="_blank"	class="info-body-title-name">';
					html+='							<span class="number-title">';
					html+='								<span class="">'+_data.name+'</span>';
					html+='							</span>';
					html+='							<span class="tsxx tsxx-red">'+_data.ggxs_display+'</span>';
					html+='						</a>';
					html+='						<span class="pull-right">';
					html+='							<span	class="price"><span>'+jg+'</span></span>';
					html+='						</span>';
					html+='					</div>';
					
					html+='				<div class="content1">';
					html+='					<label>区域：</label><span>'+toStr(_data.area_display)+toStr(_data.city_display)+'</span>';
					html+='				</div>';
					html+='				<div class="content1">';
					html+='					<label>媒体名称：</label><span>'+_data.dst_display+'</span>';
					html+='				</div>';
					html+='				<div class="content1">';
					html+='					<label>发布人：</label>';
					html+='					<span> <!-- react-text: 417 -->'+_data.companyName+'<!-- /react-text --></span>';
					html+='				</div>';
					
					html+='				<div class="time-content">';
					html+='					<span> 发布时间：<!-- react-text: 421 -->'+_data.cjsj+'<!-- /react-text -->';
					html+='						<!-- react-text: 422 --><!-- /react-text -->';
					html+='					</span>';
					html+=' 			</div>';
					html+='			</div>';
					html+='		</div>';
					html+='</div>';
					html+='</div>';
				}
			}
			if(html==""){
				html='<div class="h-200 vertical-align text-xs-center order-null animation-fade"><div class="vertical-align-middle font-size-18 blue-grey-500">没有符合条件的需求</div></div>';
			}
			$("#divContent").html(html);
		});
	}
	
});