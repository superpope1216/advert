/**
 * 
 */
$(document).ready(function(){
	var staticDlxxFormConfig=[
	                      {
	                    	  "field":"title",
	                    	  "label":"代理标题",
	                    	  "col":1
	                      },
	                     
	                      {
	                    	  "field":"kssj",
	                    	  "label":"代理开始时间"
	                      },
	                      {
	                    	  "field":"jssj",
	                    	  "label":"代理结束时间"
	                      },
	                      
	                      {
	                    	  "field":"imgid",
	                    	  "label":"图片",
	                    	  "col":1,
	                    	  "type":"img",
	                    	  "id":"imgid"
	                    	  
	                      },
	                      {
	                    	  "field":"content",
	                    	  "label":"代理内容正文",
	                    	  "col":1
	                    		  
	                      },
	                      {
	                    	  "field":"ztnr",
	                    	  "label":"代理主题简介",
	                    	  "col":1
	                      },
	                      {
	                    	  "field":"xgsj",
	                    	  "label":"创建/刷新时间",
	                    	  "col":1
	                      }
	                      ];
		var staticCurrentFormConfig=null;
		
		var staticHzxxFormConfig=[
		                      {
		                    	  "field":"title",
		                    	  "label":"合作标题",
		                    	  "col":1
		                      },
		                     
		                      {
		                    	  "field":"kssj",
		                    	  "label":"合作开始时间"
		                      },
		                      {
		                    	  "field":"jssj",
		                    	  "label":"合作结束时间"
		                      },
		                      
		                      {
		                    	  "field":"imgid",
		                    	  "label":"图片",
		                    	  "col":1,
		                    	  "type":"img",
		                    	  "id":"imgid"
		                    	  
		                      },
		                      {
		                    	  "field":"content",
		                    	  "label":"合作内容正文",
		                    	  "col":1
		                    		  
		                      },
		                      {
		                    	  "field":"ztnr",
		                    	  "label":"合作主题简介",
		                    	  "col":1
		                      },
		                      {
		                    	  "field":"xgsj",
		                    	  "label":"创建/刷新时间",
		                    	  "col":1
		                      }
		                      ];
		var staticZbxxFormConfig=[
		                      {
		                    	  "field":"title",
		                    	  "label":"招标标题",
		                    	  "col":1
		                      },
		                     
		                      {
		                    	  "field":"kssj",
		                    	  "label":"招标开始时间"
		                      },
		                      {
		                    	  "field":"jssj",
		                    	  "label":"招标结束时间"
		                      },
		                      
		                      {
		                    	  "field":"imgid",
		                    	  "label":"图片",
		                    	  "col":1,
		                    	  "type":"img",
		                    	  "id":"imgid"
		                    	  
		                      },
		                      {
		                    	  "field":"content",
		                    	  "label":"招标内容正文",
		                    	  "col":1
		                    		  
		                      },
		                      {
		                    	  "field":"ztnr",
		                    	  "label":"招标主题简介",
		                    	  "col":1
		                      },
		                      {
		                    	  "field":"xgsj",
		                    	  "label":"创建/刷新时间",
		                    	  "col":1
		                      }
		                      ];
		
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/sjglDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			if(sjlx=="1"){
				staticCurrentFormConfig=staticDlxxFormConfig;
			}else if(sjlx=="2"){
				staticCurrentFormConfig=staticHzxxFormConfig;
			}else if(sjlx=="3"){
				staticCurrentFormConfig=staticZbxxFormConfig;
			}
			doGet(basePath+"/sjglDetail/selectSjglInfo","wid="+wid+"&sjlx="+sjlx,function(data){
				var _form=createStaticForm(staticCurrentFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);  
				if(sjlx=="1"){
					$("#spanAdverType").html("代理");
				}else if(sjlx=="2"){
					$("#spanAdverType").html("合作");
				}else if(sjlx=="3"){
					$("#spanAdverType").html("招标");
				}
				$("#spanName").html(data.datas.title);
				
			});
		}
		
		
});
