/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	
	
	$$('#formBzzy').bootstrapValidator();
	$$('#formBzzyExt').bootstrapValidator();
	
	var formClassify={
			"1":"formBzzyGsyg",
			"2":"formBzzyXbmgg",
			"3":"formBzzyRw",
			"4":"formBzzyJy"
	};
	var formNameClassify={
			"1":"bzzyGsygInfo",
			"2":"bzzyXbmggInfo",
			"3":"bzzyRwInfo",
			"4":"bzzyJyInfo"
	};
	
	for(var key in formClassify){
		$$('#'+formClassify[key]).bootstrapValidator();
	}
	init();
	function init(){
		setFormData();
		//initUploader();
		setAdvertTypeChange(ggfl);
		initEvent();
	}
	function dltuUploder(wid){
		$("#dlzsljuploadBtn").ajaxImageUpload({
			url: basePath+'/attr/upload', //上传的服务器地址
		    data: { },
		    id:"dlzsljUploadBox",
		    maxNum: 1, //允许上传图片数量
		    hidenInputName:'', // 上传成功后追加的隐藏input名，注意不要带[]，会自动带[]，不写默认和上传按钮的name相同
		    zoom: true, //允许上传图片点击放大
		    allowType: ["gif", "jpeg", "jpg", "bmp",'png'], //允许上传图片的类型
		    wid:wid,
		    maxSize :2, //允许上传图片的最大尺寸，单位M
		    deleteCallBack:function(){
		    	$("#formBzzyExt [name='bzzyExtInfo.dlzslj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formBzzyExt [name='bzzyExtInfo.dlzslj']").val(data.fileWids);
		    	$("#formBzzyExt [name='bzzyExtInfo.dlzslj']").removeClass("has-error").addClass("has-success");
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
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
		    	$("#formBzzyExt [name='bzzyExtInfo.sctulj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formBzzyExt [name='bzzyExtInfo.sctulj']").val(data.fileWids);
		    	$("#formBzzyExt [name='bzzyExtInfo.sctulj']").removeClass("has-error").addClass("has-success");
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	function initEvent(){
		$("#formBzzy [name='bzzyInfo.advertType1']").click(function(){
			setAdvertTypeChange($(this).val());
		});
		$("#formBzzy [name='bzzyInfo.area']").change(function(){
			setCity($(this).val());
			setDst($(this).val());
		});
		$("#formBzzyExt [name='bzzyExtInfo.sfxzhy']").click(function(){
			setHyChange($(this).val());
		});
	}
	
	
	function setAdvertTypeChange(_value){
		
		for(var key in formClassify){
			if(_value==key){
				$("#"+formClassify[key]).show();
			}else{
				$("#"+formClassify[key]).hide();
			}
			$("#"+formClassify[key])[0].reset();
		}
		$("#formBzzy [name='bzzyInfo.advertType']").val(_value);
		$("#formBzzy [name='bzzyInfo.advertType1'][value='"+_value+"']").prop("checked",true);
	}
	
	function setCity(parentBm,data2){
		if(parentBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+parentBm,"#formBzzy [name='bzzyInfo.city'",data2);
			
		}else{
			$("#formGbzy [name='bzzyInfo.city']").empty();
			$("#formGbzy [name='bzzyInfo.city']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setDst(areaBm,data2){
		if(areaBm){
			doGetSelect(basePath+"/dictionary/selectBzxx","areaBm="+areaBm,"#formBzzy [name='bzzyInfo.tvId'",data2);
		}else{
			$("#formGbzy [name='bzzyInfo.tvId']").empty();
			$("#formGbzy [name='bzzyInfo.tvId']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setHyChange(value,data2){
		
		if(value=="0"){
			$("#formBzzyExt [name='divHy']").hide();
			$("#formBzzyExt [name='bzzyExtInfo.hy']").prop("checked",false);
			
		}else{
			$("#formBzzyExt [name='divHy']").show();
			$("#formBzzyExt [name='bzzyExtInfo.hy']").prop("checked",false);
			if(data2){
				var _data=data2.split(",");
				for(var i=0;i<_data.length;i++){
					$("#formBzzyExt [name='bzzyExtInfo.hy'][value='"+_data[i]+"']").prop("checked",true);
				}
				
			}
		}
	}
	function setFormData(){
		if(wid){
			setBzzyData();
			setBzzyExtData();
		}else{
			dltuUploder(null);
			sctpUploader(null);
		}
	}
	

	function setBzzyData(){
			doGet(basePath+"/bzzyPublishing/selectBzzy","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formBzzy [name='bzzyInfo."+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formBzzy [name='bzzyInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
						}else{
							_control.val(data.datas[key]);	
						}
					};
					if(data.datas.area){
						setCity(data.datas.area,data.datas.city);
					}
					if(data.datas.city){
						setDst(data.datas.city,data.datas.tvId);
					}else if(data.datas.area){
						setDst(data.datas.area,data.datas.tvId);
					}
					setBzzyOtherData(data.datas.tvId);
					
				}
			});
	}
	function setBzzyExtData(){
		doGet(basePath+"/bzzyPublishing/selectBzzyExt","bzzyId="+wid,function(data){
			if(data && data.datas){
				for(var key in data.datas){
					var _control=$("#formBzzyExt [name='bzzyExtInfo."+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formBzzyExt [name='bzzyExtInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
					}else{
						_control.val(data.datas[key]);	
					}
					
					
				};
				setHyChange(data.datas["sfxzhy"],data.datas["hy"]);
				
				dltuUploder(data.datas.dlzslj);
				sctpUploader(data.datas.sctulj);
			}
		});
	}
	function setBzzyOtherData(tvId){
		doGet(basePath+"/bzzyPublishing/selectBzzyOther","bzzyId="+wid+"&ggfl="+ggfl,function(data){
			if(data &&data.datas){
				var _currentForm="",_currentFormName="";
				for(var key in formClassify){
					if(key==ggfl){
						_currentForm=formClassify[key];
					}
				}
				for(var key in formNameClassify){
					if(key==ggfl){
						_currentFormName=formNameClassify[key];
					}
				}
				for(var key2 in data.datas){
				//	$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"']").val(data.datas[key2]);
					var _control=$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"'][value='"+data.datas[key2]+"']").prop("checked",true);
					}else{
						_control.val(data.datas[key2]);	
					}
				}
			}
		});
	}
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formBzzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formBzzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formBzzy [name='bzzyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formBzzyGsyg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				if($("#formBzzyExt [name='bzzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyGsyg").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyGsyg",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=4";
						})
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formBzzyXbmgg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formBzzyExt [name='bzzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyXbmgg").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyXbmgg",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=4";
						})
					});
				});
			}
		}
		else if(_value=="3"){
			var bootstrapValidator2 = $$('#formBzzyRw').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formBzzyExt [name='bzzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyRw").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyRw",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=4";
						})
					});
				});
			}
		}
		else if(_value=="4"){
			var bootstrapValidator2 = $$('#formBzzyJy').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formBzzyExt [name='bzzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formBzzy").serializeArray();
					var data2=$("#formBzzyJy").serializeArray();
					var data3=$("#formBzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/bzzyPublishing/publishingBzzyJy",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=4";
						});
						
					});
				});
			}
		}
	});
});