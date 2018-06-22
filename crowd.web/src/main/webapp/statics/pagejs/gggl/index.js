/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/dszyPublishing/index";
	});
	queryList(1,true);
	queryListCount();
	function queryListCount(){
		doGet(basePath+"/supplyView/listCount","",function(data){
			if(data &&data.datas){
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _class="";
					if(data.datas[i].gglx==key){
						_class="mygglx-active";
					}else{
						_class="mygglx";
					}
					html+='<div data-gglx="'+data.datas[i].gglx+'" class=" cclick '+_class+'" style="cursor:pointer;">';
					html+='<a  href="javascript:void(0)";>'+data.datas[i].name+'</a>';
					html+='<br>';
					html+='<strong>'+data.datas[i].count+'</strong>';
					html+='</div>';
				}
				$("#headerGg").html(html);
			}
		});
	}
	$("#btnSearch").click(function(){
		queryList(1,true);
	});
	$("#headerGg").on("click","div.cclick",function(){
		
			var _gglx=$(this).attr("data-gglx");
			$("#headerGg div").removeClass("mygglx-active").addClass("mygglx");
			$(this).addClass("mygglx-active");
			key=_gglx;
			queryList(1,true);
		
	})
	
	
	$("#tblData").on("click","button[data-option='edit']",function(){
		var key=$(this).attr("data-key");
		var gglx=$(this).attr("data-gglx");//广告类型
		var ggfl=$(this).attr("data-ggfl");//广告分类
		if(gglx=="2"){
			window.location=basePath+"/dszyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}else if(gglx=="3"){
			window.location=basePath+"/gbzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}else if(gglx=="4"){
			window.location=basePath+"/bzzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}else if(gglx=="5"){
			window.location=basePath+"/xmtzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}
		else if(gglx=="6"){
			window.location=basePath+"/zzzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}else if(gglx=="7"){
			window.location=basePath+"/wlzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}else if(gglx=="1"){
			window.location=basePath+"/hwzyPublishing/index?wid="+key+"&gglx="+gglx+"&ggfl="+ggfl;
		}
	});
	$("#tblData").on("click","button[data-option='delete']",function(){
		var key=$(this).attr("data-key");
		var gglx=$(this).attr("data-gglx");//广告类型
		var ggfl=$(this).attr("data-ggfl");//广告分类
		if(gglx=="2"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/dszyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="3"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/gbzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="4"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/bzzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="5"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/xmtzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="6"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/zzzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="7"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/wlzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}else if(gglx=="1"){
			confirm("您确认删除该记录吗？",function(){
				doPost(basePath+"/hwzyPublishing/delete","wid="+key+"&ggfl="+ggfl,function(data){
					alert("记录删除成功！");
					window.location.reload();
				});
			});
		}
	});
	function queryList(pageNum,needPage){
		var _serach=$("#txtSearch").val();
		doGet(basePath+"/supplyView/list","pageNum="+pageNum+"&gglx="+key+"&condition="+_serach,function(data){
			if(data && data.datas){
				if(needPage){
					$('.mypaging2').pagination({
						pageCount:data.pageInfo.totalPage,
					    showData:data.pageInfo.pageSize,
					    coping:true,
					    callback:function(api){
					    	var _cPage=api.getCurrent();
					    	queryList(_cPage,false);
					    }
					});
				}
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
					
					html+='<td><button data-gglx="'+_data.gglx+'" data-ggfl="'+_data.advert_type+'" data-key="'+_data.wid+'" data-option="edit" class="btn btn-primary btn-xs" data-original-title="" title=""><i class="fa fa-pencil" data-original-title="" title=""></i></button>';
                    html+='<button  data-gglx="'+_data.gglx+'" data-ggfl="'+_data.advert_type+'" data-key="'+_data.wid+'" data-option="delete" class="btn btn-danger btn-xs" data-original-title="" title=""><i class="fa fa-trash-o " data-original-title="" title=""></i></button></td>';
					html+="</tr>";
				}
				$("#tblData").html(html);
			}
		});
	}
});