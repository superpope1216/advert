/**
 * 
 */
$(document).ready(function(){
	var staticXmtzyFormConfig=[
	 	                      
	  	                     
	 	                      {
	 	                    	  "field":"name",
	 	                    	  "label":"资源名称"
	 	                      },
	 	                      {
	 	                    	  "field":"advertTypeDisplay",
	 	                    	  "label":"新媒体类型"
	 	                      },
	 	                      {
	 	                    	  "field":"areaDisplay",
	 	                    	  "label":"省"
	 	                      },
	 	                      {
	 	                    	  "field":"cityDisplay",
	 	                    	  "label":"市"
	 	                      },
	 	                      
	 	                      {
	 	                    	  "field":"ggjg",
	 	                    	  "label":"广告价格(元/单位)"
	 	                      },{
	 	                    	  "field":"ggggxs",
	 	                    	  "label":"广告规格形式"
	 	                      },
	 	                      
	 	                      {
	 	                    	  "field":"szrqDisplay",
	 	                    	  "label":"受众人群"
	 	                      },
	 	                      {
	 	                    	  "field":"jycdDisplay",
	 	                    	  "label":"教育程度"
	 	                      },
	 	                      {
	 	                    	  "field":"zyfbDisplay",
	 	                    	  "label":"职业分布"
	 	                      },
	 	                      {
	 	                    	  "field":"srzkDisplay",
	 	                    	  "label":"收入状况"
	 	                      },
	 	                      {
	 	                    	  "field":"xmtjj",
	 	                    	  "label":"新媒体简介"
	 	                      },
	 	                      {
	 	                    	  "field":"cjsj",
	 	                    	  "label":"创建时间"
	 	                      }
	 	                      ];
		
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/supplyXmtzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyXmtzyDetail/selectXmtzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form1=createStaticForm(staticXmtzyFormConfig,data.datas);
				$("#divDszyInfo").html(_form1);  
				$("#spanName").html(data.datas.name);
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
			});
		}
});
