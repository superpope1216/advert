/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formXmtzy').bootstrapValidator();
	
	
	
	$("#formXmtzy [name='xmtzyInfo.area']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#formXmtzy [name='xmtzyInfo.city']").empty();
			$("#formXmtzy [name='xmtzyInfo.city']").append("<option value=''>--请选择--</option>");
		}
		doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
			if(data && data.datas){
				
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formXmtzy [name='xmtzyInfo.city']").html(html);
			}
		});
	});
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formXmtzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		
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