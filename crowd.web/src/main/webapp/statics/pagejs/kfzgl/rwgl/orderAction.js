/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	//申请验收
	$("a[data-option='sqys']").click(function(){
		
			confirm("您确认申请验收吗？",function(data){
				doPost(basePath+"/kfzOrderAction/applyAccept","rwid="+rwid,function(data){
					window.location.reload();
				});
			});
		
	});
});