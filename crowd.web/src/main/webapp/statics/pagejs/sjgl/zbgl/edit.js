/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
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
	var xqwdfjidUploader=new Uploader({id:"imgidDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)",uploadedFunc:function(data){
        if(true){
      //  $("#xqwdfjid").val(xqwdfjidUploader.params.value);
        $("#formDlxx [name='imgid']").val(xqwdfjidUploader.params.value);
        }
     }});
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/zbglView/index";
	});
	$("#btnSaveCompany").click(function(){
		var bootstrapValidator = $$('#formDlxx').data('bootstrapValidator');
		bootstrapValidator.validate();
		var datas=$('#formDlxx').serializeArray();
		if (bootstrapValidator.isValid()) {
			if (!UE.getEditor('txtContent').hasContents()){
			    alert('请先填写代理内容正文!');
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
					 if(_data.imgid){
						 xqwdfjidUploader.setValue(_data.imgid);
					 }
					 UE.getEditor('txtContent').setContent(toStr(_data.content));
				 } 
			  });
		  }
	  }

});