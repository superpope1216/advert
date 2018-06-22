/**
 * 
 */


var DictionaryEnum={
		T_ADVERT_SJZD_GGXS:1,
		T_ADVERT_SJZD_XZQH:2,
		T_ADVERT_SJZD_DST:3,
		T_ADVERT_SJZD_HY:4,
		T_ADVERT_SJZD_GGDLFS:5,
		T_ADVERT_SJZD_LX:6,
		T_CROWD_SJZD_SDPD:7,
		T_ADVERT_SJZD_SHZT:8,
		T_ADVERT_SJZD_DLLM:9,
		T_ADVERT_SJZD_TBBCCSLX:10,
		T_ADVERT_SJZD_ZTSJD:11,
		T_ADVERT_SJZD_GMGGJGPC:12,
		T_ADVERT_SJZD_GBLX:13,
		T_ADVERT_SJZD_GBDST:14,
		T_ADVERT_SJZD_GBDSTPD:15,
		T_ADVERT_SJZD_BZXX:16,
		T_ADVERT_SJZD_BZLX:17,
		T_ADVERT_SJZD_XBMGGLX:18,
		T_ADVERT_SJZD_BZYS:19,
		T_ADVERT_SJZD_ZZZYLX:20,
		T_ADVERT_SJZD_ZZXX:21,
		T_ADVERT_SJZD_WLGZWZ:22,
		T_ADVERT_SJZD_GGLX:23,
		T_ADVERT_SJZD_XMTLX:24,
		T_ADVERT_SJZD_XMTZY_SZRQ:25,
		T_ADVERT_SJZD_XMTZY_JYCD:26,
		T_ADVERT_SJZD_XMTZY_ZYFB:27,
		T_ADVERT_SJZD_XMTZY_SRZK:28,
		T_ADVERT_SJZD_COMPANYXZ:29,
		T_ADVERT_SJZD_COMPANY_NYYE:30,
		T_ADVERT_SJZD_COMPANY_ZZLX:31,
		T_ADVERT_SJZD_SJLX:32,
		T_ADVERT_SJZD_SF:33
};


function toStr(value,replace){
	var rtuValue="";
	if(value==undefined|| value==null){
		rtuValue="";
	}else{
		rtuValue=value;
	}
	if(rtuValue=="" && replace!=undefined){
		return replace;
	}
	return rtuValue;
}
function doSyncGet(url, params, callback) {
	$.ajax({
		type : "GET",
		url : url,
		async : false,
		data : params,
		dataType : 'json',
		success : function(data) {
			ajaxBack(data, callback);
		}
	});
}

function ajaxBack(data, callBack) {
	if (data.success == true) {
		if (callBack) {
			callBack(data);
		}
	} else {
		alert(data.msg);
	}
}

function doGet(url, params, callback) {
	$.ajax({
		type : "GET",
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			ajaxBack(data, callback);
		}
	});
}

function doGetBack(url, params, callback) {
	$.ajax({
		type : "GET",
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			if(callback){
				callback(data);
			}
		}
	});
}

function doPostBack(url, params, callback) {
	var aContentType = "";
	$.ajax({
		type : "POST",
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			if(callback){
				callback(data);
			}
		}
	});
}
function doPost(url, params, callback) {
	var aContentType = "";
	$.ajax({
		type : "POST",
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			ajaxBack(data, callback);
		}
	});
}

function doGetSelect(url, params, obj, data2, callBack) {
	doGet(url, params, function(data) {
		var str = "<option value=''>--请选择--</option>";
		if (data.data && data.data.length > 0) {
			for (var i = 0; i < data.data.length; i++) {
				var checked = "";
				if (data2 && data2 == data.data[i].lbdm) {
					checked = " selected='selected' ";
				}
				str += "<option " + checked + " value='" + data.data[i].lbdm
						+ "'>" + data.data[i].lbmc + "</option>"
			}
		}
		$(obj).append(str);
		if (callBack) {
			callBack();
		}
	});
}
function doGetSelect2(tblName, obj, data2, callBack) {
	doGet(basePath + "/zdbdetail/list", "tableName=" + tblName, function(data) {
		$(obj).empty();
		var str = "<option value=''>--请选择--</option>";
		if (data.data && data.data.length > 0) {
			for (var i = 0; i < data.data.length; i++) {
				var checked = "";
				if (data2 && data2 == data.data[i].lbdm) {
					checked = " selected='selected' ";
				}
				str += "<option " + checked + " value='" + data.data[i].lbdm
						+ "'>" + data.data[i].lbmc + "</option>"
			}
		}
		$(obj).append(str);
		if (callBack) {
			callBack();
		}
	});
}

function doGetMulSelect(url, params, obj, data2, callBack) {
	$.ajax({
		type : "GET",
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			$(obj).empty();
			var str = "";
			if (data && data.success) {

				if (data.data && data.data.length > 0) {
					for (var i = 0; i < data.data.length; i++) {
						var checked = "";
						if (data2 && data2 == data.data[i].LBDM) {
							checked = " selected='selected' ";
						}
						str += "<option " + checked + " value='"
								+ data.data[i].LBDM + "'>" + data.data[i].LBMC
								+ "</option>"
					}
				}

			}
			$(obj).append(str);
			if (callBack) {
				callBack();
			}
		}
	});
}


function isEmpty(obj){
	if(obj==""||obj==null){
		return true;
	}
	return false;
}

function isNotEmpty(obj){
	if(obj==""||obj==null){
		return false;
	}
	return true;
}

window.alert=function(msg,title){
	if(title==undefined ||title=="" ||title==null){
		title="提示信息";
	}
	//resetAlert();
	return alertify.alert(title,msg).setting({
	    "label":"关闭",
		  buttonReverse : false,
		    buttonFocus  : "ok"
	}).set('resizable',false);
};

window.confirm=function(msg,callBack){
	//resetConfirm();
		
	return alertify.confirm("确认信息",msg, function(){
		if(callBack){
   		 callBack();
   	 }
		}, function(){ 
			
		}).setting({
		    labels : {
			      ok   : "确认",
			      cancel : "取消"
			    },
			    
			    buttonReverse : false,
			    buttonFocus  : "ok"
		});
	  
}

alertify.genericDialog || alertify.dialog('genericDialog',function(){
    return {
        main:function(content){
            this.setContent(content);
        },
        setup:function(){
            return {
                focus:{
                    element:function(){
                        return this.elements.body.querySelector(this.get('selector'));
                    },
                    select:true
                },
                options:{
                    basic:true,
                    maximizable:false,
                    resizable:false,
                    padding:false
                }
            };
        },
        settings:{
            selector:undefined
        }
    };
});
function openDialog(content){
	alertify.genericDialog(content);
}

function createQueryForm(config,control){
	
	if(config){
		$(control).append("<form id='queryForm' class='queryForm'></form>");
		$("#queryForm").append("<table>");
		for(var i=0;i<config.length;i++){
			var _config=config[i];
			if(i%3==0){
				$("#queryForm").append("<tr>");
			}
			if(_config.type=="text"){
				$("#queryForm").append("<td>"+toStr(_config.label,"&nbsp;")+"</td>");
				$("#queryForm").append("<td><input class='form-control' type='text' placeholder='"+toStr(_config.placeholder)+"' name='"+_config.name+"' style='width:150px;'></td>");
			}else if(_config.type=="select"){
				$("#queryForm").append("<td>"+toStr(_config.label,"&nbsp;")+"</td>");
				$("#queryForm").append("<td><select class='form-control' name='"+_config.name+"' style='width:150px;'><option value=''>--请选择--</option></select></td>");
				doGet(basePath+"/dictionary/selectList","flag="+_config.table,function(data){
					if(data &&data.datas){
						for(var j=0;j<data.datas.length;j++){
							var _data1=data.datas[j];
							$("#queryForm [name='"+_config.name+"']").append("<option value='"+_data1.lbdm+"'>"+_data1.lbmc+"</option>");
						}
					}
				});
			}
			if(i==config.length-1){
				$("#queryForm").append("<td><button type='button' class='btn btn-primary btn-sm' id='btnQuery'><i class='fa fa-search'></i> 查询</button></td>");
			}
			if((i%3==2) ||(i==config.length-1)){
				$("#queryForm").append("</tr>");
			}
		}
		$("#queryForm").append("</table>");
		
	}
}
function createModal(options){
	var defaultOption={
			id:"",
			title:"标题",
			content:"",
			btnName:"确定",
			needBtn:true
	};
	var settings = $.extend(defaultOption, options);
	
	var html="";
	html+='<div class="modal fade" id="'+settings.id+'" >';
	html+='   <div class="modal-dialog modal-lg">';
	html+='	     <div class="modal-content">';
	html+='	       <div class="modal-header">';
	html+='	        	<button type="button" class="close" data-dismiss="modal" aria-label="Close">';
	html+='	        	<span aria-hidden="true">×</span></button>';
	html+='		        <h4 class="modal-title">'+settings.title+'</h4>';
	html+='        </div>';
	html+='        <div class="modal-body">';
	if(settings.content){
		html+=settings.content;
	}
	html+='        </div>';
	html+='        <div class="modal-footer">';
	
	html+='          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>';
	if(settings.needBtn==true){
		html+='	         <button type="button" class="btn btn-primary" id="btnSh">'+config.btnName+'</button>';
	}
    html+='		   </div>';
    html+='    </div>';
    html+='	</div>';
    html+='</div>';
    return html;
}





