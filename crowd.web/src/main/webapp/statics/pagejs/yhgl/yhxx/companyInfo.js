/**
 * 
 */

define(function(require, exports, module) {

	var $$ = jQuery$ = require('jquery');
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
			for(var key in data.datas){
				var _control=$("#formCompany [name='"+key+"']");
				if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
					$("#formCompany [name='"+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
				}else{
					_control.val(data.datas[key]);	
				}
			};
			setCity(toStr(_data.area),toStr(_data.city));
			setXian(toStr(_data.city),toStr(_data.xian));
//			var uploader=new Uploader({id:"sfzzmztjidBrower",maxSize:1024*1024*10,propExplain:"请上传照片",uploadedFunc:function(data){
//				if(true){
//					var imgPath=basePath+"/image/preView?wid="+uploader.params.value;
//					$("#sfzzmztjidImg").attr("src",imgPath);
//					$("#formCompany [name='gslog']").val(uploader.params.value);
//					$("#sfzzmztjidImg").css("width","303px");
//					$("#sfzzmztjidImg").css("z-index","0");
//				}
//			}});
			//服务端处理没有特殊的限制，只要服务端接受file表单提交的数据处理后返回json格式数据，上传成功返回的json数据里必须含有code和src，其中code必须为200，src是上传后的图片url，上传失败返回的json数据里必须含有code和msg，其中code为错误码(不能是200)，msg为错误信息。
			$("#js_uploadBtn").ajaxImageUpload({
				url: basePath+'/attr/upload', //上传的服务器地址
			    data: { },
			    id:"img1",
			    maxNum: 1, //允许上传图片数量
			    hidenInputName:'', // 上传成功后追加的隐藏input名，注意不要带[]，会自动带[]，不写默认和上传按钮的name相同
			    zoom: true, //允许上传图片点击放大
			    allowType: ["gif", "jpeg", "jpg", "bmp",'png'], //允许上传图片的类型
			    maxSize :2, //允许上传图片的最大尺寸，单位M
			    wid:data.datas.gslog,
			    before: function () {
			      
			    },
			    success:function(data){
			    	$("#formCompany [name='gslog']").val(data.fileWids);
			        console.log(data);
			    },
			    error:function (e) {
			        
			        console.log(e);
			    }
			    	
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