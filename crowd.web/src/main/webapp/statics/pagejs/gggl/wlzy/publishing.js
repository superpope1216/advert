/**
 * 
 */
define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formWlzy').bootstrapValidator();
	
	init();
	function init(){
		initEvent();
	//	initUploader();
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
		    	$("#formWlzy [name='zytp1']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formWlzy [name='zytp1']").val(data.fileWids);
		    	$("#divSctplj").removeClass("has-error").addClass("has-success");
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	
	function setFormData(){
		if(wid){
			doGet(basePath+"/wlzyPublishing/select","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formWlzy [name='"+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formWlzy [name='"+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
						}else{
							_control.val(data.datas[key]);	
						}
					};
					setZsfs(data.datas.zsxt,data.datas.zsfs);
					setZscc(data.datas.zsxt,data.datas.zscc);
					setJffsDisplay(data.datas.jffs);
					sctpUploader(data.datas.zytp1);
				}
			});
		}else{
			sctpUploader(null)
		}
	}
	function initEvent(){
		$("#formWlzy [name='jffs']").click(function(){
			var _value=$(this).val();
			setJffsDisplay(_value);
		});
		$("#formWlzy [name='zsxt']").change(function(){
			setZsfs($(this).val());
			setZscc($(this).val());
		});
	}
	
	
	function setZsfs(zsxt,data2){
		if(zsxt==""){
			$("#formWlzy [name='zsfs']").html("<option value=''>--请选择--</option>");
		}else{
			doGetSelect(basePath+"/dictionary/selectZsfsByZsxt","zsxt="+zsxt,"#formWlzy [name='zsfs']",data2);
		}
		
	}
	
	function setZscc(zsxt,data2){
		if(zsxt=="3"){
			$("#divZscc").hide();
		}else{
			$("#divZscc").show();
		}
		if(zsxt==""){
			$("#formWlzy [name='zscc']").html("<option value=''>--请选择--</option>");
		}else{
			doGetSelect(basePath+"/dictionary/selectZsccByZsxt","zsxt="+zsxt,"#formWlzy [name='zscc']",data2);
		}
	}
	function setJffsDisplay(_value){
		if(_value=="1"){
			$("#divScjf").show();
			$("#divCpm").hide();
			$("#divCpc").hide();
		}else if(_value=="2"){
			$("#divScjf").hide();
			$("#divCpm").show();
			$("#divCpc").hide();
		}else if(_value=="3"){
			$("#divScjf").hide();
			$("#divCpm").hide();
			$("#divCpc").show();
		}
	}
	
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formWlzy').data('bootstrapValidator');
		bootstrapValidator.validate();
		
		if(bootstrapValidator.isValid()){
			if($("#formWlzy [name='jffs']").val()=='1'){
				var hourKlj=$("#formWlzy [name='hourKlj']").val();
				var hourXsj=$("#formWlzy [name='hourXsj']").val();
				var dayKlj=$("#formWlzy [name='dayKlj']").val();
				var dayXsj=$("#formWlzy [name='dayXsj']").val();
				var weekKlj=$("#formWlzy [name='weekKlj']").val();
				var weekXsj=$("#formWlzy [name='weekXsj']").val();
				var halfMonthKlj=$("#formWlzy [name='halfMonthKlj']").val();
				var halfMonthXsj=$("#formWlzy [name='halfMonthXsj']").val();
				var monthKlj=$("#formWlzy [name='monthKlj']").val();
				var monthXsj=$("#formWlzy [name='monthXsj']").val();
				var jdKlj=$("#formWlzy [name='jdKlj']").val();
				var jdXsj=$("#formWlzy [name='jdXsj']").val();
				var halfYearKlj=$("#formWlzy [name='halfYearKlj']").val();
				var halfYeafXsj=$("#formWlzy [name='halfYeafXsj']").val();
				var yearKlj=$("#formWlzy [name='yearKlj']").val();
				var yeafXsj=$("#formWlzy [name='yeafXsj']").val();
				
				if(hourKlj==""&&hourXsj==""&& dayKlj==""&& dayXsj==""
					&& weekKlj=="" && weekXsj=="" && halfMonthKlj==""
						&& halfMonthXsj=="" && monthKlj=="" && monthXsj==""
						&& jdKlj=="" &&	jdXsj=="" && halfYearKlj==""
						&& halfYeafXsj==""	&& yearKlj=="" && yeafXsj==""){
					alert("请至少输入一种计费方式！");
					$("#formWlzy [name='hourKlj']")[0].focus();
					return;
				}
				if(hourKlj!="" && hourXsj==""){
					alert("请输入小时销售价！");
					$("#formWlzy [name='hourXsj']")[0].focus();
					return;
				}
				if(hourKlj=="" && hourXsj!=""){
					alert("请输入小时刊例价！");
					$("#formWlzy [name='hourKlj']")[0].focus();
					return;
				}
				
				if(weekKlj!="" && weekXsj==""){
					alert("请输入周销售价！");
					$("#formWlzy [name='weekXsj']")[0].focus();
					return;
				}
				if(weekKlj=="" && weekXsj!=""){
					alert("请输入周刊例价！");
					$("#formWlzy [name='weekKlj']")[0].focus();
					return;
				}
				
				if(halfMonthKlj!="" && halfMonthXsj==""){
					alert("请输入半月销售价！");
					$("#formWlzy [name='halfMonthXsj']")[0].focus();
					return;
				}
				if(halfMonthKlj=="" && halfMonthXsj!=""){
					alert("请输入半月刊例价！");
					$("#formWlzy [name='halfMonthKlj']")[0].focus();
					return;
				}
				
				if(monthKlj!="" && monthXsj==""){
					alert("请输入月销售价！");
					$("#formWlzy [name='monthXsj']")[0].focus();
					return;
				}
				if(monthKlj=="" && monthXsj!=""){
					alert("请输入月刊例价！");
					$("#formWlzy [name='monthKlj']")[0].focus();
					return;
				}
				
				
				if(jdKlj!="" && jdXsj==""){
					alert("请输入季度销售价！");
					$("#formWlzy [name='jdXsj']")[0].focus();
					return;
				}
				if(jdKlj=="" && jdXsj!=""){
					alert("请输入季度刊例价！");
					$("#formWlzy [name='jdKlj']")[0].focus();
					return;
				}
				
				if(halfYearKlj!="" && halfYeafXsj==""){
					alert("请输入半年销售价！");
					$("#formWlzy [name='halfYeafXsj']")[0].focus();
					return;
				}
				if(halfYearKlj=="" && halfYeafXsj!=""){
					alert("请输入半年刊例价！");
					$("#formWlzy [name='halfYearKlj']")[0].focus();
					return;
				}
				
				if(yearKlj!="" && yeafXsj==""){
					alert("请输入年销售价！");
					$("#formWlzy [name='yeafXsj']")[0].focus();
					return;
				}
				if(yearKlj=="" && yeafXsj!=""){
					alert("请输入年刊例价！");
					$("#formWlzy [name='hourKlj']")[0].focus();
					return;
				}
			}else if($("#formWlzy [name='jffs']").val()=='2'){
				if($("#formWlzy [name='cpmKlj']").val()==""){
					alert("请输入刊例价！");
					$("#formWlzy [name='cpmKlj']")[0].focus();
					return;
				}
				if($("#formWlzy [name='cpmXsj']").val()==""){
					alert("请输入销售价！");
					$("#formWlzy [name='cpmXsj']")[0].focus();
					return;
				}
			}else{
				if($("#formWlzy [name='cpcKlj']").val()==""){
					alert("请输入刊例价！");
					$("#formWlzy [name='cpcKlj']")[0].focus();
					return;
				}
				if($("#formWlzy [name='cpcXsj']").val()==""){
					alert("请输入销售价！");
					$("#formWlzy [name='cpcXsj']")[0].focus();
					return;
				}
			}
			if($("#formWlzy [name='zytp1']").val()==""){
				var body = $('html,body');
				var sc=$("#zytp1FileImg");
				body.animate({scrollTop:sc.offset().top - 100 }, 2000);
				$("#divZytp1").removeClass("has-success").addClass("has-error");
				alert("请上传资源图片！");
				return;
			}
			doPost(basePath+"/wlzyPublishing/publishing",$("#formWlzy").serializeArray(),function(){
				alert("发布成功",function(){
					window.location.href=basePath+"/supplyView/index?key=7";
				});
			});
		}
	})
});