/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/upload/jquery.form');
	require('plugins/vendor/upload/imageUploader');
	require('plugins/vendor/upload/uploader');
	require('plugins/vendor/bootstrap/validator/entrance');
	
	
	
	var formClassify={
			"1":"formDszySd",
			"2":"formDszyLm",
			"3":"formDszyTb",
			"4":"formDszyZt",
			"5":"formDszyGm",
			"6":"formDszyZz"
	};
	var formNameClassify={
			"1":"dszySdInfo",
			"2":"dszyLmInfo",
			"3":"dszyTbInfo",
			"4":"dszyZtInfo",
			"5":"dszyGmInfo",
			"6":"dszyZzInfo"
	}
	for(var key in formClassify){
		$$('#'+formClassify[key]).bootstrapValidator();
	}
	$$('#formDszy').bootstrapValidator();
	$$('#formDszyExt').bootstrapValidator();
	init();
	function init(){
		setFormData();
		setAdvertTypeChange(ggfl);
		//initUploader();
		initEvent();
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
		    	$("#formDszyExt [name='dszyExtInfo.dlzslj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formDszyExt [name='dszyExtInfo.dlzslj']").val(data.fileWids);
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
		    	$("#formDszyExt [name='dszyExtInfo.sctulj']").val("");
		    },
		    before: function () {
		      
		    },
		    success:function(data){
		    	$("#formDszyExt [name='dszyExtInfo.sctulj']").val(data.fileWids);
		        console.log(data);
		    },
		    error:function (e) {
		        
		        console.log(e);
		    }
		    	
		});
	}
	function initUploader(){
		
		//dltuUploder(null);
		
		//sctpUploader(null);
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
		$("#formDszy [name='dszyInfo.advertType']").val(_value);
		$("#formDszy [name='dszyInfo.advertType1'][value='"+_value+"']").prop("checked",true);
	}
	
	function setLmpdChange(_value,data2){
		if(_value==""){
			$("#formDszyLm [name='dszyLmInfo.dllm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+_value,function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyLm [name='dszyLmInfo.dllm']").html(html);
					if(data2){
						$("#formDszyLm [name='dszyLmInfo.dllm']").val(data2);
					}
				}
			});
		}
	}
	
	function setGmpdChange(_value,data2){
		if(_value==""){
			$("#formDszyGm [name='dszyGmInfo.sslmBm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+_value,function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyGm [name='dszyGmInfo.sslmBm']").html(html);
					if(data2){
						$("#formDszyGm [name='dszyGmInfo.sslmBm']").val(data2);
					}
				}
			});
		}
	}
	
	function setZzpdChange(_value,data2){
		if(_value==""){
			$("#formDszyZz [name='dszyZzInfo.sslmBm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+_value,function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyZz [name='dszyZzInfo.sslmBm']").html(html);
					if(data2){
						$("#formDszyZz [name='dszyZzInfo.sslmBm']").val(data2);
					}
				}
			});
		}
	}
	function initEvent(){
	
		
		$("#formDszy [name='dszyInfo.advertType1']").click(function(){
			var _value=$(this).val();
			setAdvertTypeChange(_value);
			
		});
		$("#formDszy [name='dszyInfo.area']").change(function(){
			var _value=$(this).val();
			setCity(_value);
			setDst(_value);
			
		});
		
		$("#formDszyLm [name='aScbt']").click(function(){
			if($("#formDszyLm [name='divBtsc']").css("display")=="none"){
				$("#formDszyLm [name='divBtsc']").show();
			}else{
				$("#formDszyLm [name='divBtsc']").hide();
			}
		});
		
		$("#formDszy [name='dszyInfo.tvId']").change(function(){
			setGgxsChange($(this).val());
		});
		$("#formDszyLm [name='dszyLmInfo.pdId']").change(function(){
			setLmpdChange($(this).val());
			
		});
		$("#formDszyZz [name='dszyZzInfo.sspdBm']").change(function(){
			setZzpdChange($(this).val());
		});
		$("#formDszyGm [name='dszyGmInfo.sspdBm']").change(function(){
			setGmpdChange($(this).val());
		});
		
		$("#formDszySd [name='aScdlzs']").click(function(){
			$("#formDszySd [name='divScdlzs']").show();
		});
		
		$("#formDszyExt [name='dszyExtInfo.sfxzhy']").change(function(e){
			setHyChange($(this).val());
		});
	}
	
	
	
	
	function setFormData(){
		if(wid){
			setDszyData();
			setDsztExtData();
		}else{
			dltuUploder(null);
			sctpUploader(null);
		}
	}
	function setDszyData(){
			doGet(basePath+"/dszyPublishing/selectDszy","wid="+wid,function(data){
				if(data && data.datas){
					for(var key in data.datas){
						var _control=$("#formDszy [name='dszyInfo."+key+"']");
						if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
							$("#formDszy [name='dszyInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
					setDszyOtherData(data.datas.tvId);
					
				}
			});
	}
	function setDsztExtData(){
		doGet(basePath+"/dszyPublishing/selectDszyExt","dszyId="+wid,function(data){
			if(data && data.datas){
				for(var key in data.datas){
					var _control=$("#formDszyExt [name='dszyExtInfo."+key+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#formDszyExt [name='dszyExtInfo."+key+"'][value='"+data.datas[key]+"']").prop("checked",true);
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
	function setDszyOtherData(tvId){
		doGet(basePath+"/dszyPublishing/selectDszyOther","dszyId="+wid+"&ggfl="+ggfl,function(data){
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
					$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"']").val(data.datas[key2]);
					var _control=$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"']");
					if(_control.is('input') && (_control.prop("type")=="checkbox"||_control.prop("type")=="radio")){
						$("#"+_currentForm+" [name='"+_currentFormName+"."+key2+"'][value='"+data.datas[key2]+"']").prop("checked",true);
					}else{
						_control.val(data.datas[key2]);	
					}
				}
				if(ggfl=="1"){
					setGgxsChange(tvId,data.datas.tvPd);
				}else if(ggfl=="2"){
					setGgxsChange(tvId,data.datas.pdId);
					setLmpdChange(data.datas.pdId,data.datas.dllm);
					
				}else if(ggfl=="3"){
					setGgxsChange(tvId,data.datas.bhpd);
				}else if(ggfl=="4"){
					setGgxsChange(tvId,data.datas.ztpdBm);
				}else if(ggfl=="5"){
					setGgxsChange(tvId,data.datas.sspdBm);
					setGmpdChange(data.datas.sspdBm,data.datas.sslmBm);
				}else if(ggfl=="6"){
					setGgxsChange(tvId,data.datas.sspdBm);
					setZzpdChange(data.datas.sspdBm,data.datas.sslmBm);
				}
			}
		});
	}
	function setCity(parentBm,data2){
		if(parentBm){
			doGet(basePath+"/dictionary/selectCity","parentBm="+parentBm,function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszy [name='dszyInfo.city']").html(html);
					if(data2){
						$("#formDszy [name='dszyInfo.city']").val(data2);
					}
				}
			});
		}else{
			$("#formDszy [name='dszyInfo.city']").empty();
			$("#formDszy [name='dszyInfo.city']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setDst(areaBm,data2){
		if(areaBm){
			doGet(basePath+"/dictionary/selectDst","areaBm="+areaBm,function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszy [name='dszyInfo.tvId']").html(html);
					if(data2){
						$("#formDszy [name='dszyInfo.tvId']").val(data2);
						
					}
				}
			});
		}else{
			$("#formDszy [name='dszyInfo.tvId']").empty();
			$("#formDszy [name='dszyInfo.tvId']").append("<option value=''>--请选择--</option>");
		}
	}
	
	function setHyChange(value,data2){
		
		if(value=="0"){
			$("#formDszyExt [name='divHy']").hide();
			$("#formDszyExt [name='dszyExtInfo.hy']").prop("checked",false);
			
		}else{
			$("#formDszyExt [name='divHy']").show();
			$("#formDszyExt [name='dszyExtInfo.hy']").prop("checked",false);
			if(data2){
				var _data=data2.split(",");
				for(var i=0;i<_data.length;i++){
					$("#formDszyExt [name='dszyExtInfo.hy'][value='"+_data[i]+"']").prop("checked",true);
				}
				
			}
		}
	}
	function setGgxsChange(_value,data2){
		if(_value==""){
			$("#formDszySd [name='dszySdInfo.tvPd'").html("<option value=''>--请选择--</option>");
			$("#formDszyLm [name='dszyLmInfo.pdId']").html("<option value=''>--请选择--</option>");
			$("#formDszyZt [name='dszyZtInfo.ztpdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyGm [name='dszyGmInfo.sspdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyZz [name='dszyZzInfo.sspdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyTb [name='divTbBhpd']").html("&nbsp;");
		}else{
			doGet(basePath+"/dictionary/selectSdpd","dstBm="+_value,function(data){
				if(data && data.datas){
					var html="",htmlCheck="";;
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
						htmlCheck+="<div class='col-sm-2'>";
						htmlCheck+='<input type="checkbox" required data-fv-notempty-message="请至少选择一项" name="dszyTbInfo.bhpd" value="'+_data.lbdm+'">'+_data.lbmc;
						htmlCheck+="</div>";
					}
					$("#formDszySd [name='dszySdInfo.tvPd']").html(html);
					
					$("#formDszyLm [name='dszyLmInfo.pdId']").html(html);
					$("#formDszyZt [name='dszyZtInfo.ztpdBm']").html(html);
					$("#formDszyGm [name='dszyGmInfo.sspdBm']").html(html);
					$("#formDszyZz [name='dszyZzInfo.sspdBm']").html(html);
					$("#formDszyTb [name='divTbBhpd']").html(htmlCheck);
					if(data2){
						$("#formDszySd [name='dszySdInfo.tvPd']").val(data2);
						$("#formDszyLm [name='dszyLmInfo.pdId']").val(data2);
						$("#formDszyZt [name='dszyZtInfo.ztpdBm']").val(data2);
						$("#formDszyGm [name='dszyGmInfo.sspdBm']").val(data2);
						$("#formDszyZz [name='dszyZzInfo.sspdBm']").val(data2);
						
						var _check=$("#formDszyTb [name='dszyTbInfo.bhpd']");
						for(var i=0;i<_check.length;i++){
							if($(_check[i]).prop("value")==data2){
								$(_check[i]).prop("checked",true);
							}else{
								$(_check[i]).prop("checked",false);
							}
						}
						
					}
				}
			});
		}
	}
	
	
	$("#btnPublishingSd").click(function(e){
		e.stopPropagation();
		e.preventDefault(); 
		var bootstrapValidator = $$('#formDszy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formDszyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formDszy [name='dszyInfo.advertType']").val();
		
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formDszySd').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszySd").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszySd",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formDszyLm').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszyLm").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszyLm",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}else if(_value=="3"){
			var bootstrapValidator2 = $$('#formDszyTb').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				
				var _bhpdNUM=0;
				$("#formDszyTb [name='dszyTbInfo.bhpd']").each(function(){
					if(this.checked){
						_bhpdNUM++;
					}
				});
				if(_bhpdNUM<=0){
					alert("请至少选择一个频道！");
					return;
				}
				var jgNum=0;
				if($("#formDszyTb [name='dszyTbInfo.fiveHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.fiveMoney']").val())==""){
						alert("套播价格5秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.seventHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.seventMoney']").val())==""){
						alert("套播价格7.5秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.tenHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.tenMoney']").val())==""){
						alert("套播价格10秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.fifteenHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.fifteenMoney']").val())==""){
						alert("套播价格15秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.twentyHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.twentyMoney']").val())==""){
						alert("套播价格20秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.twentyFiveHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.twentyFiveMoney']").val())==""){
						alert("套播价格25秒价格必须输入！");
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.thirtyHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.thirtyMoney']").val())==""){
						alert("套播价格30秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.fortyFiveHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.fortyFiveMoney']").val())==""){
						alert("套播价格45秒价格必须输入！");
						return;
					}
				}
				if($("#formDszyTb [name='dszyTbInfo.sixtyHas']").prop("checked")){
					jgNum++;
					if($.trim($("#formDszyTb [name='dszyTbInfo.sixtyMoney']").val())==""){
						alert("套播价格60秒价格必须输入！");
						return;
					}
				}
				if(jgNum<=0){
					alert("请至少勾选一个套播价格！");
					return;
				}
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszyTb").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszyTb",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}else if(_value=="4"){
			var bootstrapValidator2 = $$('#formDszyZt').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszyZt").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszyZt",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}else if(_value=="5"){
			var bootstrapValidator2 = $$('#formDszyGm').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszyGm").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszyGm",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}else if(_value=="6"){
			var bootstrapValidator2 = $$('#formDszyZz').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
				if($("#formDszyExt [name='dszyExtInfo.sctulj']").val()==""){
					alert("请上传封面图片");
					return;
				}
				confirm("您确认要发布该广告吗？",function(){
					var data1=$("#formDszy").serializeArray();
					var data2=$("#formDszyZz").serializeArray();
					var data3=$("#formDszyExt").serializeArray();
					for(var i=0;i<data2.length;i++){
						data1.push(data2[i]);
					}
					for(var i=0;i<data3.length;i++){
						data1.push(data3[i]);
					}
					doPost(basePath+"/dszyPublishing/publishingDszyZz",data1,function(){
						alert("发布成功",function(){
							window.location.href=basePath+"/supplyView/index?key=2";
						});
						
					});
				});
			}
		}
		
		
		return false;
	});
});
