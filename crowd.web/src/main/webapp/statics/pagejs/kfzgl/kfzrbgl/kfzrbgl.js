
define(function(require, exports, module) {
	var $$ = jQuery$ = require('jquery');
	require('plugins/vendor/bootstrap/validator/entrance');
	addEvent();
	function addEvent(){
		
		$("#rbxx-edit-modal").on("hidden.bs.modal", function() {
		   $$("#formRbxxgl").bootstrapValidator("validate");
		   $$("#formRbxxgl").data('bootstrapValidator').destroy(); 
		})
		$("#btnAddRbxx").click(function(){
			$("#rbxx-modal-title").text("日报新建");
			$("input[name='rq']").parent("div").parent("div").show();
			$("#formRbxxgl")[0].reset();
			$("textarea[name='gznrsm']").text("");
    		$("textarea[name='bz']").text("");
			$("#wid").val("");
		    //bootstarp重新验证
			$("#rbxx-edit-modal").modal("show");
		});
		
		$("input[name='rwbh']").autocomplete({
	    	 source:function(query,process){
	    		 if(query){
	    			  var params={"rwbh":query};
	    			  var url=basePath+"/kfzrbgl/queryRwjbxxInfo";
	    		       doPostBack(url,params,function(data){
	    		    	   process(data.datas);
	    		   });
	    		 }
	    	 },
	    	formatItem:function(item){  
			       return item["rwbh"]+"("+item["rwmc"]+")";  
			    },  
		    setValue:function(item){  
		    	   $("input[name='rwmc']").val(item["rwmc"]);
			       return{'data-value':item["rwbh"],'real-value':item["rwbh"]};
			    },        
		});
	/*	$("form").bootstrapValidator({  
		    excluded:[":disabled"]//关键配置，表示只对于禁用域不进行验证，其他的表单元素都要验证  
		});*/
		
	   $("#btnSave").click(function(){
		   $$("#formRbxxgl").bootstrapValidator("validate");
		   var formRbxxglValidator = $$("#formRbxxgl").data('bootstrapValidator');
		   formRbxxglValidator.validate();
		   if(formRbxxglValidator.isValid()){
			     var rqDate=$("input[name='rq']").val();
			     if(rqDate==""){
			    	 alert("请选择日报日期");
			    	 return;
			     }
			     var rwmc=$("input[name='rwmc']").val();
			     if(rwmc==""){
			    	 alert("任务编号不正确请重新选择");
			    	 return;
			     }
				 var clientDate=new Date(rqDate);
				 var clientDateTime=clientDate.getTime();
				 var serverDate=new Date();
				 var serverDateTime=serverDate.getTime();
				 var wid=$("#wid").val();
				 if(wid==""&&!checkRq(serverDateTime, clientDateTime, serverDate,rqDate)){
					 return;
				 }
					var url=basePath+"/kfzrbgl/saveOrUpdateRbxxNewInfo";
					//$("input[name='rwmc']").val("暂时无任务名称");
				    var basicData=$("#formRbxxgl").serializeArray();
				    doPostBack(url,basicData,function(data){
				    	refreshTable();
				    	$("#rbxx-edit-modal").modal("hide");
			          });
			 }
		});
	
	}
	
	
});

function checkRq(serverDateTime,clientDateTime,serverDate,rqDate){
	
	 if(serverDateTime>=clientDateTime){
		 var removeOneDay=new Date(formatDate(serverDate)).getTime();
		 if(clientDateTime>=removeOneDay){
			 if(clientDateTime==removeOneDay){
				 var newClientDate=new Date(rqDate+" 12:00:00");
				 newClientDate.setDate(newClientDate.getDate()+1);
				 if(new Date().getTime()>newClientDate.getTime()){
					 alert("日报已过期,不能填写昨天的日报");
					 return false;
				 }
			 }
		 }else{
			 alert("选择日期必须为当日或者当日的前一日");
			 return false;
		 }
	 }else{
	   alert("选择日期不能大于当前日期");
	   return false;
	 }
	return true;
	
}


function editRbxx(wid){
	$("#rbxx-modal-title").text("日报编辑");
	$("#wid").val(wid);
	var url=basePath+"/kfzrbgl/queryRbxxNewInfo";
    var basicData={wid:wid};
	$("input[name='rq']").parent("div").parent("div").hide();
    doSynchrPostBack(url,basicData,function(data){
    	if(data.success&&isNotEmpty(data.datas)){
    		$("input[name='rwbh']").val(data.datas[0].rwbh);
    		$("input[name='rwmc']").val(data.datas[0].rwmc);
    		$("input[name='rq']").val(data.datas[0].rq);
    		$("select[name='sjd']").val(data.datas[0].sjd);
    		$("input[name='sjgzl']").val(data.datas[0].sjgzl);
    		$("textarea[name='gznrsm']").text(data.datas[0].gznrsm);
    		$("textarea[name='bz']").text(data.datas[0].bz);
        }
      });
	$("#rbxx-edit-modal").modal("show");
}

function delRbxx(wid){
	confirm("确认删除该条数据吗",function(data){
		var url=basePath+"/kfzrbgl/delRbxxNewInfo";
	    var basicData={wid:wid};
	    doPostBack(url,basicData,function(data){
	    	refreshTable();
	      });
	});
}
//刷新表格
function refreshTable(){
   $("tbody tr").remove();
   var url=basePath+"/kfzrbgl/queryRbxxNewInfo";
   var params={wid:""};
   doPostBack(url,params,function(data){
	   	if(data.success&&isNotEmpty(data.datas)){
			var html="";
			for(var i=0;i<data.datas.length;i++){
				var result=data.datas[i];
				html+='<tr class="text-xs-center"><td>'+result.rwbh+'</td>';
				html+='<td class="text-xs-left">'+result.rwmc+'</td><td>'+result.rq+'</td>';
				html+='<td>'+result.sjdDisplay+'</td>';
				html+='<td><span class="red-600 subtotal" data-id="32">'+result.sjgzl+'</span></td>';
				html+='<td><a href="#"><i class="icon wb-edit" aria-hidden="true" ';
				html+=' onclick="editRbxx(\''+result.wid+'\')"></i></a>';
				html+='<a href="#"><i class="icon wb-trash" aria-hidden="true" ';
				html+='onclick="delRbxx(\''+result.wid+'\')"></i></a></td></tr>';
			}
			$("tbody").append(html);
	   	}
     });
}


//减少当前日期 一天
function add0(m){return m<10?'0'+m:m }
function formatDate(time)
{
//shijianchuo是整数，否则要parseInt转换
var y = time.getFullYear();
var m = time.getMonth()+1;
var d = time.getDate()-1;
return y+'-'+add0(m)+'-'+add0(d);
}