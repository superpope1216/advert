/**
 * 
 */
$(document).ready(function(){
	var staticFormConfig=[
	                      {
	                    	  "field":"name",
	                    	  "label":"资源名称"
	                      },
	                     
	                      {
	                    	  "field":"jg",
	                    	  "label":"价格(元)"
	                      },
	                      {
	                    	  "field":"content",
	                    	  "label":"求购内容",
	                    	  "col":1
	                      },
	                      {
	                    	  "field":"xgsj",
	                    	  "label":"发布/刷新时间",
	                    	  "col":1
	                      }
	                      ];
		
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/qgDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/qgDetail/select","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);
				$("#spanName").html(data.datas.name);
			});
		}
		
});
