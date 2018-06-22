/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	
	
	$$('#formHwzy').bootstrapValidator();
	
	$('#formHwzy [name="zztfrq"]').datepicker({
	    language: 'zh-CN',
	    autoclose:true,
	    todayHighlight:true
	}).on('hide',function(ev){
		 $$('#formHwzy').data('bootstrapValidator').updateStatus('zztfrq', 'NOT_VALIDATED',null).validateField('zztfrq');
	});	
	$('#formHwzy [name="ssqdqr"]').datepicker({
	    language: 'zh-CN',
	    autoclose:true,
	    todayHighlight:true
	}).on('hide',function(ev){
		 $$('#formHwzy').data('bootstrapValidator').updateStatus('ssqdqr', 'NOT_VALIDATED',null).validateField('ssqdqr');
	});	
	init();
	
	function init(){
		initEvent();
		//initUploader();
		setFormData();
	}
	function sctpUploader(wid){
		$("#sctuljuploadBtn").ajaxImageUpload({
			url: basePath+'/attr/upload', //上传的服务器地址
		    data: { },
		    wid:wid,
		    id:"sctuljUploadBox",
		    maxNum: 1, //允许上传图片数量
		    hidenInputName:'', // 上传成功后追加的隐藏input名，注意不要带[]，会自动带[]，不写默认和上传按钮的name相同
		    zoom: true, //允许上传图片点击放大
		    allowType: ["gif", "jpeg", "jpg", "bmp",'png'], //允许上传图片的类型
		    maxSize :2, //允许上传图片的最大尺寸，单位M
		    deleteCallBack:function(){
		    	$("#formHwzy [name='sctplj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formHwzy [name='sctplj']").val(data.fileWids);
		    	$("#divSctplj").removeClass("has-error").addClass("has-success");
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	
	
	function setFormData(){
		if(wid){
			doGet(basePath+"/hwzyPublishing/select","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formHwzy [name='"+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formHwzy [name='gbzyInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
						}else{
							_control.val(data.datas[key]);	
						}
					};
					if(data.datas.advertType){
						setAdvertType(data.datas.advertType);
					}
					setArea(data.datas.area);
					
					setCity(data.datas.area,data.datas.city);
					setXian(data.datas.city,data.datas.xian);
					setQy(data.datas.advertType,data.datas.qy);
					setXs(data.datas.advertType,data.datas.xs);
					if(data.datas.xian){
						setXianXx(data.datas.xian,data.datas.tvId);
					}else if(data.datas.city){
						setCityXx(data.datas.city,data.datas.tvId);
					}else{
						setAreaXx(data.datas.area,data.datas.tvId);
					}
					sctpUploader(data.datas.sctplj);
			}
		});
		}else{
			sctpUploader(null);
		}
	}
	function initEvent(){
		$("#formHwzy [name='advertType']").change(function(){
			var _adverType=$(this).val();
			$("#formHwzy [name='area']").val("");
			setArea("");
			setCity("");
			setXian("");
			setQy(_adverType);
			setXs(_adverType);
			setAreaXx("");
			setAdvertType(_adverType);
		});
		$("#formHwzy [name='area']").change(function(){
			var _area=$(this).val();
			setArea(_area);
			setCity(_area);
			setXian("");
			setAreaXx(_area);
		});
		$("#formHwzy [name='city']").change(function(){
			var _city=$(this).val();
			setXian(_city);
			setCityXx(_city);
		});
		$("#formHwzy [name='xian']").change(function(){
			var _xian=$(this).val();
			setXianXx(_xian);
		});
		
	}
	
	function setArea(_value){
		if(_value==""){
			$("#divQy").hide();
			$("#divXs").hide();
		}else{
			$("#divQy").show();
			$("#divXs").show();
		}
	}
	function setAdvertType(_value){
		
		if(_value==""){
			$("#divAdvertType").hide();
			$("#divHwxx").hide();
		}else{
			$("#divAdvertType").show();
			if(_value=="1"){
				$("#labelName").html("选择高速");
				$("#divHwxx").show();
			}else if(_value=="2"){
				$("#labelName").html("选择国道");
				$("#divHwxx").show();
			}else if(_value=="3"){
				$("#labelName").html("选择省道");
				$("#divHwxx").show();
			}else if(_value=="4"){
				$("#labelName").html("选择主干道");
				$("#divHwxx").show();
			}else if(_value=="5"){
				$("#labelName").html("选择机场高速");
				$("#divHwxx").show();
			}else if(_value=="6"){
				$("#labelName").html("选择商业区");
				$("#divHwxx").show();
			}else if(_value=="7"){
				$("#labelName").html("选择商场");
				$("#divHwxx").show();
			}else if(_value=="8"){
				$("#labelName").html("选择广场");
				$("#divHwxx").show();
			}else if(_value=="9"){
				$("#labelName").html("选择社区");
				$("#divHwxx").show();
			}else if(_value=="10"){
				$("#labelName").html("选择写字楼");
				$("#divHwxx").show();
			}else if(_value=="11"){
				$("#labelName").html("");
				$("#divHwxx").hide();
			}else if(_value=="12"){
				$("#labelName").html("");
				$("#divHwxx").hide();
			}else if(_value=="13"){
				$("#labelName").html("选择地铁");
				$("#divHwxx").show();
			}else if(_value=="14"){
				$("#labelName").html("选择地铁站");
				$("#divHwxx").show();
			}else if(_value=="15"){
				$("#labelName").html("选择高铁动车");
				$("#divHwxx").hide();
			}else if(_value=="16"){
				$("#labelName").html("选择高铁站");
				$("#divHwxx").show();
			}else if(_value=="17"){
				$("#labelName").html("选择火车");
				$("#divHwxx").hide();
			}else if(_value=="18"){
				$("#labelName").html("选择火车站");
				$("#divHwxx").show();
			}else if(_value=="19"){
				$("#labelName").html("选择机场");
				$("#divHwxx").show();
			}else if(_value=="20"){
				$("#labelName").html("选择长途汽车");
				$("#divHwxx").hide();
			}else if(_value=="21"){
				$("#labelName").html("选择长途汽车站");
				$("#divHwxx").show();
			}else if(_value=="22"){
				$("#labelName").html("选择学校");
				$("#divHwxx").show();
			}else if(_value=="23"){
				$("#labelName").html("选择驾校");
				$("#divHwxx").hide();
			}else if(_value=="24"){
				$("#labelName").html("选择医院");
				$("#divHwxx").hide();
			}else if(_value=="25"){
				$("#labelName").html("选择超市");
				$("#divHwxx").show();
			}else if(_value=="26"){
				$("#labelName").html("选择酒店");
				$("#divHwxx").hide();
			}else if(_value=="27"){
				$("#labelName").html("选择餐饮");
				$("#divHwxx").hide();
			}else if(_value=="28"){
				$("#labelName").html("选择银行");
				$("#divHwxx").hide();
			}else if(_value=="29"){
				$("#labelName").html("选择电影院");
				$("#divHwxx").show();
			}else if(_value=="30"){
				$("#labelName").html("选择场馆");
				$("#divHwxx").show();
			}else if(_value=="31"){
				$("#labelName").html("选择会所");
				$("#divHwxx").show();
			}else if(_value=="32"){
				$("#labelName").html("选择景区");
				$("#divHwxx").show();
			}else if(_value=="33"){
				$("#labelName").html("选择园林");
				$("#divHwxx").show();
			}else if(_value=="34"){
				$("#labelName").html("选择轻轨");
				$("#divHwxx").show();
			}else if(_value=="35"){
				$("#labelName").html("选择娱乐场所");
				$("#divHwxx").show();
			}else if(_value=="36"){
				$("#labelName").html("选择公共自行车");
				$("#divHwxx").hide();
			}else if(_value=="37"){
				$("#labelName").html("选择高尔夫球场");
				$("#divHwxx").hide();
			}else if(_value=="38"){
				$("#labelName").html("选择码头");
				$("#divHwxx").show();
			}
			
		}
		
		
		
		
	}
	
	function setAreaXx(area,data2){
		if(area){
			doGetSelect(basePath+"/dictionary/selectHwzyGgxx","gglx="+$("#formHwzy [name='advertType']").val()+"&area="+area,"#formHwzy [name='tvId']",data2,function(data){
				
			});
			
		}else{
			$("#formHwzy [name='tvId']").empty();
			$("#formHwzy [name='tvId']").append("<option value=''>--请选择--</option>");
		
		}
	}
	function setCityXx(city,data2){
		if(city){
			doGetSelect(basePath+"/dictionary/selectHwzyGgxx","gglx="+$("#formHwzy [name='advertType']").val()+"&city="+city,"#formHwzy [name='tvId']",data2,function(data){
				
			});
			
		}else{
			$("#formHwzy [name='tvId']").empty();
			$("#formHwzy [name='tvId']").append("<option value=''>--请选择--</option>");
			
		}
	}
	function setXianXx(xian,data2){
		if(xian){
			doGetSelect(basePath+"/dictionary/selectHwzyGgxx","gglx="+$("#formHwzy [name='advertType']").val()+"&xian="+xian,"#formHwzy [name='tvId']",data2,function(data){
				
			});
			
		}else{
			$("#formHwzy [name='tvId']").empty();
			$("#formHwzy [name='tvId']").append("<option value=''>--请选择--</option>");
			
		}
	}
	function setQy(_gglx,data2){
		
		if(_gglx){
			doGetSelect(basePath+"/dictionary/selectHwzyQyByGglx","gglx="+_gglx,"#formHwzy [name='qy']",data2);
			
		}else{
			$("#formHwzy [name='qy']").empty();
			$("#formHwzy [name='qy']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setXs(_gglx,data2){
		if(_gglx){
			doGetSelect(basePath+"/dictionary/selectHwzyXsByGglx","gglx="+_gglx,"#formHwzy [name='xs']",data2);
			
		}else{
			$("#formHwzy [name='xs']").empty();
			$("#formHwzy [name='xs']").append("<option value=''>--请选择--</option>");
		}
	}
	function setCity(parentBm,data2){
		if(parentBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+parentBm,"#formHwzy [name='city']",data2);
			
		}else{
			$("#formHwzy [name='city']").empty();
			$("#formHwzy [name='city']").append("<option value=''>--请选择--</option>");
		}
	}
	function setXian(parentBm,data2){
		if(parentBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+parentBm,"#formHwzy [name='xian']",data2);
			
		}else{
			$("#formHwzy [name='xian']").empty();
			$("#formHwzy [name='xian']").append("<option value=''>--请选择--</option>");
		}
	}
	
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formHwzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		
		if(bootstrapValidator.isValid()){
			if($("#formHwzy [name='sctplj']").val()==""){
				var body = $('html,body');
				var sc=$("#sctpljUpload");
			//	body.animate({scrollTop:sc.offset().top - 100 }, 2000);
				$("#divSctplj").removeClass("has-success").addClass("has-error");
				alert("请上传封面图片！");
				return;
			}
			
			confirm("您确认要发布该广告吗？",function(){
				doPost(basePath+"/hwzyPublishing/publishing",$("#formHwzy").serializeArray(),function(data){
					alert("发布成功！",function(){
						window.location.href=basePath+"/supplyView/index?key=1";	
					});
					
					
				});
			});
			
		}
	});
});