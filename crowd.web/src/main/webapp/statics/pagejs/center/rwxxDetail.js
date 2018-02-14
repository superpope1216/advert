/**
 * 
 */
$(document).ready(function(){
	 var IE9 = (navigator.userAgent.indexOf("MSIE 9.0") > 0) ? true: false;
	//$("a").webuiPopover({title:"hello",content:"content",width:"300"}); 
	
   $("#btnOpenTb").click(function(){
	   doPost(basePath+"/rwxxDetail/doTb","rwid="+rwid,function(data){
		   $("#moadl_tbxx").modal("show");
	   });
	   
   })
   
   $("#formRbxxgl [name='tbje']").on("change",function(){
	  if($("#formRbxxgl [name='spanAllje']").size()>0){
		  $("#formRbxxgl [name='spanAllje']").html(parseInt($(this).val())+parseInt($("#formRbxxgl [name='spanPtbzje']").html()));
		  
		  
	  }
		  
   });
   
   $("#btnSaveTbxx").click(function(){
	   confirm("你确认投标吗？",function(e){
		   doPost(basePath+"/rwxxDetail/toTb",$("#formRbxxgl").serializeArray(),function(data){
			  window.location.reload(); 
		   });
	   });
   });
   $("#ulTbzxx [data-option='selectTA']").click(function(){
		  var _tbId=$(this).attr("data-key");
		  confirm("您确认选择该开发者参与需求的开发吗？",function(){
			  doPost(basePath+"/rwxxDetail/selectTb","tbid="+_tbId,function(data){
				  if(data && data.datas){
					  alert("选标成功！");
					  window.location.reload(); 
				  }
			  })
		  })
	  });
  //  queryTbzxx();
    function queryTbzxx(){
    	if($("#ulTbzxx").size()<=0){
			return;
		}
    	doGet(basePath+"/rwxxDetail/queryRwtbxx","rwid="+rwid,function(data){
    		  if(data && data.datas){
    			  var html="";
    			  for(var i=0;i<data.datas.length;i++){
    				  var _data=data.datas[i]
    				  html+='<li class=" shown offer wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">';
    				  html+='	<a href="'+basePath+'/kfzview/index?kfzid='+_data.kfzid+'" title="'+(_data.kfzNc?_data.kfzNc:_data.kfzXm)+'" target="_blank" style="padding: 2px; background: #fff;">';
    				  html+='			<article class="inner-box" style="border: 1px solid #f5f5f5;">';
    				  html+='				<figure class="image" style="margin-bottom:0px;">';
    				  html+='					<img src="'+basePath+'/statics/images/12.png" title="'+(_data.kfzNc?_data.kfzNc:_data.kfzXm)+'" alt="'+(_data.kfzNc?_data.kfzNc:_data.kfzXm)+'">';
    				  html+='					<div class="overlay-box">';
    				  html+='						<div class="date">'+(_data.kfzNc?_data.kfzNc:_data.kfzXm)+'</div>';
    				  html+='    				</div>';
    				  html+='			    </figure>';
    				  html+='               <div class="text">';
    				  html+='					<div class="desc">';
    				  html+='						<p style="overflow: auto;">';
    				  html+='						<span style="text-align: left; float: left; display: inline-block;">'+(_data.kfzNc?_data.kfzNc:_data.kfzXm)+'</span>';
    				  html+='						<span style="text-align: center; float: right; display: inline-block; width: 40px; background-color: #ddd; border: none; font-size: 12px; border-radius: 3px; cursor: pointer; display: inline-block; background-color: #65C279; color: #FFF;">'+_data.zbztDisplay+'</span>';
    				  html+='				        </p>';
    				  html+='				        <p>';
    				  html+='							<b style="text-align: center;  display: inline-block;" class="price">￥'+_data.tbje+'元</b>';
    				  html+='				        </p>';
    				  html+='					</div>';
    				  html+='					<div class="link text-center">';
    				  html+='							<a href="javascript:void(0);" data-option="selectTA" data-key="'+_data.wid+'" title="选中TA" target="_self" class="theme-btn btn-skew style-two btn-sm">选中TA</a>';
    				  html+='	                </div>';
    				  html+='                </div>';
    				  html+='			</article>';
    				  html+='	</a>';
    				  html+='</li>';
    			  }
    			  $("#ulTbzxx").html(html);
    			  $("#ulTbzxx [data-option='selectTA']").click(function(){
    				  var _tbId=$(this).attr("data-key");
    				  confirm("您确认选择该开发者参与需求的开发吗？",function(){
    					  doPost(basePath+"/rwxxDetail/selectTb","tbid="+_tbId,function(data){
    						  if(data && data.datas){
    							  alert("选标成功！");
    							  queryTbzxx();
    						  }
    					  })
    				  })
    			  });
//    			  var d= new Swiper('.groom-cut', {
//    			        wrapperClass: 'groom-cut-wraper',
//    			        slideClass: 'groom-cut-slide',
//    			        slidesPerView: IE9 ? 4 : 'auto',
//    			        autoplay: 3800,
//    			        watchSlidesProgress: true,
//    			        watchSlidesVisibility: true,
//    			        prevButton: '.groom-box .fa-chevron-left',
//    			        nextButton: '.groom-box .fa-chevron-right',
//    			        observer: true,
//    			        observeParents: true
//    			    });
//    			  $('.groom-cut img[data-original]').lazyload();
    		  }
    	   });
    }
   
    
});
