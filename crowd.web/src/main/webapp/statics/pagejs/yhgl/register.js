define(function(require, exports, module) {

	var $$ = jQuery = require('jquery');
	
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formRegister').bootstrapValidator();
	$$('#formCompany').bootstrapValidator();
	$("#divStep1").show();
	  $("#divStep2").hide();
	   if(flag=="1"){
		   $("#divSelect").hide();
		   if(isBuy){
			   $("#liStep2").removeClass("disabled").addClass("current");
			   $("#liStep3").removeClass("disabled").addClass("current");
			   $("#divStep1").hide();
			   $("#divStep2").hide();
			   $("#divStep3").show();
			   $("#divSupplygg").hide();
				$("#divBuygg").hide();
		   }else{
			   $("#liStep2").removeClass("disabled").addClass("current");
			   $("#divStep1").hide();
			   $("#divStep2").show();
			   $("#divStep3").hide();
			   $("#divSupplygg").show();
				$("#divBuygg").hide();
		   }
			$$("#formCompany").data('bootstrapValidator').resetForm();
			$("#formCompany")[0].reset();
			$("#formCompany [name='flag']").val("1");
	   }else if (flag=="2"){
		   $("#divSelect").hide();
		   if(isSupply){
			   $("#liStep2").removeClass("disabled").addClass("current");
			   $("#liStep3").removeClass("disabled").addClass("current");
			   $("#divStep1").hide();
			   $("#divStep2").hide();
			   $("#divStep3").show();
			   $("#divSupplygg").hide();
				$("#divBuygg").hide();
		   }else{
			   $("#liStep2").removeClass("disabled").addClass("current");
			   $("#divStep1").hide();
			   $("#divStep2").show();
			   $("#divStep3").hide();
			   $("#divSupplygg").hide();
				$("#divBuygg").show();
		   }
			$$("#formCompany").data('bootstrapValidator').resetForm();
			$("#formCompany")[0].reset();
			$("#formCompany [name='flag']").val("1");
	   }
	   //$("#liStep2").removeClass("disabled").addClass("current");
	$("#btnRegister").click(function(){
		 var bootstrapValidator = $$('#formRegister').data('bootstrapValidator');
		 bootstrapValidator.validate();
		 if(bootstrapValidator.isValid()){
	           doPost(basePath+"/register/register",$("#formRegister").serializeArray(),function(data){
	        	  // window.location.href=basePath+"/yhjbxx/index";
	        	   $("#divStep1").hide();
	        	   $("#divStep2").show();
	        	   $("#liStep2").removeClass("disabled").addClass("current");
	           });
	       }
	});
	setFormData();
	$("#btnSupply").click(function(){
		$("#btnSupply").removeClass("btn-default").addClass("btn-primary");
		$("#btnBuy").removeClass("btn-primary").addClass("btn-default");
		$("#divSupplygg").show();
		$("#divBuygg").hide();
		$$("#formCompany").data('bootstrapValidator').resetForm();
		$("#formCompany")[0].reset();
		$("#formCompany [name='flag']").val("1");
		flag="1";
		$("#btnSaveCompany").html("提交并开通广告商铺");
	});
	
	function setFormData(){
		if(isBuy || isSupply){
			doGet(basePath+"/register/select","",function(data){
				if(data && data.datas){
					for(var key in data.datas){
					var _control=$("#formCompany [name='"+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formBzzy [name='"+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
					}else{
						_control.val(data.datas[key]);	
					}
					}
					setCity(data.datas.area,data.datas.city);
					setXian(data.datas.city,data.datas.xian);
					if(data.datas.sfybz==1){
						$("#btnBz").html("已标注");
						$("#btnBz").css("color","green");
						$("#btnBz i").removeClass("fa-close").addClass("fa-check");
					}
				}
			});
		}
		
	}
	$("#btnSaveCompany").click(function(){
		 var bootstrapValidator = $$('#formCompany').data('bootstrapValidator');
		 bootstrapValidator.validate();
		 if(bootstrapValidator.isValid()){
			 doPost(basePath+"/register/saveCompanyInfo?registerFlag="+flag,$("#formCompany").serializeArray(),function(data){
				 $("#divStep3").hide();
				 $("#divStep4").show();
				 $("#liStep4").removeClass("disabled").addClass("current");
	           });
		 }
	});
	
	$("#btnBuy").click(function(){
		$("#btnBuy").removeClass("btn-default").addClass("btn-primary");
		$("#btnSupply").removeClass("btn-primary").addClass("btn-default");
		$("#divSupplygg").hide();
		$("#divBuygg").show();
		flag="2";
		
		$$("#formCompany").data('bootstrapValidator').resetForm();
		$("#formCompany")[0].reset();
		$("#formCompany [name='flag']").val("2");
		$("#btnSaveCompany").html("提交完善企业信息");
	});
	$("#btnKtSupply").click(function(){
		$("#formCompany [name='flag']").val("1");
		$("#liStep3").removeClass("disabled").addClass("current");
		$("#divStep2").hide();
		$("#divStep3").show();
		
	});
	
	function setCity(_value,data2){
		doGetSelect(basePath+"/dictionary/selectCity","parentBm="+_value,"#formCompany [name='city']",data2);
	}
	$("#formCompany [name='area']").change(function(){
		var _value=$(this).val();
		setCity(_value);
	});
	function setXian(_value,data2){
		doGetSelect(basePath+"/dictionary/selectCity","parentBm="+_value,"#formCompany [name='xian']",data2);
	}
	$("#formCompany [name='city']").change(function(){
		var _value=$(this).val();
		setXian(_value);
	});
	$("#btnKtBuy").click(function(){
		$("#formCompany [name='flag']").val("2");
		$("#liStep3").removeClass("disabled").addClass("current");
		$("#divStep2").hide();
		$("#divStep3").show();
	});
	$("#btnGetVerification").click(function(){
		$$("#formRegister").data('bootstrapValidator').resetForm();
		$$('#formRegister').bootstrapValidator("updateStatus","sjh","NOT_VALIDATED");
		$$("#formRegister").data('bootstrapValidator').validateField("sjh");
		var bootstrapValidator = $$('#formRegister').data('bootstrapValidator');
		  var _sjh=$("input[name='sjh']").val();
		  if(_sjh==""||!(/^1[34578]\d{9}$/.test(_sjh))){
			  return;
		  }
		  $("#btnGetVerification").attr("disabled",true);
		  $("#btnGetVerification").val("正在发送...");
		if($.trim(_sjh)){
			doPostBack(basePath+"/register/sendVerification",{phone:_sjh},function(data){
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
					$$("#formRegister").data('bootstrapValidator').resetForm();
					$("#btnGetVerification").val("点击获取验证码"); 
        			$("#btnGetVerification").attr("disabled",false);
        			if(data.code=="-4"){
		               $("input[name='sjh']").parent("div").after('<small class="help-block" data-bv-validator="regexp" data-bv-for="sjh" data-bv-result="INVALID" style="display: inline;color:#f96868;">'+data.msg+'</small>');
                    }else{
 		               $("input[name='sjh']").parent("div").after('<small class="help-block" data-bv-validator="regexp" data-bv-for="sjh" data-bv-result="INVALID" style="display: inline;color:#f96868;">'+data.msg+'</small>');
                    }
				}
			});
		}
	});
	var map = new BMap.Map("allmap");  // 创建Map实例
	setMap();
	
	function setMap(){
		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
		var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角
		map.addControl(top_left_control);        
		map.addControl(top_left_navigation);     
		map.addControl(top_right_navigation); 
		var menu = new BMap.ContextMenu();
		var txtMenuItem=[{text:'标注',callback:function(e){
			map.clearOverlays();
			var point = new BMap.Point(e.lng, e.lat);
			
			var marker = new BMap.Marker(point);        // 创建标注    
			map.addOverlay(marker);
			$("#formCompany [name='sfybz']").val("1");
			$("#formCompany [name='lng']").val(e.lng);
			$("#formCompany [name='lat']").val(e.lat);
			$("#btnBz").html("已标注");
			$("#btnBz").css("color","green");
			$("#btnBz i").removeClass("fa-close").addClass("fa-check");
		}}];
		for(var i=0; i < txtMenuItem.length; i++){
			menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
		}
		map.addContextMenu(menu);
	}
	$("#btnBz").click(function(){
		if($("#formCompany [name='area']").val()==""){
			$("#formCompany [name='area']")[0].focus();
			alert("请选择所在地区！");
			return;
		}
		var _areaName=$("#formCompany [name='area']").find("option:selected").text();
		var _cityName="",_xianName="";
		if($("#formCompany [name='city']").val()!=""){
			_cityName=$("#formCompany [name='city']").find("option:selected").text();
		}
		if($("#formCompany [name='xian']").val()!=""){
			_xianName=$("#formCompany [name='xian']").find("option:selected").text();
		}
		$("#bzModal").modal("show");
		
		map.centerAndZoom(_areaName+_cityName+_xianName,14); 
		if($("#formCompany [name='sfybz']").val()=="1"){
			var _point = new BMap.Point($("#formCompany [name='lng']").val(), $("#formCompany [name='lat']").val());
			var marker = new BMap.Marker(_point);        // 创建标注    
			map.addOverlay(marker);
			map.panTo(_point);
		}
		
		
		
		
	});
	/*获取短信验证码*/
	var $phone = $("button.phone_code");
	if($phone.length){
		var wait=90;
		function time(o) {
			if (wait == 0) {
				o.attr("disabled",false);           
				o.find('span.badge').html('');
				wait = 90;
			} else {
				o.find('span.badge').html(wait);
				wait--;
				setTimeout(function() {
					time(o);
				},
				1000)
			}
		}
		$phone.click(function(){
			var my = $(this),tel = $("input[name='username']");
			if(tel.val()==''||!/^1[0-9]{10}$/.test(tel.val())){
				require.async('pub/bootstrap/modal/alert',function(event){
					event.malert(tel.data('phone-message'));
				});
			}else{
				$.ajax({
				   type: "POST",
				   url: $(this).data("url")+'&phone='+tel.val(),
				   success: function(msg){
						if(msg == 'SUCCESS'){
							my.attr('disabled',true);
							my.html(my.data('retxt') + ' <span class="badge"></span>');
							time(my);
						}else{
							require.async('pub/bootstrap/modal/alert',function(event){
								event.malert(msg);
							});
						}
				   }
				});
			}
		});
	}
	
		
});