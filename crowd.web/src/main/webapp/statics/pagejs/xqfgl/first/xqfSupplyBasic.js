/**
 * 
 */
define(function(require, exports, module) {
	var $ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	initSelect();
	
	$(".nav-tabs li a").click(function(){
		if($(this).attr("id")=="aBasic"){
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").hide();
			$("#ulBasicInfo").show();
		    $(".nav-tabs li a").removeClass("active");
			$("#aBasic").addClass("active");
			
		}else if($(this).attr("id")=="aResume"){
			$("#ulBasicInfo").hide();
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").show();
			 $(".nav-tabs li a").removeClass("active");
			$("#aResume").addClass("active");
		}else if($(this).attr("id")=="aCard"){
			// $('#formBasicInfo').bootstrapValidator("validate");
		    //   var formBasicValidator = $('#formBasicInfo').data('bootstrapValidator');
			 //     if(formBasicValidator.isValid()){
			    	 $("#ulBasicInfo").hide();
					 $("#ulResumeInfo").hide();
					 $("#ulCardInfo").show();
					 $(".nav-tabs li a").removeClass("active");
					 $("#aCard").addClass("active");
			//     }
		}
	});
	
	
	//下一步
	$("#btnBasicNext").click(function(){
	   $('#formBasicInfo').bootstrapValidator("validate");
	    var formBasicValidator = $('#formBasicInfo').data('bootstrapValidator');
		formBasicValidator.validate();
	     if(formBasicValidator.isValid()){
			        $(".nav-tabs li a").removeClass("active");
					$("#aCard").addClass("active");
					$("#ulBasicInfo").hide();
					$("#ulCardInfo").show();
	     }
		
	});
	
	$("#btnResumePre").click(function(){
		$(".nav-tabs li a").removeClass("active");
		$("#aBasic").addClass("active");
		$("#ulCardInfo").hide();
		$("#ulBasicInfo").show();
	});
	
	$("form").bootstrapValidator({  
	    excluded:[":disabled"]//关键配置，表示只对于禁用域不进行验证，其他的表单元素都要验证  
	});
	$("#saveXqfxxInfo").click(function(){
		   $('#formBasicInfo').bootstrapValidator("validate");
		   $('#formCardInfo').bootstrapValidator("validate");
			 var formCardValidator = $('#formCardInfo').data('bootstrapValidator');
			 var formBasicValidator = $('#formBasicInfo').data('bootstrapValidator');
		     if(formCardValidator.isValid()&&formBasicValidator.isValid()){
		    	  var basicData=$("#formBasicInfo").serializeArray();
		    	  var cardData=$("#formCardInfo").serializeArray();
		    	  for(var i=0;i<cardData.length;i++){
						basicData.push(cardData[i]);
					}
		    	  basicData.push({"name":"shzt","value":"1"});
			      doPostBack(basePath+"/xqfSupply/saveOrUpdateXqfxxInfo",basicData,function(data){
			    	  if(data.success){
			    		  window.location.href=basePath+"/xqfSupply/index";
			    	  }
		          });
		     }
	});
    
	//上传
	 var uploader=new Uploader({id:"headBrower",maxSize:1024*200,propExplain:"请上传照片",uploadedFunc:function(data){
			if(true){
				var imgPath=basePath+"/image/preView?wid="+uploader.params.value;
				$("#headImg").attr("src",imgPath);
				$("#zpfjid").val(uploader.params.value);
			}
		}});
	$("#headUpload").click(function(){
		$("#f_headBrower").trigger("click");
	});
	
	
	 var sfzzmztjidUploader=new Uploader({id:"sfzzmztjidBrower",maxSize:1024*200,propExplain:"请上传照片",uploadedFunc:function(data){
			if(true){
				var imgPath=basePath+"/image/preView?wid="+sfzzmztjidUploader.params.value;
				$("#sfzzmztjidImg").attr("src",imgPath);
				$("#sfzzmztjid").val(sfzzmztjidUploader.params.value);
			}
		}});
	$("#sfzzmztjidUpload").click(function(){
		$("#f_sfzzmztjidBrower").trigger("click");
	});
	
	 var sfzfmztjidUploader=new Uploader({id:"sfzfmztjidBrower",maxSize:1024*200,propExplain:"请上传照片",uploadedFunc:function(data){
			if(true){
				var imgPath=basePath+"/image/preView?wid="+sfzfmztjidUploader.params.value;
				$("#sfzfmztjidImg").attr("src",imgPath);
				$("#sfzfmztjid").val(sfzfmztjidUploader.params.value);
			}
		}});
	$("#sfzfmztjidUpload").click(function(){
		$("#f_sfzfmztjidBrower").trigger("click");
	});
	//初始化
	doSynchrPostBack("../xqfSupply/queryXqfxxInfo","",function(data){
		if(data.success&&isNotEmpty(data.datas)){
		    if(isNotEmpty(data.datas[0].zpfjid)){
		    	 $("#zpfjid").val(data.datas[0].zpfjid);
		         var imgPath=basePath+"/image/preView?wid="+data.datas[0].zpfjid;
				 $("#headImg").attr("src",imgPath);
            }
            if(isNotEmpty(data.datas[0].sfzzmztjid)){
		    	$("#sfzzmztjid").val(data.datas[0].sfzzmztjid);
		   	     var imgPath=basePath+"/image/preView?wid="+data.datas[0].sfzzmztjid;
			    $("#sfzzmztjidImg").attr("src",imgPath);
            }
            if(isNotEmpty(data.datas[0].sfzfmztjid)){
		    	$("#sfzfmztjid").val(data.datas[0].sfzfmztjid);
		    	 var imgPath=basePath+"/image/preView?wid="+data.datas[0].sfzfmztjid;
				 $("#sfzfmztjidImg").attr("src",imgPath);
            }
			$("#wid").val(data.datas[0].wid);
			$("input[name='nc']").val(data.datas[0].nc);
			$("input[name='xqfdwmc']").val(data.datas[0].xqfdwmc);
			$("input[name='qqh']").val(data.datas[0].qqh);
			$("input[name='wxh']").val(data.datas[0].wxh);
			$("input[name='xm'").val(data.datas[0].xm);
			$("input[name='sfzjh'").val(data.datas[0].sfzjh);
            
            if(isNotEmpty(data.datas[0].perProvince)){
            	$("select[name='perProvince']").val(data.datas[0].perProvince);
            }
            if(isNotEmpty(data.datas[0].perCity)){
            	$("select[name='perCity']").val(data.datas[0].perCity);
            }
            if(isNotEmpty(data.datas[0].perArea)){
            	$("select[name='perArea']").val(data.datas[0].perArea);
            }
            if(isNotEmpty(data.datas[0].xqflb)){
            	$("select[name='xqflb']").val(data.datas[0].xqflb);
            }
            if(isNotEmpty(data.datas[0].userRange)){
            	$("select[name='userRange']").val(data.datas[0].userRange);
            }
		}
	});
	
	
	function initSelect(){
		//省
		$("select[name='perProvince']").change(function(){
			 var value=$(this).find("option:selected").attr("value");
			 var text=$(this).find("option:selected").text();
			 
	             if(isEmpty(value)){
	            	 return;
	             }
			 $("select[name='perCity']").empty();
			 var url=basePath+"/kfzSupply/queryXzqhInfoList";
             var params={ls:value};
             doSynchrPostBack(url, params, function(data){
					var result=data.datas;
					for(var i=0;i<result.length;i++){
						if(i==0){
							value=result[i].lbdm;
						}
						$("select[name='perCity']").append("<option  value="+result[i].lbdm+">"+result[i].lbmc+"</option>");
		            }
				});
           
             $("select[name='perArea']").empty();
             var params={ls:value};
             doSynchrPostBack(url, params, function(data){
					var result=data.datas;
					for(var i=0;i<result.length;i++){
						$("select[name='perArea']").append("<option value="+result[i].lbdm+">"+result[i].lbmc+"</option>");
		            }
				});
             
		});
		//市
		$("select[name='perCity']").change(function(){
			
			 var value=$(this).find("option:selected").attr("value");
             var params={ls:value};
             if(isEmpty(value)){
            	 return;
             }
             $("select[name='perArea']").empty();
             var url=basePath+"/kfzSupply/queryXzqhInfoList";
             doPostBack(url, params, function(data){
					var result=data.datas;
					for(var i=0;i<result.length;i++){
						$("select[name='perArea']").append("<option value="+result[i].lbdm+">"+result[i].lbmc+"</option>");
		            }
				});
			
		});
		
	}
	
	
	/*$('#formBasicInfo').bootstrapValidator({
		 message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
		  fields: {
			  nc: {
	             message: '昵称验证失败',
	             validators: {
	                 notEmpty: {
	                     message: '昵称不能为空'
	                 }
	             }
	         }
	    }
	});*/
	 function add0(m){return m<10?'0'+m:m }
	 function format(shijianchuo)
	 {
	 //shijianchuo是整数，否则要parseInt转换
	 var time = new Date(shijianchuo);
	 var y = time.getFullYear();
	 var m = time.getMonth()+1;
	 var d = time.getDate();
	
	 return y+'-'+add0(m)+'-'+add0(d);
	 }
});


