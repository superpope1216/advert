

//(function ($) {
//	
//	            
//	            
//    $.fn.myDataTable = function (options) {
//    	var defaultOption={ //DataTables初始化选项  
//                language: {  
//                    "sProcessing":   "处理中...",  
//                    "sLengthMenu":   "每页 _MENU_ 项",  
//                    "sZeroRecords":  "没有匹配结果",  
//                    "sInfo":         "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",  
//                    "sInfoEmpty":    "当前显示第 0 至 0 项，共 0 项",  
//                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",  
//                    "sInfoPostFix":  "",  
//                    "sSearch":       "搜索:",  
//                    "sUrl":          "",  
//                    "sEmptyTable":     "表中数据为空",  
//                    "sLoadingRecords": "载入中...",  
//                    "sInfoThousands":  ",",  
//                    "oPaginate": {  
//                        "sFirst":    "首页",  
//                        "sPrevious": "上页",  
//                        "sNext":     "下页",  
//                        "sLast":     "末页",  
//                        "sJump":     "跳转"  
//                    },  
//                    "oAria": {  
//                        "sSortAscending":  ": 以升序排列此列",  
//                        "sSortDescending": ": 以降序排列此列"  
//                    }  
//                },  
//                autoWidth: false,   //禁用自动调整列宽  
//                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合  
//                order: [],          //取消默认排序查询,否则复选框一列会出现小箭头  
//                bLengthChange:false,//取消每页多少条切换
//                processing: true,  //隐藏加载提示,自行处理  
//                serverSide: true,   //启用服务器端分页  
//                searching: false    //禁用原生搜索  
//            };
//        //创建一些默认值，拓展任何被提供的选项
//        var settings = $.extend(defaultOption, options);
//
//        return this.each(function () {
//
//
//        });
//
//    };
//})(jQuery);
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
                bLengthChange:false,//取消每页多少条切换
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


function createMyTable(control,url,queryParams,columns,options){
	var tbl=$(control).DataTable($.extend(true,options,DATATABLE_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
		 ajax:function(data,callback,setting){
			 
			var params={};
			 
			 params.pageNum=parseInt(data.start)/parseInt(data.length)+1;
			 params.pageSize = data.length;  
			 params.draw = data.draw;
			 if(queryParams!=null && queryParams!=undefined){
				 for(var i=0;i<queryParams.length;i++){
					 params[queryParams[i].field]=$(queryParams[i].control).val();
				 }
			 }
			 doGet(url,params,function(data){
			  	  var dataSources={};
			  	  dataSources.draw=data.draw;
			  	  dataSources.data=data.datas;
			  	  dataSources.recordsTotal = data.pageInfo.totalSize;//返回数据全部记录，对象属性为固定格式不可更改，影响表格信息显示
			  	  dataSources.recordsFiltered = data.pageInfo.totalSize;
			    	callback(dataSources);
			    });
		 },
		 columns: columns
	}));
	return tbl;
}
