/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formRbxxgl').bootstrapValidator();
	$$('#formRbxxglSh').bootstrapValidator();
	scoreFun($("#formRbxxgl [data-option='kfzl']"),{
		 fen_d:32,//每一个a的宽度
         ScoreGrade:5//a的个数5
	});
	scoreFun($("#formRbxxgl [data-option='fwzl']"),{
		 fen_d:32,//每一个a的宽度
        ScoreGrade:5//a的个数5
	});
	scoreFun($("#formRbxxgl [data-option='xysd']"),{
		 fen_d:32,//每一个a的宽度
        ScoreGrade:5//a的个数5
	});
	scoreFun($("#formRbxxglSh [data-option='kfzl']"),{
		 fen_d:32,//每一个a的宽度
        ScoreGrade:5,//a的个数5
        defaultValue:kfzl
	});
	scoreFun($("#formRbxxglSh [data-option='fwzl']"),{
		 fen_d:32,//每一个a的宽度
       ScoreGrade:5,//a的个数5
       defaultValue:fwzl
	});
	scoreFun($("#formRbxxglSh [data-option='xysd']"),{
		 fen_d:32,//每一个a的宽度
       ScoreGrade:5,//a的个数5
       defaultValue:xysd
	});
	$("#formRbxxgl [name='ysjg']").change(function(){
		var _val=$(this).val();
		if(_val==1){
			$("#formRbxxgl [data-option='divTgpjnr']").show();
			$("#formRbxxgl [data-option='divBtgpjnr']").hide();
			$("#formRbxxgl [data-option='divNone']").hide();
			
		}else if(_val==0){
			$("#formRbxxgl [data-option='divTgpjnr']").hide();
			$("#formRbxxgl [data-option='divBtgpjnr']").show();
			$("#formRbxxgl [data-option='divNone']").hide();
		}else{
			$("#formRbxxgl [data-option='divTgpjnr']").hide();
			$("#formRbxxgl [data-option='divBtgpjnr']").hide();
			$("#formRbxxgl [data-option='divNone']").show();
		}
	});
	$("#formRbxxglSh [name='ysjg']").change(function(){
		var _val=$(this).val();
		if(_val==1){
			$("#formRbxxglSh [data-option='divTgpjnr']").show();
			$("#formRbxxglSh [data-option='divBtgpjnr']").hide();
			$("#formRbxxglSh [data-option='divNone']").hide();
			
		}else if(_val==0){
			$("#formRbxxglSh [data-option='divTgpjnr']").hide();
			$("#formRbxxglSh [data-option='divBtgpjnr']").show();
			$("#formRbxxglSh [data-option='divNone']").hide();
		}else{
			$("#formRbxxglSh [data-option='divTgpjnr']").hide();
			$("#formRbxxglSh [data-option='divBtgpjnr']").hide();
			$("#formRbxxglSh [data-option='divNone']").show();
		}
	});
	$("#btnSaveYsjg").click(function(){
		var bootstrapValidator = $$('#formRbxxgl').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			var param="rwid="+rwid;
			param+="&pjjg="+$("#formRbxxgl [name='ysjg']").val();
			if($("#formRbxxgl [name='ysjg']").val()=="1"){
				param+="&kfzl="+(6-parseInt($("#formRbxxgl [data-option='kfzl'] a.clibg").css("z-index")));
				param+="&fwzl="+(6-parseInt($("#formRbxxgl [data-option='fwzl'] a.clibg").css("z-index")));
				param+="&xysd="+(6-parseInt($("#formRbxxgl [data-option='xysd'] a.clibg").css("z-index")));
				param+="&bz="+$("#formRbxxgl [name='tgpjnr']").val();
			}else if($("#formRbxxgl [name='ysjg']").val()=="0"){
				param+="&bz="+$("#formRbxxgl [name='btgyy']").val();
			}
			
			
			doPost(basePath+"/xqfOrderAction/accept",param,function(data){
				window.location.reload();
			});
		};
	});
	
	$("#btnSaveShjg").click(function(){
		var bootstrapValidator = $$('#formRbxxglSh').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()) {
			var param="rwid="+rwid;
			param+="&pjjg="+$("#formRbxxglSh [name='ysjg']").val();
			if($("#formRbxxglSh [name='ysjg']").val()=="1"){
				param+="&kfzl="+(6-parseInt($("#formRbxxglSh [data-option='kfzl'] a.clibg").css("z-index")));
				param+="&fwzl="+(6-parseInt($("#formRbxxglSh [data-option='fwzl'] a.clibg").css("z-index")));
				param+="&xysd="+(6-parseInt($("#formRbxxglSh [data-option='xysd'] a.clibg").css("z-index")));
				param+="&bz="+$("#formRbxxgl [name='tgpjnr']").val();
			}else if($("#formRbxxglSh [name='ysjg']").val()=="0"){
				param+="&bz="+$("#formRbxxglSh [name='btgyy']").val();
			}
			
			
			doPost(basePath+"/xqfOrderAction/saleEnd",param,function(data){
				window.location.reload();
			});
		}
	});
	//申请验收
	$("a[data-option='ys']").click(function(){
		$("#moadl_tbxx").modal("show");
//			confirm("您确认申请验收吗？",function(data){
//				doPost(basePath+"/kfzOrderAction/applyAccept","rwid="+rwid,function(data){
//					window.location.reload();
//				});
//			});
		
	});
	$("a[data-option='sh']").click(function(){
		$("#moadl_shjsxx").modal("show");
//			confirm("您确认申请验收吗？",function(data){
//				doPost(basePath+"/kfzOrderAction/applyAccept","rwid="+rwid,function(data){
//					window.location.reload();
//				});
//			});
		
	});
	
	
});