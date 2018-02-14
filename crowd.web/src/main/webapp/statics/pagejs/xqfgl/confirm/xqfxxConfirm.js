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
	initUserInfo();
	saveUserInfo();
	
	$(".nav-tabs li a").click(function(){
		if($(this).attr("id")=="aBasic"){
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").hide();
			$("#ulBasicInfo").show();
		    $(".nav-tabs li a").removeClass("active");
			$("#aBasic").addClass("active");
		//	$(".fileinput-remove").attr("disabled",false); 
		}else if($(this).attr("id")=="aResume"){
			$("#ulBasicInfo").hide();
			$("#ulCardInfo").hide();
			$("#ulResumeInfo").show();
			 $(".nav-tabs li a").removeClass("active");
			$("#aResume").addClass("active");
		}else if($(this).attr("id")=="aCard"){
	    	 $("#ulBasicInfo").hide();
			 $("#ulResumeInfo").hide();
			 $("#ulCardInfo").show();
			 $(".nav-tabs li a").removeClass("active");
			 $("#aCard").addClass("active");
			
		}
	});
	
	function initUserInfo(){
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
				if(isNotEmpty(data.datas[0])){
					var shzt=data.datas[0].shzt;
					var shztHtml="";
					if(shzt=="1"){
						shztHtml='<p style="background-color:#EEE;padding-left:10px;padding-top:10px;font-size:18px;color:#32be77;margin-right:7px;">正在审核中!</p>';
						shztHtml+='<p style="margin-bottom:15px;background-color:#EEE;padding-left:10px;padding-bottom:10px;font-size:12px;color:#999;margin-right:7px;margin-top:-18px;">3个工作日内将为您审核身份，请耐心等待</p>';
					}else if(shzt=="2"){
						shztHtml='<p style="background-color:#EEE;padding-left:10px;padding-top:10px;font-size:18px;color:#32be77;margin-right:7px;">审核通过</p>';
						shztHtml+='<p style="margin-bottom:15px;background-color:#EEE;padding-left:10px;padding-bottom:10px;font-size:12px;color:#999;margin-right:7px;margin-top:-18px;">您已通过了开发者审核,成为crowd的一员,恭喜,您已经打了未来成功的一扇门!</p>';
					}else if(shzt=="3"){
						shztHtml='<p style="background-color:#EEE;padding-left:10px;padding-top:10px;font-size:18px;color:#F91818;margin-right:7px;">审核不通过!</p>';
						shztHtml+='<p style="margin-bottom:15px;background-color:#EEE;padding-left:10px;padding-bottom:10px;font-size:12px;color:#999;margin-right:7px;margin-top:-18px;">请重新提交你的身份认证信息</p>';
					}else{
						shztHtml='<p style="background-color:#EEE;padding-left:10px;padding-top:10px;font-size:18px;color:#F91818;margin-right:7px;">未提交!</p>';
						shztHtml+='<p style="margin-bottom:15px;background-color:#EEE;padding-left:10px;padding-bottom:10px;font-size:12px;color:#999;margin-right:7px;margin-top:-18px;">请提交你的身份认证信息</p>';
					}
					var html="";
					html='<div class="form-group col-md-12">'
						+shztHtml;
					    +'</div>';
					$("#first_p").after(html);
				}
				
				if(data.datas[0].shzt=='1'||data.datas[0].shzt=='2'){
					$("input[name='xm']").attr("readonly",true);
					$("input[name='sfzjh']").attr("readonly",true);
					$("#sfzzmztjidUpload").unbind("click");
					$("#sfzfmztjidUpload").unbind("click");
                    $("#saveCardInfo").hide();
				}else{
					$("#saveCardInfo").show();
				}
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
	}
	
	
	function saveUserInfo(){
		$("#saveCardInfo").click(function(){
			 $('#formCardInfo').bootstrapValidator("validate");
			 var formCardValidator = $('#formCardInfo').data('bootstrapValidator');
			 if(formCardValidator.isValid()){
				    var wid=$("#wid").val();
				    var basicData=$("#formCardInfo").serializeArray();
				    basicData.push({"name":"wid","value":wid});
				    basicData.push({"name":"shzt","value":1});
				    doPostBack(basePath+"/xqfSupply/saveOrUpdateXqfxxInfo",basicData,function(data){
						  window.location.href=basePath+"/xqfConfrim/index?flag=xqfconfirm";
			          });
			 }
		});
		
		$("#saveBasicInfo").click(function(){
			 $('#formBasicInfo').bootstrapValidator("validate");
			 var formCardValidator = $('#formBasicInfo').data('bootstrapValidator');
			 if(formCardValidator.isValid()){
				    var basicData=$("#formBasicInfo").serializeArray();
				    doPostBack(basePath+"/xqfSupply/saveOrUpdateXqfxxInfo",basicData,function(data){
						  window.location.href=basePath+"/xqfConfrim/index?flag=xqfconfirm";
			          });
			 }
		});
	}
	
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


