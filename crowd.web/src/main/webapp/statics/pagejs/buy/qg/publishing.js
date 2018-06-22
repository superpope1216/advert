/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formQgInfo').bootstrapValidator();
	init();
	function init(){
		setFormData();
	}
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formQgInfo').data('bootstrapValidator');
		bootstrapValidator.validate();
		if (bootstrapValidator.isValid()){
			confirm("您确认要发布该广告吗？",function(){
				doPost(basePath+"/buyQgPublishing/publishing",$("#formQgInfo").serializeArray(),function(){
					alert("发布成功",function(){
						window.location.href=basePath+"/buyQg/index";
					});
					
				});
			});
		}
				
	});
	function setFormData(){
		if(wid){
			doGet(basePath+"/buyQgPublishing/select","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formQgInfo [name='"+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formQgInfo [name='"+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
						}else{
							_control.val(data.datas[key]);	
						}
					};
				}
			});
		}
	}
	
});