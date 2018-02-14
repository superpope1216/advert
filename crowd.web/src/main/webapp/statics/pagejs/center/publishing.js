/**
 * 
 */
define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formRbxxgl').bootstrapValidator();
	$$('#formXmxx').bootstrapValidator();
	
	$('#formXmxx [name="rwjbxxExtInfo.xmbh"]').autocomplete({  
		   source:function(query,process){
			 if(query){
				 doPost(basePath+"/publishing/xmxxs","condition="+query,function(data){
					 process(data.datas);
				});
				 
			 }else{
				 if(_xmxx){
					 return _xmxx;
				 }else{
					 doPost(basePath+"/publishing/xmxxs","condition="+query,function(data){
						 _xmxx=data.datas;
						 process(data.datas);
					});
				 }
			 }
		   }, 
		   formatItem:function(item){  
		       return item["xmbh"]+"("+item["ssxx"]+")";  
		    },  
		   setValue:function(item){  
			   doGet(basePath+"/publishing/fbxxs","xmbh="+item["xmbh"],function(data){
				   setSelect("#formXmxx [name='fb']","---请选择分包信息---",data.datas);
			   });
		       return{'data-value':item["xmbh"],'real-value':item["xmbh"]};  
		    },
		    minLength:0
		}); 

	$("#formXmxx [name='rwjbxxExtInfo.ywxbm']").change(function(){
		var _value=$(this).val();
		if(_value){
			doGet(basePath+"/publishing/cpmls","ywxbm="+_value,function(data){
				setSelect("#formXmxx [name='rwjbxxExtInfo.mkbh']","---请选择模块信息---",data.datas);
			});
		}else{
			setSelect("#formXmxx [name='rwjbxxExtInfo.mkbh']","---请选择模块信息---")
		}
	});
	$("#btnNext").click(function() {
		var bootstrapValidator = $$('#formRbxxgl').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			$("#rwjbxx").hide();
			$("#xmjbxx").show();
		}

	});
	
	$("#btnPre").click(function(){
		$("#xmjbxx").hide();
		$("#rwjbxx").show();
		
	});
	//提交审核
	$("#btnSaveSh").click(function(){
		var bootstrapValidator = $$('#formXmxx').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			var _rwxxData=$("#formRbxxgl").serializeArray();
			var _xmxxData=$("#formXmxx").serializeArray();
			for(var i=0;i<_xmxxData.length;i++){
				_rwxxData.push(_xmxxData[i]);
			}
			doPost(basePath+"/publishing/publishing",_rwxxData,function(data){
				window.location.href=basePath+"/xqfOrder/index";
			});
		}
	});
	$("#formRbxxgl [name='rwjbxxInfo.rwxs']").change(function(){
		var _value=$(this).val();
		if(_value=="" ||_value=="1"){
			$("#formRbxxgl [name='rwjbxxInfo.rwlx']").parent().show();
			$("#formRbxxgl [name='rwjbxxInfo.kfkj']").parent().show();	
			$("#formRbxxgl [name='rwjbxxInfo.sfjjxq']").parent().show();	
		}else{
			$("#formRbxxgl [name='rwjbxxInfo.rwlx']").parent().hide();
			$("#formRbxxgl [name='rwjbxxInfo.kfkj']").parent().hide();	
			$("#formRbxxgl [name='rwjbxxInfo.sfjjxq']").parent().hide();
		}
		
	})

});