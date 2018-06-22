/**
 * 
 */
$(document).ready(function(){
	var staticBzzyFormConfig=[
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
		                    	  "label":"报纸"
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
		var staticBzzyCurrentFormConfig=null;
		
		var staticBzzyGyygFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"lxDisplay",
			                    	  "label":"类型"
			                      },
			                     
			                      {
			                    	  "field":"ccK",
			                    	  "label":"尺寸(宽)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"ccG",
			                    	  "label":"尺寸(高)"
			                      },
				                     
			                      {
			                    	  "field":"kljg",
			                    	  "label":"刊例价格(元)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"xxjg",
			                    	  "label":"销售价格(元)"
			                      },
				                     
			                      {
			                    	  "field":"bwms",
			                    	  "label":"版位描述"
			                      },
				                     
			                      {
			                    	  "field":"ysDisplay",
			                    	  "label":"颜色"
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
		var staticBzzyRwFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"btjg",
				                    	  "label":"标题价格(元)"
				                      },
				                     
				                      {
				                    	  "field":"zwjg",
				                    	  "label":"正文价格(元)"
				                      },
				                     
				                      {
				                    	  "field":"zwzsxz",
				                    	  "label":"正文字数限制"
				                      }
				                      ];
		var staticBzzyJyFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"dyjg",
				                    	  "label":"单页价格(元/份)"
				                      }
				                      ];
		var staticBzzyExtFormConfig=[
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
			doGet(basePath+"/supplyBzzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyBzzyDetail/selectBzzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticBzzyFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);  
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
			});
		}
		
		function setDszyOtherInfo(){
			if(ggxs=="1"){
				staticBzzyCurrentFormConfig=staticBzzyGyygFormConfig;
			}else if(ggxs=="2"){
				staticBzzyCurrentFormConfig=staticBzzyGyygFormConfig;
			}else if(ggxs=="3"){
				staticBzzyCurrentFormConfig=staticBzzyRwFormConfig;
			}else if(ggxs=="4"){
				staticBzzyCurrentFormConfig=staticBzzyJyFormConfig;
			}
			doGet(basePath+"/supplyBzzyDetail/selectBzzyOtherInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticBzzyCurrentFormConfig,data.datas,2);
				$("#divDszyOtherInfo").html(_form);  
				$("#spanName").html(data.datas.name)
			});
		}
		
		function setDszyExtInfo(){
			doGet(basePath+"/supplyBzzyDetail/selectBzzyExtInfo","wid="+wid+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticBzzyExtFormConfig,data.datas,2);
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
