/**
 * 
 */
$(document).ready(function(){
	var staticFormConfig=[
	                      {
	                    	  "field":"title",
	                    	  "label":"公告名称",
	                    	  "col":1
	                      },
	                     
	                      {
	                    	  "field":"content",
	                    	  "label":"公告内容",
	                    	  "col":1
	                      },
	                      {
	                    	  "field":"xgsj",
	                    	  "label":"最后修改时间",
	                    	  "col":1
	                      }
	                      ];
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/qyzxGgDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/qyzxGgDetail/select","wid="+wid+"&sjlx="+sjlx,function(data){
				var _form=createStaticForm(staticFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);
				$("#spanName").html(data.datas.title);
				
			});
		}
		
		
});
