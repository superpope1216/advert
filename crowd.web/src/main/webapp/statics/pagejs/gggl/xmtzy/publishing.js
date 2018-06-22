/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formXmtzy').bootstrapValidator();
	
	
	init();
	function init(){
		initEvent();
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
		    	$("#formXmtzy [name='zytp']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formXmtzy [name='zytp']").val(data.fileWids);
		    	$("#divSctplj").removeClass("has-error").addClass("has-success");
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	function initEvent(){
		$("#formXmtzy [name='xmtzyInfo.area']").change(function(){
			setCity($(this).val());
		});
	}
	
	function setFormData(){
		if(!wid){
			sctpUploader(null);
			return;
		}
		doGet(basePath+"/xmtzyPublishing/select","wid="+wid,function(data){
			if(data && data.datas){
				for(var key in data.datas){
					var _control=$("#formXmtzy [name='"+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formXmtzy [name='"+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
					}else{
						_control.val(data.datas[key]);	
					}
				};
				if(data.datas.szrq){
					var _szrq=data.datas.szrq.split(",");
					for(var i=0;i<_szrq.length;i++){
						$("#formXmtzy [name='szrq'][value='"+_szrq[i]+"']").prop("checked",true);
					}
				}
				if(data.datas.jycd){
					var _jycd=data.datas.jycd.split(",");
					for(var i=0;i<_jycd.length;i++){
						$("#formXmtzy [name='jycd'][value='"+_jycd[i]+"']").prop("checked",true);
					}
				}
				if(data.datas.zyfb){
					var _zyfb=data.datas.zyfb.split(",");
					for(var i=0;i<_zyfb.length;i++){
						$("#formXmtzy [name='zyfb'][value='"+_zyfb[i]+"']").prop("checked",true);
					}
				}
				if(data.datas.srzk){
					var _srzk=data.datas.srzk.split(",");
					for(var i=0;i<_srzk.length;i++){
						$("#formXmtzy [name='srzk'][value='"+_srzk[i]+"']").prop("checked",true);
					}
				}
				sctpUploader(data.datas.zytp);
			}
		});
	}
		
	function setCity(areaBm,data2){
		if(areaBm){
			doGetSelect(basePath+"/dictionary/selectCity","parentBm="+areaBm,"#formXmtzy [name='city']",data2);
		}else{
			$("#formXmtzy [name='city']").empty();
			$("#formXmtzy [name='city']").append("<option value=''>--请选择--</option>");
		}
	}
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formXmtzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		
		if(bootstrapValidator.isValid()){

			if($("#formXmtzy [name='zytp']").val()==""){
				var body = $('html,body');
				var sc=$("#zytpFileImg");
				//body.animate({scrollTop:sc.offset().top - 100 }, 2000);
				$("#divZytp").removeClass("has-success").addClass("has-error");
				alert("请上传资源图片！");
				return;
			}
			doPost(basePath+"/xmtzyPublishing/publishing",$("#formXmtzy").serializeArray(),function(data){
				alert("发布成功！",function(){
					window.location.href=basePath+"/supplyView/index?key=5";
				});
				
			});
		};
	});
});