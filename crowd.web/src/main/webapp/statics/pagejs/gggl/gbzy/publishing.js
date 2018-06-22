/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formGbzy').bootstrapValidator();
	$$('#formGbzyExt').bootstrapValidator();
	var formClassify={
			"1":"formGbzySd",
			"2":"formGbzyQt"
	};
	var formNameClassify={
			"1":"gbzySdInfo",
			"2":"gbzyQtInfo"
	};
	for(var key in formClassify){
		$$('#'+formClassify[key]).bootstrapValidator();
	}
	init();
	function init(){
		setFormData();
		initEvent();
		setAdvertTypeChange(ggfl);
		
		//initUploader();
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
		    	$("#formGbzyExt [name='gbzyExtInfo.dlzslj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formGbzyExt [name='gbzyExtInfo.dlzslj']").val(data.fileWids);
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
		    	$("#formGbzyExt [name='gbzyExtInfo.sctulj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formGbzyExt [name='gbzyExtInfo.sctulj']").val(data.fileWids);
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	function initEvent(){
		$("#formGbzy [name='gbzyInfo.advertType1']").click(function(){
			setAdvertTypeChange($(this).val());
		});
		$("#formGbzy [name='gbzyInfo.area']").change(function(){
			setCity($(this).val());
			setDst($(this).val());
		});
		
		$("#formGbzy [name='gbzyInfo.tvId']").change(function(){
			setGgxsChange($(this).val());
		});
		
		$("#formGbzyExt [name='gbzyExtInfo.sfxzhy']").click(function(){
			setHyChange($(this).val());
		});
	}
	
	function setFormData(){
		if(wid){
			setGbzyData();
			setGbzyExtData();
		}else{
			dltuUploder(null);
			sctpUploader(null);
		}
	}
	

	function setGbzyData(){
			doGet(basePath+"/gbzyPublishing/selectGbzy","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formGbzy [name='gbzyInfo."+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formGbzy [name='gbzyInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
					setGbzyOtherData(data.datas.tvId);
					
				}
			});
	}
	function setGbzyExtData(){
		doGet(basePath+"/gbzyPublishing/selectGbzyExt","gbzyId="+wid,function(data){
			if(data && data.datas){
				for(var key in data.datas){
					var _control=$("#formGbzyExt [name='gbzyExtInfo."+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formGbzyExt [name='gbzyExtInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
	function setGbzyOtherData(tvId){
		doGet(basePath+"/gbzyPublishing/selectGbzyOther","gbzyId="+wid+"&ggfl="+ggfl,function(data){
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
				if(ggfl=="2"){
					
				}
				if(data.datas.ztMoney){
					$("#formGbzyQt [name='gbzyQtInfo.ztHas']").prop("checked",true);
				}
				if(data.datas.lbMoney){
					$("#formGbzyQt [name='gbzyQtInfo.lbHas']").prop("checked",true);
				}
				if(data.datas.gmMoney){
					$("#formGbzyQt [name='gbzyQtInfo.gmHas']").prop("checked",true);
				}
				if(data.datas.tyMoney){
					$("#formGbzyQt [name='gbzyQtInfo.tyHas']").prop("checked",true);
				}
				if(data.datas.zdbsMoney){
					$("#formGbzyQt [name='gbzyQtInfo.zdbsHas']").prop("checked",true);
				}
				if(data.datas.lbMoney){
					$("#formGbzyQt [name='gbzyQtInfo.lbHas']").prop("checked",true);
				}
				if(ggfl=="1"){
					setGgxsChange(tvId,data.datas.gbpdBm);
				}else if(ggfl=="2"){
					setGgxsChange(tvId,data.datas.gbpdBm);
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
		$("#formGbzy [name='gbzyInfo.advertType']").val(_value);
		$("#formGbzy [name='gbzyInfo.advertType1'][value='"+_value+"']").prop("checked",true);
	}
	
	function setCity(parentBm,data2){
		if(parentBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+parentBm,"#formGbzy [name='gbzyInfo.city'",data2);
			
		}else{
			$("#formGbzy [name='gbzyInfo.city']").empty();
			$("#formGbzy [name='gbzyInfo.city']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setDst(areaBm,data2){
		if(areaBm){
			doGetSelect(basePath+"/dictionary/selectGbdst","areaBm="+areaBm,"#formGbzy [name='gbzyInfo.tvId'",data2);
		}else{
			$("#formGbzy [name='gbzyInfo.tvId']").empty();
			$("#formGbzy [name='gbzyInfo.tvId']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setGgxsChange(_value,data2){
		if(_value==""){
			$("#formGbzySd [name='gbzySdInfo.gbpdBm'").html("<option value=''>--请选择--</option>");
			$("#formGbzyQt [name='gbzyQtInfo.gbpdBm']").html("<option value=''>--请选择--</option>");
			
		}else{
			doGetSelect(basePath+"/dictionary/selectGbdstpd","gbdstBm="+_value,"#formGbzySd [name='gbzySdInfo.gbpdBm']",data2);
			doGetSelect(basePath+"/dictionary/selectGbdstpd","gbdstBm="+_value,"#formGbzyQt [name='gbzyQtInfo.gbpdBm']",data2);
		}
	}
	
	function setHyChange(value,data2){
			
			if(value=="0"){
				$("#formGbzyExt [name='divHy']").hide();
				$("#formGbzyExt [name='gbzyExtInfo.hy']").prop("checked",false);
				
			}else{
				$("#formGbzyExt [name='divHy']").show();
				$("#formGbzyExt [name='gbzyExtInfo.hy']").prop("checked",false);
				if(data2){
					var _data=data2.split(",");
					for(var i=0;i<_data.length;i++){
						$("#formGbzyExt [name='gbzyExtInfo.hy'][value='"+_data[i]+"']").prop("checked",true);
					}
					
				}
			}
		}
	
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formGbzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formGbzyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formGbzy [name='gbzyInfo.advertType']").val();
		
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formGbzySd').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formGbzyExt [name='gbzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formGbzy").serializeArray();
					var data2=$("#formGbzySd").serializeArray();
					var data3=$("#formGbzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/gbzyPublishing/publishingGbzySd",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=3";
						});
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formGbzyQt').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formGbzyExt [name='gbzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				var ggzkNum=0;
				$("#formGbzyQt [data-option='ggzk']").each(function(){
					if(this.checked){
						ggzkNum++;
					}
				});
				if(ggzkNum<=0){
					alert("请至少勾选一个广告折扣！");
					return;
				}
				if($("#formGbzyQt [name='gbzyQtInfo.ztHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.ztMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.ztMoney']")[0].focus();
						alert("请输入专题折扣！");
						return;
					}
					
				}
				if($("#formGbzyQt [name='gbzyQtInfo.lbHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.lbMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.lbMoney']")[0].focus();
						alert("请输入联播折扣！");
						return;
					}
				
				}
				if($("#formGbzyQt [name='gbzyQtInfo.gmHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.gmMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.gmMoney']")[0].focus();
						alert("请输入冠名折扣！");
						return;
					}
					
				}
				if($("#formGbzyQt [name='gbzyQtInfo.tyHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.tyMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.tyMoney']")[0].focus();
						alert("请输入特约折扣！");
						return;
					}
					
				}
				if($("#formGbzyQt [name='gbzyQtInfo.zdbsHas']").prop("checked")){
					if($.trim($("#formGbzyQt [name='gbzyQtInfo.zdbsMoney']").val())==""){
						$("#formGbzyQt [name='gbzyQtInfo.zdbsMoney']")[0].focus();
						alert("请输入整点报时折扣！");
						return;
					}
					
				}
				

				if($("#formGbzyExt [name='gbzyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formGbzy").serializeArray();
					var data2=$("#formGbzyQt").serializeArray();
					var data3=$("#formGbzyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/gbzyPublishing/publishingGbzyQt",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=3";
						});
						
					});
				});
			}
		}
	});
});