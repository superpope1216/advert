/**
 * 
 */

$(document).ready(function(){
	//$('.dataStatistics').dataStatistics({min:100,max:1500,time:30000,len:6});
	$(".column-side li a[data-toggle='collapse']").click(function() {
		if($(this).find("i.icon").hasClass("wb-chevron-down")){
			
			//$(".column-side ol li a").css("padding","24px 18px 5px");
			$(this).find("i.icon").removeClass("wb-chevron-down").addClass("wb-chevron-up");
		}else{
			//$(".column-side ol li a").css("padding","24px 18px");
			$(this).find("i.icon").removeClass("wb-chevron-up").addClass("wb-chevron-down");
		}
	});
	$("#paralist a").click(function(){
		var data_option=$(this).attr("data-option");
		$("#paralist a[data-option='"+data_option+"']").removeClass("queryActive");
		$(this).addClass("queryActive");
		queryRwjbxx();
	});
	
	$("#btnPublishing").click(function(){
		window.location.href=basePath+"/publishing/index";
	});
	
	$("#btnTb").click(function(){
		doGet(basePath+"/center/toNeed","",function(){
			alert("请在众包大厅中选择招标中的需求进行投标！");
		});
	});
	function addPreZero(num){
		 var t = (num+'').length,
		  s = '';
		  
		 for(var i=0; i<6-t; i++){
		  s += '0';
		 }
		  
		 return s+num;
		}
	queryRwtjxxStatic();
	function queryRwtjxxStatic(){
		doGet(basePath+"/center/rwxxStatics","",function(data){
			if(data && data.datas){
				var _data=parseInt(data.datas);
				var _halfData=Math.round(_data/2);
				var timer=setInterval(function(){
					if(_halfData>_data){
						
						_halfData=_data;
						clearInterval(timer);
					}
					var _strHalfData=addPreZero(_halfData);
					var _num1=_strHalfData.substr(0,1);
					var _num2=_strHalfData.substr(1,1);
					var _num3=_strHalfData.substr(2,1);
					var _num4=_strHalfData.substr(3,1);
					var _num5=_strHalfData.substr(4,1);
					var _num6=_strHalfData.substr(5,1);
					$("#divNum1").html(_num1);
					$("#divNum2").html(_num2);
					$("#divNum3").html(_num3);
					$("#divNum4").html(_num4);
					$("#divNum5").html(_num5);
					$("#divNum6").html(_num6);
					_halfData+=100;
					
				},1000);
			}
		});
	}
	function setTimeValue(value){
		
	};
	queryRwjbxx();
	function queryRwjbxx(){
		var param="ywxlb="+$("#paralist a[data-option='ywx'].queryActive").attr("data-key");
		param+="&kfkj="+$("#paralist a[data-option='kfkj'].queryActive").attr("data-key");
		param+="&rwjd="+$("#paralist a[data-option='rwzt'].queryActive").attr("data-key");
		param+="&rwxs="+lbdm;
		doGet(basePath+"/center/query",param,function(data){
			var html="";
			if(data && data.datas){
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<li class=" shown offer wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible;  animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">';
					html+='	  <a href="'+basePath+'/rwxxDetail/index?rwid='+_data.wid+'" title="'+_data.rwmc+'"	target="_self" style="padding: 0px;background:#fff;">';
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
				}
			}
			$("#crowd-grid").html(html);
		});
	}
	
});