/**
 * 
 */

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

//DATATABLE
var DATATABLE_CONSTANT = {  
        DATA_TABLES : {  
            DEFAULT_OPTION : { //DataTables初始化选项  
                language: {  
                    "sProcessing":   "处理中...",  
                    "sLengthMenu":   "每页 _MENU_ 项",  
                    "sZeroRecords":  "没有匹配结果",  
                    "sInfo":         "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",  
                    "sInfoEmpty":    "当前显示第 0 至 0 项，共 0 项",  
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",  
                    "sInfoPostFix":  "",  
                    "sSearch":       "搜索:",  
                    "sUrl":          "",  
                    "sEmptyTable":     "表中数据为空",  
                    "sLoadingRecords": "载入中...",  
                    "sInfoThousands":  ",",  
                    "oPaginate": {  
                        "sFirst":    "首页",  
                        "sPrevious": "上页",  
                        "sNext":     "下页",  
                        "sLast":     "末页",  
                        "sJump":     "跳转"  
                    },  
                    "oAria": {  
                        "sSortAscending":  ": 以升序排列此列",  
                        "sSortDescending": ": 以降序排列此列"  
                    }  
                },  
                autoWidth: false,   //禁用自动调整列宽  
                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合  
                order: [],          //取消默认排序查询,否则复选框一列会出现小箭头  
                processing: true,  //隐藏加载提示,自行处理  
                serverSide: true,   //启用服务器端分页  
                searching: false    //禁用原生搜索  
            },  
            COLUMN: {  
                CHECKBOX: { //复选框单元格  
                    className: "td-checkbox",  
                    orderable: false,  
                    width: "30px",  
                    data: null,  
                    render: function (data, type, row, meta) {  
                        return '<input type="checkbox" class="iCheck">';  
                    }  
                }  
            },  
            RENDER: {   //常用render可以抽取出来，如日期时间、头像等  
                ELLIPSIS: function (data, type, row, meta) {  
                    data = data||"";  
                    return '<span title="' + data + '">' + data + '</span>';  
                }  
            }  
        }  
};  





