/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formZzzy').bootstrapValidator();
	$$('#formZzzyExt').bootstrapValidator();
	var formClassify={
			"1":"formZzzyGsyg",
			"2":"formZzzyRw",
			"3":"formZzzyJy"
	};
	var formNameClassify={
			"1":"zzzyGsygInfo",
			"2":"zzzyRwInfo",
			"3":"zzzyJyInfo"
	};
	for(var key in formClassify){
		$$('#'+formClassify[key]).bootstrapValidator();
	}
	init();
	function init(){
		setAdvertTypeChange(ggfl);
		//initUploader();
		initEvent();
		setFormData();
		
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
		    	$("#formZzzyExt [name='zzzyExtInfo.dlzslj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formZzzyExt [name='zzzyExtInfo.dlzslj']").val(data.fileWids);
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
		    	$("#formZzzyExt [name='zzzyExtInfo.sctulj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formZzzyExt [name='zzzyExtInfo.sctulj']").val(data.fileWids);
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	function initEvent(){
		$("#formZzzy [name='zzzyInfo.advertType1']").click(function(){
			setAdvertTypeChange($(this).val());
		});
		$("#formZzzy [name='zzzyInfo.area']").change(function(){
			setCity($(this).val());
			setDst($(this).val());
		});
		$("#formZzzyExt [name='zzzyExtInfo.sfxzhy']").click(function(){
			setHyChange($(this).val());
		});
	}
	
	function setFormData(){
		if(wid){
			setZzzyData();
			setZzzyExtData();
		}else{
			dltuUploder(null);
			sctpUploader(null);
		}
	}
	
	function setZzzyData(){
		doGet(basePath+"/zzzyPublishing/selectZzzy","wid="+wid,function(data){
			if(data && data.datas){
				for(var key in data.datas){
					var _control=$("#formZzzy [name='zzzyInfo."+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formZzzy [name='zzzyInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
				setZzzyOtherData(data.datas.tvId);
				
			}
		});
}
function setZzzyExtData(){
	doGet(basePath+"/zzzyPublishing/selectZzzyExt","zzzyId="+wid,function(data){
		if(data && data.datas){
			for(var key in data.datas){
				var _control=$("#formZzzyExt [name='zzzyExtInfo."+key+"']");
				if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
					$("#formZzzyExt [name='zzzyExtInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
function setZzzyOtherData(tvId){
	doGet(basePath+"/zzzyPublishing/selectZzzyOther","zzzyId="+wid+"&ggfl="+ggfl,function(data){
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
				//$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"']").val(data.datas[key2]);
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
	
	function setAdvertTypeChange(_value){
		
		for(var key in formClassify){
			if(_value==key){
				$("#"+formClassify[key]).show();
			}else{
				$("#"+formClassify[key]).hide();
			}
			$("#"+formClassify[key])[0].reset();
		}
		$("#formZzzy [name='zzzyInfo.advertType']").val(_value);
		$("#formZzzy [name='zzzyInfo.advertType1'][value='"+_value+"']").prop("checked",true);
	}
	function setCity(parentBm,data2){
		if(parentBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+parentBm,"#formZzzy [name='zzzyInfo.city'",data2);
			
		}else{
			$("#formZzzy [name='zzzyInfo.city']").empty();
			$("#formZzzy [name='zzzyInfo.city']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setDst(areaBm,data2){
		if(areaBm){
			doGetSelect(basePath+"/dictionary/selectZzxx","areaBm="+areaBm,"#formZzzy [name='zzzyInfo.tvId'",data2);
		}else{
			$("#formZzzy [name='zzzyInfo.tvId']").empty();
			$("#formZzzy [name='zzzyInfo.tvId']").append("<option value=''>--请选择--</option>");
		}
	}
	
	
	
	
	
	
	function setHyChange(value,data2){
		
		if(value=="0"){
			$("#formZzzyExt [name='divHy']").hide();
			$("#formZzzyExt [name='zzzyExtInfo.hy']").prop("checked",false);
			
		}else{
			$("#formZzzyExt [name='divHy']").show();
			$("#formZzzyExt [name='zzzyExtInfo.hy']").prop("checked",false);
			if(data2){
				var _data=data2.split(",");
				for(var i=0;i<_data.length;i++){
					$("#formZzzyExt [name='zzzyExtInfo.hy'][value='"+_data[i]+"']").prop("checked",true);
				}
				
			}
		}
	}
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formZzzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formZzzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formZzzy [name='zzzyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formZzzyGsyg').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyGsyg").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyGsyg",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=6";
						});
					});
				});
			}
		}
		else if(_value=="2"){
			var bootstrapValidator2 = $$('#formZzzyRw').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				var _bjlx=$("#formZzzyRw [name='zzzyRwInfo.bjlx']").val();
				if(_bjlx=="1"){
					if($.trim($("#formZzzyRw [name='zzzyRwInfo.jg']").val())==""){
						$("#formZzzyRw [name='zzzyRwInfo.jg']")[0].focus();
						alert("请输入报价价格");
						return;
					}
				}else{
					if($.trim($("#formZzzyRw [name='zzzyRwInfo.zk']").val())==""){
						$("#formZzzyRw [name='zzzyRwInfo.zk']")[0].focus();
						alert("请输入报价折扣");
						return;
					}
				}
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyRw").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyRw",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
		else if(_value=="3"){
			var bootstrapValidator2 = $$('#formZzzyJy').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formZzzy").serializeArray();
					var data2=$("#formZzzyJy").serializeArray();
					var data3=$("#formZzzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/zzzyPublishing/publishingZzzyJy",data1,function(){
						alert("发布成功")
					});
				});
			}
		}
	});
});