/**
 * 
 */
define(function(require, exports, module) {

	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	//$('#formRbxxgl').bootstrapValidator();
	
	addEvent();
	function addEvent(){
		$("#btnAddRbxx").click(function(){
		//	document.getElementById("rbxx-edit-modal").reset();
			//
		//	var bootstrapValidator = $('#formRbxxgl').data('bootstrapValidator');
		//	bootstrapValidator.resetForm();
			$("#rbxx-edit-modal").modal("show");
		});
		
		$("#btnSave").click(function(){
			 var bootstrapValidator = $$('#formRbxxgl').data('bootstrapValidator');
			 bootstrapValidator.validate();
			 if(bootstrapValidator.isValid()){
				 
			 }
		});
	}
});
