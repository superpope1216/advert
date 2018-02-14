/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	
	$("#btnSupply").click(function(){
		window.location.href=basePath+"/qyzxNewsView/index";
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
			
			$("#formDlxx [name='content']").val(UE.getEditor('txtContent').getContent());
			doPost(basePath+"/qyzxNewsEdit/save",datas,function(data){
				window.location.href=basePath+"/qyzxNewsView/index";
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
			  doGet(basePath+"/qyzxNewsEdit/select","wid="+wid,function(data){
				 if(data && data.datas){
					 var _data=data.datas;
					 $("#formDlxx [name='wid']").val(toStr(_data.wid));
					 $("#formDlxx [name='content']").val(toStr(_data.content));
					 $("#formDlxx [name='title']").val(toStr(_data.title));
					 UE.getEditor('txtContent').setContent(toStr(_data.content));
				 } 
			  });
		  }
	  }

});