/**
 * 
 */
$(document).ready(function(){
	var staticGbzyFormConfig=[
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
		                    	  "label":"广播电台"
		                      },
		                      {
		                    	  "field":"advertTypeDisplay",
		                    	  "label":"广告形式"
		                      },
		                      {
		                    	  "field":"cjsj",
		                    	  "label":"创建时间",
		                    	  "col":1
		                      }
		                      ];
		var staticGbzyCurrentFormConfig=null;
		
		var staticGbzySdFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"gbpdBmDisplay",
			                    	  "label":"时段频道"
			                      },
			                     
			                      {
			                    	  "field":"zk",
			                    	  "label":"折扣(折)",
			                    	  "col":1
			                      }
			                      ];
		var staticGbzyQtFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                      {
				                    	  "field":"gbpdBmDisplay",
				                    	  "label":"广播频道"
				                      },
				                      {
				                    	  "field":"ztMoney",
				                    	  "label":"专题折扣(折)"
				                      }
				                      ,
				                      {
				                    	  "field":"lbMoney",
				                    	  "label":"联播折扣(折)"
				                      }
				                      ,
				                      {
				                    	  "field":"gmMoney",
				                    	  "label":"冠名折扣(折)"
				                      },
				                      {
				                    	  "field":"tyMoney",
				                    	  "label":"特约折扣(折)"
				                      },
				                      {
				                    	  "field":"zdbsMoney",
				                    	  "label":"整点报时折扣(折)",
				                    	  "col":1
				                      }
				                      ];
		
		var staticGbzyExtFormConfig=[
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
			doGet(basePath+"/supplyGbzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyGbzyDetail/selectGbzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticGbzyFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);  
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
			});
		}
		
		function setDszyOtherInfo(){
			if(ggxs=="1"){
				staticGbzyCurrentFormConfig=staticGbzySdFormConfig;
			}else if(ggxs=="2"){
				staticGbzyCurrentFormConfig=staticGbzyQtFormConfig;
			}
			doGet(basePath+"/supplyGbzyDetail/selectGbzyOtherInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticGbzyCurrentFormConfig,data.datas,2);
				$("#divDszyOtherInfo").html(_form);  
				$("#spanName").html(data.datas.name)
			});
		}
		
		function setDszyExtInfo(){
			doGet(basePath+"/supplyGbzyDetail/selectGbzyExtInfo","wid="+wid+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticGbzyExtFormConfig,data.datas,2);
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
