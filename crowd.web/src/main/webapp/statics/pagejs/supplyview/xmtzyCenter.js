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
		doGet(basePath+"/dictionary/selectDst","areaBm="+_areaBm,function(data){
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
			}
		});
		queryRwjbxx(getParam(1));
	});
	
	$("#ddCity").on("click","a",function(){
		var _areaBm=$(this).attr("data-key");
		$("#divQueryCity a").removeClass("queryActive");
		$(this).addClass("queryActive");
		doGet(basePath+"/dictionary/selectDst","areaBm="+_areaBm,function(data){
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
	$("#paralist a").click(function(){
		var data_option=$(this).attr("data-option");
		$("#paralist a[data-option='"+data_option+"']").removeClass("queryActive");
		$(this).addClass("queryActive");
		
		//queryRwjbxx(getParam(1));
	});
	
	function getParam(pageNum,pageSize){
		var param="ggxs="+toStr($("#paralist a[data-option='ggxs'].queryActive").attr("data-key"));
		param+="&areaBm="+toStr($("#paralist a[data-option='area'].queryActive").attr("data-key"));
		param+="&cityBm="+toStr($("#paralist a[data-option='city'].queryActive").attr("data-key"));
		param+="&dst="+toStr($("#paralist a[data-option='dst'].queryActive").attr("data-key"));
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
	queryRwjbxx(getParam(1));
	function queryRwjbxx(param){
		doGet(basePath+"/supplyDszyCenter/list",param,function(data){
			var html="";
			if(data && data.datas){
//				$('.mypaging2').pagination({
//					pageCount:data.pageInfo.totalPage,
//				    showData:data.pageInfo.pageSize,
//				    coping:true,
//				    callback:function(api){
//				    	var _cPage=api.getCurrent();
//				    	queryRwjbxx(getParam(_cPage));
//				    }
//				});
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
					html+='<div class="center-left-body-block">';
					html+='	<div class="child">';
					html+='		<div class="img-div">';
					html+='			<a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" target="_blank">';
					html+='				<img src="'+basePath+'/statics/images/home/emap.png">';
					html+='				<img  class="mycover" src="'+basePath+'/statics/images/home/emap.png">';
					html+='			</a>';
					html+='		</div>';
					html+='		<div class="left-bolck">';
					html+='			<div class="info-body">';
					html+='				<div class="info-body-title">';
					html+='					<a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" target="_blank"	class="info-body-title-name">';
				
					html+='						<span class="number-title">';
					html+='							<span class="">'+_data.name+'</span>';
					html+='						</span>';
					html+='						<span class="tsxx tsxx-red">'+_data.ggxs_display+'</span>';
					html+='					</a>';
					html+='					<span class="pull-right">';
					html+='						<span	class="price"><span>'+jg+'</span></span>';
					html+='					</span>';
					html+='				</div>';
					html+='			<div>';
					html+='			<div class="content1">';
					html+='				<label>区域：</label><span>'+toStr(_data.area_display)+toStr(_data.city_display)+'</span>';
					html+='			</div>';
					html+='			<div class="content1">';
					html+='				<label>媒体名称：</label><span>'+_data.dst_display+'</span>';
					html+='			</div>';
					html+='			<div class="content1">';
					html+='				<label>发布人：</label>';
					html+='				<span> <!-- react-text: 417 -->'+_data.companyName+'<!-- /react-text -->';
					html+='				</span>';
					html+='			</div>';
					html+='		</div>';
					html+='		<div class="time-content">';
					html+='			<span> <!-- react-text: 421 -->'+_data.cjsj+'<!-- /react-text -->';
					html+='				<!-- react-text: 422 -->发布<!-- /react-text -->';
					html+='			</span>';
					html+='				<!-- react-text: 423 -->|<!-- /react-text -->';
					html+='			<span> <!-- react-text: 425 -->'+_data.childKfzCount+'<!-- /react-text -->';
					html+='				<!-- react-text: 426 --> 人点击<!-- /react-text -->';
					html+='			</span>';
					html+=' 	</div>';
					html+='	</div>';
					html+='</div>';
					html+='	</div>';
					html+='</div>';
					
//					html+='<div class="col-sm-3 sm-margin-b-50"><a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" title="'+_data.rwmc+'"	target="_self">';
//					html+='		<div class="margin-b-20">';
//					html+='			<div class="wow zoomIn animated" data-wow-duration=".3"	data-wow-delay=".1s" style="visibility: visible; animation-delay: 0.1s; animation-name: zoomIn; position: relative;">';
//					html+='				<img class="img-responsive"	style="max-width: 100%; heigth: auto; display: block;"	src="'+basePath+'/statics/images/home/'+getImagePath(_data.rwxs,_data.kfkj)+'.png" alt="'+_data.rwmc+'">';
//					var _jd=""
//					if(_data.rwjd=="1"){
//						_jd="label-danger";
//					}else if(_data.rwjd=="2"){
//						_jd="label-primary";
//					}else if( _data.rwjd=="3" || _data.rwjd=="4"){
//						_jd="label-success";
//					}else{
//						_jd="label-info"
//					}
//					html+='				<span class="label '+_jd+'" style="color: #fff; position: absolute; bottom: 0px; right: 0px;">'+_data.rwjdDisplay+'</span>';
//					html+='			</div>';
//					html+='   	</div>';
//					var _rwmc=_data.rwmc;
//					if(_rwmc && _rwmc.length>10){
//						_rwmc=_rwmc.substr(0,10)+"...";
//					}
//					html+='		<h4>';
//					html+='			<a href="javascript:void(0);"	style="color: #515769; font-family: Hind, sans-serif; line-height: 1.4; font-weight: 700;" title="'+_data.rwmc+'">'+_rwmc+'</a> ';
//					html+='			<span class="text-uppercase margin-l-20" style="color: #bfc1c7; font-size: 14px; margin-left: 20px; font-weight: 500;">'+_data.zbzq+'天</span>';
//					html+='		</h4>';
//					var _xmgs=_data.xmgs;
//					if(_xmgs && _xmgs.length>35){
//						_xmgs=_xmgs.substr(0,35)+"...";
//					}
//					html+='		<p	style="color: #a6a7aa; font-weight: 400; font-size: 15px; min-height: 50px; max-height: 50px;">'+_xmgs+'</p>';
//					html+='		<a href="#"	style="font-size: 15px; font-weight: 700; color: red; font-family: Hind, sans-serif;">$'+xmje+'元</a>';
//					html+='</a>	</div>';
					/**
					html+='<li class=" shown offer wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible;  animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">';
					html+='	  <a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" title="'+_data.rwmc+'"	target="_self" class="my-card">';
					html+='	  	 <article class="inner-box">';
					html+='	        <figure class="image" style="margin:0;">';
					html+='				<img src="'+basePath+'/statics/images/home/'+getImagePath(_data.rwxs,_data.kfkj)+'.png" title="'+_data.rwmc+'" alt="'+_data.rwmc+'">';
					html+='				<div class="overlay-box">';
					html+='					<div class="date">';
					html+='					'+_data.xmgs+'';	
					html+='				    </div>';
					html+='				</div>';
					html+='			</figure>';
					html+='			<div class="text">';
					html+='				<div class="desc">';
					html+='				    <p><b>'+_data.rwmc+'</b></p>';
					html+='				    <p style="overflow: auto;">';
					var xmje=_data.xmysje;
					if(_data.zbje){
						xmje=_data.zbje;
					}
					if(_data.ptbzje){
						xmje=xmje+_data.ptbzje;
					}
					html+='				    	<span style="text-align: left; float: left; display: inline-block;" class="price">￥'+xmje+'元</span> ';
					html+='				        <span style="text-align: center; float: right; display: inline-block; width: 40px; background-color: #ddd; border: none; font-size: 12px; border-radius: 3px; cursor: pointer; display: inline-block; background-color: #65C279; color: #FFF;">'+_data.rwjdDisplay+'</span>'
					html+='				     </p>';
					html+='				  </div>';
					html+='				  <p style="overflow: auto; border-top: solid 1px #ddd; color: #999; padding-top: 4px;">';
					html+='				     <span	style="text-align: left; float: left; display: inline-block;">'+_data.kfkjDisplay+'</span>';
					html+='					 <span	style="text-align: center; float: right; cursor: pointer; display: inline-block;">'+_data.zbzq+'天</span>';
					html+='			     </p>';
					html+='			</div>';
					html+='	    </article>';
					html+='   </a>';
					html+='</li>';
					*/
				}
			}
			if(html==""){
				html='<div class="h-200 vertical-align text-xs-center order-null animation-fade"><div class="vertical-align-middle font-size-18 blue-grey-500">没有符合条件的需求</div></div>';
			}
			$("#divContent").html(html);
		});
	}
	
});