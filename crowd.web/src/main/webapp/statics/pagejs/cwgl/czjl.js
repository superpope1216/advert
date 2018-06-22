/**
 * 
 */
define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	
	$("#btnSupply").click(function(){
		$("#modalCz").modal("show");
	});
	list(1,true);
	function list(pageNum,needPage){
		doGet(basePath+"/cwgl/czjl/list","pageNum="+pageNum,function(data){
			var html="";
			if(data &&data.datas){
				if(needPage){
					$('.mypaging2').pagination({
						pageCount:data.pageInfo.totalPage,
					    showData:data.pageInfo.pageSize,
					    coping:true,
					    callback:function(api){
					    	var _cPage=api.getCurrent();
					    	list(_cPage,false);
					    }
					});
				}
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					
					html+="<tr>";
					html+="   <td>"+toStr(_data.nx)+"</td>";
					html+="   <td>"+toStr(_data.ddbh)+"</td>";
					html+="   <td>"+toStr(_data.zfztDisplay)+"</td>";
					html+="   <td>"+toStr(_data.djDisplay)+"</td>";
					html+="   <td>"+toStr(_data.kssj)+"</td>";
					html+="   <td>"+toStr(_data.jssj)+"</td>";
					html+="   <td>"+toStr(_data.yxj)+"</td>";
					html+="   <td>"+toStr(_data.je/_data.nx)+"</td>";
					html+="   <td>"+toStr(_data.je)+"</td>";
					html+="</tr>";
				}
				
			}
			$("#tblData").html(html);
		});
	} 
	$("#formCzInfo [name='djxx']").change(function(){
		var _key=$(this).val();
		doGet(basePath+"/cwgl/czjl/selectDjxx","wid="+_key,function(data){
			
			$("#formCzInfo [name='fy']").html(toStr(data.datas.fy));
			var ts="";
			if(!data.datas.ggzyxzsl){
				ts="不限制";
			}else{
				ts=data.datas.ggzyxzsl;
			}
			$("#formCzInfo [name='ggts']").html(toStr(ts));
			$("#formCzInfo [name='yxjb']").html(toStr(data.datas.yxjb));
			$("#formCzInfo [name='bz']").html(toStr(data.datas.bz));
			setMoney();
		});
	});
	
	function setMoney(){
		if($("#formCzInfo [name='djxx']").val()==""){
			$("#formCzInfo [name='czzje']").html("");
		}else{
			$("#formCzInfo [name='czzje']").html(parseInt($("#formCzInfo [name='fy']").html())*parseInt($("#formCzInfo [name='ns']").val()));
		}
	}
	
	$("#btnFk").click(function(){
		var nx=$("#formCzInfo [name='ns']").val();
		var hydj=$("#formCzInfo [name='djxx']").val();
		var hydjName=$("#formCzInfo [name='djxx']").find("option:selected").text();
		var je=$("#formCzInfo [name='czzje']").html();
		
		confirm("您当前的充值总金额为"+je+"元，会员为"+hydjName+",年限为"+nx+"年，您确认充值吗？",function(){
			doPost(basePath+"/cwgl/czjl/recharge","dj="+hydj+"&nx="+nx,function(data){
				window.open(basePath+"/cwgl/czjl/changePage?wid="+data.datas);
			});
		});
	});
	$("#formCzInfo [name='ns']").change(function(){
		setMoney();
	});
});