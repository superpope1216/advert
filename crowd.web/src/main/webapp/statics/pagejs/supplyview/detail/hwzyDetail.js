/**
 * 
 */
$(document).ready(function(){
	var staticHwzyFormConfig1=[
								{
									  "field":"name",
									  "label":"标题",
									  "col":1
								},
								{
									  "field":"advertTypeDisplay",
									  "label":"媒体类型",
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
		                    	  "field":"xianDisplay",
		                    	  "label":"县"
		                      },
		                      {
		                    	  "field":"tvIdDisplay",
		                    	  "label":"媒体信息"
		                      },
		                      
		                      {
		                    	  "field":"qyDisplay",
		                    	  "label":"区域"
		                      },{
		                    	  "field":"xsDisplay",
		                    	  "label":"形式"
		                      },
		                      
		                      {
		                    	  "field":"mtcz",
		                    	  "label":"媒体材质"
		                      },
		                      {
		                    	  "field":"cjsj",
		                    	  "label":"创建时间"
		                      },
		                      {
		                    	  "field":"shztDisplay",
		                    	  "label":"审核状态",
		                    	  "col":1
		                      }
		                      ];
		
		var staticHwzyFormConfig2=[
									{
										  "field":"gjcll",
										  "label":"估计人流量(万人次/天 )"
									},
									{
										  "field":"gjrll",
										  "label":"估计车流量(万车次/天)",
									},
									
			                      {
			                    	  "field":"mtggK",
			                    	  "label":"户外媒体规格(宽)"
			                      },
			                      {
			                    	  "field":"mtggG",
			                    	  "label":"户外媒体规格(高)"
			                      },
			                      {
			                    	  "field":"mtggM",
			                    	  "label":"户外媒体规格(面)"
			                      },
			                      {
			                    	  "field":"mtggPfm",
			                    	  "label":"户外媒体规格(平方米)"
			                      },
			                      
			                      {
			                    	  "field":"zxjgMonth",
			                    	  "label":"执行价格(元/月)"
			                      },{
			                    	  "field":"zxjgYear",
			                    	  "label":"执行价格(元/年)"
			                      },
			                      
			                      {
			                    	  "field":"zmsjDisplay",
			                    	  "label":"照明时间",
			                    	  "col":1
			                      }
			                      ];
		var staticHwzyFormConfig3=[
									{
										  "field":"mtztDisplay",
										  "label":"媒体状态"
									},
									{
										  "field":"zxtfzqDisplay",
										  "label":"最小投放周期",
									},
									
			                      {
			                    	  "field":"zztfrq",
			                    	  "label":"最早投放时间"
			                      },
			                      {
			                    	  "field":"ssqdqr",
			                    	  "label":"所有权到期日"
			                      },
			                      {
			                    	  "field":"zxtfsl",
			                    	  "label":"最小投放数量(个)"
			                      },
			                      {
			                    	  "field":"ggsyqzk",
			                    	  "label":"广告所有权状况"
			                      },
			                      
			                      {
			                    	  "field":"hwgljj",
			                    	  "label":"户外广告简介",
			                    	  "col":1
			                      }
			                      ];
		
		setDszyInfo();
		setCompanyInfo();
		function setCompanyInfo(){
			doGet(basePath+"/supplyHwzyDetail/selectCompanyInfo","wid="+wid,function(data){
				if(data.datas){
					$("#imgCompanyLog").prop("src",basePath+'/image/preview?wid='+data.datas.gslog);
					$("#divComanyName").html(data.datas.name);
				}
			});
		}
		function setDszyInfo(){
			doGet(basePath+"/supplyHwzyDetail/selectHwzyInfo","wid="+wid+"&ggxs="+ggxs,function(data){
				var _form1=createStaticForm(staticHwzyFormConfig1,data.datas);
				$("#divHwzy1").html(_form1);
				var _form2=createStaticForm(staticHwzyFormConfig2,data.datas);
				$("#divHwzy2").html(_form2);
				var _form3=createStaticForm(staticHwzyFormConfig3,data.datas);
				$("#divHwzy3").html(_form3); 
				$("#spanAdverType").html(data.datas.advertTypeDisplay);
				$("#spanName").html(data.datas.name);
			});
		}
});
