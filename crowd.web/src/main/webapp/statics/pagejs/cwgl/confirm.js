/**
 * 
 */
$(document).ready(function(){
	doPost(basePath+"/cwgl/czjl/rechargePage","wid="+wid,function(data){
		$("body").html(data.datas);
	});

	 function ajaxBack(data,callBack){
		 if (data.success == true) {
	        	if(callBack){
	        		callBack(data);
	        	}
	     } else{
	    	 if(parseInt(data.code)>=-14 && parseInt(data.code)<=-7){
	    		 window.location.href=basePath+"/error/index?errorCode="+data.code;
	    	 }else{
	    		 alert(data.msg);
	    	 }
	     }
	 }
	function doPost(url,params,callback,other){
		 var aContentType="";
		 $.ajax({
		 		  type: "POST",
		 		  url: url,
		 		  data: params,
		 		  dataType: 'json',  
		 		  success:function(data){
		 			  if(other){
		 				  $(other).attr("disabled",false);
		 			  }
		 			 ajaxBack(data,callback);
		 		  }
		 		});	
		 }
});