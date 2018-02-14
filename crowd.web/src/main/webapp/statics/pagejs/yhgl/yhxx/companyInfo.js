/**
 * 
 */

define(function(require, exports, module) {

	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	var upload=null;
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formCompany').bootstrapValidator();
	$('#formCompany [name="area"]').change(function(){
		var _value=$(this).val();
		setCity(_value,"");
	});
	
	function setCity(_value,_selectValue){
		if(_value==""){
			$('#formCompany [name="city"]').html("<option value=''>--请选择--</option>");
			$('#formCompany [name="xian"]').html("<option value=''>--请选择--</option>");
		}else{
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+_value,'#formCompany [name="city"]',_selectValue);
			$('#formCompany [name="xian"]').html("<option value=''>--请选择--</option>");
		}
	}
	function setXian(_value,_selectValue){
		if(_value==""){
			$('#formCompany [name="xian"]').html("<option value=''>--请选择--</option>");
		}else{
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+_value,'#formCompany [name="xian"]',_selectValue);
		}
	}
	$('#formCompany [name="city"]').change(function(){
		var _value=$(this).val();
		setXian(_value,"");
	});
	doGet(basePath+"/companyInfo/queryCompanyInfo","",function(data){
		if(data && data.datas){
			var _data=data.datas;
			$("#formCompany [name='wid']").val(toStr(_data.wid));
			$("#formCompany [name='name']").val(toStr(_data.name));
			$("#formCompany [name='area']").val(toStr(_data.area));
			setCity(toStr(_data.area),toStr(_data.city));
			setXian(toStr(_data.city),toStr(_data.xian));
			$("#formCompany [name='addr']").val(toStr(_data.addr));
			$("#formCompany [name='lxr']").val(toStr(_data.lxr));
			$("#formCompany [name='qq']").val(toStr(_data.qq));
			$("#formCompany [name='sjh']").val(toStr(_data.sjh));
			$("#formCompany [name='czh']").val(toStr(_data.czh));
			$("#formCompany [name='wzdz']").val(toStr(_data.wzdz));
			$("#formCompany [name='gsxz']").val(toStr(_data.gsxz));
			$("#formCompany [name='nyye']").val(toStr(_data.nyye));
			$("#formCompany [name='gsjj']").val(toStr(_data.gsjj));
			var uploader=new Uploader({id:"sfzzmztjidBrower",maxSize:1024*1024*10,propExplain:"请上传照片",uploadedFunc:function(data){
				if(true){
					var imgPath=basePath+"/image/preView?wid="+uploader.params.value;
					$("#sfzzmztjidImg").attr("src",imgPath);
					$("#formCompany [name='gslog']").val(uploader.params.value);
					$("#sfzzmztjidImg").css("width","303px");
					$("#sfzzmztjidImg").css("z-index","0");
				}
			}});
			$("#sfzzmztjidUpload").click(function(){
				$("#f_sfzzmztjidBrower").trigger("click");
			});
		}
	});
	
	$("#btnSaveCompany").click(function(){
		var bootstrapValidator = $$('#formCompany').data('bootstrapValidator');
		bootstrapValidator.validate();
		if(bootstrapValidator.isValid()){
			if($("#formCompany [name='gslog']").val()==""){
				alert("请上传商品LOG图片！");
				return;
			}
			doPost(basePath+"/companyInfo/save",$("#formCompany").serializeArray(),function(data){
				if(data && data.datas){
					window.location.reload();
				}
			})
		}
	});
	
});