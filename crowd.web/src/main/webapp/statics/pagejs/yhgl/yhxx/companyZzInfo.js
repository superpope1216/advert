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
	$$('#formCompanyZz').bootstrapValidator();
	
	
	$("#btnAddZz").click(function(){
		$("#ysqrModal").modal("show");
	});
	
	var uploader=new Uploader({id:"sfzzmztjidBrower",maxSize:1024*1024*10,propExplain:"请上传照片",uploadedFunc:function(data){
		if(true){
			var imgPath=basePath+"/image/preView?wid="+uploader.params.value;
			$("#sfzzmztjidImg").attr("src",imgPath);
			$("#formCompanyZz [name='zzlog']").val(uploader.params.value);
			$("#sfzzmztjidImg").css("width","303px");
			$("#sfzzmztjidImg").css("z-index","0");
		}
	}});
	$("#sfzzmztjidUpload").click(function(){
		$("#f_sfzzmztjidBrower").trigger("click");
	});
	query(1,true);
	function query(pageNum,needPage){
		doGet(basePath+"/companyZzInfo/query","pageNum="+pageNum,function(data){
			if(data && data.datas){
				if(needPage){
					$('.mypaging2').pagination({
						pageCount:data.pageInfo.totalPage,
					    showData:data.pageInfo.pageSize,
					    coping:true,
					    callback:function(api){
					    	var _cPage=api.getCurrent();
					    	query(_cPage,false);
					    }
					});
				}
				
				var html="";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+='<tr>';
					html+='<td><button type="button" data-option="view" data-key="'+_data.zzlog+'"  class="btn btn-link">预览</button></td>';
					html+='<td>'+_data.zzlxDisplay+'</td>';
					html+='<td>'+_data.shztDisplay+'</td>';
					html+='<td>'+_data.updateTime+'</td>';
					html+='<td><button type="button" data-option="edit" data-key="'+_data.wid+'" class="btn btn-link"><i class="fa fa-edit" aria-hidden="true"></i></button>';
					html+='<button type="button"  data-option="delete" data-key="'+_data.wid+'" class="btn btn-link"><i class="fa fa-close" aria-hidden="true"></i></button></td>';
					html+='</tr>';
				}
				$("#tblMain").html(html);
			}
		});
	}
	
	$("#tblMain").on("click","button",function(){
		var _option=$(this).attr("data-option");
		var _key=$(this).attr("data-key");
		if(_option=="view"){
			var imgPath=basePath+"/image/preView?wid="+_key;
			$("#imgZzzsView").attr("src",imgPath);
			$("#zzzsViewModal").modal("show");
		}else if(_option=="edit"){
			doGet(basePath+"/companyZzInfo/selectOne","wid="+_key,function(data){
				if(data && data.datas){
					var _data=data.datas;
					$("#formCompanyZz [name='wid']").val(toStr(_data.wid));
					$("#formCompanyZz [name='zzlx']").val(toStr(_data.zzlx));
					if(_data.zzlog){
						var imgPath=basePath+"/image/preView?wid="+_data.zzlog;
						$("#sfzzmztjidImg").attr("src",imgPath);
						$("#formCompanyZz [name='zzlog']").val(_data.zzlog);
						$("#sfzzmztjidImg").css("width","303px");
						$("#sfzzmztjidImg").css("z-index","0");
					}
				}
				$("#ysqrModal").modal("show");
			});
		}else if(_option=="delete"){
			confirm("您确认删除该资质信息吗？",function(e){
				doPost(basePath+"/companyZzInfo/delete","wid="+_key,function(data){
					window.location.reload();
				});
			});
		}
	});
	
	$("#btnSaveZzzs").click(function(){
		var bootstrapValidator = $$('#formCompanyZz').data('bootstrapValidator');
		bootstrapValidator.validate();
		if(bootstrapValidator.isValid()){
			if($("#formCompanyZz [name='zzlog']").val()==""){
				alert("请上传资质图片！");
				return;
			}
			doPost(basePath+"/companyZzInfo/save",$("#formCompanyZz").serializeArray(),function(data){
				if(data && data.datas){
					window.location.reload();
				}
			})
		}
	});
	
});