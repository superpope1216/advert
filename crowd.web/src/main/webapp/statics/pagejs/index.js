/**
 * 
 */

$(document).ready(function(){
	getList(basePath+"/supplyHwzyCenter/list","","ulHwzy",basePath+"/supplyHwzyDetail/index");
	getList(basePath+"/supplyDszyCenter/list","","ulDszy",basePath+"/supplyDszyDetail/index");
	getList(basePath+"/supplyGbzyCenter/list","","ulGbzy",basePath+"/supplyGbzyDetail/index");
	getList(basePath+"/supplyBzzyCenter/list","","ulBzzy",basePath+"/supplyBzzyDetail/index");
	getList(basePath+"/supplyZzzyCenter/list","","ulZzzy",basePath+"/supplyZzzyDetail/index");
	getList(basePath+"/supplyWlzyCenter/list","","ulWlzy",basePath+"/supplyWlzyDetail/index");
	getList(basePath+"/supplyXmtzyCenter/list","","ulXmtzy",basePath+"/supplyXmtzyDetail/index");
	$("[data-option='more']").click(function(){
		var key=$(this).attr("data-key");
		switch(key){
		case "1":
			window.open(basePath+"/supplyHwzyCenter/index?flag="+key);
			break;
		case "2":
			window.open(basePath+"/supplyDszyCenter/index?flag="+key);
			break;
		case "3":
			window.open(basePath+"/supplyGbzyCenter/index?flag="+key);
			break;
		case "4":
			window.open(basePath+"/supplyBzzyCenter/index?flag="+key);
			break;
		case "5":
			window.open(basePath+"/supplyXmtzyCenter/index?flag="+key);
			break;
		case "6":
			window.open(basePath+"/supplyZzzyCenter/index?flag="+key);
			break;
		case "7":
			window.open(basePath+"/supplyWlzyCenter/index?flag="+key);
			break;
		}
	});
	getZbList();
	function getZbList(){
		doGet(basePath+"/sjglCenter/queryAllList","sjlx=3&pageNum=1&pageSize=7",function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<4;i++){
					var name="",tm="",wid="";
					if(i<data.datas.length){
						var _data=data.datas[i];
						name=_data.title;
						tm=_data.xgsj;
						wid=_data.wid;
					}
					html+="<li>";
					html+='	<a href="'+basePath+'/sjglDetail/index?&sjlx=3&wid='+wid+'" title="'+name+'" target="_blank">';
					html+='		<span>'+tm+'</span>';
					html+=name;						
					html+='	</a>';
					html+="</li>";
					
				}
				$("#tblZb").html(html);
			}
		});
	}
	getQgList();
	function getQgList(){
		doGet(basePath+"/qgCenter/list","pageNum=1&pageSize=7",function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<4;i++){
					var name="",tm="",wid="";
					
					if(i<data.datas.length){
						var _data=data.datas[i];
						name=_data.name;
						tm=_data.xgsj;
						wid=_data.wid;
					}
					html+="<li>";
					html+='	<a href="'+basePath+'/qgDetail/index?wid='+wid+'" title="'+name+'" target="_blank">';
					html+='		<span>'+tm+'</span>';
					html+=name;						
					html+='	</a>';
					html+="</li>";
				}
				
				
				$("#tblQg").html(html);
			}
		});
	}
	
	$("[data-option='edit']").click(function(){
		var key=$(this).attr("data-key");
		switch(key){
		case "1":
			window.open(basePath+"/hwzyPublishing/index?gglx="+key);
			break;
		case "2":
			window.open(basePath+"/dszyPublishing/index?gglx="+key);
			break;
		case "3":
			window.open(basePath+"/gbzyPublishing/index?gglx="+key);
			break;
		case "4":
			window.open(basePath+"/bzzyPublishing/index?gglx="+key);
			break;
			
		case "5":
			window.open(basePath+"/xmtzyPublishing/index?gglx="+key);
			break;
		case "6":
			window.open(basePath+"/zzzyPublishing/index?gglx="+key);
			break;
		case "7":
			window.open(basePath+"/wlzyPublishing/index?gglx="+key);
			break;
		}
	});
	function getList(url,param,control,detailUrl){
		doGet(url,"pageSize=5&pageNum=1",function(data){
			if(data && data.datas){
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					var jg=getDszyMoney(_data);
					var imgSrc=basePath+"/image/preView?wid="+_data.IMGID;
					html+='<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" style="width:20%;">';
					html+='	<div class="mt-card-item" style="margin-bottom:0px;">';
					html+='		<div class="mt-card-avatar mt-overlay-1">';
					html+='			<img src="'+imgSrc+'" style="max-height:200px;">';
					html+='			<div class="mt-overlay">';
					html+='				<ul class="mt-info">';
					html+='                <li>';
					html+='						<a class="btn default btn-outline" target="_blank" href="'+detailUrl+'?wid='+_data.wid+"&ggxs="+toStr(_data.advert_type)+'">';
					html+='                        <i class="icon-magnifier">详情</i>';
					html+='                     </a>';
					html+='                </li>';
					html+='            </ul>';
					html+='        </div>';
					html+='    </div>';
					html+='    <div class="mt-card-content">';
					html+='		<h3 class="mt-card-name">'+jg+'</h3>';
					html+='        <p class="mt-card-desc font-grey-mint">'+_data.name+'</p>';
					html+='    </div>';
					html+=' </div>';
					html+='</div>';
				}
				$("#"+control).html(html);
			}
		});
	}
});