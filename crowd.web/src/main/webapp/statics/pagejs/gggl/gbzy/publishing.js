/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formGbzy').bootstrapValidator();
	$$('#formGbzySd').bootstrapValidator();
	$$('#formGbzyExt').bootstrapValidator();
	$$('#formGbzyQt').bootstrapValidator();
	
	
	$("#formGbzy [name='gbzyInfo.advertType1']").click(function(){
		var _value=$(this).val();
		$("#formGbzy [name='gbzyInfo.advertType']").val(_value);
		if(_value=="1"){
			$("#formGbzySd").show();
			$("#formGbzyQt").hide();
			$("#formGbzySd")[0].reset();
			$("#formGbzyQt")[0].reset();
		}else if(_value=="2"){
			$("#formGbzySd").hide();
			$("#formGbzyQt").show();
			$("#formGbzySd")[0].reset();
			$("#formGbzyQt")[0].reset();
		}
	});
	$("#formGbzy [name='gbzyInfo.area']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#formGbzy [name='gbzyInfo.city']").empty();
			$("#formGbzy [name='gbzyInfo.city']").append("<option value=''>--请选择--</option>");
			$("#formGbzy [name='gbzyInfo.tvId']").html("<option value=''>--请选择--</option>");
			$("#formGbzySd [name='gbzySdInfo.gbpdBm']").html("<option value=''>--请选择--</option>");
			$("#formGbzyQt [name='gbzyQtInfo.gbpdBm']").html("<option value=''>--请选择--</option>");
		}
		doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
			if(data && data.datas){
				
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formGbzy [name='gbzyInfo.city']").html(html);
			}
		});
		doGet(basePath+"/dictionary/selectGbdst","areaBm="+$(this).val(),function(data){
			if(data && data.datas){
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formGbzy [name='gbzyInfo.tvId']").html(html);
				
			}
		});
	});
	
	$("#formGbzy [name='gbzyInfo.tvId']").change(function(){
		if($(this).val()==""){
			$("#formGbzySd [name='gbzySdInfo.gbpdBm'").html("<option value=''>--请选择--</option>");
			$("#formGbzyQt [name='gbzyQtInfo.gbpdBm']").html("<option value=''>--请选择--</option>");
			formDszyTb
		}else{
			doGet(basePath+"/dictionary/selectGbdstpd","gbdstBm="+$(this).val(),function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formGbzySd [name='gbzySdInfo.gbpdBm']").html(html);
					$("#formGbzyQt [name='gbzyQtInfo.gbpdBm']").html(html);
				}
			});
		}
	});
	
	$("#formGbzyExt [name='aScdlzs']").click(function(){
		$("#formGbzyExt [name='divScdlzs']").show();
	});
	
	$("#formGbzyExt [name='gbzyExtInfo.sfxzhy']").click(function(){
		if($(this).val()=="0"){
			$("#formGbzyExt [name='divHy']").hide();
			$("#formGbzyExt [name='gbzyExtInfo.hy']").prop("checked",false);
		}else{
			$("#formGbzyExt [name='divHy']").show();
			$("#formGbzyExt [name='gbzyExtInfo.hy']").prop("checked",false);
		}
	});
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formGbzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formGbzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formGbzy [name='gbzyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formGbzySd').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formGbzy").serializeArray();
					var data2=$("#formGbzySd").serializeArray();
					var data3=$("#formGbzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/gbzyPublishing/publishingGbzySd",data1,function(){
						alert("发布成功")
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formGbzyQt').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				var ggzkNum=0;
				$("#formGbzyQt [data-option='ggzk']").each(function(){
					if(this.checked){
						ggzkNum++;
					}
				});
				if(ggzkNum<=0){
					alert("请至少勾选一个广告折扣！");
					return;
				}
				if($("#formGbzyQt [name='gbzyQtInfo.ztHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.ztMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.ztMoney']")[0].focus();
						alert("请输入专题折扣！");
						return;
					}
					
				}
				if($("#formGbzyQt [name='gbzyQtInfo.lbHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.lbMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.lbMoney']")[0].focus();
						alert("请输入联播折扣！");
						return;
					}
				
				}
				if($("#formGbzyQt [name='gbzyQtInfo.gmHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.gmMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.gmMoney']")[0].focus();
						alert("请输入冠名折扣！");
						return;
					}
					
				}
				if($("#formGbzyQt [name='gbzyQtInfo.tyHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.tyMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.tyMoney']")[0].focus();
						alert("请输入特约折扣！");
					}
					return;
				}
				if($("#formGbzyQt [name='gbzyQtInfo.zdbsHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.zdbsMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.zdbsMoney']")[0].focus();
						alert("请输入整点报时折扣！");
					}
					return;
				}
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formGbzy").serializeArray();
					var data2=$("#formGbzyQt").serializeArray();
					var data3=$("#formGbzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/gbzyPublishing/publishingGbzyQt",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
	});
});