/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formZzzy').bootstrapValidator();
	$$('#formZzzyGsyg').bootstrapValidator();
	$$('#formZzzyExt').bootstrapValidator();
	$$('#formZzzyRw').bootstrapValidator();
	$$('#formZzzyJy').bootstrapValidator();
	
	
	$("#formZzzy [name='zzzyInfo.advertType1']").click(function(){
		var _value=$(this).val();
		$("#formZzzy [name='zzzyInfo.advertType']").val(_value);
		if(_value=="1"){
			$("#formZzzyGsyg").show();
			$("#formZzzyRw").hide();
			$("#formZzzyJy").hide();
		}else if(_value=="2"){
			$("#formZzzyGsyg").hide();
			$("#formZzzyXbmgg").hide();
			$("#formZzzyRw").show();
			$("#formZzzyJy").hide();
		}else if(_value=="3"){
			$("#formZzzyGsyg").hide();
			$("#formZzzyXbmgg").hide();
			$("#formZzzyRw").hide();
			$("#formZzzyJy").show();
		}
			

		$("#formZzzyGsyg")[0].reset();
		$("#formZzzyRw")[0].reset();
		$("#formZzzyJy")[0].reset();
	});
	$("#formZzzy [name='zzzyInfo.area']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#formZzzy [name='zzzyInfo.city']").empty();
			$("#formZzzy [name='zzzyInfo.city']").append("<option value=''>--请选择--</option>");
			$("#formZzzy [name='zzzyInfo.tvId']").html("<option value=''>--请选择--</option>");
		}
		doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
			if(data && data.datas){
				
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formZzzy [name='zzzyInfo.city']").html(html);
			}
		});
		doGet(basePath+"/dictionary/selectZzxx","areaBm="+$(this).val(),function(data){
			if(data && data.datas){
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formZzzy [name='zzzyInfo.tvId']").html(html);
				
			}
		});
	});
	
	
	$("#formBzzyExt [name='aScdlzs']").click(function(){
		$("#formZzzyExt [name='divScdlzs']").show();
	});
	
	$("#formZzzyExt [name='zzzyExtInfo.sfxzhy']").click(function(){
		if($(this).val()=="0"){
			$("#formZzzyExt [name='divHy']").hide();
			$("#formZzzyExt [name='zzzyExtInfo.hy']").prop("checked",false);
		}else{
			$("#formZzzyExt [name='divHy']").show();
			$("#formZzzyExt [name='zzzyExtInfo.hy']").prop("checked",false);
		}
	});
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formZzzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formZzzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formZzzy [name='zzzyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formZzzyGsyg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyGsyg").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyGsyg",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
		else if(_value=="2"){
			var bootstrapValidator2 = $$('#formZzzyRw').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				var _bjlx=$("#formZzzyRw [name='zzzyRwInfo.bjlx']").val();
				if(_bjlx=="1"){
					if($.trim($("#formZzzyRw [name='zzzyRwInfo.jg']").val())==""){
						$("#formZzzyRw [name='zzzyRwInfo.jg']")[0].focus();
						alert("请输入报价价格");
						return;
					}
				}else{
					if($.trim($("#formZzzyRw [name='zzzyRwInfo.zk']").val())==""){
						$("#formZzzyRw [name='zzzyRwInfo.zk']")[0].focus();
						alert("请输入报价折扣");
						return;
					}
				}
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyRw").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyRw",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
		else if(_value=="3"){
			var bootstrapValidator2 = $$('#formZzzyJy').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyJy").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyJy",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
	});
});