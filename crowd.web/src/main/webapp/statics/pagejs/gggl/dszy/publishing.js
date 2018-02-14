/**
 * 
 */

define(function(require, exports, module) {
	var $$ = jQuery = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	$$('#formDszy').bootstrapValidator();
	$$('#formDszySd').bootstrapValidator();
	$$('#formDszyExt').bootstrapValidator();
	$$('#formDszyLm').bootstrapValidator();
	$$('#formDszyTb').bootstrapValidator();
	$$('#formDszyZt').bootstrapValidator();
	$$('#formDszyGm').bootstrapValidator();
	$$('#formDszyZz').bootstrapValidator();
	
	
	$("#formDszy [name='dszyInfo.advertType1']").click(function(){
		var _value=$(this).val();
		$("#formDszy [name='dszyInfo.advertType']").val(_value);
		if(_value=="1"){
			$("#formDszySd").show();
			$("#formDszyLm").hide();
			$("#formDszyTb").hide();
			$("#formDszyZt").hide();
			$("#formDszyGm").hide();
			$("#formDszyZz").hide();
			$("#formDszyLm")[0].reset();
			$("#formDszyTb")[0].reset();
			$("#formDszyZt")[0].reset();
			$("#formDszyGm")[0].reset();
			$("#formDszyZz")[0].reset();
		}else if(_value=="2"){
			$("#formDszySd").hide();
			$("#formDszyLm").show();
			$("#formDszyTb").hide();
			$("#formDszyZt").hide();
			$("#formDszyGm").hide();
			$("#formDszyZz").hide();
			
			$("#formDszySd")[0].reset();
			$("#formDszyTb")[0].reset();
			$("#formDszyZt")[0].reset();
			$("#formDszyGm")[0].reset();
			$("#formDszyZz")[0].reset();
		}else if(_value=="3"){
			$("#formDszySd").hide();
			$("#formDszyLm").hide();
			$("#formDszyTb").show();
			$("#formDszyZt").hide();
			$("#formDszyGm").hide();
			$("#formDszyZz").hide();
			
			$("#formDszySd")[0].reset();
			$("#formDszyLm")[0].reset();
			$("#formDszyZt")[0].reset();
			$("#formDszyGm")[0].reset();
			$("#formDszyZz")[0].reset();
		}else if(_value=="4"){
			$("#formDszySd").hide();
			$("#formDszyLm").hide();
			$("#formDszyTb").hide();
			$("#formDszyZt").show();
			$("#formDszyGm").hide();
			$("#formDszyZz").hide();
			
			$("#formDszySd")[0].reset();
			$("#formDszyLm")[0].reset();
			$("#formDszyTb")[0].reset();
			$("#formDszyGm")[0].reset();
			$("#formDszyZz")[0].reset();
		}else if(_value=="5"){
			$("#formDszySd").hide();
			$("#formDszyLm").hide();
			$("#formDszyTb").hide();
			$("#formDszyZt").hide();
			$("#formDszyGm").show();
			$("#formDszyZz").hide();
			
			$("#formDszySd")[0].reset();
			$("#formDszyLm")[0].reset();
			$("#formDszyTb")[0].reset();
			$("#formDszyZt")[0].reset();
			$("#formDszyZz")[0].reset();
		}else if(_value=="6"){
			$("#formDszySd").hide();
			$("#formDszyLm").hide();
			$("#formDszyTb").hide();
			$("#formDszyZt").hide();
			$("#formDszyGm").hide();
			$("#formDszyZz").show();
			
			$("#formDszySd")[0].reset();
			$("#formDszyLm")[0].reset();
			$("#formDszyTb")[0].reset();
			$("#formDszyZt")[0].reset();
			$("#formDszyGm")[0].reset();
		}
	});
	$("#formDszy [name='dszyInfo.area']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#formDszy [name='dszyInfo.city']").empty();
			$("#formDszy [name='dszyInfo.city']").append("<option value=''>--请选择--</option>");
		}
		doGet(basePath+"/dictionary/selectCity","parentBm="+$(this).val(),function(data){
			if(data && data.datas){
				
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formDszy [name='dszyInfo.city']").html(html);
			}
		});
		doGet(basePath+"/dictionary/selectDst","areaBm="+$(this).val(),function(data){
			if(data && data.datas){
				var html="";
				html+="<option value=''>--请选择--</option>";
				for(var i=0;i<data.datas.length;i++){
					var _data=data.datas[i];
					html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
				}
				$("#formDszy [name='dszyInfo.tvId']").html(html);
				
			}
		});
	});
	
	$("#formDszyLm [name='aScbt']").click(function(){
		if($("#formDszyLm [name='divBtsc']").css("display")=="none"){
			$("#formDszyLm [name='divBtsc']").show();
		}else{
			$("#formDszyLm [name='divBtsc']").hide();
		}
	});
	
	$("#formDszy [name='dszyInfo.tvId']").change(function(){
		if($(this).val()==""){
			$("#formDszySd [name='dszySdInfo.tvPd'").html("<option value=''>--请选择--</option>");
			$("#formDszyLm [name='dszyLmInfo.pdId']").html("<option value=''>--请选择--</option>");
			$("#formDszyZt [name='dszyZtInfo.ztpdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyGm [name='dszyGmInfo.sspdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyZz [name='dszyZzInfo.sspdBm']").html("<option value=''>--请选择--</option>");
			$("#formDszyTb [name='divTbBhpd']").html("&nbsp;");
			formDszyTb
		}else{
			doGet(basePath+"/dictionary/selectSdpd","dstBm="+$(this).val(),function(data){
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
				}
			});
		}
	});
	$("#formDszyLm [name='dszyLmInfo.pdId']").change(function(){
		if($(this).val()==""){
			$("#formDszyLm [name='dszyLmInfo.dllm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+$(this).val(),function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyLm [name='dszyLmInfo.dllm']").html(html);
				}
			});
		}
		
	});
	$("#formDszyZz [name='dszyZzInfo.sspdBm']").change(function(){
		if($(this).val()==""){
			$("#formDszyZz [name='dszyZzInfo.sslmBm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+$(this).val(),function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyZz [name='dszyZzInfo.sslmBm']").html(html);
				}
			});
		}
	});
	$("#formDszyGm [name='dszyGmInfo.sspdBm']").change(function(){
		if($(this).val()==""){
			$("#formDszyGm [name='dszyGmInfo.sslmBm'").html("<option value=''>--请选择--</option>");
		}else{
			doGet(basePath+"/dictionary/selectDllm","pdId="+$(this).val(),function(data){
				if(data && data.datas){
					var html="";
					html+="<option value=''>--请选择--</option>";
					for(var i=0;i<data.datas.length;i++){
						var _data=data.datas[i];
						html+="<option value='"+_data.lbdm+"'>"+_data.lbmc+"</option>";
					}
					$("#formDszyGm [name='dszyGmInfo.sslmBm']").html(html);
				}
			});
		}
	});
	
	$("#formDszySd [name='aScdlzs']").click(function(){
		$("#formDszySd [name='divScdlzs']").show();
	});
	
	$("#formDszyExt [name='dszyExtInfo.sfxzhy']").click(function(){
		if($(this).val()=="0"){
			$("#formDszyExt [name='divHy']").hide();
			$("#formDszyExt [name='dszyExtInfo.hy']").attr("checked",false);
		}else{
			$("#formDszyExt [name='divHy']").show();
			$("#formDszyExt [name='dszyExtInfo.hy']").attr("checked",false);
		}
	});
	$("#btnPublishingSd").click(function(){
		var bootstrapValidator = $$('#formDszy').data('bootstrapValidator');
		bootstrapValidator.validate();
		var bootstrapValidator3 = $$('#formDszyExt').data('bootstrapValidator');
		bootstrapValidator3.validate();
		
		
		var _value=$("#formDszy [name='dszyInfo.advertType']").val();
		if(_value=="1"){
			var bootstrapValidator2 = $$('#formDszySd').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
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
						alert("发布成功")
					});
				});
			}
		}else if(_value=="2"){
			var bootstrapValidator2 = $$('#formDszyLm').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
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
						alert("发布成功")
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
						alert("发布成功")
					});
				});
			}
		}else if(_value=="4"){
			var bootstrapValidator2 = $$('#formDszyZt').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
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
						alert("发布成功")
					});
				});
			}
		}else if(_value=="5"){
			var bootstrapValidator2 = $$('#formDszyGm').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
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
						alert("发布成功");
					});
				});
			}
		}else if(_value=="6"){
			var bootstrapValidator2 = $$('#formDszyZz').data('bootstrapValidator');
			bootstrapValidator2.validate();
			if (bootstrapValidator.isValid() && bootstrapValidator2.isValid() && bootstrapValidator3.isValid()) {
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
						alert("发布成功")
					});
				});
			}
		}
		
		
		
	});
});