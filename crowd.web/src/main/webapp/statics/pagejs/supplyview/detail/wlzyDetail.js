/**
 * 
 */
$(document).ready(function(){
	var staticWlzyFormConfig=[
		                      {
		                    	  "field":"addr",
		                    	  "label":"网站地址"
		                      },
		                     
		                      {
		                    	  "field":"name",
		                    	  "label":"资源名称"
		                      },
		                      {
		                    	  "field":"ggwzDisplay",
		                    	  "label":"广告位置"
		                      },
		                      {
		                    	  "field":"wzms",
		                    	  "label":"位置描述"
		                      },
		                      {
		                    	  
		                    	  "fields":[{
		                    		"field":"zsxtDisplay"  
		                    	  },{"field":"zsfsDisplay"}],
		                    	  "label":"展示形态"
		                      },
		                      {
		                    	  "field":"zsccDisplay",
		                    	  "label":"尺寸"
		                      },{
		                    	  "field":"jffsDisplay",
		                    	  "label":"计费方式"
		                      },
		                      {
		                    	  "field":"cjsj",
		                    	  "label":"创建时间"
		                      }
		                      ];
		var staticWlzyCurrentFormConfig=null;
		
		var staticWlzyScjfFormConfig=[
			                      {
			                    	  "field":"hourKlj",
			                    	  "label":"刊例价(元/小时)"
			                      },
			                     
			                      {
			                    	  "field":"hourXsj",
			                    	  "label":"销售价(元/小时)"
			                      },
			                      {
			                    	  "field":"dayKlj",
			                    	  "label":"刊例价(元/天)"
			                      },
			                     
			                      {
			                    	  "field":"dayXsj",
			                    	  "label":"销售价(元/天)"
			                      },
			                      {
			                    	  "field":"weekKlj",
			                    	  "label":"刊例价(元/周)"
			                      },
			                     
			                      {
			                    	  "field":"weekXsj",
			                    	  "label":"销售价(元/周)"
			                      },
			                      {
			                    	  "field":"halfMonthKlj",
			                    	  "label":"刊例价(元/半月)"
			                      },
			                     
			                      {
			                    	  "field":"halfMonthXsj",
			                    	  "label":"销售价(元/半月)"
			                      },
			                      {
			                    	  "field":"monthKlj",
			                    	  "label":"刊例价(元/月)"
			                      },
			                     
			                      {
			                    	  "field":"monthXsj",
			                    	  "label":"销售价(元/月)"
			                      },
			                      {
			                    	  "field":"jdKlj",
			                    	  "label":"刊例价(元/季度)"
			                      },
			                     
			                      {
			                    	  "field":"jdXsj",
			                    	  "label":"销售价(元/季度)"
			                      },
			                      {
			                    	  "field":"halfYearKlj",
			                    	  "label":"刊例价(元/半年)"
			                      },
			                     
			                      {
			                    	  "field":"halfYeafXsj",
			                    	  "label":"销售价(元/半年)"
			                      },
			                      {
			                    	  "field":"yearKlj",
			                    	  "label":"刊例价(元/年)"
			                      },
			                     
			                      {
			                    	  "field":"yeafXsj",
			                    	  "label":"销售价(元/年)"
			                      }
			                      ];
		var staticWlzyCpmFormConfig=[
				                      {
				                    	  "field":"cpmKlj",
				                    	  "label":"刊例价(每千次展示)"
				                      },
				                     
				                      {
				                    	  "field":"cpmXsj",
				                    	  "label":"销售价(每千次展示)"
				                      }
				                      ];
		var staticWlzyCpcFormConfig=[
				                      {
				                    	  "field":"cpcKlj",
				                    	  "label":"刊例价(每有效点击)"
				                      },
				                     
				                      {
				                    	  "field":"cpcXsj",
				                    	  "label":"销售价(每有效点击)"
				                      }
				                      ];
		
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/supplyWlzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyWlzyDetail/selectWlzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form1=createStaticForm(staticWlzyFormConfig,data.datas);
				$("#divWlzy").html(_form1);
				$("#spanName").html(data.datas.name);
				$("#spanAdverType").html(data.datas.ggwzDisplay);
				if(data.datas.jffs){
					if(data.datas.jffs=="1"){
						var _form2=createStaticForm(staticWlzyScjfFormConfig,data.datas);
						$("#divWlzyjffx").html(_form2);
					}else if(data.datas.jffs=="2"){
						var _form2=createStaticForm(staticWlzyCpmFormConfig,data.datas);
						$("#divWlzyjffx").html(_form2);
					}else if(data.datas.jffs=="3"){
						var _form2=createStaticForm(staticWlzyCpcFormConfig,data.datas);
						$("#divWlzyjffx").html(_form2);
					}
				}
				  
			});
		}
		
		
});
