/*
 * M['weburl'] 		//网站网址
 * M['lang']  		//网站语言
 * M['tem']  		//模板目录路径
 * M['classnow']  	//当前栏目ID
 * M['id']  		//当前页面ID
 * M['module']  	//当前页面所属模块
 * lazyloadbg       //系统调用的延迟加载背景图片路径,base64：灰色
 * deviceType       //客户端判断（d：桌面电脑，t：平板电脑，m：手机）
*/
$(document).ready(function() {
	var isMobile=$('html').hasClass('isMobile')?true:false;
	var IE9=(navigator.userAgent.indexOf("MSIE 9.0")>0)?true:false;
	
	if($('#map').length>0){
		var script = document.createElement("script"),
			coordinate = $('#map').attr('coordinate')||'105,25';
		script.src = "//api.map.baidu.com/api?v=2.0&ak=aL2Gwp389Kxj3bFhSMq7cf9w&callback=map_func";
		document.body.appendChild(script);
		map_func = function(){
			var coo = coordinate&&coordinate.split(',');
			var map = new BMap.Map("map");
			map.centerAndZoom(new BMap.Point(coo[0]*1,coo[1]*1), 19);
			map.enableScrollWheelZoom();  
			var Icon = new BMap.Icon(M['tem']+"/min/svg/point.svg\" class=\"point_svg", new BMap.Size(28,56));
			var marker = new BMap.Marker(new BMap.Point(coo[0]*1,coo[1]*1),{icon:Icon});
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); 
			map.addOverlay(marker);
		}	
	}

	var win_width=$(window).width();
	if($('.advert-box').length){
		if(!$('.advert-box').hasClass('auto')){
			var data_height=$('.advert-box').attr('data-height')||'120|100|80';
			resize_height($('.advert-box'),data_height.split('|'));
		}
		$('.advert-box img[data-original]').lazyload();
	}
	function resize_height(obj,arr,res){
		if(win_width>=1200) obj.height(arr[0]||120);
		else if(win_width>=768) obj.height(arr[1]||100);
		else obj.height(arr[2]||80);
		if(!res) $(window).resize(function(){ 
			win_width=$(window).width();
			resize_height(obj,arr,true); 
		});
	}
	function head_width(res){
		$('.head-left').css('max-width',$('.head-box .container').width()-$('.head-right').width());
		if(!res) $(window).resize(function(){ 
			win_width=$(window).width();
			head_width(true); 
		});
	}
	head_width();
	M['head']=new Swiper('.head-left',{ 
		wrapperClass: 'head-left-wrapper',
		slideClass: 'head-left-slide',
		slidesPerView : 'auto',
		freeMode : true,
		freeModeSticky : true,
		mousewheelControl: true,
		mousewheelSensitivity: 1,
		observer:true,
		observeParents:true
	});
	
	function nav_width_fun(res){
		nav_width=0;
		$('.nav-cut ul li').each(function(index, element) {
			nav_width+=$(this).outerWidth();
		});
		if(win_width>460){
			neck_width=$('.neck-box .container').width()-
						$('.logo-box').width()-
						$('.search-box').width()-
						$('.nav-class').width()-
						$('.nav-box').css('margin-left').replace('px','')-
						$('.nav-box').css('margin-right').replace('px','')-1;
			$('.nav-cut').css('max-width',nav_width>neck_width?neck_width:nav_width);
		}else{
			neck_width=$('.neck-box .container').width()-
						$('.nav-class').width()-
						$('.nav-box').css('margin-left').replace('px','')-
						$('.nav-box').css('margin-right').replace('px','')-1;
			$('.nav-cut').css('max-width',nav_width>neck_width?neck_width:nav_width);
			$('.logo-box').css('max-width',$('.neck-box .container').width()-$('.search-box').width()-15);
		}
		$('.nav-hover').css('left',$('.nav-class').css('display')=='block'?$('.nav-class').width():0);
		if(!res) $(window).resize(function(){ 
			clearTimeout(M['nav_width']);
			M['nav_width']=window.setTimeout(function(){
				nav_width_fun(true);
			},1);
		});
	}
	nav_width_fun();
	
	var logo=new Image();
	logo.src=$('.logo-box img').attr('src');
	logo.onload=function(){
		nav_width_fun(true);
	}
	
	new Swiper('.nav-cut',{
		initialSlide : $('.nav-li.active').index(),
		wrapperClass : 'nav-ul',
		slideClass : 'nav-li',
		freeMode : true,
		freeModeMomentumRatio : .1,
		freeModeSticky : true,
		freeModeSticky : true,
		slidesPerView : 'auto',
		mousewheelControl: true,
		observer : true,
		observeParents : true,
		onTouchStart : function(swiper,even){
			$('.nav-hover ul').removeClass('active');
		}
	});
	if($('.nav-hover').length>0){
		var navtime='';
		$('.nav-li').mouseover(function(){
			if(win_width>=1200||!isMobile){
				clearTimeout(navtime);
				var nowleft=$(this).position().left;
				var navul=$('.nav-hover ul').removeClass('active').eq($(this).index());
				navul.css('left',nowleft-(navul.width()-$(this).width())/2).addClass('active');
				if(nowleft>win_width/2&&win_width<768) navul.addClass('right'); else navul.removeClass('right');
			}
		}).click(function(){
			if(win_width<1200&&isMobile){
				clearTimeout(navtime);
				var nowleft=$(this).position().left;
				var navul=$('.nav-hover ul').removeClass('active').eq($(this).index());
				navul.css('left',nowleft-(navul.width()-$(this).width())/2).addClass('active');
				if(nowleft>win_width/2&&win_width<768) navul.addClass('right'); else navul.removeClass('right');
			}
		});
		$('.nav-cut,.nav-hover').mouseleave(function(){
			clearTimeout(navtime);
			navtime=window.setTimeout(function(){
				$('.nav-hover ul').removeClass('active');
			},200);
		});
		$('.nav-hover').find('ol,ul').each(function(index, element) {
            if(!$(this).find('li').length) $(this).css('opacity','0');
        });
		$('.nav-hover ul').mouseenter(function(){
			clearTimeout(navtime);
		});
		$('.nav-li a').click(function(e){
			if(win_width<1200&&isMobile&&$(this).parent().hasClass('navs')){
				e.preventDefault();
			}
		});
		$('.nav-hover ol').prev('a').click(function(e){
			if(win_width<1200&&isMobile){
				e.preventDefault();
			}
		});
		$(window).resize(function(){
			$('.nav-hover ul').removeClass('active');
		});
	}
	
	
	if($('.search-box').length){
		if($('.search-box input[type=text]').val()!='') $('.search-box').addClass('active');
		$('.search-box input[type=text]').focus(function(){
			if($(this).val()=='') $('.search-box').addClass('active');
		}).blur(function(){
			if($(this).val()=='') $('.search-box').removeClass('active');
		});
	}
	
	
	
	
	
	M['class']=new Swiper('.product-class',{ 
		wrapperClass: 'product-class-wrapper',
		slideClass: 'product-class-slide',
		slidesPerView : 'auto',
		direction : 'vertical', 
		freeMode : true, 
		mousewheelControl: true,
		mousewheelSensitivity: 1,
		observer:true,
		observeParents:true
	});
	$('.product-class-slide').mouseover(function(){
		that=$(this);
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){
			$('.product-class-slide').removeClass('active');
			that.addClass('active');
			$('.product-list').removeClass('active');
			$('.product-list').eq(that.index()).addClass('active').find('[data-original]').lazyload({
				load: function(){
					$(this).removeAttr('data-original');
				}
			});
		},10);
	});
	$('.product-class').mouseout(function(){
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){
			$('.product-class-slide').removeClass('active');
			$('.product-list').removeClass('active');
		},10);
	});
	$('.product-list').mouseover(function(){
		clearTimeout(M['pro_class']);
	}).mouseout(function(){
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){
			$('.product-list').removeClass('active');
		},10);
	});
	$('.product-cut').mouseout(function(){
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){
			$('.nav-class').removeClass('active');
			$('.product-cut').removeClass('active');
			$('.product-class-slide').removeClass('active');
			$('.product-list').removeClass('active');
		},10);
	});
	
	
	$('.nav-class').mouseover(function(){
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){ 
			$('.nav-class').addClass('active');
			$('.product-cut').addClass('active');
		},10);
	}).mouseout(function(){
		clearTimeout(M['pro_class']);
		M['pro_class']=window.setTimeout(function(){
			$('.nav-class').removeClass('active');
			$('.product-cut').removeClass('active');
		},500);
	});
	$(window).resize(function(){
		$('.nav-class').removeClass('active');
		$('.product-cut').removeClass('active');
		$('.product-class-slide').removeClass('active');
		$('.product-list').removeClass('active');
	});
	
	
	
	
	
	$('.product-ul').each(function(index, element) {
		var pro_all=$(this).find('.product-li').html();
		M['pro_all'+index]=pro_all?pro_all.split('　'):[];
	});
	function pro_html_fun(mun){
		$('.product-ul').each(function(index, element) {
			pro_all_num=M['pro_all'+index].length;
			if(pro_all_num!=0){
				pro_html='<li class="product-li">';
				for(i=0;i<pro_all_num;i++){
					pro_html+=M['pro_all'+index][i].replace('data-style','style');
					if((i+1)%mun==0&&i&&M['pro_all'+index][i+1])
						pro_html+='</li>\n<li class="product-li">';
				}
				pro_html+='</li>';
				$(this).html(pro_html);
			}else{
				$(this).parent('.product-list').hide();
			}
		});
	}	
	function pro_fun(res){
		pro_cut_hgt=$('.product-class').outerHeight();
		$('.product-content').height(pro_cut_hgt);
		pro_num=Math.floor( pro_cut_hgt/(win_width>=768?70:60) );
		pro_pad=Math.floor((pro_cut_hgt/pro_num-40)/2);
		pro_html_fun(pro_num);
		var pro_width=$('.product-cut').width()-$('.product-class').outerWidth()-1;
		if(win_width>=1200) pro_con=4;
		else if(win_width>=992) pro_con=3;
		else if(win_width>=460) pro_con=2;
		else pro_con=1;
		pro_list_width=pro_width/pro_con;
		$('.product-li').width(pro_list_width);
		$('.product-list').each(function(index, element) {
			var pro_len=Math.ceil(M['pro_all'+index].length/pro_num);
			$(this).width((pro_len<=pro_con?pro_len:pro_con)*pro_list_width);
		});
		$('.product-list a').css('padding-top',pro_pad).css('padding-bottom',pro_pad);
		if(!res) $(window).resize(function(){
			clearTimeout( M['pro_time'] );
			M['pro_time'] = window.setTimeout(function(){
				pro_fun(true);
			},300);
		});
	}
	pro_fun();
	M['pro_list']=new Swiper('.product-list',{
		wrapperClass: 'product-ul',
		slideClass: 'product-li',
		slidesPerView: 'auto',
		lazyLoading : true,
		freeMode : true, 
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		mousewheelControl: true,
		mousewheelSensitivity: 1,
		observer:true,
		observeParents:true
	});
	
	
	function active_fun(res){
		if(win_width>=460) $('.active-box').width($('.acromion-box .container').width()-$('.column-box').width());
		else $('.active-box').width('auto');
		if(!res) $(window).resize(function(){  
			active_fun(true); 
		});
	}
	active_fun();
	M['active']=new Swiper('.active-box',{
		wrapperClass: 'active-box-wraper',
		slideClass: 'active-box-slide',
		slidesPerView: IE9?3:'auto',
		autoplay : 3500,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		observer:true,
		observeParents:true
	});
	$('.active-box img[data-original]').lazyload({
		load:function(){
			active_fun();
		}
	});	
		
	
	M['groom']=new Swiper('.groom-cut',{
		wrapperClass: 'groom-cut-wraper',
		slideClass: 'groom-cut-slide',
		slidesPerView: IE9?5:'auto',
		autoplay : 3800,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		prevButton:'.groom-box .fa-chevron-left',
		nextButton:'.groom-box .fa-chevron-right',
		observer:true,
		observeParents:true
	});
	$('.groom-cut img[data-original]').lazyload();
		
		
	$('.host-adver [data-original]').lazyload();	
	
	$('.host-box').each(function(index,element){
        $('.host-box:eq('+index+') .host-title li').click(function(e){
			e.preventDefault();
			$('.host-box:eq('+index+') .host-title li').removeClass('active');
			$(this).addClass('active');
			$('.host-box:eq('+index+') .host-list')
				.removeClass('active')
				.eq($(this).index()).addClass('active')
				.find('img[data-original]').lazyload();
		});
    });
	
	M['host']=new Swiper('.host-list.index',{
		wrapperClass: 'host-list-wraper',
		slideClass: 'host-list-slide',
		slidesPerView: 4,
		slidesPerColumn : 2,
		slidesPerColumnFill : 'row',
		autoplay : 2500,
		lazyLoading : true,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		observer:true,
		observeParents:true,
		breakpoints: { 
			1199: { slidesPerView:3, slidesPerColumn:2 },
			992: { slidesPerView:2, slidesPerColumn:2 },
			640: { slidesPerView:2, slidesPerColumn:1 }
		}
	});
	 
	
	$('.host-list.active [data-original]').each(function(index, element) {
        $(this).lazyload();
    }); 
	
	$('.host-list dd').mouseover(function(){
		$(this).parent('dl').find('dd').removeClass('active');
		$(this).addClass('active')
		$(this).parents('li').find('img').attr('src',$(this).attr('src'));
	});
	
	
	M['info']=new Swiper('.info-cut.index',{
		wrapperClass: 'info-cut-wraper',
		slideClass: 'info-cut-slide',
		slidesPerView: IE9?4:'auto',
		lazyLoading : true,
		autoplay: 4000,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		prevButton:'.info-box .fa-chevron-left',
		nextButton:'.info-box .fa-chevron-right',
		observer:true,
		observeParents:true
	});
	$('.info-cut img[data-original]').lazyload();
	
	
	M['foot_service']=new Swiper('.foot-service',{
		wrapperClass: 'foot-service-wraper',
		slideClass: 'foot-service-slide',
		slidesPerView: IE9?5:'auto',
		autoplay: 2900,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		observer:true,
		observeParents:true
	});
	
	
	M['foot_nav']=new Swiper('.foot-nav',{
		wrapperClass: 'foot-nav-wraper',
		slideClass: 'foot-nav-slide',
		slidesPerView: IE9?6:'auto',
		autoplay: 3010,
		watchSlidesProgress : true,
		watchSlidesVisibility : true,
		observer:true,
		observeParents:true
	});
	
	
	
	new Swiper('.column-nav',{
		initialSlide : $('.column-li.active').index(),
		wrapperClass : 'column-ul',
		slideClass : 'column-li',
		freeMode : true,
		slidesPerView : 'auto',
		freeModeSticky : true,
		onReachEnd: function(swiper){
			$('.column-nav').addClass('active');
		},
		onTouchStart : function(swiper,even){
			$('.column-hover ul').removeClass('active');
		}
	});
	if($('.column-hover').length>0){
		var navtime='';
		$('.column-li').mouseover(function(){
			if(win_width>=1200||!isMobile){
				clearTimeout(navtime);
				var nowleft=$(this).position().left;
				var navul=$('.column-hover ul').removeClass('active').eq($(this).index());
				navul.css('left',nowleft-(navul.width()-$(this).width())/2).addClass('active');
			}
		}).click(function(){
			if(win_width<1200&&isMobile){
				clearTimeout(navtime);
				var nowleft=$(this).position().left;
				var navul=$('.column-hover ul').removeClass('active').eq($(this).index());
				navul.css('left',nowleft-(navul.width()-$(this).width())/2).addClass('active');
			}
		});
		$('.column-side').mouseleave(function(){
			clearTimeout(navtime);
			navtime=window.setTimeout(function(){
				$('.column-hover ul').removeClass('active');
			},200);
		});
		$('.column-hover ul').mouseenter(function(){
			clearTimeout(navtime);
		});
		$('.column-li a').click(function(e){
			if(win_width<1200&&isMobile&&$(this).parent().hasClass('navs')){
				e.preventDefault();
			}
		});
	}
	
	
		
		
    if(M['classnow']==10001){
		
		
		
		
		
		
        // 图片懒加载
        var $index_original=$('.met-index-body [data-original]');
        if($index_original.length){
            $index_original.lazyload({
                load:function(){
                    if($(this).parents('.met-index-service').length) $('.met-index-service [class*=block] li').matchHeight();
                }
            });
        }

        // 首页首屏内动画预加载
        var $met_indexbody1_appear=$('.met-index-body:eq(0) [data-plugin=appear]');
        if($met_indexbody1_appear.length){
            $met_indexbody1_appear.scrollFun(function(val){
                val.appearDiy();
            });
        }

        // 产品列表
        if($(".met-index-product").length){
            //内滚导航条（移动端）
            Breakpoints.on('xs sm',{
                enter: function(){
                    navtabSwiper('.met-index-product .nav-tabs');
                }
            })
            var problock='.met-index-product #indexprolist',
                protab='.met-index-product .nav-tabs li';
            //图片高度预设
            imageSize(problock);
            //分类筛选动画
            IsotopeNum(problock,protab);
        }

        // 新闻列表
        // 图片高度预设
        if($('.met-index-news ul.blocks-2').length) imageSize('.met-index-news ul.blocks-2');
    }
})
// 分类筛选动画(可控制默认选项对应的显示数量)
function IsotopeNum(itObj,itControl) {
    var itFun=$(itObj).isotope(),
    	intItControlAttr=$(itControl+'.active a').data('filter');
    $(itControl).on('click', 'a', function() {
        var filterValue = $(this).data('filter'),
            filterValues=filterValue=='*'?'[data-type]':'[data-type='+filterValue+']',
            num=$(this).data('num');
        if(num) filterValues=function(){return $(this).index() < num;} || filterValues;
        itFun.isotope({filter:filterValues});
        if(filterValue!=intItControlAttr){
            $(filterValues+' [data-original]').each(function() {
                if($(this).data('original')!=$(this).attr('src'))
                $(this).lazyload({event:'sporty'}).trigger('sporty');
            });
        }
    });
    // 触发默认选项点击效果
    if($(itControl+'.active a').data('num')){
        setTimeout(function () {
            $(itControl+'.active a').trigger('click');
        },500);
    }
}


$(window).load(function(){
	$('.load-box').addClass('active');
});