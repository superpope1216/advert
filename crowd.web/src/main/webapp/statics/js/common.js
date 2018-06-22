/**
 * 
 */
 $('.datepicker').datepicker({
    language: 'zh-CN',
    autoclose:true
});
 
 
 function getDszyMoney(_data){
	 if(_data.gglx=='1' && _data.advert_type=="1"){
			return _data.jg+"折";
		}else if(_data.gglx=='1' && _data.advert_type=="2"){
			return _data.jg;
		}else{
			return _data.jg;
		}
 }
 function getImagePath(rwxs,kfkj){
	 if(rwxs=='1'){
		 if(kfkj=="1"){
			 return "emap";
		 }else if(kfkj=="2"){
			 return "epstar";
		 }else if(kfkj=="3"){
			 return "cmstar";
		 }else if(kfkj=="4"){
			 return "home";
		 }else if(kfkj=="5"){
			 return "mobile";
		 }else if(kfkj=="9"){
			 return "other";
		 }
	 }else if(rwxs=="2"){
		 return "doing";
	 }else if(rwxs=="3"){
		 return "ui";
	 }else if(rwxs=="4"){
		 return "market";
	 }else if(rwxs=="5"){
		 return "buy";
	 }else if(rwxs=="6"){
		 return "train";
	 }else if(rwxs=="7"){
		 return "test";
	 }
 }
 function doSyncGet(url,params,callback){
	 $.ajax({
	 		  type: "GET",
	 		  url: url,
	 		  async:false,
	 		  data: params,
	 		  dataType: 'json',  
	 		  success:function(data){
	 			 ajaxBack(data,callback);
	 		  }
	 		});	
	 }
 
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

 function doGet(url,params,callback,other){
	 $.ajax({
	 		  type: "GET",
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
 
 
 

 function setSelect(obj,text,data,value,callback){
	 $(obj).empty();
	 if(!text){
		 text="--请选择--";
	 }
	 var str="<option value=''>"+text+"</option>";
	 if(data){
		 if(data && data.length>0){
			 for(var i=0;i<data.length;i++){
				 var checked="";
				if(value && value==data[i].lbdm){
					checked=" selected='selected' ";
				}
				 str+="<option "+checked+" value='"+data[i].lbdm+"'>"+data[i].lbmc+"</option>"
			 }
		 }
		
	 }
	 $(obj).append(str);
	 if(callback){
		 callback();
	 }
 }
 
 function doGetSelect(url,params,obj,data2,callBack){
	 doGet(url,params,function(data){
		 var str="<option value=''>--请选择--</option>";
		 if(data.datas && data.datas.length>0){
			 for(var i=0;i<data.datas.length;i++){
				 var checked="";
				if(data2 && data2==data.datas[i].lbdm){
					checked=" selected='selected' ";
				}
				 str+="<option "+checked+" value='"+data.datas[i].lbdm+"'>"+data.datas[i].lbmc+"</option>"
			 }
		 }
		 $(obj).html(str);
		 if(callBack){
				 callBack(data);
		}
	 });
 }
 function doGetSelect2(tblName,obj,data2,callBack){
	 doGet(basePath+"/zdbdetail/list","tableName="+tblName,function(data){
		 $(obj).empty();
		 var str="<option value=''>--请选择--</option>";
		 if(data.data && data.data.length>0){
			 for(var i=0;i<data.data.length;i++){
				 var checked="";
				if(data2 && data2==data.data[i].lbdm){
					checked=" selected='selected' ";
				}
				 str+="<option "+checked+" value='"+data.data[i].lbdm+"'>"+data.data[i].lbmc+"</option>"
			 }
		 }
		 $(obj).append(str);
		 if(callBack){
				 callBack();
		}
	 });
 }

 function doGetMulSelect(url,params,obj,data2,callBack){
	 $.ajax({
	 		  type: "GET",
	 		  url: url,
	 		  data: params,
	 		  dataType: 'json',  
	 		  success:function(data){
	 			 $(obj).empty();
	 			 var str="";
	 			 if(data && data.success){
	 				 
	 				 if(data.data && data.data.length>0){
	 					 for(var i=0;i<data.data.length;i++){
	 						 var checked="";
	 						if(data2 && data2==data.data[i].LBDM){
	 							checked=" selected='selected' ";
	 						}
	 						 str+="<option "+checked+" value='"+data.data[i].LBDM+"'>"+data.data[i].LBMC+"</option>"
	 					 }
	 				 }
	 				
	 			 }
	 			 $(obj).append(str);
	 			 if(callBack){
	 				 callBack();
	 			 }
	 		  }
	 		});	
	 }
   function isEmpty(obj){
		if(obj==""||obj==null){
			return true;
		}
		return false;
	}

	function isNotEmpty(obj){
		if(obj==""||obj==null){
			return false;
		}
		return true;
	}
	
	function toStr(obj){
		if(obj==undefined || obj==null){
			return "";
		}
		return obj;
	}
	function doPostBack(url, params, callback) {
		var aContentType = "";
		$.ajax({
			type : "POST",
			url : url,
			data : params,
			dataType : 'json',
			success : function(data) {
				if(callback){
					callback(data);
				}
			}
		});
	}
	
	function doSynchrPostBack(url, params, callback) {
		var aContentType = "";
		$.ajax({
			type : "POST",
			url : url,
			async:false,
			data : params,
			dataType : 'json',
			success : function(data) {
				if(callback){
					callback(data);
				}
			}
		});
	}
	
	function resetAlert() {
		  alertify.set({
		    labels : {
		      ok   : "确认",
		      cancel : "取消"
		    },
		    delay:3000,
		    buttonReverse : false,
		    buttonFocus  : "ok"
		  });
		};
		function resetConfirm() {
			  alertify.set({
			    labels : {
			      ok   : "确认",
			      cancel : "取消"
			    },
			    
			    buttonReverse : false,
			    buttonFocus  : "ok"
			  });
			};
	window.alert=function(msg,callback){
		resetAlert();
		alertify.alert(msg,function(){
			if(callback){
				callback();
			}
		});
		
	}
	
	window.confirm=function(msg,callBack){
		resetConfirm();
			
			
		   alertify.confirm(msg, function (e) {
		     if (e) {
		       //alertify.success("点击确认");
		    	 if(callBack){
		    		 callBack();
		    	 }
		     } else {
		       //alertify.error("点击取消");
		     }
		   });
	}
	
 