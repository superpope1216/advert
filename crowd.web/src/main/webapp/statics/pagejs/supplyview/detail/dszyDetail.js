/**
 * 
 */
$(document).ready(function(){
	var staticDszyFormConfig=[
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
		var staticDszyCurrentFormConfig=null;
		
		var staticDszySdFormConfig=[
			                      {
			                    	  "field":"name",
			                    	  "label":"资源名称"
			                      },
			                     
			                      {
			                    	  "field":"tvPdDisplay",
			                    	  "label":"时段频道"
			                      },
			                     
			                      {
			                    	  "field":"hjsdZk",
			                    	  "label":"黄金时段折扣(折)"
			                      }
			                      ,
				                     
			                      {
			                    	  "field":"fhjsdZk",
			                    	  "label":"非黄金时段折扣(折)"
			                      }
			                      ];
		var staticDszySdPriceConfig={
				"field":"hjsdZk",
				"label":"非黄金时段折扣(折)"
		}
		var staticDszyLmFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"pdIdDisplay",
				                    	  "label":"栏目频道"
				                      },
				                      {
				                    	  "field":"dllmDisplay",
				                    	  "label":"代理栏目"
				                      },
				                      {
				                    	  "field":"qscZk",
				                    	  "label":"全时长折扣(折)"
				                      },
				                      {
				                    	  "field":"fiveZk",
				                    	  "label":"5秒(折)"
				                      },
				                      {
				                    	  "field":"tenZk",
				                    	  "label":"10秒(折)"
				                      },			                     
				                      {
				                    	  "field":"fiveteenZk",
				                    	  "label":"15秒(折)"
				                      },			                     
				                      {
				                    	  "field":"twentyZk",
				                    	  "label":"20秒(折)"
				                      },
				                      {
				                    	  "field":"thirtyZk",
				                    	  "label":"30秒(折)",
				                    	  "col":1
				                    		  
				                      }
				                      ];
		var staticDszyTbFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"bhpdDisplay",
				                    	  "label":"频道"
				                      },
				                     
				                      {
				                    	  "field":"bcsmBmDisplay",
				                    	  "label":"播出频率"
				                      },
				                     
				                      {
				                    	  "field":"fiveMoney",
				                    	  "label":"套播价格5秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"seventMoney",
				                    	  "label":"套播价格7.5秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"tenMoney",
				                    	  "label":"套播价格10秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"fifteenMoney",
				                    	  "label":"套播价格15秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"twentyMoney",
				                    	  "label":"套播价格20秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"twentyFiveMoney",
				                    	  "label":"套播价格25秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"thirtyMoney",
				                    	  "label":"套播价格30秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"fortyFiveMoney",
				                    	  "label":"套播价格45秒(元)"
				                      }
				                      ,
					                     
				                      {
				                    	  "field":"sixtyMoney",
				                    	  "label":"套播价格60秒(元)"
				                      }
				                      ];
		var staticDszyZtFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"ztpdBmDisplay",
				                    	  "label":"专题频道"
				                      },
				                     
				                      {
				                    	  "field":"sjdBmDisplay",
				                    	  "label":"时间段"
				                      },
				                     
				                      {
				                    	  "field":"bcsc",
				                    	  "label":"播出时长(分钟)"
				                      },
				                     
				                      {
				                    	  "field":"ggjg",
				                    	  "label":"广告价格(元/分钟)",
				                    	  "col":1
				                      }
				                      ];
		
		var staticDszyGmFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"sspdBmDisplay",
				                    	  "label":"所属频道"
				                      },
				                     
				                      {
				                    	  "field":"sslmBmDisplay",
				                    	  "label":"所属栏目"
				                      },
				                     
				                      {
				                    	  "field":"bcpc",
				                    	  "label":"播出频次(次/月)"
				                      },
				                     
				                      {
				                    	  "fields":[
				                    	            {"field":"ggjgBmDisplay"},
				                    	            {"field":"ggjgMoney"},
				                    	            ],
				                    	  "label":"广告价格(元)",
				                    	  "col":1
				                      }
				                      ];
		
		var staticDszyZzFormConfig=[
				                      {
				                    	  "field":"name",
				                    	  "label":"资源名称"
				                      },
				                     
				                      {
				                    	  "field":"sspdBmDisplay",
				                    	  "label":"所属频道"
				                      },
				                     
				                      {
				                    	  "field":"sslmBmDisplay",
				                    	  "label":"所属栏目"
				                      },
				                     
				                      {
				                    	  "field":"bcpc",
				                    	  "label":"播出频次(次/月)"
				                      },
				                     
				                      {
				                    	  "fields":[
				                    	            {"field":"ggjgBmDisplay"},
				                    	            {"field":"ggjgMoney"},
				                    	            ],
				                    	  "label":"广告价格(元)",
				                    	  "col":1
				                      }
				                      ];
		var staticDszyExtFormConfig=[
									{
										  "field":"sfxzhy",
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
			doGet(basePath+"/supplyDszyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyDszyDetail/selectDszyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticDszyFormConfig,data.datas,2);
				$("#divDszyInfo").html(_form);  
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
			});
		}
		
		function setDszyOtherInfo(){
			if(ggxs=="1"){
				staticDszyCurrentFormConfig=staticDszySdFormConfig;
			}else if(ggxs=="2"){
				staticDszyCurrentFormConfig=staticDszyLmFormConfig;
			}else if(ggxs=="3"){
				staticDszyCurrentFormConfig=staticDszyTbFormConfig;
			}else if(ggxs=="4"){
				staticDszyCurrentFormConfig=staticDszyZtFormConfig;
			}else if(ggxs=="5"){
				staticDszyCurrentFormConfig=staticDszyGmFormConfig;
			}
			else if(ggxs=="6"){
				staticDszyCurrentFormConfig=staticDszyZzFormConfig;
			}
			doGet(basePath+"/supplyDszyDetail/selectDszyOtherInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form=createStaticForm(staticDszyCurrentFormConfig,data.datas,2);
				$("#divDszyOtherInfo").html(_form);  
				$("#spanName").html(data.datas.name)
			});
		}
		
		function setDszyExtInfo(){
			doGet(basePath+"/supplyDszyDetail/selectDszyExtInfo","wid="+wid+"&ggxs="+ggxs,function(data){
			var _form=createStaticForm(staticDszyExtFormConfig,data.datas,2);
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
