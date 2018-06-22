/**
 * 
 */

$(document).ready(function(){
	initValidate();
	function initValidate(){
		 $("#shForm").validate({
		        errorElement : 'span',
		        errorClass : 'help-block',

		        rules : {
		        	name :{
		        		required : true
		        	},
		        	fy : {
		                required : true,
		                digits:true
		            },
		            ggzyxzsl : {
		            	digits:true
		            },
		            yxjb : {
		                required : true,
		                digits:true
		            },
		            bz:{
		            	required:false
		            }
		        },
		        //自定义错误消息放到哪里
		        errorPlacement : function(error, element) {
		            element.next().remove();//删除显示图标
		            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		            element.closest('.form-group').append(error);//显示错误消息提示
		        },
		        //给未通过验证的元素进行处理
		        highlight : function(element) {
		            $(element).closest('.form-group').addClass('has-error has-feedback');
		        },
		        //验证通过的处理
		        success : function(label) {
		            var el=label.closest('.form-group').find("input");
		            el.next().remove();//与errorPlacement相似
		            el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		            label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
		            label.remove();
		        },

		    });
	}
	
	var tblColums=[
        {"data":"name"},
        {"data":"fy"},
        {"data": 'ggzyxzsl' ,render:function(data2,type,full){
        	if(full.ggzyxzsl==null ||full.ggzyxzsl==undefined){
        		return "无限制";
        	}else{
        		return full.ggzyxzsl;
        	}
        }},
        {"data": 'yxjb' },
        {"data": 'bz' },
        {"data": "","width":"160px",render:function(data2,type,full){
       	 var _content="<div class='btn-group'>";
         _content+="	<button data-key='"+full.wid+"' action='shRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>编辑</button>";
       	 _content+="	<button data-key='"+full.wid+"' action='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i>删除</button>";
       	 _content+="</div>";
       	 return _content;
        }}
    ];
	list();
	function list(){
		var tbl=createMyTable("#example",basePath+"/system/hy/list",null,tblColums);
	}
	$("#example").on("click","[action='shRow']",function(){
		var key=$(this).attr("data-key");
		doGet(basePath+"/system/hy/select","wid="+key,function(data){
			$("#shForm [name='wid']").val(toStr(data.datas.wid));
			$("#shForm [name='name']").val(toStr(data.datas.name));
			$("#shForm [name='fy']").val(toStr(data.datas.fy));
			$("#shForm [name='ggzyxzsl']").val(toStr(data.datas.ggzyxzsl));
			$("#shForm [name='yxjb']").val(toStr(data.datas.yxjb));
			$("#shForm [name='bz']").val(toStr(data.datas.bz));
		});
		$("#modal-sh").modal("show");
	});
	$("#example").on("click","[action='delRow']",function(){
		var key=$(this).attr("data-key");
		confirm("您确认删除该记录吗？",function(){
			doPost(basePath+"/system/hy/delete","wid="+key,function(){
				window.location.reload();
			});
		});
		
	});
	$("#btnSh").click(function(){
		if($("#shForm").valid()){
			doPost(basePath+"/system/hy/save",$("#shForm").serializeArray(),function(){
				$("#modal-sh").modal("hide");
				window.location.reload();
			});
		}
	});
	
	$("#btnNew").click(function(){
		$("#shForm")[0].reset();
		$("#shForm").resetForm();
		$("#modal-sh").modal("show");
	});
})