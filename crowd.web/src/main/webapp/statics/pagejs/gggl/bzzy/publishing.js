/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formBzzy').bootstrapValidator();
	$$('#formBzzyGsyg').bootstrapValidator();
	$$('#formBzzyExt').bootstrapValidator();
	$$('#formBzzyXbmgg').bootstrapValidator();
	$$('#formBzzyRw').bootstrapValidator();
	$$('#formBzzyJy').bootstrapValidator();
	
	
	$("#formBzzy [name='bzzyInfo.advertType1']").click(function(){
		var _value=$(this).val();
		$("#formBzzy [name='bzzyInfo.advertType']").val(_value);
		if(_value=="1"){
			$("#formBzzyGsyg").show();
			$("#formBzzyXbmgg").hide();
			$("#formBzzyRw").hide();
			$("#formBzzyJy").hide();
		}else if(_value=="2"){
			$("#formBzzyGsyg").hide();
			$("#formBzzyXbmgg").show();
			$("#formBzzyRw").hide();
			$("#formBzzyJy").hide();
		}else if(_value=="3"){
			$("#formBzzyGsyg").hide();
			$("#formBzzyXbmgg").hide();
			$("#formBzzyRw").show();
			$("#formBzzyJy").hide();
		}else if(_value=="4"){
			$("#formBzzyGsyg").hide();
			$("#formBzzyXbmgg").hide();
			$("#formBzzyRw").hide();
			$("#formBzzyJy").show();
		}

		$("#formBzzyGsyg")[0].reset();
		$("#formBzzyXbmgg")[0].reset();
		$("#formBzzyRw")[0].reset();
		$("#formBzzyJy")[0].reset();
	});
	$("#formBzzy [name='bzzyInfo.area']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#formBzzy [name='bzzyInfo.city']").empty();
			$("#formBzzy [name='bzzyInfo.city']").append("<option value=''>--请选择--</option>");
			$("#formBzzy [name='bzzyInfo.tvId']").html("<option value=''>--请选择--</option>");
		}
		doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
			if(data && data.datas){
				
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formBzzy [name='bzzyInfo.city']").html(html);
			}
		});
		doGet(basePath+"/dictionary/selectBzxx","areaBm="+$(this).val(),function(data){
			if(data && data.datas){
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formBzzy [name='bzzyInfo.tvId']").html(html);
				
			}
		});
	});
	
	
	$("#formBzzyExt [name='aScdlzs']").click(function(){
		$("#formBzzyExt [name='divScdlzs']").show();
	});
	
	$("#formBzzyExt [name='bzzyExtInfo.sfxzhy']").click(function(){
		if($(this).val()=="0"){
			$("#formBzzyExt [name='divHy']").hide();
			$("#formBzzyExt [name='bzzyExtInfo.hy']").prop("checked",false);
		}else{
			$("#formBzzyExt [name='divHy']").show();
			$("#formBzzyExt [name='bzzyExtInfo.hy']").prop("checked",false);
		}
	});
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formBzzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formBzzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formBzzy [name='bzzyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formBzzyGsyg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyGsyg").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyGsyg",data1,function(){
						alert("发布成功")
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formBzzyXbmgg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyXbmgg").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyXbmgg",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
		else if(_value=="3"){
			var bootstrapValidator2 = $$('#formBzzyRw').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyRw").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyRw",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
		else if(_value=="4"){
			var bootstrapValidator2 = $$('#formBzzyJy').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyJy").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyJy",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
	});
});