/**
 * 
 */
define(function(require, exports, module) {
	var $ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	//$('#formBasicInfo').bootstrapValidator();
    //$('#formResumeInfo').bootstrapValidator();
	//$('#formCardInfo').bootstrapValidator();
	$(".nav-tabs li a").click(function(){
		if($(this).attr("id")=="aBasic"){
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").hide();
			$("#ulBasicInfo").show();
		}else if($(this).attr("id")=="aResume"){
			$("#ulBasicInfo").hide();
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").show();
		}else if($(this).attr("id")=="aCard"){
			$("#ulBasicInfo").hide();
			$("#ulResumeInfo").hide();
			$("#ulCardInfo").show();
		}
	})
	
	$("#btnBasicNext").click(function(){
		 $('#formBasicInfo').bootstrapValidator("validate");
		 var formBasicValidator = $('#formBasicInfo').data('bootstrapValidator');
		 if(formBasicValidator.isValid()){
			 $(".nav-tabs li a").removeClass("active");
				$("#aResume").addClass("active");
				$("#ulBasicInfo").hide();
				$("#ulResumeInfo").show();
		 }
	});
	
	$("#btnResumePre").click(function(){
		
		$(".nav-tabs li a").removeClass("active");
		$("#aBasic").addClass("active");
		$("#ulResumeInfo").hide();
		$("#ulBasicInfo").show();
	});
	
	$("#btnResumeNext").click(function(){
		 $('#formResumeInfo').bootstrapValidator("validate");
	     var formResumeValidator = $('#formResumeInfo').data('bootstrapValidator');
		 if(formResumeValidator.isValid()){
			 $(".nav-tabs li a").removeClass("active");
				$("#aCard").addClass("active");
				$("#ulResumeInfo").hide();
				$("#ulCardInfo").show();
		 }
	});
	
	//初始化
	doPostBack("../kfzSupply/queryKfzxxInfo","",function(data){
		if(data.success&&isNotEmpty(data.datas)){
		    if(isNotEmpty(data.datas[0].grzpfjid)){
		         $("#grzpfjid").val(data.datas[0].grzpfjid);
		         var imgPath=basePath+"/image/preView?wid="+data.datas[0].grzpfjid;
				 $("#headImg").attr("src",imgPath);
            }
            if(isNotEmpty(data.datas[0].sfzzmztjid)){
		    	//$("#sfzzmztjidImg").attr("value","../image/preView?wid="+data.datas[0].sfzzmztjid);
		    	$("#sfzzmztjid").val(data.datas[0].sfzzmztjid);
		    	 var imgPath=basePath+"/image/preView?wid="+data.datas[0].sfzzmztjid;
				 $("#sfzzmztjidImg").attr("src",imgPath);
            }
            if(isNotEmpty(data.datas[0].sfzfmztjid)){
		    	$("#sfzfmztjid").val(data.datas[0].sfzfmztjid);
		    	 var imgPath=basePath+"/image/preView?wid="+data.datas[0].sfzfmztjid;
				 $("#sfzfmztjidImg").attr("src",imgPath);
            }
			$("#kfzxxWid").val(data.datas[0].wid);
			$("input[name='nc']").val(data.datas[0].nc);
			$("input[name='csrq']").val(format((data.datas[0].csrq)));
			$("input[name='qq']").val(data.datas[0].qq);
			$("input[name='wxh']").val(data.datas[0].wxh);
			$("input[name='qtjn'").val(data.datas[0].qtjn);
			$("textarea[name='gzjl']").text(data.datas[0].gzjl);
			$("textarea[name='xmjy']").text(data.datas[0].xmjy);
			$("input[name='zslj'").val(data.datas[0].zslj);
			$("input[name='xm'").val(data.datas[0].xm);
			$("input[name='sfzjh'").val(data.datas[0].sfzjh);
            if(isNotEmpty(data.datas[0].sfytd)){
            	$("select[name='sfytd']").val(data.datas[0].sfytd);
            }
            if(isNotEmpty(data.datas[0].kxsjid)){
            	$("select[name='kxsjid']").val(data.datas[0].kxsjid);
            }
            if(isNotEmpty(data.datas[0].gzlbdm)){
            	$("select[name='gzlbdm']").val(data.datas[0].gzlbdm);
            }
            if(isNotEmpty(data.datas[0].scjsdm)){
            	$("select[name='scjsdm']").val(data.datas[0].scjsdm);
            }
            if(isNotEmpty(data.datas[0].jygznx)){
            	$("select[name='jygznx']").val(data.datas[0].jygznx);
            }
            if(isNotEmpty(data.datas[0].gznx)){
            	$("select[name='gznx']").val(data.datas[0].gznx);
            }
            if(isNotEmpty(data.datas[0].gzxz)){
            	$("select[name='gzxz']").val(data.datas[0].gzxz);
            }
            if(isNotEmpty(data.datas[0].perProvince)){
            	$("select[name='perProvince']").val(data.datas[0].perProvince);
            }
            if(isNotEmpty(data.datas[0].perCity)){
            	$("select[name='perCity']").val(data.datas[0].perCity);
            }
            if(isNotEmpty(data.datas[0].perArea)){
            	$("select[name='perArea']").val(data.datas[0].perArea);
            }
           
		}
	});
	
	 var uploader=new Uploader({id:"headBrower",maxSize:1024*200,propExplain:"请上传照片",uploadedFunc:function(data){
			if(true){
				var imgPath=basePath+"/image/preView?wid="+uploader.params.value;
				$("#headImg").attr("src",imgPath);
				$("#grzpfjid").val(uploader.params.value);
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
	
	
	$("form").bootstrapValidator({  
	    excluded:[":disabled"]//关键配置，表示只对于禁用域不进行验证，其他的表单元素都要验证  
	});
	$("#saveKfzxxInfo").click(function(){
		 $('#formCardInfo').bootstrapValidator("validate");
		 $('#formResumeInfo').bootstrapValidator("validate");
		 $('#formCardInfo').bootstrapValidator("validate");
	     var formBasicValidator = $('#formBasicInfo').data('bootstrapValidator');
		 var formResumeValidator = $('#formResumeInfo').data('bootstrapValidator');
		 var formCardValidator = $('#formCardInfo').data('bootstrapValidator');
		 formBasicValidator.validate();
		 formResumeValidator.validate();
		 formCardValidator.validate();
		 
		 if(!formCardValidator.isValid()||!formResumeValidator.isValid()||!formBasicValidator.isValid()){
			 return ;
		 }
	/*	 if(!formBasicValidator.isValid()||!formResumeValidator.isValid()||!formCardValidator.isValid()){
			 //alert("有不合法的参数值");
			 return;
		 }
		*/
			    var basicData=$("#formBasicInfo").serializeArray();
				var resumeData=$("#formResumeInfo").serializeArray();
				var cardData=$("#formCardInfo").serializeArray();
				basicData.push({"name":"shzt","value":"1"});
				for(var i=0;i<resumeData.length;i++){
					basicData.push(resumeData[i]);
				}
				for(var i=0;i<cardData.length;i++){
					basicData.push(cardData[i]);
				}
			    //alert(JSON.stringify(basicData));
				doPostBack(basePath+"/kfzSupply/saveOrUpdateKfzxxInfo",basicData,function(data){
					   $("#formBasicInfo").empty();
					   $("#formResumeInfo").empty();
					   $("#formCardInfo").empty();
			       	  window.location.href=basePath+"/kfzSupply/index";
		          });
		    
	});
	
	
	initSelect();
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