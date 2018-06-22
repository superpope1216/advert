define(function(require, exports, module) {
	
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	addEvent();
	
	function addEvent(){
		//注册按钮 
		$("#btnRegister").click(function(){
			 $$('#userRegister').bootstrapValidator("validate");
			 var bootstrapValidator = $$('#userRegister').data('bootstrapValidator');
			 if(bootstrapValidator.isValid()){
				    var basicData=$("#userRegister").serializeArray();
				    var sjh=$("input[name='sjh']").val();
				    basicData.push({name:"phone",value:sjh});
		            doPost(basePath+"/resetPwd/doResetPwd",basicData,function(data){
		       	   if(data.success){
	        		    window.location.href=basePath+"/login/index";
		        	   }else{
		        		  alert(data.msg);
		        	   }
		          });
		       }
		});
		//点击获取验证码
		$("#btnGetVerification").click(function(){
			  $$("#userRegister").bootstrapValidator("validate");
			  $$("#userRegister").data('bootstrapValidator').resetForm();
			  $$("#userRegister").data('bootstrapValidator').validateField("sjh");
			  var bootstrapValidator = $$('#userRegister').data('bootstrapValidator');
			  var sjh=$("input[name='sjh']").val();
			  if(sjh==""||!(/^1[34578]\d{9}$/.test(sjh))){
				  return;
			  }
			  $("#btnGetVerification").attr("disabled",true);
			  $("#btnGetVerification").val("正在发送...");
			doPostBack(basePath+"/resetPwd/sendVerification",{phone:sjh},function(data){
				if(data.success){
					var times = 60;
		        	var timer = setInterval(function() {
		        		if (times < 1) {
		        			clearInterval(timer); 
		        			$("#btnGetVerification").val("点击获取验证码"); 
		        			$("#btnGetVerification").attr("disabled",false); 
		        			return;
		        		}
		        		$("#btnGetVerification").val("已发送 ("+ times +")");
		        		times --;
		        	}, 1000);
				}else{
				    $$("#userRegister").data('bootstrapValidator').resetForm();
					$("#btnGetVerification").val("点击获取验证码"); 
        			$("#btnGetVerification").attr("disabled",false);
        			if(data.code=="-4"){
		               $("input[name='sjh']").parent("div").after('<small class="help-block" data-bv-validator="regexp" data-bv-for="sjh" data-bv-result="INVALID" style="display: inline;color:#f96868;">'+data.msg+'</small>');
                    }else{
	        		   $("input[name='sjh']").parent("div").after('<small class="help-block" data-bv-validator="regexp" data-bv-for="sjh" data-bv-result="INVALID" style="display: inline;color:#f96868;">'+data.msg+'</small>');
                    }
				}
			});
		 });
	}
	
	
});