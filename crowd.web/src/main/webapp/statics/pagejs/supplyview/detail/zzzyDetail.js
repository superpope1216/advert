/**
 * 
 */
$(document).ready(function(){
	var staticZzzyFormConfig=[
		                      {
		                    	  "field":"areaDisplay",
		                    	  "label":"省"
		                      },
		                     
		                      {
		                    	  "field":"cityDisplay",
		                    	  "label":"市"
		                      },
		                      {
		                    	  "field":"tvIdDisplay",
		                    	  "label":"杂志"
		                      },
		                      {
		                    	  "field":"advertTypeDisplay",
		                    	  "label":"版面"
		                      },
		                      {
		                    	  "field":"cjsj",
		                    	  "label":"创建时间",
		                    	  "col":1
		                      }
		                      ];
		var staticZzzyCurrentFormConfig=null;
		
		var staticZzzyGyygFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"zk",
			                    	  "label":"折扣"
			                      }
			                      ];
		var staticBzzyXbmggFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"zk",
				                    	  "label":"折扣"
				                      }
				                      ];
		var staticZzzyRwFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"jg",
				                    	  "label":"价格(元/篇)"
				                      },
				                     
				                      {
				                    	  "field":"zk",
				                    	  "label":"折扣(折)",
				                    	  "col":1
				                      }
				                      ];
		var staticZzzyJyFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"dyjg",
				                    	  "label":"单页价格(元/份)"
				                      }
				                      ];
		var staticZzzyExtFormConfig=[
									{
										  "field":"sfxzhyDisplay",
										  "label":"行业要求"
									},
									{
										  "field":"hyDisplay",
										  "label":"具体行业"
									},
				                      {
				                    	  "field":"bcsm",
				                    	  "label":"补充说明",
				                    	  "col":1
				                      },
				                     
				                      {
				                    	  "field":"ggdlfsDisplay",
				                    	  "label":"广告代理方式",
				                    	  "col":1
				                      },{
				                    	  "field":"dlzslj",
				                    	  "label":"代理证书图片",
				                    	  "type":"img",
				                    	  "col":1
				                      },{
				                    	  "field":"sctulj",
				                    	  "label":"图片",
				                    	  "type":"img",
				                    	  "col":1
				                      }
				                     ];
		setDszyInfo();
		setDszyOtherInfo();
		setDszyExtInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/supplyZzzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyZzzyDetail/selectZzzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticZzzyFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);  
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
			});
		}
		
		function setDszyOtherInfo(){
			if(ggxs=="1"){
				staticZzzyCurrentFormConfig=staticZzzyGyygFormConfig;
			}else if(ggxs=="2"){
				staticZzzyCurrentFormConfig=staticZzzyRwFormConfig;
			}else if(ggxs=="3"){
				staticZzzyCurrentFormConfig=staticZzzyJyFormConfig;
			}	
			doGet(basePath+"/supplyZzzyDetail/selectZzzyOtherInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticZzzyCurrentFormConfig,data.datas,2);
				$("#divDszyOtherInfo").html(_form);  
				$("#spanName").html(data.datas.name)
			});
		}
		
		function setDszyExtInfo(){
			doGet(basePath+"/supplyZzzyDetail/selectZzzyExtInfo","wid="+wid+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticZzzyExtFormConfig,data.datas,2);
			$("#divDszyExtInfo").html(_form);  
//			if(data.datas.dlzslj){
//			var imgUploader=new Uploader({id:"dlzsljDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)"});
//				imgUploader.setValue(data.datas.dlzslj);
//			}
//			if(data.datas.sctulj){
//				var imgUploader=new Uploader({id:"sctuljDiv",maxSize:1024*1024*10,propExplain:"(请上传需求文档附件)"});
//					imgUploader.setValue(data.datas.sctulj);
//				}
//			});
			});
		}
});
