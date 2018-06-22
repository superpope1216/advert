/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploaderFile');
	require('plugins/vendor/jquery-bootstrup-newsScroll/js/jquery.bootstrap.newsbox');
	$('#formDlxx [name="kssj"]').datepicker({
	    language: 'zh-CN',
	    autoclose:true,
	    todayHighlight:true
	}).on('hide',function(ev){
		 $$('#formDlxx').data('bootstrapValidator').updateStatus('kssj', 'NOT_VALIDATED',null).validateField('kssj');
	});	 
	$('#formDlxx [name="jssj"]').datepicker({
	    language: 'zh-CN',
	    autoclose:true,
	    todayHighlight:true
	}).on('hide',function(ev){
		 $$('#formDlxx').data('bootstrapValidator').updateStatus('jssj', 'NOT_VALIDATED',null).validateField('jssj');
	});	
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
		    	$("#formDlxx [name='imgid']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formDlxx [name='imgid']").val(data.fileWids);
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	};
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/zbglView/index";
	});
	$("#btnSaveCompany").click(function(){
		var bootstrapValidator = $$('#formDlxx').data('bootstrapValidator');
		bootstrapValidator.validate();
		var datas=$('#formDlxx').serializeArray();
		if (bootstrapValidator.isValid()) {
			if (!UE.getEditor('txtContent').hasContents()){
			    alert('请先填写招标内容正文!');
			    return;
			}
			if($("#formDlxx [name='imgid']").val()==""){
				alert("请上传图片！");
				return;
			}
			$("#formDlxx [name='content']").val(UE.getEditor('txtContent').getContent());
			doPost(basePath+"/zbglEdit/save",datas,function(data){
				window.location.href=basePath+"/zbglView/index";
			});
		}
	});
	$$('#formDlxx').bootstrapValidator();
	 var editor=UE.getEditor("txtContent",{toolbars: [[
	   	                                            'fullscreen', 'source', '|', 'undo', 'redo', '|',
	   	                                            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor','|',
	   	                                             
	   	                                            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	   	                                            
	   	                                            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
	   	                                           
	   	                                            'simpleupload', 'insertimage','|',
	   	                                          
	   	                                           
	   	                                            'print', 'preview'
	   	                                        ]]});
	   	 
	   	 editor.addListener("ready", function() {
	   		 select();
	   	 });
	  function select(){
		  if(wid){
			  doGet(basePath+"/zbglEdit/select","wid="+wid,function(data){
				 if(data && data.datas){
					 var _data=data.datas;
					 $("#formDlxx [name='wid']").val(toStr(_data.wid));
					 $("#formDlxx [name='content']").val(toStr(_data.content));
					 $("#formDlxx [name='title']").val(toStr(_data.title));
					 $("#formDlxx [name='kssj']").val(toStr(_data.kssj));
					 $("#formDlxx [name='jssj']").val(toStr(_data.jssj));
					 $("#formDlxx [name='ztnr']").val(toStr(_data.ztnr));
					 $("#formDlxx [name='imgid']").val(toStr(_data.imgid));
					 sctpUploader(_data.imgid);
					 UE.getEditor('txtContent').setContent(toStr(_data.content));
				 } 
			  });
		  }else{
			  sctpUploader(null);
		  }
	  }

});