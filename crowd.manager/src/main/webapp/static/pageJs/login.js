/**
 * 
 */

$(document).ready(function(){
	$("#btnLogin").click(function(){
		var datas=$('#mainForm').serializeArray();
		doPost(basePath+"/login/login",datas,function(data){
			window.location.href=basePath+"/registerUser/index";
		});
		
	});
	
});
