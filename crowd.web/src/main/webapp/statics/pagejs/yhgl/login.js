define(function(require, exports, module) {

	var $ = jQuery = require('jquery');
	
	require('plugins/vendor/bootstrap/validator/entrance');
	$('.login_index form').bootstrapValidator();
	
	$("#btnLogin").click(function(){
		 var bootstrapValidator = $('.login_index form').data('bootstrapValidator');
		 bootstrapValidator.validate();
		 if(bootstrapValidator.isValid()){
	           doPost(basePath+"/login/login",$(".login_index form").serializeArray(),function(data){
	        	   if(backurl){
	        		   window.location.href=backurl;
	        	   }else{
	        		   window.location.href=basePath+"/index.jsp";
	        	   }
	           });
	       }
	});	
});